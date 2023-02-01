import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("employees.csv");

        if (file.exists()) {
            String fileName = "employees.csv";
            Employee[] employees = CompanyUtils.read(fileName);
            Statistics statistics = CompanyUtils.getStatistics(employees);
            File stats = new File("stats.txt");
            CompanyUtils.write(statistics, stats);
        }
    }
}
