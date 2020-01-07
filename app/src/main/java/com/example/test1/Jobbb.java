package com.example.test1;

public class Jobbb {

    public Jobbb(){}

    String job_Position;
    String job_Description;
    String job_Salary;
            String job_Requirement;
            String job_id;

                public Jobbb(String job_Position, String job_Description, String job_Salary, String job_Requirement, String job_id){
                    this.job_Position = job_Position;
                    this.job_Description = job_Description;
                    this.job_Salary = job_Salary;
                    this.job_Requirement = job_Requirement;
                    this.job_id = job_id;
                }

    public String getJob_Position() {
        return job_Position;
    }

    public String getJob_Description() {
        return job_Description;
    }

    public void setJob_Position(String job_Position) {
        this.job_Position = job_Position;
    }

    public void setJob_Description(String job_Description) {
        this.job_Description = job_Description;
    }

    public void setJob_Salary(String job_Salary) {
        this.job_Salary = job_Salary;
    }

    public void setJob_Requirement(String job_Requirement) {
        this.job_Requirement = job_Requirement;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public String getJob_Salary() {
        return job_Salary;
    }

    public String getJob_Requirement() {
        return job_Requirement;
    }

    public String getJob_id() {
        return job_id;
    }
}
