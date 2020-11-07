package model;

import constants.Constants;

public class Employee extends Person {
    private String level;
    private String duty = "employee";

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDuty() {
        return duty;
    }

//    @Override
//    public void getSalary(Salary salary) {
//        if (Constants.EMPLOYEE_3_7.equals(level)) {
//            salary.setSalary()
//        }
//    }

    @Override
    public String toString() {
        return super.toString() +
                "duty:  " + duty +
                ", level: " + level ;
    }
}
