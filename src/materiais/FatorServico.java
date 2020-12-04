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
public class FatorServico {
    
    public double fator;
    
    
    public FatorServico(double fator){
        this.fator = fator;        
                
    }

    public double getFator() {
        return fator;
    }

    public void setFator(double fator) {
        this.fator = fator;
    }

    @Override
    public String toString() {
        return "Fator de Serviço: "+ fator;
    }
    
}

