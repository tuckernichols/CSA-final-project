public class PlayerAI extends Player {
    private boolean isAggressive; // AI aggressiveness flag

    public PlayerAI(String name) {
        super(name);
    }

    private void decideStrategy() {
        // Simple strategy decision based on the player's current money
        if (getMoney() > 1500) {
            isAggressive = true; // Aggressive if money is above a certain threshold
        } else {
            isAggressive = false; // Conservative otherwise
        }
    }

    public boolean shouldBuyProperty(Property property) {
        decideStrategy(); // Update strategy before making a decision
    
        // If the property is not available for purchase, return false
        if (!property.isAvailable()) {
            return false;
        }
    
        // Aggressive AI logic
        if (isAggressive) {
            // Aggressive AI prioritizes Railroads and Utilities for strategic advantage
            if (property instanceof RailRoad || property instanceof Utility) {
                return true;
            }
            // Aggressive AI buys RealEstate if it has enough money
            if (property instanceof RealEstate) {
                RealEstate realEstate = (RealEstate) property;
                return getMoney() > realEstate.getValue();
            }
        } else {
            // Conservative AI logic
            if (property instanceof RealEstate) {
                RealEstate realEstate = (RealEstate) property;
                // Conservative AI buys if the property is cheap or strategically valuable
                return getMoney() > realEstate.getValue() * 0.75 && realEstate.getRent() > 50;
            }
            // Conservative AI avoids Railroads and Utilities unless it has a lot of money
            if ((property instanceof RailRoad || property instanceof Utility) && getMoney() > 1000) {
                return true;
            }
        }
    
        // Default fallback: don't buy if none of the above conditions are met
        return false;
    }

    


    
    
}
