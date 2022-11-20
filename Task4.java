//package com.company.task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Task4 {
    public static void main(String[] args) throws IOException {
        String path  = args[0];
        ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get(path));
        //удаляем пустые значения (\n), если они есть
        for (int i = lines.size()-1; i >=0 ; i--) {
            if(lines.get(i).equals("")) {
                lines.remove(i);
            }
        }
        //находим среднее арифметическое
        int sum = 0;
        int stepCount = 0; //количество ходов
        int[] nums = new int[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            nums[i] = Integer.parseInt(lines.get(i));
            sum += nums[i];
        }
        int average = Math.round(sum/lines.size());
        for (int i = 0; i < nums.length; i++) {
            stepCount += Math.abs(nums[i]-average);
        }
        System.out.println(stepCount);
    }
}
