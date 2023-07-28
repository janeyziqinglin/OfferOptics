package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.FileNotFoundException;
import java.io.FileReader;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.room.Room;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button EnterJobDetailsn;
    private Button enterJobOffers;
    private Button adjustComparison;
    private Button compareJobs;

    private List<Job> jobsToSort = new ArrayList<>();
    private int yearlySalaryWeight = 1;
    private int yearlyBonusWeight = 1;
    private int leaveWeight = 1;
    private int maternityLeaveWeight = 1;
    private int lifeInsuranceWeight = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EnterJobDetailsn = (Button) findViewById(R.id.button_EnterJobDetailsn);
        enterJobOffers = (Button) findViewById(R.id.button_EnterJobOffers);
        adjustComparison = (Button) findViewById(R.id.button_AdjustComparison);
        compareJobs = (Button) findViewById(R.id.button_CompareJobs);
        try {
            compareJobs.setEnabled(checkJobsLength()>=2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        EnterJobDetailsn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,EnterJobDetailsn.class);
                startActivity(intent);
                System.out.println("saved successfully main activity");
            }
        });

        enterJobOffers.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, EnterJobOffers.class);
                startActivity(intent);
                System.out.println("saved successfully main activity job offer");
            }
        });

        adjustComparison.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, AdjustComparisonSetting.class);
                startActivity(intent);
            }
        });

        compareJobs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                jobCompareButton();
                Intent intent = new Intent(MainActivity.this, CompareJobOffers.class);
                startActivity(intent);
            }
        });


//        ApplicationDB DB = Room.databaseBuilder(getApplicationContext() ,
//                ApplicationDB.class, "database-name").allowMainThreadQueries().build();
//        ComparisonWeightDao CWDao = DB.CWDao();
//        ComparisonWeight CW = new ComparisonWeight();
//        CWDao.insert_weight(CW);
//        List<ComparisonWeight> var = CWDao.get_all_weights();
//        System.out.println("test"+ var.get(0).getLeaveWeight());
    }
    private void jobCompareButton() {
        readFromFileAndCreateJobsToSort();
        readComparisonFromFile();
        rankJobOffers();
        saveSortedJobToTextFile(jobsToSort);
    }
    // Read from "jobs.txt" and create jobsSort array list
    private void readFromFileAndCreateJobsToSort() {
        try {
            File directory = new File(getExternalFilesDir(null), "edu.gatech.seclass.jobcompare6300");
            File file = new File(directory, "jobs.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                if (attributes.length >= 12) {
                    // With attributes, create jobsSort array list

                    String curTitle = String.valueOf(attributes[0]);
                    String curCompany = String.valueOf(attributes[1]);
                    String curLocation = String.valueOf(attributes[2]);
                    int curCostOfLiving = Integer.parseInt(attributes[3]);
                    double curYearlySalary = Double.parseDouble(attributes[4]);
                    double curYearlyBonus = Double.parseDouble(attributes[5]);
                    int curLeave = Integer.parseInt(String.valueOf(attributes[6]));
                    int curMaternityLeave = Integer.parseInt(attributes[7]);
                    int curLifeInsurance = Integer.parseInt(attributes[8]);
                    boolean current = Boolean.parseBoolean(attributes[11]);
                    Job curJob = new Job(curTitle, curCompany, curLocation,
                            curCostOfLiving, curYearlySalary, curYearlyBonus,
                            curLeave, curMaternityLeave, curLifeInsurance);

                    curJob.setCurJob(current);

                    jobsToSort.add(curJob);
                    // Print the company of this job for verification
                    System.out.println("this job's company: "+curJob.getCompany());
                }

            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Comparison Weight reading from compare.txt file
    private void readComparisonFromFile() {
        try {
            File directory = new File(getExternalFilesDir(null), "edu.gatech.seclass.jobcompare6300");
            File file = new File(directory, "compare.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            reader.close();

            if (line != null) {
                String[] weights = line.split(",");

                if (weights.length >= 5) {
                    // Set the weights to the weight variables
                    yearlySalaryWeight = Integer.parseInt(weights[1]);
                    yearlyBonusWeight = Integer.parseInt(weights[2]);
                    leaveWeight = Integer.parseInt(weights[3]);
                    maternityLeaveWeight = Integer.parseInt(weights[4]);
                    lifeInsuranceWeight = Integer.parseInt(weights[5]);
                    // Print for verification
                    System.out.println("yearlySalaryWeight: "+ yearlySalaryWeight);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Calculate jobScore and sort the job objects according to job scores
    private void rankJobOffers() {
        // Calculate the score for each job offer
        for (Job job : jobsToSort) {
            double score = job.getScore(yearlySalaryWeight, yearlyBonusWeight, leaveWeight,
                    maternityLeaveWeight, lifeInsuranceWeight);
            job.setJobRank((int) score); // Set the rank as the score (temporary)
        }

        // Sort the job offers based on the rank (score)
        Collections.sort(jobsToSort, Comparator.comparingInt(Job::getJobRank));
        Collections.reverse(jobsToSort); // Reverse the list to rank from highest to lowest
    }

    // write all the jobs in jobsToSort array list to the jobsSorted.tex file
    private void saveSortedJobToTextFile(List<Job> jobsToSort) {
        File directory = new File(getExternalFilesDir(null), "edu.gatech.seclass.jobcompare6300");
        File file = new File(directory, "jobsSorted.txt");
        if (file.exists()) {
            file.delete();
        }

        for (Job job : jobsToSort) {
            saveJobToTextFile(job);
            System.out.println("job"+job);
        }
        // Print a success message
        System.out.println("Sorted saved successfully!");
        // Print the file path for verification
    }

    // save the job offer to the jobsSorted.tex file
    private void saveJobToTextFile(Job job) {
        try {
            File directory = new File(getExternalFilesDir(null), "edu.gatech.seclass.jobcompare6300");
            if (!directory.exists()) {
                directory.mkdirs();
            }
            File file = new File(directory, "jobsSorted.txt");
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
            System.out.println("Job(Sorted) saved successfully!");
            // Print the file path for verification
            System.out.println("File path: " + file.getAbsolutePath());
            //print job
            //System.out.println(job);
            //System.out.println("id: "+job.getJobId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int checkJobsLength() throws IOException {
        File directory = new File(getExternalFilesDir(null), "edu.gatech.seclass.jobcompare6300");
        File file = new File(directory, "jobs.txt");
        int Count = 0;
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.readLine() != null){
                Count++;
            }
        }
        return Count;
    }


}
