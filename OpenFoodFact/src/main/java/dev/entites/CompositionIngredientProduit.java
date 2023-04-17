package dev.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "Composition")
public class CompositionIngredientProduit {

    @Id
    @Column(name = "produit_id")
    private Integer produit_id;

    @Id
    @Column(name = "ingredient_id")
    private Integer ingredient_id;

    @Column(name = "quantite")
    private String quantite;

    public CompositionIngredientProduit() {
    }

    public Integer getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(Integer produit_id) {
        this.produit_id = produit_id;
    }

    public Integer getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(Integer ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "CompositionIngredientProduit{" +
                "produit_id=" + produit_id +
                ", ingredient_id=" + ingredient_id +
                ", quantite='" + quantite + '\'' +
                '}';
    }
}
