package com.example.zlink.myappmvp.Base;

/**
 * Created by Zlink on 7/3/2560.
 */

public interface BasePresenter<V> {
    void setView(V view);
    void onPause();
    void onResume();
    void onDestroy();
}