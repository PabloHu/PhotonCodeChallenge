package mobile.huaman.photoncodechallenge.challengeactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import mobile.huaman.photoncodechallenge.R;

public class MainActivity extends AppCompatActivity implements Contract.View {
    private static final String TAG = "ActivityTag";
    Presenter presenter = new Presenter();
    Button btnCreateMatrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.attachView(this);
        btnCreateMatrix = (Button)  findViewById(R.id.btnCreateMatrix);


        // Sample 1 NOT WORKING
        int[][] sample1 =
                {
                        {3, 4, 1, 2, 8, 6},
                        {6, 1, 8, 2, 7, 4},
                        {5, 9, 3, 9, 9, 5},
                        {8, 4, 1, 3, 2, 6},
                        {3, 7, 2, 8, 6, 4}
                };
        String criteria = "none";
        int numRow = sample1.length;
        int numColumn = sample1[0].length;
        presenter.getMatrixSolution(sample1, numRow, numColumn, "Sample 1", criteria);


        int[][] sample2 =
                {
                        {3, 4, 1, 2, 8, 6},
                        {6, 1, 8, 2, 7, 4},
                        {5, 9, 3, 9, 9, 5},
                        {8, 4, 1, 3, 2, 6},
                        {3, 7, 2, 1, 2, 3}
                };
        criteria = "none";
        numRow = sample2.length;
        numColumn = sample2[0].length;
        presenter.getMatrixSolution(sample2, numRow, numColumn, "Sample 2", criteria);


        //sample 3
        int[][] sample3 =
                {
                        {19, 10, 19, 10, 19},
                        {21, 23, 20, 19, 12},
                        {20, 12, 20, 11, 10}
                };
        criteria = "<50";
        numRow = sample3.length;
        numColumn = sample3[0].length;
        presenter.getMatrixSolution(sample3, numRow, numColumn, "Sample 3", criteria);


        //sample 4
        int[][] sample4 =
                {
                        {5, 8, 5, 3, 5}
                };
        criteria = "none";
        numRow = sample4.length;
        numColumn = sample4[0].length;
        presenter.getMatrixSolution(sample4, numRow, numColumn, "Sample 4", criteria);


        //sample 5
        int[][] sample5 =
                {
                        {5},
                        {8},
                        {5},
                        {3},
                        {5}
                };
        criteria = "none";
        numRow = sample5.length;
        numColumn = sample5[0].length;
        presenter.getMatrixSolution(sample5, numRow, numColumn, "Sample 5", criteria);

        try {
            //sample 6
            int[][] sample6 =
                    {
                            {5, 4, Integer.parseInt("H")},
                            {8, Integer.parseInt("M"), 7},
                            {5, 7, 5}
                    };
            criteria = "none";
            numRow = sample6.length;
            numColumn = sample6[0].length;
            presenter.getMatrixSolution(sample6, numRow, numColumn, "Sample 6", criteria = "none");
        } catch (Exception e) {
            Log.d(TAG, "sample6:  non numberic input");
        }
        try {
            //sample 7
            int[][] sample7 =
                    {
                            {Integer.parseInt(null)}};
            criteria = "none";
            numRow = sample7.length;
            numColumn = sample7[0].length;
            presenter.getMatrixSolution(sample7, numRow, numColumn, "Sample 7", criteria);
        } catch (Exception e) {
            Log.d(TAG, "sample7: Invalid matrix");
        }

        // sample 8
        int[][] sample8 =
                {
                        {69, 10, 19, 10, 19},
                        {51, 23, 20, 19, 12},
                        {60, 12, 20, 11, 10},

                };
        criteria = "Start>50";
        numRow = sample8.length;
        numColumn = sample8[0].length;
        presenter.getMatrixSolution(sample8, numRow, numColumn, "Sample 8", criteria);

        // sample 9
        int[][] sample9 =
                {
                        {60, 3, 3, 6},
                        {6, 3, 7, 9},
                        {5, 6, 8, 3}

                };
        criteria = "oneValue>50";
        numRow = sample9.length;
        numColumn = sample9[0].length;
        presenter.getMatrixSolution(sample9, numRow, numColumn, "Sample 9", criteria);


        // sample 10
        int[][] sample10 =
                {
                        {6, 3, (-5), 9},
                        {(-5), 2, 4, 10},
                        {3, (-2), 6, 10},
                        {6, (-1), (-2), 10}
                };
        criteria = "none";
        numRow = sample10.length;
        numColumn = sample10[0].length;
        presenter.getMatrixSolution(sample10, numRow, numColumn, "Sample 10", criteria);


        // sample 11
        int[][] sample11 =
                {
                        {51, 51},
                        {0, (51)},
                        {51, 51},
                        {5, 5}

                };
        criteria = "none";
        numRow = sample11.length;
        numColumn = sample11[0].length;
        presenter.getMatrixSolution(sample11, numRow, numColumn, "Sample 11", criteria);

        // sample 12
        int[][] sample12 =
                {
                        {51, 51, 51},
                        {0, (51), 51},
                        {51, 51, 51},
                        {5, 5, 51}

                };
        criteria = "none";
        numRow = sample12.length;
        numColumn = sample12[0].length;
        presenter.getMatrixSolution(sample12, numRow, numColumn, "Sample 12", criteria);

        //sample 13
        int[][] sample13 =
                {
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}

                };
        criteria = "none";
        numRow = sample13.length;
        numColumn = sample13[0].length;
        presenter.getMatrixSolution(sample13, numRow, numColumn, "Sample 13", criteria);
    }

    @Override
    public void showError(String s) {

        Log.d(TAG, "showError: ");
    }
/*
    @Override
    public void updateMatrix(int[] displayIntegerList) {


        String a = "";
        for (int i = 0; i < displayIntegerList.length; i++) {
            if (a.equals(""))
                a += displayIntegerList[i];
            else {
                a += ", " + displayIntegerList[i];
            }
        }

        Toast.makeText(this, "" + a, Toast.LENGTH_SHORT).show();

    }
*/
    @Override
    public void matrixOutput(String matrixStatus, int finalCost, ArrayList<Integer> pathway, String sampleId) {
        Log.d(TAG, "----------\n");
        Log.d(TAG, sampleId);

        Log.d(TAG, "Output:");
        Log.d(TAG, matrixStatus);
        Log.d(TAG, "" + finalCost);
        String path = "[";
        for (int i = 0; i < pathway.size(); i++) {
            path += pathway.get(i);
            if ((i + 1) != pathway.size())
                path += ", ";
        }
        path += "]";
        Log.d(TAG, "" + path + "\n");
    }


}
