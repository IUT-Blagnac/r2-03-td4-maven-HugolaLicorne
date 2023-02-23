package main;

import tps.banque.Compte;
import tps.banque.exception.CompteException;

public class ClasseEssaiCompte {
	public static void mainExo1(String[] argv) throws Exception {
		Compte cUn;
		String nbCompte;
		String nomProprio;
		double soldeC;

		System.out.println("Hello World");
		cUn = new Compte("010101", "Lepoisson Benoit");
		cUn.afficher();
		cUn.setProprietaire("Berdinel Hugo");

// 4) Après utilisation de la méthode afficher(), on voit dans la console le numéro de compte,
// le nom du propriétaire ainsi que le nombre de crédits, de débits et d'opération effectuées  

		nbCompte = cUn.getNumCompte();
		nomProprio = cUn.getProprietaire();
		soldeC = cUn.soldeCompte();

		System.out.println("Numéro de compte : " + nbCompte);
		System.out.println("Propriétaire : " + nomProprio);
		System.out.println("Solde actuel : " + soldeC);

		try {
			cUn.deposer(100);
			System.out.println("Solde actuel : " + cUn.soldeCompte());
		} catch (CompteException e) {
			System.out.println("Erreur : Le montant déposer doit être supérieur à 0");

		}

		try {
			cUn.retirer(100);
			System.out.println("Solde actuel : " + cUn.soldeCompte());
		} catch (CompteException e) {
			System.out.println("Erreur : Le montant retiré doit être supérieur ou égal à 0");
		}

		cUn.afficher();
		try {
			cUn.retirer(-100);
			System.out.println("Solde actuel : " + cUn.soldeCompte());
		} catch (CompteException e) {
			System.out.println("Erreur : Le montant retiré doit être supérieur ou égal à 0 ");
		}

// 7) Les 100 euros ne sont pas retirés, le main lève une exception (le montant retiré doit être supérieur ou égal à 0)

		try {
			cUn.deposer(-100);
			System.out.println("Solde actuel : " + cUn.soldeCompte());
		} catch (CompteException e) {
			System.out.println("Erreur : Le montant déposé doit être supérieur à 0");
		}

// 8) Le main lève une exception : le montant déposé doit être supérieur à 0

		System.out.println(cUn);

// 9) La méthode affiche le numéro de compte, le propriétaire, ect...

		cUn = null;

		System.out.println(System.identityHashCode(cUn));

// 10) L'instruction affiche le numéro de l'obet cUn

		cUn.afficher();

// 13) Le main lève une exception : la valeur null ayant été affectée au compte, la méthode cUn.afficher() n'accède pas 
// aux informations du compte

	}

	public static void mainExo2(String[] argv) throws Exception {
		Compte cUn;
		Compte cDeux;
		Compte cTrois;
		Compte cQuatre;

//		cUn.afficher();

// 1) L'IDE indique qu'on ne peut pas exécuter l'instruction car l'objet n'a pas été initialisé

		cUn = new Compte("010101", "Jean");
		cDeux = new Compte("020202", "Marie");

		cUn.afficher();
		cDeux.afficher();

		System.out.println(System.identityHashCode(cUn));
		System.out.println(System.identityHashCode(cDeux));

		try {
			cUn.deposer(1);
			System.out.println("Solde actuel : " + cUn.soldeCompte());
		} catch (CompteException e) {
			System.out.println(e);
		}

		try {
			cDeux.deposer(1000);
			System.out.println("Solde actuel : " + cDeux.soldeCompte());
		} catch (CompteException e) {
			System.out.println(e);
		}

		try {
			cUn.retirer(1);
			System.out.println("Solde actuel : " + cUn.soldeCompte());
		} catch (CompteException e) {
			System.out.println("Erreur : Le montant retiré doit être supérieur ou égal à 0");
		}

		try {
			cDeux.retirer(1000);
			System.out.println("Solde actuel : " + cDeux.soldeCompte());
		} catch (CompteException e) {
			System.out.println("Erreur : Le montant retiré doit être supérieur ou égal à 0");
		}

		try {

			cUn.retirer(-100);
			System.out.println("Solde actuel : " + cUn.soldeCompte());
		} catch (CompteException e) {
			System.out.println("Erreur : Le montant retiré doit être supérieur ou égal à 0 ");
		}

// 5) Les 100 euros ne sont pas retirés, le main lève une exception (le montant retiré doit être supérieur ou égal à 0)

		try {
			cDeux.deposer(-100);
			System.out.println("Solde actuel : " + cDeux.soldeCompte());
		} catch (CompteException e) {
			System.out.println("Erreur : Le montant déposé doit être supérieur à 0");
		}

//6) Le main lève une exception : le montant déposé doit être supérieur à 0

		cDeux = cUn;

		cUn.afficher();
		cDeux.afficher();

		System.out.println(System.identityHashCode(cUn));
		System.out.println(System.identityHashCode(cDeux));

// 8) Le compte cDeux se réfère maintenant aux informations du même objet que cUn

		cUn.deposer(1000);
		System.out.println(cUn);
		System.out.println(cDeux);

		cTrois = cUn;
		cQuatre = cUn;

		System.out.println("Solde actuel : " + cUn.soldeCompte() + "\n" + cUn);
		System.out.println("Solde actuel : " + cDeux.soldeCompte() + "\n" + cDeux);
		System.out.println("Solde actuel : " + cTrois.soldeCompte() + "\n" + cTrois);
		System.out.println("Solde actuel : " + cQuatre.soldeCompte() + "\n" + cQuatre);

// cTrois et cQuatre réfèrent eux aussi au même objet que cUn 

		System.out.println(System.identityHashCode(cUn));
		System.out.println(System.identityHashCode(cDeux));
		System.out.println(System.identityHashCode(cTrois));
		System.out.println(System.identityHashCode(cQuatre));

// le code d'identification des quatre variables sera les mêmes car les quatres variables réfèrent au même objet depuis 
// qu'on a fait cDeux = cUn, ect...

		try {
			cTrois.deposer(500);
			System.out.println(cTrois.soldeCompte());
		} catch (CompteException e) {
			System.out.println(" Le montant déposé doit être supérieur à 0");
		}

		try {
			cQuatre.retirer(200);
			System.out.println(cQuatre.soldeCompte());
		} catch (CompteException e) {
			System.out.println("Le montant retiré doit être supérieur à 0");
		}
// Etant donné que cUn, cDeux, cTrois et cQuatre réfèrent tous au même objet, l'argent va être déposé et retiré sur le même compte, 
// et cUn, cDeux, cTrois, cQuatre afficheront le même solde, ect...

// On ne peut pas le faire, car lors de l'instruction cdeux = cUn, la référence de l'objet ayant pour propriétaire Marie a été 
// perdue, on ne peut as la récupérer et donc plus influer sur ce compte

		cUn = null;
		System.out.println(cUn);
// La console affiche null
		// cUn.afficher();
// La console indique une exception : cUn est à null, donc il ne réfère plus l'objet
		cDeux.afficher();
// La variable cDeux affiche bien le compte, car c'est la variable cUn qui est à null et non l'objet

	}

public static void main (String [] args) {
	Compte cUn;
	Compte cDeux;
	Compte cptTemp;

	cUn = new Compte ("010101", "Jean");
	cDeux = new Compte ("020202", "Marie");
	try {
	    cUn.deposer( 1000 );
	    cUn.retirer ( 500 );
	    cDeux.deposer( 2000 );
	    cDeux.retirer ( 200 );
	} catch (CompteException e) {
	        System.out.println("Erreur ...");
	}

	cptTemp = cUn;
	cUn = cDeux;
	cDeux = cptTemp;

	cUn.afficher(); //1
	cDeux.afficher(); //2

//  En 1 sera affiché le nom "Marie" et en 2 le nom "Jean"
	}


}