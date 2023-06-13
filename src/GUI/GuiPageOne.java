package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static Function.WorkCipher.WORK_CIPHER;
import static Function.WorkResources.WORK_RESOURCES;

public class GuiPageOne {
    private static JTextArea TXT_CONVERT_CIPHER;
    private static JTextArea OUT_TEXT_LABEL;



    public GuiPageOne() {
    }

    public static Container centralPanel() {
        JTabbedPane jTabbedPane = new JTabbedPane();
        Font font = new Font("Verdana", Font.PLAIN, 10);
        jTabbedPane.setFont(font);
        JPanel pageOne = new JPanel();
        pageOne.setBackground(Color.WHITE);
        pageOne.setLayout(new GridLayout(1, 2, 5, 12));
        pageOne.add(txtPanel());
        pageOne.add(buttonPanel());
        pageOne.add(label());
        jTabbedPane.addTab("Зашифровать текст", pageOne);
        jTabbedPane.addTab("Зашифровать файл",GuiPageTwo.filesTextCipher());
        jTabbedPane.addTab("Расшифровать файл",GuiPageThree.filesTextDecipher());
        jTabbedPane.setBackground(Color.WHITE);
        return jTabbedPane;
    }

    public static Container buttonPanel() {
        Container container = new Container();
        container.setLayout(new FlowLayout(FlowLayout.LEFT));
        container.setPreferredSize(new Dimension(695 / 2, 495 / 2));
        container.add(east());
        return container;
    }

    public static Container label() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        jPanel.setBackground(Color.WHITE);
        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("images\\icon.PNG");
        imageLabel.setIcon(imageIcon);
        jPanel.add(imageLabel);
        return jPanel;
    }

    public static JPanel txtPanel() {
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.RIGHT));
        container.setPreferredSize(new Dimension(400, 300));
        west(container);
        return container;
    }


    private static JPanel west(JPanel jPanel) {
        TXT_CONVERT_CIPHER = new JTextArea();
        TXT_CONVERT_CIPHER.setBorder(BorderFactory.createLineBorder(Color.black));
        TXT_CONVERT_CIPHER.setBackground(Color.WHITE);
        TXT_CONVERT_CIPHER.setLineWrap(true);

        final JScrollPane jScrollPaneConv = new JScrollPane(TXT_CONVERT_CIPHER, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPaneConv.setPreferredSize(new Dimension(220, 100));
        OUT_TEXT_LABEL = new JTextArea();
        OUT_TEXT_LABEL.setBorder(BorderFactory.createLineBorder(Color.black));
        OUT_TEXT_LABEL.setBackground(Color.WHITE);
        OUT_TEXT_LABEL.setLineWrap(true);
        OUT_TEXT_LABEL.setEditable(false);
        final JScrollPane jScrollPaneLabel = new JScrollPane(OUT_TEXT_LABEL, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPaneLabel.setPreferredSize(new Dimension(220, 100));


        jPanel.add(jScrollPaneConv);
        jPanel.add(jScrollPaneLabel);
        jPanel.setBackground(Color.WHITE);
        return jPanel;
    }

    private static Container east() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.setPreferredSize(new Dimension(250, 280));
        jPanel.setBackground(Color.WHITE);
        JButton BUTTON_ROT_ONE = new JButton("Зашифровать текст-1");
        BUTTON_ROT_ONE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               workCipherText(1);
            }
        });
        JButton BUTTON_ROT_TWO = new JButton("Зашифровать текст-2");
        BUTTON_ROT_TWO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             workCipherText(2);
            }
        });
        JButton BUTTON_ROT_THREE = new JButton("Зашифровать текст-3");
        BUTTON_ROT_THREE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               workCipherText(3);
            }
        });
        JButton BUTTON_ROT_FOUR = new JButton("Зашифровать текст-4");
        BUTTON_ROT_FOUR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workCipherText(4);
            }
        });
        JButton BUTTON_ROT_FIVE = new JButton("Зашифровать текст-5");
        BUTTON_ROT_FIVE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               workCipherText(5);
            }
        });
        JButton BUTTON_ROT_SIX = new JButton("Зашифровать текст-6");
        BUTTON_ROT_SIX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               workCipherText(6);
            }
        });
        JButton BUTTON_ROT_SEVEN = new JButton("Зашифровать текст-7");
        BUTTON_ROT_SEVEN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               workCipherText(7);


            }
        });
        jPanel.add(BUTTON_ROT_ONE);
        jPanel.add(BUTTON_ROT_TWO);
        jPanel.add(BUTTON_ROT_THREE);
        jPanel.add(BUTTON_ROT_FOUR);
        jPanel.add(BUTTON_ROT_FIVE);
        jPanel.add(BUTTON_ROT_SIX);
        jPanel.add(BUTTON_ROT_SEVEN);
        return jPanel;
    }
private static void workCipherText(int step){
    WORK_RESOURCES.setStepsCode(step);
    WORK_CIPHER.сhoiceRot(WORK_RESOURCES.getStepsCode());
    OUT_TEXT_LABEL.setText(WORK_CIPHER.cipher(TXT_CONVERT_CIPHER.getText()));
}


}
