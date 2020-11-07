package model;

import constants.Constants;

public class Manager extends Person {
    private String positinon;
    private String duty = "manager";

    public Manager() {
    }

    public Manager(String positinon) {
        this.positinon = positinon;
    }

    public String getPositinon() {
        return positinon;
    }

    public void setPositinon(String positinon) {
        this.positinon = positinon;
    }

    public String getDuty() {
        return duty;
    }

    @Override
    public void getSalary(Salary salary) {
        int x = 100000;
        if (Constants.MANAGER_DEPARTMENT_HEAD.equals(positinon)) {
            x = 200000;
        }
        salary.setSalary((Constants.Salary.MANAGER + x) * salary.getWorkingDays() - salary.getDayOff() * 50000);
    }

    @Override
    public String toString() {
        return super.toString() +
                "duty: " + duty +
                ", positinon: " + positinon;
    }
}
//            System.out.println(TimeUnit.DAYS.convert(date1 - date2, TimeUnit.MILLISECONDS));
