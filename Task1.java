//Круговой массив - массив из элементов, в котором по достижению конца массива следующим элементом будет снова первый. 
//Mассив задается числом n, то есть представляет собой числа от 1 до n.
//Напишите программу, которая выводит путь, по которому, двигаясь интервалом длины m по заданному массиву, концом будет являться первый элемент.
//Началом одного интервала является конец предыдущего. Путь - массив из начальных элементов полученных интервалов.
//Пример 1:
//n = 4, m = 3
//Решение:
//Круговой массив: 1234. При длине обхода 3 получаем интервалы: 123, 341. Полученный путь: 13.
//Параметры передаются в качестве аргументов командной строки.

public class Task1 {
    public static void main(String[] args) {
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
