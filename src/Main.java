import domain.*;
import service.Estoque;
import service.StatusVenda;
import service.Venda;

public class Main {
    public static void main(String[] args) {
        Categoria eletronicoCategoria = Categoria.ELETRONICO;
        Categoria vestuarioCategoria = Categoria.VESTUARIO;
        Categoria livroCategoria = Categoria.LIVRO;
        Categoria alimentoCategoria = Categoria.ALIMENTO;

        StatusVenda statusVendaCancelada = StatusVenda.CANCELADA;
        StatusVenda statusVendaConcluida = StatusVenda.CONCLUIDA;
        StatusVenda statusVendaProcessando = StatusVenda.PROCESSANDO;

        Eletronico eletronico = new Eletronico("Playstation 5", "00001", 2780.00D, 3180.00D, 78, eletronicoCategoria);
        eletronico.setMesesGarantia(12);

        Vestuario vestuario = new Vestuario("Moletom Preto", "00002", 50.0D, 180D, 44, vestuarioCategoria);

        Livro livro = new Livro("O Hobbit", "00003", 30D, 65D, 180, livroCategoria);
        livro.setAutor("Tolkien");
        livro.setEditora("Harper Collins");

        Alimento alimento = new Alimento("Peito de frango", "00004", 8D, 22D, 78, alimentoCategoria);
        alimento.setDataDeValidade("14/10/2026");

        Estoque estoque1 = new Estoque();
        estoque1.adicionarProdutoAoEstoque(eletronico);
        estoque1.adicionarProdutoAoEstoque(vestuario);
        estoque1.adicionarProdutoAoEstoque(livro);
        estoque1.adicionarProdutoAoEstoque(alimento);

        estoque1.removerProduto(vestuario);

        estoque1.exibirDetalhes();

        System.out.println("\n################# Venda ###################");

        Venda venda1 = new Venda("Kauê Kelvin", statusVendaProcessando, estoque1);

        venda1.adicionarProduto(livro,180);
        venda1.adicionarProduto(eletronico,78);

        venda1.exibirDetalhes();
        System.out.println("\n######### Preço Total ########");
        venda1.calcularPrecoItens();

        venda1.setStatusVenda(statusVendaConcluida);

        System.out.println("\n############# Venda após ser Concluída ##############");
        venda1.exibirDetalhes();
    }
}
