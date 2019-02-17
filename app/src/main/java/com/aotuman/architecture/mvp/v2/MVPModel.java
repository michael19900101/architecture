package com.aotuman.architecture.mvp.v2;

import java.util.ArrayList;

public class MVPModel implements MVPContract.Model {

    private MVPContract.InteractionListener<ArrayList<MVPBean>> mListener;

    private String param;

    public MVPModel(String param, MVPContract.InteractionListener<ArrayList<MVPBean>> listener) {
        this.param = param;
        this.mListener = listener;
    }

    @Override
    public void loadContent(boolean isLoadMore, String lastKey) {
        //网络请求
        //数据处理
        //成功或者失败的回调
        //伪代码
//        if(success){
//            mListener.onInteractionSuccess("结果数据");
//        }else{
//            mListener.onInteractionFail("错误码","错误信息");
//        }
        boolean success = true;
        ArrayList<MVPBean> datas = new ArrayList<>();
        if(success){
            mListener.onInteractionSuccess(datas);
        }else{
            mListener.onInteractionFail(404,"错误信息404");
        }
    }
}