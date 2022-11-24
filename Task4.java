//package com.company.task4;
//Дан массив целых чисел nums. Напишите программу, выводящую минимальное количество ходов, требуемых для приведения всех элементов к одному числу. 
//За один ход можно уменьшить или увеличить число массива на 1.
//Пример: nums = [1, 2, 3]
//Решение: [1, 2, 3] => [2, 2, 3] => [2, 2, 2]
//Минимальное количество ходов: 2
//Элементы массива читаются из файла, переданного в качестве аргумента командной строки.
//Пример: На вход подаётся файл с содержимым: 1 10 2 9
//Вывод в консоль: 16


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Task4 {
    public static void main(String[] args) throws IOException {
        String path  = args[0];
        ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get(path));
        for (int i = lines.size()-1; i >=0 ; i--) {
            if(lines.get(i).equals("")) {
                lines.remove(i);
            }
        }
        int sum = 0;
        int stepCount = 0; 
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
