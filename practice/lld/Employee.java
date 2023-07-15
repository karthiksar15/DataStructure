package practice.lld;

import java.util.List;

public class Employee {
    private String name;
    private Gender gender;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void assignManager(Employee employee) {

    }

    public List getDirectReports() {
        return null;
    }

    public List getTeamMates() {
        return null;
    }

}
