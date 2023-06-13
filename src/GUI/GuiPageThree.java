package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static Function.WorkResources.WORK_RESOURCES;
import static Function.WorksFiles.WORKS_FILES;

public class GuiPageThree {
    private static final JTextArea FILE_TEXT_LABEL_PANEL_DECODE = new JTextArea();
    private static File FILE_TXT_DECIPHER;
    private static final String NAME_PATH_SAVE_DECIPHER_FILE = "FileTxt\\";

    public static JPanel filesTextDecipher() {
        JPanel panelDecipher = new JPanel();
        panelDecipher.setLayout(new GridLayout(1, 2, 5, 12));
        panelDecipher.setBackground(Color.WHITE);
        panelDecipher.add(txtFilesPanel());
        panelDecipher.add(buttonTxtFilesPanel());
        return panelDecipher;
    }
    private static Container txtFilesPanel() {
        JPanel filesJPanel = new JPanel();
        filesJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        filesJPanel.setBackground(Color.WHITE);
        FILE_TEXT_LABEL_PANEL_DECODE.setEditable(false);
        final JScrollPane jScrollFileLabel = new JScrollPane(FILE_TEXT_LABEL_PANEL_DECODE);
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
                    FILE_TXT_DECIPHER = fileChooser.getSelectedFile();
                    FILE_TEXT_LABEL_PANEL_DECODE.setText(FILE_TXT_DECIPHER.getPath());
                }
            }
        });
        JButton deCipherFile = new JButton("Расшифровать файл");
        deCipherFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deCipher();
            }
        });
        buttonTxtJPanel.add(buttonChoiceFile);
        buttonTxtJPanel.add(deCipherFile);
    return buttonTxtJPanel;
    }
    private static void deCipher(){
        WORK_RESOURCES.setNamePathResult(FILE_TXT_DECIPHER.getPath());
        String result = JOptionPane.showInputDialog("Введите название файла для ссохранения");
        if (!result.isEmpty()) {
            WORK_RESOURCES.setLocalePathDecod(NAME_PATH_SAVE_DECIPHER_FILE+result);
            WORKS_FILES.createFileDecoding(WORKS_FILES.parse(WORK_RESOURCES.getNamePathResult()), WORK_RESOURCES.getLocalePathDecod());
        }
    }

}
