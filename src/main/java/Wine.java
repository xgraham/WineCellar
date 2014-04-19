/**
 * This class encapsulates a particular type of wine held within a cellar
 * @author Alex Graham
 */
// winery, vintage, price, color, number)

public class Wine {
    private String wineName;
    private String vintage;
    private String note;
    private int count;
    private Color color;

    public Wine( String wineName ) {

        this.wineName = wineName;
        this.vintage="Not Set";
        this.note = "";
        this.color = Color.UNKNOWN;
        this.count = 0;
    }

    public String getNote() {
        return note;
    }

    public void setNote( String note ) {
        this.note = note;
    }

    public String getColor() {
        if ( this.color == Color.RED ) return "red";
        else if ( this.color == Color.WHITE ) return "white";
        else if ( this.color == Color.YELLOW ) return "yellow";
        else return "unknown";
    }

    public void setColor( Color color ) {
        this.color = color;
    }

    public void setColor( String color ) {
        if ( color.equalsIgnoreCase( "white" ) ) this.color = Color.WHITE;
        if ( color.equalsIgnoreCase( "red" ) ) this.color = Color.RED;
        if ( color.equalsIgnoreCase( "yellow" ) ) this.color = Color.YELLOW;
        else this.color = Color.UNKNOWN;
    }

    public String getVintage() {
        return vintage;
    }

    public void setVintage( String vintage ) {
        this.vintage = vintage;
    }

    public int getCount() {
        return count;
    }

    public void setCount( int count ) {
        this.count = count;
    }

    public String getWineName() {
        return wineName;
    }

    public void setWineName( String wineName ) {
        this.wineName = wineName;
    }

    public enum Color {YELLOW, RED, WHITE, UNKNOWN}

}

