public class OperationBancaire implements Comparable<OperationBancaire>{
    private final double montant;
    private final FrenchGregorianCalendar dateOperation;
    private final String libelle;

    public OperationBancaire(double montant, FrenchGregorianCalendar dateOperation, String libelle) {
        this.montant = montant;
        this.dateOperation = dateOperation;
        this.libelle = libelle;
    }

    public double getMontant() {
        return montant;
    }

    public FrenchGregorianCalendar getDateOperation() {
        return dateOperation;
    }

    public String getLibelle() {
        return libelle;
    }
    //c1 envoi de l'argent à c2
    public void virement (CompteBancaire c1,CompteBancaire c2,double montant) throws BancaireException{
        c1.retrait(montant,libelle, dateOperation);
        c2.depot(montant, dateOperation, libelle);
    }

    public String toString() {
        return "OperationBancaire{montant=" + montant + ", le "+ dateOperation + ", " + libelle + '}';
    }

    @Override
    public int compareTo(OperationBancaire o) {
        int c=o.dateOperation.compareTo(this.dateOperation);
        if (c==0) return o.libelle.compareTo(this.libelle);
        else return c;
    }
}
