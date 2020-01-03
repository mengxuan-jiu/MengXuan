package com.bawei.mengxuan.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bawei.mengxuan.R;

import butterknife.ButterKnife;


public abstract class BaseFragmen<P extends BasePresenter> extends Fragment {
    protected P mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(layoutId(), container, false);
        mPresenter = protectedPresenter();
        if (mPresenter != null) {
            mPresenter.attach(this);
        }
        ButterKnife.bind(getActivity());
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDate();
    }

    protected abstract int layoutId();

    protected abstract void initDate();

    protected abstract void initView(View view);

    protected abstract P protectedPresenter();


}
