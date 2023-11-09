import Armazenamento.Estoque;
import Armazenamento.Predio;
import Dimensoes.DimensaoEstoque;
import Dimensoes.DimensaoPredio;
import Posicao.Posicao;
import Produto.Produto;

import java.util.Objects;
import java.util.Scanner;


import static frontend.Menu.*;

public class Main {

    public static void main(String[] args) {
        Estoque estoque = new Estoque(new DimensaoEstoque(10, 10, 10));
        Scanner scanner = new Scanner(System.in);
        Predio novoPredio;

        int escolha;

        do {
            printMenu();
            escolha = inputInt(scanner, ">> Insira a opção selecionada (ex.: 1): ");
            System.out.println();

            switch (escolha) {
                case 2:
                    // Adicionar Produto
                    System.out.println("== Informe os detalhes do produto ==");

                    String id = inputString(scanner,"ID: ");
                    String nome = inputString(scanner,"Nome: ");
                    String tipoArmazenagem = inputString(scanner,"Tipo de Armazenagem: ");
                    String descricao = inputString(scanner,"Descrição: ");

                    Produto produto = new Produto(id, nome, tipoArmazenagem, descricao);

                    estoque.adicionarProduto(produto);

                    break;
                case 3:
                    // Retirar Produto
                    String idRetirada = inputString(scanner,">> Informe o ID do produto a ser retirado: ");

                    Produto produtoRetirada = encontrarProdutoPorID(estoque, idRetirada);

                    if (produtoRetirada != null) {
                        estoque.removerProduto(produtoRetirada);
                    } else {
                        System.out.println("Produto não encontrado no estoque!");
                    }
                    break;
                case 4:
                    // Mover Produto
                    String idMovimentacao = inputString(scanner, ">> Informe o ID do produto a ser movido: ");
                    Produto produtoMovimentacao = encontrarProdutoPorID(estoque, idMovimentacao);

                    if (produtoMovimentacao != null) {
                        int predio = inputInt(scanner, "Predio (ex.: 10): ");
                        int andar = inputInt(scanner, "Andar (ex.: 5): ");
                        int apartamento = inputInt(scanner, "Apartamento (ex.: 20): ");

                        boolean sucesso = estoque.moverProduto(produtoMovimentacao, new Posicao(andar, apartamento, predio));
                        scanner.nextLine();
                        if (sucesso) {
                            System.out.println("Produto movido com sucesso!");
                        } else {
                            System.out.println("Produto não pode ser adicionado.");
                        }

                    } else {
                        System.out.println("Produto não encontrado no estoque.");
                    }
                    break;
                case 5:
                    // Fazer Inventário de Produtos
                    estoque.fazerInventarioDeProdutos();
                    break;


                case 1:
                    System.out.println("== Dimensão do Estoque ==");

                    int numPredios = inputInt(scanner, "Número de prédios (ex.: 10): ");
                    int numAndares = inputInt(scanner, "Número de andares por prédio (ex.: 5): ");
                    int numApartamentos = inputInt(scanner, "Número de apartamentos por prédio (ex.: 20): ");

                    estoque = new Estoque(new DimensaoEstoque(numApartamentos, numAndares, numPredios));

                    break;

                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
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

