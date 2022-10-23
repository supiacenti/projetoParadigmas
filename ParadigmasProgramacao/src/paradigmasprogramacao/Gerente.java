package paradigmasprogramacao;

public class Gerente extends Empresa {
    private double salario, previdencia, adicional;
    public Gerente(int ID, String nome, double salario, double adicional){
        super(ID, nome, salario);
        this.previdencia=0.07;
        // adicional caso o funcionário seja por exemplo chefe.
        this.adicional = adicional;
    }
    public void alteraAdicional(double novo_percentual){
        this.adicional = adicional*(1+novo_percentual);
    }
    public double getSalario(){
    // Calcula o salário líquido
        return(salario*((1- this.previdencia)+ this.adicional));
    }
}
