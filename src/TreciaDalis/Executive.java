package TreciaDalis;

public class Executive extends Employee{
    private double bonus = 0;
    public Executive(String name, String surname, String phone, String insurance_number, double salary){
        super(name,surname,phone,insurance_number, salary);
    }

    public void awardBonus(double bonus){
        this.bonus = bonus;
    }

    public double pay(){
        double bonus = this.bonus;
        this.bonus = 0;
        return this.salary + bonus;

    }



}
