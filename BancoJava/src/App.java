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
        do{
            Terminal terminal = new Terminal();
            terminal.getMenu();
        
            escolha = teclado.nextInt();
            teclado.nextLine();

            Account account = new Account(accountsList);
            switch(escolha){
                case 0: 
                    Terminal.clearScreen();
                    System.out.println("Fim de execução");
                    break;
                case 1: 
                    System.out.println("Digite seu nome: ");
                    String Name = teclado.nextLine();
                    int setreturn = account.setName(Name);
                
                    if(setreturn ==-1){
                        Terminal.clearScreen();
                        System.out.println("Erro ao criar conta: Tamanho máximo de 20 Caracteres.");
                        break;
                    }else{
                        Terminal.clearScreen();
                        System.out.println("Conta criada com sucesso");
                        account.setName(Name.toUpperCase());
                        account.setAg();
                        account.setAcc();
                        account.accountsList.add(account);

                        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        System.out.println("\nCONTA CRIADA:");
                        System.out.printf("\tNOME: %s\n", account.getName());
                        System.out.printf("\tAGENCIA: %d\n", account.getAg());
                        System.out.printf("\tAGENCIA + CONTA: %s\n\n", account.getAcc());
                        break;
                    }
            
                case 2:
                        if(account.accountsList.isEmpty()){
                            Terminal.clearScreen();
                            System.out.println("Nenhuma conta encontrada");
                        }else{
                            Terminal.clearScreen();
                            for(Account contas : account.accountsList){
                            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                            System.out.println("\tContas criadas:");
                            System.out.printf("\tNOME: %s\n", contas.getName());
                            System.out.printf("\tAGENCIA: %d\n", contas.getAg());
                            System.out.printf("\tAGENCIA + CONTA: %s\n\n", contas.getAcc());
                            }
                        }
                    break;
                
                case 3:
                        System.out.println("Digite o nome da conta a buscar:");
                        Name = teclado.nextLine();
                        for (Account account2 : accountsList) {
                            if(account.getName().equalsIgnoreCase(Name)){
                                System.out.println("Conta encontrada: ");
                                System.out.printf("\tNOME: %s\n", account2.getName());
                                System.out.printf("\tAGENCIA: %d\n", account2.getAg());
                                System.out.printf("\tAGENCIA + CONTA: %s\n\n", account2.getAcc());
                            }else
                                System.out.println("Conta não encontrada");

                        }

                default: 
                    System.out.println("Opção invalida");
                    break;
                    
            }
            
        }while(escolha != 0);  
       
        teclado.close();   
    }
}

