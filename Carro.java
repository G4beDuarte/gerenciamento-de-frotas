public class Carro extends Veiculo{
    private int numeroPortas;

    public String getTipo(){
        return "Carro";
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    @Override
    public String toString() {
        String descricao = super.toString();
        return descricao + " - Número de portas: " + this.getNumeroPortas();
    }
}