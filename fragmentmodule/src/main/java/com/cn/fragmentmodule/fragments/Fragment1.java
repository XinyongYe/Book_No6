package com.cn.fragmentmodule.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cn.fragmentmodule.R;

public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.layout_frag1,null);
        return view;//如果我们需要使用的Fragment是无视图界面的话，那么，可以直接返回null
    }

}
