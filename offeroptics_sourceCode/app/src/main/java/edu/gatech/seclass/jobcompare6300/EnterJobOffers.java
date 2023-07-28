package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.os.Environment;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnterJobOffers extends AppCompatActivity {

    private EditText titleID;
    private EditText companyID;
    private EditText locationID;
    private EditText costOfLivingID;
    private EditText yearlySalaryID;
    private EditText yearlyBonusID;
    private EditText leaveID;
    private EditText maternityLeaveID;
    private EditText lifeInsuranceID;
    private Button saveOfferButtonID;
    private Button returnToMain;
    private Button displayComparison;
    private Button enterNewOffer;

    private List<Job> jobs = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_job_offers);
        titleID = (EditText) findViewById(R.id.titleID);
        companyID = (EditText) findViewById(R.id.companyID);
        locationID = (EditText) findViewById(R.id.locationID);
        costOfLivingID = (EditText) findViewById(R.id.costOfLivingID);
        yearlySalaryID = (EditText) findViewById(R.id.yearlySalaryID);
        yearlyBonusID = (EditText) findViewById(R.id.yearlyBonusID);
        leaveID = (EditText) findViewById(R.id.leaveID);
        maternityLeaveID = (EditText) findViewById(R.id.maternityLeaveID);
        lifeInsuranceID = (EditText) findViewById(R.id.lifeInsuranceID);
        returnToMain = (Button) findViewById(R.id.button_ReturnToMain);
        displayComparison = (Button) findViewById(R.id.button_displayComparison);
        saveOfferButtonID = (Button) findViewById(R.id.saveOfferButtonID);
        enterNewOffer = (Button) findViewById(R.id.button_enterNewOffer);
        displayComparison.setEnabled(false);
        returnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EnterJobOffers.this, MainActivity.class);
                startActivity(intent);
            }
        });
        displayComparison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EnterJobOffers.this, DisplayComparison_offer.class);
                startActivity(intent);
            }
        });

        saveOfferButtonID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateTitle()|!validateCompany()|!validateLocation()|!validateCostOfLiving()
                        |!validateSalary()|!validateBonus()|!validateLeave()|!validateMaternity()|!validateInsurance()){
                    return;
                }
                saveButton();
                Toast.makeText(getApplicationContext(), "Details Saved Successfully!", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(EnterJobOffers.this, MainActivity.class);
//                startActivity(intent);
                displayComparison.setEnabled(checkCurrentJob());
            }
        });
        enterNewOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EnterJobOffers.this, EnterJobOffers.class);
                startActivity(intent);
            }
        });
    }

    private boolean checkCurrentJob() {
        try {
            File directory = new File(getExternalFilesDir(null), "edu.gatech.seclass.jobcompare6300");
            File file = new File(directory, "jobs.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                if (attributes.length >= 2) {
                    String flag = attributes[attributes.length-1];
                    if (flag.equals("true")){
                        return true;
                    }
                }
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    private void saveButton() {
        String curTitle = String.valueOf(titleID.getText());
        String curCompany = String.valueOf(companyID.getText());
        String curLocation = String.valueOf(locationID.getText());
        int curCostOfLiving = Integer.parseInt(String.valueOf(costOfLivingID.getText()));
        double curYearlySalary = Double.parseDouble(String.valueOf(yearlySalaryID.getText()));
        double curYearlyBonus = Double.parseDouble(String.valueOf(yearlyBonusID.getText()));
        int curLeave = Integer.parseInt(String.valueOf(leaveID.getText()));
        int curMaternityLeave = Integer.parseInt(String.valueOf(maternityLeaveID.getText()));
        int curLifeInsurance = Integer.parseInt(String.valueOf(lifeInsuranceID.getText()));
        Job curJob = new Job(curTitle, curCompany, curLocation,
                curCostOfLiving, curYearlySalary, curYearlyBonus,
                curLeave, curMaternityLeave, curLifeInsurance);

        jobs.add(curJob);
        saveJobToTextFile(curJob);
    }


    private void saveJobToTextFile(Job job) {
        try {
            File directory = new File(getExternalFilesDir(null), "edu.gatech.seclass.jobcompare6300");
            if (!directory.exists()) {
                directory.mkdirs();
            }
            File file = new File(directory, "jobs.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            String jobString = job.toString(); // Convert job object to string using toString()
            outputStreamWriter.append(jobString); // Append the job string to the file
            outputStreamWriter.append("\n"); // create a new line for the next job
            outputStreamWriter.close();
            fileOutputStream.close();
            // Print a success message
            System.out.println("Job saved successfully!");
            // Print the file path for verification
            System.out.println("File path: " + file.getAbsolutePath());
            //print job
            System.out.println(job);
            System.out.println("id: "+job.getJobId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private boolean validateTitle(){
        String curTitle = String.valueOf(titleID.getText());
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(curTitle);
        if (curTitle.isEmpty()) {
            titleID.setError("Please enter the Title");
            return false;
        }else if (matcher.find()) {
            titleID.setError("Please remove special characters in Title");
            return false;
        }
        else{
            titleID.setError(null);
            return true;
        }
    }
    private boolean validateCompany(){

        String curCompany = String.valueOf(companyID.getText());

        if (curCompany.isEmpty()) {
            companyID.setError("Please enter the Company");
            return false;
        }
        else{
            companyID.setError(null);
            return true;
        }
    }
    private boolean validateLocation(){

        String curLocation = String.valueOf(locationID.getText());
        if (curLocation.isEmpty()) {
            locationID.setError("Please enter the Location");
            return false;
        }else if (curLocation.contains(",")) {
            locationID.setError("Please remove comma ','");
            return false;
        }
        else{
            locationID.setError(null);
            return true;
        }
    }

    private boolean validateCostOfLiving(){
        String costOfLeaving = String.valueOf(costOfLivingID.getText());
        int index;
        try {
            index =  Integer.parseInt(costOfLeaving);
        } catch (NumberFormatException e) {
            costOfLivingID.setError("Please enter the Cost Of Leaving");

            return false;
        }

        if(index < 0 || index > 213) {
            costOfLivingID.setError("Please enter the correct Cost Of Leaving");
            return false;
        }
        else{
            costOfLivingID.setError(null);
            return true;
        }
    }
    private boolean validateSalary(){
        String salary = String.valueOf(yearlySalaryID.getText());
        double yearlySalary;
        try {
            yearlySalary =  Double.parseDouble(salary);
        } catch (NumberFormatException e) {
            yearlySalaryID.setError("Please enter the Salary");

            return false;
        }

        if(yearlySalary < 0 ) {
            yearlySalaryID.setError("Must be positive decimal value");
            return false;
        }
        else{
            yearlySalaryID.setError(null);
            return true;
        }

    }
    private boolean validateBonus(){
        String bonus = String.valueOf(yearlyBonusID.getText());
        double yearlyBonus;
        try {
            yearlyBonus =  Double.parseDouble(bonus);
        } catch (NumberFormatException e) {
            yearlyBonusID.setError("Please enter the Bonus");

            return false;
        }

        if(yearlyBonus < 0 ) {
            yearlyBonusID.setError("Must be positive decimal value");
            return false;
        }
        else{
            yearlyBonusID.setError(null);
            return true;
        }
    }
    private boolean validateLeave(){
        String leave = String.valueOf(leaveID.getText());
        int leaveInt;
        try {
            leaveInt =  Integer.parseInt(leave);
        } catch (NumberFormatException e) {
            leaveID.setError("Please enter the Leave");

            return false;
        }

        if(leaveInt < 0 || leaveInt > 30) {
            leaveID.setError("Must be between 0 and 30");
            return false;
        }
        else{
            leaveID.setError(null);
            return true;
        }
    }

    private boolean validateMaternity(){
        String maternity = String.valueOf(maternityLeaveID.getText());
        int maternityLeave;
        try {
            maternityLeave =  Integer.parseInt(maternity);
        } catch (NumberFormatException e) {
            maternityLeaveID.setError("Please enter the Maternity/Paternity Leave");

            return false;
        }

        if(maternityLeave < 0 || maternityLeave > 20) {
            maternityLeaveID.setError("Must be between 0 and 20");
            return false;
        }
        else{
            maternityLeaveID.setError(null);
            return true;
        }

    }
    private boolean validateInsurance(){
        String insurance = String.valueOf(lifeInsuranceID.getText());
        int lifeInsurance;
        try {
            lifeInsurance =  Integer.parseInt(insurance);
        } catch (NumberFormatException e) {
            lifeInsuranceID.setError("Please enter the Life Insurance");

            return false;
        }


        if(lifeInsurance < 0 || lifeInsurance > 10) {
            lifeInsuranceID.setError("Must be between 0 and 10");
            return false;
        }
        else{
            lifeInsuranceID.setError(null);
            return true;
        }

    }

}


