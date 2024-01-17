import java.util.Comparator;


public class OperatorFitness1 implements  Comparator<Solution>  {

    

    @Override
    public int compare(Solution s1, Solution s2) {
        return (int) (s1.getFitness1() - s2.getFitness1());
    }
 


}

