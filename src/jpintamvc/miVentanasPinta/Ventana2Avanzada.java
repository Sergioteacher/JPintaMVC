/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jpintamvc.miVentanasPinta;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

/**
 * Clase de la ventana AVANZADA
 * @author Sergio Teacher
 */
public class Ventana2Avanzada extends javax.swing.JFrame {

    /**
     * Constructor de la ventana Avanzada
     */
    public Ventana2Avanzada() {
        initComponents();
        System.out.println("Lanzando la ventana AVANZADA");
        setBounds(0,0,500,400);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupOption = new javax.swing.ButtonGroup();
        PanelNorte = new javax.swing.JPanel();
        optionEscala = new javax.swing.JRadioButton();
        jSliderEscala = new javax.swing.JSlider();
        optionValores = new javax.swing.JRadioButton();
        jTextX = new javax.swing.JTextField();
        jTextY = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();
        txtFoto = new javax.swing.JLabel();
        txtEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroupOption.add(optionEscala);
        optionEscala.setText("%");
        PanelNorte.add(optionEscala);

        jSliderEscala.setEnabled(false);
        PanelNorte.add(jSliderEscala);

        buttonGroupOption.add(optionValores);
        optionValores.setText("Ok");
        PanelNorte.add(optionValores);

        jTextX.setColumns(3);
        jTextX.setEnabled(false);
        PanelNorte.add(jTextX);

        jTextY.setColumns(3);
        jTextY.setEnabled(false);
        PanelNorte.add(jTextY);

        btnOK.setText("OK");
        btnOK.setEnabled(false);
        PanelNorte.add(btnOK);

        getContentPane().add(PanelNorte, java.awt.BorderLayout.PAGE_START);

        txtFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(txtFoto, java.awt.BorderLayout.CENTER);

        txtEstado.setText("Tamaño:");
        getContentPane().add(txtEstado, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelNorte;
    private javax.swing.JButton btnOK;
    private javax.swing.ButtonGroup buttonGroupOption;
    private javax.swing.JSlider jSliderEscala;
    private javax.swing.JTextField jTextX;
    private javax.swing.JTextField jTextY;
    private javax.swing.JRadioButton optionEscala;
    private javax.swing.JRadioButton optionValores;
    private javax.swing.JLabel txtEstado;
    private javax.swing.JLabel txtFoto;
    // End of variables declaration//GEN-END:variables

    /**
    * Doy control selectivo, sólo a la capacidad de cargar una imagen.
    */
    public void setIconTxtFoto(ImageIcon MiImagen) {
        this.txtFoto.setIcon(MiImagen); ;
    }

    /**
    * Doy control selectivo, sólo a la capacidad de escuchar.
    */
    public void addActionListenerOptionEscala(ActionListener l) {
        optionEscala.addActionListener(l);
    }

    /**
    * Doy control selectivo, sólo a la capacidad de escuchar.
    */
    public void addActionListenerOptionValores(ActionListener l) {
        optionValores.addActionListener(l);
    }


    /**
    * Doy control total del Botón OK
    */
    public JButton getBtnOK() {
        return btnOK;
    }

    /**
    * Doy control total del deslizador
    */
    public JSlider getjSliderEscala() {
        return jSliderEscala;
    }

    /**
    * Doy control total de la caja de texto
    */
    public JTextField getjTextX() {
        return jTextX;
    }

    /**
    * Doy control total de la caja de texto
    */
    public JTextField getjTextY() {
        return jTextY;
    }

    /**
    * Doy control selectivo, sólo a la capacidad de escribir.
    */
    public void escribeTxtEstado(String s) {
        txtEstado.setText(s);
        System.out.println(s);
    }


}
