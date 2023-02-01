import java.io.*;
import java.util.Scanner;

public class CompanyUtils {

    public static double[] statistics(Employee[] employees) {
        double[] statistics = new double[6];
        statistics[0] = StatisticsCalculator.avgSalary(employees);
        statistics[1] = StatisticsCalculator.minSalary(employees);
        statistics[2] = StatisticsCalculator.maxSalary(employees);
        statistics[3] = StatisticsCalculator.countItEmployee(employees);
        statistics[4] = StatisticsCalculator.countSupportEmployee(employees);
        statistics[5] = StatisticsCalculator.countManagementEmployee(employees);
        return statistics;
    }

    public static Employee[] read(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        int lines = countLines(fileName);
        Employee[] results = new Employee[lines];
        for (int i = 0; i < lines; i++) {
            String line = scanner.nextLine();
            String[] split = line.split(";");
            double salary = Double.parseDouble(split[4]);
            results[i] = new Employee(split[0], split[1], split[2], split[3], salary);
        }
        return results;
    }

    private static int countLines(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        int lines = 0;
        while (scanner.hasNextLine()) {
            lines++;
            scanner.nextLine();
        }
        return lines;
    }
}
