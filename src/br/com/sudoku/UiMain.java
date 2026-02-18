package br.com.sudoku;

import br.com.sudoku.ui.custom.screen.MainScreen;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UiMain {

    public static void main(String[] args){
        final var gameConfig = (Map)Stream.of(args).collect(Collectors.toMap((k) -> k.split(";")[0], (v) -> v.split(";")[1]));
        var mainScreen = new MainScreen(gameConfig);
        mainScreen.buildMainScreen();
    }
}
