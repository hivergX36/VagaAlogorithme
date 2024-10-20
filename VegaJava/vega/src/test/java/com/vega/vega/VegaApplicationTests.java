package com.vega.vega;
import java.util.*;
import java.io.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;

public class VegaApplicationTests {

    Ressource ressource = new Ressource();
    String chemin = ressource.getfileinressourcefortest("knapsack.txt");
    String chemin2 = ressource.getfileinressourcefortest("knapsack.txt");
    



    Vega Vg = new Vega(chemin, 10,5);
    Vega Vg2 = new Vega(chemin2, 10, 5);

    Solution s1 = new Solution(2,3);
    Solution s2 = new Solution(2,3);
    Solution s3 = new Solution(2,3);



    @Test
    public void test_nb_ind(){
        
        Assert.assertEquals(Vg.Nbind,5);
    }


    @Test 
    public void test_nb_variable(){
        Assert.assertEquals(Vg.NbVariable,4);

    }

    @Test 
    public void test_nb_constraint(){
        Assert.assertEquals(Vg.NbConstraints,2);
    }

    @Test
    public void test_nb_objective(){

        Assert.assertEquals(Vg.NbObj, 2);

    }

    @Test
    public void test_nb_pop(){

        Assert.assertEquals(Vg.NbPop, 10);

    }

    @Test
    public void test_nb_ind_vg2(){
        
        Assert.assertEquals(Vg2.Nbind,5);
    }

    @Test 
    public void test_nb_variable_vg2(){
        Assert.assertEquals(Vg2.NbVariable,4);

    }

    @Test 
    public void test_nb_constraint_vg2(){
        Assert.assertEquals(Vg2.NbConstraints,2);
    }

    @Test
    public void test_nb_objective_vg2(){

        Assert.assertEquals(Vg2.NbObj, 2);

    }

    @Test
    public void test_nb_pop_vg2(){

        Assert.assertEquals(Vg2.NbPop, 10);

    }

    @Test 
    public void compare_solution_vg_s1(){
        s1.FitnessValue1 = 58;
        s1.FitnessValue2 = 60;
        s2.FitnessValue1 = 57;
        s2.FitnessValue2 = 59;
        Solution  MyList1[] = new Solution[2];
        MyList1[0] = s2;
        MyList1[1] = s1;
        Arrays.sort(MyList1, Solution.OperatorFitness1);
        Assert.assertEquals(MyList1[0].FitnessValue1, 58,0);


    }

    @Test
    public void conpare_solution_vg_s2(){
            s1.FitnessValue1 = 58;
            s1.FitnessValue2 = 60;
            s2.FitnessValue1 = 57;
            s2.FitnessValue2 = 59;
            Solution  MyList1[] = new Solution[2];
            MyList1[0] = s2;
            MyList1[1] = s1;
            Arrays.sort(MyList1, Solution.OperatorFitness1);
            Assert.assertEquals(MyList1[1].FitnessValue1, 57,0);
    
    
        }

        @Test
        public void compare_solution_f1_vg_s3_p1(){
            s1.FitnessValue1 = 58;
            s1.FitnessValue2 = 60;
            s2.FitnessValue1 = 57;
            s2.FitnessValue2 = 59;
            s3.FitnessValue1 = 64;
            s3.FitnessValue2 = 59;
            Solution  MyList1[] = new Solution[3];
            MyList1[0] = s3;
            MyList1[1] = s1;
            MyList1[2] = s2;
            Arrays.sort(MyList1, Solution.OperatorFitness1);
            Assert.assertEquals(MyList1[0].FitnessValue1, 64,0);
    
        }
    
        @Test
        public void compare_solution_f1_vg_s3_p2(){
            s1.FitnessValue1 = 58;
            s1.FitnessValue2 = 60;
            s2.FitnessValue1 = 57;
            s2.FitnessValue2 = 59;
            s3.FitnessValue1 = 64;
            s3.FitnessValue2 = 59;
            Solution  MyList1[] = new Solution[3];
            MyList1[0] = s1;
            MyList1[1] = s3;
            MyList1[2] = s2;
            Arrays.sort(MyList1, Solution.OperatorFitness1);
            Assert.assertEquals(MyList1[0].FitnessValue1, 64,0);
    
        }

    @Test
    public void compare_solution_f1_vg_s3_p3(){
        s1.FitnessValue1 = 58;
        s1.FitnessValue2 = 60;
        s2.FitnessValue1 = 57;
        s2.FitnessValue2 = 59;
        s3.FitnessValue1 = 64;
        s3.FitnessValue2 = 59;
        Solution  MyList1[] = new Solution[3];
        MyList1[0] = s2;
        MyList1[1] = s1;
        MyList1[2] = s3;
        Arrays.sort(MyList1, Solution.OperatorFitness1);
        Assert.assertEquals(MyList1[0].FitnessValue1, 64,0);

    }

    @Test
    public void compare_solution_f2_vg_s2_p1(){
        s2.FitnessValue1 = 57;
        s2.FitnessValue2 = 78;
        s1.FitnessValue1 = 58;
        s1.FitnessValue2 = 60;
        s3.FitnessValue1 = 64;
        s3.FitnessValue2 = 64;
        Solution  MyList1[] = new Solution[3];
        MyList1[0] = s2;
        MyList1[1] = s1;
        MyList1[2] = s3;
        Arrays.sort(MyList1, Solution.OperatorFitness2);
        Assert.assertEquals(MyList1[0].FitnessValue2, 78,0);

    }

    @Test
    public void compare_solution_vg_s2_p2(){
        s1.FitnessValue1 = 58;
        s1.FitnessValue2 = 60;
        s2.FitnessValue1 = 57;
        s2.FitnessValue2 = 78;
        s3.FitnessValue1 = 64;
        s3.FitnessValue2 = 64;
        Solution  MyList1[] = new Solution[3];
        MyList1[0] = s1;
        MyList1[1] = s2;
        MyList1[2] = s3;
        Arrays.sort(MyList1, Solution.OperatorFitness2);
        Assert.assertEquals(MyList1[0].FitnessValue2, 78,0);
        Assert.assertEquals(MyList1[1].FitnessValue2, 64,0);


    }

@Test
public void compare_solution_vg_s3_p3(){
    s1.FitnessValue1 = 58;
    s1.FitnessValue2 = 60;
    s2.FitnessValue1 = 57;
    s2.FitnessValue2 = 78;
    s3.FitnessValue1 = 64;
    s3.FitnessValue2 = 65;
    Solution  MyList1[] = new Solution[3];
    MyList1[0] = s2;
    MyList1[1] = s1;
    MyList1[2] = s3;
    Arrays.sort(MyList1, Solution.OperatorFitness2);
    Assert.assertEquals(MyList1[0].FitnessValue2, 78,0);
    Assert.assertEquals(MyList1[1].FitnessValue2, 65,0);


}

   

    }


    




