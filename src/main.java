public class main {

    private Player player = new Player();

    public Player getPlayer(){
        Player copy = new Player(player);
        return copy;
    }

    public void shop(TaipanShop shop){
        shop.setPlayer(player);
        shop.shop();
        player = shop.getPlayer();
    }

    public void peasantFleet(ShipWarfare warfare) throws Exception {
        warfare.setPlayer(player);
        warfare.peasantFleetAttack();
        player = warfare.getPlayer();
    }

    public static void main(String[] args) throws Exception {
        main main = new main();
        ShipWarfare littyWarfare = new ShipWarfare(main.getPlayer());
        TaipanShop littyShop = new TaipanShop(main.getPlayer());

        main.shop(littyShop);

        main.peasantFleet(littyWarfare);

        main.shop(littyShop);
    }
}
