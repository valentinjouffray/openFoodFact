package dev.entites;

import jakarta.persistence.*;

@Embeddable
public class Vitamine {

    private Double energie100g;

    private Double graisse100g;

    private Double sucre100g;

    private Double fibre100g;

    private Double proteine100g;

    private Double sel100g;

    private Double vita100g;

    private Double vitd100g;

    private Double vitk100g;

    private Double vite100g;

    private Double vitc100g;

    private Double vitb1100g;

    private Double vitb2100g;

    private Double vitpp100g;

    private Double vitb6100g;

    private Double vitb9100g;

    private Double calcium100g;

    private Double magnesium100g;

    private Double fer100g;

    private Double iron100g;

    public Vitamine() {
    }

    public Double getEnergie100g() {
        return energie100g;
    }

    public void setEnergie100g(Double energie100g) {
        this.energie100g = energie100g;
    }

    public Double getGraisse100g() {
        return graisse100g;
    }

    public void setGraisse100g(Double graisse100g) {
        this.graisse100g = graisse100g;
    }

    public Double getSucre100g() {
        return sucre100g;
    }

    public void setSucre100g(Double sucre100g) {
        this.sucre100g = sucre100g;
    }

    public Double getFibre100g() {
        return fibre100g;
    }

    public void setFibre100g(Double fibre100g) {
        this.fibre100g = fibre100g;
    }

    public Double getProteine100g() {
        return proteine100g;
    }

    public void setProteine100g(Double proteine100g) {
        this.proteine100g = proteine100g;
    }

    public Double getSel100g() {
        return sel100g;
    }

    public void setSel100g(Double sel100g) {
        this.sel100g = sel100g;
    }

    public Double getVita100g() {
        return vita100g;
    }

    public void setVita100g(Double vita100g) {
        this.vita100g = vita100g;
    }

    public Double getVitd100g() {
        return vitd100g;
    }

    public void setVitd100g(Double vitd100g) {
        this.vitd100g = vitd100g;
    }

    public Double getVitk100g() {
        return vitk100g;
    }

    public void setVitk100g(Double vitk100g) {
        this.vitk100g = vitk100g;
    }

    public Double getVite100g() {
        return vite100g;
    }

    public void setVite100g(Double vite100g) {
        this.vite100g = vite100g;
    }

    public Double getVitc100g() {
        return vitc100g;
    }

    public void setVitc100g(Double vitc100g) {
        this.vitc100g = vitc100g;
    }

    public Double getVitb1100g() {
        return vitb1100g;
    }

    public void setVitb1100g(Double vitb1100g) {
        this.vitb1100g = vitb1100g;
    }

    public Double getVitb2100g() {
        return vitb2100g;
    }

    public void setVitb2100g(Double vitb2100g) {
        this.vitb2100g = vitb2100g;
    }

    public Double getVitpp100g() {
        return vitpp100g;
    }

    public void setVitpp100g(Double vitpp100g) {
        this.vitpp100g = vitpp100g;
    }

    public Double getVitb6100g() {
        return vitb6100g;
    }

    public void setVitb6100g(Double vitb6100g) {
        this.vitb6100g = vitb6100g;
    }

    public Double getVitb9100g() {
        return vitb9100g;
    }

    public void setVitb9100g(Double vitb9100g) {
        this.vitb9100g = vitb9100g;
    }

    public Double getCalcium100g() {
        return calcium100g;
    }

    public void setCalcium100g(Double calcium100g) {
        this.calcium100g = calcium100g;
    }

    public Double getMagnesium100g() {
        return magnesium100g;
    }

    public void setMagnesium100g(Double magnesium100g) {
        this.magnesium100g = magnesium100g;
    }

    public Double getFer100g() {
        return fer100g;
    }

    public void setFer100g(Double fer100g) {
        this.fer100g = fer100g;
    }

    public Double getIron100g() {
        return iron100g;
    }

    public void setIron100g(Double iron100g) {
        this.iron100g = iron100g;
    }

    @Override
    public String toString() {
        return "Vitamine{" +
                "energie100g=" + energie100g +
                ", graisse100g=" + graisse100g +
                ", sucre100g=" + sucre100g +
                ", fibre100g=" + fibre100g +
                ", proteine100g=" + proteine100g +
                ", sel100g=" + sel100g +
                ", vita100g=" + vita100g +
                ", vitd100g=" + vitd100g +
                ", vitk100g=" + vitk100g +
                ", vite100g=" + vite100g +
                ", vitc100g=" + vitc100g +
                ", vitb1100g=" + vitb1100g +
                ", vitb2100g=" + vitb2100g +
                ", vitpp100g=" + vitpp100g +
                ", vitb6100g=" + vitb6100g +
                ", vitb9100g=" + vitb9100g +
                ", calcium100g=" + calcium100g +
                ", magnesium100g=" + magnesium100g +
                ", fer100g=" + fer100g +
                ", iron100g=" + iron100g +
                '}';
    }
}
