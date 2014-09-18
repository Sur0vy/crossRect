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
    public static int fullArea(RectangleList rl) {
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
        int cnt = 0;
        try {
            cnt = in.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid rectangles count");
        }
        if (cnt > 0) {
            RectangleList rl = new RectangleList();
            int x1;
            int x2;
            int y1;
            int y2;
            for (int i = 0; i < cnt; i++) {
                System.out.println("Enter \"" + (i + 1) + "\" rectangle coordinates:");
                try {
                    x1 = in.nextInt();
                    y1 = in.nextInt();
                    x2 = in.nextInt();
                    y2 = in.nextInt();
                    if ((x1 >= 0) && (x2 >= 0) && (y1 >= 0) && (y2 >= 0)) {
                        rl.addRectangle(x1, y1, x2, y2);
                    } else {
                        System.out.println("Invalid rectangle parameters!");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid rectangle coordinates!");
                }
            }
            //делаем расчет
            int rectArea = fullArea(rl);
            System.out.println("Full area = " + rectArea);
        }
    }
}
