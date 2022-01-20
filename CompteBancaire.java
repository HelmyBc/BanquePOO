import java.util.*;

public class CompteBancaire{
    int nbComptes = 0;
    double solde;
    final int numeroCompte;
    TreeSet<OperationBancaire> listeOperations;
    //code du compte sera pris dans l'ordre de l'instanciation
    CompteBancaire(double solde) {
        this.solde=solde;
        nbComptes += 1;
        numeroCompte = nbComptes;
        listeOperations = new TreeSet<>();
    }

    public String toString() {
        return "Compte n°" + numeroCompte + " " + " dispose de "+solde+ "Dinars.";
    }

    public String listeOperations(int n) {
        Iterator<OperationBancaire> i = listeOperations.iterator();
        int index = 0;
        String resultat = "";
        while (index < n && i.hasNext()) {
            resultat = resultat + i.next().toString() + "\n";
            index = index + 1;
        }
        return resultat;
    }
    
    public double depot(double montant,FrenchGregorianCalendar date,String libelle) {
        solde=solde+montant;
        listeOperations.add(new OperationBancaire(montant,date,libelle));
        return solde;}	

    public double retrait(double montant,String libelle, FrenchGregorianCalendar date) throws BancaireException {
        if (montant> solde) throw new BancaireException("Pas assez d'argent sur le compte");
            else solde=solde-montant;
            listeOperations.add(new OperationBancaire(-montant,date,libelle));
        return solde;
    }
}