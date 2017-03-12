package com.example.zlink.myappmvp.Base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Zlink on 12/3/2560.
 */

public class TabModel {
    private String title;
    private int iconResId;
    private Class<? extends Fragment> fragment;
    private Bundle bundle;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }

    public Class<? extends Fragment> getFragment() {
        return fragment;
    }

    public void setFragment(Class<? extends Fragment> fragment) {
        this.fragment = fragment;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public TabModel(){
        bundle = new Bundle();
    }

}
