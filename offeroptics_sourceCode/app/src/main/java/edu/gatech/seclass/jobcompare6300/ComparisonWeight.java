package edu.gatech.seclass.jobcompare6300;

/**
 * ComparisonWeight class
 *
 * This is a class that sets the weight for the job comparison
 * for Job Offer Comparison App.
 *
 * This is the work of Team015 in 2023 Summer Software Development Process Course
 */
public class ComparisonWeight {
    public  int id;
    public int yearly_salary_weight = 1;
    public int yearly_bonus_weight = 1;
    public int leave_weight = 1;
    public int maternity_leave_weight = 1;
    public int life_insurance_weight = 1;

//    /**
//     * The set<weight> method stores values for the corresponding attributes of this class
//     * @param yearly_salary_weight   The value to store in yearly_salary_weight
//     * @param yearly_bonus_weight    The value to store in yearly_bonus_weight
//     * @param leave_weight           The value to store in leave_weight
//     * @param maternity_leave_weight The value to store in maternity_leave_weight
//     * @param life_insurance_weight  The value to store in life_insurance_weight
//     */

    public void setYearlySalaryWeight(int yearly_salary_weight) {
        this.yearly_salary_weight = yearly_salary_weight;
    }

    public void setYearlyBonusWeight(int yearly_bonus_weight) {
        this.yearly_bonus_weight = yearly_bonus_weight;
    }

    public void setLeaveWeight(int leave_weight) {
        this.leave_weight = leave_weight;
    }

    public void setMaternityLeaveWeight(int maternity_leave_weight) {
        this.maternity_leave_weight = maternity_leave_weight;
    }

    public void setLifeInsuranceWeight(int life_insurance_weight) {
        this.life_insurance_weight = life_insurance_weight;
    }

    /**
     * The get<weight> method returns a value for the corresponding attributes of this class
     *
     * @return The value in yearly_salary_weight field
     * @return The value in yearly_bonus_weight field
     * @return The value in leave_weight field
     * @return The value in maternity_leave_weight field
     * @return The value in life_insurance_weight field
     */

    public int getYearlySalaryWeight() {
        return yearly_salary_weight;
    }

    public int getYearlyBonusWeight() {
        return yearly_bonus_weight;
    }

    public int getLeaveWeight() {
        return leave_weight;
    }

    public int getMaternityLeaveWeight() {
        return maternity_leave_weight;
    }

    public int getLifeInsuranceWeight() {
        return life_insurance_weight;
    }

    @Override
    public String toString() {
        return yearly_salary_weight + "," + yearly_bonus_weight + "," + leave_weight + "," + maternity_leave_weight + "," + life_insurance_weight;
    }
}