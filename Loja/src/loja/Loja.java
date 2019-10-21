/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja;
import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class Loja {
    private DAO dao;
    private Scanner entrada = new Scanner(System.in);
    
    public void menu(){
        int opcao;
        do{
            System.out.print("\n\tMENU PRINCIPAL\n1-Pessoa\n2-Fornecedor\n3-Sair\n: ");
            opcao = entrada.nextInt();
            switch(opcao){
                case 1:
                    dao = PessoaDAO.getSingleton();
                    break;
                case 2:
                    dao = FornecedorDAO.getSingleton();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Por favor, digite uma opção válida");
            }
            dao.menu();
        }while(opcao != 3);
    }
}
