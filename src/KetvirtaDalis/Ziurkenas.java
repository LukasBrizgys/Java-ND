package KetvirtaDalis;

public class Ziurkenas extends Gyvunas{
    private int uodegosIlgis;
    private String spalva;

    public Ziurkenas(String name){
        super(name,"Žiurkėnas");
        this.name = name;

    }
    public int getUodegosIlgis(){return this.uodegosIlgis;}
    public String getSpalva(){return this.spalva;}

    public void setSpalva(String spalva){this.spalva = spalva;}
    public void setUodegosIlgis(int ilgis){this.uodegosIlgis = ilgis;}

    @Override
    public String toString() {
        return this.type+". " + "Vardas: " + this.name + ", Uodegos ilgis: "
                + this.uodegosIlgis + ", Spalva: "+ this.spalva;
    }
}
