package DataAnalyzer;

//First, we will declare an Employee class 
//which represents the employee's 
//details like ID, name, departement, and salary.

    import java.util.Optional;

public class Employee {
    private int id;
    private String name;
    private String department;
    private Double salary;

    public Employee(int id, String name, String department, Double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public Optional<Double> getSalary() {
        return Optional.ofNullable(salary);
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + '}';
    }
}
    

