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
            
            double length1 = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
            double length2 = Math.sqrt((x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1));
            double length3 = Math.sqrt((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2));
            double angle = Math.acos((length1 * length1 - length2 * length2 - length3 * length3) / (2 * length2 * length3));
            double diameter = length1 / Math.sin(angle);
            
            double cir = Math.PI * diameter;
            
            System.out.printf("%.2f\n", cir);
        
        }
    }
}
