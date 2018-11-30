package com.example.vee.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vee.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentC extends Fragment {
public static final String TAG="FragmentC";
private View mView;

    public FragmentC() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_fragment_c, container, false);

        return mView;
    }

}
