package vttp.batch5.sdf.task01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import vttp.batch5.sdf.task01.models.BikeEntry;

public class fileManagement {

    public List<BikeEntry> csvReader(String fileName) throws FileNotFoundException, IOException{

            File file = new File(fileName);
            // System.out.println(file.getCanonicalPath());

            // A good check to see if file exist in the folder

            // if (file.exists()){
            //     System.out.println(file.toString() + " found!");
            // } else {
            //     System.out.println(file.toString() + " does not exist");
            // }

            //Setup a catcher and a container
            String line = "";
            List<BikeEntry> database = new ArrayList<>();

            //Hire a File Reader and set him to slow mode
            // try { 
            BufferedReader br = new BufferedReader(new FileReader(file));
    
            //Catcher machine, process and put in container

            while ((line = br.readLine()) != null){
                if (!line.startsWith("season")){
                    String[] lineData = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); //!https://stackoverflow.com/questions/15738918/splitting-a-csv-file-with-quotes-as-text-delimiter-using-string-split

                    BikeEntry temp = BikeEntry.toBikeEntry(lineData);
                    database.add(temp);
                }

            }

            return database;
        
    }
}
