package com.example.zlink.myappmvp.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.zlink.myappmvp.Base.TabIconLayoutProvider;
import com.example.zlink.myappmvp.Base.TabModel;
import com.example.zlink.myappmvp.R;
import com.example.zlink.myappmvp.detail.model.DataUser;
import com.example.zlink.myappmvp.profile.tab1.ProfileFragment;
import com.example.zlink.myappmvp.profile.tab2.AddressFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.Bundler;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity implements ProfileFragment.listeners, AddressFragment.listeners {
    public static String TAGS = "Param_ProfileActivity";

    DataUser dataUser;
    @BindView(R.id.guest_smartTab)
    SmartTabLayout guestSmartTab;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private ArrayList<TabModel> tabModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        dataUser = Parcels.unwrap(intent.getParcelableExtra(TAGS));
        setupTabLayout(dataUser);
        //setupTabLayout2(dataUser);
    }

    /*private void setupTabLayout2(DataUserEntity dataUser) {
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Profile", ProfileFragment.class, new Bundler().putParcelable("DataUserEntity", Parcels.wrap(dataUser)).get())
                .add("Address", AddressFragment.class, new Bundler().putParcelable("DataUserEntity", Parcels.wrap(dataUser)).get())
                .create());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.guest_smartTab);
        viewPagerTab.setViewPager(viewPager);
    }*/


    private void setupTabLayout(DataUser dataUser) {
        setTabs(dataUser);
        FragmentPagerItems pages = new FragmentPagerItems(this);
        //guestSmartTab.setCustomTabView(new TabIconLayoutProvider(tabModels, guestSmartTab));
        for (TabModel tabModel : tabModels) {
            pages.add(FragmentPagerItem.of(tabModel.getTitle(),tabModel.getFragment(),tabModel.getBundle()));
        }
        final FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(), pages);
        viewpager.setAdapter(adapter);
        guestSmartTab.setViewPager(viewpager);
        guestSmartTab.setOnPageChangeListener(pageChangeListener);
    }

    private void setTabs(DataUser dataUser) {
        tabModels = new ArrayList<>();

        Bundle t1 = new Bundle();
        t1.putParcelable("DataUserEntity",Parcels.wrap(dataUser));

        Bundle t2 = new Bundle();
        t2.putParcelable("DataUserEntity",Parcels.wrap(dataUser));

        //Profile Tab
        TabModel Profile = new TabModel();
        Profile.setTitle("Profile");
        Profile.setFragment(ProfileFragment.class);
        Profile.setBundle(t1);

        //homeTab.setIconResId(R.mipmap.ic_home);


        // Address

        TabModel Address = new TabModel();
        Address.setTitle("Address");
        Address.setFragment(AddressFragment.class);
        Address.setBundle(t2);

        //profileTab.setIconResId(R.mipmap.ic_profile);



        tabModels.add(Profile);
        tabModels.add(Address);
    }

    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            toolbar.setTitle(tabModels.get(position).getTitle());
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public void GpBack() {
        finish();
    }
}
