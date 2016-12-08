package jp.pokkyun.mogura;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements SurfaceHolder.Callback{
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;

    public MainActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        surfaceView = (SurfaceView) view.findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        return view;
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Paint backPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Paint holePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        holePaint.setColor(Color.BLACK);
        holePaint.setStyle(Paint.Style.FILL);
        RectF hole1 = new RectF(100,100,300,200);
        Canvas c = surfaceHolder.lockCanvas();
        c.drawColor(Color.GREEN);
        c.drawOval(hole1, holePaint);
        surfaceHolder.unlockCanvasAndPost(c);
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}
