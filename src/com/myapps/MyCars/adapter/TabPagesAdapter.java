package com.myapps.MyCars.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.myapps.MyCars.fragment.FillupFragement;
import com.myapps.MyCars.fragment.ServiceFragement;
import com.myapps.MyCars.fragment.StatisticsFragement;

/**
 * Created with IntelliJ IDEA.
 * User: richard
 * Date: 7/23/14
 * Time: 10:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class TabPagesAdapter extends FragmentPagerAdapter {

    public TabPagesAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {
        switch (index) {
            case 0:
                return new FillupFragement();
            case 1:
                return new ServiceFragement();
            case 2:
                return new StatisticsFragement();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

}
