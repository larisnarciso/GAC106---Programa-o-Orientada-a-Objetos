import java.util.Scanner;

/*
 * Classe que trata a interface com o usuário (menu de opções)
 */
public class InterfaceUsuario {

    // Objeto do zoologico 
    private Zoologico zoologico;

    // Scanner para obter dados do usuário via terminal
    private Scanner entrada;

    /* 
     * Construtor da classe
     */
    public InterfaceUsuario() {
        entrada = new Scanner(System.in);
        zoologico = new Zoologico();
    }

    /*
     * Método que trata o loop de exibição e tratamento do menu
     */
    public void executar() {
        int opcao;
        do {
            exibirMenu();
            
            System.out.println("\nDigite sua opção: ");
            opcao = Integer.parseInt(entrada.nextLine());

            tratarMenu(opcao);

        } while (opcao != 5);

        // fecha o objeto Scanner para liberar os seus recursos
        entrada.close();
    }

    /*
     * Método que exibe as opções de menu
     */
    public void exibirMenu() {
        System.out.println("1 - Cadastrar animal");
        System.out.println("2 - Descrever animal");
        System.out.println("3 - Listar animais");        
        System.out.println("4 - Listar animais completo");
        System.out.println("5 - Sair");
    }

    /*
     * Método que trata uma opção de menu escolhida pelo usuário
     */
    private void tratarMenu(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarAnimal();
                break;
            case 2:
                descreverAnimal();
                break;
            case 3:
                listarAnimais();
                break;
            case 4:
                listarAnimaisCompleto();
                break;
            case 5:
                System.out.println("Saindo do programa...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        // se o usuário não estiver saindo do programa, pede para ele digitar ENTER antes de exibir o menu novamente
        if (opcao != 5) {
            System.out.println("\nDigite ENTER para continuar!");
            entrada.nextLine();
        }
    }

    /*
     * Método auxiliar que obtém um Inteiro do usuário
     */
     private int pedirNum(String instrucao){
        System.out.println(instrucao + ": ");
        int informacao = Integer.parseInt(entrada.nextLine());
        return informacao;
     }

    /*
     * Método auxiliar que obtém uma String do usuário
     */
    private String pedirString(String instrucao) {
        System.out.print(instrucao + ": ");
        String informacao = entrada.nextLine();
        return informacao;
    }


    /*
     * Trata a opção de menu: Cadastrar Animal
     */
    private void cadastrarAnimal() {
        String nome, corPelo;
        int especie, animal, voo;
        boolean adicionado = false;

        nome = pedirString("Digite o nome do animal");
        especie = pedirNum("Qual a especie do animal (1- ave, 2- mamifero)?");

        switch(especie){
            case 1:
                animal = pedirNum("Qual animal (1- galinha, 2- águia)?");
                voo = pedirNum("Digite se este animal voa bem (1- sim, 2- nao): ");
                boolean qldVoo = (voo == 1);

                if (animal == 1){
                    zoologico.adicionarGalinha(nome, qldVoo);
                    adicionado = true;
                } else if (animal == 2) {
                    zoologico.adicionarAguia(nome, qldVoo);
                    adicionado = true;
                } else {
                    System.out.println("Tipo de animal invalido");
                }
            case 2:
                animal = pedirNum("Qual animal (1- lobo, 2- gato)?");
                corPelo = pedirString("Digite a cor do pelo");

                if (animal == 1){
                    zoologico.adicionarLobo(nome, corPelo);
                    adicionado = true;
                } else if (animal == 2) {
                    zoologico.adicionarGato(nome, corPelo);
                    adicionado = true;
                } else {
                    System.out.println("Tipo de animal invalido");
                }
        }
        if (adicionado){
            System.out.println("Animal adicionado!");
        }                
    }

    /*
     * Exibe a descrição completa do animal digitado
     */
    private void descreverAnimal() {
        String nome = pedirString("Digite o nome do animal");
        System.out.println(zoologico.getDescricaoLongaAnimal(nome));
    }

    /*
     * Lista os animais do zoologico com uma descrição curta
     */
    private void listarAnimais() {
        System.out.println(zoologico.getDescricaoZoologico());
    }

    /*
     * Lista os animais do zoologico com uma descrição longa
     */
    private void listarAnimaisCompleto() {
        System.out.println(zoologico.getDescricaoLongaZoologico());
    }
}