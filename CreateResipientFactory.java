class CreateResipientFactory {
    private String type;
    private String data;
    
    public CreateResipientFactory(String type, String data){
        this.type = type;
        this.data = data; 
    }

    public Recipient Build(){
        if ( this.type.equals("Personal") ){
            return new Personal_Recipient(data);
        }
        else if( this.type.equals("Office_friend") ){
            return new Office_Friend_Recipient(data);
        }
        else if( this.type.equals("Official") ){
            return new Official_Recipient(data);
        }
        System.out.println("Error.Inputted data format is wrong.");
        return null;
    }
}
   