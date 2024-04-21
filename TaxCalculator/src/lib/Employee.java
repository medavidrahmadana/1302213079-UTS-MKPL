package lib;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {

    private int yearJoined;
    private int monthJoined;
    private boolean isForeigner;
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;
    private String spouseIdNumber;
    private List<String> childNames;
    private List<String> childIdNumbers;

    public Employee(int yearJoined, int monthJoined, boolean isForeigner) {
        this.yearJoined = yearJoined;
        this.monthJoined = monthJoined;
        this.isForeigner = isForeigner;
        childNames = new LinkedList<>();
        childIdNumbers = new LinkedList<>();
    }

    public void setMonthlySalary(int grade) {
        monthlySalary = calculateMonthlySalary(grade);
    }

    private int calculateMonthlySalary(int grade) {
        int baseSalary = 0;
        if (grade == 1) {
            baseSalary = 3000000;
        } else if (grade == 2) {
            baseSalary = 5000000;
        } else if (grade == 3) {
            baseSalary = 7000000;
        }
        if (isForeigner) {
            baseSalary *= 1.5;
        }
        return baseSalary;
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public void setSpouse(String spouseIdNumber) {
        this.spouseIdNumber = spouseIdNumber;
    }

    public void addChild(String childName, String childIdNumber) {
        childNames.add(childName);
        childIdNumbers.add(childIdNumber);
    }

    public int getAnnualIncomeTax() {
        LocalDate date = LocalDate.now();
        int monthWorkingInYear = date.getYear() == yearJoined ? date.getMonthValue() - monthJoined : 12;
        return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouseIdNumber.equals(""), childIdNumbers.size());
    }
}
