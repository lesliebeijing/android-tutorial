package com.leslie.fragmenttabhostdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolBar;
    private FragmentTabHost mTabHost;
    private Class[] fragments = new Class[]{HomeFragment.class, CertificateFragment.class, NoticeFragment.class, ProfileFragment.class};
    private int[] imageResIds = new int[]{R.drawable.home_tab, R.drawable.certificate_tab, R.drawable.notice_tab, R.drawable.profile_tab};
    private String[] tags = new String[]{"home", "certificate", "notice", "profile"};
    private String[] titles = new String[]{"首页", "凭证", "公示", "我的"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);

        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        for (int i = 0; i < fragments.length; i++) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(tags[i]).setIndicator(getTabItemView(i));
            mTabHost.addTab(tabSpec, fragments[i], null);
        }
    }

    private View getTabItemView(int i) {
        View view = LayoutInflater.from(this).inflate(R.layout.tab_item, null);
        ImageView image = (ImageView) view.findViewById(R.id.tab_image);
        TextView text = (TextView) view.findViewById(R.id.tab_tex);
        image.setImageResource(imageResIds[i]);
        text.setText(titles[i]);
        return view;
    }
}
