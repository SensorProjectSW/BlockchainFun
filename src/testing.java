public class testing {
    public static void main(String[] args) {
        block genesis = new block("first block!");

        System.out.println(genesis);
        System.out.println("Next ID: " + genesis.getNext_ID());
        System.out.println();

        chain blockchain = new chain(genesis);

        blockchain.append("second block");
        blockchain.append("third block");

        System.out.println(blockchain);

        blockchain.getAllData();
    }
}
