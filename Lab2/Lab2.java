import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Lab2 {
    public static void main(String[] arg){
        /*Point3d firstPoint = new Point3d();
        firstPoint.setPoint3d(); //Задание точки
        Point3d secondPoint = new Point3d();
        secondPoint.setPoint3d();
        Point3d thirdPoint = new Point3d();
        thirdPoint.setPoint3d();

        //Вывод площади треугольника
        System.out.println(computeArea(firstPoint,secondPoint,thirdPoint));*/

        File file = new File("D:\\Проекты\\Java\\Lab2\\set data.txt");

        try {
            FileInputStream inFile = new FileInputStream(file);
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            String txt = new String(str);
            String[] pars = txt.split("[^0-9]");

            ArrayList<Point3d> arr = new ArrayList<>();
            for (int i =0, j = 0; i< pars.length;){
                arr.add(new Point3d());
                arr.get(j++).setCoorFromFile(pars[i++],pars[i++],pars[i++]);
                i++;
            }
            System.out.print(computeArea(arr.get(0),arr.get(1),arr.get(2)));


        }catch (FileNotFoundException e){
            System.out.println("File not exists");
        }
        catch (Exception e){

        }
    }

    public static double computeArea(Point3d p1, Point3d p2, Point3d p3){
        //Если пара точек одинаковая - выводим сообщение и не вычисляем
        if (p1.equals(p2) || p2.equals(p3) || p3.equals(p1)) {
            System.out.println('\n' + "Pair of points is equal!");
            return 0.0;
        }
        //Вычисление площади треугольника
        else {
            double a = p1.distanceTo(p2);
            double b = p2.distanceTo(p3);
            double c = p3.distanceTo(p1);
            double p = (a + b + c) / 2; //simeperimeter
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
    }




}
