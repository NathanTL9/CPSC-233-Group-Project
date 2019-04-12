package logic;

public class WarehouseLogic extends Player {

    /**
     * constructor; only runs when a Player object is provided. The constructor is fully encapsulated.
     *
     * @param player is a Player object that will be copied and the player instance variable is set to the copy.
     */
    public WarehouseLogic(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    /**
    * Method that transfers your cargo from your ship to your warehouse.
    * Has error handling to prevent incorrect inputs
    * @return returns the string which is to be said to the player
    */
    public String deposit(String str, int goodsNum) {
        try {
            int deposit = Integer.parseInt(str);
            if(deposit <= 0){
                return "Please enter a valid value";
            }
            //Transfers General amount
            else if(goodsNum == 1 && deposit <= getGeneralHeld()){
                setGeneralHeld(getPlayer().getGeneralHeld()-deposit);
                setwGeneral(getPlayer().getwGeneral()+deposit);
                return "Successful deposit";
            }
            //Transfers Arms amount
            else if(goodsNum == 2 && deposit <= getArmsHeld()){
                setArmsHeld(getPlayer().getArmsHeld()-deposit);
                setwArms(getPlayer().getwArms()+deposit);
                return "Successful deposit";
            }
            //Transfers Silk amount
            else if(goodsNum == 3 && deposit <= getSilkHeld()){
                setSilkHeld(getPlayer().getSilkHeld()-deposit);
                setwSilk(getPlayer().getwSilk()+deposit);
                return "Successful deposit";
            }
            //Transfers Opium amount
            else if(goodsNum == 4 && deposit <= getOpiumHeld()){
                setOpiumHeld(getPlayer().getOpiumHeld()-deposit);
                setwOpium(getPlayer().getwOpium()+deposit);
                return "Successful deposit";
            }
            //Checks if the correct value is entered
            else{
                return "Please enter a valid value";
            }
        }
        catch (Exception e) {
            return "Please enter a valid value";
        }
    }

    /**
    * Method that transfers cargo from your warehouse onto your ship.
    * Has error handling to prevent incorrect inputs
    * @return returns the string which is to be said to the player
    */
    public String withdraw(String str, int goodsNum) {
        try {
            int withdraw = Integer.parseInt(str);
            if(withdraw <= 0){
                return "Please enter a valid value";
            }
            //Transfers general amount
            else if(goodsNum == 1 && withdraw <= getwGeneral()){
                setGeneralHeld(getPlayer().getGeneralHeld()+withdraw);
                setwGeneral(getPlayer().getwGeneral()-withdraw);
                return "Successful withdraw";
            }
            //Transfers Arms amount
            else if(goodsNum == 2 && withdraw <= getwArms()){
                setArmsHeld(getPlayer().getArmsHeld()+withdraw);
                setwArms(getPlayer().getwArms()-withdraw);
                return "Successful withdraw";
            }
            //Transfers Silk Amount
            else if(goodsNum == 3 && withdraw <= getwSilk()){
                setSilkHeld(getPlayer().getSilkHeld()+withdraw);
                setwSilk(getPlayer().getwSilk()-withdraw);
                return "Successful withdraw";
            }
            //Transfers Opium amount
            else if(goodsNum == 4 && withdraw <= getwOpium()) {
                setOpiumHeld(getPlayer().getOpiumHeld() + withdraw);
                setwOpium(getPlayer().getwOpium() - withdraw);
                return "Successful withdraw";
            }
            // Ensures a valid value is entered
            else{
                return "Please enter a valid value";
            }
        }
        catch (Exception e) {
            return "Please enter a valid value";
        }
    }
}
