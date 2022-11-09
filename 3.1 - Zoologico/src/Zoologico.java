import java.util.ArrayList;

public class Zoologico{
  private ArrayList<Lobo> lobos;        // coleção de lobos do zoologico
  private ArrayList<Gato> gatos;        // coleção de gatos do zoologico
  private ArrayList<Galinha> galinhas;  // coleção de galinhas do zoologico
  private ArrayList<Aguia> aguias;      // coleção de aguias do zoologico

  /**
    Construtor
  */
  public Zoologico(){
    lobos = new ArrayList<Lobo>();
    gatos = new ArrayList<Gato>();
    galinhas = new ArrayList<Galinha>();
    aguias = new ArrayList<Aguia>();
  }

  /**
    Adiciona animais Lobo, Gato, Galinha e Aguia no Zoologico.
  */

  public void adicionarLobo(String nome, String corPelo){
    Lobo lobo = new Lobo(nome, corPelo);
    lobos.add(lobo);
  }

  public void adicionarGato(String nome, String corPelo){
    Gato gato = new Gato(nome, corPelo);
    gatos.add(gato);
  }

  public void adicionarGalinha(String nome, boolean qldVoo){
    Galinha galinha = new Galinha(nome, qldVoo);
    galinhas.add(galinha);
  }

  public void adicionarAguia(String nome, boolean qldVoo){
    Aguia aguia = new Aguia(nome, qldVoo);
    aguias.add(aguia);
  }

  /**
    Retorna uma String com a descrição longa de um animal em especifico do zoologico.
    @return Descrição longa de um animal do zoologico.
  */
  public String getDescricaoLongaAnimal(String nome){
    String descricao = "Não está cadastrado!";

    for (Lobo lobo : lobos){
      if (lobo.getNome().equals(nome)){
        descricao = lobo.getDescricaoLonga();
      }
    }
    for (Gato gato : gatos){
      if (gato.getNome().equals(nome)){
        descricao = gato.getDescricaoLonga();
      }
    }
    for (Galinha galinha : galinhas){
      if (galinha.getNome().equals(nome)){
        descricao = galinha.getDescricaoLonga();
      }
    }
    for (Aguia aguia : aguias){
      if (aguia.getNome().equals(nome)){
        descricao = aguia.getDescricaoLonga();
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

    for (Lobo lobo : lobos){
      descricao += "\n" + lobo.getDescricao();
    }
    for (Gato gato : gatos){
      descricao += "\n" + gato.getDescricao();
    }
    for (Galinha galinha : galinhas){
      descricao += "\n" + galinha.getDescricao();
    }
    for (Aguia aguia : aguias){
      descricao += "\n" + aguia.getDescricao();
    }
    return descricao;
 }

  /**
    Retorna uma String com a descrição longa de todos os animais do zoologico.
    @return Descrição longa de todos os animais do zoologico
  */
  public String getDescricaoLongaZoologico(){
    String descricao = "ANIMAIS DO ZOOLOGICO";

    for (Lobo lobo : lobos){
      descricao += "\n" + lobo.getDescricaoLonga();
    }
    for (Gato gato : gatos){
      descricao += "\n" + gato.getDescricaoLonga();
    }
    for (Galinha galinha : galinhas){
      descricao += "\n" + galinha.getDescricaoLonga();
    }
    for (Aguia aguia : aguias){
      descricao += "\n" + aguia.getDescricaoLonga();
    }
    return descricao;
  }
  
}