package com.cn.fragmentmodule;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.cn.fragmentmodule.fragments.Fragment1;
import com.cn.fragmentmodule.fragments.Fragment2;
import com.cn.fragmentmodule.fragments.Fragment3;
import com.cn.fragmentmodule.fragments.Fragment4;

/**
 * yxy 2020/5/4
 * 使用Fragment（碎片）实现
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取布局文件的4个导航图片
        ImageView image1=(ImageView)findViewById(R.id.image1);
        ImageView image2=(ImageView)findViewById(R.id.image2);
        ImageView image3=(ImageView)findViewById(R.id.image3);
        ImageView image4=(ImageView)findViewById(R.id.image4);

        //为导航图片添加单击事件
        image1.setOnClickListener(listener);
        image2.setOnClickListener(listener);
        image3.setOnClickListener(listener);
        image4.setOnClickListener(listener);
    }

    //创建单击事件监听器
    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //获取FragmentManager对象，用于对我们添加的Fragment进行管理
            FragmentManager fm=getSupportFragmentManager();
            //开启一个事务，服务于Fragment先关操作
            FragmentTransaction ft=fm.beginTransaction();

            //创建Fragment对象，赋值为null，后续用户选做出选择时再赋值
            Fragment fragment=null;//为Fragment初始化
            switch(v.getId()){ //通过获取点击的id判断点击了哪张图片
                case R.id.image1:
                    fragment=new Fragment1();//创建第一个Fragment
                    break;
                case R.id.image2:
                    fragment=new Fragment2();//创建第二个Fragment
                    break;
                case R.id.image3:
                    fragment=new Fragment3();//创建第三个Fragment
                    break;
                case R.id.image4:
                    fragment=new Fragment4();//创建第四个Fragment
                    break;
                default:
                    break;
            }
            ft.replace(R.id.fragment1,fragment);//替换Fragment（用户选择哪一个就替换成哪一个）
            ft.commit();//提交事务
        }
    };

}
