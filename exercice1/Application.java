import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        int choice = 0;
        Scanner keyboard = new Scanner(System.in);

        EntierNaturel n1 = initialize(keyboard);

        do{
            System.out.println("=============================");
            System.out.println("1. modifier le nombre entier");
            System.out.println("2. Afficher le nombre entier");
            System.out.println("3. Decrementer l'entier");
            System.out.println("4. Quitter");

            try {
                choice = keyboard.nextInt();
            } catch (InputMismatchException e) {
                keyboard.nextLine();
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.println("Entrer la nouvelle valeur entier");
                        int value = keyboard.nextInt();
                        n1.setVal(value);
                    } catch (InputMismatchException e) {
                        System.err.println("Veuillez entrer un entier valide.");
                        keyboard.nextLine();
                    } catch (NombreNegatifException e) {
                        System.err.println(e.getMessage());
                        System.err.println(e.getCause());
                    }
                    break;
                case 2:
                    System.out.println("L'entier est: "+n1.getVal());
                    break;
                case 3:
                    try {
                        n1.decrementer();
                        System.out.println("La nouvelle valeur est: "+n1.getVal());
                    } catch (NombreNegatifException e) {
                        System.err.println(e.getMessage());
                        System.err.println(e.getCause());
                    }
                    break;
                case 4:
                    System.out.println("Bye.");
                    break;
                default:
                    System.err.println("Veuiller entrer un choix valide.");
                    break;
            }
        }while (choice != 4);
    }    

    //Initialisation de l'entier
    public static EntierNaturel initialize(Scanner keyboard) {
        while (true) {
            try {
                System.out.print("Entrer un entier : ");
                int input = keyboard.nextInt();

                EntierNaturel n = new EntierNaturel(input);
                System.out.println("Entier initialisé par la valeur : " + input);
                return n;

            } catch (InputMismatchException e) {
                System.err.println("Veuillez entrer un entier valide.");
                keyboard.nextLine();

            } catch (NombreNegatifException e) {
                System.err.println(e.getMessage());
                System.err.println(e.getCause());
            }
        }   
    }
}
