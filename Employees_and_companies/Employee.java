import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Employee implements Comparable<Employee>{

	private String name;
	private String surname;
	private double moneyPerHour;
	private int[] hoursInMonth = new int[12];
	private String bankAccount;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int[] getHoursInMonth() {
		return Arrays.copyOf(hoursInMonth, hoursInMonth.length);
	}

	public void setHoursInMonth(int[] hoursInMonth) {
		int len = this.hoursInMonth.length;
		if (hoursInMonth.length < len)
			len = hoursInMonth.length;
		for (int i = 0; i < len; i++)
			this.setWorkingHours(i, hoursInMonth[i]);
	}

	private static boolean isCorrectMonth(int month) {
		// correct if in 0..11
		if (month >= 0 && month <= 11)
			return true;
		else
			return false;
	}

	public void setWorkingHours(int month, int hours) {
		if (hours < 0)
			throw new IllegalArgumentException("Liczba godzin mniejsza od 0!");
		if (!isCorrectMonth(month))
			throw new IllegalArgumentException("Nieprawidłowy miesiąc!");
		hoursInMonth[month] = hours;
	}

	public int getWorkingHours(int month) {
		if (!isCorrectMonth(month))
			throw new IllegalArgumentException("Nieprawidłowy miesiąc!");
		return hoursInMonth[month];
	}

	public double getSalary(int month) {
		return this.getMoneyPerHour() * this.getWorkingHours(month);
	}

	public Employee(String name, String surname, double moneyPerHour) {
		
		this.setName(name);
		this.setSurname(surname);
		this.setMoneyPerHour(moneyPerHour);
	}

	public double getSumOfSalaries() {
		// returns the total sum of salaries
		double sum = 0;
		for (int i = 0; i < hoursInMonth.length; i++) {
			sum = sum + getSalary(i);
		}
		return sum;
	}

	public String toString() {
		return name + " " + surname + ":" + Arrays.toString(hoursInMonth) + ":" + this.getMoneyPerHour();
	}

	public int getMonthWithMaximumHours() {
		/*
		int maxMonth = 0;
		int maxHours=this.hoursInMonth[0];
		for(int i=1;i<this.hoursInMonth.length;i++) {
			if(hoursInMonth[i]>maxHours) {
				maxHours=hoursInMonth[i];
				maxMonth=i;
			}
		}
		
		return maxMonth;
		*/
		int maxMonth = 0;
		for(int i=1;i<this.hoursInMonth.length;i++) {
			if(hoursInMonth[i]>hoursInMonth[maxMonth]) {
				maxMonth=i;
			}
		}
		
		return maxMonth;
		
	}

	public static Employee[] randomEmployees(int n) {
		//complete the code
		Employee[] emps=new Employee[n];
		for(int i=0;i<emps.length;i++) {
			emps[i]=Employee.randomEmployee();
		}		
		return emps;
	}
	public static Employee randomEmployee() {
		String[] names = { "John", "Mary", "Alan", "Bart", "Ann", "Cindy", "Josh", "Jack" };
		String[] surnames = { "Smith", "Cooper", "Williams", "Taylor", "Brown", "Evans" };
		int[] hours = new int[12];
		Random r = new Random();
		for (int i = 0; i < hours.length; i++) {
			hours[i] = r.nextInt(10);
		}
		Employee e = new Employee(names[r.nextInt(names.length)], surnames[r.nextInt(surnames.length)], r.nextInt(100));
		for (int i = 0; i < hours.length; i++)
			e.setWorkingHours(i, hours[i]);
		return e;
	}

	public double getMoneyPerHour() {
		return moneyPerHour;
	}

	public void setMoneyPerHour(double moneyPerHour) {
		if (moneyPerHour < 0)
			throw new IllegalArgumentException("Stawka mniejsza od 0!");
		this.moneyPerHour = moneyPerHour;
	}
	ArrayList<Employee> employees=new ArrayList<Employee>();
	
	
	public void addEmployee(Employee e) {
		employees.add(e);
	}
	public void print() {
		employees.sort(null);
		for(Employee e: employees) {
			System.out.println(e+" "+e.getSumOfSalaries());
		}
	}



	 public String getBankAccount() {
	        return this.bankAccount;
	    }

	    public void setBankAccount(String bankAccount) {
	        this.bankAccount = bankAccount;
	    }
	 @Override
	 public int compareTo(Employee o) {
	        return Double.compare(this.getSumOfSalaries(), o.getSumOfSalaries());
	    }
	    public static Employee[] randomEmployees1(int n) {
	        Employee[] emps = new Employee[n];
	        for (int i = 0; i < emps.length; i++) {
	            emps[i] = Employee.randomEmployee();
	        }
	        return emps;
	    }

	}

	
//@Override
//	public String getBankAccount{
//		return this.bankAccount;
//	}

