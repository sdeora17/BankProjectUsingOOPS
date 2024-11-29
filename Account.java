public abstract class Account{
  private String name;
  private String accountNumber;
  private double balance;
  private String uniqId;

  public Account(String name,String accountNumber, double balance,String uniqId){
    this.name = name;
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.uniqId = uniqId;
    System.out.println(uniqId);
  }

  public abstract void deposit(double amount);
  public abstract void withdrawl(double amount);
  public abstract String type();

  public String getUniqId(){
    return uniqId;
  }


  public double getBalance(){
    return balance;
  }

  public void updateBalance(double amount){
    this.balance = amount;
  }

  public String getAccountNumber(){
    return accountNumber;
  }
}