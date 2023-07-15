package practice.lld;

import java.util.List;

public class Company {
    private Employee employee;


    public void registerEmployee(String employeeName, Gender gender) {
        employee = new Employee(employeeName);
        employee.setGender(gender);
    }

    public Employee getEmployee(String employeeName) {
        this.employee = new Employee(employeeName);
        return this.employee;
    }

    public void deleteEmployee(String employeeName) {

    }

    void assignManager(String employeeName, String managerName) {

    }

    public List getDirectReports(String managerName) {
        return null;
    }

    public List getTeamMates(String employeeName) {
        return null;
    }

    public List<List> getEmployeeHierarchy(String managerName) {
        return null;
    }
}
