package com.example.zlink.myappmvp.Base;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zlink.myappmvp.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;

/**
 * Created by Zlink on 12/3/2560.
 */


public class TabIconLayoutProvider implements SmartTabLayout.TabProvider {
    private final SmartTabLayout tabLayout;
    private final ArrayList<TabModel> tabModels;

    public TabIconLayoutProvider(ArrayList<TabModel> tabModels, SmartTabLayout tabLayout) {
        this.tabLayout = tabLayout;
        this.tabModels = tabModels;
    }

    @Override
    public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
        final LayoutInflater inflater = LayoutInflater.from(tabLayout.getContext());
        ImageView icon = (ImageView) inflater.inflate(R.layout.custom_tab_icon, container, false);
        icon.setImageResource(tabModels.get(position).getIconResId());
        return icon;
    }
}
