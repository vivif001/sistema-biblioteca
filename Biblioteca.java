public class Biblioteca {
    private ItemBiblioteca[] acervo;
    private int totalItens;

    public Biblioteca(int capacidade) {
        this.acervo = new ItemBiblioteca[capacidade];
        this.totalItens = 0;
    }

    public void adicionarItem(ItemBiblioteca item) {
        if (totalItens < acervo.length) {
            acervo[totalItens] = item;
            totalItens++;
        } else {
            System.out.println("Acervo cheio! Nao foi possivel adicionar: " + item.getTitulo());
        }
    }

    public boolean emprestar(Usuario usuario, ItemBiblioteca item) {
        if (!usuario.podeEmprestar()) {
            System.out.println("Emprestimo recusado para " + usuario.getNome() + 
                               ": Limite maximo atingido (" + usuario.getLimiteItens() + " itens).");
            return false;
        }

        if (!item.isDisponivel()) {
            System.out.println("Emprestimo recusado: O item '" + item.getTitulo() + "' ja esta emprestado.");
            return false;
        }

        item.setDisponivel(false);
        usuario.incrementarEmprestimo();
        System.out.println("Sucesso! " + usuario.getNome() + " pegou '" + item.getTitulo() + 
                           "'. Prazo de devolucao: " + item.getPrazoEmprestimo() + " dias.");
        return true;
    }

    public boolean devolver(Usuario usuario, ItemBiblioteca item) {
        if (item.isDisponivel()) {
            System.out.println("Devolucao invalida: O item '" + item.getTitulo() + "' ja consta na estante.");
            return false;
        }

        item.setDisponivel(true);
        usuario.decrementarEmprestimo();
        System.out.println("Devolucao concluida: '" + item.getTitulo() + "' devolvido por " + usuario.getNome() + ".");
        return true;
    }

    public void listarAcervo() {
        System.out.println("\n=== ACERVO DA BIBLIOTECA ===");
        for (int i = 0; i < totalItens; i++) {
            ItemBiblioteca item = acervo[i];
            System.out.println(
                "Codigo: " + item.getCodigo() +
                " | Titulo: " + item.getTitulo() +
                " | Disponivel: " + (item.isDisponivel() ? "Sim" : "Nao") +
                " | Prazo: " + item.getPrazoEmprestimo() + " dias" +
                " | Multa/dia: R$ " + String.format("%.2f", item.getValorMultaPorDia())
            );
        }
        System.out.println("============================\n");
    }
}