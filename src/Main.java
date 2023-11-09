import Armazenamento.Estoque;
import Armazenamento.Predio;
import Dimensoes.DimensaoEstoque;
import Dimensoes.DimensaoPredio;
import Dispositivos.Drone;
import Dispositivos.Empilhadeira;
import Posicao.Posicao;
import Produto.Produto;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque(new DimensaoEstoque(10, 10, 10));
        Scanner scanner = new Scanner(System.in);
        Predio novoPredio;

        int escolha;

        do {
            System.out.println("Selecione uma opção:\n");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Retirar Produto");
            System.out.println("3. Mover Produto");
            System.out.println("4. Fazer Inventário de Produtos");
            System.out.println("5. Adicionar Prédio");
            System.out.println("6. Dimesionar estoque");
            System.out.println("0. Sair\n");
            System.out.print("Insira a opção selecionada: ");
            escolha = scanner.nextInt();
            System.out.println();

            switch (escolha) {
                case 1:
                    // Adicionar Produto
                    System.out.println("Informe os detalhes do produto");
                    System.out.print("ID: ");
                    String id = scanner.next();

                    System.out.print("Nome: ");
                    String nome = scanner.next();

                    System.out.print("Tipo de Armazenagem: ");
                    String tipoArmazenagem = scanner.next();

                    System.out.print("Descrição: ");
                    String descricao = scanner.next();

                    Produto produto = new Produto(id, nome, tipoArmazenagem, descricao);

                    estoque.adicionarProduto(produto);

                    produto.setPredio(0);

                    break;
                case 2:
                    // Retirar Produto
                    System.out.print("Informe o ID do produto a ser retirado: ");
                    String idRetirada = scanner.next();

                    Produto produtoRetirada = encontrarProdutoPorID(estoque, idRetirada);

                    if (produtoRetirada != null) {
                        estoque.removerProduto(produtoRetirada);
                    } else {
                        System.out.println("Produto não encontrado no estoque.");
                    }
                    break;
                case 3:
                    // Mover Produto
                    System.out.print("Informe o ID do produto a ser movido: ");
                    String idMovimentacao = scanner.next();
                    Produto produtoMovimentacao = encontrarProdutoPorID(estoque, idMovimentacao);

                    if (produtoMovimentacao != null) {
                        System.out.println("Informe a nova posição (X, Y, Z) para o produto (Exemplo: '1 2 3'): ");
                        System.out.print("X: ");
                        int x = scanner.nextInt();
                        System.out.print("Y: ");
                        int y = scanner.nextInt();
                        System.out.print("Z: ");
                        int z = scanner.nextInt();

                        Posicao novaLocalizacao = new Posicao(x, y, z);
                        estoque.moverProduto(produtoMovimentacao, novaLocalizacao);
                    } else {
                        System.out.println("Produto não encontrado no estoque.");
                    }
                    break;
                case 4:
                    // Fazer Inventário de Produtos
                    estoque.fazerInventarioDeProdutos();
                    break;
                case 5:

                    System.out.print("largura: ");
                    int largura = scanner.nextInt();

                    System.out.print("altura: ");
                    int altura = scanner.nextInt();

                    System.out.print("identificador do prédio (número): ");
                    int predioId = scanner.nextInt();

                    DimensaoPredio dimensaoPredio = new DimensaoPredio(largura, altura);
                    novoPredio = new Predio(dimensaoPredio, String.valueOf(predioId));
                    Produto produto2 = new Produto("1", "produto", "não sei", "sobre efeito do produto");
                    Posicao pos = new Posicao(0, 0, 0);
                    produto2.setPosicao(pos);
                    novoPredio.escreverBackupPredio(novoPredio.getPredioID(), produto2);
                    break;

                case 6:
                    System.out.print("número de apartamentos: ");
                    int numeroDeApartamentos = scanner.nextInt();

                    System.out.print("número de andares: ");
                    int numeroDeAndares = scanner.nextInt();

                    System.out.print("número de prédios");
                    int numeroDePredios = scanner.nextInt();

                    DimensaoEstoque dimensaoEstoque = new DimensaoEstoque(numeroDeApartamentos, numeroDeAndares,
                            numeroDePredios);

                    estoque = new Estoque(dimensaoEstoque);

                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (escolha != 0);
    }

    // Método auxiliar para encontrar um produto no estoque pelo ID
    private static Produto encontrarProdutoPorID(Estoque estoque, String id) {
        for (Produto produto : estoque.getProdutosNoEstoque()) {
            if (Objects.equals(produto.getId(), id)) {
                return produto;
            }
        }
        return null;
    }
}
// private static void salvarTudo(ArrayList<String> arquivosAcessados){
// for (int i = 0; i < ; i++) {
// for (int j = 0; j < ; j++) {

// matrizDeProdutos.get(i).set(j, produto);

// }
// }
// }
