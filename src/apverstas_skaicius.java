import java.util.Scanner;
public class apverstas_skaicius {
   static int reversed = 0;
    public static int reverse_num(int number){

        if(number > 0){
            int remainder = number % 10;
            reversed = reversed * 10 + remainder;

            reverse_num(number / 10);
        }
        return reversed;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Įveskite skaičių:");
        int num = input.nextInt();
        int reversed = reverse_num(num);
        System.out.println(reversed);

    }
}
