package Shop;

public class SalesRegister {
    private double totalValue; // total value of transactions
    private String transactions; // list of transactions
    private int numCardSales; // number of card sales
    private int numCashSales; // number of cash sales

    public SalesRegister() {
        this.totalValue = 0.0;
        this.numCardSales = 0;
        this.numCashSales = 0;
        this.transactions = "";
    }

    public void cashSale(String item, double value) {
        if (item != null && value >= 0) {
            this.transactions = "Cash:\t£" + value + "\t" + item +"\n";
            this.numCashSales += 1;
            this.totalValue += value;
        } else System.out.println("Invalid");
    }

    public void cardSale(String item, double value) {
        if (item != null && value >= 0) {
            this.transactions += "Card:\t£" + value + "\t" + item +"\n";
            this.numCardSales += 1;
            this.totalValue += value;
        } else System.out.println("Invalid");
    }
    public String listTransactions() {
        return this.transactions;
    }
    public double getTotalValue() {
        return totalValue;
    }
    public int getNumCardSales() {
        return numCardSales;
    }
    public int getNumCashSales() {
        return numCashSales;
    }
}
