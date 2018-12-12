package com.example.vee;

import android.graphics.Bitmap;
import android.view.View;

public class ScreenShot {
    public static Bitmap takeScreenShot(View view) {
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache(true);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return bitmap;

    }

    public static Bitmap takeScreenShotOfRootView(View v) {
        return ScreenShot.takeScreenShot(v.getRootView());
    }
}
