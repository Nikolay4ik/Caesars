package GUI;

import Function.WorksFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static Function.WorkCipher.WORK_CIPHER;
import static Function.WorkResources.WORK_RESOURCES;
import static Function.WorksFiles.WORKS_FILES;

public class GuiPageTwo {
    private static final JTextArea FILE_TEXT_LABEL = new JTextArea();
    private static File FILE_TXT_CIPHER;
    private static final String NAME_PATH_SAVE_CIPHER_FILE = "FileTxt\\";

    public static JPanel filesTextCipher() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1, 2, 5, 12));
        jPanel.setBackground(Color.WHITE);
        jPanel.add(txtFilesPanel());
        jPanel.add(buttonTxtFilesPanel());
        return jPanel;
    }

    private static Container txtFilesPanel() {
        JPanel filesJPanel = new JPanel();
        filesJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        filesJPanel.setBackground(Color.WHITE);
        FILE_TEXT_LABEL.setEditable(false);
        final JScrollPane jScrollFileLabel = new JScrollPane(FILE_TEXT_LABEL);
        jScrollFileLabel.setPreferredSize(new Dimension(330, 30));
        filesJPanel.add(jScrollFileLabel);
        return filesJPanel;
    }

    private static Container buttonTxtFilesPanel() {
        JPanel buttonTxtJPanel = new JPanel();
        buttonTxtJPanel.setLayout(new BoxLayout(buttonTxtJPanel, BoxLayout.Y_AXIS));
        buttonTxtJPanel.setBackground(Color.WHITE);
        JButton buttonChoiceFile = new JButton("Выбрать файл");
        buttonChoiceFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int ret = fileChooser.showDialog(null, "Выбрать файл");

                if (ret == JFileChooser.APPROVE_OPTION) {
                    FILE_TXT_CIPHER = fileChooser.getSelectedFile();
                    FILE_TEXT_LABEL.setText(FILE_TXT_CIPHER.getPath());
                }
            }
        });
        JButton buttonRotOneFile = new JButton("Зашифровать файл-1");
        buttonRotOneFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cipherFiles(1);
            }
        });
        JButton buttonRotTwoFile = new JButton("Зашифровать файл-2");
        buttonRotTwoFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cipherFiles(2);
            }
        });
        JButton buttonRotThreeFile = new JButton("Зашифровать файл-3");
        buttonRotThreeFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cipherFiles(3);
            }
        });
        JButton buttonRotFourFile = new JButton("Зашифровать файл-4");
        buttonRotFourFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cipherFiles(4);
            }
        });
        JButton buttonRotFiveFile = new JButton("Зашифровать файл-5");
        buttonRotFiveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cipherFiles(5);
            }
        });
        JButton buttonRotSixFile = new JButton("Зашифровать файл-6");
        buttonRotSixFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cipherFiles(6);
            }
        });
        JButton buttonRotSevenFile = new JButton("Зашифровать файл-7");
        buttonRotSevenFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cipherFiles(7);
            }
        });
        buttonTxtJPanel.add(buttonChoiceFile);
        buttonTxtJPanel.add(buttonRotOneFile);
        buttonTxtJPanel.add(buttonRotTwoFile);
        buttonTxtJPanel.add(buttonRotThreeFile);
        buttonTxtJPanel.add(buttonRotFourFile);
        buttonTxtJPanel.add(buttonRotFiveFile);
        buttonTxtJPanel.add(buttonRotSixFile);
        buttonTxtJPanel.add(buttonRotSevenFile);
        return buttonTxtJPanel;
    }

    private static void cipherFiles(int steps) {
        WORK_RESOURCES.setStepsCode(steps);
        WORK_CIPHER.сhoiceRot(WORK_RESOURCES.getStepsCode());
        WORK_RESOURCES.setLocalePathStart(FILE_TXT_CIPHER.getPath());
        String result = JOptionPane.showInputDialog("Введите название файла для ссохранения");
        if (!result.isEmpty()) {
            WORK_RESOURCES.setNamePathResult(NAME_PATH_SAVE_CIPHER_FILE + result);
            WORKS_FILES.createFileCipher(WorksFiles.parse(WORK_RESOURCES.getLocalePathStart()), WORK_RESOURCES.getNamePathResult());
        }
    }
}

