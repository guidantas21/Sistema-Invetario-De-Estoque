package Dispositivos;

import Dispositivos.Dispositivo;
import Posicao.Posicao;
import Produto.Produto;

public class Empilhadeira extends Dispositivo {
    private boolean emOperacao;
    private Produto produtoCarregado;

    public Empilhadeira() {
    }

    public Empilhadeira(int id, String tipoDeEmbarcado, Posicao localizacaoInicial, int autonomia, int velocidade) {
        super(id, tipoDeEmbarcado, localizacaoInicial, autonomia, velocidade);
        this.emOperacao = false;
        this.produtoCarregado = null;
    }

    // Método para iniciar a operação da empilhadeira
    public void iniciarOperacao() {
        emOperacao = true;
        System.out.println("Dispositivos.Empilhadeira iniciou a operação.");
    }

    // Método para parar a operação da empilhadeira
    public void pararOperacao() {
        emOperacao = false;
        System.out.println("Dispositivos.Empilhadeira parou a operação.");
    }

    // Método para carregar um produto na empilhadeira
    public void carregarProduto(Produto produto) {
        if (emOperacao) {
            if (produtoCarregado == null) {
                produtoCarregado = produto;
                System.out.println("Produto carregado na empilhadeira.");
            } else {
                System.out.println("A empilhadeira já está carregando um produto.");
            }
        } else {
            System.out.println("A empilhadeira não está em operação.");
        }
    }

    // Método para descarregar o produto carregado na empilhadeira
    public void descarregarProduto() {
        if (emOperacao) {
            if (produtoCarregado != null) {
                System.out.println("Produto descarregado da empilhadeira: " + produtoCarregado.getNome());
                produtoCarregado = null;
            } else {
                System.out.println("A empilhadeira não está carregando nenhum produto.");
            }
        } else {
            System.out.println("A empilhadeira não está em operação.");
        }
    }

    @Override
    public void movimentacaoDispositivo() {
        // Implemente a lógica de movimentação da empilhadeira aqui
        System.out.println("Movimentação da empilhadeira em andamento.");
    }
}
