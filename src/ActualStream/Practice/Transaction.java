package ActualStream.Practice;

public class Transaction {
    Trader trader;
    private int year;
    private int price;

    public Transaction(Trader trader, int year, int price) {
        this.trader = trader;
        this.year = year;
        this.price = price;
    }
    public String getName(){
        return trader.getName();
    }
    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }
}