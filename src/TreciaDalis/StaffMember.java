package TreciaDalis;

public class StaffMember {
    protected String name;
    protected String surname;
    protected String phone;

    public StaffMember(){}
    public StaffMember(String name, String surname, String phone){
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }
    public double pay(){return 0;}

    public String toString(){
        return String.format("Name: %s, Surname: %s, Phone: %s",this.name,this.surname,this.phone);
    }
}
