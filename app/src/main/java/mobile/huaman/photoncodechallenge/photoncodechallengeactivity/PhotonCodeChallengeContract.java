package mobile.huaman.photoncodechallenge.photoncodechallengeactivity;

import java.util.ArrayList;
import java.util.List;

import mobile.huaman.photoncodechallenge.BasePresenter;
import mobile.huaman.photoncodechallenge.BaseView;

/**
 * Created by Pablo on 12/20/2017.
 */

public interface PhotonCodeChallengeContract {
    interface View extends BaseView {
        void updateMatrix(int[] displayIntegerList);

        void matrixOutput(String matrixStatus, int finalCost, ArrayList<Integer> pathway, String sampleId);



    }

    interface Presenter extends BasePresenter<View> {
        //   void validateSelection();

        void getMatrixSolution(int[][]matrixInput, int numRow, int numColumn, String sampleId, String criteria);


    }
}
