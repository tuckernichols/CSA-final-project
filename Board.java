public class Board {
    private Property[] board = new Property[40];

    public Board() {
        initBoard();
       
    }
    
    private void initBoard() {
        board[0] = new Property("Go", "0", false);
        board[1] = new Property("Mediterranean Avenue", "60", true);
        board[2] = new Property("Community Chest", "0", false);
        board[3] = new Property("Baltic Avenue", "60", true);
        board[4] = new Property("Income Tax", "0", false);
        board[5] = new Property("Reading Railroad", "200", true);
        board[6] = new Property("Oriental Avenue", "100", true);
        board[7] = new Property("Chance", "0", false);
        board[8] = new Property("Vermont Avenue", "100", true);
        board[9] = new Property("Connecticut Avenue", "120", true);
        board[10] = new Property("Jail", "0", false);
        board[11] = new Property("St. Charles Place", "140", true);
        board[12] = new Property("Electric Company", "150", true);
        board[13] = new Property("States Avenue", "140", true);
        board[14] = new Property("Virginia Avenue", "160", true);
        board[15] = new Property("Pennsylvania Railroad", "200", true);
        board[16] = new Property("St. James Place", "180", true);
        board[17] = new Property("Community Chest", "0", false);
        board[18] = new Property("Tennessee Avenue", "180", true);
        board[19] = new Property("New York Avenue", "200", true);
        board[20] = new Property("Free Parking", "0", false);
        board[21] = new Property("Kentucky Avenue", "220", true);
        board[22] = new Property("Chance", "0", false);
        board[23] = new Property("Indiana Avenue", "220", true);
        board[24] = new Property("Illinois Avenue", "240", true);
        board[25] = new Property("B&O Railroad", "200", true);
        board[26] = new Property("Atlantic Avenue", "260", true);
        board[27] = new Property("Ventnor Avenue", "260", true);
        board[28] = new Property("Water Works", "150", true);
        board[29] = new Property("Marvin Gardens", "280", true);
        board[30] = new Property("Go to Jail", "0", false);
        board[31] = new Property("Pacific Avenue", "300", true);    
        board[32] = new Property("North Carolina Avenue", "300", true);
        board[33] = new Property("Community Chest", "0", false);
        board[34] = new Property("Pennsylvania Avenue", "320", true);
        board[35] = new Property("Short Line Railroad", "200", true);
        board[36] = new Property("Chance", "0", false);
        board[37] = new Property("Park Place", "350", true);
        board[38] = new Property("Luxury Tax", "0", false);
        board[39] = new Property("Boardwalk", "400", true);
    }

    public Property getProperty(int index) {
        return board[index];
    }
    
}
