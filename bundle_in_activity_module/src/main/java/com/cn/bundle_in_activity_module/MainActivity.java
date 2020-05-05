package com.cn.bundle_in_activity_module;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1=(Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入所在地区
                String site1=((EditText)findViewById(R.id.edit1)).getText().toString();
                //获取所在街道
                String site2=((EditText)findViewById(R.id.edit2)).getText().toString();
                //获取输入的详细地址
                String site3=((EditText)findViewById(R.id.edit3)).getText().toString();
                //获取输入的用户信息
                String site4=((EditText)findViewById(R.id.edit4)).getText().toString();
                //获取输入的用户输入的手机号
                String site5=((EditText)findViewById(R.id.edit5)).getText().toString();
                //获取输入的用户输入的邮箱
                String site6=((EditText)findViewById(R.id.edit6)).getText().toString();

                //用户输入的信息不为空
                if (!"".equals(site1) && !"".equals(site2) && !"".equals(site3) && !"".equals(site4) && !"".equals(site5) && !"".equals(site6)){
                    //将用户输入的信息保存到Bundle中，通过Intent传递到另外一个Activity中并显示出来
                    Intent intent=new Intent(MainActivity.this,AddressActivity.class);
                    //创建病实例化一个Bundle对象，用于存储键值对
                    Bundle bundle=new Bundle();
                    bundle.putString("name",site4);//保存姓名
                    bundle.putString("phone",site5);//保存电话
                    bundle.putString("site1",site1);//保存所在省市
                    bundle.putString("site2",site2);//保存街道信息
                    bundle.putString("site3",site3);//保存详细地址
                    intent.putExtras(bundle);//将Bundle对象添加到Intent对象中
                    startActivity(intent);//启动新的Activity即AddressActivity
                }
                //用户有漏填信息
                else{
                    Toast.makeText(MainActivity.this, "请将收获地址填写完整！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
