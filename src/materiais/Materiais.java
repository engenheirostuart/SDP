/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package materiais;

/**
 *
 * @author stuar
 */
public class Materiais {
    
    private String nomeMaterial;
    private double resMaterial;
    private int id;
    
    
    public Materiais(String nomeMaterial, double resMaterial, int id){
        this.nomeMaterial = nomeMaterial;
        this.resMaterial = resMaterial;
        this.id = id;
    }

    public String getNomeMaterial() {
        return nomeMaterial;
    }

    public void setNomeMaterial(String nomeMaterial) {
        this.nomeMaterial = nomeMaterial;
    }

    public double getResMaterial() {
        return resMaterial;
    }

    public void setResMaterial(double resMaterial) {
        this.resMaterial = resMaterial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getNomeMaterial();
    }
    
}
