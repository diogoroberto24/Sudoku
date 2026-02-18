package br.com.sudoku.ui.custom.button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ButtonReset extends JButton {
    public ButtonReset(final ActionListener actionListener){
        this.setText("Resetar Jogo");
        this.addActionListener(actionListener);
    }
}
