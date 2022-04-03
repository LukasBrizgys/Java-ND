import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class failo_paieska {
    public static File search_file(File path, String file_name){
        if(path.isDirectory()){
            File[] file_array = path.listFiles();
            for(File n : file_array){
                File found = search_file(n,file_name);
                if(found != null){
                    return found;
                }
            }
        }else{
            if(path.getName().equals(file_name)){
                return path;
            }
        }

        return null;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Įveskite failo pavadinimą");
        String file_name = in.next();
        //System.out.println(file_name);
        File f = new File("./src/");
        File found = search_file(f, file_name);
        if(found == null){
            System.out.println("failas nerastas");
        }else{
            System.out.println(found);
        }

    }
}
