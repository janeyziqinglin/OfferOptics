package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;

public class AdjustComparisonSetting extends AppCompatActivity {
    private EditText yearlySalaryWeightID;
    private EditText yearlyBonusWeightID;
    private EditText leaveWeightID;
    private EditText maternityLeaveWeightID;
    private EditText lifeInsuranceWeightID;
    private Button saveWeightButtonID;
    private Button returnToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjust_comparison_setting);
        yearlySalaryWeightID = (EditText) findViewById(R.id.yearlySalaryWeightID);
        yearlyBonusWeightID = (EditText) findViewById(R.id.yearlyBonusWeightID);
        leaveWeightID = (EditText) findViewById(R.id.leaveWeightID);
        maternityLeaveWeightID = (EditText) findViewById(R.id.maternityLeaveWeightID);
        lifeInsuranceWeightID = (EditText) findViewById(R.id.lifeInsuranceWeightID);
        returnToMain = (Button) findViewById(R.id.button_ReturnToMain);
        saveWeightButtonID = (Button) findViewById(R.id.saveWeightButtonID);
        returnToMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                saveButton();
                Intent intent = new Intent(AdjustComparisonSetting.this,MainActivity.class);
                startActivity(intent);
            }
        });
        saveWeightButtonID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean valid1 = validateYearlySalary();
                boolean valid2 = validateYearlyBonus();
                boolean valid3 = validateLeave();
                boolean valid4 = validateMaternityLeave();
                boolean valid5 = validateLifeInsurance();

                if ( valid1 == true && valid2 == true && valid3 == true && valid4 == true && valid5 == true){
                    saveButton();
                    Intent intent = new Intent(AdjustComparisonSetting.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        readComparisonFromFileAndPopulateTextView();

    }

    private boolean validateYearlySalary() {
        String yearlySalaryWeight_str = String.valueOf(yearlySalaryWeightID.getText());
        try {
            int yearlySalaryWeight = Integer.parseInt(String.valueOf(yearlySalaryWeightID.getText()));
            if ( yearlySalaryWeight < 1 || yearlySalaryWeight > 10 ) {
                yearlySalaryWeightID.setError("Please enter an integer between 1 and 10");
                return false;
            }
        } catch (NumberFormatException e) {
            yearlySalaryWeightID.setError("Please enter an integer");
            return false;
        }
        if (yearlySalaryWeight_str.length() == 0 ){
            yearlySalaryWeightID.setError("Please enter Yearly Salary Weight");
            return false;
        }
        else {
            yearlySalaryWeightID.setError(null);
            return true;
        }
    }

    private boolean validateYearlyBonus() {
        String yearlyBonusWeight_str = String.valueOf(yearlyBonusWeightID.getText());
        try {
            int yearlyBonusWeight = Integer.parseInt(String.valueOf(yearlyBonusWeightID.getText()));
            if ( yearlyBonusWeight < 1 || yearlyBonusWeight > 10 ) {
                yearlyBonusWeightID.setError("Please enter an integer between 1 and 10");
                return false;
            }
        } catch (NumberFormatException e) {
            yearlyBonusWeightID.setError("Please enter an integer");
            return false;
        }
        if (yearlyBonusWeight_str.isEmpty()){
            yearlyBonusWeightID.setError("Please enter Yearly Bonus Weight");
            return false;
        }
        else {
            yearlyBonusWeightID.setError(null);
            return true;
        }
    }

    private boolean validateLeave() {
        String leaveWeight_str = String.valueOf(leaveWeightID.getText());
        try {
            int leaveWeight = Integer.parseInt(String.valueOf(leaveWeightID.getText()));
            if ( leaveWeight < 1 || leaveWeight > 10 ) {
                leaveWeightID.setError("Please enter an integer between 1 and 10");
                return false;
            }
        } catch (NumberFormatException e) {
            leaveWeightID.setError("Please enter an integer");
            return false;
        }
        if (leaveWeight_str.isEmpty()){
            leaveWeightID.setError("Please enter Leave Weight");
            return false;
        }
        else {
            leaveWeightID.setError(null);
            return true;
        }
    }

    private boolean validateMaternityLeave() {
        String maternityLeaveWeight_str = String.valueOf(maternityLeaveWeightID.getText());
        try {
            int maternityLeaveWeight = Integer.parseInt(String.valueOf(maternityLeaveWeightID.getText()));
            if ( maternityLeaveWeight < 1 || maternityLeaveWeight > 10 ) {
                maternityLeaveWeightID.setError("Please enter an integer between 1 and 10");
                return false;
            }
        } catch (NumberFormatException e) {
            maternityLeaveWeightID.setError("Please enter an integer");
            return false;
        }
        if (maternityLeaveWeight_str.isEmpty()){
            maternityLeaveWeightID.setError("Please enter Maternity Leave Weight");
            return false;
        }
        else {
            maternityLeaveWeightID.setError(null);
            return true;
        }
    }
    private boolean validateLifeInsurance() {
        String lifeInsuranceWeight_str = String.valueOf(lifeInsuranceWeightID.getText());
        try {
            int lifeInsuranceWeight = Integer.parseInt(String.valueOf(lifeInsuranceWeightID.getText()));
            if ( lifeInsuranceWeight < 1 || lifeInsuranceWeight > 10 ) {
                lifeInsuranceWeightID.setError("Please enter an integer between 1 and 10");
                return false;
            }
        } catch (NumberFormatException e) {
            lifeInsuranceWeightID.setError("Please enter an integer");
            return false;
        }
        if (lifeInsuranceWeight_str.isEmpty()){
            lifeInsuranceWeightID.setError("Please enter Life Insurance Weight");
            return false;
        }
        else {
            lifeInsuranceWeightID.setError(null);
            return true;
        }
    }
    private void readComparisonFromFileAndPopulateTextView() {
        try {
            File directory = new File(getExternalFilesDir(null), "edu.gatech.seclass.jobcompare6300");
            File file = new File(directory, "compare.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            reader.close();

            if (line != null) {
                String[] weights = line.split(",");

                if (weights.length >= 5) {
                    // Set the weights to the TextViews
                    yearlySalaryWeightID.setText(weights[0]);
                    yearlyBonusWeightID.setText(weights[1]);
                    leaveWeightID.setText(weights[2]);
                    maternityLeaveWeightID.setText(weights[3]);
                    lifeInsuranceWeightID.setText(weights[4]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void saveButton() {
        // Get the weight values from the input fields
        int yearlySalaryWeight = Integer.parseInt(yearlySalaryWeightID.getText().toString());
        int yearlyBonusWeight = Integer.parseInt(yearlyBonusWeightID.getText().toString());
        int leaveWeight = Integer.parseInt(leaveWeightID.getText().toString());
        int maternityLeaveWeight = Integer.parseInt(maternityLeaveWeightID.getText().toString());
        int lifeInsuranceWeight = Integer.parseInt(lifeInsuranceWeightID.getText().toString());

        // Create a comparison string using the weight values
        String comparisonString = yearlySalaryWeight + "," + yearlyBonusWeight + "," +
                leaveWeight + "," + maternityLeaveWeight + "," + lifeInsuranceWeight;

        // Save the comparison string to compare.txt
        saveComparisonToTextFile(comparisonString);
    }

    private void saveComparisonToTextFile(String comparisonString) {
        try {
            File directory = new File(getExternalFilesDir(null), "edu.gatech.seclass.jobcompare6300");
            if (!directory.exists()) {
                directory.mkdirs();
            }
            File file = new File(directory, "compare.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            // Update the TextView values
            String yearlySalaryWeight = yearlySalaryWeightID.getText().toString();
            String yearlyBonusWeight = yearlyBonusWeightID.getText().toString();
            String leaveWeight = leaveWeightID.getText().toString();
            String maternityLeaveWeight = maternityLeaveWeightID.getText().toString();
            String lifeInsuranceWeight = lifeInsuranceWeightID.getText().toString();

            // Set the updated values to the comparison string
            comparisonString = yearlySalaryWeight + "," + yearlyBonusWeight + "," +
                    leaveWeight + "," + maternityLeaveWeight + "," + lifeInsuranceWeight;

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(comparisonString); // Write the updated comparison string to the file
            outputStreamWriter.close();
            fileOutputStream.close();

            // Print a success message
            System.out.println("Comparison saved successfully!");
            // Print the file path for verification
            System.out.println("File path: " + file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    private void saveComparisonToTextFile(String comparisonString) {
//        try {
//            File directory = new File(getExternalFilesDir(null), "edu.gatech.seclass.jobcompare6300");
//            if (!directory.exists()) {
//                directory.mkdirs();
//            }
//            File file = new File(directory, "compare.txt");
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            FileOutputStream fileOutputStream = new FileOutputStream(file);
//            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
//            outputStreamWriter.write(comparisonString); // Write the comparison string to the file
//            outputStreamWriter.close();
//            fileOutputStream.close();
//
//            // Print a success message
//            System.out.println("Comparison saved successfully!");
//            // Print the file path for verification
//            System.out.println("File path: " + file.getAbsolutePath());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}