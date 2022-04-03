package KetvirtaDalis;

public class Zuvis extends Gyvunas{
    private int pelekuKiekis;

    public Zuvis(String name){
        super(name,"Žuvis");
        this.name = name;

    }
    public int getPelekuKiekis(){return this.pelekuKiekis;}
    public void setPelekuKiekis(int kiekis){this.pelekuKiekis = kiekis;}

    @Override
    public String toString() {
        return this.type + ". Vardas: " + this.name + ", Peleku kiekis: " + this.pelekuKiekis;
    }
}
