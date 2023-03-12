public class chain {
    private block genesis;
    public chain() {
        genesis = new block("This is the first block!");
    }
    public chain(block genesis) {
        this.genesis = genesis;
    }

    //TODO: append block to blockchain
    public void append(String data) {
        append(new block((data)));
    }

    private void append(block new_block) {

    }

    //TODO: browsing all records
    public String toString() {
        String output = "";
        /*while () {
            output += genesis.getOwn_ID();
        }*/
        return output;
    }

    //TODO: get last block of blockchain (helper function)
    private block getLastBlock() {

    }
}
