package com.example.vee.views;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.vee.MainActivity;
import com.example.vee.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentD extends Fragment {
    public static final String TAG="FragmentD";
    private View mView;
    private Button signOut;
    private FirebaseAuth mAuth;

    public FragmentD() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_fragment_d, container, false);
//        FirebaseApp.initializeApp(getContext());
        mAuth = FirebaseAuth.getInstance();
        signOut =mView.findViewById(R.id.btn_signout);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               SignOut();
                ((MainActivity)getActivity()).showSignInFragment();
            }
        });

        return mView;
    }
    public void showToast(String msg) {
        Toast.makeText(getContext(), "" + msg, Toast.LENGTH_SHORT).show();
    }

    public void SignOut() {
        if (mAuth != null) {
            mAuth.signOut();
            showToast("sign out succesfully");
        }
    }

}