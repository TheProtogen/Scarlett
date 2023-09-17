package aiCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class SystemPropertiesViewer extends JFrame {
    private JTextArea propertiesTextArea;

    public SystemPropertiesViewer() {
        // Configurar a janela
        setTitle("Propriedades do Computador");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Área de texto para exibir as propriedades
        propertiesTextArea = new JTextArea();
        propertiesTextArea.setEditable(false);

        // Botão para exibir as propriedades
        JButton showPropertiesButton = new JButton("Mostrar Propriedades");
        showPropertiesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showSystemProperties();
            }
        });

        // Layout da janela
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(propertiesTextArea), BorderLayout.CENTER);
        panel.add(showPropertiesButton, BorderLayout.SOUTH);

        getContentPane().add(panel);
    }

    private void showSystemProperties() {
        Properties systemProperties = System.getProperties();
        StringBuilder propertiesText = new StringBuilder();

        for (String key : systemProperties.stringPropertyNames()) {
            String value = systemProperties.getProperty(key);
            propertiesText.append(key).append(": ").append(value).append("\n");
        }

        propertiesTextArea.setText(propertiesText.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SystemPropertiesViewer app = new SystemPropertiesViewer();
                app.setVisible(true);
            }
        });
    }
}