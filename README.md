# User Manual of Job Offer Comparison App

This user manual provides a detailed guide on how to use the Job Offer Comparison App.

## 1. Main Menu

Upon launching the app, users are presented with the main menu. The main menu provides options for various functionalities:

<div style="display: flex;">
    <img src="/images/MainMenu_default.png" alt="Main Menu Default" style="width: 300px;"/>
    <img src="/images/MainMenu.png" alt="Main Menu" style="width: 290px;"/>
</div>

### 1.1 Description of Each Field

The main menu consists of four buttons:

- "Enter/Edit Current Job": Allows users to enter or edit details of their current job.
- "Enter Job Offers": Enables users to enter information about job offers they receive.
- "Adjust Comparison Setting": Allows users to adjust the comparison weights for each job benefit.
- "Compare Job Offers": Once at least two jobs are saved, users can compare the offers using this option.

## 2. Enter/Edit Current Job

This section guides users on how to enter or edit their current job details.

### 2.1 User Interface Screen
<div style="display: flex;">
    <img src="/images/EnterEditCurrentJob.png" alt="Main Menu Default" style="width: 300px;"/>
    <img src="/images/EnterEditCurrentJob_Error.png" alt="Main Menu" style="width: 297px;"/>
</div>


### 2.2 Description of Each Field

There are 9 text input fields:

- "Title": Enter the job title.
- "Company": Enter the name of the company.
- "Location": Enter the job location (city and state without a comma).
- "Cost of Living": Enter the cost of living (an integer value between 0 and 212).
- "Yearly Salary": Enter the yearly salary.
- "Yearly Bonus": Enter the yearly bonus.
- "Leave": Enter the number of leave days (an integer value between 0 and 30).
- "Maternity Leave": Enter the number of maternity leave days (an integer value between 0 and 20).
- "Life Insurance": Enter the life insurance value (an integer value between 0 and 10).

### 2.3 Description of Functionality

If it's the first time entering the current job information:

- Input all the detailed information of the current job into the text input fields.
- Click "Save" to save the information.
- Click "Cancel" to go back to the main menu page.

If the current job information is already saved:

- The app will display the current job details in the text input fields.
- Hints will show example inputs on each text input field.
- Edit the information if needed.
- Click "Save" to save the edited information.
- Click "Cancel" to go back to the main menu page.

## 3. Enter Job Offers

This section explains how to enter job offer details.

### 3.1 User Interface Screen

![Job Offers](/images/EnterJobOffers.png)

### 3.2 Description of Each Field

There are 9 text input fields:

- "Title": Enter the job title.
- "Company": Enter the name of the company.
- "Location": Enter the job location (city and state without a comma).
- "Cost of Living": Enter the cost of living (an integer value between 0 and 212).
- "Yearly Salary": Enter the yearly salary.
- "Yearly Bonus": Enter the yearly bonus.
- "Leave": Enter the number of leave days (an integer value between 0 and 30).
- "Maternity Leave": Enter the number of maternity leave days (an integer value between 0 and 20).
- "Life Insurance": Enter the life insurance value (an integer value between 0 and 10).

### 3.3 Description of Functionality

- Input all the detailed information of the new job offer into the text input fields.
- Hints will show example inputs on each text input field.
- Click "Save" to save the information.
- Click "Return" to go back to the main menu page.
- Click "Compare" to compare the new job offer with the current job.
- Click "New Offer" to clear the form and input a new job offer.
- Up to four job offers can be added.

## 4. Adjust Comparison Setting

This section allows users to adjust the comparison weights for each job benefit.

### 4.1 User Interface Screen

![Comparison](/images/AdjustComparisonSetting.png)

### 4.2 Description of Each Field

There are 5 text input fields:

- "Yearly Salary": Enter the weight for yearly salary.
- "Yearly Bonus": Enter the weight for yearly bonus.
- "Leave": Enter the weight for leave days.
- "Maternity Leave": Enter the weight for maternity leave days.
- "Life Insurance": Enter the weight for life insurance.

All weights should be integers from 1 to 10 inclusive.

### 4.3 Description of Functionality

- Input the weight for each job benefit.
- Hints will show example inputs on each text input field.
- Click "Save" to save the weights.
- Click "Return" to go back to the main menu page.
- If no weights are input, default weights of 1 will be used.

## 5. Compare Job Offers

This section allows users to compare different job offers.

