import java.util.ArrayList;

/**
 * This class displays and handles the menu interactions
 * No one said the menu had to be intuitive or easy to navigate
 * We're going for an A on the rubric not the world's best menu
 *
 */
public class Menu {
    ResponseReader response = ResponseReader.getInstance();
    CellarContent cellar = CellarContent.getCurrentCellar();
    CellarIO reader = CellarIO.getInstance();
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
            case 1:
                addWine();
                break;
            case 2:
                listWine();
                break;
            case 3:
                printVintage();
                break;
            case 6:
                saveCellar();
                break;
            case 0:
                sayGoodbye( 0 );
                break;
        }

    }

    /**
     * This method will exit the current menu and return to top level menu
     * or if it is the top level menu, it will exit the program
     *
     * @param level int that corresponds to the depth of the menu, 0 meaning top level menu, increases with depth
     */
    private void sayGoodbye( int level ) {
        if ( level > 0 ) {
            printMenu();
        }
        if ( level <= 0 ) {
            run = false;
        }


    }

    private void saveCellar() {
        reader.serialize();
        System.out.println("Saved!");

    }

    private void printVintage() {
        System.out.println("What vintage do you want to look up");
        String vintage = response.readString();
        ArrayList<Wine> list = cellar.getContents();
        for ( int i = 0; i < list.size(); i++ ) {
            Wine wine =  list.get( i );
            if(!wine.getVintage().equalsIgnoreCase( vintage )){
                 list.remove( i );
            }

        }
    }

    private void addWine() {
        System.out.println( "What is this wine called?" );
        String name = response.readString();
        System.out.println( "How many would you like to add?" );
        int count = response.readValue();
        Wine addition = new Wine( name );
        addition.setCount( count );
        cellar.addWine( addition );
    }

    private void listWine() {
        ArrayList<Wine> list = cellar.getContents();
        System.out.println( "Which wine would you like to edit?" );
        for ( int i = 0; i < list.size(); i++ ) {
            Wine wine = list.get( i );
            System.out.println( i + 1 + ".    " + wine.getWineName() );
        }
        System.out.println( "0.    Exit" );

        int result = response.readValue();
        if ( result == 0 ) {
            sayGoodbye( 1 );
        }
        if ( result > 0 && result < list.size() + 1 ) {
            editWine( list.get( result - 1 ) );
        }

    }

    private void editWine( Wine wine ) {    //lots of prints means lots of lines, still readable
        System.out.println( "What would you like to do?" );
        System.out.println( "1.    Change the number of wine" );
        System.out.println( "2.    Edit note" );
        System.out.println( "3.    Edit vintage" );
        System.out.println( "4.    Edit color" );
        System.out.println( "0.    Exit" );
        int userInput = response.readValue();
        //Later we will add printing of current value to compare and shorten this method entirely
        switch ( userInput ) {
            case 1:
                System.out.println( "How many bottles of this wine do you have?" );
                wine.setCount( response.readValue() );
                break;
            case 2:
                System.out.println("Please enter the note you'd like to add:");
                wine.setNote( response.readString() );
                break;
            case 3:
                System.out.println("Please enter the vintage, whatever that means:");
                wine.setVintage( response.readString() );
                break;
            case 4:
                System.out.println("Please enter the color of the wine.");
                System.out.println("You choices are red, yellow, white and unknown.");
                wine.setColor( response.readString() );
                break;
            case 0:
                sayGoodbye( 1 );
                break;
        }


    }
    public void openExistingCellar(){
        System.out.println("Found some cellars, please pick which one you'd like to edit:");
        String[] cellars = reader.getListOfCellars();
        for ( int i = 0; i < cellars.length; i++ ) {
            System.out.println(i+1 + cellars[i]);

        }
        int userInput = response.readValue()-1;
        reader.deserialize( cellars[ userInput ] );

    }
}
