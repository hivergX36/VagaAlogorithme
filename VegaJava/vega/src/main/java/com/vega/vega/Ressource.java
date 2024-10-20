package com.vega.vega;
import java.nio.file.Paths;
import java.nio.file.Path;

public class Ressource{

    String filepathString;


    Ressource(){


        

        



    }

    public String getfileinressource(String name){

    
    Path path = Paths.get("./vega/src/main/ressources/instances" + "/" + name);

    this.filepathString = path.toString(); 
    return this.filepathString;



    }

    public String getfileinressourcefortest(String name){
            
    Path path = Paths.get("../vega/src/main/ressources/instances" + "/" + name);

    this.filepathString = path.toString(); 
    return this.filepathString;



    }



    

}