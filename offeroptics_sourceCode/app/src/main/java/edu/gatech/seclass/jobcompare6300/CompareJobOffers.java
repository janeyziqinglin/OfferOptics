package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CompareJobOffers extends AppCompatActivity {
    private Button returnToMain;
    private Button displayComparison;
    private CheckBox checkBox01;
    private CheckBox checkBox02;
    private CheckBox checkBox03;
    private CheckBox checkBox04;
    private CheckBox checkBox05;

    private CheckBox selectedCheckBox1;
    private CheckBox selectedCheckBox2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_job_offers);
        returnToMain = findViewById(R.id.button_ReturnToMain);

        checkBox01 = findViewById(R.id.checkBox01);
        checkBox02 = findViewById(R.id.checkBox02);
        checkBox03 = findViewById(R.id.checkBox03);
        checkBox04 = findViewById(R.id.checkBox04);
        checkBox05 = findViewById(R.id.checkBox05);

        checkBox01.setEnabled(false);
        checkBox01.setVisibility(View.GONE);
        checkBox02.setEnabled(false);
        checkBox02.setVisibility(View.GONE);
        checkBox05.setEnabled(false);
        checkBox05.setVisibility(View.GONE);
        checkBox03.setEnabled(false);
        checkBox03.setVisibility(View.GONE);
        checkBox04.setEnabled(false);
        checkBox04.setVisibility(View.GONE);
        returnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompareJobOffers.this, MainActivity.class);
                startActivity(intent);
            }
        });

        displayComparison = findViewById(R.id.button_displayComparison);
        displayComparison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToDisplayComparison();
            }
        });

        checkBox01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCheckBoxClick(checkBox01);
            }
        });

        checkBox02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCheckBoxClick(checkBox02);
            }
        });

        checkBox03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCheckBoxClick(checkBox03);
            }
        });

        checkBox04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCheckBoxClick(checkBox04);
            }
        });

        checkBox05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCheckBoxClick(checkBox05);
            }
        });

        readFromFileAndPopulateCheckBoxes();
    }

    private void handleCheckBoxClick(CheckBox checkBox) {
        if (checkBox.isChecked()) {
            if (selectedCheckBox1 == null) {
                selectedCheckBox1 = checkBox;
            } else if (selectedCheckBox2 == null) {
                selectedCheckBox2 = checkBox;
            } else {
                selectedCheckBox1.setChecked(false);
                selectedCheckBox1 = selectedCheckBox2;
                selectedCheckBox2 = checkBox;
            }
        } else {
            if (selectedCheckBox1 == checkBox) {
                selectedCheckBox1 = null;
            } else if (selectedCheckBox2 == checkBox) {
                selectedCheckBox2 = null;
            }
        }
    }

//    private void moveToDisplayComparison() {
//        if (selectedCheckBox1 != null && selectedCheckBox2 != null) {
//            Intent intent = new Intent(CompareJobOffers.this, DisplayComparison.class);
//            intent.putExtra("job1", getJobInfo(selectedCheckBox1));
//            intent.putExtra("job2", getJobInfo(selectedCheckBox2));
//            startActivity(intent);
//        }
//    }
private void moveToDisplayComparison() {
    if (selectedCheckBox1 != null && selectedCheckBox2 != null) {
        int index1 = getCheckboxIndex(selectedCheckBox1);
        int index2 = getCheckboxIndex(selectedCheckBox2);
        Intent intent = new Intent(CompareJobOffers.this, DisplayComparison.class);
        intent.putExtra("checkboxIndex1", index1);
        intent.putExtra("checkboxIndex2", index2);
        startActivity(intent);
    }
}

    private String getJobInfo(CheckBox checkBox) {
        StringBuilder jobInfo = new StringBuilder();
        String[] attributes = checkBox.getText().toString().split(", ");
        if (attributes.length >= 2) {
            jobInfo.append("Title: ").append(attributes[0]).append("\n");
            jobInfo.append("Company: ").append(attributes[1]).append("\n");
        }
        // Add more attributes as needed
        return jobInfo.toString();
    }

    private void readFromFileAndPopulateCheckBoxes() {
        try {
            File directory = new File(getExternalFilesDir(null), "edu.gatech.seclass.jobcompare6300");
            File file = new File(directory, "jobsSorted.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            String checkboxText;
            int checkboxIndex = 1;
            while ((line = reader.readLine()) != null && checkboxIndex <= 5) {
                String[] attributes = line.split(",");
                if (attributes.length >= 2) {
                    String flag = attributes[attributes.length-1];
                    System.out.println(flag+"flag is printed");
                    if (flag.equals("true")){
                        checkboxText = attributes[0] + ", " + attributes[1] + " " + "[Current Job]";
                    }
                    else{
                        checkboxText = attributes[0] + ", " + attributes[1];
                    }
                    System.out.println(checkboxText);
                    setCheckboxText(checkboxIndex, checkboxText);
                    checkboxIndex++;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getCheckboxIndex(CheckBox checkBox) {
        if (checkBox == checkBox01) {
            return 1;
        } else if (checkBox == checkBox02) {
            return 2;
        } else if (checkBox == checkBox03) {
            return 3;
        } else if (checkBox == checkBox04) {
            return 4;
        } else if (checkBox == checkBox05) {
            return 5;
        } else {
            return 0;
        }
    }


    private void setCheckboxText(int checkboxIndex, String text) {
        CheckBox checkBox;
        switch (checkboxIndex) {
            case 1:
                checkBox = checkBox01;
                break;
            case 2:
                checkBox = checkBox02;
                break;
            case 3:
                checkBox = checkBox03;
                break;
            case 4:
                checkBox = checkBox04;
                break;
            case 5:
                checkBox = checkBox05;
                break;
            default:
                return;
        }
        checkBox.setEnabled(true);
        checkBox.setVisibility(View.VISIBLE);
        checkBox.setText(text);
    }
}
