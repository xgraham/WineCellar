import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class holds an arraylist of Wine objects
 * @see Wine
 * @author Alex Graha.
 *
 */
public class CellarContent implements Serializable {
    public static CellarContent currentCellar = new CellarContent();
    private String CellarName;
    ArrayList<Wine> contents;

    public static CellarContent getCurrentCellar() {
        return currentCellar;
    }

    public String getCellarName() {
        return CellarName;
    }

    public void setCellarName( String cellarName ) {
        CellarName = cellarName;
    }

    public ArrayList<Wine> getContents() {
        return contents;
    }

    public void setContents( ArrayList<Wine> contents ) {
        this.contents = contents;
    }

    public void addWine ( Wine newWine){
            this.contents.add( newWine );
    }


}
