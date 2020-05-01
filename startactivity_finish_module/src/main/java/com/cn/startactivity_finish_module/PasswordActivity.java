package com.cn.startactivity_finish_module;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PasswordActivity extends AppCompatActivity {

    private ImageView close;//关闭图标

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        close=(ImageView)findViewById(R.id.close);//关闭图标
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();//关闭当前Activity，回到上一个Activity或者回到手机桌面
            }
        });
    }
}
