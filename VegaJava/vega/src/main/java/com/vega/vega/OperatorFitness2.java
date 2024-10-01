package com.vega.vega;
import java.util.Comparator;


public class OperatorFitness2 implements  Comparator<Solution>  {

    

    @Override
    public int compare(Solution s1, Solution s2) {
        int compare = 0;
        if(s1.getFitness2() == 0 && s1.getFitness2() == 0 ){
        if (s1.getFitness2() - s2.getFitness2() == 0){
            compare = 0;
        }
        else if(s1.getFitness2() - s2.getFitness2() > 0){
            compare = 1;
        }else{
            compare = -1;
        }}else 
        {
            compare = 0; 
        }
        return compare;
    }
 


}