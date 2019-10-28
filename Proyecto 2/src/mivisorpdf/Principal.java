
package mivisorpdf;

//import pueba.pkg2.pkg0.MiVisorPDF;
import VO.ArchivosVO;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/*
 * Esta es la clase se da el desarrollo de todo el programa llamando a todas las clases para su funcionamiento y a demás la creación de la interfase gráfica 
 */
public class Principal extends javax.swing.JFrame {
    /**
 *
 * Se declaran las variables que se utilizarán durate todo el corrido del programa e inicializa valores de la interfase  
 */
    private int numImg;
    DefaultListModel modelo;
    DefaultTableModel modelotabla;
    String buscarpalabra;
    Vector valtabla;
    Vector datos;
    Vector nombres;
    String Nombre,Fecha, Texto;
    int Tamaño;
    public static int count1,count2,count3;
    Vector valores;
    int fila;
    
    
    private String ruta_archivo = "";

    /**
 *
 * Esta el la clase principal la cual inicia los componentes y los valores de las tablas e inicializa los contadores que nos ayudan a ordenar de mayor a menos o vice versa 
 */
    public Principal() {
        initComponents();
        modelo= new DefaultListModel();
        modelotabla = (DefaultTableModel) jTable1.getModel();
        tabla();
        int count1 =0;
        int count2 =0;
        int count3 =0;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        textField1 = new java.awt.TextField();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        button4 = new java.awt.Button();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jList1);

        textField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField1ActionPerformed(evt);
            }
        });

        button1.setLabel("Buscar");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setLabel("Añadir Documento");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setLabel("Eliminar Documento");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Fecha Creación", "Tamaño", "Texto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(250);
        }

        jLabel1.setText("Escribir texto a buscar");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Lista de busqueda");

        button4.setActionCommand("Nueva Busqueda");
        button4.setLabel("Nueva Busqueda");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\leona\\Downloads\\triangulos-.png")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\leona\\Downloads\\triangulos-.png")); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\leona\\Downloads\\triangulos-.png")); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField1ActionPerformed
        // texto a buscar
        
    }//GEN-LAST:event_textField1ActionPerformed
/**
 *
 * El boton 2 es  de Añadir documento , cuando este se acciona habre un cuadro para buscar el documento obteniendo la ruta de enlzace pdf,docx, o txt que son los documentos a trabajar 
 */
    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        //Buscar
        JFileChooser j = new JFileChooser(ruta_archivo);
        FileNameExtensionFilter fi = new FileNameExtensionFilter("pdf", "pdf");
        j.setFileFilter(fi);
        FileNameExtensionFilter fa = new FileNameExtensionFilter("docx","docx");
        j.setFileFilter(fa);
        FileNameExtensionFilter fe = new FileNameExtensionFilter("txt","txt");
        j.setFileFilter(fe);
        int se = j.showOpenDialog(this);
        if (se == 0) {
            ruta_archivo = j.getSelectedFile().getAbsolutePath();
            modelo.addElement(ruta_archivo);
            jList1.setModel(modelo);
           
    }
       
    }//GEN-LAST:event_button2ActionPerformed
/**
 *
 * El boton 1 es el de buscar, cuando este se acciona agarra el texto que se introdujo en el Textfield que sera el texto a buscar en los documentos ingresados anteriormente
 *Dependiendo la terminación del nombre se envia al proceso de busqueda respectivo, llamando a las clases lectores para recibir un vector con las ocurrencias que encuantra en el documento
 *Se agarra cada ocurrencia y se agrega a la Jtabla de la interfase apareciendo el nombre, fecha de creación , tamaño y la linea donde se encuentra el texto a buscar en el documento
 */
    @SuppressWarnings("empty-statement")
    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        //Buscar
        datos= new Vector();
        nombres= new Vector();
        buscarpalabra = textField1.getText();
        int i=0;
        int l=modelo.getSize();
        String comparar= "ftx";
        String texto= "No se encontro";
        //leer lista de busqueda 
        while(i<l){
            
        Object sFichero = modelo.get(i);
        File fichero = new File((String) sFichero);
        
        // Fecha de creacion 
        BasicFileAttributes attrs;
		try {
		    attrs = Files.readAttributes(fichero.toPath(), BasicFileAttributes.class);
		    FileTime time = attrs.creationTime();
		    
		    String pattern = "yyyy-MM-dd";
		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			
		    String formatted = simpleDateFormat.format( new Date( time.toMillis() ) );

                    Fecha =formatted;
                    
                    } catch (IOException e) {
		    e.printStackTrace();
		}
                
        int length = modelo.get(i).toString().length();
            if(modelo.get(i).toString().charAt(length-1)== comparar.charAt(1)){
                Lector_txt1 txt = new Lector_txt1();
                valores = new Vector();
                valores = txt.txt(modelo.get(i).toString(),buscarpalabra);
                int o =0 ;
                while ( o < valores.size()){
                   valtabla = new Vector();
                    Nombre =fichero.getName();
                    Tamaño =(int) fichero.length();
                    valtabla.addElement(Nombre);
                    valtabla.addElement(Fecha);
                    valtabla.addElement(Tamaño);
                    valtabla.addElement(valores.get(o).toString());
                    datos.addElement(valtabla); 
                    o++;
            }
              
            }
            if(modelo.get(i).toString().charAt(length-1)== comparar.charAt(0)){
                Lector_pdf pdf = new Lector_pdf();
                pdf.PDF(modelo.get(i).toString(),buscarpalabra);
                valores = new Vector();
                valores = pdf.PDF(modelo.get(i).toString(),buscarpalabra);
                int o =0 ;
                while ( o < valores.size()){
                   valtabla = new Vector();
                    Nombre =fichero.getName();
                    Tamaño =(int) fichero.length();
                    valtabla.addElement(Nombre);
                    valtabla.addElement(Fecha);
                    valtabla.addElement(Tamaño);
                    valtabla.addElement(valores.get(o).toString());
                    datos.addElement(valtabla); 
                    o++;
            }
            }
            if(modelo.get(i).toString().charAt(length-1)== comparar.charAt(2)){
                Lector_docx word = new Lector_docx();
                word.docx(modelo.get(i).toString(),buscarpalabra);
                valores = new Vector();
                valores = word.docx(modelo.get(i).toString(),buscarpalabra);
                int o =0 ;
                while ( o < valores.size()){
                   valtabla = new Vector();
                    Nombre =fichero.getName();
                    Tamaño =(int) fichero.length();
                    valtabla.addElement(Nombre);
                    valtabla.addElement(Fecha);
                    valtabla.addElement(Tamaño);
                    valtabla.addElement(valores.get(o).toString());
                    datos.addElement(valtabla); 
                    o++;
            }
            }
        
        
        
        i++; 
        
        
        
        } 
        nombres.addElement("Nombre");
        nombres.addElement("Fecha de Modificacion");
        nombres.addElement("Tamaño (Bytes)");
        nombres.addElement("Texto");
        modelotabla.setDataVector(datos, nombres);
    }//GEN-LAST:event_button1ActionPerformed
/**
 *
 *  El valor seleccionado en la lista de documentos y al seleccionar el boton eliminar documento , este será eliminado de la lista 
 */
    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        //eliminar
        int index = jList1.getSelectedIndex();
        modelo.remove(index);
    }//GEN-LAST:event_button3ActionPerformed
/**
 *
 *  Libera espacios de la Jtabla donde se encuantran los resultados de las busquedas 
 */
    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        //Nueva busquedad
        int i=0;
        int l= modelotabla.getRowCount();
        while(i<l){
            modelotabla.removeRow(i);
            
            //modelotabla.setDataVector(datos, nombres);
            i++;
        }
    }//GEN-LAST:event_button4ActionPerformed
/**
 *
 *  Este boton al ser clickeado por primera vez ordena la tabla de resultados con el algoritmo de QuickSort con respecto a los nombres y en su segunda activación realiza la misma acción pero en orden contrario
 */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        QuickSort ob = new QuickSort();
        // Ordenar nombres 
        if (count1%2==0){
        modelotabla.setDataVector(ob.QuickSort(datos),nombres);
        }
        else{
        modelotabla.setDataVector(ob.QuickSort1(datos),nombres);
        }
        System.out.println(count1);
        count1++;
    }//GEN-LAST:event_jButton2ActionPerformed
/**
 *
 *  Este boton al ser clickeado por primera vez ordena la tabla de resultados con el algoritmo de BubbleSort con respecto a las fechas de creación y en su segunda activación realiza la misma acción pero en orden contrario
 */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Ordenar fechas 
        BubbleSort oc = new BubbleSort();
        if (count2%2==0){
        modelotabla.setDataVector(oc.Bubble(datos),nombres);}
        else{
        modelotabla.setDataVector(oc.Bubble1(datos),nombres);
        }
        count2++;
    }//GEN-LAST:event_jButton6ActionPerformed
/**
 *
 *  Este boton al ser clickeado por primera vez ordena la tabla de resultados con el algoritmo de RadixSort con respecto a los tamaños de los documentos 
 */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Ordenar por tamaño
        Radix ov =new Radix();
        if (count3%2==0){
        modelotabla.setDataVector(ov.radix(datos),nombres);}
        else{
        }
        count3++;
    }//GEN-LAST:event_jButton5ActionPerformed
/**
 *
 *  En esta función se desarrolla la interacción con la Jtabla de resutados donde al clickear dos veces sobr un elemento de la tabla automaticamente obtendra el valor y será comparado con los valores de la lista de documento para buscar su enlace 
 * y salir del programa abriendo el documento en el dispoitivo
 */
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //tabla 
        valores = new Vector();
        datos = new Vector();
        jTable1.addMouseListener(new MouseAdapter()
    	{
    		public void mouseClicked(MouseEvent evnt)
    		{
                    if (evnt.getClickCount() == 2)
                    {
                          System.out.println("Entro a la funcion");
                          fila = jTable1.getSelectedRow();
                          System.out.println(fila+"   int");
                          valores = modelotabla.getDataVector();
                          datos= (Vector)valores.get(fila);
                          String comp =  datos.get(0).toString();
                          System.out.println(comp +"   nombre");
                          int k=0;
                          while (k < modelo.getSize()){

                              Object sFichero = modelo.get(k);
                              File fichero = new File((String) sFichero);
                              System.out.println(fichero.getName()+"   name");
                              if(fichero.getName().compareTo(comp)==0){
                                  System.out.println("   entro");
                                  try {
                                      File path = new File (modelo.get(k).toString());
                                      Desktop.getDesktop().open(path);

                                         }catch (IOException ex) {
                                      ex.printStackTrace();
                              }

                              }
                              k++;
                          }
                    }
    		}
    	});
        
    }//GEN-LAST:event_jTable1MouseClicked
    /**
 *
 *  Este metodo es extra lo que hace es ordenar los datos si se le clickea sobre las cabeceras de la tabla ordenandola segun la columna
 */
    private void tabla(){
        TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(modelotabla);
        jTable1.setRowSorter(elQueOrdena);
    }
    /**
     * La función main es la encargada de hacer que el programa corra ejecutando la función principal en un Runneable
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private java.awt.PopupMenu popupMenu1;
    private java.awt.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
