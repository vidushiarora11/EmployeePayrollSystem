package util;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import model.Employee;
import model.Payroll;

import java.io.FileOutputStream;

public class PDFGenerator {

    public static void generateSalarySlip(
            Employee employee,
            Payroll payroll,
            String month
    ) {

        try {
            Document document = new Document();

            PdfWriter.getInstance(
                    document,
                    new FileOutputStream("output/SalarySlip_" + employee.getName() + ".pdf")
            );

            document.open();

            document.add(new Paragraph("EMPLOYEE SALARY SLIP"));
            document.add(new Paragraph("-----------------------------"));
            document.add(new Paragraph("Month: " + month));
            document.add(new Paragraph(""));

            document.add(new Paragraph("Employee Name: " + employee.getName()));
            document.add(new Paragraph("Designation: " + employee.getDesignation()));
            document.add(new Paragraph("Department: " + employee.getDepartment()));
            document.add(new Paragraph(""));

            document.add(new Paragraph("Basic Salary: " + employee.getBasicSalary()));
            document.add(new Paragraph("HRA: " + payroll.getHra()));
            document.add(new Paragraph("DA: " + payroll.getDa()));
            document.add(new Paragraph("PF: " + payroll.getPf()));
            document.add(new Paragraph("Tax: " + payroll.getTax()));
            document.add(new Paragraph(""));

            document.add(new Paragraph("Net Salary: " + payroll.getNetSalary()));

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
