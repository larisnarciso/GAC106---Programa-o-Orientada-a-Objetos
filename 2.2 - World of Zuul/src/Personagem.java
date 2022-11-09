import java.util.ArrayList;

public class Personagem {
  private String nome;
  private ArrayList<Item> mochila;

  public Personagem(String nome) {
    this.nome = nome;
    this.mochila = new ArrayList<>();
  }

  public String getNome() {
    return nome;
  }

  public void adicionarItem(Item item) {
    mochila.add(item);
  }

  public boolean removerItem(String nomeItem) {
    for (int i = 0; i < mochila.size(); i++) {
      if (mochila.get(i).getNomeItem().equals(nomeItem)) {
        mochila.remove(i);
        return true;
      }
    }
    return false;
  }

  public String descricaoMochila() {
    if (mochila.size() > 0){
      String texto = "Itens na mochila: ";
      for (Item item : mochila) {
        texto += item.getNomeItem() + " ";
      }
      return texto;
    }
    return null;
  }

  public boolean mochilaCheia(){
    if (mochila.size() == 3){
      System.out.println("Parabéns!! Você encontrou todas as provas");
      System.out.println("Você descobriu que...");
      System.out.println("O bilhete era a senha do celular do Nathan.");
      System.out.println("Você desbloqueou o celular e descobriu conversas com o prof. Mark Jefferson");
      System.out.println("Que juntamente com as fotos da Rachel Amber, comprovou seu envolvimento em seu sumiço");
      System.out.println("O professor Mark Jefferson é o culpado pelo sumiço de Rachel Amber ");
      return true;
    }
    return false;
  }

}