import java.util.Scanner;

public class main{
    public static void main(String[] args) {
        boolean gameRunning = true;
        // Create a new player
        Player player = new Player("Tucker Nichols");
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Monopoly!");
        

        while(gameRunning){
            for(int i = 0; i < 2; i++) {
                System.out.println(player.getName() + "`s turn.");      // pre roll data
                String answer = scanner.nextLine();
                player.printPrerollData(answer);
                System.out.println("");
               
                player.rollDice();
                System.out.println(player.getName() + " rolled the dice and moved to position: " + player.getPosition());
                
                // Get the current property based on the player's position
                Property currentProperty = board.getProperty(player.getPosition());
                System.out.println("Current Property: " + currentProperty.getName());

                if(currentProperty instanceof RealEstate) {                         // if real estate
                    RealEstate currentRealEstate = (RealEstate) currentProperty;
                    System.out.println(currentProperty);
                    if(currentProperty.isAvailable()){
                        System.out.println("Do you want to buy it? (yes/no)");
                        answer = scanner.nextLine();
                        if(answer.equalsIgnoreCase("yes")){
                            player.buyProperty(currentProperty);
                        } else {
                            System.out.println("You chose not to buy the property.");
                        }
                    } else {
                        System.out.println("This property is owned by " + currentRealEstate.getOwner().getName());
                        System.out.println("Rent paid: " + currentRealEstate.getRent());
                        player.transact(-currentRealEstate.getRent());
                    }
                } else{
                    System.out.println("This property is not a real estate.");
                }

                System.out.println("- - - - - - - - - - - -");

            }

        }

    }
}