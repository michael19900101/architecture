package com.aotuman.architecture.mvp.v1.model;

public interface IUserModel {
    void login(String username, String password, OnLoginListener loginListener);
}
