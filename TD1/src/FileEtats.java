/**
 * TP1 : Labyrinthes - Recherche opérationnelle et aide à la décision
 * Classe FileEtats : les états dans la file sont ordonnés par valeur croissante
 * de la fonction f.
 * 
 * @version 2017-03-06
 * @author Solen Quiniou
 *
 */

import java.util.*;


public class FileEtats {
	/**
	 * La file des états ordonnés selon les valeurs croissantes de f. 
	 */
	private PriorityQueue<Etat> _fileEtats;
	
	
	
	/**
	 * Constructeur d'une file vide.
	 */
	public FileEtats(){
		this._fileEtats=new PriorityQueue<>(new ComparateurEtat());
	}
	
	
	/**
	 * Méthode qui donne l'élément de la file correspondant 
	 * à l'élément donné en paramètre.
	 * @param elem : l'élément recherché.
	 * @return l'élément recherché, s'il existe (null sinon).
	 */
	public Etat get(Etat elem){
//		if (!this._fileEtats.contains(elem)) {
//			return null;
//		}
		return this._fileEtats.stream().filter(val -> val.equals(elem)).findFirst().orElse(null);
	}
	
	
	/**
	 * Méthode qui ajoute un élément dans la file,
	 * à la bonne position pour qu'elle soit ordonnée
	 * de manière croissante.
	 * @param elem : l'élément à ajouter.
	 * @return vrai si l'ajout a été effectué.
	 */
	public boolean add(Etat elem){
		this._fileEtats.add(elem);
		return true;
	}
	
	
	/**
	 * Méthode qui ôte le premier élément de la file.
	 * @return l'élément en tête de file qui a été ôté.
	 */
	public Etat first(){
		return this._fileEtats.poll();
	}

	
	/**
	 * Méthode qui indique si la file est vide ou non.
	 * @return vrai si la file est vide, faux sinon.
	 */
	public boolean isEmpty() {
		return this._fileEtats.isEmpty();
	}


	/**
	 * Méthode qui supprime un état de la file.
	 * @param etat : l'état à supprimer.
	 */
	public void remove(Etat etat) {
		this._fileEtats.remove(etat);
	}
	
	
	/**
	 * Méthode qui donne la représentation de la file.
	 * @return la représentation de la file sous forme de chaîne.
	 */
	public String toString(){
		String str = "";
		
		Iterator<Etat> iter = _fileEtats.iterator();
		while(iter.hasNext()){
			str += iter.next().toString() + "\n";
		}
		
		return str;
	}

}
