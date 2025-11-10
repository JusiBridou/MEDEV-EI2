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
public class CaseCarte extends CaseSpeciale {
    private String type; //Type de la case : "chance" ou "communaute"
    
    /**
     * Constructeur par défaut d'une case Carte
     */
    public void CaseCarte() {
        super();
        type = "chance";
    }
    
    /**
     * Constructeur d'une CaseCarte à partir de son type
     * @param type le type de la case "chance" ou "communaute"
     */
    public void CaseCarte(String type){
        super();
        checkType(type);
        this.type = type;
    }
    
    /**
     * Constructeur d'une CaseCarte complet
     * @param numero le numéro de la case
     * @param nom le nom de la case
     * @param type le type de la case : "chance" ou "communaute"
     */
    public void CaseCarte(int numero, String nom, String type){
        super(numero, nom);
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
     * Méthode de tirage
     */
    public Carte tirerUneCarte(ArrayList pioche){
        
        return cartePiochee;
    }
}
