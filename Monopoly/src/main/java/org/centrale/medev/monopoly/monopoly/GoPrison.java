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
	 */
    public GoPrison() {
		super(30, "Aller en prison");
	}
	
	/**
	 * Fonction qui envoie le joueur en prison
	 * @param j Le joueur à envoyer en prison
	 */
	public void envoyerJoueurPrison(Joueur j) {
		ArrayList<Case> plateau = j.getPlateau().getPlateau();
		for (Case case : plateau) {
			if (case.getNom().equals("Prison")) {
				j.setCase(case);
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
