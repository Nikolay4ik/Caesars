package GUI;

import Function.WorkCipher;
import Function.WorkResources;

import static Function.WorkResources.WORK_RESOURCES;
import static Function.WorkCipher.WORK_CIPHER;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GuiResourse {
    private static JTextArea TXT_CONVERT_CIPHER;
    private static JTextArea OUT_TEXT_LABEL;
    private static JButton BUTTON_ROT_ONE;
    private static JButton BUTTON_ROT_TWO;
    private static JButton BUTTON_ROT_THREE;
    private static JButton BUTTON_ROT_FOUR;
    private static JButton BUTTON_ROT_FIVE;
    private static JButton BUTTON_ROT_SIX;
    private static JButton BUTTON_ROT_SEVEN;
    private static JButton BUTTON_CHOICE_FILE;

    public GuiResourse() {
    }

    public static Container centralPanel() {
        Container container = new Container();
        container.setLayout(new GridLayout(1, 2, 5, 12));
        container.setPreferredSize(new Dimension(695, 495));
        container.add(txtPanel());
        container.add(buttonPanel());
        return container;
    }

    public static Container buttonPanel() {
        Container container = new Container();
        container.setLayout(new FlowLayout(FlowLayout.LEFT));
        container.setPreferredSize(new Dimension(695 / 2, 495 / 2));
        container.add(east());
        return container;
    }

    public static JPanel txtPanel() {
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.LEFT));
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
        jScrollPaneConv.setPreferredSize(new Dimension(330, 100));
        OUT_TEXT_LABEL = new JTextArea();
        OUT_TEXT_LABEL.setBorder(BorderFactory.createLineBorder(Color.black));
        OUT_TEXT_LABEL.setBackground(Color.WHITE);
        OUT_TEXT_LABEL.setLineWrap(true);
        OUT_TEXT_LABEL.setEditable(false);
        final JScrollPane jScrollPaneLabel = new JScrollPane(OUT_TEXT_LABEL, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPaneLabel.setPreferredSize(new Dimension(330, 100));
        jPanel.add(jScrollPaneConv);
        jPanel.add(jScrollPaneLabel);
        return jPanel;
    }

    private static Container east() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.setPreferredSize(new Dimension(150, 245));
        BUTTON_ROT_ONE = new JButton("Сдвиг-1");
        BUTTON_ROT_ONE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WORK_RESOURCES.setStepsCode(1);
                WORK_CIPHER.сhoiceRot(WORK_RESOURCES.getStepsCode());
                OUT_TEXT_LABEL.setText(WORK_CIPHER.cipher(TXT_CONVERT_CIPHER.getText()));
            }
        });
        BUTTON_ROT_TWO = new JButton("Сдвиг-2");
        BUTTON_ROT_TWO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WORK_RESOURCES.setStepsCode(2);
                WORK_CIPHER.сhoiceRot(WORK_RESOURCES.getStepsCode());
                OUT_TEXT_LABEL.setText(WORK_CIPHER.cipher(TXT_CONVERT_CIPHER.getText()));
            }
        });
        BUTTON_ROT_THREE = new JButton("Сдвиг-3");
        BUTTON_ROT_THREE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WORK_RESOURCES.setStepsCode(3);
                WORK_CIPHER.сhoiceRot(WORK_RESOURCES.getStepsCode());
                OUT_TEXT_LABEL.setText(WORK_CIPHER.cipher(TXT_CONVERT_CIPHER.getText()));
            }
        });
        BUTTON_ROT_FOUR = new JButton("Сдвиг-4");
        BUTTON_ROT_FOUR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WORK_RESOURCES.setStepsCode(4);
                WORK_CIPHER.сhoiceRot(WORK_RESOURCES.getStepsCode());
                OUT_TEXT_LABEL.setText(WORK_CIPHER.cipher(TXT_CONVERT_CIPHER.getText()));
            }
        });
        BUTTON_ROT_FIVE = new JButton("Сдвиг-5");
        BUTTON_ROT_FIVE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WORK_RESOURCES.setStepsCode(5);
                WORK_CIPHER.сhoiceRot(WORK_RESOURCES.getStepsCode());
                OUT_TEXT_LABEL.setText(WORK_CIPHER.cipher(TXT_CONVERT_CIPHER.getText()));
            }
        });
        BUTTON_ROT_SIX = new JButton("Сдвиг-6");
        BUTTON_ROT_SIX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WORK_RESOURCES.setStepsCode(6);
                WORK_CIPHER.сhoiceRot(WORK_RESOURCES.getStepsCode());
                OUT_TEXT_LABEL.setText(WORK_CIPHER.cipher(TXT_CONVERT_CIPHER.getText()));
            }
        });
        BUTTON_ROT_SEVEN = new JButton("Сдвиг-7");
        BUTTON_ROT_SEVEN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WORK_RESOURCES.setStepsCode(7);
                WORK_CIPHER.сhoiceRot(WORK_RESOURCES.getStepsCode());
                OUT_TEXT_LABEL.setText(WORK_CIPHER.cipher(TXT_CONVERT_CIPHER.getText()));


            }
        });
        BUTTON_CHOICE_FILE = new JButton("Выбрать файл-TXT");
        jPanel.add(BUTTON_ROT_ONE);
        jPanel.add(BUTTON_ROT_TWO);
        jPanel.add(BUTTON_ROT_THREE);
        jPanel.add(BUTTON_ROT_FOUR);
        jPanel.add(BUTTON_ROT_FIVE);
        jPanel.add(BUTTON_ROT_SIX);
        jPanel.add(BUTTON_ROT_SEVEN);
        jPanel.add(BUTTON_CHOICE_FILE);

        return jPanel;
    }

}
