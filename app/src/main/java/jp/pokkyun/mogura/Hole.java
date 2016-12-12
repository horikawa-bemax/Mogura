package jp.pokkyun.mogura;

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
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.Random;

/**
 * Created by bemax_ap01 on 2016/12/10.
 */

public class Hole extends RelativeLayout{
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

        int width = right - left;
        int height = buttom - top;
        int mbWidth = width * 7 / 10;
        int mbHeight = height * 5 / 6;
        int horizon = mbHeight;
        if(mbWidth < mbHeight){
            mbHeight = mbWidth;
        }else{
            mbWidth = mbHeight;
        }
        int holeWidth = width * 8 / 10;
        int holeHeight = height / 3;
        int holeTop = horizon - holeHeight / 2;
        int holeLeft = width / 10;

        Log.d("width:height","" + width + ":" + height);

        moleBase = new LinearLayout(getContext());
        //moleBase.setBackgroundColor(Color.BLUE);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(mbWidth, mbHeight);
        params.addRule(ALIGN_PARENT_TOP);
        params.addRule(CENTER_IN_PARENT);
        params.setMargins(0,horizon - mbHeight,0,0);
        addView(moleBase, params);

        imageView = new ImageView(getContext());
        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(mbWidth, mbHeight);
        imageParams.setMargins(0,mbHeight,0,0);
        moleBase.addView(imageView, imageParams);

        //Mole set
        Mole mole = new Mole1(getContext(), imageView, mbHeight);
        setMole(mole, getHandler());

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        //canvas.drawColor(Color.RED);
        canvas.drawOval(new RectF(holeLeft, holeTop, holeLeft + holeWidth, holeTop + holeHeight), paint);
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
                Random rand = new Random();
                int startDelay = rand.nextInt(3000);
                mole.animator.setStartDelay(startDelay);
                mole.animator.start();
            }
        });
    }

    public ImageView getMoleView(){
        return imageView;
    }
}
