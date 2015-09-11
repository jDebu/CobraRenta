package jdebu.github.io.cobrarenta.start.presenter;

import jdebu.github.io.cobrarenta.start.view.IProgressBarView;

/**
 * Created by jose on 16/08/15.
 */
public class ProgressBarPresenter {
    IProgressBarView iProgressBarView;
    public  ProgressBarPresenter(IProgressBarView iProgressBarView){
        this.iProgressBarView=iProgressBarView;
    }
    public void setProgressBarView(int visibility){
        iProgressBarView.setProgressBarVisibility(visibility);
    }

}
