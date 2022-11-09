/**
    Classe que define um animal. Superclasse para os demais tipos de animais.
    Um animal tem nome, especie, som e quantidade de patas
 */

public class Animal {
    private String nome;
    private String especie;
    private String som;
    private int qtdPata;

    public Animal(String nome, String especie, String som, int qtdPata){
        this.nome = nome;
        this.especie = especie;
        this.som = som;
        this.qtdPata = qtdPata;
    }

    public String getNome(){
        return nome; 
    }

    public String getEspecie(){
        return especie;
    }

    public String getSom(){
        return som;
    }

    public int getQtdPata(){
        return qtdPata;
    }

    public String getDescricao(){
        String descricao;
        descricao = nome + " é um " + especie;
        return descricao;
    }

    public String getDescricaoLonga(){
        String descricao;
        descricao = nome + " é um " + especie + " que faz " + som;
        return descricao;
    }
}
