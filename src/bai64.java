import java.util.Scanner;

public class bai64 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String monthInput;
        int year;

        while (true) {
            System.out.print("Enter month (name, abbreviation, or number): ");
            monthInput = scanner.next();

            System.out.print("Enter year (4-digit non-negative number): ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year >= 0) break;
            } else {
                scanner.next(); // Clear invalid input
            }
            System.out.println("Invalid year. Please enter again.");
        }

        int month = convertMonthToNumber(monthInput);

        while (month == -1) {
            System.out.print("Invalid month. Please enter again: ");
            monthInput = scanner.next();
            month = convertMonthToNumber(monthInput);
        }

        int days = getDaysInMonth(month, year);
        System.out.println("Number of days: " + days);

        scanner.close();
    }

    public static int convertMonthToNumber(String month) {
        month = month.toLowerCase();
        switch (month) {
            case "january": case "jan.": case "jan": case "1": return 1;
            case "february": case "feb.": case "feb": case "2": return 2;
            case "march": case "mar.": case "mar": case "3": return 3;
            case "april": case "apr.": case "apr": case "4": return 4;
            case "may": case "5": return 5;
            case "june": case "jun": case "6": return 6;
            case "july": case "jul": case "7": return 7;
            case "august": case "aug.": case "aug": case "8": return 8;
            case "september": case "sept.": case "sep": case "9": return 9;
            case "october": case "oct.": case "oct": case "10": return 10;
            case "november": case "nov.": case "nov": case "11": return 11;
            case "december": case "dec.": case "dec": case "12": return 12;
            default: return -1;
        }
    }

    public static int getDaysInMonth(int month, int year) {
        int[] daysInCommonYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] daysInLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        return isLeapYear ? daysInLeapYear[month - 1] : daysInCommonYear[month - 1];
    }
}