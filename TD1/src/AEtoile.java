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
		List<Etat> ouvert = new ArrayList<>();
		ouvert.add(etatInit);
		List<Etat> fermes = new ArrayList<>();
		Etat etatFinal=null;
		Etat etat;

		while (!ouvert.isEmpty() && etatFinal==null){
			System.out.println("1");
			etat=ouvert.get(0);
			if(etat.estFinal()){
				etatFinal=etat;
			}else{
				fermes.add(etat);
				etat.getSuccesseurs(heurist).forEach(succ ->{
					if (fermes.contains(succ)){
						Etat succFerme = fermes.get(fermes.indexOf(succ));
						if(heurist.heuristique(succ)< heurist.heuristique(succFerme)){
							fermes.remove(succFerme);
							ouvert.add(succ);
						}
					}else if(ouvert.contains(succ)){
						Etat succOuver = ouvert.get(ouvert.indexOf(succ));
						if(heurist.heuristique(succ)< heurist.heuristique(succOuver)){
							ouvert.remove(succOuver);
							ouvert.add(succ);
						}
					}else{
						ouvert.add(succ);
					}

//					System.out.println(succ);

				});
			}
			ouvert.stream().sorted(new ComparateurEtat());
		}

		return etatFinal;
	}

}
