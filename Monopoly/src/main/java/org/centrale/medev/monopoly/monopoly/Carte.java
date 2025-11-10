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
     * Construit une carte aléatoire
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
     * Construit une carte du type correspondant d'un montant aléatoire entre -150 et 150
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
    
    /**
    * Affiche les informations de la carte
    */
   public void affiche() {
       System.out.println("📇 Carte " + type.toUpperCase());
       System.out.println("Montant : " + effet + " €");
       System.out.println("Texte : " + texte);
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
     * @param type le nouveau type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Le getter des effets
     * @return les effets
     */
    public int getEffet() {
        return effet;
    }

    /**
     * Le setter des effets
     * @param effet le nouveau montant
     */
    public void setEffet(int effet) {
        this.effet = effet;
    }

    /**
     * Le getter du text
     * @return le texte de la carte
     */
    public String getTexte() {
        return texte;
    }

    /**
     * Le setter du texte
     * @param texte le nouveau texte de la carte
     */
    public void setTexte(String texte) {
        this.texte = texte;
    }
}
