package dev.entites;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Embedded
    private Vitamine vitamine;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "marque_id")
    private Marque marque;

    @ManyToMany(mappedBy = "produits")
    private List<Allergene> allergenes = new ArrayList<Allergene>();

    @ManyToMany(mappedBy = "produits")
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();

    @ManyToMany(mappedBy = "produits")
    private List<Additif> additifs = new ArrayList<Additif>();

    public Produit() {
    }

    public Vitamine getVitamine() {
        return vitamine;
    }

    public void setVitamine(Vitamine vitamine) {
        this.vitamine = vitamine;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public List<Allergene> getAllergenes() {
        return allergenes;
    }

    public void setAllergenes(List<Allergene> allergenes) {
        this.allergenes = allergenes;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Additif> getAdditifs() {
        return additifs;
    }

    public void setAdditifs(List<Additif> additifs) {
        this.additifs = additifs;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", vitamine=" + vitamine +
                ", categorie=" + categorie +
                ", marque=" + marque +
                ", allergenes=" + allergenes +
                ", ingredients=" + ingredients +
                ", additifs=" + additifs +
                '}';
    }
}
