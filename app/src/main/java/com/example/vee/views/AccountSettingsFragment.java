package com.example.vee.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.vee.R;
import com.example.vee.database.DbConstants;
import com.example.vee.database.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountSettingsFragment extends Fragment {
    public static final String TAG = AccountSettingsFragment.class.getSimpleName();
    private View mView;
    private ImageView profileImg;
    private EditText currentStatus;
    private Button btnUpdate;
    private FirebaseDatabase database;
    private FirebaseAuth auth;
    private DatabaseReference df;

    public AccountSettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =inflater.inflate(R.layout.fragment_account_settings, container, false);
        init();


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return mView;
    }

    private void init() {
        auth =FirebaseAuth.getInstance();
        database =FirebaseDatabase.getInstance();
        df =database.getReference(DbConstants.USERS);
//        df.getKey(auth.getUid());
//        if (auth.getCurrentUser()!=null) {
//            User user =new User();
//            user.setUid(auth.getUid());
//            user.setEmail(auth.getCurrentUser().getEmail());
//
//            df.child(auth.getUid()).setValue(user);
//        }
//                child(auth.getUid());
//        df.setValue("hellow world");

        profileImg = mView.findViewById(R.id.profile_img_sf);
        currentStatus = mView.findViewById(R.id.user_status_sf);
        btnUpdate = mView.findViewById(R.id.btn_update_info_sf);

    }

}
