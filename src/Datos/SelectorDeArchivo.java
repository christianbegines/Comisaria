package Datos;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SelectorDeArchivo extends JPanel
                              implements ActionListener {
    private static final String newline = "\n";
    private JFileChooser fc;
    public String seleccionar() {
        String ruta="";
        fc = new JFileChooser();
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Imagenes JPG", "jpg"));
        fc.setAcceptAllFileFilterUsed(false);
        int returnVal = fc.showDialog(SelectorDeArchivo.this,"Abrir");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            ruta = file.getPath();
        }
        fc.setSelectedFile(null);
        return ruta;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
