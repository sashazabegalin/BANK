import java.util.*;
public class Bank {
  static BankAccount[] accounts = new BankAccount[1]; //This array will point to all the BankAccount objects
  static int noOfAccs = 0;           //Keeps track of the total number of accounts
  
  public static void main(String[] args) { 
	//call bankMenu
   bankMenu();
  }
  
  //bankMenu runs the main part of the program, until user selects 'Q'
  static void bankMenu(){
    int currentIndex = -1;
    char userSelection;
    boolean quit = false;
    Scanner reader = new Scanner(System.in);	//This variable tells us whether we are pointing to a valid account 
    
    printMenu(currentIndex);

    do{  
	 //display menu and ask for user selection
      System.out.println("Enter command:");
      userSelection = reader.next().charAt(0);
      switch(userSelection){ 
        case 'O': 
        //Open account 
          //make sure you have enough space or double size OF accounts array
		//make sure the account number is not a duplicate. Assign array index to account
          //set the current index;
          //increment the number of accounts
           
          
          if(noOfAccs >= accounts.length)
            accounts = resize();
         
          accounts[noOfAccs] = openAcc();
          currentIndex = noOfAccs;
          noOfAccs++;
          
          break;
        case 'D': //Deposit 
          //deposit only if currentIndex is not -1. you are depositing into a particular account 
          if(currentIndex != -1)
            accounts[currentIndex].deposit();          
            break;         
        case 'S': //Select account
          //look for account and if it exists, set currentIndex to it          
        case 'C': //Close account
          //if currentindex is not -1 close the account and reset currentIndex		            
        case 'W': //Withdraw
          //if current index is not -1, withdraw
          if(currentIndex != -1)
            accounts[currentIndex].withdraw ();          
            break;         

        case 'L': //List accounts
          //traverse through all the accounts and display their information
          listAccounts();
          break;
        case 'Q': //Quit
          //end the program
          quit = true;
         
      }
    }while(!quit);
  }

  //Print the menu, takes index of currently selected account
  static void printMenu(int index){
    //display menu 
    //if index is not -1 display the account information 
    System.out.println("O: Open account\nD: Deposit\nS: Select account\nC: Close account\nW: Withdraw\nL: List all accounts\nQ: Quit\n");
    if(index == -1)
      System.out.println("current account selected: NONE\n");
    else
       System.out.println("current account selected:" + index +"\n"); 
      }

 
  static BankAccount openAcc(){
    //Grab account number
    //validate for duplicate account number 
    //Grab balance
    //create new account and return the object so that the array index can point to the 
    //newly created object
    BankAccount newAcc;
    int input;
    double balance;
    Scanner reader = new Scanner(System.in);
    boolean valid = true;
    
    
    if(noOfAccs > 0)
    {   
          do{
          
          System.out.println("Enter new account number :");
          input = reader.nextInt();
          
          
          for (int i = 0; i < noOfAccs; i++) {
      
                if (accounts[i].getAcc() == input) {
                     System.out.println("Error: Duplicate\n");
                     valid = false;
      
                  }
      
             }
          
          
      	}while(!valid);
   }
   else
       System.out.println("Enter new account number :");
        input = reader.nextInt();

   
   System.out.println("Enter initial balance:");
   balance = reader.nextDouble();
   
   
   newAcc = new BankAccount(input,balance);
   
   
    
    return newAcc;
  }
  
  static BankAccount[] resize(){
	//resize array. Double the size
   BankAccount[] temp = new BankAccount[accounts.length * 2];
   System.arraycopy(accounts, 0, temp, 0, accounts.length);
   return temp;

  }

  static void listAccounts(){
	//Go through all the accounts using a for loop and display their content
   for(int i = 0; i < noOfAccs; i++){
      System.out.println(i+1 + ") Acct #:" + accounts[i].getAcc() + " Bal: " + accounts[i].getBalance() + "\n");
   }
  }

  static int selectAcc(){
    return 0;
    //ask for the account number, check to see if it exists and return index
  }
  
  static void closeAcc(int index){
    //move last account to the index that needs to be deleted 
    //set last account to null
    //decrement noOfAccts variable
  }
}

class BankAccount{
  private int accNbr;
  private double balance;
  
  BankAccount(int accNbr, double balance){
    //set instance variables
    this.accNbr = accNbr;
    this.balance = balance;
  }
  
  int getAcc(){
    //return accountNumber
    return accNbr;
  }
  
  double getBalance(){
   //return balance
   return balance;
  }
  
  void deposit(){     
	//add to deposit 
   Scanner reader = new Scanner(System.in); 
   double deposit;
   System.out.println("Enter amount of deposit: ");
   deposit = reader.nextDouble();
   balance += deposit;
  }
  
  void withdraw (){
    //withdraw as long as there is still $1 in the account
    Scanner reader = new Scanner(System.in);
    double withdraw;
    
    System.out.println("Enter amount to withdraw: ");
    withdraw = reader.nextDouble();
    
    if(withdraw < balance)
      balance -= withdraw;
    else
      System.out.println("You are withdrawing too much: try again");
  }
}
