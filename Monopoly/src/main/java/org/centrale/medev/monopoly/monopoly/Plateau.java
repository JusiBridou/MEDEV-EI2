/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.monopoly.monopoly;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;


/**
 *
 * @author Max
 */
public class Plateau {
    private ArrayList<Case> plateau;
    private LinkedList<Joueur> joueurs;
    private ArrayList<Carte> piocheChance;
    private ArrayList<Carte> piocheCommunaute;
    private ArrayList<Carte> defausseChance;
    private ArrayList<Carte> defausseCommunaute;
    private int nbToursMax = 100;
    private int compteurTours = 1;
    /**
     * 
     */
    public Plateau(){ 
    }
    /**
     * 
     * @return 
     */
    public int lancerDé1(){
        Random randInt = new Random();
        int dé1 = randInt.nextInt(6)+1;

        return dé1;
    }
    public int lancerDé2(){
        Random randInt = new Random();
        int dé2 = randInt.nextInt(6)+1;
        
        return dé2;
    }
    public void affiche(){
        for(Case case_plateau : plateau){
            case_plateau.toString();
        }
    }

    public void supprimerJoueur(Joueur j){
        joueurs.remove(j);
    }
    
    public boolean finDePartie(){
        return (joueurs.size()<=1 || compteurTours > nbToursMax) ;
    }
    
    public ArrayList getPlateau() {
        return plateau;
    }

    public void setPlateau(ArrayList plateau) {
        this.plateau = plateau;
    }

    public LinkedList getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(LinkedList joueurs) {
        this.joueurs = joueurs;
    }
    
}

