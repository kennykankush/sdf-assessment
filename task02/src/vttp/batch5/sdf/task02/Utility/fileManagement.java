package vttp.batch5.sdf.task02.Utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fileManagement {

    public static String[][] txtReaderToBoard(String fileName) throws IOException{

        // String folder = "TTT";

        // String directoryPath = "." + File.separator + folder + File.separator;
        
        File file = new File(fileName);

        String[][] board = new String[3][3];

        // System.out.println(file.getCanonicalPath());

        // if (file.exists()){
        //     System.out.println("Yay");
        // } else {
        //     System.out.println("Nay");
        // }

        try {

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        

        System.out.println("Processing: " + fileName + "\n");


        String line = "";
        String config_line = "";
        
        while ((line = br.readLine()) != null){
            config_line = config_line + line;
        }

        String[] config = config_line.split("");

        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                int convert = i * 3 + j;

                board[i][j] = config[convert];
            }
        }

    return board;

    } catch (IOException e){
        System.out.println("File not found!");
        System.out.println("Unable to find file at " + file.getCanonicalPath());
    } 

    return null;
    }
}


