package com.example.zlink.myappmvp.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zlink.myappmvp.R;

public class DetailActivity extends AppCompatActivity implements DetailFragment.listeners {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.detailcontent,DetailFragment.newInstance("")).commit();
        }
    }

    @Override
    public void GoBack() {
        finish();
    }
}
