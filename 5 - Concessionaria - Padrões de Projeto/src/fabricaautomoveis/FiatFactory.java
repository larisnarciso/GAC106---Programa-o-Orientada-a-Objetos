package fabricaautomoveis;

import fabricaautomoveis.carros.*;

public class FiatFactory extends CarroFactory{

  @Override
  public Carro criarCarro(Categoria categoria, String cor) {
    Carro carro = null;

    if (categoria == Categoria.POPULAR){
      carro = new Argo(cor);
    }else if (categoria == Categoria.PICKUP){
      carro = new Strada(cor);
    }else if (categoria == Categoria.LUXO){
      carro = new Toro(cor);
    }

    return carro;
  }
}
