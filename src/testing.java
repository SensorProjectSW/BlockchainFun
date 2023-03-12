public class testing {
    public static void main(String[] args) {
        block genesis = new block("This is the first block!");

        System.out.println(genesis);
        System.out.println("Next ID: " + genesis.getNext_ID());
    }
}
