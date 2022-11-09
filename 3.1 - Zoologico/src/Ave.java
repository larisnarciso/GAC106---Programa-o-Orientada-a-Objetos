/**
    Classe que representa uma ave.
    Ave herda da classe Animal (herdando nome, especie, som e quantidade de patas)
    Uma ave tem qualidade de voo (voando bem ou mal)
 */

public class Ave extends Animal{
  private boolean qldVoo;

  public Ave(String nome, String especie, String som, boolean qldVoo){
    super(nome,especie,som,2);
    this.qldVoo = qldVoo;
  }

  public boolean getQldVoo(){
    return qldVoo;
  }

  @Override
  public String getDescricaoLonga(){
    String descricao = super.getDescricaoLonga();
    if (qldVoo){
      descricao = descricao + " voa bem";
    }else {
      descricao = descricao + " voa mal";
    }
    return descricao;
  }
}