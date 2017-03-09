package com.example.zlink.myappmvp.login;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zlink.myappmvp.R;
import com.example.zlink.myappmvp.detail.DetailActivity;
import com.example.zlink.myappmvp.detail.DetailFragment;
import com.example.zlink.myappmvp.login.LoginFragment;

public class LoginActivity extends AppCompatActivity implements LoginFragment.listeners {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content,LoginFragment.newInstance("")).commit();
        }
    }

    @Override
    public void GotoPageDetail() {
        Intent i = new Intent(this,DetailActivity.class);
        startActivity(i);
    }
}
