package com.myapps.MyCars.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.myapps.MyCars.R;

/**
 * Created with IntelliJ IDEA.
 * User: richard
 * Date: 7/23/14
 * Time: 11:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class ServiceFragement  extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragement_service, container, false);

        return rootView;
    }
}
