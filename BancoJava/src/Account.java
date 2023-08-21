import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Account {
    //Atributos da classe
    private String Name;
    private String Acc;
    private int Ag;
    private double Saldo;

    

    //Valor que define o tamanho maximo do nome
    private static final int MAX_LENGTH = 20;

    //Declaração da lista de contas
    public List<Account> accountsList = new ArrayList<>();

    //Construtor da lista de contas
    public Account(List<Account> accountsList) {
        this.accountsList = accountsList;
    }
    
    /*Construtor
    public Account(String Name, int Acc, int Ag){
        Name = this.Name;
        Acc = this.Acc;
        Ag = this.Ag;
        Saldo = this.Saldo;
    }
    */

    //Getters
    public String getName() {
        return Name;
    }
    public String getAcc() {
        return Acc;
    }
    public int getAg() {
        return Ag;
    }
    public double getSaldo() {
        return Saldo;
    }

    //Setters
    public int setName(String name) {
        //Caso o tamanho do nome exceda o tamanho maximo definido, retorna -1 como erro
        //Caso nome ja existente retorna -2 (tratar exception)
        if(name.length()>MAX_LENGTH){
            return -1;
        }
        for(Account account : accountsList){
            if(account.getName().equalsIgnoreCase(name)){
                return -2;
            }
        }
        
        Name = name;
        return 0;
    }
    public void setAcc() {
        Random acc = new Random();
        //Definir tamanho maximo do numero
        int MaxRange = 10000;
        int MinRange = 1000;
        int conta = acc.nextInt(MaxRange - MinRange) + MinRange;
        
        //Concatenação da agencia + conta para ficar mais realista
        Acc = "0" + conta;
    }
    public void setAg() {
        //Cenario onde um banco possui 5 agencias
        Random agg = new Random();
        Ag = 1 + agg.nextInt(5);
    }

    public void setSaldo(double saldo) {
        Saldo = saldo;
    }
}
