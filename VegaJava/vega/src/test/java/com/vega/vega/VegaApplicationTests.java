package com.vega.vega;

import org.junit.*;

public class VegaApplicationTests {
    @Test 
    public void test_nb_variable(){
        Vega Vg = new Vega("knapsack.txt", 10,5);
        Assert.assertEquals(Vg.NbVariable,4);

    }

    @Test 
    public void test_nb_constraint(){
        Vega Vg = new Vega("knapsack.txt", 10, 5);
        Assert.assertEquals(Vg.NbConstraints,2);
    }

    @Test
    public void test_nb_objective(){
        Vega Vg = new Vega("knapsack.txt",10,5);
        Assert.assertEquals(Vg.NbObj, 2);

    }


}
