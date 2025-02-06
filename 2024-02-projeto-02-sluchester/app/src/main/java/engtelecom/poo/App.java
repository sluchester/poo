/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package engtelecom.poo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private CamadaDeRede camadaDeRede = new CamadaDeRede();

    Scanner entrada = new Scanner(System.in);

    //menu de opcoes inicial
    public int menuOpcao(){
        System.out.println("*****************************************************************************");
        System.out.println("-----------------------SIMULADOR DE REDES TCP/IP-----------------------------");
        System.out.println("*****************************************************************************");
        System.out.println();
        System.out.println("Escolha entre uma das opções abaixo:");
        System.out.println("Digite 1 para listar os dispositivos da rede por tipo");
        System.out.println("Digite 2 para listar os dispositivos por rede");
        System.out.println("Digite 3 para listar as rotas do roteador");
        System.out.println("Digite 4 para listar as regras de filtragem");
        System.out.println("Digite 5 para criar uma nova regra de filtragem");
        System.out.println("Digite 6 para apagar uma regra filtragem");
        System.out.println("Digite 7 para simular o processamento de um pacote pela rede");
        System.out.println("Digite 8 para sair do programa");

        int op = entrada.nextInt();
        entrada.nextLine();

        return op;
    }

    //separa a string lida do teclado em um vetor de strings para ser passada como parâmetro
    public String[] separaStringLida(String stringLida){
        String vet[] = stringLida.split(" ");
        return vet;
    }

    //menu com as instruções para criar uma regra no firewall
    public String[] menuCriarRegraFirewall(){
        System.out.println("**************************************************************************");
        System.out.println("*Você entrou no menu de criação de regra. !!!SIGA AS ISNTRUÇÕES ABAIXO!!!*");
        System.out.println("**************************************************************************");
        System.out.println("Para cada informação que você digitar, DÊ UM ESPAÇO.");
        System.out.println("- Os endereços IP possuem 4 números.\n- As portas são números únicos.\n- A ação é 1(ENCAMINHAR) ou 0(DESCARTAR)");
        System.out.println("EXEMPLO: 2301 2 4353 4 1");
        System.out.println("Digite o Endereço IP de Origem, a Porta de Origem, o Endereço IP de Destino,\na Porta de Destino" +
                " e a ação a ser executada (1 ou 0)");

        String stringLida  = entrada.nextLine();
        String vet[] = separaStringLida(stringLida);

        return vet;
    }

    public void mensagemCriacaoRegraSucesso(){
        System.out.println("Regra criada com sucesso!");
    }

    public void mensagemCriacaoRegraFracasso(){
        System.out.println("Falha na criação da regra. Tente novamente");
    }

    public int menuApagarRegraFirewall(){
        System.out.println("Você entrou no menu de criação de regra.");
        System.out.println("Digite o número da regra que deseja excluir:");

        int numRegra = entrada.nextInt();
        entrada.nextLine();

        return numRegra;
    }

    public void mensagemApagarRegraSucesso(){
        System.out.println("Regra apagada com sucesso!");
    }

    public void mensagemApagarRegraFracasso(){
        System.out.println("Falha ao apagar a regra. Tente novamente");
    }

    //menu para a opção de simulação com pacote
    public String[] menuSimulacao(){
        System.out.println("--------------------------------------------------------------");
        System.out.println("--------------Você entrou no menu de simulação----------------");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Para efetuar a simulação, forneça os seguintes itens COM UM ESPAÇO ENTRE CADA ITEM:");
        System.out.println("-Endereço IP de Origem\n-Porta de Origem\n-Endereço IP de Destino\n-Porta de Destino\n" +
                "-Endereço MAC de Destino\n-Conteudo (Payload)\n");
        System.out.println("EXEMPLO: 1234 2 3213 0 C1 Ola");

        String stringLida  = entrada.nextLine();
        String vet[] = separaStringLida(stringLida);

        return vet;
    }

    public void mensagemFinal(){
        System.out.println("Obrigado por usar o programa! Até mais o/");
    }

    public static void main(String[] args) {
        App app = new App();
        Scanner mainEntrada = new Scanner(System.in);

        //flag para sair do while e finalizar o programa
        boolean finalizarPrograma = false;
        while(!finalizarPrograma){
            //pega a opção escolhida pelo usuario no menuOpcao
            switch (app.menuOpcao()){
                //recebe uma tabela hash com todos os dispositivos e itera ela para mostrar o tipo correto
                case 1:{
                    HashMap<Integer, ArrayList<Dispositivo>> tabelaTipos= app.camadaDeRede.listarDispositivosPorTipo();
                    tabelaTipos.forEach((chave, valorDispositivos) -> {
                        switch (chave){
                            case 1:{
                                System.out.println("Comutador");
                                break;
                            }
                            case 2:{
                                System.out.println("Endpoint");
                                break;
                            }
                            case 3:{
                                System.out.println("Firewall");
                                break;
                            }
                            case 4:{
                                System.out.println("Roteador");
                                break;
                            }
                        }
                        for (Dispositivo dispositivo : valorDispositivos) {
                            System.out.print("Endereço IP: " + dispositivo.getEnderecoIp()); System.out.print(" || ");
                            System.out.println("Endereço MAC: " + dispositivo.getEnderecoMac());
                        }
                    });
                    break;
                }

                //obtém uma lista com todos os dispositivos separados por lista de redes
                    //com a iteração é possível separar por rede
                case 2:{
                    ArrayList<ArrayList<Dispositivo>> listaCompleta = app.camadaDeRede.listarDispositivosPorRede();
                    for(ArrayList<Dispositivo> listaAuxiliar : listaCompleta){
                        for(Dispositivo dispositivo : listaAuxiliar){
                            System.out.println("Rede " + dispositivo.getEnderecoIp().charAt(0));
                            System.out.print("Endereço IP: " + dispositivo.getEnderecoIp()); System.out.print(" || ");
                            System.out.println("Endereço MAC: " + dispositivo.getEnderecoMac());
                        }
                    }
                    break;
                }

                //obtém a tabela hash do roteador para mostrar as rotas
                case 3:{
                    HashMap<Integer, String> tabelaRotaRedes = app.camadaDeRede.listarRotasDoRoteador();
                    tabelaRotaRedes.forEach((rota, enderecoIp)->
                            System.out.println("Rota: " + rota + " - IP: " + enderecoIp));
                    break;
                }

                //obtém a lista de regras do firewall
                case 4:{
                    ArrayList<RegraFirewall> regras = app.camadaDeRede.listarRegrasDeFiltragem();
                    for (RegraFirewall regraFirewall : regras) {
                        System.out.println("Regra(s) " + regras.indexOf(regraFirewall) + ":\n" + regraFirewall);
                    }
                    break;
                }

                //recebe um vetor de string do usuário com as informações necessárias para criar uma regra
                    //caso seja digitado alguma informação errada, retorna uma exceção
                case 5:{
                    try{
                        String regraCriada[] = app.menuCriarRegraFirewall();
                        if(app.camadaDeRede.criarRegraDeFiltragem(regraCriada[0], Integer.valueOf(regraCriada[1]), regraCriada[2],
                                Integer.valueOf(regraCriada[3]), Integer.valueOf(regraCriada[4]))){
                            app.mensagemCriacaoRegraSucesso();
                        } else{app.mensagemCriacaoRegraFracasso();}
                    } catch (InputMismatchException e){
                        System.err.println("Algo deu errado. Leia as instruções e tente novamente\n");
                    }
                    break;
                }

                //permite ao usuário apagar uma regra que ele tenha criado
                case 6:{
                    int numRegraParaApagar = app.menuApagarRegraFirewall();
                    if(app.camadaDeRede.apagarRegraDeFiltragem(numRegraParaApagar)){
                        app.mensagemApagarRegraSucesso();
                    } else {app.mensagemApagarRegraFracasso();}
                    break;
                }

                //permite o usuário criar um pacote IP e simular ele passando pela rede
                case 7:{
                    try{
                        String pacoteIp[] = app.menuSimulacao();
                        app.camadaDeRede.montarPacoteip(pacoteIp[0], Integer.valueOf(pacoteIp[1]),
                                pacoteIp[2], Integer.valueOf(pacoteIp[3]), pacoteIp[4], pacoteIp[5]);
                        System.out.println(app.camadaDeRede.simularProcessamentoDePacote());
                    } catch (InputMismatchException e){
                        System.err.println("Algo deu errado. Leia as instruções e tente novamente\n");
                    }
                    break;
                }

                //sai do programa
                case 8:{
                    finalizarPrograma = true;
                    break;
                }
            }
        }
        app.mensagemFinal();
    }
}