import java.util.Scanner;

public class main{
    public static void main(String[] args) {
        boolean gameRunning = true;
        // Create a new player
        Player player = new HumanPlayer("Tucker Nichols");
        Player[] Players = new Player[]{player};
        Board board = new Board();
        GameManager gameManager = new GameManager();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n Welcome to Monopoly!");
        System.out.println("- - - - - - - - - - - -");

        String answer;
        int roll;

        

        while(gameRunning){
            for(int i = 0; i < 1; i++) {
                gameManager.printPrerollData(player, Players); // print pre roll data
                roll = player.rollDice();
                System.out.println(roll + "!");
                System.out.println(player.getName() + " rolled the dice and moved to position: " + player.getPosition());
                
                if (player.getPosition() + roll > 40 ) { // Passed go
                    System.out.println("You passed Go - Collect $200.");
                    player.transact(200); 
}
                // Get the current property based on the player's position
                Property currentProperty = board.getProperty(player.getPosition());
                System.out.println("Current Property: " + currentProperty.getName());

                if(currentProperty instanceof RealEstate) {                         // if real estate
                    RealEstate currentRealEstate = (RealEstate) currentProperty;
                    if(currentProperty.isAvailable()){
                        System.out.println("Do you want to buy it for " + currentProperty.getValue()+ "? (yes/no)");
                        answer = scanner.nextLine();
                        if(answer.equalsIgnoreCase("yes")){
                            player.buyProperty(currentProperty);
                        } else {
                            System.out.println("You chose not to buy the property.");
                        }
                    } else if(currentProperty.getOwner() != player) {
                        System.out.println("This property is owned by " + currentRealEstate.getOwner().getName());
                        System.out.println("Rent paid: " + currentRealEstate.getRent());
                        player.pay(currentRealEstate.getRent(), currentProperty.getOwner());
                    }

                } else if(currentProperty instanceof RailRoad) {                // if railroad
                    RailRoad currentRailRoad = (RailRoad) currentProperty;
                    if(currentProperty.isAvailable()){
                        System.out.println("Do you want to buy it for 200$ ? (yes/no)");
                        answer = scanner.nextLine();
                        if(answer.equalsIgnoreCase("yes")){
                            player.buyProperty(currentProperty);
                        } else {
                            System.out.println("You chose not to buy the property.");
                        }
                    } else if(currentProperty.getOwner() != player) {
                        System.out.println("This property is owned by " + currentRailRoad.getOwner().getName());
                        System.out.println("Rent paid: " + currentRailRoad.getRent());
                        player.pay(currentRailRoad.getRent(), currentRailRoad.getOwner());
                    }

                } else if(currentProperty instanceof Utility){              // if utility
                    Utility currentUtility = (Utility) currentProperty;
                    if(currentProperty.isAvailable()){
                        System.out.println("Do you want to buy it 150$ ? (yes/no)");
                        answer = scanner.nextLine();
                        if(answer.equalsIgnoreCase("yes")){
                            player.buyProperty(currentProperty);
                        } else {
                            System.out.println("You chose not to buy the property.");
                        }
                    } else if(currentProperty.getOwner() != player) {
                        System.out.println("This property is owned by " + currentUtility.getOwner().getName());
                        System.out.println("Rent paid: " + currentUtility.getRent(roll));
                        player.pay(currentUtility.getRent(roll), currentUtility.getOwner());
                    }

                } else if(currentProperty instanceof Tax) {                // if tax
                    Tax currentTax = (Tax) currentProperty;
                    System.out.println("You have to pay " + currentTax.getTaxAmount() + "$ in taxes.");
                    player.transact(( - currentTax.getTaxAmount()));
                }  
                else if(player.getPosition() == 30) {                    // if go to jail
                    System.out.println("You have been sent to jail.");
                    player.setPosition(10);
                }                                                               // if chance card
                else if(player.getPosition() == 7 || player.getPosition() == 22 || player.getPosition() == 36) {      
                    ChanceCard chanceCard = board.drawChanceCard();
                    System.out.println("You have drawn a chance card - " + chanceCard.getDescription());
                    chanceCard.applyEffect(player);
                                                                        // if community chest
                } else if(player.getPosition() == 2 || player.getPosition() == 17 || player.getPosition() == 33) {     
                    CommunityChest communityChest = board.drawCommunityChestCard();
                    System.out.println("You have drawn a community chest card - " + communityChest.getDescription());
                    communityChest.applyEffect(player);
                }
            

                System.out.println("- - - - - - - - - - - -");

            }

        }

    }
}