/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.monopoly.monopoly;

import java.util.ArrayList;

/**
 * Classe de la case Aller en prison
 * @author Max
 */
public class GoPrison extends CaseSpeciale {
	
	/**
	 * Constructeur de la case Aller en prison
	 * @param numero Numéro de la case
	 */
    public GoPrison(int numero) {
		super("Aller en prison", numero);
	}

	/**
	 * Constructeur de la case Aller en prison
	 * @param nom Nom de la case
	 * @param numero Numéro de la case
	 */
    public GoPrison(String nom, int numero) {
		super(nom, numero);
	}
	
	/**
	 * Fonction qui envoie le joueur en prison
	 * @param j Le joueur à envoyer en prison
	 */
	public void envoyerJoueurPrison(Joueur j) {
		ArrayList<Case> plateau = j.getPlateau().getPlateau();
		for (Case case_jeu : plateau) {
			if (case_jeu.getNom().equals("Prison")) {
				j.setCase(case_jeu.getNumero());
				j.setTourRestantPrison(3);
				
				break;
			}
		}
	}
	
	/**
	 * Redéfinition de la fonction toString
	 * @return Aller en prison
	 */
	@Override
	public String toString() {
		return this.getNom();
	}
}
