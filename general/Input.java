package general;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;

class Input {
    public static void main(String[] args){

        
        var a = 1.0f;
        var b = 2f;
        System.out.println(String.format("output %.2f",a+b));

        //------------------Data type--------------------------------------

        String str = "this is string";
        int number = 10;
        // BigInteger bigNumber = 10;

        //------------------variable type----------------------------------
        

        // -----------------Reading from terminal-----------------------------
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = s.nextLine();
        System.out.println("Enter your age");
        int age = s.nextInt();
        s.close();

        System.out.println(String.format("Hello, %s. Your age is %d", name, age));


        // -----------------Reading form file--------------
        String fileName = "example.txt";
        try{
            FileWriter fielWriter = new FileWriter(fileName);  
            BufferedWriter bufferedWriter = new BufferedWriter(fielWriter);
            bufferedWriter.write("Hello world");
            bufferedWriter.newLine();
            bufferedWriter.write("Today is Sunday");
            bufferedWriter.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
            bufferedReader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}