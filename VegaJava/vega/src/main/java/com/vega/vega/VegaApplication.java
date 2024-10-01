package com.vega.vega;


public class VegaApplication {

	public static void main(String[] args) {
		String file = "knapsack.txt";

		Vega GeneticAlgorithm = new Vega(file,50,20);

System.out.println("NbVariable: " + GeneticAlgorithm.NbVariable + " NbConstraints: " + GeneticAlgorithm.NbConstraints);

GeneticAlgorithm.resolve(10);

	}

}
