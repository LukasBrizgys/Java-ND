import java.util.Scanner;

public class keliamieji_metai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Iveskite metus");
        int year = input.nextInt();
        if((year % 400 == 0) || (year % 100 !=0) && (year % 4 == 0)){
            System.out.println("Metai " + year + " keliamieji");
        }else {
            System.out.println("Metai " + year + " paprastieji");
        }

    }
}
