import java.io.*;
import java.util.*;

class PersonManager {
    private ArrayList<Recipient> data = new ArrayList<Recipient>();
    
    public PersonManager(){
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
            e.printStackTrace();
        }
    }

    public void addNew(String details){
        String[] arr = details.split(":");
        Recipient r = new CreateResipientFactory(arr[0],arr[1]).Build();
        data.add(r);
    }

    public void saveToFile(String details) {
        try {
            FileWriter myWriter = new FileWriter("src/clientList.txt",true);
            myWriter.write(System.lineSeparator()+details);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void printData(){
        System.out.println("Printing all person data =>");
        for (Recipient r:data){
            System.out.println(r.getData());
        }
    }
}