/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jpintamvc.miControlPinta;

import javax.swing.JOptionPane;
import jpintamvc.miModeloPinta.ModelosPinta;
import jpintamvc.miVentanasPinta.Ventana1Basica;
import jpintamvc.miVentanasPinta.Ventana2Avanzada;
import jpintamvc.miVentanasPinta.Ventana3Visor;

/**
 * Clase principal de JPintaMVC
 * @author Sergio Teacher
 */
public class JPintaMVC {

    /**
     * Es el método principal del proyecto
     * donde se inician las clases principales.
     * En este caso, se lanza un selector de opciones para decidir interfaz
     * y se crean en este caso sólo las clases necesarias.
     * @param args es la matriz de String con los argumentos pasados al programa
     */
    public static void main(String[] args) {
        Boolean Elegido = false;
        System.out.println("Iniciando JPintaMVC ...");
        System.out.println("Se han pasado " + args.length + " argumentos.");

        int optionT=0;
        String[] optionesVentana={"Básica", "Avanzada","Visor"};
        optionT = JOptionPane.showOptionDialog(null, "Control de presentación de imágenes", "Seleccione VENTANA de arranque", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionesVentana, "Básica");

        ModelosPinta MisModelos = new ModelosPinta();
        ControlPinta MiControl=null;

        switch (optionT){
            case 0:
                System.out.println("Iniciando Básica ...");
                Ventana1Basica VBasica = new Ventana1Basica();
                MiControl = new ControlPinta(VBasica, null, null, MisModelos, "Ventana1 Básica");
                Elegido = true;
                break;
            case 1:
                System.out.println("Iniciando Avanzada ...");
                Ventana2Avanzada VAvanzada = new Ventana2Avanzada();
                MiControl = new ControlPinta(null, VAvanzada, null, MisModelos, "Ventana2 Avanzada");
                Elegido = true;
                break;
            case 2:
                System.out.println("Iniciando Visor ...");
                Ventana3Visor VVisor = new Ventana3Visor();
                MiControl = new ControlPinta(null ,null ,VVisor, MisModelos, "Ventana3 Visor");
                Elegido = true;
                break;
            default:
                System.out.println("No se lanza ventana alguna.");
        }
        if( Elegido == true ){
               MiControl.InicialControl();
        }
 
    }
    
}
