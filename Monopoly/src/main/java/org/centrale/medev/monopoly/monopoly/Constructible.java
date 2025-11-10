/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.monopoly.monopoly;

/**
 *
 * @author Max
 */
public class Constructible extends CaseAchetable {
    private int nbBatiment;

    /**
     * Constructeur d'une case constructible
     * @param nbBatiment
     * @param prix
     * @param proprietaire
     * @param numero
     * @param nom
     */
    public Constructible(int nbBatiment, int prix, Joueur proprietaire, int numero, String nom) {
        super(prix, proprietaire, numero, nom);
        this.nbBatiment = nbBatiment;
    }

    /**
     *
     * @return
     */
    public int getNbBatiment() {
        return nbBatiment;
    }

    /**
     *
     * @param nbBatiment
     */
    public void setNbBatiment(int nbBatiment) {
        this.nbBatiment = nbBatiment;
    }
    
    /**
     * Méthode qui permet d'afficher une case constructible
     * @return chaîne de caractère qui ajoute à la méthode super le propriétaire, le nombre de maisons possédées et si besoin, le loyer à payer sur cette case
     */
    @Override
    public String toString(){
        String txt = super.toString();
        if (this.getProprietaire() == null){
            txt +=" - sans propriétaire";
        }
        else{
            txt += " - propriétaire : "+this.getProprietaire()+", "+this.getNbBatiment()+" maison(s)";
            int loyer = calculerLoyer(this.getProprietaire());
            txt += ", loyer = "+loyer;
        }
        return txt;
    }

    /**
     * Méthode qui permet de calculer le loyer d'une case constructible
     * @param prop joueur qui possède la case constructible
     * @return le loyer à payer au joueur possédant la case qui est calculé selon une fonction dépendant de la distance de la case au départ, le prix de celle-ci et le nombre de bâtiments possédés par le joueur à payer
     */
    @Override
    public int calculerLoyer(Joueur prop) {
        if (prop==null){
            return 0;
        }
        else{
            // Le prix du loyer dépend de la distance de la case en question avec le départ (représentée par son numéro) et du nombre de bâtiments sur la case
            // fonction pour calculer : 1 loyer = ax+b avec x le numéro de la case
            float a = 175/2f; // 1ere case : 500, dernière case 4000, nbr de case = 40 => a = 4000-500/40
            int b = 500; // prix loyer 1ere case
            int loyerBase = (int) ((a*this.getNumero()+b)/100)*100; // Calcul qui permet d'optimiser les arrondies
            int loyer = loyerBase + this.getNbBatiment()*loyerBase; // loyerdebase + loyerdebase*nbbatimentsurlacase
            return loyer;
        }
    }
    
    /**
     * Méthode qui permet de construire un bâtiment sur cette case, sachant qu'il ne peut y avoir au maximum que 5 bâtiments
     */
    public void construire(){
        if (this.getNbBatiment()<5){
           this.setNbBatiment(this.getNbBatiment()+1); 
        }
        else{
            System.out.println("Nbr de bâtiment max atteint pour cette case");
        }
    }
}
