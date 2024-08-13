package example;

import org.mindrot.jbcrypt.BCrypt;

public class Hashing {
    static String generateBcrypt(String input) {
        return BCrypt.hashpw(input, BCrypt.gensalt(12));
    }
}