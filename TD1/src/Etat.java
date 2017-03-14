/**
 * TP1 : taquin - Recherche opérationnelle et aide à la décision
 * Classe Etat : classe qui représente un état et qui contient son état père, les coordonnées de la case vide,
 * 				 la configuration de jeu du taquin, les valeurs des fonctions f et g ainsi que les coups joués
 * 				 depuis une configuration initiale et le nombre de coups.
 * 
 * @version 2016-02-22
 * @author quiniou-s-1
 *
 */

import com.sun.istack.internal.NotNull;

import java.lang.reflect.Array;
import java.util.*;


public class Etat{
	/**
	 * Le labyrinthe courant.
	 */
	private Labyrinthe _labyrinthe; 
	
	
	/**
	 * L'abscisse de la case courante.
	 */
	private int _xCour;
	/**
	 * L'ordonnée de la case courante.
	 */
	private int _yCour;
	
	
	/**
	 * L'état père de l'état courant.
	 */
	private Etat _pere; 
	
	
	/**
	 * La valeur de la fonction de coût g().
	 */
	private int _valG;
	/**
	 * La valeur de la fonction de coût f() = g() + h().
	 */
	private int _valF;

	
	/**
	 * La suite de déplacements dans le labyrinthe, de l'état initial à l'état courant.
	 */
	private List<Deplacement> _coups;
	
	
	
	/**
	 * Constructeur.
	 * @param lab : le labyrinthe courant.
	 * @param heurist : la fonction heuristique choisie.
	 */
	public Etat(Labyrinthe lab, FonctionHeuristique heurist){
		this._labyrinthe=lab;
		this._xCour=lab.getXEntree();
		this._yCour=lab.getYEntree();
		this._pere=null;
		this._valG=0;
		this._valF= heurist==null?0:this._valG+heurist.heuristique(this);//???????
		this._coups=new ArrayList<>();
	}
	
	
	/**
	 * Constructeur.
	 * @param lab : le labyrinthe courant.
	 */
	public Etat(Labyrinthe lab){
		this(lab, new HeuristiqueEuclidienne());
	}
	
	
	/**
	 * Constructeur qui recopie l'état e dans l'état courant.
	 * @param e : l'état à cloner.
	 */
	public Etat(Etat e){
		this._labyrinthe=e._labyrinthe;
		this._coups=e._coups;
		this._pere=e.getPere();
		this._valF=e.getValF();
		this._valG=e.getValG();
		this._xCour=e.getX();
		this._yCour=e.getY();
	}

	public void set_labyrinthe(Labyrinthe _labyrinthe) {
		this._labyrinthe = _labyrinthe;
	}

	public void set_xCour(int _xCour) {
		this._xCour = _xCour;
	}

	public void set_yCour(int _yCour) {
		this._yCour = _yCour;
	}

	public void set_pere(Etat _pere) {
		this._pere = _pere;
	}

	public void set_valG(int _valG) {
		this._valG = _valG;
	}

	public void set_valF(int _valF) {
		this._valF = _valF;
	}

	public void set_coups(List<Deplacement> _coups) {
		this._coups = _coups;
	}

	public void add_coups(Deplacement dep){
		this._coups.add(dep);
	}

	/**
	 * Méthode qui donne le père de l'état courant.
	 * @return le père de l'état courant.
	 */
	public Etat getPere(){
		return this._pere;
	}
	
	
	/**
	 * Méthode qui donne le nombre de déplacements effectués
	 * depuis l'état initial. 
	 * @return le nombre de déplacements.
	 */
	public int getNbCoups(){
		return this._coups.size();
	}
	
	
	/**
	 * Méthode qui donne la valeur de la fonction d'évaluation g.
	 * @return la valeur de la fonction g.
	 */
	public int getValG(){
		return this._valG;
	}
	
	
	/**
	 * Méthode qui donne la valeur de la fonction d'évaluation f.
	 * @return la valeur de la fonction f.
	 */
	public int getValF(){
		return this._valF;
	}
	
	
	/**
	 * Méthode qui indique si la case de coordonnées données est accessible ou non.
	 * @param x : l'abscisse de la case.
	 * @param y : l'ordonnée de la case.
	 * @return vrai si la case courante est accessible et faux si c'est un mur.
	 */
	public boolean estAccessible(int x, int y){
		return this._labyrinthe.estAccessible(x,y);
	}
	
	
	/**
	 * Méthode qui donne l'abscisse de la case courante.
	 * @return l'abscisse de la case courante.
	 */
	public int getX(){
		return this._xCour;
	}
	
	
	/**
	 * Méthode qui donne l'ordonnée de la case courante.
	 * @return l'ordonnée de la case courante.
	 */
	public int getY(){
		return this._yCour;
	}

	public Labyrinthe get_labyrinthe() {
		return _labyrinthe;
	}

	/**
	 * Méthode qui dit si l'état courant est un état final.
	 * @return vrai si l'état courant correspond à un état final.
	 */
	public boolean estFinal(){
		return this._xCour==this._labyrinthe.getXSortie() && this._yCour==this._labyrinthe.getYSortie();
	}

	
	
	/**
	 * Méthode qui indique s'il est possible de se déplacer,
	 * dans la direction donnée par d.
	 * @param d : la direction pour se déplacer depuis la case courante.
	 * @return vrai si la case vide peut être déplacée dans la direction d.
	 */
	public boolean deplacementPossible(Deplacement d){
		//a test
		Boolean b=false;
		switch(d){
			case haut:
				b= this.estAccessible(this._xCour, this._yCour-1);
				break;
			case bas:
				b= this.estAccessible(this._xCour, this._yCour+1);
				break;
			case gauche:
				b= this.estAccessible(this._xCour-1, this._yCour);
				break;
			case droite:
				b= this.estAccessible(this._xCour+1, this._yCour);
				break;
		}
		return b;
	}
	
	
	/**
	 * Méthode qui étend l'état courant, en créant un nouvel état dans lequel 
	 * la case courante est déplacée dans la direction donnée par d.
	 * @param d : la direction pour se déplacer depuis la case courante.
	 * @param heurist : la fonction heuristique utilisée pour étendre l'état.
	 * @return l'état créé à partir de l'état courant
	 */
	public Etat etendEtat(Deplacement d, FonctionHeuristique heurist){
//		System.out.println("bug");
		Etat e=new Etat(this);
		e.add_coups(d);
		e.set_pere(this);
		e.set_valG(getValG()+1);
		e.set_valF(e.getValG()+heurist.heuristique(e));

		switch(d){
			case haut:
				e.set_yCour(this._yCour-1);
				break;
			case bas:
				e.set_yCour(this._yCour+1);
				break;
			case gauche:
				e.set_xCour(this._xCour-1);
				break;
			case droite:
				e.set_xCour(this._xCour+1);
				break;
		}
		return e;
	}
	
	
	/**
	 * Méthode qui crée les états successeurs de l'état courant,
	 * calculés selon l'emplacement de la case courante et en utilisant
	 * la fonction heuristique donnée.
	 * @param heurist : la fonction heuristique utilisée pour étendre l'état.
	 * @return les états successeurs créés.
	 */
	public List<Etat> getSuccesseurs(FonctionHeuristique heurist){
//		List<Etat> l = new ArrayList<>();
//		Arrays.stream(Deplacement.values()).forEach(dep -> {
//			if (this.deplacementPossible(dep)) {
//				l.add(this.etendEtat(dep, heurist));
//			}
//		});
//		return l;

		return Arrays.stream(Deplacement.values())
				.filter(this::deplacementPossible)
				.collect(ArrayList::new,
						(array, deplacement) -> array.add(this.etendEtat(deplacement, heurist)),
						ArrayList::addAll);
	}


	/**
	 * Méthode qui dit si 2 états sont égaux, du point de vue de la configuration.
	 * @param e : l'état avec lequel comparer l'état courant.
	 * @return vrai si les états correspondent à la même configuration.
	 */
	@Override
	public boolean equals(Object e) {
		if (this == e) return true;
		if (e == null || getClass() != e.getClass()) return false;

		Etat etat = (Etat) e;

		if (_xCour != etat._xCour) return false;
		if (_yCour != etat._yCour) return false;
		return _labyrinthe != null ? _labyrinthe.equals(etat._labyrinthe) : etat._labyrinthe == null;

	}

	/**
	 * Méthode qui affiche la séquence de configurations.
	 */
	public void afficherParcours(){
		System.out.println(this._coups);
	}
	
	/**
	 * Méthode qui donne la représentation de l'état, sous forme de chaîne, comprenant
	 * le labyrinthe, les valeurs des fonctions f et g ainsi que les nombre de
	 * coups et la suite de déplacements de la case vide.
	 * @return la chaîne représentant l'état.
	 */
	public String toString() {
		return "Etat{" +
				"_labyrinthe=" + _labyrinthe.toString() +
				", _xCour=" + _xCour +
				", _yCour=" + _yCour +
				", _pere=" + _pere +
				", _valG=" + _valG +
				", _valF=" + _valF +
				", _coups=" + _coups +
				'}';
	}

}
