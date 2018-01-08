package mobile.huaman.photoncodechallenge.challengeactivity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mobile.huaman.photoncodechallenge.R;

public class MainActivity extends AppCompatActivity implements Contract.View {
    private static final String TAG = "ActivityTag";
    Presenter presenter = new Presenter();
    Button btnCreateMatrix;
    TextView tvCriteriaResult, tvMatrixResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.attachView(this);
        btnCreateMatrix = (Button) findViewById(R.id.btnCreateMatrix);
        tvCriteriaResult = (TextView) findViewById(R.id.tvCriteriaResult);
        tvMatrixResult = (TextView) findViewById(R.id.tvMatrixResult);

        btnCreateMatrix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gatherInputMatrix();
            }

        });

    }


    @Override
    public void showError(String displayError) {

        Log.d(TAG, "Error: " + displayError);
        tvCriteriaResult.setText(displayError);
    }

    @Override
    public void matrixOutput(String criteriaResult, int finalCost, ArrayList<Integer> pathwayLocation)  {
        String displayPath = "[";
        for (int i = 0; i < pathwayLocation.size(); i++) {
            displayPath += pathwayLocation.get(i);
            if ((i + 1) != pathwayLocation.size())
                displayPath += ", ";
        }
        displayPath += "]";

        tvCriteriaResult.setText(criteriaResult);
        tvMatrixResult.setText(displayPath);
      //  Log.d(TAG, "" + path + "\n");
    }



    private void gatherInputMatrix() {


        LayoutInflater li = LayoutInflater.from(MainActivity.this);
        View promptsView = li.inflate(R.layout.custom_prompt, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                MainActivity.this);


        alertDialogBuilder.setView(promptsView);

        final EditText userInput = (EditText) promptsView
                .findViewById(R.id.etRowInput);


        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Toast.makeText(MainActivity.this, userInput.getText(), Toast.LENGTH_SHORT).show();
                                presenter.userMatrixInput(userInput.getText().toString());
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }
}
