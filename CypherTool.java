import java.util.Scanner;

public class CypherTool {
    public static void main(String[] args) {
        // greet the user
        System.out.println("\nWelcome to the Cypher Tool!");

        String operation = "";
        String cypher = "";

        // prompt the user to select operation until they provide a valid input 
        while (operation.equals("")) {
            // show options
            System.out.print("\n" +
            "Select operation:\n" +
            "1. Encrypt\n" +
            "2. Decrypt\n" + 
            "$> ");

            // wait for user input
            InputData inputData = getInput();
            
            // if user wants to exit, we exit
            if (inputData.isExit) {
                System.exit(0);
            }

            // assign corresponding operation based on the value entered by the user
            switch (inputData.text) {
                case "1":
                    operation = "Encrypt";
                    break;
            
                case "2":
                    operation = "Decrypt";
                    break;

                // if the user entered anything else aside from 1 or 2, explain to them what should they enter
                default:
                    System.out.println("\nPlease type number 1 to encrypt and 2 to decrypt.");

                    break;
            }
        }
        // prompt the user to select cypher until they provide a valid input 
        while (cypher == "") {
            // show options
            System.out.print("\n" +
            "Select cypher:\n" +
            "1. ROT13\n" +
            "2. Atbash\n" +
            "3. Other\n" + 
            "$> ");

            // wait for user input
            InputData inputData = getInput();
            
            // if user wants to exit, we exit
            if (inputData.isExit) {
                System.exit(0);
            }

            // assign corresponding cypher based on the value entered by the user
            switch (inputData.text) {
                case "1":
                    cypher = "ROT13";
                    break;
            
                case "2":
                    cypher = "Atbash";
                    break;

                case "3":
                    cypher = "Other";
                    break;

                // if the user entered anything else aside from 1, 2 or 3, explain to them what should they enter
                default:
                    System.out.println("\nPlease type a number from the list above.");
                    break;
            }
        }

        // ask the user to enter a message on which to perform selected operation
        System.out.print("\n" +
        "Enter the message:\n" +
        "$> ");

        // wait for their input
        String message = getInput().text;
        
        // the result of operation will be stored in this variable
        String result = "";
        
        // perform chosen operation with chosen cypher and store the result in variable above
        switch (cypher) {
            case "ROT13":
                if (operation.equals("Encrypt"))
                    result = encryptRot13(message);
                else
                    result = decryptRot13(message);
                break;

            case "Atbash":
                if (operation.equals("Encrypt"))
                    result = encryptAtbash(message);
                else
                    result = decryptAtbash(message);
                break;
        
            case "Other":
                if (operation.equals("Encrypt"))
                    result = encryptOther(message);
                else
                    result = decryptOther(message);
                break;
    
            default:
                break;
        }

        // show the result to the user
        System.out.println("\n" +
        operation + "ed message (" + cypher + "):\n" +
        result);
    }


    public static InputData getInput() {
        // prepare the data that we will return
        InputData inputData = new InputData();

        // create a scanner that will read user's input from the terminal
        Scanner scanner = new Scanner(System.in);

        // read the line that user enters and remove extra space in start and end
        String userInput = scanner.nextLine().trim();

        // check if the user wants to exit the program
        if (userInput == "exit") {
            inputData.isExit = true;
        }

        // store the user's input and return it
        inputData.text = userInput;

        return inputData;
    }

    public static String encryptRot13(String s) {
        return Rot13.encrypt(s);
    }

    public static String encryptAtbash(String s) {
        return Atbash.encrypt(s);
    }

    public static String encryptOther(String s) {
        return Other.encrypt(s);
    }

    public static String decryptRot13(String s) {
        return Rot13.encrypt(s);
    }

    public static String decryptAtbash(String s) {
        return Atbash.encrypt(s);
    }

    public static String decryptOther(String s) {
        return Other.decrypt(s);
    }
}
