public class FixedDeposit extends Account {
  private double interestRate;
  private int maturityPeriod;
  private boolean matured;
  private String uniqId;

  FixedDeposit(String name,String accountNumber,double initialBalance,double interestRate,int maturityPeriod,String uniqId){
    super(name,accountNumber, initialBalance,uniqId);
    this.interestRate = interestRate;
    this.maturityPeriod = maturityPeriod;
    this.matured = false;
    this.uniqId = uniqId;
  }


  @Override
  public String type(){
    return "Fixed Account";
  }

  
  @Override
  public void deposit(double amount){
    System.out.println("You cannot Deposit a fixed Deposit Account");
  }
  @Override
  public void withdrawl(double amount){
    double initial = getBalance();
    if(matured){
      initial -= amount;
      updateBalance(initial);
    }else{
      System.out.println("Cannot Withdraw Before Maturity");
    }
  }
  
  public void matureAccount(){
    matured = true;
    double initial = getBalance();
    double interest =  initial * interestRate/100;
    initial = initial + interest;
    updateBalance(initial);
  }
}
