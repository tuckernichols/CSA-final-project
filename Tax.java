public class Tax extends Property {
    private int taxAmount;

    public Tax(String name, int taxAmount) {
        super(name, 0, false);
        this.taxAmount = taxAmount;
    }

    public int getTaxAmount() {
        return taxAmount;
    }

    @Override
    public String toString() {
        return "Tax{" +
                "name='" + getName() + '\'' +
                ", taxAmount=" + taxAmount +
                '}';
    }
    
}
