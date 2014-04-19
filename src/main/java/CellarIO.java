import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * This class is used for general IO of the cellar and .cellar file
 */
public class CellarIO {
    public static CellarIO instance = new CellarIO();
    private String[] listOfCellars;


    public static CellarIO getInstance() {
        return instance;
    }

    public String[] getListOfCellars() {
        return listOfCellars;
    }


    public String[] checkForCellars() {
        File cellar = new File( "Cellars" );
        listOfCellars = cellar.list();
        if ( listOfCellars.length > 0 ) {

            return listOfCellars;
        } else return null;


    }

    private void deserialize( String cellarName ) {
        try {
            File cellarFile = new File( "Cellars/" + cellarName );
            FileInputStream inputStream = new FileInputStream( cellarFile );
            ObjectInputStream ois = new ObjectInputStream( inputStream );
            CellarContent cellarFromFile = ( CellarContent ) ois.readObject();
            ois.close();

        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
    }
}