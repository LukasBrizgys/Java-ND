package TreciaDalis;

 class StatusisTrikampis extends Trikampis{

    public StatusisTrikampis(){}
    public StatusisTrikampis(double firstEdge, double secondEdge){

        super.firstEdge = firstEdge;
        super.secondEdge = secondEdge;
        super.thirdEdge = Math.pow(super.firstEdge, 2 ) + Math.pow(super.secondEdge, 2);
    }
    public double calculateArea(){
        return (super.firstEdge * super.secondEdge) / 2.0;
    }

}
