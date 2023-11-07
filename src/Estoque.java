import java.util.ArrayList;
import java.util.List;

public class Estoque implements Armazenamento {
    private Dimensao dimensaoEstoque;
    private int capacidadeMaxima;
    private int quantidadeTotalProdutosRegistrados;
    private Drone drone;
    private Empilhadeira empilhadeira;
    private List<Produto> produtosNoEstoque;

    public Estoque() {
    }

    public Estoque(Dimensao dimensaoEstoque, int capacidadeMaxima, Drone drone, Empilhadeira empilhadeira) {
        this.dimensaoEstoque = dimensaoEstoque;
        this.capacidadeMaxima = capacidadeMaxima;
        this.quantidadeTotalProdutosRegistrados = 0;
        this.drone = drone;
        this.empilhadeira = empilhadeira;
        this.produtosNoEstoque = new ArrayList<>();
    }

    // Método para acessar a lista de produtos no estoque
    public List<Produto> getProdutosNoEstoque() {
        return produtosNoEstoque;
    }

    @Override
    public void adicionarProduto(Produto produto) {
        if (quantidadeTotalProdutosRegistrados < capacidadeMaxima) {
            produtosNoEstoque.add(produto);
            quantidadeTotalProdutosRegistrados++;
            System.out.println("Produto adicionado ao estoque com sucesso.");
        } else {
            System.out.println("Capacidade máxima do estoque atingida. Não é possível adicionar mais produtos.");
        }
    }

    @Override
    public void retirarProduto(Produto produto) {
        if (produtosNoEstoque.remove(produto)) {
            quantidadeTotalProdutosRegistrados--;
            System.out.println("Produto retirado do estoque com sucesso.");
        } else {
            System.out.println("Produto não encontrado no estoque.");
        }
    }

    @Override
    public void moverProduto(Produto produto, Position novaLocalizacao) {
        // Verifica se o produto existe no estoque
        if (produtosNoEstoque.contains(produto)) {
            Position localizacaoAtual = produto.getLocalizacaoDeProduto();
            int xAntigo = localizacaoAtual.getX();
            int yAntigo = localizacaoAtual.getY();
            int zAntigo = localizacaoAtual.getZ();

            int xNovo = novaLocalizacao.getX();
            int yNovo = novaLocalizacao.getY();
            int zNovo = novaLocalizacao.getZ();

            // Verifica se a nova localização é válida dentro da dimensão do estoque
            if (xNovo >= 0 && xNovo < dimensaoEstoque.getLargura() &&
                    yNovo >= 0 && yNovo < dimensaoEstoque.getAltura() &&
                    zNovo >= 0 && zNovo < dimensaoEstoque.getProfundidade()) {
                // Remove o produto da localização anterior
                produtosNoEstoque.remove(produto);

                // Atualiza a localização do produto
                produto.setLocalizacaoDeProduto(novaLocalizacao);

                // Adiciona o produto na nova localização
                produtosNoEstoque.add(produto);

                System.out.println("Produto movido para (" + xNovo + ", " + yNovo + ", " + zNovo + ")");
            } else {
                System.out.println("Nova localização inválida. O produto não foi movido.");
            }
        } else {
            System.out.println("Produto não encontrado no estoque. Não é possível movê-lo.");
        }
    }

    public void fazerInventarioDeProdutos() {
        System.out.println("Inventário de Produtos no Estoque:");
        for (Produto produto : produtosNoEstoque) {
            System.out.println("ID: " + produto.getId());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Tipo de Armazenagem: " + produto.getTipoDeArmazenagem());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Localização: " + produto.getLocalizacaoDeProduto().x + ", " + produto.getLocalizacaoDeProduto().y);
            System.out.println("----------------------");
        }
        System.out.println("Quantidade total de produtos no estoque: " + quantidadeTotalProdutosRegistrados);
    }
}
