package com.bawei.mengxuan.base;


public abstract class BasePresenter<V>  {
    protected V view;

    public BasePresenter() {
        initModel();
    }

    public void attach(V view) {
        this.view = view;
    }
    public void dttach() {
       view = null;
    }
    protected abstract void initModel();
}
