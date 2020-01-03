package com.bawei.mengxuan.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.mengxuan.R;
import com.bawei.mengxuan.base.BaseActivity;
import com.bawei.mengxuan.base.BasePresenter;
import com.bawei.mengxuan.view.fragment.HomeFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.m_viewPager)
    ViewPager mViewPager;
    @BindView(R.id.m_home)
    RadioButton mHome;
    @BindView(R.id.m_sort)
    RadioButton mSort;
    @BindView(R.id.m_find)
    RadioButton mFind;
    @BindView(R.id.m_cart)
    RadioButton mCart;
    @BindView(R.id.m_my)
    RadioButton mMy;
    @BindView(R.id.m_radioGroup)
    RadioGroup mRadioGroup;

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initDate() {
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new HomeFragment());
        list.add(new HomeFragment());
        list.add(new HomeFragment());
        list.add(new HomeFragment());
        mViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }

    @Override
    protected void initView() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mRadioGroup.check(mRadioGroup.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected BasePresenter protectedPresenter() {
        return null;
    }


    @OnClick({R.id.m_home, R.id.m_sort, R.id.m_find, R.id.m_cart, R.id.m_my})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_home:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.m_sort:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.m_find:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.m_cart:
                mViewPager.setCurrentItem(3);
                break;
            case R.id.m_my:
                mViewPager.setCurrentItem(4);
                break;
        }
    }
}
