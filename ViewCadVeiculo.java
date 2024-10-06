import java.util.Scanner;

public class ViewCadVeiculo {
    private static ServiceVeiculo service = new ServiceVeiculo();
    static Scanner input = new Scanner(System.in);
    static ServiceVeiculo veiculo = new ServiceVeiculo();

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

    private static void adicionar() throws Exception{
        limparTela();
        Veiculo novoVeiculo = new Veiculo();
        System.out.println("========== ADICIONANDO NOVO VEICULO ==========");
        int tipoVeiculo;

        System.out.print("Informe a marca do Veículo: ");
        String marca = input.nextLine();
        novoVeiculo.setMarca(marca);

        System.out.print("Informe o modelo do Veículo: ");
        String modelo = input.nextLine();
        novoVeiculo.setModelo(modelo);

        System.out.print("Informe o ano do Veículo: ");
        int anoVeiculo = input.nextInt();
        novoVeiculo.setAno(anoVeiculo);
        input.nextLine();

        System.out.print("Informe a placa do Veículo: ");
        String placa = input.nextLine();
        novoVeiculo.setPlaca(placa);

        try {
            veiculo.adicionar(novoVeiculo);
            System.out.println("VEICULO ADICIONADO COM SUCESSO!!!");
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        input.nextLine();

    }
    public static void main(String[] args) throws Exception {
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
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                default:
                    System.out.println("Opção Inválida!!!");
                    aguardarEnter();
                    break;
            }
        } while (opcao != 0);
    }
}