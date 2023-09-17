package aiCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessKiller extends JFrame {
    private JTextArea processListTextArea;
    private JTextField processNameField;

    public ProcessKiller() {
        // Configurar a janela
        setTitle("Gerenciador de Processos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Área de texto para listar os processos
        processListTextArea = new JTextArea();
        processListTextArea.setEditable(false);

        // Campo de texto para inserir o nome do processo a ser encerrado
        processNameField = new JTextField(25);

        // Botão para listar os processos
        JButton listProcessesButton = new JButton("Listar Processos");
        listProcessesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listProcesses();
            }
        });

        // Botão para encerrar o processo
        JButton killProcessButton = new JButton("Encerrar Processo");
        killProcessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                killProcess();
            }
        });

        // Layout da janela
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(processListTextArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new FlowLayout());
        
        inputPanel.add(processNameField);
        inputPanel.add(listProcessesButton);
        inputPanel.add(killProcessButton);

        panel.add(inputPanel, BorderLayout.SOUTH);

        getContentPane().add(panel);
    }

    private void listProcesses() {
        try {
            // Executar o comando para listar os processos
            Process process = Runtime.getRuntime().exec("tasklist /fo csv /nh");

            // Ler a saída do comando
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder processList = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                processList.append(line).append("\n");
            }

            reader.close();
            processListTextArea.setText(processList.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void killProcess() {
        String processName = processNameField.getText().trim();

        if (!processName.isEmpty()) {
            try {
                // Executar o comando para encerrar o processo
                Process process = Runtime.getRuntime().exec("taskkill /f /im " + processName);

                // Esperar que o comando termine
                int exitCode = process.waitFor();

                if (exitCode == 0) {
                    JOptionPane.showMessageDialog(this, "Processo '" + processName + "' encerrado com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(this, "Não foi possível encerrar o processo '" + processName + "'.");
                }
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, insira o nome do processo a ser encerrado.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ProcessKiller app = new ProcessKiller();
                app.setVisible(true);
            }
        });
    }
}

