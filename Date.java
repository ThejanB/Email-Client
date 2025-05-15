import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

class Date {
    private String today;
    
    public Date(){
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        this.today = LocalDate.now().format(myFormat);
    }

    public String getToday(){
        return this.today;
    }
}