#include<iostream> 
#include<vector> 
#include<fstream> 
#include "VagaAlgorithm.hpp"

int main(){
      /*La fonction checkup n'est pas bonne */
 
   std::string file = "Knapsack.txt";

   VegaAlgorithm Vega = VegaAlgorithm(file,100,10);
   
  Vega.resolve(10);

}