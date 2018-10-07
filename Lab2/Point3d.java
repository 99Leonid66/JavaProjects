import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Point3d {

    private double xCoord;
    private double yCoord;
    private double zCoord;

    public Point3d(){
        this(0,0,0);
    }
    public Point3d(double x, double y, double z){
      xCoord = x;
      yCoord = y;
      zCoord = z;
    }

    void setXCoord(double x){xCoord = x;}
    void setYCoord(double y){yCoord = y;}
    void setZCoord(double z){zCoord = z;}

    double getXCoord(){return xCoord;}
    double getYCoord(){return yCoord;}
    double getZCoord(){return zCoord;}

    //Переопределение метода equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point3d point3d = (Point3d) obj;
        return Double.compare(point3d.xCoord, xCoord) == 0 &&
                Double.compare(point3d.yCoord, yCoord) == 0 &&
                Double.compare(point3d.zCoord, zCoord) == 0;
        /*return this == obj ? true : (obj == null || getClass() != obj.getClass()) ?
                false : xCoord == ((Point3d) obj).xCoord &&
                        yCoord == ((Point3d) obj).yCoord &&
                        zCoord == ((Point3d) obj).zCoord;*/
    }

    //Переопределение метода hashCode
    @Override
    public int hashCode() {
        final int PRIME = 37;
        int result = 1;
        long longBitsX = Double.doubleToLongBits(xCoord);
        long longBitsY = Double.doubleToLongBits(yCoord);
        long longBitsZ = Double.doubleToLongBits(zCoord);

        result = PRIME * result + (int)(longBitsX - (longBitsX >>> 32));
        result = PRIME * result + (int)(longBitsY - (longBitsY >>> 32));
        result = PRIME * result + (int)(longBitsZ - (longBitsZ >>> 32));

        return result;
        //return Objects.hash(xCoord,yCoord,zCoord);
    }

    //Вычисление расстояния между 2-я точками
    public double distanceTo(Point3d p) {
        return Math.sqrt(Math.pow(getXCoord() - p.getXCoord(), 2) +
                         Math.pow(getYCoord() - p.getYCoord(), 2) +
                         Math.pow(getZCoord() - p.getZCoord(), 2));
    }

    //Пользовательский ввод вещественных чисел
    public static double getDouble() {

        // There's potential for the input operation to "fail"; hard with a
        // keyboard, though!
        try {
            // Set up a reader tied to standard input.
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));

            // Read in a whole line of text.
            String s = br.readLine();

            // Conversion is more likely to fail, of course, if there's a typo.
            try {
                double d = Double.parseDouble(s);

                //Return the inputted double.
                return d;
            }
            catch (NumberFormatException e) {
                // Bail with a 0.  (Simple solution for now.)
                return 0.0;
            }
        }
        catch (IOException e) {
            // This should never happen with the keyboard, but we'll
            // conform to the other exception case and return 0 here,
            // too.
            return 0.0;
        }
    }

    //Задание координат точки
    public void setPoint3d (){//Задает координаты точки
        System.out.println("Set the coordonation of 3d point");
        System.out.print("Set the xCoor: ");
        setXCoord(getDouble());
        System.out.print("Set the yCoor: ");
        setYCoord(getDouble());
        System.out.print("Set the zCoor: ");
        setZCoord(getDouble());
    }

    //Вывод координат точки
    public void print3DPoint(){
        System.out.println('\n' + "3d point coordination: ");
        System.out.println("xCoor: " + this.getXCoord());
        System.out.println("yCoor: " + this.getYCoord());
        System.out.println("zCoor: " + this.getZCoord());
    }

    public void setCoorFromFile(String pars1,String pars2,String pars3){
        setXCoord(new Double(pars1));
        setYCoord(new Double(pars2));
        setZCoord(new Double(pars3));
    }

}
