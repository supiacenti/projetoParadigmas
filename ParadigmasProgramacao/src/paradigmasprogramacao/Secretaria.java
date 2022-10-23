package paradigmasprogramacao;

public class Secretaria extends Empresa {
    int ID;
    private String nome;
    private double previdencia;
    public Secretaria(int ID, String nome, double salario){
        super(ID, nome, salario);
        this.previdencia = 0.05;
    }
    public double getSalarioSecretaria (){
      // Calcula o salário líquido
      return(salario * (1 - previdencia));
    }
}