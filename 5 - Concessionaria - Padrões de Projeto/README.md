[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=8319147&assignment_repo_type=AssignmentRepo)
# Concessionária Multimarcas

Este projeto é utilizado em exercícios sobre Padrões de Projeto em disciplinas de Programação Orientada a Objetos.

## Passo 1

Este projeto representa uma concessionária de forma bem simplificada, pois a intenção é facilitar a resolução dos exercícios.
Mas, especialmente para as perguntas reflexivas abaixo, considere como as classes seriam em um sistema completo, bem mais complexas e extensas, e responda pensando nisso.

Execute o programa implementado neste projeto e teste todas as suas opções.

Estude o projeto e veja que ele possui uma superclasse chamada `Carro` e subclasses para cada modelo de carro.
Ele também possui uma classe `Concessionaria`, que é a principal classe de regra de negócio do sistema, e que
permite que o usuário compre um carro.

Em seguida, mude a marca da franquia da `Concessionaria`, alterando a chamada do seu construtor, e teste o programa novamente.

## Passo 2

No passo anterior, vimos que a classe `Concessionaria` não tem os carros de todas as categorias para a Marca VW.

Faça as alterações necessárias para que a classe `Concessionaria` consiga entregar modelos de Saveiro (Pickup da VW).
Por enquanto não trate os carros de luxo.

O que você achou das mudanças no código? Lembrando que em um sistema completo, a classe `Concessionaria` seria a principal classe de regra de negócio do sistema.

> -- Foi necessário realizar alterações em várias partes do código, onde para cada carro que for acrescentado será necessário modificar o método comprarCarro da classe Concessionária e criar uma classe do carro.  --

O que aconteceria se o carro popular da VW passasse a ser o UP!
Que partes do código precisariam ser alteradas?

> -- Seria necessário criar uma classe do carro UP e alterar o método comprarCarro --

O que aconteceria se quiséssemos agora comprar carros da Chevrolet?
Que partes do código precisariam ser alteradas?

> -- Teria que adicionar Chevrolet em Marca, criar uma classe de cada um dos carros herdando da superclasse Carro, modificar o método comprarCarro com cada um dos carros e realizar a alteração do construtor da concessionária para a nova marca. --

## Passo 3

Veja que no passo anterior, nós acabamos mudando o código da classe `Concessionaria` para produzir carros diferentes.
Isso está acontecendo porque nossa classe está dependendo de classes concretas (ou seja, depende da criação de objetos de tipos específicos).

Seguindo os _Princípios de Design_ que aprendemos, o ideal é que nossas classes sejam _abertas para extensão e fechadas para modificação_.
Se nós quiséssemos tratar uma nova marca (Chevrolet, por exemplo) teríamos que fazer ainda mais modificações na classe `Concessionaria`.

Na aula teórica vimos que o **Padrão de Projeto Abstract Factory** é muito útil nessas situações.
Com ele, nós poderemos criar carros de tipos diferentes, inclusive de marcas diferentes, sem precisarmos alterar o código da classe `Concessionaria` a cada novo modelo de carro.

Faça então uma modelagem UML das alterações necessárias para implementar o Padrão de Projeto Abstract Factory, considerando duas fábricas concretas: VW e Fiat.
Exporte a modelagem para o formato `png`e coloque o arquivo em uma pasta `doc` dentro da pasta principal do projeto,

Dica: use um software de desenho qualquer para fazer a modelagem (preocupe-se apenas com uma visão geral das classes e dos métodos principais necessários).

## Passo 4

Faça a implementação de acordo com a modelagem do exercício anterior.
Crie as classes necessárias para tratar as marcas VW e Fiat.
Teste suas alterações.

O que aconteceria agora se o carro popular da VW passasse a ser o UP!
A classe Concessionaria precisaria ser alterada?

> -- Não precisaria alterar a classe Concessionaria. Seria necessário apenas alterar a classe VWFactory e criar a classe UP --

O que aconteceria agora se quiséssemos agora comprar carros da Chevrolet?
Quais partes do código precisariam ser alteradas?

> -- Seria necessário criar a classe ChevroletFactory, criar a classe de cada carro da marca, adicionar Chevrolet na classe Marca, alterar a classe InterfaceUsuario para criar um objeto Chevrolet --

## Passo 5

Faça agora as alterações necessárias para que nossa concessionária possa vender carros da Chevrolet.

Quais mudanças foram necessárias na classe `Concessionaria`?

> -- Não foi necessiário fazer nenhuma alteração na classe Concessionaria --

## Passo 6

Veja que com a utilização do Padrão de Projeto Abstract Factory nós ganhamos a possibilidade de até mudarmos a marca da franquia _em tempo de execução_, caso necessário.

Crie então na classe `Concessionaria` a opção de mudar a marca da franquia e faça os tratamentos necessários.

Adicione uma opção de menu _Mudar Franquia_ na interface do usuário, que permite que ele mude a franquia da concessionária.
Teste seu programa comprando carros de uma franquia, e depois mude a franquia e compre novos carros.

O que achou das alterações? Tente comparar como isso seria feito com o código inicial do Passo 1.

> -- As alterações ficaram mais simplificadas, deixando o código menor, atingindo os principios de design, comparando ao codigo original, antes teria que realizar grandes alterações no código, o que também dificultaria a manuntenção. --
