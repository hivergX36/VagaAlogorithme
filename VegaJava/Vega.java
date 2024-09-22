import java.util.*;
import java.io.*;



public class Vega {

    int NbVariable;
    int NbConstraints;
    int IndCandidat;
    int NbObj; 
    int NbPop;
    int Nbind; 

    
    /*Price function */
    int[][] Price;
    /* Utility function */

    /*Matrix of constraint*/
    double[][] CostMatrix;
    /*Vector of solution*/





    double[] constraint;
    Solution[] Population; 
    Solution[] Echantillon; 


//Faire le nombre d'objectif 
 
    Vega(String name, Integer nbpop , Integer nbind){

 
        this.Nbind = nbind;
        this.NbPop = nbpop;  
        Population = new Solution[this.NbPop];
        Echantillon = new Solution[this.Nbind];
        

        File input = new File(name);
        
        
        try{
            Scanner reader = new Scanner(input);
            String[] nums = reader.nextLine().split(",");
            this.NbVariable = Integer.parseInt(nums[0]);
            this.NbConstraints = Integer.parseInt(nums[1]);
            this.NbObj = Integer.parseInt(nums[2]);
            this.Price = new int[this.NbObj][this.NbVariable];
            this.CostMatrix = new double[this.NbConstraints][this.NbVariable];
            this.constraint = new double[this.NbConstraints];
            System.out.println(this.NbObj);
            nums = reader.nextLine().split(",");

     /* 
            
            
            for(int i = 0; i < this.NbObj; i++){
                nums = reader.nextLine().split(",");
                System.out.println(i);

                for(int j = 0; j < this.NbVariable; j++){
                    System.out.println(j);

                    System.out.println(nums[j]);

                    this.Price[i][j] = Integer.parseInt(nums[j]);
                }
            }

                for(int i = 0; i < this.NbConstraints; i++){
                    nums = reader.nextLine().split(",");
      
                    for(int j = 0; j < this.NbVariable; j++ ){
                    this.CostMatrix[i][j] = Float.parseFloat(nums[j]);
                  }
                }

            nums = reader.nextLine().split(",");
            
            for(int i = 0; i < NbConstraints; i++){
                this.constraint[i] = Float.parseFloat(nums[i]);
            }

              */
            reader.close();

        
    }
    catch (IOException e){
      System.out.println("no file");
     }

  };
  

  public void displayCostMatrix(){
        for(int i = 0; i < NbConstraints; i++){
            for(int j = 0; j < NbVariable; j++)
            {
                System.out.println(this.CostMatrix[i][j] + "\t") ; 

        }

        System.out.println("\nd");
        }
    }

        void sumconstraint(Solution individual){

            double sum; 

          for(int i = 0; i < NbConstraints; i++){
                individual.SumConstraint[i] = 0;
            }

     
        for(int j = 0;j < NbConstraints; j++){
            sum = 0;
            for(int i = 0; i < NbVariable; i++){
            sum += CostMatrix[j][i] * individual.solution[i];
            }
            individual.SumConstraint[j] = sum;
        }



    }




   




    void RepaireSample(Solution individual){
        int compteur = 0;
        int indice;
        int choix; 
        Random random = new Random();
        List<Integer> listChoix = new ArrayList<Integer>();


        

    
        for(int i = 0; i < NbVariable; i++){
            if(individual.solution[i] > 0){
                listChoix.add(i);
                compteur++;
            }
        }
        if(compteur > 0){

        indice = random.nextInt(compteur - 0) + 0;
        choix = listChoix.get(indice);
        individual.solution[choix] = 0;

        }
        

    }

   int checkPopindividual(Solution individual, int compteur){
        boolean check = true;

        for(int i = 0; i < this.NbConstraints; i++){
            System.out.println("La contrainte est: " +  this.constraint[i] + "\t");
        if( individual.SumConstraint[i] > this.constraint[i] || individual.SumConstraint[i] == 0){
             
                check = false;
                break;
            }
        }

                 System.out.println("le booléen est: " + check + "\t");

        if(check == false){
                 System.out.println( "La solution n'est pas admissible" + "\t");

        }else{

                 System.out.println( "La solution est  admissible" + "\t");
        Population[compteur] = individual;
        compteur++; 

        }

        return compteur;
    }
        void initPopulation(){
            Random random = new Random();

            int compteur = 0; 
            int nbrandomseeds;
            int indice; 
            int value;
     while(compteur < NbPop)
                {
               Solution individual = new Solution(this.NbVariable, this.NbConstraints); 
                for(int k = 0; k < this.NbVariable; k++){
                     individual.solution[k] = 0;
                }
                nbrandomseeds = random.nextInt(this.NbVariable - 0) + 0; 
                 System.out.println( nbrandomseeds + "\t");  
                for(int j = 0; j < nbrandomseeds; j++){
                    indice = random.nextInt(this.NbVariable - 0) + 0 ;
                    value = random.nextInt(2 - 0) + 0;
                    if(value > 0){
    
                      individual.solution[indice] = 1; 
    
    
                    }
    
                }
                sumconstraint( individual);
                displayIndividual(individual);
                compteur = checkPopindividual(individual,compteur);
        }
    
        }

        void displayIndividual(Solution  individual){

               System.out.println( "La solution créée est: "); 
            for(int i = 0; i < NbVariable; i ++){
    
                     System.out.println(individual.solution[i]);
    
            }
    
                 System.out.println("\t"); 
    
                 System.out.println("Les contraintes sont: "); 
            for (int j = 0; j < NbConstraints; j++){
    
                     System.out.println(individual.SumConstraint[j]); 
    
            }
                 System.out.println("\t");
        }
    
    
        void displayPopulation(){
            System.out.println("La population est: "); 
            for(int i = 0;i < NbPop; i++){
                System.out.println("individu_" +  i + " : ");
                for(int j = 0; j < NbVariable; j++){
                    System.out.println(this.Population[i].solution[j] );
                }
                     System.out.println("obj1: " + this.Population[i].FitnessValue1);
                     System.out.println("\t");
                    System.out.println("obj2: " + this.Population[i].FitnessValue2);

    
    
            }
    
          
    
        }
    
          void displayEchantillon(){
            System.out.println( "L'Echantillon est: " + "\t"); 
            for(int i = 0;i < Nbind; i++){
                  System.out.println("individu_" +  i + 1 + " : ");
                for(int j = 0; j < NbVariable; j++){
    
                      System.out.println(Echantillon[i].solution[j] + " ");
                }
    
                  System.out.println("\t");
    
    
            }
          }

    
        void fitnessValuePop(/*std::vector<Solution> & Echantillon, int dim*/){
            float fitnessvalue1; 
            float fitnessvalue2;
            int compteur = 0;
            while(compteur < NbPop)
            {
                fitnessvalue1 = 0; 
                fitnessvalue2 = 0; 

            
                if(Population[compteur].fitnessCalculated == false){
                    for(int i = 0; i < NbVariable; i++){
                        fitnessvalue1 += Population[compteur].solution[i] * Price[0][i];
                        fitnessvalue2 += Population[compteur].solution[i] * Price[1][i];

                    }
                    Population[compteur].FitnessValue1 = fitnessvalue1; 
                    Population[compteur].FitnessValue2 = fitnessvalue2; 

                    Population[compteur].fitnessCalculated = true;
                }
    
                compteur++;
    
    
            }
        }
    
        void fitnessValueSample(){
            float fitnessvalue1; 
            float fitnessvalue2; 

            int compteur = 0;
            while(compteur < Nbind)
            {
                fitnessvalue1 = 0; 
                fitnessvalue2 = 0; 

                if(Echantillon[compteur].fitnessCalculated == false){
                    for(int i = 0; i < NbVariable; i++){
                        fitnessvalue1 += Echantillon[compteur].solution[i] * Price[0][i];
                        fitnessvalue2 += Echantillon[compteur].solution[i] * Price[0][i];

                    }
                    Echantillon[compteur].FitnessValue1 = fitnessvalue1; 
                    Echantillon[compteur].FitnessValue2 = fitnessvalue2; 

                    Echantillon[compteur].fitnessCalculated = true;
                }
    
                compteur++;
    
    
            }
    
    
        }
    
        void Tournament(){
        Random random = new Random(); 
        int taillelist;
        int supcompteur;



        if (this.Nbind %  2 == 0){

            taillelist = this.Nbind / 2;
            supcompteur = this.Nbind;



        } 
        else{

            taillelist = (this.Nbind + 1) / 2;
            supcompteur = this.Nbind + 1;
        };

        Solution  MyList1[] = new Solution [taillelist];
        Solution  MyList2[] = new Solution [taillelist]; 



            int compteur = 0;
            int randomIndividual1;
            int randomIndividual2; 
            while(compteur < supcompteur){
                for(int i = 0; i < taillelist; i++){
                randomIndividual1 = random.nextInt(this.NbPop);
                randomIndividual2 = random.nextInt(this.NbPop);

                MyList1[i] = Population[randomIndividual1];
                MyList2[i] = Population[randomIndividual2]; 

    
                }

                System.out.println("Operateur1l1: "+  MyList1[0].FitnessValue1);
                System.out.println("Operateur1l2: "+  MyList2[0].FitnessValue1);
                System.out.println("Operateur2l1: "+  MyList1[0].FitnessValue2);
                System.out.println("Operateur2l2: "+  MyList2[0].FitnessValue1);

    
             Arrays.sort(MyList1, Solution.OperatorFitness1);
             Arrays.sort(MyList2, Solution.OperatorFitness2);

             System.out.println("Operateur1: "+  MyList1[0].FitnessValue1);
             System.out.println("Operateur2: "+  MyList2[0].FitnessValue2);


             System.out.println("erreur?: ");
             
             this.Echantillon[compteur] = MyList1[0];
             if(compteur + 1 < supcompteur ){
             this.Echantillon[compteur + 1] = MyList2[0];
             }

             compteur ++; 
    
    
    
    
            }
    
    
    
    
        }
    
        void CrossoverMutation(){
            Random random = new Random();
            int ind_Parent1 = random.nextInt(Nbind);
            int ind_Parent2 = random.nextInt(Nbind);
            int ind_crossover = random.nextInt(NbVariable); 
            int Getmuted;
            Solution Enfant1 = new Solution(this.NbVariable,this.NbConstraints); 
            Solution Enfant2 = new Solution(this.NbVariable,this.NbConstraints);;
            /*for(int k = 0; k < NbVariable; k++){
    
            } */
            for(int i = 0; i < ind_crossover; i++){
                Enfant1.solution[i] = Echantillon[ind_Parent1].solution[i];
                Enfant2.solution[i] = Echantillon[ind_Parent2].solution[i];
                
            }
    
            for(int j = ind_crossover; j < NbVariable; j++){
    
                Enfant2.solution[j] = Echantillon[ind_Parent1].solution[j];
                Enfant1.solution[j] = Echantillon[ind_Parent2].solution[j];
    
            }
    
            Getmuted = random.nextInt(3);
          
            System.out.println( "choixmutation: " +  Getmuted + "\t");
            if(Getmuted > 0){
            
            Addmutation(Enfant1);
            Addmutation(Enfant2);
    
            }
            
            sumconstraint(Enfant1);
            sumconstraint(Enfant2);
    
            CheckSampleindividual(Enfant1,0,ind_Parent1);
            CheckSampleindividual(Enfant2,0,ind_Parent2);
    
    
    }
    
            void CheckSampleindividual(Solution individual, int k, int ind){
            int compteur = k;
            boolean check = true;
            for(int i = 0; i < NbConstraints; i++){
                
                 System.out.println( "La contrainte est: " +  constraint[i] + "\t");
                if( individual.SumConstraint[i] > constraint[i] || individual.SumConstraint[i] == 0){
                 
                    check = false;
                    break;
                }
            }
            
                 System.out.println("le booléen est: " + check + "\t");
            if(check == false){
                
                 System.out.println("La solution n'est pas admissible" + "\t"); 
            
                if(compteur < 1){
                    RepaireSample(individual);
                    compteur++;
                    CheckSampleindividual(individual, compteur, ind);
    
                }
                }else{
                    
                 System.out.println("La solution est admissible" + "\t"); 
                    this.Echantillon[ind] = individual;
                    compteur++;
                    }
                }
    
    
    
        void Addmutation(Solution Enfant){
            int compteur = 0;
            int indice;
            int choix; 
            Random random  = new Random();
            List<Integer> listChoix = new ArrayList<Integer>();

            
    
            for(int i = 0; i < NbVariable; i++){
                if(Enfant.solution[i] < 1){
                }
            }
            for(int i = 0; i < NbVariable; i++){
                if(Enfant.solution[i] < 1){
                    listChoix.add(i);
                    compteur++;
                }
            }

            if(compteur > 0){

                indice = random.nextInt(compteur - 0) + 0;
                choix = listChoix.get(indice);
                Enfant.solution[choix] = 0;
        
                }
                
    
    
    
        }
    
    
    
    
       
    
    
       void UpdateEllitismPopulation(){  
    
    
             Arrays.sort(Population, Collections.reverseOrder());    
            for(int i = 0; i < this.Nbind; i++){
    
                Population[this.NbPop - i - 1].solution = Echantillon[i].solution; 
    
            }
            
        fitnessValuePop();
        Arrays.sort(Population, Collections.reverseOrder());
    
    
    
    
       }
    
       void UpdateFusionPopulation(){
        int compteur;
        int comptList = 0; 

        if(this.NbPop % 2 == 0){
            compteur = this.NbPop / 2;
        }else{
            compteur = (this.NbPop + 1) / 2;
        }
        fitnessValueSample();
        int tailleList = this.NbPop + this.Nbind;
        int indlist;
    
        Solution List[] = new Solution[tailleList];
    
        for(int i = 0; i < this.NbPop; i++){
            List[i] = this.Population[i];
        }
    
        for(int j = 0; j < this.Nbind; j++){

            indlist = this.NbPop + j;
    
            List[indlist] = this.Echantillon[j];
        }
    
    
        Arrays.sort(List, Solution.OperatorFitness1);
    
    
        for(int k = 0; k < compteur; k++){
            this.Population[k] = List[k];
        
        }

        Arrays.sort(List, Solution.OperatorFitness2);

        for(int k = 0; k < compteur; k++){
            this.Population[k] = List[comptList];
            comptList += 1; 
        
        }

       }
    
    void resolve(int Nbgen){ 
    Random rand = new Random(); 
    int nbCrossover;
    this.initPopulation();
    System.out.println("La population est créée");
   for(int i = 0; i < Nbgen; i++){
        this.fitnessValuePop();
        this.displayPopulation();
        this.Tournament();
     nbCrossover = rand.nextInt(this.Nbind - 0) + 0;
        for(int k = 0; k < nbCrossover; k++){
            this.CrossoverMutation();

        }
        this.UpdateFusionPopulation();
    }
  /*   Arrays.sort(Population, Collections.reverseOrder()); */
  Arrays.sort(this.Population, Solution.OperatorFitness1);
  this.displayPopulation(); 
}
    


    



    

    

  

       
        };


      
  

    

