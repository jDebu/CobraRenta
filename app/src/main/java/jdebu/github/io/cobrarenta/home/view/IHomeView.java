package jdebu.github.io.cobrarenta.home.view;

/**
 * Created by jose on 17/08/15.
 */
public interface IHomeView {
    public void OnHomeResult(Boolean result, int errorType);
    public void setErrorType(int tipo);
}
