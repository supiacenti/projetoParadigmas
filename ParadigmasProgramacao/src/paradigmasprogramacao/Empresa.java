package paradigmasprogramacao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Empresa {
    int ID;
    String nome;
    double salario;
    String cargo;
    private double previdenciaS;
    private double previdenciaP;
    private double previdenciaG;
    private double adicional_whisky, adicional_helicoptero,adicional_adicional;
    private double adicional;
    private double vale_coxinha;
    List<LinkedHashMap<String,String>> list = new ArrayList<LinkedHashMap<String, String>>();
    LinkedHashMap<String, String> container = new LinkedHashMap<String, String>();
    
    public Empresa (int ID, String nome, double salario, String cargo){
        this.setID(ID);
        this.setNome(nome);
        this.setSalario(salario);
        this.setCargo(cargo);
        this.previdenciaS = 0.05;
        this.adicional_whisky=0.9;
        this.adicional_helicoptero=0.7;
        this.adicional_adicional=3.8;
        this.adicional = adicional;
        this.vale_coxinha = vale_coxinha;
        this.previdenciaP=0.15; 
        this.previdenciaG=0.07;
    }
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    //Funções Secretária
    public double getSalarioSecretaria (){
      // Calcula o salário líquido
      return(salario * (1 - previdenciaS));
    }
    
    //Funções Presidente
    void alteraAdicionalPresidente(double novo_percentual){
        this.adicional_whisky = 0.9 * (1 + novo_percentual);
        this.adicional_helicoptero = 0.7 * (1 + novo_percentual);
        this.adicional_adicional = 3.8 * (1 + novo_percentual);
    }
    public double getSalarioPresidente(){
      // Calcula o salário líquido
      return(salario*((1-this.previdenciaP)+this.adicional_whisky+
             this.adicional_helicoptero+this.adicional_adicional));
    }
    
    
    //Funções Estagiário
    public void setValeCoxinha(double vale_coxinha){
      this.vale_coxinha = vale_coxinha;
    }
    
    
    //Container:
    public void Container(int ID, String nome, double salario, String cargo){
        String value = ID + "," + nome + "," + salario + "," + cargo;
        String id = ID + "";
        container.put(id, value);
        list.add(container);
    }
    public String printContainer(){
        String text = "";
        String cont = "";
        for(Map<String, String> map : list){
            for(String key : map.keySet()){
                cont = map.get(key);
                String[] s = cont.split(",");
                text = text + ("ID: " + s[0] + "\n" +
                                "Nome: " + s[1] + "\n" +
                                "Salário: " + s[2] + "\n" + "------------------------------" + "\n");
            }
        }
        return text;
    }
    
    //Função Salários:
    public double salario(double id){
        String v = "";
        for(Map<String, String> map : list){
            for(String key : map.keySet()){
                String s = key;
                DecimalFormat decimalFormat = new DecimalFormat("#,##0");
                String ID = decimalFormat.format(id);
                System.out.println(key);
                System.out.println(ID);
                v = map.get(key);
                String[] values = v.split(",");
                String cargo = values[3];
                double salario = Double.parseDouble(values[2]);
                if (s.equals(ID)){
                    System.out.println("SIM");
                    if(cargo.equals("estagiario")){
                        return(salario + this.vale_coxinha);
                    }else if (cargo.equals("secretaria")){
                        return(salario * (1 - previdenciaS));
                    }else if (cargo.equals("gerente")){
                        return(salario*((1- this.previdenciaG)+ this.adicional));
                    }else if (cargo.equals("presidente")){
                        return(salario*((1-this.previdenciaP)+this.adicional_whisky+
                         this.adicional_helicoptero+this.adicional_adicional));
                    }
                }
            }
        }
//        if(this.cargo == "estagiario"){
//            return(this.salario + this.vale_coxinha);
//        }else if (this.cargo == "secretaria"){
//            return(salario * (1 - previdenciaS));
//        }else if (this.cargo == "gerente"){
//            return(salario*((1- this.previdenciaG)+ this.adicional));
//        }else if (this.cargo == "presidente"){
//            return(salario*((1-this.previdenciaP)+this.adicional_whisky+
//             this.adicional_helicoptero+this.adicional_adicional));
//        }
        return 0;
    }
    
    //Função Adicional (Presidente e Gerente:
    public double adicional(double novo_percentual){
        if(this.cargo == "presidente"){
            this.adicional_whisky = 0.9 * (1 + novo_percentual);
            this.adicional_helicoptero = 0.7 * (1 + novo_percentual);
            this.adicional_adicional = 3.8 * (1 + novo_percentual);
        }else if (this.cargo == "gerente"){
            this.adicional = adicional*(1+novo_percentual);
        }
        return 0;
    }
}
