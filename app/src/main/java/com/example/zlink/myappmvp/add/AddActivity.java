package com.example.zlink.myappmvp.add;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.example.zlink.myappmvp.Base.TabModel;
import com.example.zlink.myappmvp.R;
import com.example.zlink.myappmvp.add.tab1.AddFragment;
import com.example.zlink.myappmvp.add.tab2.ResFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.guest_smartTab)
    SmartTabLayout guestSmartTab;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private ArrayList<TabModel> tabModels;
    FragmentPagerItems pages;
    FragmentPagerItemAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setupTabLayout();
    }

    private void setupTabLayout() {
        setTabs();
        pages = new FragmentPagerItems(this);
        //guestSmartTab.setCustomTabView(new TabIconLayoutProvider(tabModels, guestSmartTab));
        for (TabModel tabModel : tabModels) {
            pages.add(FragmentPagerItem.of(tabModel.getTitle(), tabModel.getFragment(), tabModel.getBundle()));
        }
        adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(), pages);
        viewpager.setAdapter(adapter);
        guestSmartTab.setViewPager(viewpager);
        guestSmartTab.setOnPageChangeListener(pageChangeListener);
    }

    private void setTabs() {
        tabModels = new ArrayList<>();

        TabModel Add = new TabModel();
        Add.setTitle("Add");
        Add.setFragment(AddFragment.class);

        TabModel Res = new TabModel();
        Res.setTitle("Res");
        Res.setFragment(ResFragment.class);


        tabModels.add(Add);
        tabModels.add(Res);
    }

    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if(position==1){

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
