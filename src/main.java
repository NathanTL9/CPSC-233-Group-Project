public class main {

    private static Player player = new Player();

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
        ShipWarfare littyWarfare = new ShipWarfare(player);
        TaipanShop littyShop = new TaipanShop(player);

        main.shop(littyShop);

        main.peasantFleet(littyWarfare);

        main.shop(littyShop);
    }
}
