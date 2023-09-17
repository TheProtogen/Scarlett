package aiCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreadMonitorApp extends JFrame {
    private JTextArea threadListTextArea;

    public ThreadMonitorApp() {
        // Configurar a janela
        setTitle("Monitor de Threads");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Rótulo para exibir informações das threads
        JLabel threadLabel = new JLabel("Threads em Execução:");

        // Área de texto para listar as threads
        threadListTextArea = new JTextArea();
        threadListTextArea.setEditable(false);

        // Botão para atualizar a lista de threads
        JButton refreshButton = new JButton("Atualizar");
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshThreadList();
            }
        });

        // Layout da janela
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(threadLabel, BorderLayout.NORTH);
        panel.add(new JScrollPane(threadListTextArea), BorderLayout.CENTER);
        panel.add(refreshButton, BorderLayout.SOUTH);

        getContentPane().add(panel);
    }

    private void refreshThreadList() {
        ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();
        while (rootGroup.getParent() != null) {
            rootGroup = rootGroup.getParent();
        }

        Thread[] threads = new Thread[rootGroup.activeCount()];
        int threadCount = rootGroup.enumerate(threads);

        threadListTextArea.setText(""); // Limpar o conteúdo anterior
        for (int i = 0; i < threadCount; i++) {
            threadListTextArea.append(threads[i].getName() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ThreadMonitorApp app = new ThreadMonitorApp();
                app.setVisible(true);
            }
        });
    }
}

