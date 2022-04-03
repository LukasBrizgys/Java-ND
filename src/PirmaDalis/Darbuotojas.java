package PirmaDalis;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
public class Darbuotojas {
    private String name;
    private String surname;
    private double salary;
    static Darbuotojas[] darbuotojai = {
            new Darbuotojas("Petras", "Petraitis", 2000),
            new Darbuotojas("Kazys", "Kazlauskas", 2000),
            new Darbuotojas("Jonas", "Jonaitis", 575)
    };
    public Darbuotojas() {} // Tuščias konstruktorius

    public Darbuotojas(String name, String surname, double salary){ // perdengtas konstruktorius
        this.name = name;
        this.surname = surname;
        this.salary = salary;

    }
    //getter'iai
    public String getName(){return this.name;}
    public String getSurname(){return this.surname;}
    public double getSalary(){return this.salary;}
    //-----------

    //Klasės metodai
    public double sodra(){return this.salary * 0.15;}
    public double incomeTax(){return this.salary * 0.09;}
    //------------
    public static void readWorkersFromFile(){ //Darbuotojų skaitymas iš failų
        try{
            File file = new File("./src/PirmaDalis/darbuotojai.txt");
            Scanner reader = new Scanner(file);
            int length = reader.nextInt();
            for(int i = 0; i<length;i++){
                String name = reader.next();
                String surname = reader.next();
                double salary = reader.nextDouble();
                Darbuotojas.darbuotojai[i] = new Darbuotojas(name,surname,salary);

            }
        }catch(FileNotFoundException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

}
