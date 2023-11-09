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
            escolha = scanner.nextInt();
            System.out.println();

            switch (escolha) {
                case 2:
                    // Adicionar Produto
                    System.out.println("== Informe os detalhes do produto ==");

                    String id = inputString("ID: ");
                    String nome = inputString("Nome: ");
                    String tipoArmazenagem = inputString("Tipo de Armazenagem: ");
                    String descricao = inputString("Descrição: ");

                    Produto produto = new Produto(id, nome, tipoArmazenagem, descricao);

                    estoque.adicionarProduto(produto);

                    break;
                case 3:
                    // Retirar Produto
                    String idRetirada = inputString(">> Informe o ID do produto a ser retirado: ");

                    Produto produtoRetirada = encontrarProdutoPorID(estoque, idRetirada);

                    if (produtoRetirada != null) {
                        estoque.removerProduto(produtoRetirada);
                    } else {
                        System.out.println("Produto não encontrado no estoque!");
                    }
                    break;
                case 4:
                    // Mover Produto
                    String idMovimentacao = inputString(">> Informe o ID do produto a ser movido: ");
                    Produto produtoMovimentacao = encontrarProdutoPorID(estoque, idMovimentacao);

                    if (produtoMovimentacao != null) {
                        System.out.println("Informe a nova posição do produto: ");

                        int andar = inputInt("Andar");
                        int apartamento = inputInt("Apartamento: ");
                        int predio = inputInt("Prédio: ");

                        estoque.moverProduto(produtoMovimentacao, new Posicao(andar, apartamento, predio));
                    } else {
                        System.out.println("Produto não encontrado no estoque.");
                    }
                    break;
                case 5:
                    // Fazer Inventário de Produtos
                    estoque.fazerInventarioDeProdutos();
                    break;
//                case 5:
//
//                    System.out.print("largura: ");
//                    int largura = scanner.nextInt();
//
//                    System.out.print("altura: ");
//                    int altura = scanner.nextInt();
//
//                    System.out.print("identificador do prédio (número): ");
//                    int predioId = scanner.nextInt();
//
//                    DimensaoPredio dimensaoPredio = new DimensaoPredio(largura, altura);
//                    novoPredio = new Predio(dimensaoPredio, String.valueOf(predioId));
//                    Produto produto2 = new Produto("1", "produto", "não sei", "sobre efeito do produto");
//                    Posicao pos = new Posicao(0, 0, 0);
//                    produto2.setPosicao(pos);
//                    novoPredio.escreverBackupPredio(novoPredio.getPredioID(), produto2);
//                    break;

                case 1:
                    System.out.println("== Dimensões do Estoque ==");
                    int numeroDePredios = inputInt("Número de prédios (ex.: 10): ");
                    int numeroDeAndares = inputInt("Número de andares por prédio (ex.: 5): ");
                    int numeroDeApartamentos = inputInt("Número de apartamentos por andar (ex.: 20): ");

                    estoque = new Estoque(new DimensaoEstoque(numeroDeApartamentos, numeroDeAndares, numeroDePredios));

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
// private static void salvarTudo(ArrayList<String> arquivosAcessados){
// for (int i = 0; i < ; i++) {
// for (int j = 0; j < ; j++) {

// matrizDeProdutos.get(i).set(j, produto);

// }
// }
// }
