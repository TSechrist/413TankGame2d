package dev.game.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Util {

    public static String loadFileAsString(String path)
    {
        StringBuilder builder = new StringBuilder();

        try
        {
            System.out.println(new File("").getAbsolutePath() + path);
            BufferedReader br = new BufferedReader(new FileReader(new File("").getAbsolutePath() + path));
            System.out.println("Test4");
            String input;
            while((input = br.readLine()) != null)
            {
                builder.append(input + "\n");
            }
        }
        catch(IOException e){
            System.out.println("Test5");
            e.printStackTrace();
        }

        return builder.toString();

    }

    public static int parseInt(String num)
    {
        try{
            return Integer.parseInt(num);
        }
        catch(Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

}
