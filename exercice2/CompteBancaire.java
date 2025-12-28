import Exceptions.CompteInexistantException;
import Exceptions.FondsInsuffisantsException;
import Exceptions.IllegalValueException;

public class CompteBancaire {
    
    private int numeroDeCompte;
    private double solde;
    private String nomDuTitulaire;

    //Constructor
    public CompteBancaire(int numeroDeCompte, double solde, String nomDuTitulaire){
        this.numeroDeCompte = numeroDeCompte;
        this.solde = solde;
        this.nomDuTitulaire = nomDuTitulaire;
    }

    //Getters
    public String getNomDuTitulaire() {
        return nomDuTitulaire;
    }
    public int getNumeroDeCompte() {
        return numeroDeCompte;
    }
    public double getSolde() {
        return solde;
    }
    //Setter
    public void setNomDuTitulaire(String nomDuTitulaire) {
        this.nomDuTitulaire = nomDuTitulaire;
    }
    public void setNumeroDeCompte(int numeroDeCompte) {
        this.numeroDeCompte = numeroDeCompte;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }


    //méthode du compte

    public void DepotArgent(double depot) throws IllegalValueException{
        if(depot <= 0)
            throw new IllegalValueException("La valeur de dépot ne peut pas être égale ou inférieur a 0");

        solde += depot;
    }

    public void AfficherSolde(){
        System.out.println("Le solde du compte numéro "+numeroDeCompte+" de "+ nomDuTitulaire+" est "+solde);
    }

    public void RetraitArgent(double montant) throws FondsInsuffisantsException{
        if (montant > solde)
            throw new FondsInsuffisantsException("Fonds insuffisants");

        solde -= montant;
    }

    public void TransfertArgent(CompteBancaire destinataire, double montant) 
            throws CompteInexistantException, FondsInsuffisantsException, IllegalValueException{
        if(destinataire == null)
            throw new CompteInexistantException("Destinataire n'existe pas.");

        this.RetraitArgent(montant);
        destinataire.DepotArgent(montant);

    }

    @Override
    public String toString() {
        return "Numero de compte: "+numeroDeCompte+" | Nom du titulair: "+nomDuTitulaire+" | Solde: "+solde;
    }
}
