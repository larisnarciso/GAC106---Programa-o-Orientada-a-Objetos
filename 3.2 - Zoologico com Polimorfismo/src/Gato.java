/**
  Classe que representa um gato.
  Gato herda da classe Mamifero.
 */
public class Gato extends Mamifero {
  public Gato (String nome, String corPelo){
    super(nome, "gato", "miau", corPelo);
  }
}