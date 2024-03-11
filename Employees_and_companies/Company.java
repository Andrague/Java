import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
	private String name;
	private ArrayList<Employee> employees = new ArrayList<>();

	public void addEmployee(Employee randomEmployee) {
	    employees.add(randomEmployee);
	}

	public List<Employee> getEmployees() {
	    return Collections.unmodifiableList(employees);
	}
    //private ArrayList<Employee> employees = new ArrayList<>();
   // public void addEmployee(Employee randomEmployee) {
   //     employees.add(randomEmployee);
   // }
	public void print() {
		for(Employee e:employees) {
			System.out.println(e);
		}
	}
	public int numberOfManagers() {
	    int number = 0;
	    double sumOfBonuses = 0;

	    for (Employee e : employees) {
	        if (e instanceof Manager) {
	            number++;
	            Manager m = (Manager) e;
	            sumOfBonuses += m.getBonus();
	        }
	    }
	    

	    // You can print the sumOfBonuses or use it as needed.

	    return number;
	}
	/*public int numberOfManagers() {
			int number=0;
			for(Employee e:employees) {
				if(e instanceof Manager) {
					number++;
				}
			}
			return number;
	}*/
	public double sumOfBonesesManager() {
		double sum=0;
		for(Employee e:employees) {
			if(e instanceof Manager) {
				Manager m=(Manager) e;
				sum+=m.getBonus();
				}
		}
		return sum;
	}
	public void saveEmployees(String path) throws IOException {
		BufferedWriter b= new BufferedWriter(new FileWriter(path));
		for(Employee e:employees) {
			b.write(e.toString());
			b.newLine();
		}
		b.close();
	}

	void printMonthlySalaryReport(String path, int month) {
	    try (PrintWriter p = new PrintWriter(path)) {
	        for (Employee e : employees) {
	            p.println(e.getName());
	            p.print(e.getSurname());
	            p.print(e.getSalary(month));
	            p.print(e.getWorkingHours(month));
	            //p.print("\n");
	        }
	        System.out.println("Monthly salary report successfully generated and saved to " + path);
	        p.close();
	    } catch (FileNotFoundException e) {
	        System.out.println("Error: Monthly salary report could not be generated. File not found: " + path);
	    }
	  
	}
	public void raport2(String path) throws IOException{
		PrintWriter w=new PrintWriter(path);
		for(Employee e:employees) {
			w.println(e.getSumOfSalaries());
			w.println(e);
			w.println("-----------------------");
		}
		boolean b=true;
		w.print(b);
		w.close();
	}
	public Employee[] busyEmployees(int month) {
	ArrayList<Employee> busy = new ArrayList<>();
	int max = this.getMostBusyEmployee(month).getWorkingHours(month);

	employees.forEach(e -> {
	    if (e.getWorkingHours(month) == max) {
	        busy.add(e);
	    }
	});

	Employee[] a = new Employee[busy.size()];
	return busy.toArray(a);
	}

	private Employee getMostBusyEmployee(int month) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	//public ArrayList<Employee>paySalaries(int month){
	//	 for (Employees e:employee) {
	//		        Employee employee = employees.get(i);
	//		      double salary =employee.getSalary(month);
	//		        Bank.moneyTransfer(this, employee, salary);
	//		    }
	//}
	
	//public ArrayList<Employee> paySalaries(int month, ArrayList<Employee> employees) throws TransferException {
	 //   for (int i = 0; i < employees.size(); i++) {
	 //       Employee employee = employees.get(i);
	 //       double salary =employee.getSalary(month);
	//        Bank.moneyTransfer(this, employee, salary);
	 //   }
	//	return employees;
	//}
	
}
