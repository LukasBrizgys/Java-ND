package TreciaDalis;

public class LygiakrastisTrikampis extends Trikampis {

    public LygiakrastisTrikampis(){}
    public LygiakrastisTrikampis(double firstEdge){
        super.firstEdge = firstEdge;

    }
    public double calculateArea(){
        return (Math.pow(super.firstEdge, 2) * Math.sqrt(3)) / 4.0;
    }
}
