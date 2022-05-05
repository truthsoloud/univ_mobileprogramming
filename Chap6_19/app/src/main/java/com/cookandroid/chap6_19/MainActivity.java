package com.cookandroid.chap6_19;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;

@SuppressWarnings("deprecation")

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    ActionBar.Tab tabSong,tabArtist, tabAlbum;

    MyTabFragment myFrags[] = new MyTabFragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabSong=bar.newTab();
        tabSong.setText("음악별");
        tabSong.setTabListener(this);
        bar.addTab(tabSong);

        tabSong=bar.newTab();
        tabSong.setText("가수별");
        tabSong.setTabListener(this);
        bar.addTab(tabArtist);

        tabSong=bar.newTab();
        tabSong.setText("앨범별");
        tabSong.setTabListener(this);
        bar.addTab(tabAlbum);
    }
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        MyTabFragment myTabFrag = null;

        if (myFrags[tab.getPosition()]==null) {
            myTabFrag=new MyTabFragment();
            Bundle data=new Bundle();
            data.putString("tabName", tab.getText().toString());
            myTabFrag.setArguments(data);
            myFrags[tab.getPosition()]=myTabFrag;
        }
        else
            myTabFrag=myFrags[tab.getPosition()];

        ft.replace(android.R.id.content, myTabFrag);
    }
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        MyTabFragment myTabFrag = null;

        if (myFrags[tab.getPosition()]==null) {
            myTabFrag=new MyTabFragment();
            Bundle data=new Bundle();
            data.putString("tabName", tab.getText().toString());
            myTabFrag.setArguments(data);
            myFrags[tab.getPosition()]=myTabFrag;
        }
        else
            myTabFrag=myFrags[tab.getPosition()];

        ft.replace(android.R.id.content, myTabFrag);
    }
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        MyTabFragment myTabFrag = null;

        if (myFrags[tab.getPosition()]==null) {
            myTabFrag=new MyTabFragment();
            Bundle data=new Bundle();
            data.putString("tabName", tab.getText().toString());
            myTabFrag.setArguments(data);
            myFrags[tab.getPosition()]=myTabFrag;
        }
        else
            myTabFrag=myFrags[tab.getPosition()];

        ft.replace(android.R.id.content, myTabFrag);
    }

    public static class MyTabFragment extends androidx.fragment.app.Fragment {
        String tabName;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data=getArguments();
            tabName=data.getString("tabName");
        }
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout baseLayout = new LinearLayout(super.getActivity());
            baseLayout.setOrientation(LinearLayout.VERTICAL);
            baseLayout.setLayoutParams(params);

            if (tabName=="음악별") baseLayout.setBackgroundColor(Color.RED);
            if (tabName=="가수별") baseLayout.setBackgroundColor(Color.GREEN);
            if (tabName=="앨범별") baseLayout.setBackgroundColor(Color.BLUE);

            return baseLayout;
        }
    }

}