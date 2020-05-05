package com.cn.startactivityforresult_onactivityresult_module;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * yxy 2020/5/2
 * 头像列表选择界面；
 */
public class HeadActivity extends AppCompatActivity {

    private int[] picture=new int[]{R.mipmap.icon_tx1,R.mipmap.icon_tx2,R.mipmap.icon_tx3,R.mipmap.icon_tx4,R.mipmap.icon_tx5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);

        GridView gridView=(GridView)findViewById(R.id.gridView);//网格视图组件
        //创建基本适配器BaseAdapter
        BaseAdapter baseAdapter=new BaseAdapter() {
            //获得数量
            @Override
            public int getCount() {
                return picture.length;
            }
            //功能：获得当前选项
            @Override
            public Object getItem(int position) {
                return position;
            }
            //功能：获得当前选项ID
            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView;//声明一个ImageView对象
                if (convertView==null){
                    imageView=new ImageView(HeadActivity.this);//实例化ImageView
                    /*******************设置图像的宽度和高度******************/
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxWidth(158);
                    imageView.setMaxHeight(150);
                    imageView.setPadding(5,5,5,5);//设置ImageView的内边距
                }else{
                    imageView=(ImageView)convertView;
                }
                imageView.setImageResource(picture[position]);//为ImageView设置要显示的图片
                return imageView;//返回ImageView
            }
        };

        gridView.setAdapter(baseAdapter);

        /**
         * 为GridView网格视图添加选项点击监听；
         */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=getIntent();//获取Intent对象
                Bundle bundle=new Bundle();//实例化要传递的数据包，即，将Bundle作为数据包来存储要传递的数据
                bundle.putInt("imageId",picture[position]);//存储用户点击选择的的图片的int值
                intent.putExtras(bundle);//将数据包Bundle存储到Intent中
                setResult(1100,intent);//设置返回的结果码，并返回调用该Activity的Activity
                finish();//关闭当前Activity，返回到上一级Activity
            }
        });

    }


}
