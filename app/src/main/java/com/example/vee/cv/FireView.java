package com.example.vee.cv;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class FireView extends View {
    private static final int DELAY = 5;
    private static final int Missiles = 8;


    Paint paint;

    public FireView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
    }

    public FireView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FireView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void resize(int width, int height) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        for (int i = 0; i < Missiles; i++) {

        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        for (int x = 0; x < canvas.getWidth(); x += 2) {
//            canvas.drawLine(x, 0, x, canvas.getHeight(), paint);
//        }
//        canvas.drawLine(0, 100, 0, 0, paint);
        getHandler().postDelayed(runnable, DELAY);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };
}
