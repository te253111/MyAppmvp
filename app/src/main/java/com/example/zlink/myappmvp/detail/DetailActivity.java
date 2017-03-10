package com.example.zlink.myappmvp.detail;

import android.content.Intent;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zlink.myappmvp.R;
import com.example.zlink.myappmvp.detail.model.DataUser;
import com.example.zlink.myappmvp.profile.ProfileActivity;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity implements  DetailFragment.listeners {

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
    public void GotoPageProfile(DataUser dataUser) {
        Intent i = new Intent(this, ProfileActivity.class);
        i.putExtra(ProfileActivity.TAGS, Parcels.wrap(dataUser));
        startActivity(i);
    }
}
