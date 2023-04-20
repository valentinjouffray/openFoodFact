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

    @Column(name = "nutritionGradeFr")
    private GradeNutrition gradeNutrition;

    @Embedded
    private Vitamine vitamine;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "marque_id")
    private Marque marque;

    @ManyToMany(mappedBy = "produits",fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private List<Allergene> allergenes = new ArrayList<Allergene>();

    @ManyToMany(mappedBy = "produits",fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();

    @ManyToMany(mappedBy = "produits",fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private List<Additif> additifs = new ArrayList<Additif>();

    public Produit() {
    }

    public GradeNutrition getGradeNutrition() {
        return gradeNutrition;
    }

    public void setGradeNutrition(String gradeNutrition) {
        String gradeNutritionUpperCase = gradeNutrition.toUpperCase();
        switch (gradeNutritionUpperCase){
            case "A" :
                this.gradeNutrition = GradeNutrition.A;
                break;
            case "B" :
                this.gradeNutrition = GradeNutrition.B;
                break;
            case "C" :
                this.gradeNutrition = GradeNutrition.C;
                break;
            case "D" :
                this.gradeNutrition = GradeNutrition.D;
                break;
            case "E" :
                this.gradeNutrition = GradeNutrition.E;
                break;
        }
    }

    public void setGradeNutrition(char gradeNutrition){
        char gradeNutritionUpperCase = Character.toUpperCase(gradeNutrition);
        switch (gradeNutritionUpperCase){
            case 'A' :
                this.gradeNutrition = GradeNutrition.A;
                break;
            case 'B' :
                this.gradeNutrition = GradeNutrition.B;
                break;
            case 'C' :
                this.gradeNutrition = GradeNutrition.C;
                break;
            case 'D' :
                this.gradeNutrition = GradeNutrition.D;
                break;
            case 'E' :
                this.gradeNutrition = GradeNutrition.E;
                break;
        }
    }

    public void setGradeNutrition(GradeNutrition gradeNutrition) {
        this.gradeNutrition = gradeNutrition;
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
                ", nutritionScore='" + gradeNutrition + '\'' +
                '}';
    }
}
