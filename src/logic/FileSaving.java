package logic;

import java.io.*;
/**
 * 2019-03-10 (Edited on 2019-03-19)
 * Authors: 
 * FileSaving Class allows the user to save the current status of the game and to continue from where they left off.
 */

public class FileSaving extends Player implements Serializable {


    /**
     *loads the file of type player which contains all the player instances
     * @return player
     */
    public Player loadFile() {

        try {
            InputStream in = new FileInputStream(new File("src/saves/playerSave.txt"));
            ObjectInputStream inObject = new ObjectInputStream(in);
            Player player = (Player) inObject.readObject();
            in.close();
            inObject.close();
            return player;
        }
        catch (Exception e) {
            try {
                InputStream in = new FileInputStream(new File("saves/playerSave.txt"));
                ObjectInputStream inObject = new ObjectInputStream(in);
                Player player = (Player) inObject.readObject();
                in.close();
                inObject.close();
                return player;
            }
            catch(Exception e2){
                return null;
            }
        }
    }

    /**
     * Saves the file of type player which contains all the player instances
     * @param player The player object being saved
     */
    public boolean saveFile(Player player){
        try{
            FileOutputStream out = new FileOutputStream(new File("src/saves/playerSave.txt"));
            ObjectOutputStream outObject = new ObjectOutputStream(out);
            outObject.writeObject(player);

            out.close();
            outObject.close();

            //returns true if program can save file
            return true;
        }
        catch (Exception e) {
            try {
                FileOutputStream out = new FileOutputStream(new File("saves/playerSave.txt"));
                ObjectOutputStream outObject = new ObjectOutputStream(out);
                outObject.writeObject(player);

                out.close();
                outObject.close();
                return true;
            }
            catch(Exception e2){
                return false;
            }
        }
    }
}
