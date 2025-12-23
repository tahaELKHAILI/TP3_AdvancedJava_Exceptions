public class EntierNaturel {

    private int valeur;

    public EntierNaturel(int valeur) throws NombreNegatifException{
        if (valeur < 0)
            throw new NombreNegatifException("La valeur n'est pas un entier", new Throwable("Cause d'erreur: "+valeur));
        this.valeur = valeur;
    }

    public EntierNaturel(){

    }
    
    public int getVal(){
        return valeur;
    }

    public void setVal(int valeur) throws NombreNegatifException{
        if (valeur < 0)
            throw new NombreNegatifException("La valeur n'est pas un entier", new Throwable("Cause d'erreur: "+valeur));
        this.valeur = valeur;
    }

    public void decrementer() throws NombreNegatifException{
        if(valeur < 1)
            throw new NombreNegatifException("0 est le plus petit entier possible", new Throwable("Cause d'erreur: "+valeur));
        valeur--;
    }
}