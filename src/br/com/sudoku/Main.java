package br.com.sudoku;

import br.com.sudoku.model.Board;
import br.com.sudoku.model.Space;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final Scanner scanner;
    private static Board board;
    private static final int BOARD_LIMIT = 9;

    public static void main(String[] args) {
        final var positions = (Map)Stream.of(args).collect(Collectors.toMap((k) -> k.split(";")[0], (v) -> v.split(";")[1]));
        int option = -1;

        while(true) {
            System.out.println("Selecione uma das opções a seguir");
            System.out.println("1 - Iniciar um novo Jogo");
            System.out.println("2 - Colocar um novo número");
            System.out.println("3 - Remover um número");
            System.out.println("4 - Visualizar jogo atual");
            System.out.println("5 - Verificar status do jogo");
            System.out.println("6 - limpar jogo");
            System.out.println("7 - Finalizar jogo");
            System.out.println("8 - Sair");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    startGame(positions);
                    break;
                case 2:
                    inputNumber();
                    break;
                case 3:
                    removeNumber();
                    break;
                case 4:
                    showCurrentGame();
                    break;
                case 5:
                    showGameStatus();
                    break;
                case 6:
                    clearGame();
                    break;
                case 7:
                    finishGame();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida, selecione uma das opções do menu");
            }
        }
    }

    private static void startGame(Map<String, String> positions) {
        if (Objects.nonNull(board)) {
            System.out.println("O jogo já foi iniciado");
        } else {
            List<List<Space>> spaces = new ArrayList();

            for(int i = 0; i < 9; ++i) {
                spaces.add(new ArrayList());

                for(int j = 0; j < 9; ++j) {
                    String positionConfig = (String)positions.get("%s,%s".formatted(i, j));
                    int expected = Integer.parseInt(positionConfig.split(",")[0]);
                    boolean fixed = Boolean.parseBoolean(positionConfig.split(",")[1]);
                    Space currentSpace = new Space(expected, fixed);
                    ((List)spaces.get(i)).add(currentSpace);
                }
            }

            board = new Board(spaces);
            System.out.println("O jogo está pronto para começar");
        }
    }

    private static void inputNumber() {
        if (Objects.isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado iniciado");
        } else {
            System.out.println("Informe a coluna que em que o número será inserido");
            int col = runUntilGetValidNumber(0, 8);
            System.out.println("Informe a linha que em que o número será inserido");
            int row = runUntilGetValidNumber(0, 8);
            System.out.printf("Informe o número que vai entrar na posição [%s,%s]\n", col, row);
            int value = runUntilGetValidNumber(1, 9);
            if (!board.changeValue(col, row, value)) {
                System.out.printf("A posição [%s,%s] tem um valor fixo\n", col, row);
            }

        }
    }

    private static void removeNumber() {
        if (Objects.isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado iniciado");
        } else {
            System.out.println("Informe a coluna que em que o número será removido");
            int col = runUntilGetValidNumber(0, 8);
            System.out.println("Informe a linha que em que o número será removido");
            int row = runUntilGetValidNumber(0, 8);
            if (!board.clearValue(col, row)) {
                System.out.printf("A posição [%s,%s] tem um valor fixo\n", col, row);
            }

        }
    }

    private static void showCurrentGame() {
        if (Objects.isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado iniciado");
        } else {
            Object[] args = new Object[81];
            int argPos = 0;

            for(int i = 0; i < 9; ++i) {
                for(List<Space> col : board.getSpaces()) {
                    int var10001 = argPos++;
                    Object var10002 = Objects.isNull(((Space)col.get(i)).getActual()) ? " " : ((Space)col.get(i)).getActual();
                    args[var10001] = " " + String.valueOf(var10002);
                }
            }

            System.out.println("Seu jogo se encontra da seguinte forma");
            System.out.printf("*************************************************************************************\n*|---0---||---1---||---2---|*|---3---||---4---||---5---|*|---6---||---7---||---8---|*\n*|       ||       ||       |*|       ||       ||       |*|       ||       ||       |*\n0|  %s   ||  %s   ||  %s   |*|  %s   ||  %s   ||  %s   |*|  %s   ||  %s   ||  %s   |0\n*|       ||       ||       |*|       ||       ||       |*|       ||       ||       |*\n*|-------||-------||-------|*|-------||-------||-------|*|-------||-------||-------|*\n*|-------||-------||-------|*|-------||-------||-------|*|-------||-------||-------|*\n*|       ||       ||       |*|       ||       ||       |*|       ||       ||       |*\n1|  %s   ||  %s   ||  %s   |*|  %s   ||  %s   ||  %s   |*|  %s   ||  %s   ||  %s   |1\n*|       ||       ||       |*|       ||       ||       |*|       ||       ||       |*\n*|-------||-------||-------|*|-------||-------||-------|*|-------||-------||-------|*\n*|-------||-------||-------|*|-------||-------||-------|*|-------||-------||-------|*\n*|       ||       ||       |*|       ||       ||       |*|       ||       ||       |*\n2|  %s   ||  %s   ||  %s   |*|  %s   ||  %s   ||  %s   |*|  %s   ||  %s   ||  %s   |2\n*|       ||       ||       |*|       ||       ||       |*|       ||       ||       |*\n*|-------||-------||-------|*|-------||-------||-------|*|-------||-------||-------|*\n*************************************************************************************\n*|-------||-------||-------|*|-------||-------||-------|*|-------||-------||-------|*\n*|       ||       ||       |*|       ||       ||       |*|       ||       ||       |*\n3|  %s   ||  %s   ||  %s   |*|  %s   ||  %s   ||  %s   |*|  %s   ||  %s   ||  %s   |3\n*|       ||       ||       |*|       ||       ||       |*|       ||       ||       |*\n*|-------||-------||-------|*|-------||-------||-------|*|-------||-------||-------|*\n*|-------||-------||-------|*|-------||-------||-------|*|-------||-------||-------|*\n*|       ||       ||       |*|       ||       ||       |*|       ||       ||       |*\n4|  %s   ||  %s   ||  %s   |*|  %s   ||  %s   ||  %s   |*|  %s   ||  %s   ||  %s   |4\n*|       ||       ||       |*|       ||       ||       |*|       ||       ||       |*\n*|-------||-------||-------|*|-------||-------||-------|*|-------||-------||-------|*\n*|-------||-------||-------|*|-------||-------||-------|*|-------||-------||-------|*\n*|       ||       ||       |*|       ||       ||       |*|       ||       ||       |*\n5|  %s   ||  %s   ||  %s   |*|  %s   ||  %s   ||  %s   |*|  %s   ||  %s   ||  %s   |5\n*|       ||       ||       |*|       ||       ||       |*|       ||       ||       |*\n*|-------||-------||-------|*|-------||-------||-------|*|-------||-------||-------|*\n*************************************************************************************\n*|-------||-------||-------|*|-------||-------||-------|*|-------||-------||-------|*\n*|       ||       ||       |*|       ||       ||       |*|       ||       ||       |*\n6|  %s   ||  %s   ||  %s   |*|  %s   ||  %s   ||  %s   |*|  %s   ||  %s   ||  %s   |6\n*|       ||       ||       |*|       ||       ||       |*|       ||       ||       |*\n*|-------||-------||-------|*|-------||-------||-------|*|-------||-------||-------|*\n*|-------||-------||-------|*|-------||-------||-------|*|-------||-------||-------|*\n*|       ||       ||       |*|       ||       ||       |*|       ||       ||       |*\n7|  %s   ||  %s   ||  %s   |*|  %s   ||  %s   ||  %s   |*|  %s   ||  %s   ||  %s   |7\n*|       ||       ||       |*|       ||       ||       |*|       ||       ||       |*\n*|-------||-------||-------|*|-------||-------||-------|*|-------||-------||-------|*\n*|-------||-------||-------|*|-------||-------||-------|*|-------||-------||-------|*\n*|       ||       ||       |*|       ||       ||       |*|       ||       ||       |*\n8|  %s   ||  %s   ||  %s   |*|  %s   ||  %s   ||  %s   |*|  %s   ||  %s   ||  %s   |8\n*|       ||       ||       |*|       ||       ||       |*|       ||       ||       |*\n*|---0---||---1---||---2---|*|---3---||---4---||---5---|*|---6---||---7---||---8---|*\n*************************************************************************************\n\n", args);
        }
    }

    private static void showGameStatus() {
        if (Objects.isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado iniciado");
        } else {
            System.out.printf("O jogo atualmente se encontra no status %s\n", board.getStatus().getLabel());
            if (board.hasErrors()) {
                System.out.println("O jogo contém erros");
            } else {
                System.out.println("O jogo não contém erros");
            }

        }
    }

    private static void clearGame() {
        if (Objects.isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado iniciado");
        } else {
            System.out.println("Tem certeza que deseja limpar seu jogo e perder todo seu progresso?");

            String confirm;
            for(confirm = scanner.next(); !confirm.equalsIgnoreCase("sim") && !confirm.equalsIgnoreCase("não"); confirm = scanner.next()) {
                System.out.println("Informe 'sim' ou 'não'");
            }

            if (confirm.equalsIgnoreCase("sim")) {
                board.reset();
            }

        }
    }

    private static void finishGame() {
        if (Objects.isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado iniciado");
        } else {
            if (board.gameIsFinished()) {
                System.out.println("Parabéns você concluiu o jogo");
                showCurrentGame();
                board = null;
            } else if (board.hasErrors()) {
                System.out.println("Seu jogo conté, erros, verifique seu board e ajuste-o");
            } else {
                System.out.println("Você ainda precisa preenhcer algum espaço");
            }

        }
    }

    private static int runUntilGetValidNumber(int min, int max) {
        int current;
        for(current = scanner.nextInt(); current < min || current > max; current = scanner.nextInt()) {
            System.out.printf("Informe um número entre %s e %s\n", min, max);
        }

        return current;
    }

    static {
        scanner = new Scanner(System.in);
    }
}
