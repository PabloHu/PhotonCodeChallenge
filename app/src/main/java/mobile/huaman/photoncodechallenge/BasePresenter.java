package mobile.huaman.photoncodechallenge;

/**
 * Created by Pablo on 12/20/2017.
 */

public interface BasePresenter <V extends BaseView> {
    void attachView(V view);
    void detachView();
}