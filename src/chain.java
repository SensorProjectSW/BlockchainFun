public class chain {
    private block genesis;
    private block last;
    public chain() {
        genesis = new block("This is the first block!");
    }
    public chain(block genesis) {
        genesis.setOwn_ID(0);
        this.genesis = genesis;
        last = genesis;
    }

    public void append(String data) {
        append(new block((data)));
    }

    private void append(block new_block) {
        new_block.setOwn_ID(last.getOwn_ID() + 1);
        last.setNext_block(new_block);
        new_block.setPrev_block(last);
        last = new_block;
    }

    public String toString() {
        block temp = genesis;
        String output = "IDs aller Blöcke: " + temp.getOwn_ID();
        while (temp.getNext_block() != null) {
            temp = temp.getNext_block();
            output += " " + temp.getOwn_ID();
        }
        return output;
    }

    public block getGenesis() {
        return genesis;
    }
    public block getLast() {
        return last;
    }

    public String getDataFromBlock(int datafromblock_id) {
        if (datafromblock_id > last.getOwn_ID()) return "ERROR: This block does not exist!";
        block temp = genesis;
        while (temp.getOwn_ID() != datafromblock_id) temp = temp.getNext_block();
        return temp.getData();
    }

    public void getAllData() {
        block temp = genesis;
        while (temp != null) {
            System.out.println("Data from block " + temp.getOwn_ID() + ": " + temp.getData());
            temp = temp.getNext_block();
        }
    }
}