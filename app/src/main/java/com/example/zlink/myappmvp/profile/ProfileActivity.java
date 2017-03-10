package com.example.zlink.myappmvp.profile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zlink.myappmvp.R;
import com.example.zlink.myappmvp.detail.model.DataUser;

import org.parceler.Parcels;

public class ProfileActivity extends AppCompatActivity implements ProfileFragment.listeners{
    public static String TAGS="Param_ProfileActivity";

    DataUser dataUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        dataUser = Parcels.unwrap(intent.getParcelableExtra(TAGS));
        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.profilecontent,ProfileFragment.newInstance(dataUser)).commit();
        }
    }

    @Override
    public void GpBack() {
        finish();
    }
}
