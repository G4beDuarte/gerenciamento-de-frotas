public abstract class Veiculo {
    private String marca;
    private String modelo;
    private int ano;
    private String placa;

    public abstract String getTipo();

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString(){
        String descricao = "Marca: " + this.getMarca() + " - modelo: " + this.getModelo() +" - placa: " + getPlaca();
        return descricao;
    }
    
}