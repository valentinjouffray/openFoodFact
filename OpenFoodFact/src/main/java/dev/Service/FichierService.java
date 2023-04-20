package dev.Service;

import dev.entites.*;
import dev.dao.*;
import dev.userInterface.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/** FichierService permet de lire tous les éléments de fichier csv
 * @author Clement
 * @version 1.00
 * Date de mise à jour : 20/04/2023
 */
public class FichierService {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.afficherMenuPrincipal();
    }

    static String FILE_NAME = "src/main/resources/open-food.csv";

    /**
     * Liste de produits enregistrés après lecture du fichier
     */
    private static List<Produit> produits;

    /**
     * Permet de lire les éléments du fichier csv
     * @param file le fichier à lire
     */
    public static void readFile(File file) throws IOException {

        produits = new ArrayList<Produit>();

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            List<Additif> additifTemp = new ArrayList<Additif>();
            List<Ingredient> ingredientTemp = new ArrayList<Ingredient>();
            List<Allergene> allergeneTemp = new ArrayList<Allergene>();
            List<Produit> produitTemp = new ArrayList<Produit>();
            String[] data = line.split("\\|",-1);

            Additif a = null;
            Ingredient i = null;
            Allergene all = null;

            if(!data[0].equals("categorie")) {

                Produit p = new Produit();
                p.setNom(data[2]);
                p.setGradeNutrition(data[3]);
                produitTemp.add(p);

                if (data[29].contains(",")) {
                    String[] adTemp = data[29].split(",");
                    for (int j = 0; j < adTemp.length; j++) {
                        a = new Additif();
                        a.setNom(adTemp[j]);
                        additifTemp.add(a);
                        a.setProduits(produitTemp);
                    }
                } else {
                    a = new Additif();
                    a.setNom(data[29]);
                    additifTemp.add(a);
                    a.setProduits(produitTemp);
                }

                data[4] = retirerCaractere(data[4]);

                if (data[4].contains(",")) {
                    String[] ingTemp = data[4].split(",");
                    for (int j = 0; j < ingTemp.length; j++) {
                        i = new Ingredient();
                        i.setNom(ingTemp[j]);
                        ingredientTemp.add(i);
                        i.setProduits(produitTemp);
                    }
                } else {
                    i = new Ingredient();
                    i.setNom(data[4]);
                    ingredientTemp.add(i);
                    i.setProduits(produitTemp);
                }

                data[28] = retirerCaractere(data[28]);

                if (data[28].contains(",")) {
                    String[] allTemp = data[4].split(",");
                    for (int k = 0; k < allTemp.length; k++) {
                        all = new Allergene();
                        all.setNom(allTemp[k]);
                        allergeneTemp.add(all);
                        all.setProduits(produitTemp);
                    }
                } else {
                    all = new Allergene();
                    all.setNom(data[28]);
                    allergeneTemp.add(all);
                    all.setProduits(produitTemp);
                }

                Vitamine v = new Vitamine();
                if(!data[5].isEmpty()) {
                    v.setEnergie100g(Double.valueOf(data[5]));
                }
                if(!data[6].isEmpty()) {
                v.setGraisse100g(Double.valueOf(data[6]));
                }
                if(!data[7].isEmpty()) {
                v.setSucre100g(Double.valueOf(data[7]));
                }
                if(!data[8].isEmpty()) {
                v.setFibre100g(Double.valueOf(data[8]));
                }
                if(!data[9].isEmpty()) {
                v.setProteine100g(Double.valueOf(data[9]));
                }
                if(!data[10].isEmpty()) {
                v.setSel100g(Double.valueOf(data[10]));
                }
                if(!data[11].isEmpty()) {
                v.setVita100g(Double.valueOf(data[11].trim().replaceAll("-", "")));
                }
                if(!data[12].isEmpty()) {
                v.setVitd100g(Double.valueOf(data[12].trim().replaceAll("-", "")));
                }
                if(!data[13].isEmpty()) {
                v.setVite100g(Double.valueOf(data[13].trim().replaceAll("-", "")));
                }
                if(!data[14].isEmpty()) {
                v.setVitk100g(Double.valueOf(data[14].trim().replaceAll("-", "")));
                }
                if(!data[15].isEmpty()) {
                v.setVitc100g(Double.valueOf(data[15]));
                }
                if(!data[16].isEmpty()) {
                v.setVitb1100g(Double.valueOf(data[16]));
                }
                if(!data[17].isEmpty()) {
                v.setVitb2100g(Double.valueOf(data[17]));
                }
                if(!data[18].isEmpty()) {
                v.setVitpp100g(Double.valueOf(data[18]));
                }
                if(!data[19].isEmpty()) {
                v.setVitb6100g(Double.valueOf(data[19]));
                }
                if(!data[20].isEmpty()) {
                v.setVitb9100g(Double.valueOf(data[20].trim().replaceAll("-", "")));
                }
                if(!data[21].isEmpty()) {
                v.setVitb12100g(Double.valueOf(data[21]));
                }
                if(!data[22].isEmpty()) {
                v.setCalcium100g(Double.valueOf(data[22]));
                }
                if(!data[23].isEmpty()) {
                v.setMagnesium100g(Double.valueOf(data[23]));
                }
                if(!data[24].isEmpty()) {
                v.setIron100g(Double.valueOf(data[24]));
                }
                if(!data[25].isEmpty()) {
                v.setFer100g(Double.valueOf(data[25]));
                }
                if(!data[26].isEmpty()) {
                v.setBetaCarotene100g(Double.valueOf(data[26]));
                }


                Categorie c = new Categorie();
                c.setNom(data[0]);

                Marque m = new Marque();
                m.setNom(data[1]);

                p.setVitamine(v);
                p.setCategorie(c);
                p.setMarque(m);

                p.setAdditifs(additifTemp);
                p.setIngredients(ingredientTemp);
                p.setAllergenes(allergeneTemp);

                produits.add(p);

            }
        }
        br.close();
        fr.close();
    }

    /**
     * Permet de retirer les contraintes regex
     * @param str le String à modifier
     * @return str
     */
    public static String retirerCaractere(String str)
    {
        str = str.trim().replaceAll("[0-9]+", "");
        str = str.trim().replaceAll("-", ",");
        str = str.trim().replaceAll(";", ",");
        str = str.trim().replaceAll("\\.", ",");
        str = str.trim().replaceAll("_", "");
        str = str.trim().replaceAll("\\*", "");
        str = str.trim().replaceAll("%", "");
        str = str.trim().replaceAll("\\[", "");
        str = str.trim().replaceAll("]", "");
        str = str.trim().replaceAll("\\(", "");
        str = str.trim().replaceAll("\\)", "");
        str = str.trim().replaceAll("Confiture", ",Confiture");

        return str;
    }

    public static String getResourcePath(String fileName) {
        final File f = new File("");
        final String dossierPath = f.getAbsolutePath() + File.separator + fileName;
        return dossierPath;
    }

    public static File getResource(String fileName) {
        final String completeFileName = getResourcePath(fileName);
        File file = new File(completeFileName);
        return file;
    }

    public static List<Produit> getProduits() {
        return produits;
    }
}