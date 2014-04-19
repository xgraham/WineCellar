/**
 * This class displays and handles the menu interactions
 */
public class Menu {
    ResponseReader response = ResponseReader.getInstance();
    CellarContent cellar = CellarContent.getCurrentCellar();
    private boolean run = true;


    public void launch() {
        while ( run ) {
            printMenu();
        }
    }

    private void printMenu() { //longer than 20 lines maybe, but we are going for readability with multiple SOUT and using switch/case
        System.out.println( "What would you like to do?" );
        System.out.println( "1.    Add type of wine to the cellar" );
        System.out.println( "2.    List all of the wines in the cellar to edit" );
        System.out.println( "3.    Print out all of the vines from a particular vintage." );
        System.out.println( "9.    Save the current cellar" );
        System.out.println( "0.    Exit" );
        int choice = response.readValue();
        switch ( choice ) {
            case 1: addWine();
                break;
            case 2: listWine();
                break;
            case 5: printVintage();
                break;
            case 6: saveCellar();
                break;
            case 0: sayGoodbye();
                break;
        }

    }

    private void printVintage() {
    }

    private void addWine() {
        System.out.println("What is this wine called?");
        String name = response.readString();
        System.out.println("How many would you like to add?");
        int count = response.readValue();
        WineBrand addition = new WineBrand( name );
        addition.setCount( count );
        cellar.addWine(addition);
    }
    private void listWine(){

    }
}
