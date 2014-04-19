import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class holds an arraylist of WineBrand objects
 * @see WineBrand
 * @author Alex Graha.
 *
 */
public class CellarContent implements Serializable {
    public static CellarContent currentCellar = new CellarContent();
    private String CellarName;
    ArrayList<WineBrand> contents;

    public static CellarContent getCurrentCellar() {
        return currentCellar;
    }

    public String getCellarName() {
        return CellarName;
    }

    public void setCellarName( String cellarName ) {
        CellarName = cellarName;
    }

    public ArrayList<WineBrand> getContents() {
        return contents;
    }

    public void setContents( ArrayList<WineBrand> contents ) {
        this.contents = contents;
    }

    public void addWine (WineBrand newWine){
            this.contents.add( newWine );
    }


}
