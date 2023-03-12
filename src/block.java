import java.sql.Timestamp;
public class block {
    private String data;
    private int next_ID;
    private int own_ID;
    private int i = 0; //primary key for unique blocks
    private Timestamp time;

    //constructor
    public block(String data) {
        this.own_ID = ++i;
        this.data = data;
        next_ID = -1;
        time = new Timestamp(System.currentTimeMillis());
    }

    //getter and setter
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public int getNext_ID() {
        return next_ID;
    }
    public void setNext_ID(int next_ID) {
        this.next_ID = next_ID;
    }
    public int getOwn_ID() {
        return own_ID;
    }
    public Timestamp getTime() {
        return time;
    }

    public String toString() {
        return "Block " + getOwn_ID() + " with following data: \"" + getData() + "\" from " + getTime();
    }
}
