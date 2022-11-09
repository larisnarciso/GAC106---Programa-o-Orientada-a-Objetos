/**
 * Essa é a classe principal da aplicacao "Life Is Strange".
 * "Life Is Strange" é um jogo de aventura muito simples, baseado em texto.
 * 
 * Usuários podem caminhar em um cenário. E é tudo! Ele realmente precisa ser 
 * estendido para fazer algo interessante!
 * 
 * Para jogar esse jogo, crie uma instancia dessa classe e chame o método "jogar".
 * 
 * Essa classe principal cria e inicializa todas as outras: ela cria os ambientes, 
 * cria o analisador e começa o jogo. Ela também avalia e  executa os comandos que 
 * o analisador retorna.
 * 
 * @author  Michael Kölling and David J. Barnes (traduzido e adaptado por Julio César Alves)
 */

public class Jogo {
    // analisador de comandos do jogo
    private Analisador analisador;
    // ambiente onde se encontra o jogador
    private Ambiente ambienteAtual;

    private Personagem personagem;
        
    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo()  {
        criarAmbientes();
        analisador = new Analisador();
        personagem = new Personagem("Max Caulfield");
    }

    /**
     * Cria todos os ambientes e liga as saidas deles
     */
    private void criarAmbientes() {
        Ambiente campus, corredor, escritorio, sala102, sala104, dormitorio, quarto;
      
        // itens
        // new Item("chave", "chave dormitorio", 0));

        // cria os ambientes
        campus = new Ambiente("no campus da Academia Blackwell, há alguns estudantes sentados na grama");
        corredor = new Ambiente("no corredor da Academia Blackwell, há vários estudantes indo e vindo das aulas e conversando", new Item ("bilhete", "bilhete com número escrito: 0829", 0));
        escritorio = new Ambiente("no escritorio do Diretor Wells");
        sala102 = new Ambiente("na sala 102 da disciplina de Artes do prof. Mark Jefferson", new Item ("fotos", "fotos da Rachel Amber dentro da gaveta da mesa", 0));
        sala104 = new Ambiente("na sala 104 da disciplina de Ciências da prof. Michelle Grant");
        dormitorio = new Ambiente("de fora do dormitorio da Academia Blackwell");
        quarto = new Ambiente("no quarto de Nathan", new Item ("celular", "celular bloqueado, pede uma senha de 4 dígitos", 1));
        
        // inicializa as saidas dos ambientes
        campus.ajustarSaidas("leste", corredor);
        campus.ajustarSaidas("sul", dormitorio);

        corredor.ajustarSaidas("oeste",  campus);
        corredor.ajustarSaidas("norte",  sala102);
        corredor.ajustarSaidas("sul", sala104);
        corredor.ajustarSaidas("leste", escritorio);

        dormitorio.ajustarSaidas("norte", campus);
        dormitorio.ajustarSaidas("leste", quarto);

        quarto.ajustarSaidas("oeste", dormitorio);

        sala102.ajustarSaidas("sul",  corredor);

        sala104.ajustarSaidas("norte", corredor);

        escritorio.ajustarSaidas("oeste", corredor);


        ambienteAtual = campus;  // o jogo comeca em frente à campus
    }

    /**
     *  Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar()  {
        imprimirBoasVindas();

        // Entra no loop de comando principal. Aqui nós repetidamente lemos comandos e 
        // os executamos até o jogo terminar.
                
        boolean terminado = false;
        while (! terminado) {            
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
            if (personagem.mochilaCheia()){
                terminado = true;
            }
        }
        System.out.println("Obrigado por jogar. Até mais!");
    }

    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas() {
        System.out.println();
        System.out.println("Bem-vindo ao jogo Life is Strange!");
        System.out.println("Life is Strange é um novo jogo de aventura.");
        System.out.println("Você joga com a Max Caulfield e tenta ajudar sua amiga Chloe Price a encontrar o culpado pelo desaparecimento de Rachel Amber");
        System.out.println("Digite 'ajuda' se voce precisar de ajuda.");
        System.out.println();
        
        imprimirLocalizacaoAtual();
    }

    private void imprimirLocalizacaoAtual(){

        System.out.println("Voce esta " + ambienteAtual.getDescricao());
        System.out.println("Saidas: " + ambienteAtual.getSaidas());
        System.out.println();
    }

    /**
     * Dado um comando, processa-o (ou seja, executa-o)
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean processarComando(Comando comando)  {
        boolean querSair = false;

        if(comando.ehDesconhecido()) {
            System.out.println("Eu nao entendi o que voce disse...");
            return false;
        }

        String palavraDeComando = comando.getPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            imprimirAjuda();
        }
        else if (palavraDeComando.equals("ir")) {
            irParaAmbiente(comando);
        }
        else if (palavraDeComando.equals("sair")) {
            querSair = sair(comando);
        }
        else if (palavraDeComando.equals("observar")){
            observar(comando);
        }
        else if (palavraDeComando.equals("pegar")){
            pegar(comando);
        }

        return querSair;
    }
    
    /**
     * Exibe informações de ajuda.
     * Aqui nós imprimimos algo bobo e enigmático e a lista de  palavras de comando
     */
    private void imprimirAjuda()  {
        System.out.println("Voce esta perdido. Voce esta sozinho. Voce caminha");
        System.out.println("pela ilha.");
        System.out.println();
        System.out.println("Suas palavras de comando sao:");
        System.out.println("   " + analisador.getComandos());
    }
   
    private void pegar(Comando comando){  
        if (!comando.temSegundaPalavra()){
            System.out.println("Pegar o que?");
            return;
        }

        String item = comando.getSegundaPalavra();

        if (item.equals(ambienteAtual.getItem())){
            Item itemColetado = ambienteAtual.pegarItem();
            personagem.adicionarItem(itemColetado);

            System.out.println("Você pegou o item " + item);
        }else{
            System.out.println("Não há item no ambiente");
        }
    }

    private void observar(Comando comando){
        imprimirLocalizacaoAtual();
        System.out.println(ambienteAtual.getDescricaoLonga());

        String mochila = personagem.descricaoMochila();
        if(mochila != null){
            System.out.println(mochila);
        }
    }


    /** 
     * Tenta ir em uma direcao. Se existe uma saída para lá entra no novo ambiente, 
     * caso contrário imprime mensagem de erro.
     */
    private void irParaAmbiente(Comando comando)  {
        // se não há segunda palavra, não sabemos pra onde ir...
        if(!comando.temSegundaPalavra()) {            
            System.out.println("Ir pra onde?");
            return;
        }

        String direcao = comando.getSegundaPalavra();

        // Tenta sair do ambiente atual
        Ambiente proximoAmbiente = null;
        proximoAmbiente = ambienteAtual.getAmbiente(direcao);

        if (proximoAmbiente == null) {
            System.out.println("Nao ha passagem!");
        }
        else {
            ambienteAtual = proximoAmbiente;
            
            imprimirLocalizacaoAtual();
        }
    }

    /** 
     * "Sair" foi digitado. Verifica o resto do comando pra ver se nós queremos 
     * realmente sair do jogo.
     * @return true, se este comando sai do jogo, false, caso contrário.
     */
    private boolean sair(Comando comando)  {
        if(!comando.temSegundaPalavra()) {
            System.out.println("Sair o que?");
            return false;
        }
        else {
            return true;  // sinaliza que nós realmente queremos sair
        }
    }
}
