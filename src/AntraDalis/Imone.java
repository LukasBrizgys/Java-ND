package AntraDalis;
import PirmaDalis.Darbuotojas;
import java.util.Scanner;
import java.util.ArrayList;
public class Imone {
    private String title;
    private String code;
    private final ArrayList <Darbuotojas> darbuotojai = new ArrayList<>();


    public Imone(String title, String code){ //Įmonės konstruktorius
        this.title = title;
        this.code = code;
    }
    //Getter'iai
    public String getTitle(){return this.title;}
    public String getCode(){return this.code;}
    public int getEmployeeCount(){return this.darbuotojai.size();}
    //-----------

    public void printEmployees(){ //Darbuotojų spausdinimas
        System.out.println("Įmonės " + this.title + " darbuotojai:");
        for(Darbuotojas d : darbuotojai){
            int position = darbuotojai.indexOf(d);
            System.out.println(position + ". " + d.getName() + " " + d.getSurname());
        }

    }
    public void addEmployee(){ //Darbuotojo pridėjimas
        String name, surname;
        double salary;
        Scanner reader = new Scanner(System.in);
        System.out.println("Įrašykite darbuotojo vardą, pavardę ir atlyginimą");
        name = reader.next();
        surname = reader.next();
        salary = reader.nextDouble();
        darbuotojai.add(new Darbuotojas(name,surname,salary));
        System.out.println("Darbuotojas pridėtas");
    }
    public void removeEmployee(){ //Darbuotojo šalinimas
        printEmployees();
        Scanner reader = new Scanner(System.in);
        System.out.println("Įrašykite darbuotojo indeksą, kurį norite ištrinti: ");
        int employeeToRemove = reader.nextInt();
        try{
            darbuotojai.remove(employeeToRemove);
            System.out.println("Darbuotojas ištrintas");
        }catch(IndexOutOfBoundsException e){
            System.out.println("Nėra tokio indekso");
        }
    }
}
