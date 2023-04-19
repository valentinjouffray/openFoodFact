package dev.dao;

import dev.entites.Ingredient;

import java.util.List;

public interface IngredientDao {
    List<Ingredient> extraire();

    void inserer(Ingredient ingredient);

    int mettreAJourNom(String ancienIngredient, String nouvelIngredient);

    int supprimer(Ingredient ingredient);
}
