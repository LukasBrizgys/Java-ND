package AntraDalis;
import java.util.Scanner;
import PirmaDalis.Point;

import static java.lang.System.exit;

public class Main {
    public static void printMenu(String[] options){ //Meniu spausdinimas
        System.out.println(" ");
        for(String option : options){

            System.out.println(option);

        }
        System.out.println(" ");
        System.out.print("Pasirinkite veiksmą: ");
    }
    public static void main(String[] args){
        int menuOption = 1;
        String[] menuOptions = {
                "1. Peržiūrėti įmonės informaciją",
                "2. Peržiūrėti darbuotojus",
                "3. Pridėti darbuotoją",
                "4. Pašalinti darbuotoją",
                "5. Išeiti"
        };

        //Line klases testavimas
        Line L1 = new Line();
        Line L2 = new Line(new Point(3,5), new Point(8,9));
        L1.setFirstPoint();
        L1.setSecondPoint();
        L1.printPoints();
        //L2.printPoints();
        System.out.println("Linijos ilgis: " + L1.calculateLineLength());
        //---------------------------

        //Imone klases testavimas
        Scanner reader = new Scanner(System.in);
        Imone I = new Imone("Maxima", "78946");
        while(menuOption != 5){
            printMenu(menuOptions);
            try {
                menuOption = reader.nextInt();
                switch (menuOption) {
                    case 1 -> {
                        System.out.println("Įmonės pavadinimas: " + I.getTitle());
                        System.out.println("Įmonės kodas: " + I.getCode());
                        System.out.println("Darbuotojų skaičius: " + I.getEmployeeCount());
                    }
                    case 2 -> I.printEmployees();
                    case 3 -> I.addEmployee();
                    case 4 -> I.removeEmployee();
                    case 5 -> exit(0);
                }
            }catch(Exception e){
                System.out.println("Įveskite skaičių tarp 1 ir " + menuOptions.length);
            }

        }



    }
}
