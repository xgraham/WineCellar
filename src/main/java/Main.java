/**
 * Main class for running the java program
 */
public class Main {
    public static void main( String[] args ) {

        CellarIO reader = CellarIO.getInstance();
        ResponseReader response = ResponseReader.getInstance();
        response.setup();
        reader.checkForCellars();

        System.out.println( "Would you like to create a new Cellar?" );
        if ( response.readYesNo() ) {
            System.out.println( "What would you like to name it?" );
            response.readCellarName();
        }
        else{

        }
        Menu menu = new Menu();
        menu.launch();


    }
}
