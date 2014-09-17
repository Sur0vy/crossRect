/**
 * Дан набор прямоугольников, заданных двумерными координатами пары противоположных вершин (левой нижней и правой верхней).
 * Стороны прямоугольников параллельны осям координат.
 * Прямоугольники могут пересекаться друг с другом.
 * Найдите общую площадь, которую покрывают эти прямоугольники
 */

package com.company;

import java.util.Scanner;

public class Main {

    //площади прямоугольников с учетом пересечений
    public static int fullArea(RectangleList rl){
        if (rl.hasCrossed()) {
            //новые прямоугольники, образованные пересечением и вхождением
            RectangleList rlSub = new RectangleList(rl);
            return (rl.totalArea() - fullArea(rlSub));
        } else {
            //удалим все дублирующиеся
            if (rl.size() > 1) {
                rl.deleteEquality();
            }
            return (rl.totalArea());
        }
    }

    public static void main(String[] args) {
        //запустим цикл заполнения массива прямоугольников
        Scanner in = new Scanner(System.in);
        System.out.println("Enter rectangles count:");
        int cnt = in.nextInt();
        RectangleList rl = new RectangleList();
        if (cnt > 0) {
            for (int i = 0; i < cnt; i++) {
                System.out.println("Enter \"" + (i + 1) + "\" rectangle coordinats:");
                int x1 = in.nextInt();
                int y1 = in.nextInt();
                int x2 = in.nextInt();
                int y2 = in.nextInt();
                if ((x1 >= 0) && (x2 >= 0) && (y1 >= 0) && (y2 >= 0)) {
                    rl.addRectangle(x1, y1, x2, y2);
                } else {
                    System.out.println("Invalid rectangle parameters!");
                }
            }
        }
        //делаем расчет
        int rectArea = fullArea(rl);
        System.out.println("Full area = " + rectArea);
    }
}
