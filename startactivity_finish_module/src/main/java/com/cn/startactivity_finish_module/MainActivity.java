package com.cn.startactivity_finish_module;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * yxy 2020/5/1
 * 使用 startActivity(Intent intent) 方法来启动需要的Activity；使用 finish()方法来关闭当前的Activity，
 * 如果在关闭当前的Activity时，有调用它的Activity（即上一级Activity）那么将返回调用它的Activity，如果
 * 没有调用它的Activity，那么，调用finish之后将返回到手机的主屏幕；
 */
public class MainActivity extends AppCompatActivity {

    private TextView text3;//忘记密码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text3=findViewById(R.id.text3);//忘记密码
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent对象
                Intent intent=new Intent(MainActivity.this,PasswordActivity.class);
                startActivity(intent);//启动PasswordActivity
            }
        });
    }
}
