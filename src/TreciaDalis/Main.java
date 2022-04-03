package TreciaDalis;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {


    public static void main(String[] args){
        //Triangles testavimas
        /*
        ArrayList<Trikampis> Triangles = new ArrayList <>();
        double sum = 0;
        Triangles.add(new Trikampis(5,5,2));
        Triangles.add(new StatusisTrikampis(5, 6));
        Triangles.add(new LygiakrastisTrikampis(10));
        System.out.println("Trikampio plotai:");
        for(Trikampis T : Triangles){
            sum += T.calculateArea();
            System.out.println(T.calculateArea());
        }
        System.out.println("Trikampių plotų suma: " + sum);

         */
        //-----------------------

        //Darbuotoju testavimas
        Staff personnel = new Staff();
        personnel.staffList = new StaffMember[0];
        Employee employee1 = new Employee("Jonas", "Jonaitis",
                "+37064446135","4561389764", 1500.99);

        Employee employee2 = new Employee("Petras", "Petraitis",
                "+37069993605","1679461320", 400.99);

        Trainee trainee1 = new Trainee("Kazys", "Kazaitis", "+37062223608");

        Executive executive1 = new Executive("Vadovas", "Vadovaitis",
                "+37062223490","4316971310", 5000);

        Hourly hourly1 = new Hourly("Vardenis", "Pavardenis", "+37065556983",
                "7946130654", 10);

        Hourly hourly2 = new Hourly("Valandininkas", "Valandininkaitis", "+37061358961",
                "9463168946", 20);

        personnel.addStaffMember(employee1);
        personnel.addStaffMember(employee2);
        personnel.addStaffMember(trainee1);
        personnel.addStaffMember(executive1);
        personnel.addStaffMember(hourly1);
        personnel.addStaffMember(hourly2);
        executive1.awardBonus(150);

        double total_sum = personnel.payDay();

        System.out.println("Visa sumokėta suma: " + total_sum + "e");
        //System.out.println(Arrays.toString(personnel.staffList));

        //-----------------------
    }





}
