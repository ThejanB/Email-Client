abstract class Recipient {
    private static int count = 0;
    private String name;
    private String nickName;
    private String birthday;
    private String email;
    private String designation;
    private String message;
    
    public Recipient(){
        count++;
    }
    
    // setters
    public void setName(String name){this.name = name;}
    public void setNickName(String nickName){this.nickName = nickName;}
    public void setEmail(String email){this.email = email;}
    public void setBirthday(String birthday){this.birthday = birthday;}
    public void setDesignation(String designation) {this.designation = designation;}
    public void setMessage(String message) {this.message = message;}

    // getters
    public static int getCount() {return count;}
    public String getName(){return this.name ;}
    public String getNickName(){return this.nickName;}
    public String getEmail(){return this.email;}
    public String getBirthday(){return this.birthday;}
    public String getDesignation() {return this.designation;}
    public String getMessage() {return this.message;}
    
    // abstract methods
    public abstract String getData();
}