//package com.company.task1;
//
//import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("n");
//        int n = Integer.parseInt(sc.nextLine());
//        System.out.println("m");
//        int m = Integer.parseInt(sc.nextLine());
        if(args.length == 0) {
            System.out.println("Argument is not found");
            System.exit(0);
        }
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        if(n<=0 || m<=0) {
            return;
        }
        String path = "";
        if(n<m) {
            if(m%n == 0) {
                m = m/n;
                path = outputingPath(m, n);
            }
            else {
                m = m%n;
                path = outputingPath(m, n);
            }
        }
        else if (n>m || n==m){
            path = outputingPath(m, n);
        }
        System.out.println(path);
        //sc.close();
    }

    public static String outputingPath(int m, int n) {
        String s = "";
        int x; //количество единиц до 1
        int y; //количество ост-хся ячеек
        int i = 1; //первый элемент
        int j; //последний элемент
        while (true) {
            s += i; //добавляем значения в строку
            if((n-i)>(m-1)) {
                j = m;
            } else if((n-i)==(m-1)) {
                j = n;
            }
            else {
                x = n - i;
                y = (m-1) - x - 1;
                j = 1 + y;
            }
            if(j == 1) break;
            i = j;
        }
        return s;
    }
}
