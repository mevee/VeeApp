package com.example.vee.views;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.vee.R;
import com.example.vee.test.FireworkLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentC extends Fragment {
    public static final String TAG = "FragmentC";
    private View mView, btnPlay;
    private FireworkLayout fireworkLayout;
    private int countb;
    private static boolean b;


    public FragmentC() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_fragment_c, container, false);
        fireworkLayout = new FireworkLayout(getContext());
        btnPlay = mView.findViewById(R.id.paly_d);
        final RelativeLayout surface = (RelativeLayout) mView.findViewById(R.id.relativeHolder);

        Log.d(TAG, "child_count" + surface.getChildCount());
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 countb = surface.getChildCount();

                if (FragmentC.b != true) {
                    surface.addView(fireworkLayout);
                    Log.d(TAG, "child_countatA" + surface.getChildCount());
                    FragmentC.b = true;
                }
            }
        });
        btnPlay.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
                dialogBuilder.setTitle("Hellow World");
                dialogBuilder.setCancelable(false);

                dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        RelativeLayout surface = (RelativeLayout) mView.findViewById(R.id.relativeHolder);

                        if (FragmentC.b == true) {
                            surface.removeView(fireworkLayout);
                            Log.d(TAG,"child_countatAR"+surface.getChildCount());
                            FragmentC.b = false;
                        }

                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();


//                firework.surfaceDestroyed(surface.getId());
                return true;
            }
        });
        return mView;
    }

}
