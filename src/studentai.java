import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class studentai {
    public static boolean isUnderperforming(int [] grades){ //funkcija kuri tikrina ar studentas nepazangus
        boolean underperforming = false;
        for (int grade : grades) {

            if (grade < 5) {
                underperforming = true;
                break;
            }


        }
        return underperforming;
    }

    public static double student_average(int [] array){ // funkcija kuri skaiciuoja studento vidurki
        int sum = 0;

        double average;
        for (int j : array) {
            sum += j;
        }
        average = (double) sum / array.length;
        return average;
    }

    public static void main(String[] args){
        double group_sum = 0;

        double group_average;
        try{
            File file = new File("./src/pazymiai.txt");
            Scanner reader = new Scanner(file);
            int n = reader.nextInt(); //dalyku skaicius
            int m = reader.nextInt(); // studentu skaicius
            int [][] array = new int[m][n];

            double [] average_array = new double[m];

            for(int i = 0; i < m; i++){

                for(int j = 0; j < n; j++){

                    array[i][j] = reader.nextInt(); //studentu ivertinimu masyvas

                }

            }
            double best_student = 0;
            int best_student_index = 0;
            System.out.println("Visų studentų vidurkiai:");
            for(int i = 0; i < m; i++) {

                average_array[i] = student_average(array[i]);
                System.out.println(i + ". " + average_array[i]);


                if (best_student < average_array[i]) {
                    best_student = average_array[i];
                    best_student_index = i;
                }

                group_sum += average_array[i];

            }

            group_average = group_sum / m;

            System.out.println("Visos grupės vidurkis: " + group_average);
            System.out.println("Geriausias studentas Nr. " + best_student_index);
            System.out.println("Nepažangūs studentai:");
            for(int i = 0; i < m; i++){
                boolean underperforming = isUnderperforming(array[i]);
                if(underperforming){
                    System.out.println("Nr. "+ i);
                }
            }

        }catch(FileNotFoundException e){
            System.out.println("An error occurred");
        }
    }
}
