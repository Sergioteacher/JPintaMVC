/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpintamvc.miModeloPinta;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 * Clase encargada del tratamiendo de mis datos
 * @author Sergio Teacher
 */
public class ModelosPinta {

private String Titulo;
private File Archivo;
private ImageIcon miIcono;
private ImageIcon pequeIcono;
private Image fotoTmp;
private Image fotoEscalada;
int anchoOriginal = 0;
int altoOriginal  = 0;
int anchoFinal, altoFinal;

    /**
    * El constructor de la clase
    * iniciando la lectura de archivos inetrnos
    */
    public ModelosPinta() {
        System.out.println("Iniciando mis MODELOS ...   ");
        pequeIcono = new ImageIcon(getClass().getResource("/jpintamvc/imagenes/miniCat.png"));
        miIcono = new ImageIcon(getClass().getResource("/jpintamvc/imagenes/white-tiger-1513723_640.jpg"));
        anchoOriginal = miIcono.getIconWidth();
        altoOriginal = miIcono.getIconHeight();
    }

    /**
    * Método get estandar
    * @return anchoOriginal tipo entero 
    */
    public int getAnchoOriginal() {
        return anchoOriginal;
    }

    /**
    * Método get estandar
    * @return altoOriginal tipo entero 
    */
    public int getAltoOriginal() {
        return altoOriginal;
    }

    /**
    * método controlado de conversión de String a entero
    * con un rango predefinido.
    * @param campo tipo String
    * @return valor entero retocado
    */
    public int ConvierteLimitado(String campo){
        int t=0;
        try{
            t = Integer.parseInt(campo) ;
        }catch(NumberFormatException e){
            System.out.println("e:" + e.getMessage());
        }
        System.out.println("salida t inicial " + t);
        if ( t<10 ){
            t=10;
        }
        System.out.println("salida t final " + t);
        return t;
    }

    /**
    * método sobrecargado para cargar una ImageIcon
    * @param Nombre tipo String
    * @return la ImageIcon seleccionada por Nombre
    */
    public ImageIcon CargaFoto(String Nombre) {
        ImageIcon tmp=null;
        switch (Nombre){
            case "miniCat":
                tmp=pequeIcono;
                break;
            case "white-tiger":
                tmp=miIcono;
                break;
            default:
                miIcono = new ImageIcon(Nombre);
                tmp=miIcono;
        }
        return tmp;
    }

    /**
    * método sobrecargado para cargar una ImageIcon
    * @param WIDTH tipo entero como ancho
    * @param HEIGHT tipo entero como alto
    * @return la ImageIcon seleccionada por tamaño
    */
    public ImageIcon CargaFoto(int WIDTH, int HEIGHT){
        ImageIcon tmp=null;
        //miIcono = new ImageIcon(getClass().getResource("/jpinta/imagenes/white-tiger-1513723_640.jpg"));
        fotoTmp = miIcono.getImage();
        fotoEscalada = fotoTmp.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);

        tmp = new ImageIcon(fotoEscalada);
        return tmp;
    }

    /**
    * método sobrecargado para cargar una ImageIcon
    * @param PORCENTAJE tipo entero como porcentaje a mostar
    * @return la ImageIcon seleccionada por % de tamaño
    */
    public ImageIcon CargaFoto(int PORCENTAJE){
        ImageIcon tmp=null;
        int anchoOriginal, altoOriginal, anchoFinal, altoFinal;
        //miIcono = new ImageIcon(getClass().getResource("/jpinta/imagenes/white-tiger-1513723_640.jpg"));
        fotoTmp = miIcono.getImage();
        anchoOriginal = miIcono.getIconWidth();
        altoOriginal = miIcono.getIconHeight();
        anchoFinal = (int)( (((double) anchoOriginal) * PORCENTAJE)/100 );
        altoFinal = (int)( (((double) altoOriginal) * PORCENTAJE)/100 );

        fotoEscalada = fotoTmp.getScaledInstance(anchoFinal, altoFinal, Image.SCALE_SMOOTH);
        tmp = new ImageIcon(fotoEscalada);
        return tmp;
    }


    /**
    * método que lanza un diálogo de busqueda
    * @return Retorna la foto a abrir
    */
    public String BuscarFoto(){
        int salidaDelDialogo=0;
        String NombreArchivo="";

        JFileChooser buscador = new JFileChooser();
        salidaDelDialogo = buscador.showOpenDialog(null) ;
        if( salidaDelDialogo == JFileChooser.APPROVE_OPTION ){
            Archivo = buscador.getSelectedFile();
            NombreArchivo = Archivo.getPath();
        }
        return NombreArchivo;
    }

    /**
    * Doy control selectivo, sólo para obtener el nombre de la foto.
    * @return Retorna el nombre
    */
    public String nombreArchivo() {
        return Archivo.getName();
    }

    /**
    * Método get estandar
    * @return Titulo tipo String 
    */
    public String getTitulo() {
        return Titulo;
    }

    /**
    * Método set estandar
    * @param Titulo tipo String 
    */
    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }


}
