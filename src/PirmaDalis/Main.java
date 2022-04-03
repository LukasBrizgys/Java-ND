package PirmaDalis;

public class Main {
    public static double average(Darbuotojas[] darbuotojai){
        int count = 0;
        double avg, sum = 0;
        for(Darbuotojas d : darbuotojai){
            if(d!=null){
                count++;
                sum+=d.getSalary();
            }else{
                break;
            }
        }

        avg = sum / count;
        return avg;
    }
    public static void printInfo(Darbuotojas[] darbuotojai){
        int count = 0;
        double sum = 0, sodra_tax = 0, income_tax = 0;
        for(Darbuotojas d : darbuotojai){
            if(d!=null){
                count++;
                sum+=d.getSalary();
                sodra_tax += d.sodra();
                income_tax += d.incomeTax();
            }else{
                break;
            }
        }
        System.out.println("Viso įmonėje darbuotojų: " + count);
        System.out.println("Įmonė sumoka darbo užmokesčiui: " + sum);
        System.out.println("Sumokėtas pajamų mokestis: " + income_tax);
        System.out.println("Sumokėtas sodros mokestis: " + sodra_tax);
        System.out.println(" ");
    }
    public static void main(String[] args){
        //Point klasės testavimas

        Point p1 = new Point();
        Point p2 = new Point(2,3);
        p1.setX();
        p1.setY();
        System.out.println("x koordinatė: " + p1.getX());
        System.out.println("y koordinatė: " + p1.getY());
        System.out.println("atstumas tarp jų: " + p1.distanceFromOrigin());
        //p1.translate(10,10);
        System.out.println("perkelti taškai: " + p1.getX() + " " + p1.getY());
        System.out.print("Atstumas tarp taškų ");
        p1.PrintString();
        System.out.print(" ir ");
        p2.PrintString();
        System.out.println(" yra: " + p1.distance(p2));
        p2.setLocation(5,6);
        System.out.print("naujos koordinatės: ");
        p2.PrintString();


        //------------------------
        //Darbuotojo klasės testavimas

            for(Darbuotojas d : Darbuotojas.darbuotojai){
                if(d!=null){
                    System.out.println(d.getName() + " " + d.getSurname() + " " + d.getSalary());
                }else{
                    break;
                }

            }
            double average_pay = average(Darbuotojas.darbuotojai);
            System.out.println("Vidutinis užmokestis: " + average_pay);
            System.out.println(" ");
            printInfo(Darbuotojas.darbuotojai);
            System.out.println("Darbuotojai iš failo:");
            Darbuotojas.readWorkersFromFile();
            for(Darbuotojas d: Darbuotojas.darbuotojai){
                if(d!=null){
                    System.out.println(d.getName() + " " + d.getSurname() + " " + d.getSalary());
                }
            }
    }
}
