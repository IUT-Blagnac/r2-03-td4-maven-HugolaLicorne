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

// 4) Apr�s utilisation de la m�thode afficher(), on voit dans la console le num�ro de compte,
// le nom du propri�taire ainsi que le nombre de cr�dits, de d�bits et d'op�ration effectu�es  

		nbCompte = cUn.getNumCompte();
		nomProprio = cUn.getProprietaire();
		soldeC = cUn.soldeCompte();

		System.out.println("Num�ro de compte : " + nbCompte);
		System.out.println("Propri�taire : " + nomProprio);
		System.out.println("Solde actuel : " + soldeC);

		try {
			cUn.deposer(100);
			System.out.println("Solde actuel : " + cUn.soldeCompte());
		} catch (CompteException e) {
			System.out.println("Erreur : Le montant d�poser doit �tre sup�rieur � 0");

		}

		try {
			cUn.retirer(100);
			System.out.println("Solde actuel : " + cUn.soldeCompte());
		} catch (CompteException e) {
			System.out.println("Erreur : Le montant retir� doit �tre sup�rieur ou �gal � 0");
		}

		cUn.afficher();
		try {
			cUn.retirer(-100);
			System.out.println("Solde actuel : " + cUn.soldeCompte());
		} catch (CompteException e) {
			System.out.println("Erreur : Le montant retir� doit �tre sup�rieur ou �gal � 0 ");
		}

// 7) Les 100 euros ne sont pas retir�s, le main l�ve une exception (le montant retir� doit �tre sup�rieur ou �gal � 0)

		try {
			cUn.deposer(-100);
			System.out.println("Solde actuel : " + cUn.soldeCompte());
		} catch (CompteException e) {
			System.out.println("Erreur : Le montant d�pos� doit �tre sup�rieur � 0");
		}

// 8) Le main l�ve une exception : le montant d�pos� doit �tre sup�rieur � 0

		System.out.println(cUn);

// 9) La m�thode affiche le num�ro de compte, le propri�taire, ect...

		cUn = null;

		System.out.println(System.identityHashCode(cUn));

// 10) L'instruction affiche le num�ro de l'obet cUn

		cUn.afficher();

// 13) Le main l�ve une exception : la valeur null ayant �t� affect�e au compte, la m�thode cUn.afficher() n'acc�de pas 
// aux informations du compte

	}

	public static void mainExo2(String[] argv) throws Exception {
		Compte cUn;
		Compte cDeux;
		Compte cTrois;
		Compte cQuatre;

//		cUn.afficher();

// 1) L'IDE indique qu'on ne peut pas ex�cuter l'instruction car l'objet n'a pas �t� initialis�

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
			System.out.println("Erreur : Le montant retir� doit �tre sup�rieur ou �gal � 0");
		}

		try {
			cDeux.retirer(1000);
			System.out.println("Solde actuel : " + cDeux.soldeCompte());
		} catch (CompteException e) {
			System.out.println("Erreur : Le montant retir� doit �tre sup�rieur ou �gal � 0");
		}

		try {

			cUn.retirer(-100);
			System.out.println("Solde actuel : " + cUn.soldeCompte());
		} catch (CompteException e) {
			System.out.println("Erreur : Le montant retir� doit �tre sup�rieur ou �gal � 0 ");
		}

// 5) Les 100 euros ne sont pas retir�s, le main l�ve une exception (le montant retir� doit �tre sup�rieur ou �gal � 0)

		try {
			cDeux.deposer(-100);
			System.out.println("Solde actuel : " + cDeux.soldeCompte());
		} catch (CompteException e) {
			System.out.println("Erreur : Le montant d�pos� doit �tre sup�rieur � 0");
		}

//6) Le main l�ve une exception : le montant d�pos� doit �tre sup�rieur � 0

		cDeux = cUn;

		cUn.afficher();
		cDeux.afficher();

		System.out.println(System.identityHashCode(cUn));
		System.out.println(System.identityHashCode(cDeux));

// 8) Le compte cDeux se r�f�re maintenant aux informations du m�me objet que cUn

		cUn.deposer(1000);
		System.out.println(cUn);
		System.out.println(cDeux);

		cTrois = cUn;
		cQuatre = cUn;

		System.out.println("Solde actuel : " + cUn.soldeCompte() + "\n" + cUn);
		System.out.println("Solde actuel : " + cDeux.soldeCompte() + "\n" + cDeux);
		System.out.println("Solde actuel : " + cTrois.soldeCompte() + "\n" + cTrois);
		System.out.println("Solde actuel : " + cQuatre.soldeCompte() + "\n" + cQuatre);

// cTrois et cQuatre r�f�rent eux aussi au m�me objet que cUn 

		System.out.println(System.identityHashCode(cUn));
		System.out.println(System.identityHashCode(cDeux));
		System.out.println(System.identityHashCode(cTrois));
		System.out.println(System.identityHashCode(cQuatre));

// le code d'identification des quatre variables sera les m�mes car les quatres variables r�f�rent au m�me objet depuis 
// qu'on a fait cDeux = cUn, ect...

		try {
			cTrois.deposer(500);
			System.out.println(cTrois.soldeCompte());
		} catch (CompteException e) {
			System.out.println(" Le montant d�pos� doit �tre sup�rieur � 0");
		}

		try {
			cQuatre.retirer(200);
			System.out.println(cQuatre.soldeCompte());
		} catch (CompteException e) {
			System.out.println("Le montant retir� doit �tre sup�rieur � 0");
		}
// Etant donn� que cUn, cDeux, cTrois et cQuatre r�f�rent tous au m�me objet, l'argent va �tre d�pos� et retir� sur le m�me compte, 
// et cUn, cDeux, cTrois, cQuatre afficheront le m�me solde, ect...

// On ne peut pas le faire, car lors de l'instruction cdeux = cUn, la r�f�rence de l'objet ayant pour propri�taire Marie a �t� 
// perdue, on ne peut as la r�cup�rer et donc plus influer sur ce compte

		cUn = null;
		System.out.println(cUn);
// La console affiche null
		// cUn.afficher();
// La console indique une exception : cUn est � null, donc il ne r�f�re plus l'objet
		cDeux.afficher();
// La variable cDeux affiche bien le compte, car c'est la variable cUn qui est � null et non l'objet

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

//  En 1 sera affich� le nom "Marie" et en 2 le nom "Jean"
	}


}