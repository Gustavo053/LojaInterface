/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja;

/**
 *
 * @author Aluno
 */
public class Administrativo extends Funcionario{
    private double horas;
    
    public Administrativo(String nome, String cpf, int matricula, double salario, double horas) {
        super(nome, cpf, matricula, salario);
        this.horas = horas;
    }

    public double getHoras(){
        return horas;
    }

    public void setHoras(double horas){
        this.horas = horas;
    }

    @Override
    public double calculaPagamento() {
        return (getSalario() + ((getSalario() * 0.01) * horas));
    }

    @Override
    public String toString() {
        return super.toString() + "\nHoras do administrador: " + horas + "\nTotal: " + calculaPagamento();
    }
    
}
