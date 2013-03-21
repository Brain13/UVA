// 438 - The Circumference of the Circle
import java.util.*;
public class Circle {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        while (input.hasNext()) {
        
            double x1 = input.nextDouble();
            double y1 = input.nextDouble();
            double x2 = input.nextDouble();
            double y2 = input.nextDouble();
            double x3 = input.nextDouble();
            double y3 = input.nextDouble();
            
            double length1 = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)) / 2;
            double length2 = Math.sqrt((x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1));
            double angle = Math.acos(length1 / length2);
            double radius = length1 / Math.cos(angle / 2);
            
            double cir = 2 * Math.PI * radius;
            
            System.out.printf("%.2f\n", cir);
        
        }
    }
}
