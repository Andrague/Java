
public class Bank {
public static void moneyTransfer(Company company, Employee employee, double amount) throws TransferException{
	if(Math.random()<0.3) throw new TransferException("Lack of account funds!"); 
}
}
