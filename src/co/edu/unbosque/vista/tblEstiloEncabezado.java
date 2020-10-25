package co.edu.unbosque.vista;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

//
// Permite personalizar el encabezado de la tabla para definir el color que tendrá en las 
// columnas
//
public class tblEstiloEncabezado implements TableCellRenderer {

    
	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        
	        JComponent jcomponent = null;
	        
	        if( value instanceof String ) {
	            jcomponent = new JLabel((String) value);
	            ((JLabel)jcomponent).setHorizontalAlignment( SwingConstants.CENTER );
	            ((JLabel)jcomponent).setSize( 20, jcomponent.getWidth() );   
	            ((JLabel)jcomponent).setPreferredSize( new Dimension(6, jcomponent.getWidth())  );
	        }         
	        
	        jcomponent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(255, 255, 255)));
	        jcomponent.setOpaque(true);
	        jcomponent.setBackground( new Color(65,65,65) );
	        jcomponent.setToolTipText("Semanario");
	        jcomponent.setForeground(Color.white);
	        
	        return jcomponent;
	    }
	}

