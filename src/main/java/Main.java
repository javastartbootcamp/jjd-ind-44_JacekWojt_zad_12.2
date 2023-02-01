import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("employees.csv");

        if (file.exists()) {
            String fileName = "employees.csv";
            Employee[] employees = CompanyUtils.read(fileName);
            double[] statistics = CompanyUtils.statistics(employees);
            File stats = new File("stats.txt");
            stats.createNewFile();
            FileWriter fileWriter = new FileWriter(stats);
            fileWriter.write("Średnia wypłat: " + statistics[0] + "\n");
            fileWriter.write("Minimalna wypłata: " + statistics[1] + "\n");
            fileWriter.write("Maksymalna wypłata: " + statistics[2] + "\n");
            fileWriter.write("Liczba pracowników IT: " + (int) statistics[3] + "\n");
            fileWriter.write("Liczba pracowników Support: " + (int) statistics[4] + "\n");
            fileWriter.write("Liczba pracowników Management: " + (int) statistics[5] + "\n");
            fileWriter.close();
        }
    }
}
