public class RailRoad extends Property{


    public RailRoad(String name) {
        super(name, 200, true);
    }

    
    public int getRent() {
        int rent = 0;
        for (Property property : getOwner().getProperties()) {
            if (property instanceof RailRoad) {
                rent += 25 ;
            }
        }
        return rent;
    }

    @Override
    public String toString() {
        if(isAvailable()) {
            return "Railroad {" +
                    "FOR SALE'" + '\'' +
                    "Name='" + getName() + '\'' +
                    ", Price='" + getValue() + '\'' +
                    '}';
        }
        else {
            return "Railroad{" +
                    "name='" + getName() + '\'' +
                    ", owner='" + getOwner().getName() + '\'' +
                    ", rent due =" + getRent() + '\'' +
                    '}';
        }
    }
}
