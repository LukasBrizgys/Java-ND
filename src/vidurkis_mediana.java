import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class vidurkis_mediana {
    public static void main(String[] args){
        Random rand = new Random();
        int sum = 0;
        double average = 0, median = 0;
        final int rand_max = 10; // virsutinis atsitiktinio skaiciaus limitas

        Scanner input = new Scanner(System.in);
        System.out.println("Kiek skaičių įrašyti į failą?");

        int length = input.nextInt();
        int [] num_array = new int[length]; // skaiciu masyvas
        int middle = length / 2; //masyvo vidurys
        try{
            File file = new File("./src/random_nums.txt");
            FileWriter Writer = new FileWriter("./src/random_nums.txt");
            PrintWriter output = new PrintWriter(Writer);
            Scanner reader = new Scanner(file);

            for(int i = 0; i < length; i++){
                output.println(rand.nextInt(rand_max)); //atsitiktiniai skaiciai irasomi i faila
            }
            output.close();
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
            for(int i = 0;i<length;i++){
                int number = reader.nextInt(); //skaiciai nuskaitomi is failo
                sum += number; //skaiciuojama visu skaiciu suma
                num_array[i] = number; //skaiciai sudedami i masyva
            }


        } catch(IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }


        average = (double) sum / length; //vidurkio skaiciavimas
        Arrays.sort(num_array); //masyvo rikiavimas

        if(num_array.length % 2 == 1){ //medianos skaiciavimas
            median = num_array[middle];
        }else{
            median = (num_array[middle-1] + num_array[middle]) / 2.0;
        }

        System.out.println("Vidurkis: " + average);
        System.out.println("Mediana: " + median);
    }
}
