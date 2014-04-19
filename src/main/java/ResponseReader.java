import java.util.Scanner;

/**
 * This class handles user input
 */
public class ResponseReader {
    public static ResponseReader instance = new ResponseReader();
    private Scanner sc;

    public static ResponseReader getInstance() {
        return instance;
    }

    public void setup() {
        sc = new Scanner( System.in );
    }

    public boolean readYesNo() {
        String response = sc.next();
        if ( response.equalsIgnoreCase( "Yes" ) || response.equalsIgnoreCase( "y" ) )
            return true;
        else return false;

    }

    public void readCellarName() {
        CellarContent cellar = CellarContent.getCurrentCellar();
        String cellarName = "";
        while ( cellarName.length() <= 0 ) {
            cellarName = sc.next();
        }
        cellar.setCellarName( cellarName );

    }


    public int readValue() {
        int result = -1;
        while ( result <= -1 ) {
            result = sc.nextInt();

        }
        return result;

    }

    public String readString() {
       return sc.next();
    }
}
