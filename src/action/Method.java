package action;

import constants.Constants;
import model.*;
import util.ParseUtils;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Method {
    private Calendar calendar = Calendar.getInstance();
    private List<Person> list = new ArrayList<>();

    public void addEmployee() {
        System.out.println("Enter number of employee: ");
        int numberEmployee = (Integer) ParseUtils.parseFromScanner(Integer.class);
        for (int i = 0; i < numberEmployee; i++) {
            Employee employee = Person.create(Employee.class, list);
            System.out.println("Enter level: ");
            System.out.println("1. level 3/7");
            System.out.println("2. Level 4/7");
            int lv = (Integer) ParseUtils.parseFromScanner(Integer.class, "1|2");
            switch (lv) {
                case 1:
                    employee.setLevel(Constants.EMPLOYEE_3_7);
                    break;
                case 2:
                    employee.setLevel(Constants.EMPLOYEE_4_7);
                    break;
            }
            list.add(employee);
        }
    }

    public void addManager() {
        System.out.println("Enter number of manager: ");
        int numberManager = (Integer) ParseUtils.parseFromScanner(Integer.class);
        for (int i = 0; i < numberManager; i++) {
            Manager manager = Person.create(Manager.class, list);
            System.out.println("Enter position: ");
            System.out.println("1. Department head");
            System.out.println("2. Deputy");
            int position = (Integer) ParseUtils.parseFromScanner(Integer.class, "1|2");
            switch (position) {
                case 1:
                    manager.setPositinon(Constants.MANAGER_DEPARTMENT_HEAD);
                    break;
                case 2:
                    manager.setPositinon(Constants.MANAGER_DEPUTY);
                    break;
            }
            list.add(manager);
        }
    }

    public void addLabor() {
        System.out.println("Enter number of labor: ");
        int numberLabor = (Integer) ParseUtils.parseFromScanner(Integer.class);
        for (int i = 0; i < numberLabor; i++) {
            Labor labor = Person.create(Labor.class, list);
            System.out.println("Enter position: ");
            System.out.println("1. Less than 1 year of experience");
            System.out.println("2. 1 year of experience");
            System.out.println("3. Over 1 year of experience");
            int experience = (Integer) ParseUtils.parseFromScanner(Integer.class, "1|2|3");
            switch (experience) {
                case 1:
                    labor.setYearOfWork(0);
                    break;
                case 2:
                    labor.setYearOfWork(1);
                    break;
                case 3:
                    labor.setYearOfWork(2);
                    break;
            }
            list.add(labor);
        }
    }

    public void addToList() {
        addEmployee();
        addManager();
        addLabor();
    }

    public void showList() {
        if (list.isEmpty()) {
            System.out.println("-----LIST EMPTY-----");
        } else {
            for (Person person : list) {
                System.out.println(person);
            }
        }
    }

    public void showEmployee() {
        for (Person person : list) {
            if (person instanceof Employee) {
                System.out.println(person.toString());
            }
        }
    }

    public void showManager() {
        for (Person person : list) {
            if (person instanceof Manager) {
                System.out.println(person.toString());
            }
        }
    }

    public void showLabor() {
        for (Person person : list) {
            if (person instanceof Labor) {
                System.out.println(person.toString());
            }
        }
    }

    public void changeName() {
        System.out.println("Enter id: ");
        int id = (Integer) ParseUtils.parseFromScanner(Integer.class);
        for (Person person : list) {
            if (id == person.getIdPerson()) {
                System.out.println("Rename to: ");
                person.setName((String) ParseUtils.parseFromScanner(String.class));
            }
        }
    }

    public void changeDateOfBirth() {
        System.out.println("Enter id: ");
        int id = (Integer) ParseUtils.parseFromScanner(Integer.class);
        for (Person person : list) {
            if (id == person.getIdPerson()) {
                System.out.println("Rename to: ");
                person.setDateOfBirth((Date) ParseUtils.parseFromScanner(Date.class));
            }
        }
    }

    public void changeAddress() {
        System.out.println("Enter id: ");
        int id = (Integer) ParseUtils.parseFromScanner(Integer.class);
        for (Person person : list) {
            if (id == person.getIdPerson()) {
                System.out.println("Rename to: ");
                person.setAddress((String) ParseUtils.parseFromScanner(String.class));
            }
        }
    }

    public void changeGender() {
        System.out.println("Enter id: ");
        int id = (Integer) ParseUtils.parseFromScanner(Integer.class);
        for (Person person : list) {
            if (id == person.getIdPerson()) {
                System.out.println("Rename to: ");
                person.setGender((String) ParseUtils.parseFromScanner(String.class));
            }
        }
    }

    public void changeId() {
        System.out.println("Enter id: ");
        int id = (Integer) ParseUtils.parseFromScanner(Integer.class);
        for (Person person : list) {
            if (id == person.getIdPerson()) {
                System.out.println("Rename to: ");
                person.setIdPerson((Integer) ParseUtils.parseFromScanner(Integer.class));
            }
        }
    }

    public void deletePerson() {
        try {
            System.out.println("Enter id: ");
            int id = (Integer) ParseUtils.parseFromScanner(Integer.class);
            for (Person person : list) {
                if (id == person.getIdPerson()) {
                    list.remove(person);
                }
            }
        } catch (Exception e) {
            System.out.println("List empty");
        }

    }

    public void findPerson() {
        System.out.println("Enter id: ");
        int id = (Integer) ParseUtils.parseFromScanner(Integer.class);
        for (Person person : list) {
            if (id == person.getIdPerson()) {
                System.out.println(person);
            }
        }
    }

    public void writeToFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("src/List.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
    }

    public void writeFileToList() {
        try {
            FileInputStream fis = new FileInputStream("src/List.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Person> listFile = (List<Person>) ois.readObject();
            for (int i = 0; i < listFile.size(); i++) {
                list.add(listFile.get(i));
            }
        } catch (Exception e) {
            System.out.println("File is empty");
        }
    }

    public void salaryManager() {
        Salary salary = new Salary();
        System.out.println("Enter id: ");
        int id = (Integer) ParseUtils.parseFromScanner(Integer.class);
        for (Person person : list) {
            if (id == person.getIdPerson()) {
                System.out.println("Enter number day off: ");
                salary.setDayOff((Integer) ParseUtils.parseFromScanner(Integer.class));
                System.out.println("Enter the month/year you want display salary: ");
                int dayOfMonth = dayOfMonth();
                salary.setWorkingDays(dayOfMonth - salary.getDayOff());
                person.getSalary(salary);
                System.out.println(salary.getSalary());
            }
        }
    }


    public int dayOfMonth() {
//        checkDayOfMonth();

        int dayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int weekends = 0;
        for (int i = 0; i < dayOfMonth; i++) {
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == Calendar.SUNDAY) {
                weekends++;
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        return dayOfMonth - weekends;
    }


    public void checkDayOfMonth() throws ParseException {

        Date date = new SimpleDateFormat("dd/MM/yyyy").parse("11/10/2020");
        System.out.println(date);
        System.out.println("Enter a month/year: ");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime((Date) ParseUtils.parseFromScanner(Date.class, "MM/yyyy", "^(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$"));
        boolean rs = calendar.getTime().after(date);
        System.out.println(calendar.getTime());
        System.out.println(rs);
    }

    public static void main(String[] args) {
        try{
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse("11/10/2020");
            System.out.println(new SimpleDateFormat("MM").format(date));
        }catch(Exception e){}
    }
}


