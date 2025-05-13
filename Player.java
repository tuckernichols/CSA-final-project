import java.util.ArrayList;

public class Player {
    private String name;
    private int money = 1500;
    private ArrayList<Property> properties = new ArrayList<Property>();
    private int position = 0;

    public Player(String name) {
        this.name = name;
    }

    public void rollDice() {
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

    public void addScore(int points) {
        this.money += points;
    }
}