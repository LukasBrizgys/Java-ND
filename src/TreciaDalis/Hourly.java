package TreciaDalis;

public class Hourly extends Employee{
    private int hoursWorked;

    public Hourly(String name, String surname, String phone,String insuranceNumber, int hoursWorked){
        super(name,surname,phone,insuranceNumber,0);
        this.hoursWorked = hoursWorked;
    }

    public void addHours(int hours){
        this.hoursWorked = hours;
    }
    public double pay(){
        int hours = this.hoursWorked;
        this.hoursWorked = 0;
        return 50 * hours;
    }
}
