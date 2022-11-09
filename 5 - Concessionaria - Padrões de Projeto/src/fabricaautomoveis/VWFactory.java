package fabricaautomoveis;

import fabricaautomoveis.carros.*;

public class VWFactory extends CarroFactory{

  @Override
  public Carro criarCarro(Categoria categoria, String cor) {
    Carro carro = null;

    if (categoria == Categoria.POPULAR){
      carro = new Gol(cor);
    }else if(categoria == Categoria.PICKUP){
      carro = new Saveiro(cor);
    }else if(categoria == Categoria.LUXO){
      carro = new Taos(cor);
    }

    return carro;
  }
  
}
