import java.util.*;

public class Manager {
  private String username;
  private String password;

  Manager(String username,String password){
    this.username = username;
    this.password = password;
  }


  private List<Account> accounts = new ArrayList<>();

  public void addAccount(Account account){
    accounts.add(account);
  }

  public boolean logic(String username,String password){
    return this.username.equals(username) && this.password.equals(password);
  }

  public String getUsername(){
    return username;
  }



  public void showBalances(){
    for(Account account:accounts){
      System.out.println("Account "+ account.getAccountNumber());
      System.out.println("Balance "+ account.getBalance());
    }
  }
  public void displayBalance(String accountNumber,String password){
    Account account = findAccount(accountNumber);

    if(account!=null){
      String uniqId = (account.getUniqId());
      if(password.equals(uniqId.toString())){
        System.out.println("Account Number"+account.getAccountNumber());
        System.out.println("Balance of the Account"+ account.getBalance());
      }else{
        System.out.println("Incorrect Password");
      }
    }
    else{
      System.out.println("Account Not Found");
    }
  }

  public void depositAccount(String accountNumber, double amount){
    Account account = findAccount(accountNumber);

    if(account != null){

      if(account.type()!= "Fixed Account"){
        account.deposit(amount);
        System.out.println("Deposited "+ amount+" to account "+accountNumber);
      }else{
        System.out.println("Cannot Deposit in A FD Account");
      }
    }else{
      System.out.println("Account Not Found\n");
    }
  }

  public void withdrwalAccount(String accountNumber,double amount,String password){
    Account account = findAccount(accountNumber);

    if(account!=null){
      String uniqId = account.getUniqId();
      if(password.equals(uniqId.toString())){
        account.withdrawl(amount);
        if(account.type()!="Fixed Account"){
          System.out.println("Amount withdrawn"+amount+ "From account" + accountNumber+"\n");
        }
      }else{
        System.out.println("Incorrect Password");
      }
    }else{
      System.out.println("Account Does not Exist\n");
    }
  }

  private Account findAccount(String accountNumber){
    for(Account account:accounts){
      if(account.getAccountNumber().equals(accountNumber)){
        account.type();
        return account;
      }
    }
    return null;
  }

  public void matureFD(String accountNumber){
    Account account = findAccount(accountNumber);

    if(account != null && account instanceof FixedDeposit){
      FixedDeposit fdAccount = (FixedDeposit) account;
      fdAccount.matureAccount();
      System.out.println("Account "+ accountNumber + " has been matured.");
    }else{
      System.out.println("Account Not Found");
    }
  }

}
