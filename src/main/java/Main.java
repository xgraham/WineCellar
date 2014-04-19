/**
 * Main class for running the java program
 */
public class Main {
    public static void main( String[] args ) {
        Menu menu = new Menu();

        CellarIO reader = CellarIO.getInstance();
        ResponseReader response = ResponseReader.getInstance();
        response.setup();

        System.out.println( "Would you like to create a new Cellar?" );
        if ( response.readYesNo() ) {
            System.out.println( "What would you like to name it?" );
            response.readCellarName();
            menu.launch();
        } else if (reader.checkForCellars()!=null){
            menu.openExistingCellar();


        }
        else{
            System.out.println("No cellars found! ");
            main(new String[0]);
        }


    }
}
