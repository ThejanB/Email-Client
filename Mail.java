import java.io.*;
import java.util.*;
import javax.mail.*;

class Mail implements Serializable{
    private String toAddress;
    private String content;
    private String subject;
    private String sentDate;

    public Mail(String toAddress,String subject,String content){
        this.toAddress = toAddress;
        this.subject = subject;
        this.content = content;
        this.sentDate = new Date().getToday(); // current date;
    }
    
    public String getData() {
        return "To Address : " + this.toAddress + "\nsubject : " + this.subject + 
        "\ncontent : "+ this.content + "\n";
    }
    
    public void send() {
        final String username = "tbwweerasekara@gmail.com";
        final String password = "pnkpdrsxkcsawsct";
        //final String username = "thejanw.20@cse.mrt.ac.lk";
        //final String password = "rkpptskjrknvktvj";
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
            new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
            Message.RecipientType.TO,
            InternetAddress.parse(this.toAddress)
            );
            message.setSubject(subject);
            message.setText(content);
            Transport.send(message);
            System.out.println("A mail was sent successfully to " + toAddress);
            MailManager.save(this); // if email was sent, save sent data
            return;
        } catch (MessagingException e) {
            System.out.println("Failed to send a mail. Check your internet connection.");
            //e.printStackTrace();
            return ;
        }
    }
    
    // getters
    public String getSentDate() {
        return this.sentDate;
    }
}