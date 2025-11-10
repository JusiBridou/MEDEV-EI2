/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.monopoly.monopoly;
import java.util.Random;

/**
 * Classe représentant les cartes à piocher 
 * @author jujus
 */
public class Carte {
    private String type; // Le type de la carte : "chance" ou "communaute"
    private int effet; // Le montant gagné (si positif) ou perdu (si négatif) dû à l'effet de la carte
    private String texte; // Le texte écrit sur la carte

    /**
     * Constructeur complet
     * @param type le type
     * @param effet l'effet
     * @param texte le texte
     */
    public Carte(String type, int effet, String texte) {
        checkType(type);
        this.type = type;
        this.effet = effet;
        this.texte = texte;
    }

    /**
     * Constructeur par défaut
     */
    public Carte() {
        Random randomNumbers = new Random(); // valeure aléatoire
        switch (randomNumbers.nextInt(2)){
            case 0 : 
                this.type = "chance";
            case 1 :
                this.type = "communaute";
        }
        this.effet = randomNumbers.nextInt(301) - 150;
        String streffet = Integer.toString(effet);
        if (effet > 0){
            this.texte = "Bonne chance ! La banque vous donne " + streffet + " !";
        } else if (effet < 0){
            this.texte = "Malheur ! Vous devez " +streffet+ " à la banque !";
        } else {
            this.texte = "Une journée comme une autre, il ne se passe rien.";
        }
    }
    
    /**
     * Constructeur spécifique au type
     * @param type le type de la carte
     */
    public Carte(String type){
        checkType(type);
        Random randomNumbers = new Random(); // valeure aléatoire
        this.type = type;
        this.effet = randomNumbers.nextInt(301) - 150;
        String streffet = Integer.toString(effet);
        if (effet > 0){
            this.texte = "Bonne chance ! La banque vous donne " + streffet + " !";
        } else if (effet < 0){
            this.texte = "Malheur ! Vous devez " +streffet+ " à la banque !";
        } else {
            this.texte = "Une journée comme une autre, il ne se passe rien.";
        }
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
}
