package jdebu.github.io.cobrarenta.home.presenter;


import android.os.Handler;
import android.os.Looper;

import jdebu.github.io.cobrarenta.home.view.IHomeView;

/**
 * Created by jose on 17/08/15.
 */
public class HomePresenter {
    IHomeView iHomeView;
    Handler handler;
    public  HomePresenter(IHomeView iHomeView){
        this.iHomeView= iHomeView;
        handler = new Handler(Looper.getMainLooper());
    }
    public void doHome(String numPiso){
        Boolean bool=true;
        int errorType=0;
        bool=checkError(numPiso);
        errorType=checkErrorType(bool,numPiso);
        final Boolean result = bool;
        final int ErrorType = errorType;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iHomeView.OnHomeResult(result, ErrorType);
            }
        },3000);
    }
    public Boolean checkError(String numPiso){
        Boolean bool=true;
        if (numPiso==null || Integer.parseInt(numPiso) <=0 || Integer.parseInt(numPiso) >4 ){
            bool = false;
        }
        return bool;
    }
    public Integer checkErrorType(boolean bool, String numPiso){
        int errorType=0;
        if (bool==false){
            if (numPiso==null)
                errorType=1;
            else
                errorType=2;
        }
        return errorType;

    }
}
