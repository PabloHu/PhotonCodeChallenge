package mobile.huaman.photoncodechallenge.challengeactivity;

import java.util.ArrayList;

import mobile.huaman.photoncodechallenge.BasePresenter;
import mobile.huaman.photoncodechallenge.BaseView;

/**
 * Created by Pablo on 12/20/2017.
 */

public interface Contract {
    interface View extends BaseView {
        void matrixOutput(String matrixStatus, int finalCost, ArrayList<Integer> pathway, String sampleId);


        void resultValidMatrixSize(boolean matrixStatus, int[][] createdMatrix);
    }

    interface Presenter extends BasePresenter<View> {
        //   void validateSelection();

        void getMatrixSolution(int[][]matrixInput, int numRow, int numColumn, String sampleId, String criteria);

        void userMatrixInput(String[][]matrixInput);

    }
}
