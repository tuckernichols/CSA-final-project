import java.util.ArrayList;
public class GameManager {

    public void printPrerollData(Player currentPlayer, ArrayList<Player> players) {
        System.out.println("Current Player: " + currentPlayer.getName());
        System.out.print("Money: " + currentPlayer.getMoney() + ", ");
        System.out.println("Position: " + currentPlayer.getPosition());
        System.out.print("Properties Owned: ");
        for (Property property : currentPlayer.getProperties()) {
            System.out.println("- " + property.getName());
        }
        
        System.out.println("\nOther Players:");
        for (Player player : players) {
            if (!player.equals(currentPlayer)) {
                System.out.println(player.getName() + " - Money: " + player.getMoney() + ", Position: " + player.getPosition());
            }
        }
        System.out.println("");
    }
}
