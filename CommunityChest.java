public class CommunityChest extends Card{

    public CommunityChest(String description, String type, int amount) {
        super(description, type, amount);

    }
    public CommunityChest(String description, String type) {
        super(description, type);
    }

    public String toString() {
        return "CommunityChest{" +
                "description='" + super.getDescription() + '\'' +
                ", type='" + super.getType() + '\'' +
                ", value=" + super.getAmount() +
                '}';
    }

}
