package com.aotuman.architecture.mvp.v2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aotuman.architecture.R;
import com.aotuman.architecture.mvp.v2.base.MVPBaseFragment;
import com.aotuman.architecture.mvp.v2.base.MVPListView;

import java.util.ArrayList;

public class MVPFragment extends MVPBaseFragment<MVPContract.View<MVPBean>, MVPPresenter> implements MVPContract.View<MVPBean>, MVPListView.IListener {

    private static final String TAG = MVPFragment.class.getSimpleName();

    private String param;

    public MVPFragment() {
        // Required empty public constructor
    }

    public static MVPFragment newInstance(String param) {
        MVPFragment fragment = new MVPFragment();
        Bundle args = new Bundle();
        args.putString("param", param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (getArguments() != null) {
            param = getArguments().getString("param");
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected MVPPresenter createPresenter() {
        return new MVPPresenter(param, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mvp, container, false);
        initView(v);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initView(View v) {

    }

    private void initData() {
        mPresenter.start();
    }

    @Override
    public void dismissLoadingViews() {

    }

    @Override
    public void showLoadingViews() {

    }

    @Override
    public void showErrorViews(int errorCode, String msg) {

    }

    @Override
    public void refreshContentView(ArrayList<MVPBean> contentList) {

    }

    @Override
    public void loadMoreContentView(ArrayList<MVPBean> contentList) {

    }

    @Override
    public void onRefresh() {
        mPresenter.requestRefresh();
    }

    @Override
    public void onLoadMore() {
        mPresenter.requestLoadMore();
    }


}