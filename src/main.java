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

    public void start(Start start){
        start.setPlayer(player);
        start.intialize();
        player = start.getPlayer();
    }

    public void warehouse(Warehouse warehouse){
        warehouse.setPlayer(player);
        //warehouse.intialize();
        player = warehouse.getPlayer();
    }

    public void bank(Bank bank){
        bank.setPlayer(player);
        //warehouse.intialize();
        player = bank.getPlayer();
    }

    public static void main(String[] args) throws Exception {
        main main = new main();
        TaipanShop littyShop = new TaipanShop(main.getPlayer());
        Start start = new Start(main.getPlayer());

        main.start(start);
        while(!main.getPlayer().getRetire()){
            main.shop(littyShop);
        }
    }
}
