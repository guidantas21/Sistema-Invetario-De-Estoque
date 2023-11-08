import Armazenamento.Estoque;
import Dimensoes.DimensaoEstoque;
import Dispositivos.Drone;
import Dispositivos.Empilhadeira;
import Posicao.Posicao;
import Produto.Produto;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque(new DimensaoEstoque(10.0, 5.0, 3.0, 3, 2, 4), 24, new Drone(),
                new Empilhadeira());
        Scanner scanner = new Scanner(System.in);

        int escolha;

        do {
            System.out.println("Selecione uma opção:\n");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Retirar Produto");
            System.out.println("3. Mover Produto");
            System.out.println("4. Fazer Inventário de Produtos");
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

                    Produto produto = new Produto(id, nome, tipoArmazenagem, descricao, 0, 0, 0);

                    estoque.adicionarProduto(produto);
                    break;
                case 2:
                    // Retirar Produto
                    System.out.print("Informe o ID do produto a ser retirado: ");
                    String idRetirada = scanner.next();

                    Produto produtoRetirada = encontrarProdutoPorID(estoque, idRetirada);

                    if (produtoRetirada != null) {
                        estoque.retirarProduto(produtoRetirada);
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
