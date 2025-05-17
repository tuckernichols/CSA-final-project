public class RealEstate extends Property {
    private Player owner;
    private int[] rent;
    private int morgageValue;
    int houseCount = 0;
    
    public RealEstate(String name, int buyPrice, int[] rent, int morgageValue) {
        super(name, buyPrice, true);
        this.rent = rent;
        this.morgageValue = morgageValue;
    }

    public int getRent() {
        return rent[houseCount];
    }

    
    public void buyHouse() {
        if (houseCount < 5) {
            houseCount++;
            // this.transact()
        } else {
            System.out.println("Max houses reached");
        }
    }


    @Override
    public String toString() {
        if(isAvailable()) {
            return "RealEstate {" +
                    "FOR SALE'" + '\'' +
                    "Name='" + getName() + '\'' +
                    ", Price='" + getValue() + '\'' +
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
