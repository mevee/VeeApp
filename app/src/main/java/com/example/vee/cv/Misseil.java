package com.example.vee.cv;

import android.graphics.Paint;
import android.graphics.Point;

import java.util.Random;

public class Misseil {
    private int random;
    private int stratP;
    private int stopP;
    private Paint paint;
    private final Point position;

    public Misseil(int random, int stratP, int stopP, Paint paint) {
        this.random = random;
        this.stratP = stratP;
        this.stopP = stopP;
        this.paint = paint;
        this.position = new Point();
    }

    private void move(int width, int height) {
//        double x = position.x + (increment * Math.cos(angle));
//        double y = position.y + (increment * Math.sin(angle));

//        angle += random.getRandom(-ANGLE_SEED, ANGLE_SEED) / ANGLE_DIVISOR;

//        position.set((int) x, (int) y);

//        if (!isInside(width, height)) {
//            reset(width);
//        }
    }

//    private boolean isInside(int width, int height) {
//        int x = position.x;
//        int y = position.y;
//        return x >= -flakeSize - 1 && x + flakeSize <= width && y >= -flakeSize - 1 && y - flakeSize < height;
//    }

    public static Misseil create(int startpoint, int endPoint, Paint paint) {
        Random random = new Random(startpoint);

        return new Misseil(random.nextInt(), startpoint, endPoint, paint);
    }
}
