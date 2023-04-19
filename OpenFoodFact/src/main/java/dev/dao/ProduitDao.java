package dev.dao;

import dev.entites.Produit;

import java.util.List;

/** ProduitDao est une interface avec les méthodes suivantes
 * @author Clement
 * @version 1.00
 * Date de mise à jour : 18/04/2023
 */
public interface ProduitDao {
    /**
     * Permet de lire les données de la Table Produit
     * @return une liste de produit représentant les données de la Table Produit
     */
    List<Produit> extraire();

    /**
     * Permet d'insérer des données dans la Table Produit
     * @param produit notre produit à insérer
     */
    void inserer(Produit produit);

    /**
     * Permet de mettre à jour les données d'un produit dans la Table Produit
     * @param ancienProduit le nom du produit à modifier
     * @param nouveauProduit le nom du produit à modifier
     * @return le nombre de lignes affectées
     */
    int mettreAJourNom(String ancienProduit, String nouveauProduit);

    /**
     * Permet de supprimer un produit dans la Table Produit
     * @param produit le nom du produit à supprimer
     * @return le nombre de lignes affectées
     */
    int supprimer(Produit produit);
}
