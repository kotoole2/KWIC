/*
 * Kelly O'toole
 * 6/7/2018
 * Sorter.java
 *
 * DESCRIPTION
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * DESCRIPTION
 *
 * @author Kelly O'toole
 * @version 1.0
 **/
public class KWICshift
{
    private ArrayList<String> data = new ArrayList<>();

    public KWICshift()
    {
        //do nothing...
    }

    public void shiftSort(String filename){

        reader(filename);

        ArrayList<String> temparr = new ArrayList<>();

        for (String aline: data) {
            System.out.println(aline);
            String tempString = "";
            String[] parts = aline.split(" ");


            for (int i = 1; i< parts.length; i++){
                tempString += parts[i]+ " ";
            }

            tempString += parts[0];

            temparr.add(tempString);

        }

        data = temparr;

        Collections.sort(data);

        for (String aline: data)
        {
            fileWriter(aline);
        }
    }

    //reads in file and adds to data
    private void reader(String filename){
            Scanner reader;
        try
        {
            reader = new Scanner(new FileInputStream((filename)));

            while(reader.hasNextLine())
            {
                data.add(reader.nextLine());
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    private void fileWriter(String line){

        PrintWriter writer = null;

        try
        {
            writer = new PrintWriter(new FileOutputStream("output.txt", true));

            writer.println(line);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            writer.close();
        }

    }
}
