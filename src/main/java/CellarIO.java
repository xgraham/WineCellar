import java.io.*;

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
        File cellars = new File( "Cellars" );
        listOfCellars = cellars.list();
        if ( listOfCellars.length > 0 ) {
            for ( int i = 0; i < listOfCellars.length; i++ ) {
                String fileName = listOfCellars[ i ];
                listOfCellars[ i ] = fileName.substring( 0, fileName.indexOf( '.' ) );

            }
            return listOfCellars;
        } else return null;


    }

    public void deserialize( String cellarName ) {
        try {
            File cellarFile = new File( "Cellars/" + cellarName + ".cellar" );
            FileInputStream inputStream = new FileInputStream( cellarFile );
            ObjectInputStream ois = new ObjectInputStream( inputStream );
            CellarContent cellarFromFile = ( CellarContent ) ois.readObject();
            ois.close();
            CellarContent cellar = CellarContent.getCurrentCellar();
            cellar = cellarFromFile;

        } catch ( Exception ex ) {
            ex.printStackTrace();
        }


    }

    public void serialize() {
        try {
            CellarContent cellar = CellarContent.currentCellar;
            FileOutputStream fileOutputStream = new FileOutputStream( "Cellar/" + cellar.getCellarName() + ".cellar" );
            ObjectOutputStream outputStream = new ObjectOutputStream( fileOutputStream );
            outputStream.writeObject( cellar );
            outputStream.close();
            System.out.println( "Done" );

        } catch ( Exception ex ) {
            ex.printStackTrace();
        }

    }
}