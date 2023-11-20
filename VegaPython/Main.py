from VegaAlgorithm import VegaAlgorithm
import random
import os


fileName = "knapsack.txt"
os.chdir("VegaPython")
print(os.getcwd()) 


vegaAlgorithme = VegaAlgorithm(100,10)
vegaAlgorithme.parseKnapsack(fileName)
vegaAlgorithme.resolve(100)