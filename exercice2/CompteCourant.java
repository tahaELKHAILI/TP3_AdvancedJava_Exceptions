import Exceptions.FondsInsuffisantsException;

public class CompteCourant extends CompteBancaire{

    private double decouvertPermi;

    public CompteCourant(int numeroDeCompte, double solde, String nomDuTitulaire, double decouvertPermi){
        super(numeroDeCompte, solde, nomDuTitulaire);
        this.decouvertPermi = decouvertPermi;
    }

    @Override
    public void RetraitArgent(double montant) throws FondsInsuffisantsException {
        if (montant > decouvertPermi)
            throw new FondsInsuffisantsException("Fonds insuffisants");

        setSolde(getSolde()-montant);
    }
}