package jp.pokkyun.mogura;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by bemax_ap01 on 2016/12/10.
 *
 */

public class Mole1 extends Mole{

    public Mole1(Context context, ImageView target, int height) {
        super(context, target);
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.mole1);
        animator = ObjectAnimator.ofFloat(target, "translationY", 0, -height, 0);
        animator.setDuration(1000);
        //animator.setInterpolator(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.d("touch","touch");
        return false;
    }

    @Override
    public float getInterpolation(float v) {

       // if (v < 2.0 / 3.0){
       //     v = 0;
       // }else{
            v = 3 * v - 2;
       // }

        return v;
    }
}