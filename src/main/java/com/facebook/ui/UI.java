package com.facebook.ui;

import javax.swing.*;

public abstract class UI {

    public String getMaskedPassword(String promptMessage) {
        final String password;
        final JPasswordField jpf = new JPasswordField();
        password = JOptionPane.showConfirmDialog(null, jpf, promptMessage,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION ?
                new String(jpf.getPassword()) : "";
        return password;
    }

    public abstract void closeApplication();

}
