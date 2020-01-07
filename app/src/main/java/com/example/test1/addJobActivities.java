package com.example.test1;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addJobActivities extends AppCompatActivity {

    private EditText edit1;
    private EditText edit2;
    private EditText edit3;
    private EditText edit4;
    private Button addbtn;

    DatabaseReference jobDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_job);


        jobDatabase = FirebaseDatabase.getInstance().getReference("Job");

        edit1 = (EditText) findViewById(R.id.addJobsPosition);
        edit2 = (EditText) findViewById(R.id.addJobsDescription);
        edit3 = (EditText) findViewById(R.id.addJobsSalary);
        edit4 = (EditText) findViewById(R.id.addJobsRequirement);

        addbtn = (Button) findViewById(R.id.addjobbtn);

        addbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                addJob();
        }
    });

}

public void addJob(){
    String jobPosition = edit1.getText().toString().trim();
    String jobDescription = edit2.getText().toString().trim();
    String jobSalary = edit3.getText().toString().trim();
    String jobRequirement = edit4.getText().toString().trim();

    /*FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference jobDatabase = database.getReference("Job");*/

    if(!TextUtils.isEmpty(jobPosition) && !TextUtils.isEmpty(jobDescription) && !TextUtils.isEmpty(jobSalary) && !TextUtils.isEmpty(jobRequirement)) {

        String id = jobDatabase.push().getKey();

        Jobbb job = new Jobbb(jobPosition, jobDescription, jobSalary, jobRequirement, id);

        jobDatabase.setValue(job);

        Toast.makeText(
                this,
                "Job Saved Successfully",
                Toast.LENGTH_SHORT
        ).show();
    } else{
        Toast.makeText(
                this,
                "Job Saved failed",
                Toast.LENGTH_SHORT
        ).show();
    }
}
}
