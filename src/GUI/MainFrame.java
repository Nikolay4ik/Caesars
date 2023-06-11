package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public static final int WIDTH = 700;
    public static final int HEIGHT = 350;
    private static final String PATH_TO_ICON = "images\\icon32x32.PNG";
    private static final String APPLICATION_NAME = "Caesar";


    MainFrame() {
        super(APPLICATION_NAME);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new BorderLayout());
        add(GuiResourse.centralPanel(),BorderLayout.CENTER);
        ImageIcon imageIcon = new ImageIcon(PATH_TO_ICON);
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);
        caesarIcon();
        pack();
        setVisible(true);

    }

    private void caesarIcon() {
        if (!SystemTray.isSupported()) {
            return;
        }
        PopupMenu popupMenu = new PopupMenu();
        MenuItem item = new MenuItem("Exit");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        popupMenu.add(item);
        item=new MenuItem("Open");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(true);
                setExtendedState(JFrame.NORMAL);
            }
        });
        popupMenu.add(item);
        item=new MenuItem("Collapse");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                setExtendedState(JFrame.NORMAL);
            }
        });
        popupMenu.add(item);


        Image icon = Toolkit.getDefaultToolkit().getImage(PATH_TO_ICON);
        TrayIcon trayIcon = new TrayIcon(icon, APPLICATION_NAME, popupMenu);
        trayIcon.setImageAutoSize(true);

        SystemTray systemTray = SystemTray.getSystemTray();
        try {
            systemTray.add(trayIcon);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        trayIcon.displayMessage(APPLICATION_NAME, "Application started!", TrayIcon.MessageType.INFO);
    }
}
