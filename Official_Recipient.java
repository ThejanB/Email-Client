class Official_Recipient extends Recipient{
 
    public Official_Recipient(String data){
        String[] dataArr = data.split(",");
        this.setName(dataArr[0]);
        this.setEmail(dataArr[1]);
        this.setDesignation(dataArr[2]);
    }

    public String getData() {
        return "Name : " + this.getName() + "\nemail : "+ this.getEmail() + 
        "\ndesignation : " + this.getDesignation() + "\n";
    }
}