package com.example.vee.views;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.vee.MainActivity;
import com.example.vee.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSignin extends Fragment {
    public static final String TAG = "FragmentSignUp";
    private EditText email, password;
    private View mView,login,tv_signup;
    public FragmentSignin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_fragment_signin, container, false);
        email =mView.findViewById(R.id.email_fsi);
        password =mView.findViewById(R.id.password_fsi);
        login =mView.findViewById(R.id.btn_login_fsi);
        tv_signup =mView.findViewById(R.id.tv_signup_fsi);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emails = email.getText().toString();
                String passord = password.getText().toString();

                ((MainActivity)getActivity()).loginWithPasswordAndEmail(emails,passord);
            }
        });
        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).showSignUpFragment();
            }
        });

        return mView;
    }

//    private void updateEmail() {
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//
//        user.updateEmail("user@example.com")
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()) {
//                            Log.d(TAG, "User email address updated.");
//                        }
//                    }
//                });
//    }

}
