public abstract class Card {
    private String description;
    private String type;
    private int amount = 0;
    

    public Card(String description, String type, int amount ) {
        this.description = description;
        this.type = type;
        this.amount = amount;
        
    }

    public Card(String description, String type) {
        this.description = description;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }
    public String getType() {
        return type;
    }
    public int getAmount() {
        return amount;
    }

    public void applyEffect(Player player) {
        if(type.equals("payment")) {
            player.transact(amount);
        } else if(type.equals("moveTo")) {
            player.setPosition(amount);
        } else if(type.equals("advance to nearest RAILROAD")) {
            if(player.getPosition() < 10) {
                player.setPosition(5);
                System.out.println(player.getName() + " moved to position " + " reading railroad");
            } else if (player.getPosition()  < 20) {
                player.setPosition(15);
                System.out.println(player.getName() + " moved to position " + " pennsylvania railroad");
            } else if(player.getPosition()  < 30) {
                player.setPosition(25);
                System.out.println(player.getName() + " moved to position " + " B&O (Body & Odor) railroad");
            } else {
                player.setPosition(35);
                System.out.println(player.getName() + " moved to position " + " short line railroad");
            }
        } 
        
    }
}
