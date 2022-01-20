public class CompteCourant extends CompteBancaire{
    double decouvert;

    CompteCourant(double solde,double decouvert) {
        super(solde);
        this.decouvert=decouvert;
    }

    public double getDecouvert() {
        return decouvert;
    }

    @Override
    public double retrait(double montant,String libelle, FrenchGregorianCalendar date) throws BancaireException {
        if (montant> solde+decouvert) throw new BancaireException("Pas assez d'argent sur le compte");
            else solde=solde-montant;
        listeOperations.add(new OperationBancaire(montant,date,libelle));
        return solde;
    }

}
