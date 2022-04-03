import java.util.Scanner;

public class apvalinimas {
    public static double round(double number, int precision){
        double rounded = number * Math.pow(10, precision);
        rounded = Math.floor(rounded + 0.5);
        rounded = rounded / Math.pow(10, precision);
        return rounded;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Įveskite skaičių");
        double num = input.nextDouble();
        System.out.println("Apvalinti iki?:");
        int precision = input.nextInt();
        double rounded_num = round(num,precision);
        System.out.println(rounded_num);
    }
}
