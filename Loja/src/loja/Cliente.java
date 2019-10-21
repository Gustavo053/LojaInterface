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
public class Cliente extends Pessoa{
    private String codigo;
    
    Cliente(String nome, String cpf, String codigo){
        super(nome, cpf);
        this.codigo = codigo;
    }

    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCódigo do cliente: " + codigo;
    }
    
}
