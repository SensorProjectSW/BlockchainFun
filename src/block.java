import java.sql.Timestamp;
public class block {
    private String data;
    private int next_ID;
    private block next_block;
    private int own_ID;
    private Timestamp time;
    private int prev_ID;
    private block prev_block;

    //constructor
    public block(String data) {
        this.data = data;
        next_ID = -1;
        next_block = null;
        time = new Timestamp(System.currentTimeMillis());
        prev_ID = -1;
        prev_block = null;
    }

    //getter and setter
    protected void setOwn_ID(int own_ID) {
        this.own_ID = own_ID;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public int getNext_ID() {
        return next_ID;
    }
    public int getOwn_ID() {
        return own_ID;
    }
    public Timestamp getTime() {
        return time;
    }
    public block getNext_block() {
        return next_block;
    }
    public void setNext_block(block next) {
        this.next_block = next;
        setNext_ID(next.getOwn_ID());
    }
    private void setNext_ID(int next_ID) {
        this.next_ID = next_ID;
    }
    public int getPrev_ID() {
        return prev_ID;
    }
    public block getPrev_block() {
        return prev_block;
    }

    public void setPrev_block(block prev) {
        this.prev_block = prev;
        setPrev_ID(prev.getOwn_ID());
    }
    private void setPrev_ID(int prev_ID) {
        this.prev_ID = prev_ID;
    }

    public String toString() {
        return "Block " + getOwn_ID() + " with following data: \"" + getData() + "\" from " + getTime();
    }
}
