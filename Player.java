import java.util.ArrayList;

public class Player {
    private String name;
    private int money = 1500;
    private ArrayList<Property> properties = new ArrayList<Property>();
    private int position = 0;

    public Player(String name) {
        this.name = name;
    }

    public int rollDice() {
        int die1 = (int) (Math.random() * 6) + 1;
        int die2 = (int) (Math.random() * 6) + 1;
        int total = die1 + die2;
    
        // Move the player
        position += total;

        // Check if the player has passed "Go"
        if (position >= 40) {
            position -= 40; // Assuming the board has 40 spaces
            addScore(200); // Collect $200 for passing "Go"
        }
        return total;  // return for if landed on utility
    }
    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }
    public void printPrerollData(String data) {
        if(data.contains("properties")){
            System.out.println("Properties: ");
            for (Property property : properties) {
                System.out.println(property.getName());
            }
        } else if(data.contains("money")){
            System.out.println("Money: " + money);
        } else if(data.contains("position")){
            System.out.println("Position: " + position);
        } else {
            System.out.println("Invalid data requested.");
        }
    }

    public void buyProperty(Property property) {
        if (property.isAvailable()) {
            this.money -= property.getValue();
            property.setOwner(this);
            property.setAvailable(false);
            properties.add(property);
            System.out.println(name + " bought " + property.getName());
            System.out.println("Remaining money: " + this.money);
        } else {
            System.out.println(property.getName() + " is not available for purchase.");
        }
    }

    public void transact(int amount) {
        this.money += amount;
    }

    
    public void pay(int amount, Player otherPlayer) {
        this.money -= amount;
        otherPlayer.money += amount;
    }
    public void addProperty(Property property) {
        properties.add(property);
    }
    public ArrayList<Property> getProperties() {
        return properties;
    }  
    public void setPosition(int position) {
        this.position = position;
    }

    public void addScore(int points) {
        this.money += points;
    }
}