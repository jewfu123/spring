package org.keycloak.userstorage;


import org.apache.ibatis.session.SqlSession;
import org.keycloak.component.ComponentModel;
import org.keycloak.credential.CredentialInput;
import org.keycloak.credential.CredentialInputUpdater;
import org.keycloak.credential.CredentialInputValidator;

import org.keycloak.models.GroupModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.RoleModel;
import org.keycloak.models.UserCredentialModel;
import org.keycloak.models.UserModel;
import org.keycloak.models.credential.PasswordCredentialModel;
import org.keycloak.storage.StorageId;
import org.keycloak.storage.UserStorageProvider;
import org.keycloak.storage.user.UserLookupProvider;
import org.keycloak.storage.user.UserQueryProvider;
import org.keycloak.storage.user.UserRegistrationProvider;
import org.keycloak.userstorage.domain.UserEntity;
import org.keycloak.userstorage.mapper.UserMapper;
import org.keycloak.userstorage.util.MD5Util;
import org.keycloak.userstorage.util.MybatisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * keycloak用户连接器
 * UserStorageProvider	自定义的StorageProvider必须要实现的接口
 * UserLookupProvider	实现后，可以从keycloak进行登录
 * UserRegistrationProvider	实现后，可以往自己数据库中增加删除修改用户数据
 * CredentialInputUpdater	实现后，可以更新密码
 * CredentialInputValidator	验证密码的逻辑
 * UserQueryProvider	从自己数据库中查询用户
 */
public class CustomUserStorageProvider implements
        UserStorageProvider,
        UserRegistrationProvider,
        UserLookupProvider,
        UserQueryProvider,
        CredentialInputUpdater,
        CredentialInputValidator {

    private final Logger logger = LoggerFactory.getLogger(CustomUserStorageProvider.class);

    private final KeycloakSession session;
    private final ComponentModel model;


    public CustomUserStorageProvider(KeycloakSession session, ComponentModel model) {
        this.session = session;
        this.model = model;
    }

    @Override
    public boolean supportsCredentialType(String credentialType) {
        return PasswordCredentialModel.TYPE.equals(credentialType);
    }

    @Override
    public boolean isConfiguredFor(RealmModel realm, UserModel user, String credentialType) {
        return supportsCredentialType(credentialType);
    }

    // 登陆验证
    @Override
    public boolean isValid(RealmModel realm, UserModel user, CredentialInput input) {
        if (!supportsCredentialType(input.getType()) || !(input instanceof UserCredentialModel)) {
            return false;
        }
        UserCredentialModel cred = (UserCredentialModel) input;
        // 用户名密码
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            UserEntity userEntity = mapper.selectByLoginNameOrEmail(user.getUsername());
            if (userEntity == null) {
                logger.info("User {} not exist: " , user.getUsername());
                return false;
            }

            String encryptedPassword = MD5Util.encrypt(userEntity.getLoginName() + cred.getChallengeResponse() + userEntity.getSalt());
//            String encryptedPassword = AuthenticateUtil.getEncryptedPassword(cred.getChallengeResponse(), userEntity.getSalt());
            return userEntity.getPassword().equalsIgnoreCase(encryptedPassword);
        } catch (Exception e) {
            logger.error("login error", e);
            return false;
        }

    }

    // 更新凭据
    @Override
    public boolean updateCredential(RealmModel realm, UserModel user, CredentialInput input) {
        // TODO
//        if (!supportsCredentialType(input.getType()) || !(input instanceof UserCredentialModel)) {
//            return false;
//        }
//        UserCredentialModel cred = (UserCredentialModel) input;
//        return repository.updateCredentials(user.getUsername(), cred.getChallengeResponse());
        return true;
    }

    @Override
    public Set<String> getDisableableCredentialTypes(RealmModel realm, UserModel user) {
        return Collections.emptySet();
    }

    @Override
    public void disableCredentialType(RealmModel realm, UserModel user, String credentialType) {
    }

    @Override
    public void preRemove(RealmModel realm) {
    }

    @Override
    public void preRemove(RealmModel realm, GroupModel group) {
    }

    @Override
    public void preRemove(RealmModel realm, RoleModel role) {
    }

    @Override
    public void close() {
    }

    @Override
    public UserModel getUserById(String id, RealmModel realm) {
        String externalId = StorageId.externalId(id);
        logger.info("Get user by userId(userId of keycloak:{} , userId of external:{} ): ", id, externalId);
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            UserEntity userEntity = mapper.selectById(externalId);
            return new UserAdapter(session, realm, model, userEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UserModel getUserByUsername(String username, RealmModel realm) {
        logger.info("Get User By Username: {}" , username);
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            UserEntity userEntity = mapper.selectByLoginNameOrEmail(username);
            if (userEntity == null) {
                logger.info("User {} not exist: " , username);
                return null;
            }
            return new UserAdapter(session, realm, model, userEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    @Override
    public UserModel getUserByEmail(String email, RealmModel realm) {
        // TODO
        return getUserByUsername(email, realm);
    }

    @Override
    public int getUsersCount(RealmModel realm) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            return mapper.count();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<UserModel> getUsers(RealmModel realm) {
        logger.info("Get All User ");
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<UserEntity> userEntities = mapper.selectList("");
            return userEntities.stream()
                    .map(user -> new UserAdapter(session, realm, model, user))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<UserModel> getUsers(RealmModel realm, int firstResult, int maxResults) {
        logger.info("Get Page User ");
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<UserEntity> userEntities = mapper.selectPage("", firstResult, maxResults);
            return userEntities.stream()
                    .map(user -> new UserAdapter(session, realm, model, user))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<UserModel> searchForUser(String search, RealmModel realm) {
        logger.info("searchForUser : {} ", search);
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<UserEntity> userEntities = mapper.selectList(search);
            return userEntities.stream()
                    .map(user -> new UserAdapter(session, realm, model, user))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<UserModel> searchForUser(String search, RealmModel realm, int firstResult, int maxResults) {
        logger.info("分页条件查询:search:{},firstResult:{},maxResults:{}", search,firstResult, maxResults);
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<UserEntity> userEntities = mapper.selectPage(search, firstResult, maxResults);
            return userEntities.stream()
                    .map(user -> new UserAdapter(session, realm, model, user))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<UserModel> searchForUser(Map<String, String> params, RealmModel realm) {
        // TODO
        return getUsers(realm);
    }

    @Override
    public List<UserModel> searchForUser(Map<String, String> params, RealmModel realm, int firstResult, int maxResults) {
        // TODO
        return getUsers(realm);
    }

    @Override
    public List<UserModel> getGroupMembers(RealmModel realm, GroupModel group, int firstResult, int maxResults) {
        // TODO
        return getUsers(realm);
    }

    @Override
    public List<UserModel> getGroupMembers(RealmModel realm, GroupModel group) {
        // TODO
        return getUsers(realm);
    }

    @Override
    public List<UserModel> searchForUserByUserAttribute(String attrName, String attrValue, RealmModel realm) {
        // TODO
        return getUsers(realm);
    }

    @Override
    public UserModel addUser(RealmModel realm, String username) {
//        logger.info("Add user: " + username);
//        UserEntity user = new UserEntity();
//        user.setLoginName(username);
//        user = repository.createUser(user);
//        return new UserAdapter(session, realm, model, user);
        return null;
    }

    @Override
    public boolean removeUser(RealmModel realm, UserModel user) {
        // TODO
//        logger.info("Remove user, userId(userId of keycloak): " + user.getId() + ", " + user.getUsername());
//        logger.info("Remove user, userId(userId of external): " + StorageId.externalId(user.getId()));
//        UserEntity u = repository.findUserById(StorageId.externalId(user.getId()));
//        if(u == null) {
//            logger.info("User does not exist, userId(userId of keycloak): " + user.getId());
//            return false;
//        }
//        repository.deleteUser(u.getUserId());
        return true;
    }


}
