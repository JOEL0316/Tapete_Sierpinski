import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class SierpinskiCarpet extends JPanel {
    // Nivel de recursividad para el tapete de Sierpinski
    int nivel_de_recursividad = 5;

    public static void main(String[] args) {
        // Crear una ventana JFrame
        JFrame frame = new JFrame("Fractal - Tapete de Sierpinski");

        // Crear una instancia de SierpinskiCarpet (el panel)
        SierpinskiCarpet panel = new SierpinskiCarpet();
        
        // Agregar el panel al frame
        frame.add(panel);
        
        // Ajustar el tamaño de la ventana
        frame.setSize(600, 600);
        
        // Configurar el cierre de la ventana al hacer clic en la "X"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Hacer la ventana visible
        frame.setVisible(true);
        
        // Llamada a repaint para forzar la actualización
        panel.repaint();
    }

    /**
     * Sobrescribir el método paintComponent para realizar el dibujo del fractal.
     */
    @Override
    protected void paintComponent(Graphics g) {
        // Llamar al método de la superclase para asegurarnos de que el panel se pinte correctamente.
        super.paintComponent(g);

        // Coordenadas iniciales del cuadrado grande (base)
        int x = 50;  // Coordenada X del cuadrado inicial
        int y = 50;  // Coordenada Y del cuadrado inicial
        int size = 500;  // Tamaño del cuadrado inicial

        // Llamada inicial para dibujar el tapete de Sierpinski
        drawSierpinskiCarpet(g, x, y, size, nivel_de_recursividad);
    }

    /**
     * Método recursivo para dibujar el tapete de Sierpinski.
     * @param g Objeto Graphics usado para dibujar.
     * @param x Coordenada X de la esquina superior izquierda del cuadrado.
     * @param y Coordenada Y de la esquina superior izquierda del cuadrado.
     * @param size Tamaño del cuadrado actual.
     * @param level El nivel de recursividad.
     */
    private void drawSierpinskiCarpet(Graphics g, int x, int y, int size, int level) {
        if (level == 0) {
            // Caso base: Si el nivel es 0, simplemente dibujamos el cuadrado lleno
            g.fillRect(x, y, size, size);
        } else {
            // Dividimos el cuadrado en una matriz de 3x3
            int newSize = size / 3;

            // Dibujar los 8 subcuadrados, omitiendo el del centro
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    // Saltar el cuadrado central
                    if (row == 1 && col == 1) {
                        // No dibujar el cuadrado central
                        continue;
                    }
                    
                    // Dibujar los subcuadrados recursivamente
                    drawSierpinskiCarpet(g, x + col * newSize, y + row * newSize, newSize, level - 1);
                }
            }
        }
    }
}
