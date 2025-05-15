import java.io.*;
import java.util.*;

class RecipientManager {
    private static ArrayList<Recipient> data = new ArrayList<Recipient>();

    String today = new Date().getToday(); // current date

    public RecipientManager(){
        File myObj = new File("src/clientList.txt");
        try {
            Scanner myReader;
            myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String details = myReader.nextLine();
                this.addNew(details); 
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            //System.out.println("ClientList.txt File not found.");
            //e.printStackTrace();
        }
    }

    public void addNew(String details){
        String[] arr = details.split(":");
        Recipient r = new CreateResipientFactory(arr[0],arr[1]).Build();
        data.add(r);
        checkBirthday(r);
    }

    ///// if today is recipient's birthdat, send a birthday wish mail 
    public void checkBirthday(Recipient r){
        if (r instanceof Official_Recipient) {
            return;
        }
        if(r.getBirthday().substring(5).equals(today.substring(5)) ){
            Mail newMail = new Mail(r.getEmail(),"Birthday wish!",r.getMessage());
            if (!MailManager.isExist(newMail)){
                // send an email & if sent serealize mail object
                newMail.send(); 
            }
        }
    }
    
    ///// save recipient data in file
    public void saveToFile(String details) {
        try {
            FileWriter myWriter = new FileWriter("src/clientList.txt",true);
            myWriter.write(details+System.lineSeparator());
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred when writing to the file.");
            //e.printStackTrace();
        }
    }

    //Printing all recipients who have birthdays on given date
    public void printRecipients(String date) {
        System.out.println("\nPrinting all recipients who have birthdays on " + date
        + " =>\n");
        boolean found = false;
        for (Recipient r:data){
            if (r.getBirthday() == null){
                continue;
            }
            else if(r.getBirthday().substring(5).equals(date) ){
                System.out.println(r.getData());
                found = true;
            }
        }

        if (!found){
            System.out.println("No recipients have birthdays on " + date );
        }
    }
}