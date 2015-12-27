package com.example.liuwangshu.myslidetabbar;

import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TabbarActivity extends AppCompatActivity {
    private HorizontalScrollView hs_activity_tabbar;
    private RadioGroup myRadioGroup;
    private List<String> titleList;
    private LinearLayout ll_activity_tabbar_content;
    private float mCurrentCheckedRadioLeft;//当前被选中的RadioButton距离左侧的距离
    private String channel;
    private TextView tv_tabname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbar);
        tv_tabname= (TextView) this.findViewById(R.id.tv_tabname);
        titleList = new ArrayList<String>();
        titleList.add("推荐");
        titleList.add("热点");
        titleList.add("北京");
        titleList.add("体育");
        titleList.add("娱乐");
        titleList.add("足球");
        titleList.add("巴萨");
        titleList.add("汽车");
        initGroup();

    }

    private void initGroup() {
        hs_activity_tabbar= (HorizontalScrollView) this.findViewById(R.id.hs_activity_tabbar);
        ll_activity_tabbar_content= (LinearLayout) this.findViewById(R.id.ll_activity_tabbar_content);
        //选项卡布局
        myRadioGroup = new RadioGroup(this);
        myRadioGroup.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        myRadioGroup.setOrientation(LinearLayout.HORIZONTAL);
        ll_activity_tabbar_content.addView(myRadioGroup);
        for (int i = 0; i < titleList.size(); i++) {
            String channel = titleList.get(i);
            RadioButton radio = new RadioButton(this);
            radio.setButtonDrawable(android.R.color.transparent);
            radio.setBackgroundResource(R.drawable.radiobtn_selector);
            ColorStateList csl = getResources().getColorStateList(R.color.radiobtn_text_color);
            radio.setTextColor(csl);
            LinearLayout.LayoutParams l = new LinearLayout.LayoutParams((int) SizeHelper.dp2px(this, 80), ViewGroup.LayoutParams.MATCH_PARENT, Gravity.CENTER);
            radio.setLayoutParams(l);
            radio.setTextSize(15);
            radio.setGravity(Gravity.CENTER);
            radio.setText(channel);
            radio.setTag(channel);
            myRadioGroup.addView(radio);
        }


        myRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int radioButtonId = group.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) findViewById(radioButtonId);
                channel = (String) rb.getTag();
                mCurrentCheckedRadioLeft = rb.getLeft();//更新当前按钮距离左边的距离
                int width=(int) SizeHelper.dp2px(TabbarActivity.this, 140);
                hs_activity_tabbar.smoothScrollTo((int) mCurrentCheckedRadioLeft - width, 0);
                tv_tabname.setText(channel);
            }
        });
        //设定默认被选中的选项卡为第一项
        if (!titleList.isEmpty()) {
            myRadioGroup.check(myRadioGroup.getChildAt(0).getId());
        }

    }
}
