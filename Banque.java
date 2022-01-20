public class Banque {
    public static void main(String[] args) {
    CompteEpargne c1=new CompteEpargne(10000,0.2);
    c1.depot(500,new FrenchGregorianCalendar(),"économie");
    System.out.println(c1.listeOperations(10));
    CompteEpargne c2=new CompteEpargne(55000,10);
    CompteCourant c3=new CompteCourant(10000,2000);
    c2.depot(2500, new FrenchGregorianCalendar(), "1èr dépot");
    c2.depot(3000, new FrenchGregorianCalendar(), "2ème dépot");
    try{
        c2.retrait(3500, "1èr retrait", new FrenchGregorianCalendar());
    }
    catch (BancaireException e){
        System.out.println("Verifier les données entrées");
    }
    
    System.out.println(c2.listeOperations(10));
    c2.calculInterets();
    c3.depot(2300, new FrenchGregorianCalendar(),"1èr dépot");
    System.out.println(c3.listeOperations(10));
    }
    
}
