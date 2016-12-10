package jp.pokkyun.mogura;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by bemax_ap01 on 2016/12/10.
 */

public class Mole1 extends Mole{

    public Mole1(Context context) {
        super(context);
        bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.mole1);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.d("touch","touch");
        return false;
    }
}
