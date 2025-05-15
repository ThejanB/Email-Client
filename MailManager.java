import java.io.*;
import java.util.*;

abstract class MailManager implements Serializable{
    private static ArrayList<Mail> data = new ArrayList<Mail>();

    public static void save(Mail email){
        data.add(email);
        serializeMails(email);
    }

    public static void printSentDataOn(String date){
        boolean found = false;
        for (Mail m:data){
            if (m.getSentDate().equals(date)){
                System.out.println("\n" + m.getData());
                found = true;
            } 
        }
        if (!found){
            System.out.println("No sent emails on " + date + "\n");
        }
    }
    
    public static boolean isExist(Mail mail){
        for (Mail m:data){
        //System.out.println(m.getSentDate());
            if(m.getData().equals(mail.getData())){
                return true;
            }
        }
        return false;
    }

    public static void serializeMails(Mail email){ 
        try {
            FileOutputStream fileOut = new FileOutputStream("src/output.ser",true);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(email);
            out.flush(); 
            fileOut.close();
        } 
        catch (IOException e) {
            System.out.println("An error occurred when serializing.");
        }
    }

    public static void deserializeMails(){ 
        String filename = "src/output.ser";
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream inObj = null;
            while(true){
                try{
                    inObj = new ObjectInputStream(fileIn);
                    Mail obj = (Mail)inObj.readObject();
                    data.add(obj);
                }catch(EOFException e){
                    break;
                }
            }
            inObj.close();
            fileIn.close();
            System.out.println("\nDeserialized data from src/serializeData.ser\n");
            return; 
        }
        catch(EOFException e){
            //System.out.println("Serialized file is empty.");
            return;
        }
        catch (FileNotFoundException e) {
            //System.out.println("No serialized data found.");
            return;
        }
        catch (IOException e) {
            System.out.println("An error occurred when deserializing.");
            return;
        } 
        catch (ClassNotFoundException e) {
            System.out.println("Mail class not found");
            return; 
        }
    }
}