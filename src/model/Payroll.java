package model;

public class Payroll {

    private double hra;
    private double da;
    private double pf;
    private double tax;
    private double netSalary;

    // Business logic: salary calculation
    public void calculateSalary(double basicSalary) {

        hra = basicSalary * 0.20;   // 20% HRA
        da  = basicSalary * 0.10;   // 10% DA
        pf  = basicSalary * 0.12;   // 12% PF
        tax = basicSalary * 0.05;   // 5% Tax

        netSalary = basicSalary + hra + da - pf - tax;
    }

    // Getters only (no setters = safer design)
    public double getHra() {
        return hra;
    }

    public double getDa() {
        return da;
    }

    public double getPf() {
        return pf;
    }

    public double getTax() {
        return tax;
    }

    public double getNetSalary() {
        return netSalary;
    }
}
