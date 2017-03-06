/**
 * TP1 : Labyrinthes - Recherche opérationnelle et aide à la décision
 * 
 * Type enum Deplacement : les 4 déplacements autorisés pour la case vide, 
 * c'est-à-dire haut, bas, gauche et droite.
 * 
 * @version 2017-03-06
 * @author Solen Quiniou
 *
 */


public enum Deplacement {
	haut, bas, gauche, droite;
	
	
	/**
	 * Méthode qui transforme le déplacement en une chaîne de caractères.
	 * @param d : le déplacement considéré.
	 * @return la chaîne de caractères correspondant au nom du déplacement.
	 */
	public static String toString(Deplacement d){
		String str = "";
		
		switch(d){
		case haut:
			str = "haut";
			break;
		case bas:
			str = "bas";
			break;
		case gauche:
			str = "gauche";
			break;
		case droite:
			str = "droite";
			break;
		}
		
		return str;
	}
}
