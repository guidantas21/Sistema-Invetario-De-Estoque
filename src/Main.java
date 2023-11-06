import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque(new DimensaoEstoque(10.0, 5.0, 3.0, 3, 2, 4), 24, new Drone(), new Empilhadeira());
        Scanner scanner = new Scanner(System.in);

        int escolha;

        do {
            System.out.println("Selecione uma opção:\n");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Retirar Produto");
            System.out.println("3. Mover Produto");
            System.out.println("4. Fazer Inventário de Produtos");
            System.out.println("0. Sair");
            System.out.print("Insira a opção selecionada: ");
            escolha = scanner.nextInt();

            System.out.println();

            switch (escolha) {
                case 1:
                    // Adicionar Produto
                    System.out.println("Informe os detalhes do produto");
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Nome: ");
                    String nome = scanner.next();
                    System.out.print("Tipo de Armazenagem: ");
                    String tipoArmazenagem = scanner.next();
                    System.out.print("Descrição: ");
                    String descricao = scanner.next();
                    Produto produto = new Produto(id, nome, tipoArmazenagem, descricao);
                    estoque.adicionarProduto(produto);
                    break;
                case 2:
                    // Retirar Produto
                    System.out.print("Informe o ID do produto a ser retirado: ");
                    int idRetirada = scanner.nextInt();
                    Produto produtoRetirada = encontrarProdutoPorID(estoque, idRetirada);
                    if (produtoRetirada != null) {
                        estoque.retirarProduto(produtoRetirada);
                    } else {
                        System.out.println("Produto não encontrado no estoque.");
                    }
                    break;
                case 3:
                    // Mover Produto
                    // Implemente a lógica para mover um produto dentro do estoque
                    System.out.println("Implemente a lógica para mover um produto.");
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
    private static Produto encontrarProdutoPorID(Estoque estoque, int id) {
        for (Produto produto : estoque.getProdutosNoEstoque()) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }
}
