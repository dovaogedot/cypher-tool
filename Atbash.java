public class Atbash{
    public static String encrypt(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            // test
            // test

            result = result + character;

        }


         return result;
    } 
    public static void main(String[] args) {

        String encryptedMessage = Atbash.encrypt("The weather is nice");

        System.out.println(encryptedMessage);
    }
}