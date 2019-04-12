package logic;

import java.io.*;
/**
 * 2019-03-10 (Edited on 2019-03-19)
 * Authors: Harkamal Randhawa
 * FileSaving Class allows the user to save the current status of the game and to continue from where they left off.
 */

public class FileSaving extends Player implements Serializable {

    /**
     * loads the file of type player which contains all the player instances
     * @return player
     */
    public Player loadFile() {
        try {
            //Load the previous save file
            InputStream in = new FileInputStream(new File("src/saves/playerSave.txt"));
            return getPlayer(in);
        }
        catch (Exception e) {
            try {
                //Loads the player save in a alternate location if the original location isn't available
                InputStream in = new FileInputStream(new File("saves/playerSave.txt"));
                return getPlayer(in);
            }
            catch(Exception e2){
                //Only it's impossible for the player to load a file
                return null;
            }
        }
    }

    /**
     * Only run inside this class, returns save files. Throws exceptions if it fails
     * @param in The input stream from the previous save(If there is one)
     * @return Returns the player object from the previous save file
     * @throws IOException Only if the file cannot be read
     * @throws ClassNotFoundException Only if there is no file available for the player to load
     */
    private Player getPlayer(InputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream inObject = new ObjectInputStream(in);
        Player player = (Player) inObject.readObject();
        in.close();
        inObject.close();
        return player;
    }

    /**
     * Saves the file of type player which contains all the player instances
     * @param player The player object being saved
     */
    public boolean saveFile(Player player){
        try{
            //Saves the object to a file
            FileOutputStream out = new FileOutputStream(new File("src/saves/playerSave.txt"));
            ObjectOutputStream outObject = new ObjectOutputStream(out);
            outObject.writeObject(player);

            out.close();
            outObject.close();

            //returns true if program can save the file
            return true;
        }
        catch (Exception e) {
            try {
                //If the player is running from the terminal it changes the files location, this catch statement fixes that
                FileOutputStream out = new FileOutputStream(new File("saves/playerSave.txt"));
                ObjectOutputStream outObject = new ObjectOutputStream(out);
                outObject.writeObject(player);

                out.close();
                outObject.close();
                //returns true if the program can save the file
                return true;
            }
            catch(Exception e2){
                //returns false if it's impossible for the player to save the file
                return false;
            }
        }
    }
}
