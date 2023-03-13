import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class HashFrontZero {
    public static String hash(String s) throws NoSuchAlgorithmException {
        // getInstance() method is called with algorithm SHA-512
        MessageDigest md = MessageDigest.getInstance("SHA-512");

        // digest() method is called
        // to calculate message digest of the input string
        // returned as array of byte
        byte[] digest = md.digest(s.getBytes());

        // Convert byte array into signum representation
        BigInteger no = new BigInteger(1, digest);

        // Convert message digest into hex value
        String hash = no.toString(16);

        // Add preceding 0s to make it 512 bit
        while (hash.length() < 128) hash = "0" + hash;
        return hash;
    }

    private static String difficulty(int i) {
        String s = "" + 0;
        for (int j = 0; j < i-1; j++) {
            s += 0;
        }
        return s;
    }


    public static String AddRandInt(String s, int i) throws NoSuchAlgorithmException {
        int min = 0, max = Integer.MAX_VALUE-1;
        Random rand = new Random();
        String diff = difficulty(i);
        while (true) {
            int randnum = rand.nextInt((max - min) +1 ) + min;
            if (hash(s+randnum).substring(0,i).equals(diff)) {
                s += randnum;
                break;
            }
        }
        return s;
    }
}
