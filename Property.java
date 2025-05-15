public class Property {
    private String name;
    private int buyPrice;
    private boolean isavailable = true;
    private Player owner;


    public Property(String name, int buyPrice, boolean isavailable) {
        this.name = name;
        this.buyPrice = buyPrice;
        this.isavailable = isavailable;
    }

    public String getName() {
        return name;
    }
    public void setAvailable(boolean isavailable) {
        this.isavailable = isavailable;
    }
    public int getValue() {
        return buyPrice;
    }

    public boolean isAvailable() {
        return isavailable;
    }
    
    public Player getOwner() {
        return owner;
    }
    
    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                '}';
    }
}

