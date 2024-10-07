import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServiceVeiculo {
    private List<Veiculo> frota = new ArrayList<>();

    public void adicionarVeiculo(Veiculo veiculo) throws Exception {
        if (veiculo.getMarca() == null || veiculo.getMarca().isEmpty()) {
            throw new Exception("Não é permido cadastrar veículo sem marca");
        } else if (veiculo.getModelo() == null || veiculo.getModelo().isEmpty()) {
            throw new Exception("Não é permitido cadastrar um veículo sem modelo");
        } else if (veiculo.getAno() < 0 || veiculo.getAno() > LocalDate.now().getYear()) {
            throw new Exception("Não é permitido cadastrar um veículo com uma data igual ou inferior a 0 e maior que a data do ano atual");
        } else if (veiculo.getPlaca() == null || veiculo.getPlaca().isEmpty()) {
            throw new Exception("Para cadastrar um veiculo é necessário uma placa");
        }
        for (Veiculo veiculoFrota : frota) {
            if (veiculoFrota.getPlaca().equalsIgnoreCase(veiculo.getPlaca())) {
                throw new Exception("Já existe cadastrado com esse título: ");
                }
            }
            frota.add(veiculo);
        }
    
    

    public List<Veiculo> listarVeiculos() {
        return frota;
    }

    public Veiculo pesquisarPorPlaca(String placa) throws Exception {
        Veiculo veiculoRet = null;
        for (Veiculo veiculo : frota) {
            if (veiculo.getPlaca().equals(placa)) {
                veiculoRet = veiculo;
                break;
            }
        }
        if (veiculoRet == null)
            throw new Exception("Veículo não encontrado com a placa informada");
        return veiculoRet;
    }
}