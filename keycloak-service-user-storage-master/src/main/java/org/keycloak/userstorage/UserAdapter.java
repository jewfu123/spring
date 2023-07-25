package org.keycloak.userstorage;

import org.keycloak.common.util.MultivaluedHashMap;
import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.storage.StorageId;
import org.keycloak.storage.adapter.AbstractUserAdapterFederatedStorage;
import org.keycloak.userstorage.domain.UserEntity;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//适配器，用来把自定义的用户字段转换成keycloak能够识别的用户字段
public class UserAdapter extends AbstractUserAdapterFederatedStorage {

    private final UserEntity user;
    private final String keycloakId;

    public UserAdapter(KeycloakSession session, RealmModel realm, ComponentModel model, UserEntity user) {
        super(session, realm, model);
        this.user = user;
        if (user != null && user.getUserId() != null) {
            this.keycloakId = StorageId.keycloakId(model, String.valueOf(user.getUserId()));

            this.setEmail(user.getEmail());
            this.setFirstName(user.getUserName());
            this.setLastName(user.getUserName());
            this.setEnabled(user.getStatus().equals("0"));
            this.setCreatedTimestamp(user.getCreateTime().getTime());
        } else {
            this.keycloakId = StorageId.keycloakId(model, null);
        }

    }

    @Override
    public String getId() {
        return keycloakId;
    }

    @Override
    public String getUsername() {
        return user.getLoginName();
    }

    @Override
    public void setUsername(String username) {
        user.setLoginName(username);
    }

    @Override
    public String getFirstAttribute(String name) {
        if (name.equals("phonenumber")) {
            return user.getPhonenumber();
        } else {
            return super.getFirstAttribute(name);
        }
    }

    @Override
    public Map<String, List<String>> getAttributes() {
        Map<String, List<String>> attrs = super.getAttributes();
        MultivaluedHashMap<String, String> all = new MultivaluedHashMap<>();
        all.putAll(attrs);
        all.add("phonenumber", user.getPhonenumber());
        all.add("userName",user.getUserName());
        return all;
    }

    @Override
    public List<String> getAttribute(String name) {
        if (name.equals("phonenumber")) {
            List<String> phone = new LinkedList<>();
            phone.add(user.getPhonenumber());
            return phone;
        } else {
            return super.getAttribute(name);
        }
    }
}
