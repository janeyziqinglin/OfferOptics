# OfferOptics: Your Ultimate Job Offer Comparison App
## Background

Introducing George P. Burdell, a trailblazing and enterprising graduate who is on the hunt for the perfect job opportunity in the US. As George ventures through the labyrinth of job offers, brimming with enticing benefits, diverse locations, and countless considerations beyond mere salary figures, he realizes the need for a game-changing solution to ease this daunting journey. And just when he thought all hope was lost, he stumbled upon OfferOptics, a revolutionary and user-friendly single-user job offer comparison app that promises to be his ultimate career companion.

![GIF](https://i.pinimg.com/originals/72/a0/bf/72a0bf71b29e145665b5d6e0a5ffa0cf.gif)

## Key Features

### Main Menu

Upon launching OfferOptics, George is welcomed by a versatile main menu. It offers four primary options:

- Enter/Edit Current Job Details
- Enter Job Offers
- Adjust Comparison Settings
- Compare Job Offers (Disabled if no offers have been entered yet)

### Entering/Editing Current Job Details

OfferOptics presents George with an intuitive user interface to enter or modify the details of his current job, including:

- Title
- Company
- Location (City and State)
- Cost of Living (Indexed Value)
- Yearly Salary
- Yearly Bonus
- Leave (Number of Whole Days, 0 to 30)
- Maternity/Paternity Leave (Number of Whole Days, 0 to 20)
- Life Insurance (Percentage of Salary, 0 to 10)

He can effortlessly save the job details or exit without saving, seamlessly returning to the main menu in both cases.

### Entering Job Offers

George finds it straightforward to enter the details of job offers through a user interface mirroring the current job form. He can effortlessly save or cancel the entry. Additionally, George has the freedom to:

- Enter another offer
- Return to the main menu
- Compare the saved offer (if present) with his current job details (if available)

### Adjusting Comparison Settings

OfferOptics empowers George to customize the comparison by assigning integer weights to essential factors like:

- Yearly Salary
- Yearly Bonus
- Leave
- Maternity/Paternity Leave
- Life Insurance

Alternatively, if George prefers simplicity, all factors are treated as equal.

### Comparing Job Offers

The heart of OfferOptics lies in its job offer comparison feature. Upon selection, George is presented with a ranked list of job offers, arranged from best to worst. The current job, if available, is clearly indicated in the list. To compare, George:

- Chooses two jobs from the list
- Initiates the comparison

The app then displays a comprehensive table comparing the two jobs, showcasing key details such as:

- Title
- Company
- Location
- Yearly Salary adjusted for cost of living
- Yearly Bonus adjusted for cost of living
- Leave
- Maternity/Paternity Leave
- Life Insurance

George can effortlessly conduct another comparison or navigate back to the main menu.

### Job Ranking Algorithm

OfferOptics computes a job's score based on the following weighted sum formula:

AYS + AYB + (LT * AYS / 260) + (MPL * AYS / 260) + (LI/100 * AYS)

AYS: Yearly Salary adjusted for cost of living
AYB: Yearly Bonus adjusted for cost of living
LT: Leave
MPL: Maternity/Paternity Leave
LI: Life Insurance

The app considers user-assigned weights for each factor, allowing George to fine-tune the comparison based on his preferences.

### User Interface Excellence

OfferOptics boasts an intuitive and responsive user interface, ensuring George enjoys a seamless experience throughout.

## Technical Details

For OfferOptics, we assume a single system running the app, eliminating the need for communication or saving data between devices. The app stands as a standalone solution for George's job offer comparison needs.

With OfferOptics, George gains the power to make informed decisions, unearthing the best job offer tailored to his unique preferences and priorities. As he embarks on his post-graduation journey, OfferOptics acts as his trusted companion, guiding him towards a rewarding and fulfilling career path.

## Getting Started

To get started with OfferOptics, follow the instructions in the [Installation Guide](/path/to/your/installation_guide.md).

## Contributing

We welcome contributions from the community. To contribute to OfferOptics, please follow the guidelines outlined in the [Contribution Guide](/path/to/your/contribution_guide.md).

## License

OfferOptics is open-source software released under the [MIT License](/path/to/your/LICENSE).


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

