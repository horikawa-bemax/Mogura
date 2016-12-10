package jp.pokkyun.mogura;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by bemax_ap01 on 2016/12/10.
 */

public abstract class Mole implements View.OnTouchListener{
    protected Bitmap bitmap;
    protected Context context;

    public Mole(Context context) {
        this.context = context;
    }
}
