import java.util.HashMap;

/**
 * Classe Ambiente - um ambiente em um jogo adventure.
 *
 * Esta classe é parte da aplicação "World of Zuul".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Um "Ambiente" representa uma localização no cenário do jogo. Ele é conectado aos 
 * outros ambientes através de saídas. As saídas são nomeadas como norte, sul, leste 
 * e oeste. Para cada direção, o ambiente guarda uma referência para o ambiente vizinho, 
 * ou null se não há saída naquela direção.
 * 
 * @author  Michael Kölling and David J. Barnes (traduzido e adaptado por Julio César Alves)
 */
public class Ambiente  {
    // descrição do ambiente
    private String descricao;
    // ambientes visinhos de acordo com a direção
    private HashMap<String, Ambiente> saidas;
    private Item item;
    

    /**
     * Cria um ambiente com a "descricao" passada. Inicialmente, ele não tem saidas. 
     * "descricao" eh algo como "uma cozinha" ou "um jardim aberto".
     * @param descricao A descrição do ambiente.
     */
    public Ambiente(String descricao)  {
        this.descricao = descricao;
        saidas = new HashMap<String, Ambiente>();
    }

    public Ambiente (String descricao, Item item){
        this(descricao);
        this.item = item;
    }

    /**
     * Define as saídas do ambiente. Cada direção ou leva a um outro ambiente ou é null 
     * (indicando que não tem nenhuma saída para lá).
     * @param norte A saída norte.
     * @param leste A saída leste.
     * @param sul A saída sul.
     * @param oeste A saída oeste.
     */
    public void ajustarSaidas(String direcao, Ambiente ambiente){
        saidas.put(direcao, ambiente);
    }
    
    /**
     * @return A descrição do ambiente.
     */
    public String getDescricao() {
        return descricao;
    }

    public boolean encontraItem(){
        if (item != null){
            return true;
        }else{
            return false;
        }
    }
    
    public String getDescricaoLonga(){
        if (encontraItem()){
            System.out.print("Há um(a) " + item.getDescricao() + " ");
        }else{
            System.out.print("Não há nada ");
        }
        return descricao;
    }

    public String getItem(){
        if (encontraItem()){
            return item.getNomeItem();
        }
        return null;
    }

    public Item pegarItem(){
        Item aux = item;
        item = null;
        return aux;
    }

    
    public Ambiente getAmbiente(String direcao){
        return saidas.get(direcao);
    }

    public String getSaidas(){
        String textoSaidas = "";
        for (String direcao : saidas.keySet()){
            textoSaidas = textoSaidas + direcao + " ";
        }
        return textoSaidas;
    }

}

