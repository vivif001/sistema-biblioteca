public class Livro extends ItemBiblioteca {

    public Livro(String codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int getPrazoEmprestimo() {
        return 14;
    }

    @Override
    public double getValorMultaPorDia() {
        return 0.50;
    }
}