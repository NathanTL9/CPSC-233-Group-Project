import java.io.*;

public class FileSaving extends Player {
    InputStream in = null;
    BufferedReader reader = null;
    OutputStream out = null;

    public Boolean loadFile() {
        try {
            in = new FileInputStream("src/saves/playerSave.txt");
            reader = new BufferedReader(new InputStreamReader(in));

            //Returns true if there is a save file
            return true;
        }
        catch (Exception e){
            //returns false if there isn't a save file
            return false;
        }
    }

    public void saveFile(){
        try{
            out = new FileOutputStream("src/saves/playerSave.txt");
        }
        catch (Exception e){

        }

    }


}
