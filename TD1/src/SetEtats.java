/**
 * TP1 : Labyrinthes - Recherche opérationnelle et aide à la décision
 * Classe SetEtats : les états dans l'ensemble doivent être tous différents.
 * 
 * @version 2017-03-06
 * @author Solen Quiniou
 *
 */

import org.omg.DynamicAny._DynValueStub;

import java.lang.reflect.Array;
import java.util.*;


/**
 * @author quiniou-s-1
 *
 */
public class SetEtats {
	/**
	 * L'ensemble des états tous différents, sans ordre particulier.
	 */
	private HashSet<Etat> _ensembleEtats;
	
	
	/**
	 * Constructeur d'un ensemble vide.
	 */
	public SetEtats(){
		this._ensembleEtats= new HashSet<>();
	}

	
	/**
	 * Méthode qui donne l'élément de l'ensemble correspondant 
	 * à l'élément donné en paramètre.
	 * @param elem : l'élément recherché.
	 * @return l'élément recherché, s'il existe (null sinon).
	 */
	public Etat get(Etat elem){
		if (!this._ensembleEtats.contains(elem)) {
			return null;
		}
		return this._ensembleEtats.stream().filter(val -> val.equals(elem)).findFirst().get();
	}


	/**
	 * Méthode qui ajoute un état à l'ensemble.
	 * @param etat : l'état à ajouter.
	 */
	public void add(Etat etat) {
		this._ensembleEtats.add(etat);
	}


	/**
	 * Méthode qui supprime un état de l'ensemble.
	 * @param etat : l'état à supprimer.
	 */
	public void remove(Etat etat) {
		this._ensembleEtats.remove(etat);
	}
	
	
	/**
	 * Méthode qui donne la représentation de la file.
	 * @return la représentation de la file sous forme de chaîne.
	 */
	public String toString(){
		String str = "";
		
		Iterator<Etat> iter = _ensembleEtats.iterator();
		while(iter.hasNext()){
			str += iter.next().toString() + "\n";
		}
		
		return str;
	}
}
