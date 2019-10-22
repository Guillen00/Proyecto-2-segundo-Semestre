/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pueba.pkg2.pkg0;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author leona
 */
public class pruebacolumnas {
    Object[][] data = new Object[4][3];
    String[] columnNames;
    
    private void populateColumnNames() {
        columnNames = new String[] { "Nombre blog", "Dirección", "Autor" };
}

private void populateTableData() {
	
	data[0][0] = "Core dumped";
	data[0][1] = "http://m3drano.es/";
	data[0][2] = "Ramón Medrano";
	data[1][0] = "Miguel Fernández";
	data[1][1] = "http://www.miguelfernandez.info/";
	data[1][2] = "Miguel Fernández";
	data[2][0] = "Informático en apuros";
	data[2][1] = "http://diegosuarezgarcia.es/blog/";
	data[2][2] = "Diego Suárez García";
	data[3][0] = "Un blog de Silverlight";
	data[3][1] = "http://geeks.ms/blogs/eecsaky/";
	data[3][2] = "Eugénio Estrada";
}


private char[][] getJTable() {
	if (table == null) {
		JTable table = new JTable();
		// Creamos el modelo, la parte que contenrá los datos de la tabla
		DefaultTableModel model = new DefaultTableModel();
		// Creamos un ordenador de filas para el modelo
		TableRowSorter sorter = new TableRowSorter(
				model);
		// Añadimos al modelo los datos que queremos que contenga la tabla
		model.setDataVector(data, columnNames);
		// Le decimos a la tabla que use el modelo de datos que hemos creado
		table.setModel(model);
		// Le decimos a la tabla que use la ordenación de filas que hemos
		// creado
		table.setRowSorter(sorter);
	}
	return table;
}
public static void main(String args[]) {
        char[][] jTable = getJTable();
    }
}
