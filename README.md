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



### Produto (classe abstrata)

Pallet que armazena mercadorias.

#### Atributos

- id
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


### Prédio (classe concreta)

Basicamente uma estante que armzena produtos (se comporta  como uma matriz).

#### Atributos

- id
- Localização do Prédio
- matriz de Produtos
- capacidade máxima de Produtos
- quantidade de Produtos registrados



### Estoque (classe concreta)

Onde os prédio são armazenados.

####  Atributos

- Dimensão de Estoque
- capacidade máxima
- quantidade total de Produtos registrados
