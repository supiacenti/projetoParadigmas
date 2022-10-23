package paradigmasprogramacao;

import java.util.ArrayList;
import paradigmasprogramacao.Empresa;
public class main {

    public static void main(String[] args) {
        int id = 1;
        int id2 = 2;

        String nome = "Leticia";
        double salario = 5000;
        String cargo = "presidente";
        Empresa d = new Empresa(id, nome, salario, cargo);
        d.Container(id, nome, salario, cargo);
        d.Container(id2, nome, salario, cargo);
        d.adicional(0.5);
        double ajuste = d.salario(1);
        System.out.println("teste" + ajuste);
        System.out.println(d.printContainer());
    }
}
