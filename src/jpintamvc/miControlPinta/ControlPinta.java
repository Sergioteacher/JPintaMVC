/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpintamvc.miControlPinta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import jpintamvc.miModeloPinta.ModelosPinta;
import jpintamvc.miVentanasPinta.Ventana1Basica;
import jpintamvc.miVentanasPinta.Ventana2Avanzada;
import jpintamvc.miVentanasPinta.Ventana3Visor;

/**
 * Clase del CONTROLADOR del proyecto JPintaMVC
 * que implementa los métodos : ActionListener y ChangeListener
 * @author Sergio Teacher
 */
public class ControlPinta implements ActionListener, ChangeListener {

private Ventana1Basica   Ventana1;
private Ventana2Avanzada Ventana2;
private Ventana3Visor    Ventana3;
private ModelosPinta MisEstructuras;
private String  MiTitulo;
private Boolean Cargada = false;

    /**
     * Constructor del Controlador
     * @param Ventana1 ventana básica
     * @param Ventana2 ventana avanzada
     * @param Ventana3 ventana visor
     * @param MisEstructuras mi modelo que gestiona mis datos
     * @param MiTitulo Sting título de la ventana de turno
     */
    public ControlPinta(Ventana1Basica Ventana1, Ventana2Avanzada Ventana2, Ventana3Visor Ventana3, ModelosPinta MisEstructuras, String MiTitulo) {
        this.Ventana1 = Ventana1;
        this.Ventana2 = Ventana2;
        this.Ventana3 = Ventana3;
        this.MisEstructuras = MisEstructuras;
        this.MiTitulo = MiTitulo;

        System.out.println("Iniciando el CONTROL ...");
    }


    /**
     * método que inicia las configuraciones
     */
    public void InicialControl(){
    switch (MiTitulo){
                case "Ventana1 Básica":
                    ajustesVentana1();
                    break;
                case "Ventana2 Avanzada":
                    ajustesVentana2();
                    break;
                case "Ventana3 Visor":
                    ajustesVentana3();                
                    break;
            }

    }
   
    /**
     * método que inicia las configuraciones de la Ventana 1º Básica
     */
    public void ajustesVentana1(){
        int x,y;
        Ventana1.setTitle(MiTitulo);
        Ventana1.setIconTxtFoto(MisEstructuras.CargaFoto("white-tiger"));
        x= MisEstructuras.getAnchoOriginal();
        y= MisEstructuras.getAltoOriginal();
        Ventana1.setBounds(0, 0, x, y);

        Ventana1.escribeTxtEstado("Tamaño: " + x + " " + y + " (propio, agranda la ventana si es necesario)");
        Ventana1.setVisible(true);
    }

    /**
     * método que inicia las configuraciones de la Ventana 2º Avanzada
     */
    public void ajustesVentana2(){
    // Con control total sería
    //     Ventana2.getOptionEscala().addActionListener(this);
    // Con control selectivo es:
        Ventana2.addActionListenerOptionEscala(this);
        Ventana2.getjSliderEscala().addChangeListener(this);
        Ventana2.getBtnOK().addActionListener(this);
    // Con control total sería
    //     Ventana2.getOptionValores().addActionListener(this);
    // Con control selectivo es:
        Ventana2.addActionListenerOptionValores(this);
        Ventana2.setTitle(MiTitulo);
        Ventana2.setIconTxtFoto(MisEstructuras.CargaFoto("miniCat"));

        Ventana2.escribeTxtEstado("Tamaño: ");
        Ventana2.setVisible(true);
    }

    /**
     * método que inicia las configuraciones de la Ventana 3º Visor
     */
    public void ajustesVentana3(){
        Ventana3.setTitle(MiTitulo);
    //  Ventana3.setIconTxtFoto(MisEstructuras.CargaFoto("miniCat"));

        Ventana3.getBtnAbrir().addActionListener(this);
        Ventana3.getBtnLimpiar().addActionListener(this);
        Ventana3.escribeTxtEstado("Img: ");
        Ventana3.setVisible(true);
    }

    /**
    * método que actua por Clicks
    * @param arg0 tipo enento ActionEvent
    */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        // Control del evnto
        System.out.println( arg0.getActionCommand() );
        switch (arg0.getActionCommand()){
            case "%":
                casoPorciento();
                break;
            case "Ok":
                casoOk();
                break;
            case "OK":
                casoOK();
                break;
            case "💾 Abrir":
                casoAbrir();
                break;
            case "💣 Limpiar":
                casoLimpiar();
                break;
            default:
                System.out.println("Se ha pulsado algo ???");
        }
    }

    /**
    * método que actua por Clicks
    * @param e tipo enento ChangeEvent
    */
    @Override
    public void stateChanged(ChangeEvent e){
    //    System.out.println("e->" + e.toString());
        Ventana2.setIconTxtFoto( MisEstructuras.CargaFoto(Ventana2.getjSliderEscala().getValue()) );
        Ventana2.escribeTxtEstado("Tamaño: " + Ventana2.getjSliderEscala().getValue() + "%");
    }

    /**
    * método de carga la imagen por defecto
    */
    public void cargaTigre(){
        if (Cargada == false){
            Cargada = true;
            Ventana2.setIconTxtFoto(MisEstructuras.CargaFoto("white-tiger"));
        }
    }

    /**
    * Acciones a realizar cuando de acciona el radio botón %
    */
    public void casoPorciento(){
        System.out.println("He pulsado el %");
        Ventana2.getjSliderEscala().setEnabled(true);
        Ventana2.getjSliderEscala().setValue(100);
        Ventana2.getBtnOK().setEnabled(false);
        Ventana2.getjTextX().setEnabled(false);
        Ventana2.getjTextY().setEnabled(false);
        cargaTigre();
        Ventana2.escribeTxtEstado("Tamaño: " + Ventana2.getjSliderEscala().getValue() + "%");
    }

    /**
    * Acciones a realizar cuando de acciona el radio botón Ok
    */
    public void casoOk(){
        System.out.println("He pulsado el Ok");
        Ventana2.getjSliderEscala().setEnabled(false);
        Ventana2.getBtnOK().setEnabled(true);
        Ventana2.getjTextX().setEnabled(true);
        Ventana2.getjTextX().setText("400");
        Ventana2.getjTextY().setEnabled(true);
        Ventana2.getjTextY().setText("300");
        cargaTigre();
        Ventana2.escribeTxtEstado("Tamaño:  X: 400  Y: 300");
    }

    /**
    * Acciones a realizar cuando de acciona el botón OK
    */
    public void casoOK(){
        System.out.println("He pulsado el Botón OK");
        int x,y;
        x = MisEstructuras.ConvierteLimitado(Ventana2.getjTextX().getText());
        y = MisEstructuras.ConvierteLimitado(Ventana2.getjTextY().getText());
        Ventana2.setIconTxtFoto( MisEstructuras.CargaFoto(x, y) );
        Ventana2.escribeTxtEstado("Tamaño:  X: " + x + "  Y: " + y);
    }

    /**
    * Acciones a realizar cuando de acciona el botón Abrir
    */
    public void casoAbrir(){
        String s="";
        System.out.println("Pulsado Botón Abrir");
        s = MisEstructuras.BuscarFoto();
        System.out.println("s-> " + s);
        Ventana3.setIconTxtFoto( MisEstructuras.CargaFoto(s) );
        Ventana3.escribeTxtEstado("Img:  " + MisEstructuras.nombreArchivo());
    }

    /**
    * Acciones a realizar cuando de acciona el botón Limpiar
    */
    public void casoLimpiar(){
        System.out.println("Pulsado Botón Limpiar");
        Ventana3.escribeTxtEstado("Img: ...");
        Ventana3.setIconTxtFoto(null);
    }

}

