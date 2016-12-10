package jp.pokkyun.mogura;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements  Runnable{
    RelativeLayout baseLayout;
    Mole[] moles;
    Hole[] holes;
    Thread thread;

    public MainActivityFragment() {
        moles = new Mole[6];
        holes = new Hole[6];

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        baseLayout = (RelativeLayout)view.findViewById(R.id.content_main);
        final ViewTreeObserver observer = baseLayout.getViewTreeObserver();
        moles[0] = new Mole1(view.getContext());

        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int w = baseLayout.getWidth();
                int h = baseLayout.getHeight();

                for(int i=0; i<1; i++){
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(w / 3, h / 3);
                    holes[i] = new Hole(baseLayout.getContext());
                    holes[i].setLayoutParams(params);
                    holes[i].setMole(new Mole1(getContext()), new Handler());

                    baseLayout.addView(holes[i]);
                }

                // 繰り返し呼ばれることがあるので、removeしておく
                baseLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

        return view;
    }

    @Override
    public void run() {

    }
}
