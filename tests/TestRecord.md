# Test Record

## 1 Testing Strategy

### 1.1 Overall strategy
In initial stage we are planning for only unit testing. However, if it requires we will implement other testing strategies like : integration testing, system testing, and regression testing.
Testing would be done thoroughly by each team member.

### 1.2 Test Selection
When selecting our test cases, we will employ a combination of black-box and white-box techniques. For the Unit tests, we will focus on white-box technique in this assignment, and we will ensure testing cover all the distinct classes.

### 1.3 Adequacy Criterion
We will assess the quality of our test cases based on:

- Functional Coverage: We will test for all functionalities of the app and ensure that all requirements have been successfully implemented.

- Structural Coverage: We will examine the code structure to verify that the paths, branches, and conditions are working properly.

### 1.4 Bug Tracking
For tracking, the Bugs throughout the testing process will be tracked via github issues.

### 1.5 Technology
The technologies we will use for testing:

- Test Framework: JUnit testing to target small isolated units of code.

- Test Automation Tools: Automated testing is beyond the scope of this assginment, however, if we are broadening the scope of the application and simulate user actions like button clicking, selenium testing will be used.
- selenium testing for en

## 2 Test Cases

Unit testing for Job Class:

| Test Case | Purpose                              | Steps                    | Expected Result | Actual Result | Pass/Fail |
|-----------|--------------------------------------|--------------------------|-----------------|---------------|-----------|
| setUp()         | Test creating Job object             |                         | True            |   True            |  Pass         || getInfo()         | Test get info             | 1                        | True            |   True            |  Pass         |
| getInfo()         | Test set info             | 1                       | True            |     True          |     Pass      |
| setInfo()         | Test set info             | 2                       | True            |     True          |     Pass      |
| isCurJob()         | Test checking a job is a current job or not            |                         | True            |     True          |    Pass       |
| testGetScore   | Test compute score with different weight   |   | True            |   True            |    Pass       |
| testToString()     |Test default values for all the attributes |  | True            |     True          |    Pass       |


1. Steps for getter: create an object of Class Job, set the value of the property you want to test,  use the getter method to retrieve the value of the property, Compare the retrieved value with the expected value using assert statement.

2. Steps for setter: create an object of Class Job, use the setter method to set the property to the expected result, Access the property with getter method to confirm that the assigned value matches the expected value using assert statement.

Unit testing for ComparisonWeight Class:

| Test Case | Purpose                              | Steps                    | Expected Result | Actual Result | Pass/Fail |
|-----------|--------------------------------------|--------------------------|-----------------|---------------|-----------|
| TestGetters()         | Test get info             | 1                        | True            |   True            |  Pass         |
| TestSetters()         | Test set info             | 2                       | True            |     True          |     Pass      |
| setTestCompWeight()         | Test creating ComparisonWeight class             |                         | True            |     True          |    Pass       |
| TestSetString()     |Test default values for all the attributes |  | True            |     True          |    Pass       |


1. Steps for getter: create an object of Class ComparisonWeight, set the value of the property you want to test,  use the getter method to retrieve the value of the property, Compare the retrieved value with the expected value using assert statement.

2. Steps for setter: create an object of Class ComparisonWeight, use the setter method to set the property to the expected result, Access the property with getter method to confirm that the assigned value matches the expected value using assert statement.

User Interaction testing:

| Test Case | Purpose                              | Steps                    | Expected Result | Actual Result | Pass/Fail |
|-----------|--------------------------------------|--------------------------|-----------------|---------------|-----------|
| openMainMenu()        | Test functionality of main menu |          compare expected results and showed one                |    True      |      True         |      Pass     |
| clickSave()         | test save button functionality for all screens            | compare database entry against save button                     |   True          |      True         |        Pass   |
| clickCancel()         | test cancel button functionality for all screens            | compare database entry against cancel button                       | True            |   True            |  Pass         |
| formattedDisplayOfOutput()    | test if output of comparison is in required format     | check displayed output against wireframes                        | True  | True | Pass |


User Interaction Manual testing on each UI Page:

< Main Menu > Page

| Test Case | Purpose                                   | Steps                | Expected Result                            | Actual Result | Pass/Fail |
|-----------|-------------------------------------------|----------------------|--------------------------------------------|---------------|-----------|
| 1         | test Enter/Edit Current Job Detail button |click Enter/Edit Current Job Detail button | move to Enter/Edit Current Job Detail page |    True           |      Pass     |
| 2         | test Enter Job Offers button              |click Enter Job Offers button | move to Enter Job Offers page              | True          | Pass      |
| 3         | test Comparison Setting button            |click Comparison Setting button | move to Comparison Setting page            |   True            |     Pass      |
| 4         | test Compare Job Offers button            |click Compare Job Offer button | move to Compare Job Offers page            |     True          |      Pass     |
| 5         | test disable Compare Job Offers button    |click Compare Job Offer button | disable  button if there is <2 job offers  |     True          |      Pass     |

< Enter/Edit Current Job Detail > Page

| Test Case | Purpose          | Steps                                                                                                                                                                              | Expected Result    | Actual Result | Pass/Fail |
|-----------|------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------|---------------|-----------|
| 1         | test Title text input | enter no input in Title and click Save button                                                                                                                                      | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus | True          |    Pass    |
| 2         | test Title text input | enter "!" in Title and click Save button                                                                                                                                           | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus |       True        |    Pass    |
| 3         | test Company text input | enter no input in Company and click Save button                                                                                                                                    | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus |   True            |    Pass    |
| 4         | test Location text input | enter no input in Location and click Save button                                                                                                                                   | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus |    True           |   Pass     |
| 5         | test Location text input | enter "Boston, MA" in Location and click Save button                                                                                                                               | an error mark on the right-hand side of the text field, a floating error message "enter without comma" whenever the field has focus |       True        |  Pass      |
| 6         | test Cost of Living text input | enter no input in Cost of Living and click Save button                                                                                                                             | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus |        True       |    Pass    |
| 7         | test Cost of Living text input | enter value >212 in Cost of Living and click Save button                                                                                                                                            | an error mark on the right-hand side of the text field, a floating error message "enter a number" whenever the field has focus |    True           |    Pass    |
| 8         | test Yearly Salary text input | enter no input in Yearly Salary and click Save button                                                                                                                              | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus |       True        |   Pass     |
| 9         | test Yearly Bonus text input | enter no input in Yearly Bonus and click Save button                                                                                                                               | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus |      True         |  Pass      |
| 10        | test Leave text input | enter no input in Leave and click Save button                                                                                                                                      | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus |     True          |    Pass    |
| 11        | test Leave text input | enter value >30 and <0 in Leave and click Save button                                                                                                                              | an error mark on the right-hand side of the text field, a floating error message "enter a number" whenever the field has focus |      True         |   Pass     |
| 12        | test Maternity Leave text input | enter no input in Maternity Leave and click Save button                                                                                                                            | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus |       True        |   Pass     |
| 13        | test Maternity Leave text input | enter value >20 and <0 in Maternity Leave and click Save button                                                                                                                    | an error mark on the right-hand side of the text field, a floating error message "enter a number" whenever the field has focus |    True           |   Pass     |
| 14        | test Life Insurance text input | enter no input in Life Insurance and click Save button                                                                                                                             | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus |       True        |   Pass     |
| 15        | test Life Insurance text input | enter value >10 and <0 in Life Insurance and click Save button                                                                                                                     | an error mark on the right-hand side of the text field, a floating error message "enter a number" whenever the field has focus |    True           |    Pass    |
| 16        | test Save button | enter the valid value in every text input (IT Consultant, ABC, San Jose CA, 300, 100000, 20000, 12, 30, 1000) and click Save button                                                | move to Main Menu |      True         |   Pass     |
| 17        | test Cancel button | click Cancel button                                                                                                                                                                | move to Main Menu |     True          |    Pass    |
| 18        | test edit function | enter all the valid value input in text field (IT Consultant, ABC, San Jose CA, 300, 110000, 30000, 15, 45, 1200), click Save button, click Enter Job Offers button from Main Menu | show the current job details in text components |     True          |  Pass      |
| 19        | test edit function | after test case 21, edit a few text fields, click Save button, click Enter Job Offers button from Main Menu                                                                        | show the editted current job details in text components |    True           |    Pass    |

< Enter Job Offers > Page

| Test Case | Purpose                         | Steps                | Expected Result                                                                                                                     | Actual Result   | Pass/Fail |
|-----------|---------------------------------|----------------------|-------------------------------------------------------------------------------------------------------------------------------------|-----------------|-----------|
| 1         | test Title text input           | enter no input in Title and click Save button | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus                       |  True      |    Pass    |
| 2         | test Title text input           | enter "!" in Title and click Save button | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus                       |    True    |  Pass      |
| 3         | test Company text input         | enter no input in Company and click Save button | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus                       |   True     |    Pass    |
| 4         | test Location text input        | enter no input in Location and click Save button | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus                       |  True      |    Pass    |
| 5         | test Location text input        | enter "Boston, MA" in Location and click Save button | an error mark on the right-hand side of the text field, a floating error message "enter without comma" whenever the field has focus |  True      | Pass       |
| 6         | test Cost of Living text input  | enter no input in Cost of Living and click Save button | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus                       |   True     |   Pass     |
| 7         | test Cost of Living text input  | enter value >212 in Cost of Living and click Save button | an error mark on the right-hand side of the text field, a floating error message "enter a number" whenever the field has focus      |  True      |   Pass     |
| 8         | test Yearly Salary text input   | enter no input in Yearly Salary and click Save button | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus                       |  True      |   Pass     |
| 9         | test Yearly Bonus text input    | enter no input in Yearly Bonus and click Save button | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus                       |   True     |   Pass     |
| 11        | test Leave text input           | enter no input in Leave and click Save button | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus                       |   True     |   Pass     |
| 12        | test Leave text input           | enter value >30 and <0 in Leave and click Save button | an error mark on the right-hand side of the text field, a floating error message "enter a number" whenever the field has focus      |  True      |  Pass      |
| 13        | test Maternity Leave text input | enter no input in Maternity Leave and click Save button | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus                       |  True      |    Pass    |
| 14        | test Maternity Leave text input | enter value >20 and <0 in Maternity Leave and click Save button | an error mark on the right-hand side of the text field, a floating error message "enter a number" whenever the field has focus      |   True     |   Pass     |
| 15        | test Life Insurance text input  | enter no input in Life Insurance and click Save button | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus                       |  True      |    Pass    |
| 16        | test Life Insurance text input  | enter value >10 and <0 in Life Insurance and click Save button | an error mark on the right-hand side of the text field, a floating error message "enter a number" whenever the field has focus      |   True     |   Pass     |
| 17        | test Save button                | enter the valid value in every text input (Software Engineer, DEF, San Diego CA, 200, 120000, 30000, 18, 60, 500) and click Save button | move to Main Menu page                |    True     |   Pass     |
| 18        | test Return button              |click Return button | move to Main Menu page                                                                                                              |   True      |   Pass     |
| 19        | test Compare button             |click Compare button | move to Display Comparison page and show this job offer and the current job comparison in Display Comparison page                   |    True     |   Pass     |
| 20        | test New Offer button           |click New Offer button | Refresh the UI for enter a new offer                                                                                                |    True     |   Pass     |

< Comparison Setting > Page

|Test Case| Purpose          | Steps                | Expected Result    | Actual Result   | Pass/Fail |
|---------|------------------|----------------------|--------------------|-----------------|-----------|
| 1       | test Yearly Salary text input | enter no input in Yearly Salary and click Save button | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus |   True     |  Pass      |
| 2       | test Yearly Salary text input | enter "AB" in Yearly Salary and click Save button | an error mark on the right-hand side of the text field, a floating error message "enter a number" whenever the field has focus |   True     |   Pass     |
| 3       | test Yearly Salary text input | enter "100" in Yearly Salary and click Save button | an error mark on the right-hand side of the text field, a floating error message "enter a number" whenever the field has focus |    True    |   Pass     |
| 4       | test Yearly Bonus text input | enter no input in Yearly Bonus and click Save button | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus |    True    |   Pass     |
| 5       | test Yearly Bonus text input | enter "AB" in Yearly Bonus and click Save button | an error mark on the right-hand side of the text field, a floating error message "enter a number" whenever the field has focus |   True     |   Pass     |
| 6       | test Yearly Bonus text input | enter "15" in Yearly Bonus and click Save button | an error mark on the right-hand side of the text field, a floating error message "enter a number" whenever the field has focus |   True     |    Pass    |
| 7       | test Leave text input | enter no input in Leave and click Save button | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus |    True    |    Pass    |
| 8       | test Leave text input | enter "AB" in Leave and click Save button | an error mark on the right-hand side of the text field, a floating error message "enter a number" whenever the field has focus |   True     |   Pass     |
| 9       | test Leave text input | enter "0" in Leave and click Save button | an error mark on the right-hand side of the text field, a floating error message "enter a number" whenever the field has focus |  True      |  Pass      |
| 10      | test Maternity Leave text input | enter no input in Maternity Leave and click Save button | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus |  True      |   Pass     |
| 11      | test Maternity Leave text input | enter "AB" in Maternity Leave and click Save button | an error mark on the right-hand side of the text field, a floating error message "enter a number" whenever the field has focus |  True      |   Pass     |
| 12      | test Maternity Leave text input | enter "-1" in Maternity Leave and click Save button | an error mark on the right-hand side of the text field, a floating error message "enter a number" whenever the field has focus |   True     |  Pass      |
| 13      | test Life Insurance text input | enter no input in Life Insurance and click Save button | an error mark on the right-hand side of the text field, a floating error message whenever the field has focus |    True    |    Pass    |
| 14      | test Life Insurance text input | enter "!" in Life Insurance and click Save button | an error mark on the right-hand side of the text field, a floating error message "enter a number" whenever the field has focus |  True      |   Pass     |
| 15      | test Life Insurance text input | enter "150" in Life Insurance and click Save button | an error mark on the right-hand side of the text field, a floating error message "enter a number" whenever the field has focus |  True      |  Pass      |
| 16      | test Save button |enter the valid value in every text input (1,2,3,4,5) and click Save button | move to Main Menu page |   True      |   Pass     |
| 17      | test Return button |click Return button | move to Main Menu page |   True      |   Pass     |
| 18      | test Compare button |click Compare button | move to Display Comparison page and show this job offer and the current job comparison in Display Comparison page |    True     |  Pass      |
| 19      | test edit function | enter all the valid value input in text field (2,3,4,2,6) , click Save button, click Comparison Setting button from Main Menu | show the previously entered comparison setting in text components |  True       |   Pass     |
| 20      | test edit function | after test case 19, edit a few text fields, click Save button, click Comparison Setting button from Main Menu | show the editted comparison setting in text components |    True     |    Pass    |


< Compare Job Offers > page

|Test Case| Purpose          | Steps                | Expected Result                                                                      | Actual Result | Pass/Fail |
|---------|------------------|----------------------|--------------------------------------------------------------------------------------|---------------|-----------|
| 1       | test check box | check two check boxes  | two check boxes checked                                                              | True          | Pass      |
| 2       | test check box and compare button | check two check boxes and click Compare button | move to Display Comparison page and show two checked jobs in Display Comparison page | True          | Pass      |
| 3       | test check box and compare button | check one check boxes and click Compare button | Compare  button will not work untill 2 boxs checked                                  | True          | Pass      |
| 4       | test check box and compare button | check three (more than two) check boxes and click Compare button | User will able to select only two boxes                                              | True          | Pass      |
| 5       | test check box and compare button | do not check any check box and click Compare button | Compare  button will not work untill 2 boxs checked                                       | True          | Pass      |
| 6       | test Return button |click Return button | move to Main Menu page                                                               | True          | Pass      |

< Display Comparison > page

|Test Case| Purpose          | Steps                | Expected Result    | Actual Result | Pass/Fail |
|---------|------------------|----------------------|--------------------|---------------|-----------|
| 1       | test display | when Compare button is clicked on Compare Job Offers page, confirm that all the displayed information is regarding two jobs selected from Compare Job Offers page | all the information is correct | True          | Pass      |
| 2       | test display | when Compare button is clicked on Enter Job Offer page, confirm that all the displayed information is regarding the job offer and the current job | all the information is correct |       True        |     Pass      |
| 3       | test Compare button |click Compare button | move to Compare Job Offers page | True          | Pass      |
| 4       | test Return button |click Return button | move to Main Menu page | True          | Pass      |

