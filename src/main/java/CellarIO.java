import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Created by Alex on 4/18/14.
 */
public class CellarIO {
    public static CellarIO instance = new CellarIO();

    public static CellarIO getInstance() {
        return instance;
    }

    public String[] checkForCellars() {
        File cellar = new File("Cellars");
        String[] listOfCellars = cellar.list();
        if(listOfCellars.length>0){
            return listOfCellars;
        }
        else return null;


    }

    private void deserialize(String cellarName) {
        try{
            File cellarFile = new File("Cellars/"+cellarName);
            FileInputStream inputStream = new FileInputStream(cellarFile);
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            CellarContent cellarFromFile = (CellarContent) ois.readObject();
            ois.close();

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}