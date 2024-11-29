public class Savings extends Account{
  private double interestRate;
  // double initial = 0;
  // private StringBuffer uniqId;
  Savings(String name,String accountNumber,double initialBalance,double interestRate,String uniqId){
    super(name,accountNumber, initialBalance,uniqId);
    this.interestRate = interestRate;
    // this.uniqId = uniqId;
  }
  @Override
  public String type(){
    return "Savings Account";
  }
  
  @Override
  public void deposit(double amount){
    double initial = getBalance();
    initial = initial + amount;
    updateBalance(initial);
  }
  
  @Override
  public void withdrawl(double amount){
    double initial = getBalance();
    if(initial>=amount){
      initial = initial - amount;
      updateBalance(initial);
    }else{
      System.out.println("Insufficient Balance\n");
    }
  }
  
  public void addInterest(){
    double initial = getBalance();
    double interest = initial * interestRate/100;
    initial = initial + interest;
    updateBalance(initial);
  }

}
