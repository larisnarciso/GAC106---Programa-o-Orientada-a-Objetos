public class Item {
  private String nome;
  private String descricao;
  private int peso;

  public Item(String nome, String descricao, int peso){
    this.nome = nome;
    this.descricao = descricao;
    this.peso = peso;
  }

  public String getNomeItem(){
    return nome;
  }

  public String getDescricao(){
    return descricao;
  }

  public int getPeso(){
    return peso;
  }
}
