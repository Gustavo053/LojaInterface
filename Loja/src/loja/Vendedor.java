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
public class Vendedor extends Funcionario{
    private double vendas;

    public Vendedor(String nome, String cpf, int matricula, double salario, double vendas){
        super(nome, cpf, matricula, salario);
        this.vendas = vendas;
    }

    public double getVendas(){
        return vendas;
    }

    public void setVendas(double vendas){
        this.vendas = vendas;
    }
    
    @Override
    public double calculaPagamento(){
        return (getSalario() + (0.10 * vendas));
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nVendas: " + vendas + "\nTotal: " + calculaPagamento();
    }
    
}
