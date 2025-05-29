public class Board {
    private Property[] board = new Property[40];
    private ChanceCard[] chanceCards = new ChanceCard[13];
    private CommunityChest[] communityChests = new CommunityChest[16];

    public Board() {
        initBoard();
    }
    
    private void initBoard() {
        board[0] = new Property("Go", 0, false);
        board[1] = new RealEstate("Mediterranean Avenue", 60, new int[]{2, 10, 30, 90, 160, 250}, 30);    
        board[2] = new Property("Community Chest", 0, false);
        board[3] = new RealEstate("Baltic Avenue", 60, new int[]{4, 20, 60, 180, 320, 450}, 30);
        board[4] = new Tax("Income Tax", 200);
        board[5] = new RailRoad("Reading Railroad");
        board[6] = new RealEstate("Oriental Avenue", 100, new int[]{6, 30, 90, 270, 400, 550}, 50);
        board[7] = new Property("Chance", 0, false);
        board[8] = new RealEstate("Vermont Avenue", 100, new int[]{6, 30, 90, 270, 400, 550}, 50);
        board[9] = new RealEstate("Connecticut Avenue", 120, new int[]{8, 40, 100, 300, 450, 600}, 60);
        board[10] = new Property("Jail", 0, false);
        board[11] = new RealEstate("St. Charles Place", 140, new int[]{10, 50, 150, 450, 625, 750}, 70);
        board[12] = new Utility("Electric Company");
        board[13] = new RealEstate("States Avenue", 140, new int[]{10, 50, 150, 450, 625, 750}, 70);
        board[14] = new RealEstate("Virginia Avenue", 160, new int[]{12, 60, 180, 500, 700, 900}, 80);
        board[15] = new RailRoad("Pennsylvania Railroad");
        board[16] = new RealEstate("St. James Place", 180, new int[]{14, 70, 200, 550, 750, 950}, 90);
        board[17] = new Property("Community Chest", 0, false);
        board[18] = new RealEstate("Tennessee Avenue", 180,  new int[]{14, 70, 200, 550, 750, 950}, 90);
        board[19] = new RealEstate("New York Avenue", 200, new int[]{16, 80, 220, 600, 800, 1000}, 100);
        board[20] = new Property("Free Parking", 0, false);
        board[21] = new RealEstate("Kentucky Avenue", 220, new int[]{18, 90, 250, 700, 875, 1050}, 110);
        board[22] = new Property("Chance", 0, false);
        board[23] = new RealEstate("Indiana Avenue", 220, new int[]{18, 90, 250, 700, 875, 1050}, 110);
        board[24] = new RealEstate("Illinois Avenue", 240, new int[]{20, 100, 300, 750, 925, 1100}, 120);
        board[25] = new RailRoad("B&O Railroad");
        board[26] = new RealEstate("Atlantic Avenue", 260, new int[]{22, 110, 330, 800, 975, 1150}, 130);
        board[27] = new RealEstate("Ventnor Avenue", 260, new int[]{22, 110, 330, 800, 975, 1150}, 130);
        board[28] = new Utility("Water Works");
        board[29] = new RealEstate("Marvin Gardens", 280, new int[]{24, 120, 360, 850, 1025, 1200}, 140);
        board[30] = new Property("Go to Jail", 0, false);
        board[31] = new RealEstate("Pacific Avenue", 300, new int[]{26, 130, 390, 900, 1100, 1275}, 150);    
        board[32] = new RealEstate("North Carolina Avenue", 300, new int[]{26, 130, 390, 900, 1100, 1275}, 150);
        board[33] = new Property("Community Chest", 0, false);
        board[34] = new RealEstate("Pennsylvania Avenue", 320, new int[]{28, 150, 450, 1000, 1200, 1400}, 160);
        board[35] = new RailRoad("Short Line Railroad");
        board[36] = new Property("Chance", 0, false);
        board[37] = new RealEstate("Park Place", 350, new int[]{35, 175, 500, 1100, 1300, 1500}, 175);
        board[38] = new Tax("Luxury Tax", 100);
        board[39] = new RealEstate("Boardwalk", 400, new int[]{50, 200, 600, 1400, 1700, 2000}, 200);

        // initialize chance cards
        
        // move to 
        chanceCards[0] = new ChanceCard("Advance to Go (Collect $200)", "moveTo", 0);
        chanceCards[1] = new ChanceCard("Advance to Illinois Avenue.", "moveTo", 24);
        chanceCards[2] = new ChanceCard("Advance to St. Charles Place", "moveTo", 11);
        chanceCards[6] = new ChanceCard("Take a trip to Reading Railroad", "moveTo", 5);
        chanceCards[7] = new ChanceCard("Take a walk on the Boardwalk", "moveTo", 39);
        // go to jail
        chanceCards[12] = new ChanceCard("Go to Jail - Go directly to jail - Do not pass Go, do not collect $200", "moveTo", 10);
        // advance to nearest
        chanceCards[3] = new ChanceCard("Advance to the nearest Utility", "advance to nearest", 12); // 12 = Electric Co. (or use 28 for Water Works)
        chanceCards[4] = new ChanceCard("Advance to the nearest Railroad", "advance to nearest RAILROAD"); // 5 = Reading Railroad
        chanceCards[5] = new ChanceCard("Advance to the nearest Railroad", "advance to nearest RAILROAD"); // duplicate
        // pay or collect
        chanceCards[8] = new ChanceCard("Bank pays you dividend of $50", "payment", 50);
        chanceCards[9] = new ChanceCard("Pay poor tax of $15", "payment", - 15);
        chanceCards[10] = new ChanceCard("Your building and loan matures - Collect $150", "payment", 150);
        chanceCards[11] = new ChanceCard("You have been elected Chairman - Pay the board $50", "payment", -50);

        // init community chests cards
        communityChests[0] = new CommunityChest("Advance to Go (Collect $200)", "moveTo", 0);
        communityChests[1] = new CommunityChest("Bank error in your favor - Collect $200", "payment", 200);
        communityChests[2] = new CommunityChest("Doctor's fees - Pay $50", "payment", -50);
        communityChests[3] = new CommunityChest("From sale of stock you get $50", "payment", 50);
        communityChests[4] = new CommunityChest("Go to Jail - Go directly to jail, do not pass Go, do not collect $200", "moveTo", 10); 
        communityChests[5] = new CommunityChest("Grand Opera Night - pay 50$ for opening night seats", "payment", -50); 
        communityChests[6] = new CommunityChest("Holiday Fund matures - Receive $100", "payment", 100);
        communityChests[7] = new CommunityChest("Income tax refund - Collect $20", "payment", 20);
        communityChests[8] = new CommunityChest("It is your birthday - Collect $20 from ", "payment", 20); 
        communityChests[9] = new CommunityChest("Life insurance matures - Collect $100", "payment", 100);
        communityChests[10] = new CommunityChest("Pay hospital fees of $100", "payment", -100);
        communityChests[11] = new CommunityChest("Pay school fees of $150", "payment", -150);
        communityChests[12] = new CommunityChest("Receive $25 consultancy fee", "payment", 25);
        communityChests[14] = new CommunityChest("You have won second prize in a beauty contest - Collect $10", "payment", 10);
        communityChests[15] = new CommunityChest("You inherit $100", "payment", 100);

    }

    

    public Property getProperty(int index) {
        return board[index];
    }
    

    public ChanceCard drawChanceCard() {
        int randomIndex = (int) (Math.random() * chanceCards.length);
        return chanceCards[randomIndex];
        
    }
    public CommunityChest drawCommunityChestCard() {
        int randomIndex = (int) (Math.random() * communityChests.length);
        return communityChests[randomIndex];
    }
}
