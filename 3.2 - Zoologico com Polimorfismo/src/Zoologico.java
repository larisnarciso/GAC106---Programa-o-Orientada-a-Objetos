import java.util.ArrayList;

public class Zoologico{
  private ArrayList<Animal> animais;        // coleção de animais do zoologico

  /**
    Construtor
  */
  public Zoologico(){
    animais = new ArrayList<>();
  }

  /**
    Adiciona animais Lobo, Gato, Galinha e Aguia no Zoologico.
  */

  public void adicionarLobo(String nome, String corPelo){
    Lobo lobo = new Lobo(nome, corPelo);
    animais.add(lobo);
  }

  public void adicionarGato(String nome, String corPelo){
    Gato gato = new Gato(nome, corPelo);
    animais.add(gato);
  }

  public void adicionarGalinha(String nome, boolean qldVoo){
    Galinha galinha = new Galinha(nome, qldVoo);
    animais.add(galinha);
  }

  public void adicionarAguia(String nome, boolean qldVoo){
    Aguia aguia = new Aguia(nome, qldVoo);
    animais.add(aguia);
  }

  /**
    Retorna uma String com a descrição longa de um animal em especifico do zoologico.
    @return Descrição longa de um animal do zoologico.
  */
  public String getDescricaoLongaAnimal(String nome){
    String descricao = "Não está cadastrado!";

    for (Animal animal : animais){
      if (animal.getNome().equals(nome)){
        descricao = animal.getDescricaoLonga();
      }
    }
    return descricao;
  }

  /**
    Retorna uma String com a descrição curta de todos os animais do zoologico.
    @return Descricao curta dos animais do zoologico
  */
  public String getDescricaoZoologico(){
    String descricao = "ANIMAIS DO ZOOLOGICO";

    for (Animal animal : animais){
      descricao += "\n" + animal.getDescricao();
    }
    return descricao;
 }

  /**
    Retorna uma String com a descrição longa de todos os animais do zoologico.
    @return Descrição longa de todos os animais do zoologico
  */
  public String getDescricaoLongaZoologico(){
    String descricao = "ANIMAIS DO ZOOLOGICO";

    for (Animal animal : animais){
      descricao += "\n" + animal.getDescricaoLonga();
    }
    return descricao;
  }
  
}