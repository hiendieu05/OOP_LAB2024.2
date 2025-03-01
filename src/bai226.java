import java.util.Scanner;

public class bai226 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solving first-degree equation ax + b = 0
        System.out.println("Solving first-degree equation: ax + b = 0");
        System.out.print("Enter a: ");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter b: ");
        double b = Double.parseDouble(scanner.nextLine());

        if (a == 0) {
            if (b == 0) {
                System.out.println("The equation has infinitely many solutions.");
            } else {
                System.out.println("The equation has no solution.");
            }
        } else {
            double x = -b / a;
            System.out.println("Solution: x = " + x);
        }

        // Solving system of first-degree equations
        System.out.println("\nSolving system of equations:");
        System.out.print("Enter a11: ");
        double a11 = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter a12: ");
        double a12 = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter b1: ");
        double b1 = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter a21: ");
        double a21 = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter a22: ");
        double a22 = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter b2: ");
        double b2 = Double.parseDouble(scanner.nextLine());

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("The system has infinitely many solutions.");
            } else {
                System.out.println("The system has no solution.");
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("Solution: x1 = " + x1 + ", x2 = " + x2);
        }

        // Solving quadratic equation ax^2 + bx + c = 0
        System.out.println("\nSolving quadratic equation: ax^2 + bx + c = 0");
        System.out.print("Enter a: ");
        double qa = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter b: ");
        double qb = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter c: ");
        double qc = Double.parseDouble(scanner.nextLine());

        if (qa == 0) {
            if (qb == 0) {
                System.out.println(qc == 0 ? "The equation has infinitely many solutions." : "The equation has no solution.");
            } else {
                double x = -qc / qb;
                System.out.println("Solution: x = " + x);
            }
        } else {
            double discriminant = qb * qb - 4 * qa * qc;
            if (discriminant > 0) {
                double root1 = (-qb + Math.sqrt(discriminant)) / (2 * qa);
                double root2 = (-qb - Math.sqrt(discriminant)) / (2 * qa);
                System.out.println("Two real solutions: x1 = " + root1 + ", x2 = " + root2);
            } else if (discriminant == 0) {
                double root = -qb / (2 * qa);
                System.out.println("Double root: x = " + root);
            } else {
                System.out.println("No real solutions.");
            }
        }

        scanner.close();
    }
}