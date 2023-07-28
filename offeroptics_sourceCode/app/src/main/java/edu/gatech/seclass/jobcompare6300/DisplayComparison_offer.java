package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DisplayComparison_offer extends AppCompatActivity {
    private Button returnToMain;
    private Button reCompare;
    private TextView job1_titleID;
    private TextView job1_companyID;
    private TextView job1_locationID;
    private TextView job1_yearlySalaryID;
    private TextView job1_yearlyBonusID;
    private TextView job1_leaveID;
    private TextView job1_maternityID;
    private TextView job1_lifeInsuranceID;

    private TextView job2_titleID;
    private TextView job2_companyID;
    private TextView job2_locationID;
    private TextView job2_yearlySalaryID;
    private TextView job2_yearlyBonusID;
    private TextView job2_leaveID;
    private TextView job2_maternityID;
    private TextView job2_lifeInsuranceID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_comparison);

        // Initialize TextViews
        job1_titleID = findViewById(R.id.job1_titleID);
        job1_companyID = findViewById(R.id.job1_companyID);
        job1_locationID = findViewById(R.id.job1_locationID);
        job1_yearlySalaryID = findViewById(R.id.job1_yearlySalaryID);
        job1_yearlyBonusID = findViewById(R.id.job1_yearlyBonusID);
        job1_leaveID = findViewById(R.id.job1_leaveID);
        job1_maternityID = findViewById(R.id.job1_maternityID);
        job1_lifeInsuranceID = findViewById(R.id.job1_lifeInsuranceID);

        job2_titleID = findViewById(R.id.job2_titleID);
        job2_companyID = findViewById(R.id.job2_companyID);
        job2_locationID = findViewById(R.id.job2_locationID);
        job2_yearlySalaryID = findViewById(R.id.job2_yearlySalaryID);
        job2_yearlyBonusID = findViewById(R.id.job2_yearlyBonusID);
        job2_leaveID = findViewById(R.id.job2_leaveID);
        job2_maternityID = findViewById(R.id.job2_maternityID);
        job2_lifeInsuranceID = findViewById(R.id.job2_lifeInsuranceID);

        returnToMain = findViewById(R.id.button_ReturnToMain);
        reCompare = findViewById(R.id.button_ReCompare);

        returnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayComparison_offer.this, MainActivity.class);
                startActivity(intent);
            }
        });
        reCompare.setEnabled(false);
        reCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayComparison_offer.this, DisplayComparison_offer.class);
                startActivity(intent);
            }
        });


        // Retrieve the selected checkbox indices from the intent
//        Intent intent = getIntent();
//        int checkboxIndex1 = intent.getIntExtra("checkboxIndex1", 0);
//        int checkboxIndex2 = intent.getIntExtra("checkboxIndex2", 0);

        // Read "jobs.txt" and populate the TextViews based on the selected checkbox index
        readFromFileAndPopulateTextView();
    }

    private int checkJobsLength() throws IOException {
        File directory = new File(getExternalFilesDir(null), "edu.gatech.seclass.jobcompare6300");
        File file = new File(directory, "jobs.txt");
        int Count = 0;
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.readLine() != null) {
                Count++;
            }
        }
        return Count;
    }

    private void readFromFileAndPopulateTextView() {
        try {
            File directory = new File(getExternalFilesDir(null), "edu.gatech.seclass.jobcompare6300");
            File file = new File(directory, "jobs.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int lineCount = 0;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                String flag = attributes[attributes.length - 1];
                if (flag.equals("true")) {
                    String title = attributes[0];
                    String company = attributes[1];
                    String location = attributes[2];
                    String costOfLivingIndex = attributes[3];
                    String yearlySalary = attributes[4];
                    String yearlyBonus = attributes[5];
                    String leave = attributes[6];
                    String maternity = attributes[7];
                    String lifeInsurance = attributes[8];
                    double adjustedYearlySalary = (Double.parseDouble(yearlySalary)*100)/Double.parseDouble(costOfLivingIndex);
                    double adjustedYearlyBonus = (Double.parseDouble(yearlyBonus)*100)/Double.parseDouble(costOfLivingIndex);
                    job1_titleID.setText(title);
                    job1_companyID.setText(company);
                    job1_locationID.setText(location);
                    job1_yearlySalaryID.setText(String.valueOf(adjustedYearlySalary));
                    job1_yearlyBonusID.setText(String.valueOf(adjustedYearlyBonus));
                    job1_leaveID.setText(leave);
                    job1_maternityID.setText(maternity);
                    job1_lifeInsuranceID.setText(lifeInsurance);
                } else if (lineCount == checkJobsLength() - 1) {
                    String title = attributes[0];
                    String company = attributes[1];
                    String location = attributes[2];
                    String costOfLivingIndex = attributes[3];
                    String yearlySalary = attributes[4];
                    String yearlyBonus = attributes[5];
                    String leave = attributes[6];
                    String maternity = attributes[7];
                    String lifeInsurance = attributes[8];
                    double adjustedYearlySalary = (Double.parseDouble(yearlySalary)*100)/Double.parseDouble(costOfLivingIndex);
                    double adjustedYearlyBonus = (Double.parseDouble(yearlyBonus)*100)/Double.parseDouble(costOfLivingIndex);
                    job2_titleID.setText(title);
                    job2_companyID.setText(company);
                    job2_locationID.setText(location);
                    job2_yearlySalaryID.setText(String.valueOf(adjustedYearlySalary));
                    job2_yearlyBonusID.setText(String.valueOf(adjustedYearlyBonus));
                    job2_leaveID.setText(leave);
                    job2_maternityID.setText(maternity);
                    job2_lifeInsuranceID.setText(lifeInsurance);
                }
                lineCount++;
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





