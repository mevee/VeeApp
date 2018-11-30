package com.example.vee.views;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vee.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {
    public static String TAG = "FragmentHome";
    private ViewPager viewPager;
    private Toolbar toolbar;
    private View mView;
    private FirebaseUser user;
    private FirebaseAuth mAuth;


    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager = mView.findViewById(R.id.viewpager_home);
        mAuth =FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        viewPager.setAdapter(new PagerAdapter(getChildFragmentManager(), 3));

//        viewPager.setCurrentItem(2);
        toolbar = mView.findViewById(R.id.toolbar_home);
        toolbar.setTitle("OEMApp");

        return mView;
    }

    private class PagerAdapter extends FragmentPagerAdapter {

        int noOfPage;

        public PagerAdapter(FragmentManager fragmentManager, int noOfPage) {
            super(fragmentManager);
            this.noOfPage = noOfPage;
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return noOfPage;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {

            if (position == 0) {
                FragmentB editStationInfoFragment = new FragmentB();
                return editStationInfoFragment;
            } else if (position == 1) {

                FragmentC liveDataFragmentForManager = new FragmentC();
                return liveDataFragmentForManager;
            } else if (position == 2) {

                FragmentD liveDataFragmentForManager = new FragmentD();
                return liveDataFragmentForManager;
            }
            return null;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            if (position==1)
                return "Friends";
            if (position==2)
                return "chats";
            if (position==3)
                return "requests";

            return super.getPageTitle(position);
        }
    }

//        @Override
//        public int getCount() {
//            return noOfPages;
//        }
////        public CharSequence title()
//
////        @Nullable
////        @Override
////        public CharSequence getPageTitle(int position) {
////            if (position == 0) {
////                return "Recents";
////            }
////            if (position == 1) {
////                return "Friends";
////            }
////            if (position == 2) {
////                return "Request";
////            }
////            return super.getPageTitle(position);
////        }
//    }

}