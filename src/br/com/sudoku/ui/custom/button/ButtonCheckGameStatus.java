package br.com.sudoku.ui.custom.button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ButtonCheckGameStatus extends JButton {

    public ButtonCheckGameStatus(final ActionListener actionListener){
        this.setText("Verificar Jogo");
        this.addActionListener(actionListener);
    }
}
