import java.io.*;
import java.util.ArrayList;
public class Lab2 {
    public static void main(String[] arg){

        File file = new File("D:\\Проекты\\Java\\Lab2\\in.txt");

        try {
            //Считывание файла и разбиение в массив
            FileInputStream inFile = new FileInputStream(file);
            byte[] buf = new byte[inFile.available()];
            inFile.read(buf);
            String txt = new String(buf);
            String[] pars = txt.split("[^0-9]");
            ArrayList<String> arrStr = new ArrayList<>();
            for (String str : pars){
                if (str.isEmpty() ){
                    continue;
                }
                else {
                    arrStr.add(str);
                }
            }
            //Массив для хранения 3д точкек
            ArrayList<Point3d> arrOfPoints = new ArrayList<>();
            //Массив для хранения площади
            ArrayList<Double>  arrOfSquare = new ArrayList<>();
            for (int i = 0, j = 0, k = 0; j < (arrStr.size()/3);){
                arrOfPoints.add(new Point3d());//Добавляем 3д точку в массив
                //Заносим координаты этой 3д точки
                arrOfPoints.get(j++).setCoorFromFile(arrStr.get(i++), arrStr.get(i++), arrStr.get(i++));
                //если имеются 3 точки, то считаем площадь и записываем её в массив
                if (arrOfPoints.size() % 3 == 0){
                    arrOfSquare.add(computeArea(arrOfPoints.get(k++), arrOfPoints.get(k++),
                            arrOfPoints.get(k++)));
                }

            }

            //Записываем ответ в новый файл
            try(FileWriter writer = new FileWriter("out.txt", false)) {
                for (int i = 0; i <  arrOfSquare.size(); i++) {
                    String answer = "The area of the " + (i+1) + " triangle is equal to " +
                            arrOfSquare.get(i) + "\r\n";
                    writer.write(answer);
                }
            }

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
