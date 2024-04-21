package lib;

public class TaxFunction {

    // Objek baru untuk menyimpan informasi pajak
    static class TaxInfo {
        int monthlySalary;
        int otherMonthlyIncome;
        int numberOfMonthWorking;
        int deductible;
        boolean isMarried;
        int numberOfChildren;

        public TaxInfo(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
            this.monthlySalary = monthlySalary;
            this.otherMonthlyIncome = otherMonthlyIncome;
            this.numberOfMonthWorking = numberOfMonthWorking;
            this.deductible = deductible;
            this.isMarried = isMarried;
            this.numberOfChildren = numberOfChildren;
        }
    }

    // Metode calculateTax direfactor untuk menggunakan objek TaxInfo
    public static int calculateTax(TaxInfo taxInfo) {
        int tax = 0;
        
        // Validasi jumlah bulan bekerja
        if (taxInfo.numberOfMonthWorking > 12) {
            System.err.println("More than 12 month working per year");
        }
        
        // Batasi jumlah anak maksimum menjadi 3
        int adjustedChildren = Math.min(taxInfo.numberOfChildren, 3);
        
        // Hitung pajak berdasarkan informasi yang diberikan
        if (taxInfo.isMarried) {
            tax = (int) Math.round(0.05 * (((taxInfo.monthlySalary + taxInfo.otherMonthlyIncome) * taxInfo.numberOfMonthWorking) - taxInfo.deductible - (54000000 + 4500000 + (adjustedChildren * 1500000))));
        } else {
            tax = (int) Math.round(0.05 * (((taxInfo.monthlySalary + taxInfo.otherMonthlyIncome) * taxInfo.numberOfMonthWorking) - taxInfo.deductible - 54000000));
        }
        
        // Pajak tidak boleh negatif
        return Math.max(tax, 0);
    }
}
