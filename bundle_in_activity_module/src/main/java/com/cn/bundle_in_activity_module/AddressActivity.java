package com.cn.bundle_in_activity_module;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AddressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        //获取从上一级Activity传递过来的Intent对象（从而获取添加到Intent对象中的Bundle对象）
        Intent intent=getIntent();//火器营从上一级Activity中传递过来的Intent对象
        Bundle bundle=intent.getExtras();//获取存储到Intent中的Bundle对象
        String name=bundle.getString("name");
        String phone=bundle.getString("phone");
        String site1=bundle.getString("site1");
        String site2=bundle.getString("site2");
        String site3=bundle.getString("site3");

        TextView textName=(TextView)findViewById(R.id.name);
        TextView textPhone=(TextView)findViewById(R.id.phone);
        TextView textAddress=(TextView)findViewById(R.id.address);

        textName.setText(name);
        textPhone.setText(phone);
        textAddress.setText(site1+site2+site3);

        ImageView image1=(ImageView)findViewById(R.id.image1);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
