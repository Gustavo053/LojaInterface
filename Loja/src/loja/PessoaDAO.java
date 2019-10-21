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
public class PessoaDAO implements DAO{
    private ArrayList<Pessoa> lista = new ArrayList<>();
    private Scanner entrada = new Scanner(System.in);
    private static PessoaDAO pessoa;
    
    private PessoaDAO(){
        
    }
    
    public static synchronized PessoaDAO getSingleton(){
        if(pessoa == null){
            pessoa = new PessoaDAO();
        }
        return pessoa;
    }
    
    @Override
    public void menu() {
        int opcao;
        do{
            System.out.println("\t loja");
            System.out.println("1-Cadastrar pessoas");
            System.out.println("2-Remover pessoa");
            System.out.println("3-Buscar pessoa");
            System.out.println("4-Adicionar Produtividade");
            System.out.println("5-Gerar Folha Pagamento");
            System.out.println("6-Sair");
            System.out.print(": ");
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
                    adicionarProdutividade();
                    break;
                case 5:
                    gerarFolhaPagamento();
                    break;
                case 6:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Por favor, digite uma opção válida");
            }
        }while(opcao != 6);
    }

    @Override
    public void cadastrar() {
        int opcao;
        do{
            System.out.println("1-Cliente");
            System.out.println("2-Administrativo");
            System.out.println("3-Vendedor");
            System.out.println("4-Voltar");
            System.out.print(": ");
            opcao = entrada.nextInt();
            switch(opcao){
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome1 = entrada.next();
                    System.out.print("Digite o CPF: ");
                    String cpf1 = entrada.next();
                    System.out.print("Digite o código: ");
                    String codigo = entrada.next();
                    lista.add(new Cliente(nome1, cpf1, codigo));
                    break;
                case 2:
                    System.out.print("Digite o nome: ");
                    String nome2 = entrada.next();
                    System.out.print("Digite o CPF: ");
                    String cpf2 = entrada.next();
                    System.out.print("Digite a matrícula: ");
                    int matricula1 = entrada.nextInt();
                    System.out.print("Digite o salário: ");
                    double salario1 = entrada.nextDouble();
                    System.out.print("Digite as horas: ");
                    double horas = entrada.nextDouble();
                    lista.add(new Administrativo(nome2, cpf2, matricula1, salario1, horas));
                    break;   
                case 3:
                    System.out.print("Digite o nome: ");
                    String nome3 = entrada.next();
                    System.out.print("Digite o CPF: ");
                    String cpf3 = entrada.next();
                    System.out.print("Digite a matrícula: ");
                    int matricula2 = entrada.nextInt();
                    System.out.print("Digite o salário: ");
                    double salario2 = entrada.nextDouble();
                    System.out.print("Digite as vendas: ");
                    double vendas = entrada.nextDouble();
                    lista.add(new Vendedor(nome3, cpf3, matricula2, salario2, vendas));
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Por favor, digite uma opção válida");  
            }
        }while(opcao != 4);
    }

    @Override
    public void remover() {
        System.out.print("Informe o cpf: ");
        String cpf = entrada.next();
        if(buscar(cpf) != null){
            lista.remove(buscar(cpf));
        }else{
            System.out.println("Usuário não encontrado");
        }
    }

    @Override
    public void buscar() {
        System.out.print("Informe o cpf: ");
        String cpf = entrada.next();
        if(buscar(cpf) != null){
            System.out.println(buscar(cpf).toString());
        }else{
            System.out.println("Usuário não encontrado");
        }
    }
    
    private Pessoa buscar(String cpf){
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getCpf().equalsIgnoreCase(cpf)){
                return lista.get(i);
            }
        }
        return null;
    }
    
    private void adicionarProdutividade(){
        System.out.print("Informe o cpf: ");
        String cpf = entrada.next();
        Pessoa p = buscar(cpf);
        if(p != null){
            p = buscar(cpf);
            System.out.print("Digite a produtividade: ");
            double produtividade = entrada.nextDouble();
            if(p instanceof Administrativo){
                ((Administrativo) p).setHoras(produtividade);
            }else if(p instanceof Vendedor){
                ((Vendedor) p).setVendas(produtividade);
            }else{
                System.out.println("Um cliente não pode usar essa função");
            }
        }else{
            System.out.println("Usuário não encontrado");
        }
    }
    
    private void gerarFolhaPagamento(){
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i) instanceof Administrativo){
                ((Administrativo) lista.get(i)).calculaPagamento();
                System.out.println(((Administrativo) lista.get(i)).toString());
            }else if(lista.get(i) instanceof Vendedor){
                ((Vendedor) lista.get(i)).calculaPagamento();
                System.out.println(((Vendedor) lista.get(i)).toString());
            }else{
                System.out.println("Um cliente não pode usar essa função");
            }
        }
    } 
    
}
