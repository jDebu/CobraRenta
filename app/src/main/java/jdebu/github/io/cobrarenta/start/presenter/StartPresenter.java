package jdebu.github.io.cobrarenta.start.presenter;

import android.os.Looper;
import android.os.Handler;
import jdebu.github.io.cobrarenta.start.view.IStartView;

/**
 * Created by jose on 16/08/15.
 */
public class StartPresenter {
    IStartView iStartView;
    Handler handler;

    public StartPresenter(IStartView iStartView){
        this.iStartView = iStartView;
        handler = new Handler(Looper.getMainLooper());
    }
    public  void doStart(){
        handler.postDelayed(new Runnable() {
            Boolean bool = true;
            final Boolean result = bool;
            @Override
            public void run() {
                iStartView.OnLoadResult(result);
            }
        },2500);
    }
}
