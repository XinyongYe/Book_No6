package com.cn.startactivityforresult_onactivityresult_module;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * yxy 2020/5/2
 * 到达头像列表选择界面，并获取HeadActivity中返回的值；
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent对象，用于开启新的Activity
                Intent intent=new Intent(MainActivity.this,HeadActivity.class);
                startActivityForResult(intent,1100);
            }
        });
    }

    /**
     * 在MainActivity中重写onActivityResult()方法。在该方法中，需要判断requestCode请求码和resultCode结果码是
     * 否与预先设置的相同，如果相同，则获取传递的数据包；
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1100 && resultCode==1100){ //判断是否为待处理结果
            Bundle bundle=data.getExtras();//获取传递的数据包
            int imageId=bundle.getInt("imageId");//获取选择的图像的ID
            //获取布局文件中添加的ImageView组件
            ImageView image=(ImageView)findViewById(R.id.image);
            image.setImageResource(imageId);//显示选择的图片
        }
    }
}
