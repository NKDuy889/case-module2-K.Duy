package model;

public class Labor extends Person{
    private int yearOfWork;
    private String duty = "labor";

    public int getYearOfWork() {
        return yearOfWork;
    }

    public void setYearOfWork(int yearOfWork) {
        this.yearOfWork = yearOfWork;
    }

    public String getDuty() {
        return duty;
    }

    @Override
    public String toString() {
        return super.toString() +
                "duty: " + duty +
                ", yearOfWork: " + yearOfWork;
    }
}
