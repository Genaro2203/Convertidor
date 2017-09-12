/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package examen1_Martinez_Barbosa_GenaroEnrique_5IM6;
 
//Librerías
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Genaro Enrique Martínez Barbosa
 * @version 1.0
 * created on 2017-09-12
 */
 
public class Convertidor extends JFrame implements ActionListener{
    private JFrame ventana;
    private JTextField pesos, dolares;	
    private JLabel titulo, lbl1, lbl2;
    private JButton convertir, borrar;
    private Container contenedor;
    
    /**
     * El Método Constructor.
     * Cuando se ejecuta el Main, se invoca éste cosntructor (el único, y sin parámetros)
     * Se invocan automáticamente los métodos initVentana() y initComponentes(), para definir las características de la ventana y sus elementos, respectivamente.
     * Luego se hace visible la ventana.     * 
     */
    
    public Convertidor()
    {
        initVentana();
        initComponentes();
        this.ventana.setVisible(true);
    }

    /**
     * El Método initVentana.
     * Establece las características de la ventana, como su tamaño, posición, etc., y ésta se engloba en un contenedor. 
     */
    
    public void initVentana()
    {
        ventana = new JFrame();
        ventana.setSize(500, 600);
        ventana.setResizable(false);
        ventana.setLayout(null);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contenedor = ventana.getContentPane();		
        contenedor.setBackground(Color.CYAN);
    }

    /**
     * El Método initComponentes.
     * Define las características de los elementos de la ventana, los mete al contenedor, les implementa el ActionListener a los botones, y los hace visibles. 
     */
    
    public void initComponentes()
    {
        titulo = new JLabel("Convertidor de pesos a dólares");
        titulo.setBounds(75, 50, 400, 50);
        titulo.setFont(new Font ("Georgia", 1, 20));
        titulo.setForeground(Color.RED);
        contenedor.add(titulo);
        titulo.setVisible(true);

        lbl1 = new JLabel("Pesos:");
        lbl1.setBounds(50, 200, 50, 50);
        lbl1.setFont(new Font ("Arial", 1, 12));
        lbl1.setForeground(Color.BLUE);
        contenedor.add(lbl1);
        lbl1.setVisible(true);

        lbl2 = new JLabel("Dólares:");
        lbl2.setBounds(50, 300, 50, 50);
        lbl2.setFont(new Font ("Arial", 1, 12));
        lbl2.setForeground(Color.BLUE);
        contenedor.add(lbl2);
        lbl2.setVisible(true);

        pesos = new JTextField();
        pesos.setBounds(150,200,200,50);
        contenedor.add(pesos);
        pesos.setVisible(true);

        dolares = new JTextField();
        dolares.setBounds(150,300,200,50);
        dolares.setEditable(false);
        contenedor.add(dolares);
        dolares.setVisible(true);		

        convertir = new JButton("Convertir");
        convertir.setBounds(350,450,100,60);
        convertir.setBackground(Color.RED);
        convertir.setForeground(Color.YELLOW);
        convertir.setFont(new Font ("Ebria", 1, 12));
        contenedor.add(convertir);
        convertir.addActionListener(this);
        convertir.setVisible(true);

        borrar = new JButton("Borrar");
        borrar.setBounds(200,450,100,60);
        borrar.setBackground(Color.WHITE);
        borrar.setForeground(Color.RED);
        borrar.setFont(new Font ("Ebria", 1, 12));
        contenedor.add(borrar);
        borrar.addActionListener(this);
        borrar.setVisible(true);
    }

    /**
     * El Método actionPerformed.
     * Señala las acciones que se deben ejecutar cada vez que se oprima un botón.
     * Si se oprime "Convertir", se efectúa la conversión, siempre que existan datos y éstos sean numéricos, dividiendo la cantidad elegida entre 19 (valor actual en pesos de un dólar).
     * Si se oprime "Borrar", se borran ambos datos.
     * No se puede escribir en el segundo cuadro (el de los dólares).
     * @param e El evento, es decir, el "click", con el que se efectúan las acciones.
     */
    
    @Override
    public void actionPerformed (ActionEvent e)
    {
        if (e.getSource() == convertir)
        {
            if (!pesos.getText().isEmpty())
            {
                try
                {
                    float cantidadPesos = Float.parseFloat(pesos.getText());
                    float cantidadDolares = cantidadPesos / 19;
                    String resultado = String.valueOf(cantidadDolares);
                    pesos.setText("$" + pesos.getText() + " MXN");
                    dolares.setText("S" + resultado + " USD");
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Sólo puedes ingresar números.");
                    pesos.setText(null);
                }					
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Ingresa datos.");
            }
        }
        else
        {
            if (e.getSource() == borrar)
            {
                pesos.setText(null);
                dolares.setText(null);
            }
        }
    }  
}