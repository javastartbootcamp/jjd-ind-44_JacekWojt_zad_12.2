public class StatisticsCalculator {

    public static int countEmployeesInDepartment(Employee[] employees, String department) {
        int number = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment().equals(department)) {
                number++;
            }
        }
        return number;
    }

    public static double maxSalary(Employee[] employees) {
        double maxSalary = employees[0].getSalary();
        for (int i = 1; i < employees.length; i++) {
            if (employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
            }
        }
        return maxSalary;
    }

    public static double minSalary(Employee[] employees) {
        double minSalary = employees[0].getSalary();
        for (int i = 1; i < employees.length; i++) {
            if (employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
            }
        }
        return minSalary;
    }

    public static double avgSalary(Employee[] employees) {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary / employees.length;
    }
}
