package jdebu.github.io.cobrarenta.home.presenter;

import jdebu.github.io.cobrarenta.home.view.IProgressBarView;

/**
 * Created by jose on 17/08/15.
 */
public class ProgressBarPresenter {
    IProgressBarView iProgressBarView;

    public ProgressBarPresenter(IProgressBarView iProgressBarView) {
        this.iProgressBarView = iProgressBarView;
    }

    public void setProgressBarVisiblity(int visiblity){
        iProgressBarView.setProgressBarVisibility(visiblity);
    }
}
