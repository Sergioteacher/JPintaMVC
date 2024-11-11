/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jpintamvc.miVentanasPinta;

import javax.swing.ImageIcon;

/**
 * Clase de la ventana básica de carga de foto
 * @author Sergio Teacher
 */
public class Ventana1Basica extends javax.swing.JFrame {

    /**
     * Constructor de la ventana básica
     */
    public Ventana1Basica() {
        initComponents();
        System.out.println("Lanzando la ventana BÁSICA");
//        setBounds(0,0,300,200);
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

        txtFoto = new javax.swing.JLabel();
        txtEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Básico MVC");

        txtFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(txtFoto, java.awt.BorderLayout.CENTER);

        txtEstado.setText("Tamaño:");
        getContentPane().add(txtEstado, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    * Doy control selectivo, sólo a la capacidad de escribir.
    */
    public void escribeTxtEstado(String s) {
        txtEstado.setText(s);
        System.out.println(s);
    }

}
