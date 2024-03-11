import java.util.ArrayList;

public class Manager extends Employee {
    private static double rate = 5;
    private ArrayList<Employee> subordinates = new ArrayList<>();

    public static double getRate() {
        return rate;
    }

    public static void setRate(double rate) {
    	Manager.rate=rate;
       // rate = newRate; 
    }

    public Manager(Employee e) {
        super(e.getName(), e.getSurname(), e.getMoneyPerHour());
        this.setHoursInMonth(e.getHoursInMonth());
    }

    public void addSubordinate(Employee e) {
        this.subordinates.add(e);
    }

    public int getNumberOfSubordinates() {
        return subordinates.size();
    }

    public double getBonus() {
        return Manager.rate * getNumberOfSubordinates();
    }

    @Override
    public double getSalary(int month) {
       return super.getSalary(month) +this.getBonus();
    }
    
    @Override
    public String toString() {
    	return "Manager"+super.getName()+super.getSurname();
    }
    
}
