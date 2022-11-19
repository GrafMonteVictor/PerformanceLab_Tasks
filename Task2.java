//package com.company.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Task2 {
    public static void main(String[] args) throws IOException {
        //читаем данные из файл1, файл2
        Path pathToFile1 = Paths.get(args[0]);
        Path pathToFile2 = Paths.get(args[1]);
        ArrayList<String> file1 = (ArrayList<String>) Files.readAllLines(pathToFile1);
        ArrayList<String> file2 = (ArrayList<String>) Files.readAllLines(pathToFile2);
        //переводим из String во float из файл1
        String[] coordCentre = file1.get(0).split(" ");
        float x0 = Float.parseFloat(coordCentre[0]);
        float y0 = Float.parseFloat(coordCentre[1]);
        float r0 = Float.parseFloat(file1.get(1));
        //переводим из String во float из файл2
        float[][] coordPoints = new float[file2.size()][2];
        for (int i = 0; i < file2.size(); i++) {
            String[] tempCoord = file2.get(i).split(" ");
            coordPoints[i][0] = Float.parseFloat(tempCoord[0]);
            coordPoints[i][1] = Float.parseFloat(tempCoord[1]);
            //определяем положение точек
            float rPoint;
            rPoint = (float) Math.sqrt(Math.pow(x0-coordPoints[i][0],2) + Math.pow(y0-coordPoints[i][1],2));
            if(rPoint < r0) {
                System.out.println(i + " - точка внутри");
            } else if(rPoint == r0) {
                System.out.println(i + " - точка лежит на окружности");
            } else {
                System.out.println(i + " - точка снаружи");
            }
        }
    }
}
