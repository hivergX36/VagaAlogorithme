package com.vega.vega;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.*;
import java.lang.reflect.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.LinkOption; 

  class Main{
    public static void main(String[] args) throws IOException 


    {


      Ressource ressource = new Ressource();
      String path_file = ressource.getfileinressource("knapsack.txt");
      Vega Vg = new Vega(path_file, 100,10);
      Vg.resolve(30);




    

   
      
     


    } 


}
  