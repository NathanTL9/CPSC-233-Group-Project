import java.io.*;

public class FileSaving extends Player implements Serializable {

    public Player loadFile() {
        try {
            InputStream in = new FileInputStream(new File("src/saves/playerSave.txt"));
            ObjectInputStream inObject = new ObjectInputStream(in);
            Player player = (Player) inObject.readObject();
            System.out.println(getPlayer().getName());
            in.close();
            inObject.close();
            return player;
        }
        catch (Exception e) {
            return null;
        }
    }

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
            return false;
        }
    }


}
