public class CompteEpargne extends CompteBancaire {
    double taux;
    CompteEpargne(double solde,double taux) {
        super(solde);
        this.taux=taux;
    }
    public double getTauxInterets() {
        return taux;
    }
    //le taux n'est pas en pourcentage il est entre 0 et 1
    public double calculInterets() {
        solde=solde+solde*taux;
        return solde;}

   
}
