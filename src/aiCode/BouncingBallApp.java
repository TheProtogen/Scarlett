package aiCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BouncingBallApp extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BALL_SIZE = 50;

    private int ballX, ballY;
    private int velocityY;
    private int gravity = 1;

    public BouncingBallApp() {
        // Configurar a janela
        setTitle("Bouncing Ball");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializar a posição da bola
        ballX = WIDTH / 2 - BALL_SIZE / 2;
        ballY = HEIGHT / 2 - BALL_SIZE / 2;
        velocityY = 0;

        // Atualizar a posição da bola em intervalos regulares
        Timer timer = new Timer(20, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateBallPosition();
                repaint();
            }
        });
        timer.start();

        // Adicionar um ouvinte de teclado para controlar a gravidade
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    gravity += 1;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    gravity -= 1;
                    if (gravity < 0) {
                        gravity = 0;
                    }
                }
            }
        });

        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    private void updateBallPosition() {
        velocityY += gravity;
        ballY += velocityY;

        // Colisão com o chão
        if (ballY + BALL_SIZE >= HEIGHT) {
            ballY = HEIGHT - BALL_SIZE;
            velocityY = -velocityY; // Inverte a velocidade para quicar
        }

        // Colisão com o teto
        if (ballY < 0) {
            ballY = 0;
            velocityY = -velocityY; // Inverte a velocidade
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponents(g);

        // Desenhar a bola
        g.setColor(Color.RED);
        g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
    }

    public void paint(Graphics g) {
        super.paint(g);
        paintComponent(g);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BouncingBallApp app = new BouncingBallApp();
                app.setVisible(true);
            }
        });
    }
}