package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnterJobDetailsn extends AppCompatActivity {
    private EditText curTitleID;
    private EditText curCompanyID;
    private EditText curLocationID;
    private EditText curCostOfLivingID;
    private EditText curYearlySalaryID;
    private EditText curYearlyBonusID;
    private EditText curLeaveID;
    private EditText curMaternityLeaveID;
    private EditText curLifeInsuranceID;
    private Button saveJobButtonID;
    private Button cancelJobButtonID;

    private List<Job> jobs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_job_details);
//        System.out.println("on create saved");
        curTitleID = (EditText) findViewById(R.id.curTitleID);
        curCompanyID = (EditText) findViewById(R.id.curCompanyID);
        curLocationID = (EditText) findViewById(R.id.curLocationID);
        curCostOfLivingID = (EditText) findViewById(R.id.curCostOfLivingID);
        curYearlySalaryID = (EditText) findViewById(R.id.curYearlySalaryID);
        curYearlyBonusID = (EditText) findViewById(R.id.curYearlyBonusID);
        curLeaveID = (EditText) findViewById(R.id.curLeaveID);
        curMaternityLeaveID = (EditText) findViewById(R.id.curMaternityLeaveID);
        curLifeInsuranceID = (EditText) findViewById(R.id.curLifeInsuranceID);
        saveJobButtonID = findViewById(R.id.saveJobButtonID);
        cancelJobButtonID = findViewById(R.id.cancelJobButtonID);
        saveJobButtonID.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!validateTitle()|!validateCompany()|!validateLocation()|!validateCostOfLiving()
                        |!validateSalary()|!validateBonus()|!validateLeave()|!validateMaternity()|!validateInsurance()){
                    return;
                }
                saveButton();
                Intent intent = new Intent(EnterJobDetailsn.this, MainActivity.class);
                startActivity(intent);
            }
        });
        cancelJobButtonID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EnterJobDetailsn.this, MainActivity.class);
                startActivity(intent);
            }
        });
        // Fill up TextView if curJob is true
        readFromFileAndPopulateTextView();
    };

    private void readFromFileAndPopulateTextView() {
        try {
            File directory = new File(getExternalFilesDir(null), "edu.gatech.seclass.jobcompare6300");
            File file = new File(directory, "jobs.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                if (attributes.length >= 12 && Boolean.parseBoolean(attributes[11].trim())) {
                    // Set the attributes to the TextView
                    curTitleID.setText(attributes[0]);
                    curCompanyID.setText(attributes[1]);
                    curLocationID.setText(attributes[2]);
                    curCostOfLivingID.setText(attributes[3]);
                    curYearlySalaryID.setText(attributes[4]);
                    curYearlyBonusID.setText(attributes[5]);
                    curLeaveID.setText(attributes[6]);
                    curMaternityLeaveID.setText(attributes[7]);
                    curLifeInsuranceID.setText(attributes[8]);
                    break; // Stop reading after finding the first line with curJob=true
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveButton() {
        String curTitle = String.valueOf(curTitleID.getText());
        String curCompany = String.valueOf(curCompanyID.getText());
        String curLocation = String.valueOf(curLocationID.getText());
        int curCostOfLiving = Integer.parseInt(String.valueOf(curCostOfLivingID.getText()));
        double curYearlySalary = Double.parseDouble(String.valueOf(curYearlySalaryID.getText()));
        double curYearlyBonus = Double.parseDouble(String.valueOf(curYearlyBonusID.getText()));
        int curLeave = Integer.parseInt(String.valueOf(curLeaveID.getText()));
        int curMaternityLeave = Integer.parseInt(String.valueOf(curMaternityLeaveID.getText()));
        int curLifeInsurance = Integer.parseInt(String.valueOf(curLifeInsuranceID.getText()));

        // Check if current job already exists in the list
        Job existingJob = findExistingJob();
        if (existingJob != null) {
            // Edit the existing job attributes
            existingJob.setTitle(curTitle);
            existingJob.setCompany(curCompany);
            existingJob.setLocation(curLocation);
            existingJob.setCostOfLivingIndex(curCostOfLiving);
            existingJob.setYearlySalary(curYearlySalary);
            existingJob.setYearlyBonus(curYearlyBonus);
            existingJob.setLeave(curLeave);
            existingJob.setMaternityPaternityLeave(curMaternityLeave);
            existingJob.setLifeInsurancePercentage(curLifeInsurance);
        } else {
            //if curJob does not exist
            // Create a new job object
            Job curJob = new Job(curTitle, curCompany, curLocation,
                    curCostOfLiving, curYearlySalary, curYearlyBonus,
                    curLeave, curMaternityLeave, curLifeInsurance);
            curJob.setCurJob(true);
            jobs.add(curJob);
        }
        //calling helper function to save results to jobs.txt
        saveJobsToTextFile();

    }

    private Job findExistingJob() {
        for (Job job : jobs) {
            if (job.isCurJob()) {
                return job;
            }
        }
        return null;
    }

    private void saveJobsToTextFile() {
        try {
            File directory = new File(getExternalFilesDir(null), "edu.gatech.seclass.jobcompare6300");
            if (!directory.exists()) {
                directory.mkdirs();
            }
            File file = new File(directory, "jobs.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            List<String> lines = new ArrayList<>();

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                if (attributes.length >= 12 && Boolean.parseBoolean(attributes[11].trim())) {
                    // Skip the line for the current job since it will be updated or replaced
                    continue;
                }
                lines.add(line);
            }
            reader.close();

            // Add the updated or new job entry
            for (Job job : jobs) {
                lines.add(job.toString());
            }

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            for (String lineToAdd : lines) {
                outputStreamWriter.append(lineToAdd); // Append the line to the file
                outputStreamWriter.append("\n"); // create a new line for the next job
            }
            outputStreamWriter.close();
            fileOutputStream.close();

            // Print a success message
            System.out.println("Jobs saved successfully!");
            // Print the file path for verification
            System.out.println("File path: " + file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean validateTitle(){
        String curTitle = String.valueOf(curTitleID.getText());
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(curTitle);
        if (curTitle.isEmpty()) {
            curTitleID.setError("Please enter the Title");
            return false;
        }
        else if (matcher.find()) {
            curTitleID.setError("Please remove special characters in Title");
            return false;
        }
        else{
            curTitleID.setError(null);
            return true;
        }
    }
    private boolean validateCompany(){

        String curCompany = String.valueOf(curCompanyID.getText());

        if (curCompany.isEmpty()) {
            curCompanyID.setError("Please enter the Company");
            return false;
        }
        else{
            curCompanyID.setError(null);
            return true;
        }
    }
    private boolean validateLocation(){

        String curLocation = String.valueOf(curLocationID.getText());
        if (curLocation.isEmpty()) {
            curLocationID.setError("Please enter the Location");
            return false;
        }else if (curLocation.contains(",")) {
            curLocationID.setError("Please remove comma ','");
            return false;
        }
        else{
            curLocationID.setError(null);
            return true;
        }
    }

    private boolean validateCostOfLiving(){
        String costOfLeaving = String.valueOf(curCostOfLivingID.getText());
        int index;
        try {
            index =  Integer.parseInt(costOfLeaving);
        } catch (NumberFormatException e) {
            curCostOfLivingID.setError("Invalid Cost Of Leaving");

            return false;
        }

        if(index < 0 || index > 213) {
            curCostOfLivingID.setError("Please enter the correct Cost Of Leaving");
            return false;
        }
        else{
            curCostOfLivingID.setError(null);
            return true;
        }
    }
    private boolean validateSalary(){
        String salary = String.valueOf(curYearlySalaryID.getText());
        double yearlySalary;
        try {
            yearlySalary =  Double.parseDouble(salary);
        } catch (NumberFormatException e) {
            curYearlySalaryID.setError("Please enter the Salary");

            return false;
        }

        if(yearlySalary < 0 ) {
            curYearlySalaryID.setError("Must be positive decimal value");
            return false;
        }
        else{
            curYearlySalaryID.setError(null);
            return true;
        }

    }
    private boolean validateBonus(){
        String bonus = String.valueOf(curYearlyBonusID.getText());
        double yearlyBonus;
        try {
            yearlyBonus =  Double.parseDouble(bonus);
        } catch (NumberFormatException e) {
            curYearlyBonusID.setError("Please enter the Bonus");

            return false;
        }

        if(yearlyBonus < 0 ) {
            curYearlyBonusID.setError("Must be positive decimal value");
            return false;
        }
        else{
            curYearlyBonusID.setError(null);
            return true;
        }
    }
    private boolean validateLeave(){
        String leave = String.valueOf(curLeaveID.getText());
        int leaveInt;
        try {
            leaveInt =  Integer.parseInt(leave);
        } catch (NumberFormatException e) {
            curLeaveID.setError("Please enter the Leave");

            return false;
        }

        if(leaveInt < 0 || leaveInt > 30) {
            curLeaveID.setError("Must be between 0 and 30");
            return false;
        }
        else{
            curLeaveID.setError(null);
            return true;
        }
    }

    private boolean validateMaternity(){
        String maternity = String.valueOf(curMaternityLeaveID.getText());
        int maternityLeave;
        try {
            maternityLeave =  Integer.parseInt(maternity);
        } catch (NumberFormatException e) {
            curMaternityLeaveID.setError("Please enter the Maternity/Paternity Leave");

            return false;
        }

        if(maternityLeave < 0 || maternityLeave > 20) {
            curMaternityLeaveID.setError("Must be between 0 and 20");
            return false;
        }
        else{
            curMaternityLeaveID.setError(null);
            return true;
        }

    }
    private boolean validateInsurance(){
        String insurance = String.valueOf(curLifeInsuranceID.getText());
        int lifeInsurance;
        try {
            lifeInsurance =  Integer.parseInt(insurance);
        } catch (NumberFormatException e) {
            curLifeInsuranceID.setError("Please enter the Life Insurance");

            return false;
        }


        if(lifeInsurance < 0 || lifeInsurance > 10) {
            curLifeInsuranceID.setError("Must be between 0 and 10");
            return false;
        }
        else{
            curLifeInsuranceID.setError(null);
            return true;
        }

    }



}