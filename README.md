# Gerenciamento de Estoque com Drone

## Requistos do Trabalho

1. Estruturação da solução em termos de classes e pacotes
2. A aplicação de herança
3. A aplicação de classes abstratas e interfaces
4. O uso de collection
5. A aplicação de polimorfismo (estático e dinâmico)
6. O encapsulamento
7. O uso correto das estruturas de programação básica do JAVA
8. O uso correto de tratamentos de erros/exceções



## Requisitos da Aplicação

### Localização (classe abstrata)



### Localização de Prédio (estende Localização)

#### Atributos
- rua



### Localização de Produto (estende Localização)

#### Atributos
- rua
- andar
- apartamento


### Dispositivo (classe abstrata)

#### Atributos

- id
- tipoDeEmbarcado
- localizacaoInicial
- autonomia
- velocidade

#### Funções

Dispositivo()
Dispositivo(id, tipoDeEmbarcado, localizacaoInicial, autonomia, velocidade)

+ locomocaoDispostivo()
+ gets


### Drone (estende dispositivo)

Drone para invetário de estoque.

#### Atributos

#### Funções

Drone()
Drone(id, tipoDeEmbarcado, localizacaoInicial, autonomia, velocidade)

-void leituraRFID()
-void locomocaoParaRegiaoDeDescarregamento(localizacaoDoDrone)
+locomocaoDispositivo(velocidade, autonomia, movimentacao)
+ArrayList<> fazerInventario(databasePreCasdastrado){ 
// o retorno desta função será um array separado por tipo de produtos onde contera;
nome, quantidadeDeNovosProdutos, id, setorDeDestino
}
+ posicao encontrarProduto(idDoProduto, idDatabase)

### Empilhadeira (estende dispositivo)

#### Atributos

#### Funções
Empilhadeira()
Empilhadeira(id, tipoDeEmbarcado, localizacaoInicial, autonomia, velocidade)

- void statusVazio()
+ int pegarProduto(localizacaoDoProduto)
+ void levarProduto(int verificador)


### Produto (classe abstrata)

Pallet que armazena mercadorias.

#### Atributos

- id
- RFID Tag
- nome
- descrição
- Localização de Produto


### Dimensão (classe abstrata)

### Dimensão de Prédio (estende Dimensão)

#### Atributos

- número de andares
- número de apartamentos por andar

### Dimensão de Estoque (estende Dimensão)

#### Atributos

- número de Prédios
- número de andares dos Prédios
- número de apartamentos por andar dos Prédios


### Armazenamento (interface)

Contrato para classes que armazenam Produtos.

#### Método

- adicionar Produto
- retirar Produto
- mover Produto

### Prédio (classe concreta que implementa Armazenamento)

Basicamente uma estante que armzena produtos (se comporta  como uma matriz).

#### Atributos

- id
- Localização do Prédio
- matriz de Produtos
- capacidade máxima de Produtos
- quantidade de Produtos registrados

#### Métodos

- adicionar Produto
- retirar Produto
- mover Produto
- verificar se apartamento está disponível


### Estoque (classe concreta que implementa Armazenamento)

Onde os prédio são armazenados.

#### Atributos

- Dimensão de Estoque
- capacidade máxima
- quantidade total de Produtos registrados
- Drone
- Empilhadeira

#### Métodos

- adicionar Produto
- retirar Produto
- mover Produto
- fazer invetário de Produtos

