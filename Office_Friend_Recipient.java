class Office_Friend_Recipient extends Recipient{
    public Office_Friend_Recipient(String data){
        String[] dataArr = data.split(",");
        this.setName(dataArr[0]);
        this.setEmail(dataArr[1]);
        this.setDesignation(dataArr[2]);
        this.setBirthday(dataArr[3]);
        this.setMessage("Wish you a Happy Birthday. \n \t\tThejan");
    }

    public String getData() {
    
        return "Name : " + this.getName() + "\nemail : "+ this.getEmail() + 
        "\ndesignation : " + this.getDesignation() + "\nbirthday : " + this.getBirthday() + 
        "\n";
    }
}