
class Personal_Recipient extends Recipient{
    public Personal_Recipient(String data){
        String[] dataArr = data.split(",");
        this.setName(dataArr[0]);
        this.setNickName(dataArr[1]);
        this.setEmail(dataArr[2]);
        this.setBirthday(dataArr[3]);
        this.setMessage(" Hugs and love on your birthday. \n \t\tThejan");
    }

    public String getData() {
        return "Name : " + this.getName() + "\nnick name : " + this.getNickName() + 
         "\nemail : "+ this.getEmail() + "\nbirthday : " + this.getBirthday() + "\n";
    }
}