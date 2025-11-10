/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.monopoly.monopoly;

import java.util.ArrayList;

/**
 * Cases représentant les cases Chance et Communauté
 * Les "?" et les coffres au trésor sur le plateau
 * @author jujus
 */
public class CaseCarte extends CaseSpeciale{
    private String type; //Type de la case : "chance" ou "communaute"
    
    /**
     * Constructeur par défaut d'une case Carte
     */
    public CaseCarte() {
        super("chance", 02);
        type = "chance";
    }
    
    /**
     * Constructeur d'une CaseCarte à partir de son type
     * @param type le type de la case "chance" ou "communaute"
     */
    public CaseCarte(String type){
        super("chance", 2);
        checkType(type);
        this.type = type;
    }
    
    /**
     * Constructeur d'une CaseCarte complet
     * @param numero le numéro de la case
     * @param nom le nom de la case
     * @param type le type de la case : "chance" ou "communaute"
     */
    public CaseCarte(String nom, int numero,  String type){
        super(nom, numero);
        checkType(type);
        this.type = type;        
    }
    
    /**
     * Méthode privée pour vérifier si le type est valide
     * @param type le type de la case
     */
    private void checkType(String type) {
        if (!type.toLowerCase().equals("chance") && !type.toLowerCase().equals("communaute")) {
            throw new IllegalArgumentException("Type de case invalide : " + type);
        }
    }
    
    /**
    * Méthode de tirage aléatoire d'une carte dans la pioche
    * @param pioche la liste de cartes disponibles
    * @return une carte tirée au hasard
    */
    public Carte tirerUneCarte(ArrayList<Carte> pioche) {
        if (pioche == null || pioche.isEmpty()) {
            throw new IllegalArgumentException("La pioche est vide ou nulle.");
        }

        int index = (int) (Math.random() * pioche.size());
        return pioche.get(index);
   }

    /**
     * Guetter de type
     * @return le type
     */
    public String getType() {
        return type;
    }

    /**
     * Le setter du type
     * @param type le type
     */
    public void setType(String type) {
        this.type = type;
    }
}
