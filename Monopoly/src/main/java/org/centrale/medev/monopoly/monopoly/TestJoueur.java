/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.monopoly.monopoly;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author selli
 */
public class TestJoueur {
    public static void main(String[] args){
        Plateau p = new Plateau();
        Joueur j = new Joueur("Justine",0,p);
        Random alea=new Random();
        int n =alea.nextInt(12); //On suppose proba uniforme de chaque résultat de lancer
        j.setPosition(j.getPosition()+n);
        System.out.println(j.getNom()+" est à la position "+j.getPosition()+".");
    }
}
