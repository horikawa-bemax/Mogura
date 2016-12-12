package jp.pokkyun.mogura;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * A placeholder fragment containing a simple view.
 *
 */
public class MainActivityFragment extends Fragment implements  Runnable{
    RelativeLayout baseLayout;
    Mole[] moles;
    Hole[] holes;

    public MainActivityFragment() {
        moles = new Mole[6];
        holes = new Hole[9];
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        baseLayout = (RelativeLayout)view.findViewById(R.id.content_main);
        final ViewTreeObserver observer = baseLayout.getViewTreeObserver();

        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int w = (baseLayout.getWidth()-100) / 3;
                int h = (baseLayout.getHeight()-100) / 3;

                for(int i=0; i<9; i++){
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(w, h);
                    params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
                    params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                    params.setMargins((i % 3) * w,(i / 3) * h,0,0);
                    holes[i] = new Hole(baseLayout.getContext());
                    baseLayout.addView(holes[i], params);

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
