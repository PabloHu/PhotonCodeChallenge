package mobile.huaman.photoncodechallenge.challengeactivity;

import java.util.ArrayList;

/**
 * Created by Pablo on 12/20/2017.
 */

public class Presenter implements Contract.Presenter {
    private static final String TAG = "Presenter";
    Contract.View view;
    ArrayList<Integer> pathwayLocation = new ArrayList<>();
    int columnCounter = 0;

    @Override
    public void attachView(Contract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    public int getInitialMinValueLocationFirstRow(int[][] cost) {

        int minValue = cost[0][0];
        int initialMinValueLocation = 0;
        for (int i = 0; i < cost.length; i++) {
            if (cost[i][0] < minValue) {
                initialMinValueLocation = i;
                minValue = cost[i][0];
            }
        }
        pathwayLocation.add(initialMinValueLocation + 1);
        return initialMinValueLocation;
    }

    private void findPath(int[][] cost, int currentRow, int currentColumn, int currentLowestCost, String sampleId, String criteria) {
        int upCost = 0, upRightCost = 0, rightCost = 0, downRightCost = 0, downCost = 0;
        int testingLowestCost = currentLowestCost;
        int testingLowestRow = currentRow;
        int testingLowestColumn = currentColumn;

        int testingRow = 0, testingColumn = 0;

        if (cost[0].length > 1) {
            //up right
            try {
                testingRow = currentRow - 1;
                testingColumn = currentColumn + 1;
                upRightCost = cost[currentRow - 1][currentColumn + 1];
                testingLowestCost = cost[currentRow - 1][currentColumn + 1];
            } catch (Exception e) {
                testingRow = (cost.length - 1);
                upRightCost = cost[testingRow][testingColumn];
                testingLowestCost = cost[testingRow][testingColumn];
            }
            testingLowestCost = cost[testingRow][testingColumn];
            testingLowestRow = testingRow;
            testingLowestColumn = testingColumn;

            //right
            try {
                testingRow = currentRow;
                testingColumn = currentColumn + 1;
                rightCost = cost[testingRow][testingColumn];
            } catch (Exception e) {
            }
            if (testingLowestCost > cost[testingRow][testingColumn]) {
                testingLowestCost = cost[testingRow][testingColumn];
                testingLowestRow = testingRow;
                testingLowestColumn = testingColumn;
            }
            //down right{
            try {
                testingRow = currentRow + 1;
                testingColumn = currentColumn + 1;
                downRightCost = cost[testingRow][testingColumn];
            } catch (Exception e) {
                testingRow = 0;
                testingColumn = currentColumn + 1;
                downRightCost = cost[testingRow][testingColumn];
            }

            if (testingLowestCost > cost[testingRow][testingColumn]) {
                testingLowestCost = cost[testingRow][testingColumn];
                testingLowestRow = testingRow;
                testingLowestColumn = testingColumn;
            }
            cost[testingLowestRow][testingLowestColumn] = testingLowestCost + currentLowestCost;
            pathwayLocation.add(testingLowestRow + 1);
        }

        columnCounter++;
        if (columnCounter < cost[0].length - 1)
            findPath(cost, testingLowestRow, testingLowestColumn, cost[testingLowestRow][testingLowestColumn], sampleId, criteria);
        else {
            String matrixStatus = "";
            if (criteria.equals("none"))
                matrixStatus = "YES";
            if (criteria.equals("<50"))
                if (cost[testingLowestRow][testingLowestColumn] > 50)
                    matrixStatus = "NO";
                else
                    matrixStatus = "YES";
            if (criteria.equals("Start>50")) {
                if (cost[0][pathwayLocation.get(0)] > 50)
                    matrixStatus = "YES";
                else
                    matrixStatus = "NO";
            }
            if (criteria.equals("oneValue>50")) {
                matrixStatus = "NO";
                for (int i = 0; i < cost.length; i++) {
                    for (int j = 0; j < cost[0].length; j++) {
                        if (cost[i][j] > 50)
                            matrixStatus = "YES";
                    }
                }
            }
            view.matrixOutput(matrixStatus, cost[testingLowestRow][testingLowestColumn], pathwayLocation, sampleId);
        }
    }

    private void initialSetUp(int[][] cost, int row, int column, String sampleId, String criteria) {
        int initialRow = getInitialMinValueLocationFirstRow(cost);
        findPath(cost, initialRow, 0, cost[initialRow][0], sampleId, criteria);
    }

    @Override
    public void getMatrixSolution(int[][] matrixInput, int numRow, int numColumn, String sampleId, String criteria) {
        pathwayLocation.clear();
        this.columnCounter = 0;
        initialSetUp(matrixInput, numRow, numColumn, sampleId, criteria);
    }

    public String getSomething(String a){

        return a;
    }

}

