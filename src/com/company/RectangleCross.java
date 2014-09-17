package com.company;

import java.awt.*;

/**
 * прямоугольние, заданный четырмя координатами на плоскости
 * левый нижний м правый верхний углы
 */
public class RectangleCross extends Rectangle {

    public RectangleCross(int x1, int y1, int x2, int y2){
       if (x1 < x2){
           x = x1;
       } else {
           x = x2;
       };
       width = Math.abs(x2 - x1);
       if (y1 < y2){
           y = y1;
       } else {
           y = y2;
       };
       height = Math.abs(y2 - y1);
   }

    public int area(){
        return(width * height);
    }

    public int getX1(){
        return x;
    }

    public int getX2(){
        return (x + width);
    }

    public int getY1(){
        return y;
    }

    public int getY2(){
        return (y + height);
    }

}
