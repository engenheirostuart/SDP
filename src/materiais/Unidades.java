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
public class Unidades {
    
    public String nomeUnidade;
    public String simbUnidade;
    public double numerador;
    
    
    public Unidades(String nomeUnidade, String simbUnidade, double numerador){
        this.nomeUnidade = nomeUnidade;
        this.simbUnidade = simbUnidade;
        this.numerador = numerador;        
    }

    public String getNomeUnidade() {
        return nomeUnidade;
    }

    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    public String getSimbUnidade() {
        return simbUnidade;
    }

    public void setSimbUnidade(String simbUnidade) {
        this.simbUnidade = simbUnidade;
    }

    public double getNumerador() {
        return numerador;
    }

    public void setNumerador(double numerador) {
        this.numerador = numerador;
    }

    @Override
    public String toString() {
        return simbUnidade;
    }

}
