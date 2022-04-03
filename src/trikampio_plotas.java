import java.util.Scanner;

public class trikampio_plotas {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Įveskite pirmą krastinę");
        double a = input.nextDouble();
        System.out.println("Įveskite antrą krastinę");
        double b = input.nextDouble();
        System.out.println("Įveskite trečią krastinę");
        double c = input.nextDouble();
        double p = (a+b+c)/2.0;
        double plotas = Math.sqrt(Math.abs(p*((p-a)*(p-b)*(p-c))));
        System.out.println(plotas);
    }

}
