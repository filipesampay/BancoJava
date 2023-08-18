public class Terminal {
    public static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getMenu(){
            System.out.println("\t=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("\t Bem vindo ao banco \t");
            System.out.println("\t Criar conta [1]");
            System.out.println("\t Listar contas [2]");
            System.out.println("\t Listar conta específica [3]");
            System.out.println("\t Depositar dinheiro [4]");
            System.out.println("\t Sacar dinheiro [5]");
            System.out.println("\t Sair [0]");
            System.out.println("\t=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }
}
