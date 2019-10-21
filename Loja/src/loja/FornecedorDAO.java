/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class FornecedorDAO implements DAO{
    private ArrayList<Fornecedor> lista = new ArrayList<>();
    private Scanner entrada = new Scanner(System.in);
    private static FornecedorDAO fornecedor;
    
    private FornecedorDAO(){
        
    }
    
    public static FornecedorDAO getSingleton(){
        if(fornecedor == null){
            fornecedor = new FornecedorDAO();
        }
        return fornecedor;
    }

    @Override
    public void menu() {
        int opcao;
        do{
            System.out.print("\n\tMENU FORNECEDOR\n1-Cadastrar Fornecedor\n2-Remover Fornecedor"
                    + "\n3-Buscar Fornecedor\n4-Voltar\n: ");
            opcao = entrada.nextInt();
            switch(opcao){
                case 1:
                    cadastrar();
                    break;
                case 2:
                    remover();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Por favor, digite uma opção válida");
            }
        }while(opcao != 4);
    }

    @Override
    public void cadastrar() {
        System.out.println("\n\tCadastrar Fornecedor\nInforme a razão social e o CNPJ da empresa: ");
        lista.add(new Fornecedor(entrada.next(), entrada.next()));
        System.out.println("Cadastrado");
    }

    @Override
    public void remover() {
        int flag = 0;
        System.out.print("Digite o cnpj: ");
        String cnpj = entrada.next();
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getCnpj().equalsIgnoreCase(cnpj)){
                lista.remove(i);
                System.out.println("Removido");
                flag = 1;
                break;
            }
        }
        if(flag == 0){
            System.out.println("Empresa não cadastrada");
        }
    }

    @Override
    public void buscar() {
        int flag = 0;
        System.out.print("Digite o cnpj: ");
        String cnpj = entrada.next();
        for(Fornecedor f: lista){
            if(f.getCnpj().equalsIgnoreCase(cnpj)){
                System.out.print(f.toString());
                flag = 1;
                break;
            }
        }
        if(flag == 0){
            System.out.println("Empresa não cadastrada");
        }
    }
    
}
