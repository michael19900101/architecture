package com.aotuman.architecture.mvp.v1.model;

import com.aotuman.architecture.mvp.v1.bean.User;

public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailed();
}
