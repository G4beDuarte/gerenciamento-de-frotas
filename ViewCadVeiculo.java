import java.util.Comparator;
import java.util.Scanner;

public class ViewCadVeiculo {
    private static ServiceVeiculo service = new ServiceVeiculo();
    static Scanner input = new Scanner(System.in);

    public static void limparTela() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static void aguardarEnter() {
        System.out.print("Pressione Enter para continuar...");
        input.nextLine();
    }

    private static int inputNumerico(String mensagem) {
        int valor = 0;
        boolean entradaValida = false;
        System.out.print(mensagem);
        do {
            String valorStr = input.nextLine();
            try {
                valor = Integer.parseInt(valorStr);
                entradaValida = true;
            } catch (Exception e) {
                System.out.println("ERRO. Valor informado deve ser um número Inteiro");
            }
        } while (!entradaValida);
        return valor;
    }


    private static void adicionar(){
        limparTela();
        Veiculo novoVeiculo = null;
        System.out.println("========== ADICIONANDO NOVO VEICULO ==========");
        int tipoVeiculo;

        do{
            tipoVeiculo = inputNumerico("Qual tipo de veiculo: (1) Carro - (2) Moto: ");
            if(tipoVeiculo == 1){
                novoVeiculo = new Carro();
            }else if (tipoVeiculo == 2){
                novoVeiculo = new Moto();
            }else{
                System.out.println("Opção inválida!");
            }
        }while(novoVeiculo == null);

        System.out.print("Informe a marca do Veículo: ");
        String marca = input.nextLine();
        novoVeiculo.setMarca(marca);

        System.out.print("Informe o modelo do Veículo: ");
        novoVeiculo.setModelo(input.nextLine());

        int ano = inputNumerico("Informe o ano do Veículo: ");
        novoVeiculo.setAno(ano);

        System.out.print("Informe a placa do Veículo: ");
        String placa = input.nextLine();
        novoVeiculo.setPlaca(placa);

        if(tipoVeiculo == 1){
            int nPortas = inputNumerico("Informe o numero de portas do carro: ");
            ((Carro)novoVeiculo).setNumeroPortas(nPortas); 
        }else if (tipoVeiculo == 2){
            int partidaEletrica = inputNumerico("Informe se a moto possui partida elétrica: (1) Sim - (2) Não");
            if (partidaEletrica == 1){
                ((Moto)novoVeiculo).setPartidaEletrica(true);
            }else if (partidaEletrica == 2){
                ((Moto)novoVeiculo).setPartidaEletrica(false);
            }else
            System.out.println("Opção Inválida!");
        }

        try {
            service.adicionarVeiculo(novoVeiculo);
            System.out.println("VEICULO ADICIONADO COM SUCESSO!!!");
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        aguardarEnter();
    }

    private static void listar() {
        limparTela();
        var veiculos = service.listarVeiculos();
        veiculos.sort(Comparator.comparing(Veiculo::getMarca));

        System.out.println("========== LISTA DE VEICULOS ==========");
        for (Veiculo veiculo : veiculos){
            System.out.println(veiculo.getTipo());
            System.out.println(veiculo.toString());
            System.out.println("--------------------------------------");
        }
        aguardarEnter();        
    }

    private static void pesquisarPorPlaca(){
        limparTela();
        System.out.println("========== PESQUISAR PLACA DE VEICULOS ==========");

        System.out.print("Informe a placa do veículo: ");
        String placa = input.nextLine();

        try{
            Veiculo veiculo = service.pesquisarPorPlaca(placa);
            if(veiculo != null){
                System.out.println(veiculo.toString());
            }else{
                System.out.println("Veículo não encontrado com a placa informada");
            }
        }catch (Exception e){
            System.out.println("ERRO: " + e.getMessage());
        }
        aguardarEnter();
    }

    public static void removerPorPlaca() {
        limparTela();
        listar();
        System.out.println("========== REMOVENDO VEICULO ==========");
        System.out.print("Digite a placa do veículo que deseja remover: ");
        String placa = input.nextLine();
        try {
            service.removerPorPlaca(placa);
            System.out.println("Veículo removido com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        aguardarEnter();
    }

    public static void main(String[] args){
        String menu = """
                SISTEMA DE GERENCIAMENTO DE FROTAS
                Menu de Opções:
                1 - Cadastrar novo Veículo;
                2 - Listar todos Veículos cadastrados;
                3 - Pesquisar Veículo pela placa;
                4 - Remover Veículo;
                0 - Sair;
                Digite a opção desejada:  
                """;
        int opcao;
        do {
            limparTela();
            opcao = inputNumerico(menu);
            switch (opcao) {
                case 0:
                    System.out.println("VOLTE SEMPRE!!!");
                    break;
                case 1:
                    adicionar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    pesquisarPorPlaca();
                    break;
                case 4:
                    removerPorPlaca();
                    break;
                default:
                    System.out.println("Opção Inválida!!!");
                    aguardarEnter();
                    break;
            }
        } while (opcao != 0);
    }
}