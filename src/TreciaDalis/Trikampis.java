package TreciaDalis;

public class Trikampis {
    protected double firstEdge;
    protected double secondEdge;
    protected double thirdEdge;

    public Trikampis(){}
    public Trikampis(double firstEdge, double secondEdge, double thirdEdge){
        this.firstEdge = firstEdge;
        this.secondEdge = secondEdge;
        this.thirdEdge = thirdEdge;
    }
    double calculateArea(){
        double p = (this.firstEdge + this.secondEdge + this.thirdEdge) / 2.0;

        return Math.sqrt(p * (p - this.firstEdge) * (p - this.secondEdge) * (p - this.thirdEdge));
    }
}
