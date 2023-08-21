import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    

    /*Criar uma conta (agencia, conta e nome)
     *      limitar nome a 12 caracteres
     *      numeros de conta gerados automaticamente
     * Sacar valores
     *      nao sacar mais doq o disponivel
     * Depositar
     * Informar ao usuário todas as transações
     */


    public static void main(String[] args) throws Exception {
        int escolha = -1;
        
        Scanner teclado = new Scanner(System.in); 
        List<Account> accountsList = new ArrayList<>();
        Transacoes transacao = new Transacoes();
        do{
            Terminal terminal = new Terminal();
            terminal.getMenu();
        
            escolha = 1;
            escolha = 4;
            //teclado.nextLine();

            Account account = new Account(accountsList);
            switch(escolha){
                case 0: 
                    Terminal.clearScreen();
                    System.out.println("Fim de execução");
                    break;
                case 1: 
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Digite seu nome: ");
                    
                    String Name = reader.readLine();
                    
                    int setreturn = account.setName(Name);
                    
                    if(setreturn ==-1){
                        Terminal.clearScreen();
                        System.out.println("Erro ao criar conta: Tamanho máximo de 20 Caracteres.");
                    }if(setreturn == -2){
                            Terminal.clearScreen();
                            System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                            System.out.println("Erro ao criar conta: Nome ja existente.\n");
                        } 
                        else{
                            Terminal.clearScreen();
                            //Define a criação das contas
                            transacao.criaConta(Name, account);
                        
                            //Retorna o status de criação da conta
                            transacao.contaCriada(account);
                            
                        }
                    
                    break;
            
                case 2:
                        if(account.accountsList.isEmpty()){
                            Terminal.clearScreen();
                            System.out.println("Nenhuma conta encontrada");
                        }else{
                            Terminal.clearScreen();
                            //Chama a listagem de contas
                            transacao.getContas(account.accountsList);
                        }
                    break;
                
                case 3:
                        System.out.println("Digite o nome da conta a buscar:");
                       
                        String Busca = teclado.nextLine();
                        int flagBusca = transacao.buscaConta(Busca, accountsList); 
              
                        
                        if(flagBusca!=1)
                            System.out.println("Conta nao encontrada!");
                        break;
               
                
                case 4:
                        if(transacao.depositaConta(accountsList) == 1){
                            System.out.println("Deposito realizado com sucesso");
                            System.out.println(account.getSaldo()); 
                        }
                        else
                            System.out.println("Erro ao realizar deposito");
                        break;

                case 5:
                        System.out.println("Digite a conta a fazer saque:");
                        System.out.print("Nome:");
                        String SaqueName = teclado.nextLine();
                        System.out.print("Agencia:");
                        int SaqueAg = teclado.nextInt();
                        teclado.nextLine();
                        System.out.print("Conta:");
                        String SaqueAcc = teclado.nextLine();
                        System.out.println("Valor do saque: ");
                        double SaqueValor = teclado.nextDouble();

                        int flagSaque = 0;
                        for(Account consultaSaque : accountsList){
                            if(consultaSaque.getName().equalsIgnoreCase(SaqueName)){
                                if(consultaSaque.getAg() == SaqueAg){
                                    if(consultaSaque.getAcc().equals(SaqueAcc)){
                                        if(consultaSaque.getSaldo() >= SaqueValor){
                                            consultaSaque.setSaldo(consultaSaque.getSaldo()-SaqueValor);
                                            flagSaque = 1;
                                        }
                                    }
                                }
                            }
                        }
                        if(flagSaque == 1){
                            System.out.println("Saque feito com sucesso.");
                            break;
                        }else{
                            System.out.println("Falha no saque.");
                            break;
                        }
                        

                default: 
                    System.out.println("Opção inválida");
                    break;
                    
            }
            
        }while(escolha != 0);  
        teclado.close();  
    }


}

