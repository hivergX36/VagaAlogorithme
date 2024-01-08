import java.util.Comparator;


public class OperatorFitness1 implements  Comparator<Solution>  {

    public int compare(Solution s1, Solution s2) {

        int result; 
        
        if (s1.FitnessValue1 >= s2.FitnessValue1){
           result = 1;
        }else{
            result = -1; 
        }
        return result; 
    }
    


}

