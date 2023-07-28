package edu.gatech.seclass.jobcompare6300;
import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Job {
  private String title;
  private String company;
  private String location;
  private int costOfLivingIndex;
  private double yearlySalary;
  private double yearlyBonus;
  private int leave;
  private int maternityPaternityLeave;
  private int lifeInsurancePercentage;
  private int jobId;
  private int jobRank;
  private boolean curJob; //?

  private static int lastJobId;

  public Job(String title, String company, String location, int costOfLivingIndex, double yearlySalary,
             double yearlyBonus, int leave, int maternityPaternityLeave, int lifeInsurancePercentage) {
    this.title = title;
    this.company = company;
    this.location = location;
    this.costOfLivingIndex = costOfLivingIndex;
    this.yearlySalary = yearlySalary;
    this.yearlyBonus = yearlyBonus;
    this.leave = leave;
    this.maternityPaternityLeave = maternityPaternityLeave;
    this.lifeInsurancePercentage = lifeInsurancePercentage;
    this.jobId = getNextJobId(); // get a unique ID for this job
    this.jobRank = 0;
    this.curJob = false;
  }


  private static int retrieveLastJobId() {
    String filePath = "/storage/emulated/0/Android/data/edu.gatech.seclass.jobcompare6300/files/edu.gatech.seclass.jobcompare6300/jobs.txt";
    Path path = Paths.get(filePath);
//    File directory = new File(getExternalFilesDir(null), "edu.gatech.seclass.jobcompare6300");


    if (!Files.exists(path)) {
      System.out.println("file not found");
      return 0; // If the file doesn't exist, we return 0 as lastJobId
    }

    try (Stream<String> lines = Files.lines(path)) {
      List<String> fileList = lines.collect(Collectors.toList());
      if (!fileList.isEmpty()) {
        String lastLine = fileList.get(fileList.size() - 1);
        String[] fields = lastLine.split(",");
        if (fields.length >= 10) {
          int newjobid = Integer.parseInt(fields[9]);
          System.out.println("lastid:"+newjobid);
          return newjobid;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return 0;
  }

  // Method to get the next available unique job ID
  private static synchronized int getNextJobId() {
    lastJobId = retrieveLastJobId();
    return ++lastJobId;
  }


  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getLocation() {
    return location;
  }

  public double getYearlySalary() {
    return yearlySalary;
  }

  public double getYearlyBonus() {
    return yearlyBonus;
  }

  public int getLeave() {
    return leave;
  }

  public int getMaternityPaternityLeave() {
    return maternityPaternityLeave;
  }

  public int getLifeInsurancePercentage() {
    return lifeInsurancePercentage;
  }

  public int getCostOfLivingIndex() {
    return costOfLivingIndex;
  }

  public void setCostOfLivingIndex(int costOfLivingIndex) {
    this.costOfLivingIndex = costOfLivingIndex;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public void setYearlySalary(double yearlySalary) {
    this.yearlySalary = yearlySalary;
  }

  public void setYearlyBonus(double yearlyBonus) {
    this.yearlyBonus = yearlyBonus;
  }

  public void setLeave(int leave) {
    this.leave = leave;
  }

  public void setMaternityPaternityLeave(int maternityPaternityLeave) {
    this.maternityPaternityLeave = maternityPaternityLeave;
  }

  public void setLifeInsurancePercentage(int lifeInsurancePercentage) {
    this.lifeInsurancePercentage = lifeInsurancePercentage;
  }

  public void setJobId(int jobId) {
    this.jobId = jobId;
  }

  public int getJobId() {
    return jobId;
  }

  public int getJobRank() {
    return jobRank;
  }

  public void setJobRank(int jobRank) {
    this.jobRank = jobRank;
  }

  public boolean isCurJob() {
    return curJob;
  }

  public void setCurJob(boolean curJob) {
    this.curJob = curJob;
  }


  public double getScore(int salaryWeight, int bonusWeight, int leaveWeight, int maternityLeaveWeight,
                         int lifeInsuranceWeight) {
    double adjustedSalary = (yearlySalary * 100) / costOfLivingIndex;
    double adjustedBonus = (yearlyBonus * 100) / costOfLivingIndex;
    double SumWeight = salaryWeight+bonusWeight+leaveWeight+maternityLeaveWeight+lifeInsuranceWeight;
    double score = (salaryWeight / SumWeight * adjustedSalary) +
            (bonusWeight / SumWeight * adjustedBonus) +
            (leaveWeight / SumWeight * leave * adjustedSalary / 260) +
            (maternityLeaveWeight / SumWeight * maternityPaternityLeave * adjustedSalary / 260) +
            (lifeInsuranceWeight / SumWeight * lifeInsurancePercentage / 100 * adjustedSalary);
    return score;
  }

  @Override
  public String toString() {
    return title + "," + company + "," + location + "," + costOfLivingIndex + "," + yearlySalary + "," + yearlyBonus
            + "," + leave + "," + maternityPaternityLeave + "," + lifeInsurancePercentage + "," + jobId + "," + jobRank
            + "," + curJob;
  }

}



