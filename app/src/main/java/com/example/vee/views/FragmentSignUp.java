package com.example.vee.views;


import android.app.Activity;
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
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSignUp extends Fragment {
    public static final String TAG = "FragmentSignUp";
    private EditText email, password,username;
    private View rootView, login;
    private FirebaseAuth mAuth;

    public FragmentSignUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_fragment_sign_up, container, false);
        mAuth = FirebaseAuth.getInstance();

        email = rootView.findViewById(R.id.email_su);
        password = rootView.findViewById(R.id.password_su);
        login = rootView.findViewById(R.id.btn_signup_su);
        username =rootView.findViewById(R.id.username_su);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emails = email.getText().toString();
                String passord = password.getText().toString();
                String usernamestring = username.getText().toString();

                if (usernamestring==null){
                    username.requestFocus();
                    username.setError("please enter user name");
                }
                else
                ((MainActivity)getActivity()).signUpWithNewuser(emails,passord,usernamestring);
            }
        });

        return rootView;
    }

//    private void signUpWithNewuser(String email, String passWord) {
//
//        if (email == null || email.isEmpty() || passWord == null || passWord.isEmpty()) {
//            showToast(getString(R.string.blank_mail_pass));
//            return;
//        }
//        mAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "createUserWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//
//
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                            MainActivity.showToast("" + task.getException().getMessage());
//                        }
//
//
//                    }
//                });
//    }

}
