public class Board {
    private Property[] board = new Property[40];

    public Board() {
        initBoard();
       
    }
    
    private void initBoard() {
        board[0] = new Property("Go", "0", false);
        board[1] = new RealEstate("Mediterranean Avenue", "60", new int[]{2, 10, 30, 90, 160, 250}, 30);    
        board[2] = new Property("Community Chest", "0", false);
        board[3] = new RealEstate("Baltic Avenue", "60", new int[]{4, 20, 60, 180, 320, 450}, 30);
        board[4] = new Property("Income Tax", "0", false);
        board[5] = new Property("Reading Railroad", "200", true);
        board[6] = new RealEstate("Oriental Avenue", "100", new int[]{6, 30, 90, 270, 400, 550}, 50);
        board[7] = new Property("Chance", "0", false);
        board[8] = new RealEstate("Vermont Avenue", "100", new int[]{6, 30, 90, 270, 400, 550}, 50);
        board[9] = new RealEstate("Connecticut Avenue", "120", new int[]{8, 40, 100, 300, 450, 600}, 60);
        board[10] = new Property("Jail", "0", false);
        board[11] = new RealEstate("St. Charles Place", "140", new int[]{10, 50, 150, 450, 625, 750}, 70);
        board[12] = new Property("Electric Company", "150", true);
        board[13] = new RealEstate("States Avenue", "140", new int[]{10, 50, 150, 450, 625, 750}, 70);
        board[14] = new RealEstate("Virginia Avenue", "160", new int[]{12, 60, 180, 500, 700, 900}, 80);
        board[15] = new Property("Pennsylvania Railroad", "200", true);
        board[16] = new RealEstate("St. James Place", "180", new int[]{14, 70, 200, 550, 750, 950}, 90);
        board[17] = new Property("Community Chest", "0", false);
        board[18] = new RealEstate("Tennessee Avenue", "180",  new int[]{14, 70, 200, 550, 750, 950}, 90);
        board[19] = new RealEstate("New York Avenue", "200", new int[]{16, 80, 220, 600, 800, 1000}, 100);
        board[20] = new Property("Free Parking", "0", false);
        board[21] = new RealEstate("Kentucky Avenue", "220", new int[]{18, 90, 250, 700, 875, 1050}, 110);
        board[22] = new Property("Chance", "0", false);
        board[23] = new RealEstate("Indiana Avenue", "220", new int[]{18, 90, 250, 700, 875, 1050}, 110);
        board[24] = new RealEstate("Illinois Avenue", "240", new int[]{20, 100, 300, 750, 925, 1100}, 120);
        board[25] = new Property("B&O Railroad", "200", true);
        board[26] = new RealEstate("Atlantic Avenue", "260", new int[]{22, 110, 330, 800, 975, 1150}, 130);
        board[27] = new RealEstate("Ventnor Avenue", "260", new int[]{22, 110, 330, 800, 975, 1150}, 130);
        board[28] = new Property("Water Works", "150", true);
        board[29] = new RealEstate("Marvin Gardens", "280", new int[]{24, 120, 360, 850, 1025, 1200}, 140);
        board[30] = new Property("Go to Jail", "0", false);
        board[31] = new RealEstate("Pacific Avenue", "300", new int[]{26, 130, 390, 900, 1100, 1275}, 150);    
        board[32] = new RealEstate("North Carolina Avenue", "300", new int[]{26, 130, 390, 900, 1100, 1275}, 150);
        board[33] = new Property("Community Chest", "0", false);
        board[34] = new RealEstate("Pennsylvania Avenue", "320", new int[]{28, 150, 450, 1000, 1200, 1400}, 160);
        board[35] = new Property("Short Line Railroad", "200", true);
        board[36] = new Property("Chance", "0", false);
        board[37] = new RealEstate("Park Place", "350", new int[]{35, 175, 500, 1100, 1300, 1500}, 175);
        board[38] = new Property("Luxury Tax", "0", false);
        board[39] = new RealEstate("Boardwalk", "400", new int[]{50, 200, 600, 1400, 1700, 2000}, 200);
    }

    public Property getProperty(int index) {
        return board[index];
    }
    
}
