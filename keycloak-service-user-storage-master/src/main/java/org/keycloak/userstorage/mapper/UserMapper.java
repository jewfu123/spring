package org.keycloak.userstorage.mapper;

import org.apache.ibatis.annotations.Param;
import org.keycloak.userstorage.domain.UserEntity;

import java.util.List;

public interface UserMapper{

    List<UserEntity> selectList(@Param("search") String search);

    UserEntity selectById(@Param("userId") String userId);

    UserEntity selectByLoginNameOrEmail(@Param("loginName") String loginName);

    List<UserEntity> selectPage(@Param("search") String search, @Param("firstResult") int firstResult, @Param("maxResults") int maxResults);

    int count();

    int deleteUser(@Param("userId") String userId);

}
