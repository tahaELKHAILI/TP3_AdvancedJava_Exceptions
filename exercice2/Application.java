import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Exceptions.CompteInexistantException;
import Exceptions.FondsInsuffisantsException;
import Exceptions.IllegalValueException;


public class Application {
    
    public static void main(String[] args) {

        ArrayList<CompteBancaire> Comptes = new ArrayList<>();
        int choix = 0;
        Scanner keyboard = new Scanner(System.in);

        InitialiseComptes(Comptes);

        do{
            
            choix = Menu(keyboard);

            switch (choix) {
                case 1:
                    AjouterCompte(keyboard, Comptes);
                    break;
                case 2:
                    SupprimerCompte(keyboard, Comptes);
                    break;
                case 3:
                    AfficherComptes(Comptes);
                    break;
                case 4:
                    OperationsCompte(keyboard, Comptes);
                    break;
                case 5:
                    System.out.println("Bye");
                    break;
            }

        }while(choix != 5);
    }

    public static void InitialiseComptes(ArrayList<CompteBancaire> Comptes){
        Comptes.add(new CompteBancaire(1111, 0, "John"));
        Comptes.add(new CompteBancaire(2222, 500, "Jane"));
        Comptes.add(new CompteBancaire(3333, 10000, "Barry"));
        Comptes.add(new CompteBancaire(4444, 100000, "Test"));
        Comptes.add(new CompteBancaire(5555, 200000, "Ahmed"));
    }

    public static int Menu(Scanner keyboard){
        System.out.println("===========Banque================");
            System.out.println("1.Ajouter compte");
            System.out.println("2.Supprimer compte");
            System.out.println("3.Afficher comptes");
            System.out.println("4.Opérations sur compte");
            System.out.println("5.Quitter");
            System.out.println("Choisi une opération à faire:");

            try {
                return keyboard.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Valeur illégal");
                return 0;
            }
    }

    public static void AfficherComptes(ArrayList<CompteBancaire> Comptes){
        System.out.println("===========Liste des comptes=====================");
        for(CompteBancaire c: Comptes)
            System.out.println(c);
    }

    public static void AjouterCompte(Scanner keyboard, ArrayList<CompteBancaire> Comptes){

        try {
            System.out.println("Entrer le numero de compte.");
            int numCompte = keyboard.nextInt();
            System.out.println("Entrer le solde du compte.");
            double solde = keyboard.nextDouble();
            System.out.println("Entrer le nom du titulaire.");
            String nomTitulaire = keyboard.next();
            CompteBancaire compte = new CompteBancaire(numCompte, solde, nomTitulaire);
            Comptes.add(compte);
        } catch (InputMismatchException e) {
            System.err.println("Valeur illégale");
            keyboard.next();
        }
    }

    public static int FindAccountIndex(int numeroDeCompte , ArrayList<CompteBancaire> Comptes)
    throws CompteInexistantException{
            
            for (int i = 0; i<Comptes.size(); i++){
                if(Comptes.get(i).getNumeroDeCompte() == numeroDeCompte)
                    return i;
            }
            throw new CompteInexistantException("Aucun compte avec le numero spécifier.");

    }

    public static CompteBancaire FindAccount(int numeroDeCompte, ArrayList<CompteBancaire> Comptes)
    throws CompteInexistantException{
            
            for (int i = 0; i<Comptes.size(); i++){
                if(Comptes.get(i).getNumeroDeCompte() == numeroDeCompte)
                    return Comptes.get(i);
            }
            throw new CompteInexistantException("Aucun compte avec le numero spécifier.");

    }

    public static void SupprimerCompte(Scanner keyboard , ArrayList<CompteBancaire> Comptes){
        System.out.println("Entrer le numéro de compte à suprimer.");
        try {
            int numeroDeCompte = keyboard.nextInt();
            int id = FindAccountIndex(numeroDeCompte, Comptes);
            Comptes.remove(id);
            System.out.println("Compte suprimer avec succés.");
        } catch (InputMismatchException e) {
            System.err.println("Entrer un numero de compte valide.");
            keyboard.next();
        } catch (CompteInexistantException e){
            System.err.println(e.getMessage());
        }
    }

    public static void OperationsCompte(Scanner keyboard, ArrayList<CompteBancaire> Comptes){
        
        System.out.println("Entrer le numéro de compte, pour effectuer une opération");
        try {
            int numeroDeCompte = keyboard.nextInt();
            int id = FindAccountIndex(numeroDeCompte, Comptes);

            System.out.println("=========Opération Compte==============");
            System.out.println("1. Retrait");
            System.out.println("2. Dépot");
            System.out.println("3. Transfert");
            System.out.println("4. Quitter");
            System.out.println("Choisi une operation à faire.");
            int choix = keyboard.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("Entrer le montant du retrait.");
                    double retrait = keyboard.nextDouble();
                    Comptes.get(id).RetraitArgent(retrait);
                    System.out.println("Retrait avec succés. Nouveau solde est "+Comptes.get(id).getSolde());
                    break;
                case 2:
                    System.out.println("Entrer le montant du dépot");
                    double depot = keyboard.nextDouble();
                    Comptes.get(id).DepotArgent(depot);
                    System.out.println("Dépot avec succés. Nouveau solde est "+Comptes.get(id).getSolde());
                    break;
                case 3:
                    System.out.println("Entrer le numero de compte du récipient");
                    int recipient = keyboard.nextInt();

                    System.out.println("Entrer le montant.");
                    double transfert = keyboard.nextDouble();

                    Comptes.get(id).TransfertArgent(FindAccount(recipient, Comptes), transfert);

                    System.out.println("Transfert avec succés.");
                    break;
                case 4:
                    System.out.println("Bye");
                    break;
            }

        } catch (InputMismatchException e) {
            System.err.println("Entrer un numero de compte valide.");
            keyboard.next();
        } catch (CompteInexistantException e){
            System.err.println(e.getMessage());
        } catch (FondsInsuffisantsException e){
            System.err.println(e.getMessage());
        } catch (IllegalValueException e){
            System.err.println(e.getMessage());
        }
    }
}
