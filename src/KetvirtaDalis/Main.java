package KetvirtaDalis;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
public class Main {
    public static void search(LinkedList<Gyvunas> gyvunai, String nameToSearch){ //Gyvūno paieška
        for(Gyvunas g : gyvunai){
            if(g.getName().equalsIgnoreCase(nameToSearch)){
                System.out.println(g.toString());
            }
        }


    }
    public static void main(String[] args){
        //Gyvūnų testavimas
        LinkedList<Gyvunas> gyvunai = new LinkedList<>();
        gyvunai.add(new Zuvis("Aukse"){{setPelekuKiekis(10);}});
        gyvunai.add(new Zuvis("Aukse"){{setPelekuKiekis(2);}});
        gyvunai.add(new Ziurkenas("Antanas"){{setSpalva("Juoda"); setUodegosIlgis(5);}});
        gyvunai.add(new Zuvis("Vardenis"){{setPelekuKiekis(5);}});
        gyvunai.add(new Ziurkenas("Pavardenis"){{setUodegosIlgis(3);setSpalva("Balta");}});

        System.out.println("Nesurikiuotas sąrašas: ");
        for(Gyvunas g : gyvunai){
           System.out.println(g.toString());
        }
        Collections.sort(gyvunai);
        System.out.println(" ");
        System.out.println("Surikiuotas sąrašas: ");
        for(Gyvunas g : gyvunai){
            System.out.println(g.toString());
        }
        Scanner reader = new Scanner(System.in);
        System.out.println("Įveskite gyvūno vardą:");
        String input = reader.next();
        System.out.println("Surasti gyvūnai:");
        search(gyvunai, input);

    }


}
