package Main;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    List<Item> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String nome, Double preco, Integer quantidade) {
        itens.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itemParaRemover = new ArrayList<>();
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                itemParaRemover.add(item);
                System.out.println("Item removido: " + item.getNome() + "\nLista atualizada: ");
            }
        }
        itens.removeAll(itemParaRemover);

    }

    public void exibirItens() {

        for (Item item : itens) {
            System.out.printf("Produto: %s - R$ %.2f - Quantidade %d%n", item.getNome(), item.getPreco(), +item.getQuantidade());
        }
    }

    public void calcularValorTotal() {

        double valorTotal = 0.0;
        double valor;
        int quantidade;
        for (Item item : itens) {
            valor = item.getPreco() * item.getQuantidade();
            valorTotal += valor;

        }
        System.out.printf("R$ %.2f", valorTotal);
    }

    public static void main(String[] args) {

        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        carrinho.adicionarItem("Abacate", 10.00, 2);
        carrinho.adicionarItem("Limão", 10.00, 1);
        carrinho.adicionarItem("Maçã", 10.00, 1);

        carrinho.exibirItens();
        System.out.println(" ");

        System.out.println("Valor total de itens no carrinho: ");
        carrinho.calcularValorTotal();
        System.out.println(" ");
        System.out.println(" ");

        carrinho.removerItem("Abacate");
        carrinho.exibirItens();

        System.out.println(" ");
        System.out.println("Valor total do carrinho após retirada de item: ");
        carrinho.calcularValorTotal();

    }
}


