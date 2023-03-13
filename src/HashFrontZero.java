import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class HashFrontZero {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(hash("Hallo"));
        System.out.println();
        System.out.println(AddRandInt("Hallo"));
        System.out.println(hash(AddRandInt("Hallo")));
    }

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

    public static String AddRandInt(String s) throws NoSuchAlgorithmException {
        int min = 0, max = Integer.MAX_VALUE-1;
        Random rand = new Random();
        while (true) {
            int randnum = rand.nextInt((max - min) +1 ) + min;
            if (hash(s+randnum).charAt(0) == '0') {
                s += randnum;
                break;
            }
        }
        return s;
    }
}
