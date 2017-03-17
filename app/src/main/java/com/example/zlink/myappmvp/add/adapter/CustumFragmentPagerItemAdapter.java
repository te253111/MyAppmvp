package com.example.zlink.myappmvp.add.adapter;

import android.support.v4.app.FragmentManager;

import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

/**
 * Created by Zlink on 17/3/2560.
 */

public class CustumFragmentPagerItemAdapter extends FragmentPagerItemAdapter {
    public CustumFragmentPagerItemAdapter(FragmentManager fm, FragmentPagerItems pages) {
        super(fm, pages);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }


}
