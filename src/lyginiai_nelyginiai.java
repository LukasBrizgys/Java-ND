import java.util.Scanner;

public class lyginiai_nelyginiai {

    public static void main(String[] args){
        int last, even = 0, odd = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Įveskite skaičių");
        int a = input.nextInt();
        while(a > 0){
            last = a % 10;

            if(last % 2 == 0){
                even++;
            }else{
                odd++;
            }

            a = a / 10;
        }
        System.out.println("Lyginiai: " + even);
        System.out.println("Nelyginiai: " + odd);
    }

}
