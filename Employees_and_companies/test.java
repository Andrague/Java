import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

public class test {

    public static void main(String[] args) {
        // Create an employee
    	Employee employee1 = new Employee("John", "Doe", 20.0);
        employee1.setBankAccount("123456789");
        System.out.println("Employee: " + employee1.getName() + " " + employee1.getSurname());
        System.out.println("Bank Account: " + employee1.getBankAccount());
        // Generate an array of random Employees
        Employee[] randomEmployees = Employee.randomEmployees1(5);
        System.out.println("\nRandom Employees (Before Sorting):");
        for (Employee emp : randomEmployees) {
            System.out.println(emp.getName() + " " + emp.getSurname() + " - Total Salary: " + emp.getSumOfSalaries());
        }
        // Sort the random Employees array based on total salary
        Arrays.sort(randomEmployees);

        System.out.println("\nRandom Employees (After Sorting by Total Salary):");
        for (Employee emp : randomEmployees) {
            System.out.println(emp.getName() + " " + emp.getSurname() + " - Total Salary: " + emp.getSumOfSalaries());
        }

        // Alternatively, use an ArrayList and Collections.sort for sorting
        ArrayList<Employee> employeeList = new ArrayList<>(Arrays.asList(randomEmployees));
        Collections.sort(employeeList); // This also uses the compareTo method for sorting

        System.out.println("\nRandom Employees (After Sorting using ArrayList):");
        for (Employee emp : employeeList) {
            System.out.println(emp.getName() + " " + emp.getSurname() + " - Total Salary: " + emp.getSumOfSalaries());
        }
        // Create a manager
        Manager manager = new Manager(employee1);
        System.out.println("Manager Salary (Month 1): " + manager.getSalary(1));

        // Add subordinates to the manager
        Employee subordinate1 = new Employee("Alice", "Johnson", 15.0);
        Employee subordinate2 = new Employee("Bob", "Smith", 18.0);

        manager.addSubordinate(subordinate1);
        manager.addSubordinate(subordinate2);

        System.out.println("Manager Bonus: " + manager.getBonus());
        System.out.println("Manager Salary with Bonus (Month 1): " + manager.getSalary(1));

        // Set a new rate for the manager
        Manager.setRate(7.0);
        System.out.println("Updated Manager Rate: " + Manager.getRate());
        System.out.println("Manager Salary with Updated Bonus (Month 1): " + manager.getSalary(1));
        System.out.println();

        Company company = new Company();
        for (int i = 0; i < 10; i++) {
            Employee newEmployee = Employee.randomEmployee();
            company.addEmployee(newEmployee);
            System.out.println(newEmployee.getName() + " " + newEmployee.getSurname() + " Salary in Month 1: " + newEmployee.getSalary(1));
        }

        company.print();
        printMonthlySalaryReport(company, 1);

        int x=0;
        do {
            try {
                // Assuming Databases.getEmployees() is a method that might throw custom exceptions
                ArrayList<Employee> emps = Databases.getEmployees();
                System.out.println("Employee data retrieved successfully.");
            } catch (ServerTooBusyException e) {
                System.out.println("Server too busy, do you want to try again? Enter 1 to retry, any other number to exit.");
                Scanner scanner = new Scanner(System.in);
                x = scanner.nextInt();
            } catch (DatabaseException e) {
                System.out.println("An unexpected database error occurred: " + e.getMessage());
                x = 0; // Assuming we do not retry on database exceptions
            }
        } while (x == 1);
    }

    private static void printMonthlySalaryReport(Company company, int month) {
        // Assuming Company class has a method to print monthly salary report
        company.printMonthlySalaryReport("report.txt", month);
    }
 // Generate an array of random Employees


}