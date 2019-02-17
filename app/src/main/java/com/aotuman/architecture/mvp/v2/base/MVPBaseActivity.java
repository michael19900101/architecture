package com.aotuman.architecture.mvp.v2.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

public abstract class MVPBaseActivity<V, P extends BasePresenter<V>> extends BaseActivity {
    private static final String TAG = "MVPBaseActivity";
    protected P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();//创建Presenter
        mPresenter.attachView((V) this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    protected abstract P createPresenter();
}