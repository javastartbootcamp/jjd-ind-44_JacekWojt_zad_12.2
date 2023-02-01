import java.io.*;
import java.util.Scanner;

public class CompanyUtils {

    public static void write(Statistics statistics, File fileName) throws IOException {
        File stats = new File("stats.txt");
        stats.createNewFile();
        FileWriter fileWriter = new FileWriter(stats);
        fileWriter.write("Średnia wypłat: " + statistics.getAvgSalary() + "\n");
        fileWriter.write("Minimalna wypłata: " + statistics.getMinSalary() + "\n");
        fileWriter.write("Maksymalna wypłata: " + statistics.getMaxSalary() + "\n");
        fileWriter.write("Liczba pracowników IT: " + statistics.getNumberOfItEmployee() + "\n");
        fileWriter.write("Liczba pracowników Support: " + statistics.getNumberOfSupportEmployee() + "\n");
        fileWriter.write("Liczba pracowników Management: " + statistics.getNumberOfManagementEmployee() + "\n");
        fileWriter.close();
    }

    public static Statistics getStatistics(Employee[] employees) {
        Statistics statistics = new Statistics();
        statistics.setAvgSalary(StatisticsCalculator.avgSalary(employees));
        statistics.setMinSalary(StatisticsCalculator.minSalary(employees));
        statistics.setMaxSalary(StatisticsCalculator.maxSalary(employees));
        statistics.setNumberOfItEmployee(StatisticsCalculator.countEmployeesInDepartment(employees, "IT"));
        statistics.setNumberOfSupportEmployee(StatisticsCalculator.countEmployeesInDepartment(employees, "Support"));
        statistics.setNumberOfManagementEmployee(StatisticsCalculator.countEmployeesInDepartment(employees, "Management"));
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
