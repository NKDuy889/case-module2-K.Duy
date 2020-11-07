package model;

public class Salary {
    private int salary;
    private int dayOff;
    private int workingDays;

    public int getSalary() {
        return salary;
    }

    public int setSalary(int salary) {
        this.salary = salary;
        return salary;
    }

    public int getDayOff() {
        return dayOff;
    }

    public void setDayOff(int dayOff) {
        this.dayOff = dayOff;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    @Override
    public String toString() {
        return "salary: " + salary +
                ", dayOff: " + dayOff +
                ", workingDays: " + workingDays;
    }
}
