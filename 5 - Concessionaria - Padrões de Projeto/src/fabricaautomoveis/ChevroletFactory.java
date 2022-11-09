package fabricaautomoveis;

import fabricaautomoveis.carros.*;

public class ChevroletFactory extends CarroFactory{

  @Override
  public Carro criarCarro(Categoria categoria, String cor) {
    Carro carro = null;

    if (categoria == Categoria.POPULAR){
      carro = new Onix(cor);
    }else if(categoria == Categoria.PICKUP){
      carro = new S10(cor);
    }else if(categoria == Categoria.LUXO){
      carro = new Camaro(cor);
    }
    return carro;
  }
  
}
