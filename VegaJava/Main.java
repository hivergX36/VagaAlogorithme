

public class Main{
 
public static void main(String[] args){
String file = "Knapsack.txt";

Vega GeneticAlgorithm = new Vega(file,4,2);

System.out.println("NbVariable: " + GeneticAlgorithm.NbVariable + " NbConstraints: " + GeneticAlgorithm.NbConstraints);

GeneticAlgorithm.resolve(1);



  

}
}







