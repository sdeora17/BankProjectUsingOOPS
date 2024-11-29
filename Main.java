import java.util.*;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String adminUsername = "admin";
    String adminPassword = "admin123";

    ArrayList<Manager> managers = new ArrayList<>();
    boolean isAdminAuthenticated = false;


    System.out.println("Enter Admin Username");
    String AdminUsername = sc.next();
    System.out.println("Enter Admin Password");
    String AdminPassword = sc.next();

    if(AdminUsername.equals(adminUsername) && AdminPassword.equals(adminPassword)){
      isAdminAuthenticated = true;
      System.out.println("Admin Login Succesfully");
    }else{
      System.out.println("Admin Authentication Failed");
      return;
    }

    while(isAdminAuthenticated){
      System.out.println("\nAdmin Menu");
      System.out.println("\n1. Create Manager");
      System.out.println("\n2. Login as a Manager");
      System.out.println("\n3. Exit");
      int adminChoice = sc.nextInt();


      switch (adminChoice) {
        case 1:
          System.out.println("Enter Manager Username");
          String managerUsername = sc.next();
          System.out.println("Enter Manager Password");
          String managerPassword = sc.next();
          
          if(isManagerExists(managers,managerUsername,managerPassword)){
            System.out.println("Manager Already Exists");
          }else{
            managers.add(new Manager(managerUsername,managerPassword));
            System.out.println("Manager Created Successfully");
          }
          break;
        case 2:
          System.out.println("Enter Manager Username");
          String enteredManagerUsername = sc.next();
          System.out.println("Enter Manager Password");
          String enteredManagerPassword = sc.next();
          Manager ob1 = autheticateManager(managers, enteredManagerUsername, enteredManagerPassword);
          if(ob1!=null){
            System.out.println("Manager Authenticated Succefully");
            MainMenu(ob1);
          }else{
            System.out.println("User not Authenticated");
          }
          break;
        case 3:
          return;
        default:
          break;
      }
    }

    // 
    // ob1.addAccount(new Savings("Siddhant",1213141,10000,2.5,"Sidd1213"));
    // 
    // ob1.addAccount(new Checking("NEW01031", 20000, 4000));
    
    // // ob1.addAccount(new FixedDeposit("ABCDEF", 10000, 2.5, 36, true));
    
    // ob1.addAccount(new FixedDeposit("A1", 1000, 2, 12));
    
    // ob1.depositAccount("A1", 100);
    // ob1.showBalances();
    // // ob1.showBalances();
    
    // ob1.displayBalance("A1");
    
    // ob1.depositAccount("ABCD", 1200);
    // ob1.showBalances();
    // ob1.depositAccount("ABCD", 1200);
    // ob1.showBalances();
    // ob1.depositAccount("NEW01031", 5000);
    // ob1.showBalances();
    
    
  }

  public static void MainMenu(Manager ob1){
    
  
    int choice;
    Scanner sc = new Scanner(System.in);
    // Manager ob1 = new Manager();
    String AccountNumber;
    String name; 
    double balance,interestRate;
    double overdraftLimit;
    int maturity;
    StringBuffer uniqId = new StringBuffer();
    String password;    
    while(true){
      System.out.println("Menu Driven");
      System.out.println("1. Add A Savings Account\n");
      System.out.println("2. Add A Fixed Deposit Account\n");
      System.out.println("3. Add A Checking Account\n");
      System.out.println("4. Show Balance\n");
      System.out.println("5. Display All Account\n");
      System.out.println("6. Withdraw Money\n");
      System.out.println("7. Deposit Money\n");
      System.out.println("8. Mature an FD Account");
      choice = sc.nextInt();
      switch(choice){
        case 1:
          System.out.println("Enter Your Name");
          name = sc.next();
          System.out.println("Enter Your Account Number");
          AccountNumber = sc.next().toLowerCase();
          System.out.println("Enter Your Balance");
          balance = sc.nextInt();
          System.out.println("Enter The Interest Rate");
          interestRate = sc.nextDouble();
          uniqId.append(AccountNumber.substring(0, 4));
          uniqId.append(name.substring(0,4));
          ob1.addAccount(new Savings(name,AccountNumber,balance,interestRate,uniqId.toString()));
          uniqId.setLength(0);
          break;
        case 2:
            System.out.println("Enter Your Name");
            name = sc.next();
            System.out.println("Enter Your Account Number");
            AccountNumber = sc.next().toLowerCase();
            System.out.println("Enter Your Balance");
            balance = sc.nextInt();
            System.out.println("Enter The Interest Rate");
            interestRate = sc.nextDouble();
            System.out.println("Enter The Maturity Months");
            maturity = sc.nextInt();
            uniqId.append(AccountNumber.substring(0,4));
            uniqId.append(name.substring(0,4));
            ob1.addAccount(new FixedDeposit(name,AccountNumber,balance,interestRate,maturity,uniqId.toString()));
            uniqId.setLength(0);
            break;
        case 3:
            System.out.println("Enter Your Name");
            name = sc.next();
            System.out.println("Enter Your Account Number");
            AccountNumber = sc.next().toLowerCase();
            System.out.println("Enter Your Balance");
            balance = sc.nextInt();
            System.out.println("Enter the Overdraft Limit");
            overdraftLimit = sc.nextDouble();
            uniqId.append(AccountNumber.substring(0, 4));
            uniqId.append(name.substring(0,4));
            ob1.addAccount(new Checking(name,AccountNumber,balance,overdraftLimit,uniqId.toString()));
            uniqId.setLength(0);
            break;
        case 4:
          System.out.println("Enter Your Account Number");
          AccountNumber = sc.next().toLowerCase();
          System.out.println("Enter Your Password");
          password = sc.next();
          ob1.displayBalance(AccountNumber,password);
          uniqId.setLength(0);
          break;
        case 5:
          ob1.showBalances();
          break;
        case 6:
          System.out.println("Enter Your Account Number");
          AccountNumber = sc.next().toLowerCase();
          System.out.println("Enter The Amount You want to withdraw");
          balance = sc.nextInt();
          System.out.println("Enter Your Password");
          password = sc.next();
          ob1.withdrwalAccount(AccountNumber, balance, password);
          break;
        
        case 7:
          System.out.println("Enter Your Account Number");
          AccountNumber = sc.next().toLowerCase();
          System.out.println("Enter the amount You want to deposit");
          balance = sc.nextDouble();
          ob1.depositAccount(AccountNumber, balance);
          break;
        
        case 8:
          System.out.println("Enter the Account Number");
          AccountNumber = sc.next().toLowerCase();
          ob1.matureFD(AccountNumber);
          break;
      }
    }
  }


  public static boolean isManagerExists(ArrayList<Manager> managers,String username,String password){
    for(Manager manager:managers){
      if(manager.getUsername().equals(username)){
        return true;
      }
    }
    return false;
  }


  public static Manager autheticateManager(ArrayList<Manager> managers,String username,String password){
    for(Manager manager:managers){
      if(manager.logic(username, password)){
        return manager; 
      }
    }
    return null;
  }
}
