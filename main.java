public class main{
    public static void main(String[] args) {
        boolean gameRunning = true;
        // Create a new player
         Player player = new Player("Tucker Nichols");
        Board board = new Board();

        while(gameRunning){
            for(int i = 0; i < 2; i++) {
                player.rollDice();
                System.out.println(player.getName() + " rolled the dice and moved to position: " + player.getPosition());
                Property currentProperty = board.getProperty(player.getPosition());
                System.out.println("Current Property: " + currentProperty);
                
                // Check if the property is available
                if (currentProperty.isAvailable()) {
                    System.out.println("You can buy this property for $" + currentProperty.getValue());
                    // Add logic to buy the property
                } else {
                    System.out.println("This property is not available.");
                }
                System.out.println("- - - - - - - - - - - -");

            }

        }

    }
}