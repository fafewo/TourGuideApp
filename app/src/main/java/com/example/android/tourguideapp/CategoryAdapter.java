package com.example.android.tourguideapp;

import android.content.Context;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {
    /** Context of the app */
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param context is the context of the app
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */

    public CategoryAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext =context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new InfoFragment();
        }else if (position == 1){
            return new SeeFragment();
        }else if (position == 2){
            return new EatFragment();
        }else {
            return new SleepFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_info);
        } else if (position == 1) {
            return mContext.getString(R.string.category_see);
        } else if (position == 2) {
            return mContext.getString(R.string.category_eat);
        } else {
            return mContext.getString(R.string.category_sleep);
        }
    }
}
