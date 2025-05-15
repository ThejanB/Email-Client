// Index number - 200698X
// Name - Weerasekara W.M.T.B.
import java.util.*;

public class Email_Client {
    public static void main(String[] args){
        MailManager.deserializeMails(); // check if there is old data
        RecipientManager RecipientData = new RecipientManager();
        Scanner scanner = new Scanner(System.in);
        
        labal:
        while(true){
            try{
                
                System.out.println("-------------------------------------------------------------------------"+
                "\nEnter option type: \n"
                + "1 - Adding a new recipient\n"
                + "2 - Sending an email\n"
                + "3 - Printing out all the recipients who have birthdays on the given date\n"
                + "4 - Printing out details of all the emails sent on the input date\n"
                + "5 - Printing out the number of recipient objects in the application\n"
                + "6 - End the program");
                
                int option = scanner.nextInt();
                switch(option){
                    case 1:
                        ///// Adding a new recipient /////
                        System.out.println("\nEnter new recipient : \n"
                        + "input format - Official: nimal,nimal@gmail.com,ceo\n"
                        + " Office_friend: kamal,kamal@gmail.com,clerk,2000/12/12\n"
                        + " Personal: sunil,<nick-name>,sunil@gmail.com,2000/10/10" );
                        
                        Scanner scanner1 = new Scanner(System.in);
                        String input1 = scanner1.nextLine();
                        
                        RecipientData.addNew(input1); // add a new  recipient 
                        RecipientData.saveToFile(input1); // store details in clientList.txt file
                        
                        break;

                    case 2:
                        ///// Sending an email /////
                        System.out.println("\nEnter the e-mail , subject & content :\n"
                        +"Input format - email, subject, content ");
                        Scanner scanner2 = new Scanner(System.in);
                        String input2 = scanner2.nextLine();
                        String[] arr = input2.split(",");
                        Mail newMail = new Mail(arr[0],arr[1],arr[2]);
                        newMail.send(); // send an email & if sent serealize mail object
                        break;

                    case 3:
                        ///// Printing out all the recipients who have birthdays on the given date /////
                        System.out.println("\nEnter date : \n"
                        +"Input format - yyyy/MM/dd");
                        Scanner scanner3 = new Scanner(System.in);
                        String input3 = scanner3.nextLine();
                        
                        RecipientData.printRecipients(input3.substring(5)); // print recipients who have birthdays on the given date
                        break;

                    case 4:
                        ///// Printing out details of all the emails sent ///// 
                        System.out.println("\nEnter date : \n"
                        +"input format - yyyy/MM/dd (ex: 2018/09/17)");
                        Scanner scanner4 = new Scanner(System.in);
                        String input4 = scanner4.nextLine();
                        MailManager.printSentDataOn(input4); // print the details of all the emails sent on the input date
                        break;

                    case 5:
                        ///// Printing out the number of recipient objects in the application /////
                        System.out.println("\nNumber of recipient objects in the application = " 
                        + Recipient.getCount()); // print the number of recipient objects in the application
                        break;

                    case 6:
                        System.out.println("\nprogram closed\n");
                        break labal;

                    default:
                        System.out.println("\nInvalid input.");
                }
        }
        catch(Exception e){
            System.out.println("\nInvalid input.");
            break labal;
        }
        }
        scanner.close();
    }
}