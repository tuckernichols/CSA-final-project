public class ChanceCard extends Card {

    public ChanceCard(String description, String type, int amount ) {
        super(description, type, amount);
    }

    public ChanceCard(String description, String type) {
        super(description, type);

    }

    public String toString() {
        return "ChanceCard{" +
                "description='" + super.getDescription() + '\'' +
                ", type='" + super.getType() + '\'' +
                ", value=" + super.getAmount() +
                '}';
    }
}
