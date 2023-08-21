import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Transacoes {
    


    public void criaConta(String Name, Account account){
        account.setName(Name.toUpperCase());
        account.setAg();
        account.setAcc();
        account.setSaldo(0);
        account.accountsList.add(account);
    }
    
    
    public void contaCriada(Account account){
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("\nCONTA CRIADA:");
        System.out.printf("\tNOME: %s\n", account.getName());
        System.out.printf("\tAGENCIA: %d\n", account.getAg());
        System.out.printf("\tCONTA: %s\n\n", account.getAcc());
        System.out.printf("\tSALDO: %.2f\n\n", account.getSaldo());
    }

    public void getContas(List<Account> accountsList){
        for(Account contas : accountsList){
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("\tContas criadas:");
            System.out.printf("\tNOME: %s\n", contas.getName());
            System.out.printf("\tAGENCIA: %d\n", contas.getAg());
            System.out.printf("\tCONTA: %s\n\n", contas.getAcc());
            }
    }

    public int buscaConta(String Busca, List<Account> accountsList){
        int flagBusca = 0;
        for (Account account2 : accountsList) {
            if(account2.getName().equalsIgnoreCase(Busca)){
                System.out.println("Conta encontrada: ");
                System.out.printf("\tNOME: %s\n", account2.getName());
                System.out.printf("\tAGENCIA: %d\n", account2.getAg());
                System.out.printf("\tCONTA: %s\n\n", account2.getAcc());
                System.out.printf("\tSALDO: %.2f\n\n", account2.getSaldo());
                flagBusca = 1;
            }
        }
        return flagBusca;
    }

    public int depositaConta(List<Account> accountsList) throws IOException{
        BufferedReader bufferDeposito = new BufferedReader(new InputStreamReader(System.in));
        Scanner scannerDeposito = new Scanner(System.in);
        System.out.println("Digite os dados da conta a fazer o deposito:");
        System.out.print("Nome:");
        String DepName = bufferDeposito.readLine();
        System.out.print("Agencia:");
        int DepAgg = scannerDeposito.nextInt();
        System.out.print("Conta:");
        String DepAcc = bufferDeposito.readLine();
                        
        System.out.println("Valor a depositar: ");
        double DepositoValor = scannerDeposito.nextDouble();
        
        int flagDeposito = 0;
        for(Account consultaDeposito : accountsList){
            if(consultaDeposito.getName().equalsIgnoreCase(DepName)){
                if(consultaDeposito.getAg() == DepAgg){
                    if(consultaDeposito.getAcc().equals(DepAcc)){
                        consultaDeposito.setSaldo(consultaDeposito.getSaldo()+DepositoValor);
                        flagDeposito = 1;
                    }
                }
            }
        }
        scannerDeposito.close();
        return flagDeposito;               
    }


}
