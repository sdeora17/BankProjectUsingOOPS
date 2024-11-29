public class Checking extends Account{
  private double overdraftLimit;
  
  double initial = getBalance();

  public Checking(String name,String accountNumber,double initialBalance,double overdraftLimit,String uniqId){
    super(name,accountNumber, initialBalance,uniqId);
    this.overdraftLimit = overdraftLimit;
  }

  @Override
  public String type(){
    return "Checking Account";
  }

  @Override
  public void deposit(double amount){
    initial = initial + amount;
    updateBalance(initial);
    System.out.println("Amount Deposited");
  }
  @Override
  public void withdrawl(double amount){
    if(initial + overdraftLimit>= amount){
      initial = initial - amount;
      updateBalance(initial);
    }else{
      System.out.println("Overdraft Limit Exceeded");
    }
  }
}