public class main {

    private Player player = new Player();

    /**
    * getter method for the Player object player.
    *
    * @return returns a copy of the object player
    */
    
    public Player getPlayer(){
        Player copy = new Player(player);
        return copy;
    }

    /**
    * Initializes the Taipan shop with the players stats after the player finishes shopping, it updates the player object and returns it.
    *
    * @param shop player object from the main class used to update the shop class
    */
    
    public void shop(TaipanShop shop){
        shop.setPlayer(player);
        shop.shop();
        player = shop.getPlayer();
    }

    /**
    * Initializes the player object with 5 guns or $400 and $5000 debt.
    *
    * @param start player object from the main class used to update the start class
    */
    
    public void start(Start start){
        start.setPlayer(player);
        start.initialize();
        player = start.getPlayer();
    }

    /**
    * Updates main class with player data and starts the game.
    * The game will only run as long as the player has not retired or has been destroyed.
    *
    */
    
    public static void main(String[] args) {
        main main = new main();
        TaipanShop littyShop = new TaipanShop(main.getPlayer());
        Start start = new Start(main.getPlayer());
        
        main.start(start);
        while(!main.getPlayer().getRetire()){
            main.shop(littyShop); 
        }
    }
}
