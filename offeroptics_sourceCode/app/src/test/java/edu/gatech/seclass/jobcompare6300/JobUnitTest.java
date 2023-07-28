package edu.gatech.seclass.jobcompare6300;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class JobUnitTest {
    private Job job;
    private Job job1;
    @Before
    public void setUp() {
        job = new Job("Software Engineer", "ABC Company", "Atlanta", 100, 80000, 5000,
                20, 12, 80);
    }

    @Test
    public void getTitle() {
        assertEquals("Software Engineer", job.getTitle());
    }

    @Test
    public void getCompany() {
        assertEquals("ABC Company", job.getCompany());
    }

    @Test
    public void getLocation() {
        assertEquals("Atlanta", job.getLocation());
    }

    @Test
    public void getYearlySalary() {
        assertEquals(80000, job.getYearlySalary(), 0.01);
    }

    @Test
    public void getYearlyBonus() {
        assertEquals(5000, job.getYearlyBonus(), 0.01);
    }

    @Test
    public void getLeave() {
        assertEquals(20, job.getLeave());
    }

    @Test
    public void getMaternityPaternityLeave() {
        assertEquals(12, job.getMaternityPaternityLeave());
    }

    @Test
    public void getLifeInsurancePercentage() {
        assertEquals(80, job.getLifeInsurancePercentage());
    }

    @Test
    public void getCostOfLivingIndex() {
        assertEquals(100, job.getCostOfLivingIndex());
    }

    @Test
    public void setCostOfLivingIndex() {
        job.setCostOfLivingIndex(120);
        assertEquals(120, job.getCostOfLivingIndex());
    }

    @Test
    public void setTitle() {
        job.setTitle("Senior Software Engineer");
        assertEquals("Senior Software Engineer", job.getTitle());
    }

    @Test
    public void setCompany() {
        job.setCompany("XYZ Company");
        assertEquals("XYZ Company", job.getCompany());
    }

    @Test
    public void setLocation() {
        job.setLocation("San Francisco");
        assertEquals("San Francisco", job.getLocation());
    }

    @Test
    public void setYearlySalary() {
        job.setYearlySalary(100000);
        assertEquals(100000, job.getYearlySalary(), 0.01);
    }

    @Test
    public void setYearlyBonus() {
        job.setYearlyBonus(8000);
        assertEquals(8000, job.getYearlyBonus(), 0.01);
    }

    @Test
    public void setLeave() {
        job.setLeave(25);
        assertEquals(25, job.getLeave());
    }

    @Test
    public void setMaternityPaternityLeave() {
        job.setMaternityPaternityLeave(16);
        assertEquals(16, job.getMaternityPaternityLeave());
    }

    @Test
    public void setLifeInsurancePercentage() {
        job.setLifeInsurancePercentage(90);
        assertEquals(90, job.getLifeInsurancePercentage());
    }

    @Test
    public void setJobId() {
        job.setJobId(1);
        assertEquals(1, job.getJobId());
    }

    @Test
    public void getJobId() {
        assertEquals(1, job.getJobId()); // Assuming the initial job ID is 0
    }

    @Test
    public void getJobRank() {
        assertEquals(0, job.getJobRank());
    }

    @Test
    public void setJobRank() {
        job.setJobRank(1);
        assertEquals(1, job.getJobRank());
    }

    @Test
    public void isCurJob() {
        assertFalse(job.isCurJob());
    }

    @Test
    public void setCurJob() {
        job.setCurJob(true);
        assertTrue(job.isCurJob());
    }


    @Test
    public void testGetScore() {
        job1 = new Job("Software Engineer", "ABC Company", "Atlanta", 100, 100, 100,
                100, 100, 100);
        double score = job1.getScore(3, 1, 1, 2, 1);
        assertEquals(76.92, score, 0.01);
    }


    @Test
    public void testToString() {
        String expected = "Software Engineer,ABC Company,Atlanta,100,80000.0,5000.0,20,12,80,1,0,false";
        assertEquals(expected, job.toString());
    }
}
