package edu.gatech.seclass.jobcompare6300;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
public class ComparisonWeightUnitTest {

    private ComparisonWeight TestCompWeight;

    @Before
    public void setTestCompWeight(){
        TestCompWeight = new ComparisonWeight();
    }

    @Test
    public void TestGetters(){
        assertEquals(1,TestCompWeight.getYearlySalaryWeight(),0);
        assertEquals(1,TestCompWeight.getLeaveWeight(),0);
        assertEquals(1,TestCompWeight.getYearlyBonusWeight(),0);
        assertEquals(1,TestCompWeight.getMaternityLeaveWeight(),0);
        assertEquals(1,TestCompWeight.getLifeInsuranceWeight(),0);
    }

    @Test
    public void TestSetters(){
        TestCompWeight.setYearlySalaryWeight(2);
        assertEquals(2,TestCompWeight.getYearlySalaryWeight(),0);

        TestCompWeight.setYearlyBonusWeight(2);
        assertEquals(2,TestCompWeight.getYearlyBonusWeight(),0);

        TestCompWeight.setLeaveWeight(2);
        assertEquals(2,TestCompWeight.getLeaveWeight(),0);

        TestCompWeight.setMaternityLeaveWeight(2);
        assertEquals(2,TestCompWeight.getMaternityLeaveWeight(),0);

        TestCompWeight.setLifeInsuranceWeight(2);
        assertEquals(2,TestCompWeight.getLifeInsuranceWeight(),0);
    }

    @Test
    public void TestSetString(){
        String expected_val = "1,1,1,1,1";
        assertEquals(expected_val,TestCompWeight.toString());
    }

}
