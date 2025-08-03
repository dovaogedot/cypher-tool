public class Atbash{
    // Turn each letter into its opposite in the alphabet (A<->Z, a<->z).
   
    public static String encrypt(String text) {
        String result = ""; // Start with empty answer.
        // Look at each character one by one.
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i); // Take the current character.

           // If it's a big letter, flip it (A becomes Z, B becomes Y, ...).
            if (Character.isUpperCase(character)){
               character = (char) ('Z' - (character - 'A'));  
              // If it's a small letter, flip it too (a becomes z, b becomes y, ...).
            } else if (Character.isLowerCase (character)) {  
                 character = (char) ('z' - (character - 'a'));
            }

            
            // Add this new or same character to the answer.

            result = result + character;

        }
           // Give back the full changed text.
          return result;
        }
    
    public static void main(String[] args) {
        // Change the sentence using the mirror-letter trick.
        String encryptedMessage = Atbash.encrypt("The weather is nice");
        
        // Show the result on screen.
        System.out.println(encryptedMessage);
    }
}
