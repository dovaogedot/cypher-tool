public class Other {

    private static boolean isEnglishLetter(char character) {
        return (character >= 'a' && character <= 'z')
            || (character >= 'A' && character <= 'Z');
    }

    public static String encrypt(String text) {
        String result = "";
        
        String vowels = "aeiou";
        String consonants = "bcdfghjklmnpqrstvwxyz";


        for (int i = 0; i < text.length(); i++) {
            // current character in the string
            char character = text.charAt(i);

            // this will hold encrypted character
            char newCharacter;

            // if the character is not a letter, skip it
            if (!isEnglishLetter(character)) {
                result += character;
                continue;
            }

            // find the position of this character in "aeiou" string  
            int vowelIndex = vowels.indexOf(Character.toLowerCase(character));

            // if it is a vowel
            if (vowelIndex != -1) {

                // if it is 'a', make it 'u'
                if (vowelIndex == 0)
                    vowelIndex = vowels.length() - 1;
                // otherwise make it the one before
                else
                    vowelIndex = vowelIndex - 1;

                // if the character was uppercase, make the character from vowels also uppercase
                newCharacter = vowels.charAt(vowelIndex);


            // if it is a consonant
            } else {
                // get it's position
                int index = consonants.indexOf(Character.toLowerCase(character));

                // make it the next one, also make sure to wrap around if it's the last one ('z')
                index = (index + 1) % consonants.length();

                newCharacter = consonants.charAt(index);
            }


            // if the character was uppercase, make the character from vowels also uppercase
            if (Character.isUpperCase(character))
                newCharacter = Character.toUpperCase(newCharacter);

            // add modified character to the result
            result = result + newCharacter;
        }

        return result;
    }

    public static String decrypt(String text) {
        String result = "";
        
        String vowels = "aeiou";
        String consonants = "bcdfghjklmnpqrstvwxyz";


        for (int i = 0; i < text.length(); i++) {
            // current character in the string
            char character = text.charAt(i);

            // this will hold encrypted character
            char newCharacter;

            // if the character is not a letter, skip it
            if (!isEnglishLetter(character)) {
                result += character;
                continue;
            }

            // find the position of this character in "aeiou" string  
            int vowelIndex = vowels.indexOf(Character.toLowerCase(character));

            // if it is a vowel
            if (vowelIndex != -1) {

                // make it the next one, also make sure to wrap around if it's the last one ('u')
                vowelIndex = (vowelIndex + 1) % vowels.length();

                newCharacter = vowels.charAt(vowelIndex);


            // if it is a consonant
            } else {
                // get it's position
                int index = consonants.indexOf(Character.toLowerCase(character));

                // if it is 'b', make it 'z'
                if (index == 0)
                    index = consonants.length() - 1;
                // otherwise make it the one before
                else
                    index = index - 1;

                newCharacter = consonants.charAt(index);
            }

            // if the character was uppercase, make the character from vowels also uppercase
            if (Character.isUpperCase(character))
                newCharacter = Character.toUpperCase(newCharacter);

            // add modified character to the result
            result = result + newCharacter;
        }

        return result;
    }


    
    public static void main(String[] args) {
        String encryptedmessage = Other.encrypt("Päike paistab");
        System.out.println("Encrypted: " + encryptedmessage);

        String decryptedmessage = Other.decrypt(encryptedmessage);
        System.out.println("Encrypted: " + decryptedmessage);
    }
}