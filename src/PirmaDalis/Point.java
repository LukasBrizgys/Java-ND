package PirmaDalis;
import java.util.Scanner;

public class Point {
    private int x;
    private int y;

    public Point(){}

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setX(){
        int x;
        Scanner reader = new Scanner(System.in);
        System.out.println("Įveskite koordinatę x: ");
        x = reader.nextInt();
        this.x = x;
    }
    public void setY(){
        int y;
        Scanner reader = new Scanner(System.in);
        System.out.println("Įveskite koordinatę y: ");
        y = reader.nextInt();
        this.y = y;
    }
    public int getX(){return this.x;}
    public int getY(){return this.y;}
    public void PrintString(){System.out.print("[" + this.x + ";"+ this.y + "]");}
    public double distanceFromOrigin(){return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));}

    public void translate(int dx, int dy){
        this.x = this.x + dx;
        this.y = this.y + dy;
    }
    public double distance(Point p){


        return Math.sqrt(Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2));
    }
    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;

    }
}
