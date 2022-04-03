import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;

public class numeriu_skaiciavimas {

    public static void main(String[] args){
        Random rand = new Random();
        final int rand_max = 10;
        int[] count = new int[10];
        final int length = count.length;
        try{
            File file = new File("./src/random_nums.txt");
            FileWriter Writer = new FileWriter("./src/random_nums.txt");
            PrintWriter output = new PrintWriter(Writer);
            Scanner reader = new Scanner(file);

            for(int i = 0; i < 50; i++){
                output.println(rand.nextInt(rand_max)); //faile irasoma 50 atsitiktiniu skaiciu nuo 0 iki 9
            }
            output.close();
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
            while(reader.hasNextInt()){
                int number = reader.nextInt();
                count[number]++;
            }


        } catch(IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
        for(int i = 0; i < length; i++){
            System.out.println("Skaičius " + i + " pasikartojo: " + count[i] + " kartus");
        }

    }
}
