public class RealEstate extends Property {
    private Player owner;
    private int[] rent;
    private int morgageValue;
    int houseCount = 0;
    
    public RealEstate(String name, String buyPrice, int[] rent, int morgageValue) {
        super(name, buyPrice, true);
        this.rent = rent;
        this.morgageValue = morgageValue;
    }

    public int getRent() {
        return rent[houseCount];
    }

    public Player getOwner() {
        return owner;
    }
    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void addHouse() {
        if (houseCount < 5) {
            houseCount++;
        } else {
            System.out.println("Max houses reached");
        }
    }

//  board[1] = new RealEstate("Mediterranean Avenue", "60", new int[]{2, 10, 30, 90, 160, 250}, 30);    

    @Override
    public String toString() {
        if(isAvailable()) {
            return "RealEstate {" +
                    "name='" + getName() + '\'' +
                    "for sale'" + '\'' +
                    ", value='" + getValue() + '\'' +
                    '}';
        }
        else {
            return "RealEstate{" +
                    "name='" + getName() + '\'' +
                    ", owner='" + owner.getName() + '\'' +
                    ", rent due =" + getRent() +
                    '}';
        }
        
    }
    
}
