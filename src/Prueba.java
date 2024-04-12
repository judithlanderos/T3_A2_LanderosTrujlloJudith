import javax.swing.*;
import java.awt.*;


class VentanaInicio extends JFrame {
    GridBagConstraints restricciones = new GridBagConstraints();
    GridBagLayout diseñoGridBag = new GridBagLayout();
    String[] respuestas = new String[10];

    public void llenarRespuestas() {
        for (int i = 0; i < respuestas.length; i++) {
            double aleatorio = Math.random();
            respuestas[i] = (aleatorio < 0.6) ? "si" : "no";
        }

        for (String respuesta : respuestas) {
            System.out.print(respuesta + " ");
        }
        System.out.println();
    }

    public VentanaInicio() {
        getContentPane().setLayout(diseñoGridBag);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Encuesta");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        JLabel etiquetaSi = new JLabel("SI");
        agregarComponente(etiquetaSi, 0, 0, 2, 1);

        JLabel etiquetaNo = new JLabel("NO");
        agregarComponente(etiquetaNo, 3, 0, 2, 1);

        JLabel espacio = new JLabel(" ");
        agregarComponente(espacio, 2, 1, 1, 3);

        String respuestasSi = "";
        for (String respuesta : respuestas) {
            if ("si".equals(respuesta)) {
                respuestasSi += respuesta;
            }
        }

        JTextArea areaSi = new JTextArea();
        areaSi.setText(respuestasSi);
        areaSi.setLineWrap(true);
        areaSi.setWrapStyleWord(true);
        JScrollPane desplazamientoSi = new JScrollPane(areaSi);
        areaSi.setEditable(false);

        agregarComponente(areaSi, 0, 1, 2, 3);
     
        JTextArea areaNo = new JTextArea();
        areaNo.setLineWrap(true);
        areaNo.setWrapStyleWord(true);
        JScrollPane desplazamientoNo = new JScrollPane(areaNo);
        areaNo.setEditable(false);
        agregarComponente(areaNo, 3, 1, 2, 3);
    }

    public void agregarComponente(Component componente, int gridX, int gridY, int ancho, int alto) {
        restricciones.gridx = gridX;
        restricciones.gridy = gridY;
        restricciones.gridwidth = ancho;
        restricciones.gridheight = alto;
        diseñoGridBag.setConstraints(componente, restricciones);
        add(componente);
        restricciones.fill = GridBagConstraints.BOTH;
    }
}

public class Prueba {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaInicio();
        });
        VentanaInicio ventana = new VentanaInicio();
        ventana.llenarRespuestas();
    }
}
