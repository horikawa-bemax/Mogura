package jp.pokkyun.mogura;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by bemax_ap01 on 2016/12/10.
 */

public class Hole extends LinearLayout{
    private LinearLayout moleBase;
    private ImageView imageView;
    private Mole mole;
    private Handler handler;

    public Hole(Context context) {
        super(context);
    }

    public Hole(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Hole(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int buttom) {
        super.onLayout(changed, left, top, right, buttom);

        if(!changed) return;

        moleBase = new LinearLayout(getContext());
        int w = (right - left) * 6 / 10;
        int h = buttom - top - 40;
        LayoutParams params = new LayoutParams(w, h * 5 / 6);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        addView(moleBase, params);
        imageView = new ImageView(getContext());
        moleBase.addView(imageView);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawOval(new RectF(20, h * 2 / 3, w - 20, h - 20), paint);
        setBackground(new BitmapDrawable(getResources(), bitmap));
    }

    public LinearLayout getMolebase(){
        return moleBase;
    }

    public void setMole(final Mole mole, Handler handler){
        this.mole = mole;

        handler.post(new Runnable() {
            @Override
            public void run() {
                imageView.setImageBitmap(mole.bitmap);
                imageView.setOnTouchListener(mole);
                ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "translationY", 400, 0, 400);
                animator.setDuration(1000);
                animator.setRepeatCount(ObjectAnimator.INFINITE);
                animator.start();
            }
        });
    }

    public ImageView getMoleView(){
        return imageView;
    }
}
