import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class armstrongo_skaicius {
    static boolean isArmstrong(int number){
        int temp, digits = 0, last = 0, sum = 0;
        temp = number;
        while(temp > 0){
            temp = temp / 10;
            digits++;
        }
        temp = number;
        while(temp > 0){
            last = temp % 10;

            sum += (Math.pow(last,digits));

            temp = temp / 10;
        }
       return number == sum;
    }

    public static void main(String[] args){

        try{

           File myFile = new File("src/armstrong.txt");
           Scanner input = new Scanner(myFile);
           int n = input.nextInt();
            for(int i = 1; i<=n;i++) {
                if (isArmstrong(i)) {
                    System.out.println(i);
                }
            }
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");

        }
    }
}
