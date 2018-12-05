package com.example.vee;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.vee.daggertest.DataInterface;
import com.example.vee.daggertest.Users;
import com.example.vee.test.MyComponent;
import com.example.vee.test.Vehical;
import com.example.vee.views.FragmentHome;
import com.example.vee.views.FragmentSignUp;
import com.example.vee.views.FragmentSignin;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    //    @Inject
//    Vehical vehical;
    @Inject
    Retrofit retrofit;
    @Inject
    FirebaseAuth myAuth;
    @Inject
    FirebaseUser user;

    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ((MyApplication) getApplication()).getNetComponent().inject(this);
//       if (vehical!=null){
//           Log.d(TAG,"111");
//       }
//
//        if (myAuth != null) {
////           Log.d(TAG,"111"+myAuth.getCurrentUser().getDisplayName());
//        }
        if (myAuth == null) {
            Log.d(TAG, "auth" + ":null");
        } else if (user != null)
            Log.d(TAG, "auth1" + user.getEmail() + "dn" + user.getPhoneNumber());

        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() == null) {
//            Log.d(TAG, "222" + mAuth.getCurrentUser().getDisplayName());
            showSignInFragment();
        } else {
            showHomeFragment();
        }

        getHeroes();
    }

    private void getHeroes() {
        DataInterface api = retrofit.create(DataInterface.class);
        Call<List<Users>> call = api.getAllUsers();
//
        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                List<Users> heroList = response.body();
                String[] heroes = new String[heroList.size()];
                for (int i = 0; i < heroList.size(); i++)
                    Log.d(TAG, "hhhh" + heroList.get(i).getEmail());
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count <= 0) {
            finish();
        }
    }

    public void showLoader(Boolean cancelable) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(cancelable);
        progressDialog.setMessage(getString(R.string.please_wait));
        progressDialog.show();
    }

    public void stopLoader() {
        try {
            if (progressDialog != null) {
                progressDialog.dismiss();
                progressDialog = null;
            }
        } catch (Exception e) {
        }
    }

    public void showSignUpFragment() {
        FragmentSignUp signupFragment = new FragmentSignUp();

        getSupportFragmentManager().beginTransaction()
                .addToBackStack(FragmentSignUp.TAG)
                .replace(R.id.all_fragments, signupFragment, FragmentSignUp.TAG)
                .commit();
    }

    public void showSignInFragment() {
        FragmentSignin signinFragment = new FragmentSignin();

        getSupportFragmentManager().beginTransaction()
                .addToBackStack(FragmentSignin.TAG)
                .replace(R.id.all_fragments, signinFragment, FragmentSignin.TAG)
                .commit();
    }

    public void showHomeFragment() {
        FragmentHome homeFragment = new FragmentHome();

        getSupportFragmentManager().beginTransaction()
                .addToBackStack(FragmentHome.TAG)
                .replace(R.id.all_fragments, homeFragment, FragmentHome.TAG)
                .commit();
    }

    public void loginWithPasswordAndEmail(String email, String passWord) {

        if (email == null || email.isEmpty() || passWord == null || passWord.isEmpty()) {
            showToast(getString(R.string.blank_mail_pass));
            return;
        }

        showLoader(false);
        mAuth.signInWithEmailAndPassword(email, passWord)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            stopLoader();
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            showToast("signInWithEmail:success");
                            showHomeFragment();

                        } else {
                            stopLoader();
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            showToast("" + task.getException());
//                            Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }

    public void signUpWithNewuser(String email, String passWord) {

        if (email == null || email.isEmpty() || passWord == null || passWord.isEmpty()) {
            showToast(getString(R.string.blank_mail_pass));
            return;
        }
        showLoader(false);
        mAuth.createUserWithEmailAndPassword(email, passWord)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            stopLoader();
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            showToast("UserWithEmail:success");
                            showSignInFragment();

                        } else {
                            stopLoader();
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            showToast("" + task.getException().getMessage());
                        }


                    }
                });
    }


    public void showAskForDecision() {
//        AskForDecision loginFragment = new AskForDecision();
//
//        getSupportFragmentManager().beginTransaction()
//                .addToBackStack(AskForDecision.TAG)
//                .replace(R.id.all_fragments, loginFragment, AskForDecision.TAG)
//                .commit();
    }


    public FirebaseUser getCurrentUser() {
        if (mAuth != null)
            return mAuth.getCurrentUser();

        return null;
    }

    public void showToast(String msg) {
        Toast.makeText(this, "" + msg, Toast.LENGTH_SHORT).show();
    }

    public void SignOut() {
        if (mAuth != null) {
            mAuth.signOut();
            showToast("sign out succesfully");
        }
    }

}
