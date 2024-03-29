package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код

        InputStream inputStream = null;
        BufferedInputStream buffer = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        reader.close();


        try {
            inputStream = new FileInputStream(filePath);
            buffer = new BufferedInputStream(inputStream);

            while(buffer.available() > 0){

                char c = (char)buffer.read();
                System.out.print(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            buffer.close();
        }


    }
}