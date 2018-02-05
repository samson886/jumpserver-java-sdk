package com.jumpserver.sdk.service;

import com.jumpserver.sdk.base.ApiConstants;
import com.jumpserver.sdk.model.User;
import com.jumpserver.sdk.model.Usergroup;

import java.util.Map;

public class JmsUsersService extends JmsBaseService {

    public JmsUsersService(String url, String username, String password) {
        super(url, username, password);
    }

    public Map<String, String> addUser(User user) {
        return super.add(user, ApiConstants.USERS);
    }

    public Map<String, String> updateUser(User user) {
        return super.update(user, ApiConstants.USERS, user.getId());
    }

    public Map<String, String> deleteUser(User user) {
        return super.delete(user, ApiConstants.USERS, user.getId());
    }

    public Map<String, String> queryUser(String id) {
        return super.query(id, ApiConstants.USERS);
    }

    public Map<String, String> addUserGroup(Usergroup usergroup) {
        return super.add(usergroup, ApiConstants.USERGROUPS);
    }

    public Map<String, String> updateUserGroup(Usergroup usergroup) {
        return super.update(usergroup, ApiConstants.USERGROUPS, usergroup.getId());
    }

    public Map<String, String> deleteUserGroup(Usergroup usergroup) {
        return super.delete(usergroup, ApiConstants.USERGROUPS, usergroup.getId());
    }

    public Map<String, String> queryUserGroup(String id) {
        return super.query(id, ApiConstants.USERGROUPS);
    }

    public Map<String, String> userPasswordReset(User user) {
        return super.commonUpdate(user, ApiConstants.USER_PASSWORD_RESET_START, ApiConstants.USER_PASSWORD_RESET_END, user.getId());
    }

}
