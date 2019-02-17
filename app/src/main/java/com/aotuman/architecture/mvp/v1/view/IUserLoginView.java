package com.aotuman.architecture.mvp.v1.view;

import com.aotuman.architecture.mvp.v1.bean.User;

public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
