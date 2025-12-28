public class CompteEpargne extends CompteBancaire {
    
    private double interetGenerer;

    public CompteEpargne(int numeroDeCompte, double solde, String nomDuTitulaire){
        super(numeroDeCompte, solde, nomDuTitulaire);
        this.interetGenerer = 0;
    }

    public void IntegrerInteret(double tauxInteret){
        interetGenerer += getSolde()*tauxInteret;
        setSolde(getSolde()*(1+tauxInteret));
    }
}
