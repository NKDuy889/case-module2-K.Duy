package model;

import util.ParseUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Person implements Serializable {
    private String name;
    private Date dateOfBirth;
    private String address;
    private String gender;
    private int idPerson;
    private HashMap<String , Salary> hashMap = new HashMap<>();

    public Person() {
    }

    public HashMap<String, Salary> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<String, Salary> hashMap) {
        this.hashMap = hashMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public static <T extends Person> T create(Class<T> clazz, List<Person> personList) {
        try {
            T t = (T) clazz.newInstance();
            System.out.println("Enter the name: ");
            t.setName(ParseUtils.parseFromScanner(String.class).toString());
            System.out.println("Enter date of birth: ");
            t.setDateOfBirth((Date) ParseUtils.parseFromScanner(Date.class));
            System.out.println("Enter address: ");
            t.setAddress(ParseUtils.parseFromScanner(String.class).toString());
            System.out.println("Enter gender: ");
            t.setGender(ParseUtils.parseFromScanner(String.class).toString());
            int id;
            do {
                System.out.println("Enter id: ");
                id = (Integer) ParseUtils.parseFromScanner(Integer.class);
                t.setIdPerson(id);
            } while (checkId(personList, id));
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static boolean checkId(List<Person> personList, int id) {
        for (Person person : personList) {
            if (person.getIdPerson() == id) {
                System.out.println("Id exist. Try again: ");
                return true;
            }
        }
        return false;
    }

    public void getSalary(Salary salary) {
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", dateOfBirth: " + dateOfBirth +
                ", address: " + address +
                ", gender: " + gender +
                ", idPerson: " + idPerson + ", ";
    }
}
