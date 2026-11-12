public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(10);

        Livro l1 = new Livro("L001", "Java: Como Programar");
        Livro l2 = new Livro("L002", "Clean Code");
        Livro l3 = new Livro("L003", "Engenharia de Software");
        Revista r1 = new Revista("R001", "Revista Java");
        Revista r2 = new Revista("R002", "Revista MundoJ");

        biblioteca.adicionarItem(l1);
        biblioteca.adicionarItem(l2);
        biblioteca.adicionarItem(l3);
        biblioteca.adicionarItem(r1);
        biblioteca.adicionarItem(r2);

        Aluno aluno = new Aluno("Ingrid Vitória");

        System.out.println("Iniciando os emprestimos");

        biblioteca.emprestar(aluno, l1);
        biblioteca.emprestar(aluno, l2);
        biblioteca.emprestar(aluno, r1);

        System.out.println("\n Tentando realizar o emprestimo para Aluno (Limite = 3)...");
        biblioteca.emprestar(aluno, r2);

        biblioteca.listarAcervo();
    }
}
