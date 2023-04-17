package dev.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "Composition")
public class CompositionIngredientProduit {

    @Id
    @Column(name = "produit_id")
    private Integer id;

    @Column(name = "quantite")
    private String quantite;

    public CompositionIngredientProduit() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "id=" + id +
                ", quantite='" + quantite + '\'' +
                '}';
    }
}
