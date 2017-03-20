import java.util.ArrayList;
import java.util.List;

/**
 * TP1 : Labyrinthes - Recherche opérationnelle et aide à la décision
 * Classe AEtoile
 * 
 * @version 2017-03-06
 * @author Solen Quiniou
 *
 */


public class AEtoile {
	
	/**
	 * Méthode qui implémente l'algorithme A*.
	 * @param etatInit : l'état initial à partir duquel réaliser l'algorithme A*.
	 * @param heurist : la fonction heuristique utilisée dans l'algorithme A*.
	 * @return l'état final obtenu par l'algorithme A* (ou null s'il n'y a pas de résultat).
	 */
	public static Etat algoAEtoile(Etat etatInit, FonctionHeuristique heurist){
		FileEtats ouvert = new FileEtats();
		ouvert.add(etatInit);
		SetEtats fermes = new SetEtats();
		Etat etatFinal=null;
//		Etat etat;

		while (!ouvert.isEmpty() && etatFinal==null){
			Etat etat=ouvert.first();
			if(etat.estFinal()){
				etatFinal=etat;
			}else{
				fermes.add(etat);
				etat.getSuccesseurs(heurist).forEach(succ ->{
//					System.out.println(fermes.get(succ));
					if (fermes.get(succ)!=null){
						Etat succFerme = fermes.get(succ);
						if(succ.getValF()<succFerme.getValF()){
							fermes.remove(succFerme);
							ouvert.add(succ);
						}
					}else if(ouvert.get(succ)!=null){
						Etat succOuver = ouvert.get(succ);
						if(succ.getValF()<succOuver.getValF()){
							ouvert.remove(succOuver);
							ouvert.add(succ);
						}
					}else{
						ouvert.add(succ);
					}

//					System.out.println(succ);
//					System.out.println(etat);
				});
			}
		}

		return etatFinal;
	}

}
