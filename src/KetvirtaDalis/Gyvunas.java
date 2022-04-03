package KetvirtaDalis;
import java.lang.Comparable;
abstract class Gyvunas implements Comparable<Gyvunas> { //implementuojamas interface, kad būtų galima lyginti gyvūno
    protected String name;                              //klasės objektus
    protected String type;



    public Gyvunas(String name, String type){
        this.name = name;
        this.type = type;
    }
    //getter'iai
    public String getName(){return this.name;}
    public String getType(){return this.type;}
    //setter'iai
    public void setName(String name){
        this.name = name;
    }
    public void setType(String type){
        this.type = type;
    }


    @Override public int compareTo(Gyvunas g){
        int i = this.type.compareTo(g.type);
        if(i != 0) return i;

        i = this.name.compareTo(g.name);
        if (i != 0) return i;

        return i;

    }
}
