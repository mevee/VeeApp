package com.example.vee.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vee.R;
import com.example.vee.cv.FireView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentB extends Fragment {
    public static final String TAG = "FragmentB";
    private View mView;
    private RecyclerView recyclerView;


    public FragmentB() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_fragment_b, container, false);

        recyclerView = mView.findViewById(R.id.recylerview_fb);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        Log.d(TAG, "oncreate");

        return mView;
    }

}
