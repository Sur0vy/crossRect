package com.company;

import java.util.ArrayList;

/**
 * класс список прямоугольников
 */

public class RectangleList {

    //массив прямоугольников
    private ArrayList<RectangleCross> rectList;

    //количкство прямоугольников в списке
    public int size() {
        return rectList.size();
    }

    //просто конструктор класса
    public RectangleList() {
        rectList = new ArrayList<RectangleCross>();
    }

    //конструктор - образуем список прямоугольников, основанный на пересечениях и вхождениях прямоугольников
    public RectangleList(RectangleList crossedRectList) {
        rectList = new ArrayList<RectangleCross>();
        for (int i = 0; i < crossedRectList.size(); i++) {
            for (int j = (i + 1); j < crossedRectList.size(); j++) {
                if (crossedRectList.checkCross(i, j)) {
                    addRectangle(Math.max(crossedRectList.getRect(i).getX1(), crossedRectList.getRect(j).getX1()),
                            Math.max(crossedRectList.getRect(i).getY1(), crossedRectList.getRect(j).getY1()),
                            Math.min(crossedRectList.getRect(i).getX2(), crossedRectList.getRect(j).getX2()),
                            Math.min(crossedRectList.getRect(i).getY2(), crossedRectList.getRect(j).getY2()));
                }
            }

        }
    }

    public RectangleCross getRect(int idx) {
        return rectList.get(idx);
    }

    //добавление прямоугольника в список
    public void addRectangle(int x1, int y1, int x2, int y2) {
        RectangleCross rc = new RectangleCross(x1, y1, x2, y2);
        rectList.add(rc);
    }

    //сумма площадей всех прямоугольников без учета пересечения
    public int totalArea() {
        int ta = 0;
        for (RectangleCross r : rectList) {
            ta += r.area();
        }
        return (ta);
    }

    //проверка, есть ли пересечения у прямоугольников (вхождение одного прямоугольника в другой или равенство в данном случае тоже пересечение)
    private boolean checkCross(int idx1, int idx2) {
        return (Math.min(rectList.get(idx1).getX2(), rectList.get(idx2).getX2()) > Math.max(rectList.get(idx1).getX1(), rectList.get(idx2).getX1())
                && Math.min(rectList.get(idx1).getY2(), rectList.get(idx2).getY2()) > Math.max(rectList.get(idx1).getY1(), rectList.get(idx2).getY1()));
    }

    //проверка прямоугольников на равенство
    private boolean checkEquality(int idx1, int idx2) {
        return ((rectList.get(idx1).getX1() == rectList.get(idx2).getX1()) && (rectList.get(idx1).getX2() == rectList.get(idx2).getX2())
                && (rectList.get(idx1).getY1() == rectList.get(idx2).getY1()) && (rectList.get(idx1).getY2() == rectList.get(idx2).getY2()));
    }

    //удаление из списка равных прямоугольников
    public void deleteEquality() {
        for (int i = 0; i < size(); i++) {
            for (int j = (size() - 1); j > i; j--) {
                if (checkEquality(i, j)) {
                    rectList.remove(j);
                }
            }
        }
    }

    //проверка, есть ли пересекающиеся прямоугольники в списке (в данном случае одинаковые прямоугольники не учитываются)
    public boolean hasCrossed() {
        for (int i = 0; i < size(); i++) {
            for (int j = (i + 1); j < size(); j++) {
                if ((checkCross(i, j)) && !(checkEquality(i, j))) {
                    return (true);
                }
            }
        }
        return (false);
    }

}

