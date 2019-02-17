package com.aotuman.architecture.mvp.v2.base;

public class MVPListView {
    public interface IListener {

        public void onRefresh();

        public void onLoadMore();
    }
}
