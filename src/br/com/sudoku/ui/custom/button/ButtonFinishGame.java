package br.com.sudoku.ui.custom.button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ButtonFinishGame extends JButton {

    public ButtonFinishGame(final ActionListener actionListener){
        this.setText("Concluir Jogo");
        this.addActionListener(actionListener);
    }
}
