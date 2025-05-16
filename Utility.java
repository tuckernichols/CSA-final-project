public class Utility extends Property {
    

    public Utility(String name) {
        super(name, 150, true);
    }

    public int getRent(int diceRoll) {
        int multiplier = 4;
        for (Property property : getOwner().getProperties()) {          // if owner has more than one utility 
            if (property instanceof Utility && property != this) { 
                multiplier = 10;
            }
        }
        return multiplier * diceRoll;
    }

    @Override
    public String toString() {
        if (isAvailable()) {
            return "Utility {" +
                    "FOR SALE'" + '\'' +
                    "Name='" + getName() + '\'' +
                    ", Price='" + getValue() + '\'' +
                    '}';
        } else {
            return "Utility{" +
                    "name='" + getName() + '\'' +
                    ", owner='" + getOwner().getName() + '\'' +
                    '}';
        }
    }
}
