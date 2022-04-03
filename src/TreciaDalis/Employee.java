package TreciaDalis;

public class Employee extends StaffMember{
    protected String insuranceNumber;
    protected double salary;


    public Employee(String name, String surname, String phone,String insuranceNumber, double salary){
        super(name,surname,phone);
        this.insuranceNumber = insuranceNumber;
        this.salary = salary;
    }

    public double pay(){return 1500;}

}
