package AntraDalis;

import PirmaDalis.Point;

public class Line {
    private Point p1 = new Point();
    private Point p2 = new Point();
    public Line(){}
    public Line(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    public Point getFirstPoint(){return p1;}
    public Point getSecondPoint(){return p2;}
    public void setFirstPoint(){
        System.out.println("Pirmas taškas");
        p1.setX();
        p1.setY();
    }
    public void setSecondPoint(){
        System.out.println("Antras taškas");
        p2.setX();
        p2.setY();
    }
    public void printPoints(){
        System.out.println("Linijos pradžios taškas: " + "[" + p1.getX() + ";" + p1.getY() + "]");
        System.out.println("Linijos Pabaigos taškas: " + "[" + p2.getX() + ";" + p2.getY() + "]");
    }
    public double calculateLineLength(){
        double d = Math.sqrt(Math.pow(this.p1.getX() - this.p2.getX(),2) + Math.pow(this.p1.getY() - this.p2.getY(),2));
        return d;
    }


}
