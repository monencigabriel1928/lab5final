package lab5;
//Creati urmatoarea clasa:

     //   Employee
      //  - name
      //  - email
      //  - hourRate
      //  - capacity (work hours per day)
       // - freeDays (to be reduced from monthly income)
       // + calculateDailyIncome() // -> hourRate * capacity
       // + calculateMonthlyIncome() // -> calculateDailyIncome() * (21-freeDays)

      //  Implementati un program care citeste de la tastatura datele a N employees (N se citeste de la tastatura)
      //  iar apoi afiseaza salariul lunar. Datele se vor salva intr-un ArrayList de tipul Employee.

import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String name;
    private String email;
    private double hourRate;
    private int capacity;
    private int freeDays;

    public Employee(String name, String email, double hourRate, int capacity, int freeDays) {
        this.name = name;
        this.email = email;
        this.hourRate = hourRate;
        this.capacity = capacity;
        this.freeDays = freeDays;
    }

    public double calculateDailyIncome() {
        return hourRate * capacity;
    }

    public double calculateMonthlyIncome() {
        return calculateDailyIncome() * (21 - freeDays);
    }

    public String getName() {
        return name;
    }
}

class SalaryCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceți numărul de angajați (N): ");
        int numberOfEmployees = scanner.nextInt();

        ArrayList<Employee> employees = new ArrayList<>();

        for (int i = 1; i <= numberOfEmployees; i++) {
            System.out.println("\nIntroduceți informațiile pentru angajatul " + i + ":");
            System.out.print("Nume: ");
            String name = scanner.next();

            System.out.print("Email: ");
            String email = scanner.next();

            System.out.print("Tarif pe oră: ");
            double hourRate = scanner.nextDouble();

            System.out.print("Capacitate (ore pe zi): ");
            int capacity = scanner.nextInt();

            System.out.print("Zile libere: ");
            int freeDays = scanner.nextInt();

            employees.add(new Employee(name, email, hourRate, capacity, freeDays));
        }

        System.out.println("\nSalariul lunar pentru fiecare angajat:");
        for (Employee employee : employees) {
            System.out.println(employee.calculateMonthlyIncome() + " RON pentru " + employee.getName());
        }
    }
}
