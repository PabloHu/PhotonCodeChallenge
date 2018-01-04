package mobile.huaman.photoncodechallenge;

import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;

import mobile.huaman.photoncodechallenge.challengeactivity.Contract;
import mobile.huaman.photoncodechallenge.challengeactivity.MainActivity;
import mobile.huaman.photoncodechallenge.challengeactivity.Presenter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Pablo on 1/4/2018.
 */

public class PresenterTest implements Contract.View{

    private static final String TAG = "PresenterTest";
    private Presenter presenter;
    ArrayList<Integer> pathwayLocation = new ArrayList<>();
    ArrayList<Integer> pathwayExpected = new ArrayList<>();

    @Before
    public void setup(){
        presenter = new Presenter();
        presenter.attachView(this);
    }


    @Test
    public  void simpleTest(){

       String actual = presenter.getSomething("hello");
       String expected = "hello";
       assertEquals("Fail", expected,actual);

    }
    @Test
    public  void sample1(){

        // Sample 1 NOT WORKING
        int[][] sample1 =
                {
                        {3, 4, 1, 2, 8, 6},
                        {6, 1, 8, 2, 7, 4},
                        {5, 9, 3, 9, 9, 5},
                        {8, 4, 1, 3, 2, 6},
                        {3, 7, 2, 8, 6, 4}
                };
        pathwayExpected.add(1);
        pathwayExpected.add(2);
        pathwayExpected.add(3);
        pathwayExpected.add(4);
        pathwayExpected.add(4);
        pathwayExpected.add(5);



        String criteria = "none";
        int numRow = sample1.length;
        int numColumn = sample1[0].length;
        presenter.getMatrixSolution(sample1, numRow, numColumn, "Sample 1", criteria);


        assertEquals("Fail", pathwayLocation,pathwayExpected );
    }

    @Test
    public  void sample2(){

        // Sample 2
        int[][] sample2 =
                {
                        {3, 4, 1, 2, 8, 6},
                        {6, 1, 8, 2, 7, 4},
                        {5, 9, 3, 9, 9, 5},
                        {8, 4, 1, 3, 2, 6},
                        {3, 7, 2, 1, 2, 3}
                };
        pathwayExpected.clear();
        pathwayExpected.add(1);
        pathwayExpected.add(2);
        pathwayExpected.add(1);
        pathwayExpected.add(5);
        pathwayExpected.add(4);
        pathwayExpected.add(5);



        String criteria = "none";
        int numRow = sample2.length;
        int numColumn = sample2[0].length;
        presenter.getMatrixSolution(sample2, numRow, numColumn, "Sample 2", criteria);


        assertEquals("Fail", pathwayExpected, pathwayLocation );
    }

    @Override
    public void showError(String s) {

    }



    @Override
    public void matrixOutput(String matrixStatus, int finalCost, ArrayList<Integer> pathway, String sampleId) {
        pathwayLocation =pathway;
    }
}
