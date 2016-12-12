package jp.pokkyun.mogura;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by bemax_ap01 on 2016/12/10.
 */

public abstract class Mole implements View.OnTouchListener, TimeInterpolator{
    protected Bitmap bitmap;
    protected Context context;
    protected ObjectAnimator animator;
    protected int point;
    protected int interbal;

    public Animator getAnimator(View root){
        return animator;
    }

    public Bitmap getBitmap(){
        return bitmap;
    }

    public int getPoint(){
        return point;
    }

    public Mole(Context context, ImageView target) {
        this.context = context;
    }

    public void animInit(){
        Random rnd = new Random();
        int interval = rnd.nextInt(3);
        interval *= 1000;
        animator.setStartDelay(interval);
    }

}

