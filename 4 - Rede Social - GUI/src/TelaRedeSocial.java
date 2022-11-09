
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Classe criada para implementar a interface gráfica da Rede Social.
 * O objetivo dessa implementação é didático! 
 * - Exercitar e apresentar conceitos de GUIs (Interfaces Gráficas de Usuário) 
 *   e Tratamento de Exceções
 * 
 * @author Julio Cesar Alves
 */
public class TelaRedeSocial {
    // Janela da nossa tela
    private JFrame janela;
    // Caixa de texto para exibir o feed de noticiai    
    private JTextArea areaTextoFeed;    
    // Botão para postar uma mensagem no feed
    private JButton botaoPostarMensagem;
    // Botão para curtir uma mensagem do feed
    private JButton botaoCurtir;
    // Botão para comentar uma mensagem do feed
    private JButton botaoComentar;
    // Botão para atualizar o feed
    private JButton botaoAtualizar;
    // Caixa de seleção 
    private JComboBox<String> caixaSelecao;
    // Atributo booleano para informar se os dados estao sendo carregados ou não
    private boolean carregando;
    
    // Objeto que representa a Regra de Negócios (a lógica da Rede Social em si)
    private FeedNoticias feed;
    
    /**
     * Construtor da classe: cria o feed, os componentes e monta a tela.
    */
    public TelaRedeSocial() {
        feed = new FeedNoticias();
        carregando = false;
        construirJanela();
    }

    /**
     * Constroi os componentes e monta a janela
    */
    private void construirJanela() throws HeadlessException {
        janela = new JFrame("GUI - Rede Social");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        criarComponentes();
        
        montarJanela();
    }

    /**
     * Cria os componentes da tela e faz a inscrição nos eventos necessários
     */
    private void criarComponentes() {
        // criando os componentes
        areaTextoFeed = new JTextArea();
        areaTextoFeed.setFont(new Font("Roboto", Font.BOLD, 12));
        botaoPostarMensagem = new JButton("Postar Mensagem");
        botaoCurtir = new JButton("Curtir");
        botaoComentar = new JButton("Comentar");
        botaoAtualizar = new JButton("Atualizar");
        caixaSelecao = new JComboBox<String>();
        preencherCaixaAutores();
        
        // impede que o usuário edite a área de texto do feed
        areaTextoFeed.setEditable(false);
        
        // adiciona o método que tratará o evento de clique no botão Postar Mensagem
        botaoPostarMensagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                postarMensagem();
            }            
        });
        
        // adiciona o método que tratará o evento de clique no botão Curtir
        botaoCurtir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                curtirMensagem();
            }
        });

        // adiciona o metodo que tratará o evento de clique do botão Comentar
        botaoComentar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                comentarMensagem();
            }
        });

        // adiciona o método que tratará o evento de clique do botão Atualizar
        botaoAtualizar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                atualizarAreaTextoFeed();
            }
        });

        // adiciona o método que tratará o evento de clique da caixa de Seleção
        caixaSelecao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(!carregando){
                    atualizarAreaTextoFeed();
                }
            }
        });
    }

    /**
     * Monta a janela
     */
    private void montarJanela() {
        janela.setSize(500, 600);
        
        // Para mais detalhes sobre o BorderLayout acesse:
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html
        janela.setLayout(new BorderLayout());
        
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new BoxLayout(painelCentral, BoxLayout.Y_AXIS));
        painelCentral.add(new JLabel("Feed de Notícias"));
        JScrollPane scroll;
        scroll = new JScrollPane(areaTextoFeed);
        painelCentral.add(scroll);
        janela.add(painelCentral, BorderLayout.CENTER);
        
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        painelBotoes.add(botaoPostarMensagem);
        painelBotoes.add(botaoCurtir);
        painelBotoes.add(botaoComentar);
        painelBotoes.add(botaoAtualizar);
        janela.add(painelBotoes, BorderLayout.SOUTH);

        JPanel painelSuperior = new JPanel();
        painelSuperior.setLayout(new FlowLayout());
        painelSuperior.add(new JLabel("Filtragem por Autores:"));
        painelSuperior.add(caixaSelecao);
        janela.add(painelSuperior, BorderLayout.NORTH);
    }
    
    /*
     * Exibe a tela da Rede Social
    */
    public void exibir() {
        janela.setVisible(true);
    }
    
    /**
     * Posta uma mensagem no feed. Solicita o autor e a mensagem ao usuário,
     * posta no Feed e atualiza a área de texto de exibição do feed.
     */
    private void postarMensagem() {
        String autor = JOptionPane.showInputDialog("Autor da mensagem");
        String mensagem = JOptionPane.showInputDialog("Texto da mensagem");        
        feed.postarMensagemTexto(autor, mensagem);   
        preencherCaixaAutores();     
        atualizarAreaTextoFeed();
    }
    
    /**
     * Curte uma mensagem. Solicita o identificador da mensagem ao usuário,
     * curte a mensagem e atualiza a área de texto de exibição do feed.
     */
    private void curtirMensagem() {
        if (feed.nroMensagens() != 0){
            int idMensagem = Integer.parseInt(JOptionPane.showInputDialog("Id da mensagem"));
            try{
                feed.curtir(idMensagem);
                atualizarAreaTextoFeed();
            }catch(MensagemNaoEncontradaException e){
                JOptionPane.showMessageDialog(janela, "ID digitada: " + e.getId()  +" - Nao possui mensagem com esta ID", "Erro", JOptionPane.ERROR_MESSAGE);
                // Continuará pedindo o identificador até ele digitar um identificador válido
                curtirMensagem();
            }
        }else{
            JOptionPane.showMessageDialog(janela, "Erro! Nenhuma mensagem publicada ainda", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Comenta uma mensagem. Solicita o identificador da mensagem ao usuário,
     * comenta a mensagem e atualiza a área de texto de exibição do feed.
     */

    private void comentarMensagem(){
        int idMensagem = Integer.parseInt(JOptionPane.showInputDialog("id da mensagem"));
        String comentario = JOptionPane.showInputDialog("Texto do comentario");
        feed.comentar(idMensagem, comentario);
        atualizarAreaTextoFeed();
    }

    /**
     * Atualiza a área de texto de exibição do Feed.
     */
    private void atualizarAreaTextoFeed() {  
        // Limpa a lista de publicações
        areaTextoFeed.setText("");

        // Obtém as publicações do feed de notícias
        List<Publicacao> publicacoes = feed.getPublicacoes();

        String autor = caixaSelecao.getItemAt(caixaSelecao.getSelectedIndex());
        if (autor.equals("Todos")){
            publicacoes = feed.getPublicacoes();
        }else{
            publicacoes = feed.getPublicacoes(autor);
        }

        // Percorre a lista de publicações adicionando na área de texto o texto da publicação
        for (Publicacao publicacao : publicacoes) {
            areaTextoFeed.append(publicacao.getTextoExibicao());
        }
    }   

    /**
     * Preenche a caixa de seleção
     */
    private void preencherCaixaAutores(){
        carregando = true;
        caixaSelecao.removeAllItems();
        caixaSelecao.addItem("Todos");
        for (String autor : feed.getAutores()){
            caixaSelecao.addItem(autor);
        }
        carregando = false;
    }
}
