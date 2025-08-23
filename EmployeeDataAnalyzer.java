package DataAnalyzer;

//This is the entry point of our system. 
//It demonstrates how to add employees, 
//process their data using threads, filter and 
//sort employees, and handle errors. 
//The main class uses EmployeeManager 
//to manage employees and EmployeeProcessor 
//to process them concurrently.

import java.util.List;
public class EmployeeDataAnalyzer {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();

        //adding employees
        employeeManager.addEmployee(new Employee(1, "Ravi", "IT", 60000.00)); 
        employeeManager.addEmployee(new Employee(2, "Vicky", "MBBS", 98000.00));
        employeeManager.addEmployee(new Employee(3, "Kundan", "MECH", 90000.00));
        employeeManager.addEmployee(new Employee(4, "Rupa", "GYNO", 80000.00));
        employeeManager.addEmployee(new Employee(5, "Raushan", "GOVERNMENT", 50000.00));
        

        //processing employees by id using multithreading
        Thread processor1 = new EmployeeProcessor(employeeManager, 1);
        Thread processor2 = new EmployeeProcessor(employeeManager, 3);
        Thread processor3 = new EmployeeProcessor(employeeManager, 5);
        Thread processor4 = new EmployeeProcessor(employeeManager, 7);

        processor1.start();
        processor2.start();
        processor3.start();
        processor4.start();

        // Wait for threads to complete
        try {
            processor1.join();
            processor2.join();
            processor3.join();
        } catch (InterruptedException e) {
            System.out.println("Error waiting for thread completion: " + e.getMessage());
        }

        
        // Filtering employees based on salary
        System.out.println("\nEmployees with salary >= 70000:");
        List<Employee> highEarners = employeeManager.filterEmployeesBySalary(70000.0);
        highEarners.forEach(System.out::println);

        // Sorting employees by salary
        System.out.println("\nEmployees sorted by salary:");
        List<Employee> sortedEmployees = employeeManager.sortEmployeesBySalary();
        sortedEmployees.forEach(System.out::println);
    }
}
