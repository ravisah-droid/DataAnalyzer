package DataAnalyzer;
//This class process employee data in a separate thread.

//To handle multiple employees at the same time, 
//we use multithreading. 
//The EmployeeProcessor class extends Thread 
//to process employee data in parallel. 
//If an employee doesn't exist, 
//it will print a helpful error message.

import java.util.Optional;
public class EmployeeProcessor extends Thread {
    private EmployeeManager employeeManager;
    private int employeeId;

    public EmployeeProcessor(EmployeeManager employeeManager, int employeeId) {
        this.employeeManager = employeeManager;
        this.employeeId = employeeId;
    }

    @Override
    public void run() {
        try {
            Optional<Employee> employee = 
                                 employeeManager.getEmployeeById(employeeId);
                                      employee.ifPresentOrElse(
                                            emp -> System.out.println("Processing employee:" + emp),
                                            () -> System.out.println("Employee with ID " + employeeId  + 
                         " not found.")
                                        );  
                                   } catch (Exception e) {
                                         System.out.println("Error processing employee data: " + e.getMessage());
                                   }   
        }                    
    }

