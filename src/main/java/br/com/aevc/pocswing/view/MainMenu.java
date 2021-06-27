package br.com.aevc.pocswing.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JMenuBar {

    // menu
    private JMenuItem mItemConfig;
    private JMenuItem mItemExit;
    private JMenuItem mItemAbout;

    //BAD PRACTICE HIGHLY COUPLED
    public MainMenu() {
        JMenu menuFile = new JMenu("Arquivo");

        MainMenuActionListener mainMenuActionListener = new MainMenuActionListener();

        this.mItemConfig = new JMenuItem("Config", new ImageIcon(
                Toolkit.getDefaultToolkit().getImage(
                        getClass().getResource("/resources/gear.png")
                )
        ));
        this.mItemConfig.addActionListener(mainMenuActionListener);

        this.mItemExit = new JMenuItem("Sair");
        mItemExit.addActionListener(mainMenuActionListener);

        menuFile.add(this.mItemConfig);
        menuFile.addSeparator();
        menuFile.add(this.mItemExit);

        add(menuFile);

        // HELP
        JMenu menuHelp = new JMenu("Ajuda");
        mItemAbout = new JMenuItem("Sobre");
        mItemAbout.addActionListener(mainMenuActionListener);
        menuHelp.add(mItemAbout);

        add(menuHelp);
    }

    //BAD PRACTICE HIGHLY COUPLED
    private class MainMenuActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            // EXIT
            if (event.getSource().equals(mItemExit)) {
                setVisible(false);
                System.exit(0);
            }

            // LOGIN
            if (event.getSource().equals(mItemConfig)) {
                // showDialog(true);
            }
            // ABOUT
            if (event.getSource().equals(mItemAbout)) {
                // JDialog dialogAbout = new JDialog();
                System.out.println("ABOUT");
            }
        }

    }

}
