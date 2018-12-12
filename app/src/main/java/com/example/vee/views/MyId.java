package com.example.vee.views;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.vee.R;
import com.example.vee.ScreenShot;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyId extends Fragment {

    public static final String TAG = "MyId";
    private View mView, relativeLayout, btn_ss, rooview;
    private ImageView iv;
    private Bitmap bitmap2;
    private Context context;
    private File file;

    public MyId() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_my_id, container, false);
        context = getContext();
        relativeLayout = mView.findViewById(R.id.relayive_id);
        btn_ss = mView.findViewById(R.id.btn_ss);
        rooview = mView.findViewById(R.id.rootview_id_);
        iv = mView.findViewById(R.id.iv_id);

        btn_ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = ScreenShot.takeScreenShot(relativeLayout);
                iv.setImageBitmap(bitmap);


                if (bitmap != null && context!=null) {
                    saveImage(bitmap);
                    try {

                        file = new File(context.getExternalCacheDir(), "screen_first.png");
                        FileOutputStream fOut = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                        fOut.flush();
                        fOut.close();
                        file.setReadable(true, false);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

            }
        }});

        return mView;
    }

//    public void save() {
//
//        Context context = getContext();
//        if (bitmap2 != null && context != null) {
//            try {
//
//                File file = new File(context.getExternalCacheDir(), "game.png");
//                FileOutputStream fOut = new FileOutputStream(file);
//                bitmap2.compress(Bitmap.CompressFormat.PNG, 100, fOut);
//                fOut.flush();
//                fOut.close();
//                file.setReadable(true, false);
//                return file;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }


    //method to take screen shot of a particular view
    public static Bitmap loadBitmapFromView(View v, int width, int height) {
        Bitmap b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.layout(0, 0, v.getLayoutParams().width, v.getLayoutParams().height);
        v.draw(c);
        return b;
    }

    //method that saves this jpg in memory
    public static void saveImage(Bitmap bitmap) {
        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/req_images");
        myDir.mkdirs();
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "MyId-" + n + ".jpg";
        File file = new File(myDir, fname);
        //  Log.i(TAG, "" + file);
        if (file.exists())
            file.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
