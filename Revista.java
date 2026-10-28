public class Revista extends ItemBiblioteca {

    public Revista(String codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int getPrazoEmprestimo() {
        return 7;
    }

    @Override
    public double getValorMultaPorDia() {
        return 1.00;
    }
}