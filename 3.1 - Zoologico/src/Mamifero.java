/**
    Classe que representa um mamifero. 
    Mamifero herda da classe Animal (herdando nome, especie, som e quantidade de patas)
    Um mamifero tem cor de pelo.
 */

public class Mamifero extends Animal{
  private String corPelo;

  public Mamifero(String nome, String especie, String som, String corPelo){
    super(nome,especie,som,4);
    this.corPelo = corPelo;
  }

  public String getCorPelo(){
    return corPelo;
  }

  @Override
  public String getDescricaoLonga(){
    String descricao = super.getDescricaoLonga();
    descricao = descricao + " que tem pelo " + corPelo;
    return descricao;
  }
}