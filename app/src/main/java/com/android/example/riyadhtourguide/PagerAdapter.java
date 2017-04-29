package com.android.example.riyadhtourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import static android.os.Build.VERSION_CODES.N;

/**
 * Created by MOHANAAD on 3/25/17.
 */


public class PagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public PagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MasjedFragment();
        } else if (position == 1) {
            return new OutdoorsFragment();
        } else if (position == 2) {
            return new MilestonesFragment();
        } else {
            return new ResturantFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_masjeds);
        } else if (position == 1) {
            return mContext.getString(R.string.category_outdoors);
        } else if (position == 2) {
            return mContext.getString(R.string.category_milestones);
        } else {
            return mContext.getString(R.string.category_resturant);
        }
    }
}
