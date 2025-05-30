import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        boolean gameRunning = true;
        String answer;
        int roll;
        
        Board board = new Board();
        GameManager gameManager = new GameManager();
        Scanner scanner = new Scanner(System.in);  

        Player[] Players = new Player[]{new HumanPlayer("Tucker Nichols"), new PlayerAI("Bob"), new PlayerAI("stupid guy")};

        System.out.println("\n Welcome to Monopoly!");
        System.out.println("- - - - - - - - - - - -");

        

        

        while(gameRunning){
            for(Player currentPlayer : Players) {
                if(currentPlayer.isBankrupt()) {
                    System.out.println(currentPlayer.getName() + " is bankrupt and has been eliminated from the game.");

                    continue; // Skip to the next currentPlayer
                }
               
                gameManager.printPrerollData(currentPlayer, Players); // print pre roll data
                roll = currentPlayer.rollDice();
                System.out.println(currentPlayer.getName() + " rolled the dice and moved to position: " + currentPlayer.getPosition());
                
                if (currentPlayer.getPosition() + roll > 40 ) { // Passed go
                    System.out.println("You passed Go - Collect $200.");
                    currentPlayer.transact(200); 
}
                // Get the current property based on the currentPlayer's position
                Property currentProperty = board.getProperty(currentPlayer.getPosition());
                System.out.println("Current Property: " + currentProperty.getName());

                   // paying rent
                if(currentProperty.getOwner() != currentPlayer && !currentProperty.isAvailable()) { // if property is not available and not owned by current player
                    if(currentProperty instanceof RealEstate) {
                        RealEstate currentRealEstate = (RealEstate) currentProperty;
                        System.out.println("This property is owned by " + currentRealEstate.getOwner().getName());
                        System.out.println("Rent paid: " + currentRealEstate.getRent());
                        currentPlayer.pay(currentRealEstate.getRent(), currentProperty.getOwner());
                    } else if(currentProperty instanceof RailRoad) {
                        RailRoad currentRailRoad = (RailRoad) currentProperty;
                        System.out.println("This property is owned by " + currentRailRoad.getOwner().getName());
                        System.out.println("Rent paid: " + currentRailRoad.getRent());
                        currentPlayer.pay(currentRailRoad.getRent(), currentRailRoad.getOwner());
                    } else if(currentProperty instanceof Utility) {
                        Utility currentUtility = (Utility) currentProperty;
                        System.out.println("This property is owned by " + currentUtility.getOwner().getName());
                        System.out.println("Rent paid: " + currentUtility.getRent(roll));
                        currentPlayer.pay(currentUtility.getRent(roll), currentUtility.getOwner());
                    }
                }  else if(currentProperty.isAvailable()) {            // if property is available  BUY / PASS
                    if(currentPlayer instanceof HumanPlayer) {
                        System.out.println("Do you want to buy it for " + currentProperty.getValue()+ "? (yes/no)");
                        answer = scanner.nextLine();
                        if(answer.equalsIgnoreCase("yes")){
                            currentPlayer.buyProperty(currentProperty);
                        } else {
                            System.out.println("You chose not to buy the property.");
                        }
                    } else if(currentPlayer instanceof PlayerAI) { 
                        PlayerAI aiPlayer = (PlayerAI) currentPlayer;
                        if(aiPlayer.shouldBuyProperty(currentProperty)) { // if AI should buy property
                            currentPlayer.buyProperty(currentProperty);
                        } else {
                        System.out.println(currentPlayer.getName() + " chose not to buy " + currentProperty.getName() + ".");
                        }       
                    }
                } else if(currentProperty instanceof Tax) {                // if tax
                    Tax currentTax = (Tax) currentProperty;
                    System.out.println("You have to pay " + currentTax.getTaxAmount() + "$ in taxes.");
                    currentPlayer.transact(( - currentTax.getTaxAmount()));  
                }  
                else if(currentPlayer.getPosition() == 30) {                    // if go to jail
                    System.out.println("You have been sent to jail.");
                    currentPlayer.setPosition(10);
                }                                                               // if chance card
                else if(currentPlayer.getPosition() == 7 || currentPlayer.getPosition() == 22 || currentPlayer.getPosition() == 36) {      
                    ChanceCard chanceCard = board.drawChanceCard();
                    System.out.println("You have drawn a chance card - " + chanceCard.getDescription());
                    chanceCard.applyEffect(currentPlayer);
                                                                        // if community chest
                } 
                else if(currentPlayer.getPosition() == 2 || currentPlayer.getPosition() == 17 || currentPlayer.getPosition() == 33) {     
                    CommunityChest communityChest = board.drawCommunityChestCard();
                    System.out.println("You have drawn a community chest card - " + communityChest.getDescription());
                    communityChest.applyEffect(currentPlayer);
                }
                System.out.println("- - - - - - - - - - - -");
            }
        }

    }
}