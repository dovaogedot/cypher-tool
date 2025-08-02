public class Rot13 {

    // See meetod võtab sisendina suvalise teksti (String) ja tagastab ROT13-ga krüpteeritud teksti.
    public static String encrypt(String text) {
        String result = ""; // Siia kogume krüpteeritud tulemuse.

        // Käime tsükliga iga tähemärgi tekstis läbi.
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i); // Võtame i-nda tähe.

            // Kontrollime, kas märk on VÄIKETÄHT (a-z)
            if (character >= 'a' && character <= 'z') {
                // Siin arvuti mõtleb:
                // "Võtan selle tähe positsiooni a-tähest (ehk character - 'a')"
                // "Lisan 13 kohta edasi" (ROT13 reegel)
                // "Kui jõuan üle z, siis kasutan %26, et keerata ringi algusesse"
                // "Lõpuks lisan selle positsiooni uuesti a juurde, et saada õige täht"
                character = (char) ((character - 'a' + 13) % 26 + 'a');
                // Näide: 'b' → (('b' - 'a' + 13) % 26 + 'a') → 'o'

            // Kui märk on SUURTÄHT (A-Z)
            } else if (character >= 'A' && character <= 'Z') {
                // Sama loogika, ainult A-tähega
                character = (char) ((character - 'A' + 13) % 26 + 'A');
                // Näide: 'G' → (('G' - 'A' + 13) % 26 + 'A') → 'T'

            // Kui märk EI OLE täht (ehk on number, tühik, koma, täpitäht jne)
            }
            // (Siin EI PEA midagi muutma – character jääb täpselt samaks)

            // Lisame selle tähemärgi tulemuse lõppu.
            result += character;
        }

        // Kui kõik tähemärgid on käidud, tagastame tulemuse.
        return result;
    }

    // See meetod aitab testida, kuidas meie ROT13 töötab.
    public static void main(String[] args) {
        String encrypted = Rot13.encrypt("Hello, World!"); // krüpteerib ainult ladina tähed
        System.out.println(encrypted); // Prindib: Uryyb, Jbeyq!

        String test = Rot13.encrypt("Päike paistab"); // Eesti tähed jäävad muutmata
        System.out.println(test); // Prindib: Pävxrx cnvfgnob
    }
}
