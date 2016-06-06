/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Datos.ArchivosDAO;
import Datos.JDBC;
import Modelo.Multa;
import Modelo.Policia;
import java.awt.Frame;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author daw1
 */
public class MultasLista extends javax.swing.JDialog {

    /**
     * Creates new form NewJDialog
     *
     * @param parent
     * @param modal
     */
    public MultasLista(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        this.setUndecorated(true);
        this.setLocation(400, 100);
        initComponents();
    }

    /**
     * @param datos
     */
    public void setConexion(JDBC datos) {
        this.datos = datos;
    }

    public void setManejadorDeArchivos(ArchivosDAO manejadorDeArchivos) {
        this.manejadorDeArchivos = manejadorDeArchivos;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuCerrar = new javax.swing.JPanel();
        panelMain = new javax.swing.JPanel();
        panelTabla = new javax.swing.JScrollPane();
        tablaMultasPolicias = new javax.swing.JTable();
        panelBuscar = new javax.swing.JPanel();
        NumeroPlacaL = new javax.swing.JLabel();
        NombreL = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        textoNumPlaca = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        orden = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPolicias = new javax.swing.JList<>();
        NumeroPlacaL1 = new javax.swing.JLabel();
        cerrar = new javax.swing.JLabel();
        cabecera = new javax.swing.JLabel();
        añadirMulta = new javax.swing.JButton();
        exportar = new javax.swing.JButton();
        añadirMulta1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        menuCerrar.setBackground(new java.awt.Color(255, 255, 255));
        menuCerrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        menuCerrar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                menuCerrarMouseDragged(evt);
            }
        });
        menuCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuCerrarMousePressed(evt);
            }
        });

        panelMain.setBackground(new java.awt.Color(255, 255, 255));

        panelTabla.setBackground(new java.awt.Color(255, 255, 255));

        tablaMultasPolicias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "descripcion", "fecha", "importe", "idpolicia", "nifinfractor", "idtipo"
            }
        ));
        panelTabla.setViewportView(tablaMultasPolicias);

        panelBuscar.setBackground(new java.awt.Color(255, 255, 255));
        panelBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filtrar por policia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N

        NumeroPlacaL.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        NumeroPlacaL.setForeground(new java.awt.Color(0, 51, 204));
        NumeroPlacaL.setText("Numero de placa:");

        NombreL.setBackground(new java.awt.Color(255, 255, 255));
        NombreL.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        NombreL.setForeground(new java.awt.Color(0, 51, 204));
        NombreL.setText("Nombre:");

        textoNombre.setBackground(java.awt.SystemColor.control);
        textoNombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textoNombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        textoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoNombreActionPerformed(evt);
            }
        });

        textoNumPlaca.setBackground(java.awt.SystemColor.control);
        textoNumPlaca.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textoNumPlaca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        botonBuscar.setBackground(new java.awt.Color(0, 102, 204));
        botonBuscar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBuscarLayout = new javax.swing.GroupLayout(panelBuscar);
        panelBuscar.setLayout(panelBuscarLayout);
        panelBuscarLayout.setHorizontalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NumeroPlacaL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textoNumPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(NombreL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        panelBuscarLayout.setVerticalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NombreL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textoNombre)
                        .addComponent(botonBuscar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBuscarLayout.createSequentialGroup()
                        .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NumeroPlacaL)
                            .addComponent(textoNumPlaca))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        orden.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "id", "descripcion", "fecha", "importe" }));
        orden.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ordenItemStateChanged(evt);
            }
        });
        orden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordenActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("Ordenar por:");

        listaPolicias.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPoliciasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaPolicias);

        NumeroPlacaL1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        NumeroPlacaL1.setForeground(new java.awt.Color(0, 51, 204));
        NumeroPlacaL1.setText("Lista de Policias:");

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(NumeroPlacaL1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orden, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(panelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(panelTabla, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(orden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(35, 35, 35))
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(NumeroPlacaL1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar.png"))); // NOI18N
        cerrar.setToolTipText("Cerrar");
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrar.setFocusable(false);
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });

        cabecera.setBackground(new java.awt.Color(255, 255, 255));
        cabecera.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        cabecera.setForeground(new java.awt.Color(0, 102, 204));
        cabecera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/multa.png"))); // NOI18N
        cabecera.setText("MULTAS");

        añadirMulta.setBackground(new java.awt.Color(0, 102, 204));
        añadirMulta.setForeground(new java.awt.Color(255, 255, 255));
        añadirMulta.setText("Añadir multa");
        añadirMulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirMultaActionPerformed(evt);
            }
        });

        exportar.setText("Exportar listado");
        exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarActionPerformed(evt);
            }
        });

        añadirMulta1.setBackground(new java.awt.Color(0, 102, 204));
        añadirMulta1.setForeground(new java.awt.Color(255, 255, 255));
        añadirMulta1.setText("Limpiar seleccion");
        añadirMulta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirMulta1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuCerrarLayout = new javax.swing.GroupLayout(menuCerrar);
        menuCerrar.setLayout(menuCerrarLayout);
        menuCerrarLayout.setHorizontalGroup(
            menuCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(menuCerrarLayout.createSequentialGroup()
                .addComponent(cabecera, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cerrar))
            .addGroup(menuCerrarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(menuCerrarLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(añadirMulta)
                        .addGap(68, 68, 68)
                        .addComponent(añadirMulta1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exportar)
                        .addGap(30, 30, 30))
                    .addGroup(menuCerrarLayout.createSequentialGroup()
                        .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))))
        );
        menuCerrarLayout.setVerticalGroup(
            menuCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuCerrarLayout.createSequentialGroup()
                .addGroup(menuCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuCerrarLayout.createSequentialGroup()
                        .addComponent(cerrar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuCerrarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cabecera)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menuCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(añadirMulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exportar)
                    .addComponent(añadirMulta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(233, 233, 233))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCerrarMousePressed
        this.x = evt.getX();
        this.y = evt.getY();
    }//GEN-LAST:event_menuCerrarMousePressed

    private void menuCerrarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCerrarMouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_menuCerrarMouseDragged

    private void textoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoNombreActionPerformed

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_cerrarMouseClicked

    private void añadirMultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirMultaActionPerformed
        MultasIntroducir ventanaIntroducir = new MultasIntroducir((Frame) super.getParent(), true);
        ventanaIntroducir.setConexion(this.datos);
        ventanaIntroducir.setVisible(true);
    }//GEN-LAST:event_añadirMultaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        DefaultListModel modelo = new DefaultListModel();
        List<Policia> todosLosPolicias = new ArrayList();
        try {
            todosLosPolicias = this.datos.obtenerPolicias();
        } catch (SQLException ex) {
            Logger.getLogger(MultasLista.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Policia p : todosLosPolicias) {
            modelo.addElement(p);
        }
        this.listaPolicias.setModel(modelo);
        if (this.listaPoliciasSeleccionados == null) {
            if (hayPolicia == true) {
                this.rellenarTablaMultasP(this.orden.getSelectedItem().toString(), policia);
                this.textoNombre.setText(this.policia.getNombre());
                this.textoNumPlaca.setText(this.policia.getNumPlaca());
            } else {
                this.rellenarTablaMultas(this.orden.getSelectedItem().toString());
            }

        } else if (this.listaPoliciasSeleccionados != null) {
            this.rellenarTablaMultasPorListaPolis(this.orden.getSelectedItem().toString(), this.listaPoliciasSeleccionados);

        }


    }//GEN-LAST:event_formWindowOpened

    private void ordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ordenActionPerformed

    private void ordenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ordenItemStateChanged
        if (this.listaPolicias.getSelectedValuesList().isEmpty()) {
            if (this.textoNumPlaca.getText().isEmpty() && this.textoNombre.getText().isEmpty()) {
                this.rellenarTablaMultas(this.orden.getSelectedItem().toString());
            } else {
                this.rellenarTablaPorBusqueda(this.orden.getSelectedItem().toString());
            }
        } else {
            this.rellenarTablaMultasPorListaPolis(this.orden.getSelectedItem().toString(), policiasSeleccionadosEnLista);
        }
    }//GEN-LAST:event_ordenItemStateChanged

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        this.listaPolicias.clearSelection();
        this.rellenarTablaPorBusqueda(this.orden.getSelectedItem().toString());
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarActionPerformed
        List<Multa> listaMultas = new ArrayList<>();
        if (this.textoNumPlaca.getText().isEmpty() && this.textoNombre.getText().isEmpty() && this.policiasSeleccionadosEnLista.isEmpty()) {
            try {
                listaMultas = this.datos.obtenerMultas(orden.getSelectedItem().toString());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "DatosNo Cargados, no existen ");

            }
        } else if (!this.policiasSeleccionadosEnLista.isEmpty()) {
            for (Policia policia : this.policiasSeleccionadosEnLista) {
                try {
                    for (Multa m : this.datos.obtenerMultasPolicia(policia.getNumPlaca(), policia.getNombre(), this.orden.getSelectedItem().toString())) {
                        listaMultas.add(m);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Lista no cargada");
                }
            }
        } else {
            try {
                listaMultas = this.datos.obtenerMultasPolicia(this.textoNumPlaca.getText(), this.textoNombre.getText(), this.orden.getSelectedItem().toString());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Datos No Cargados, no existen ");

            }
        }
        int resultado;
        final JFileChooser fc = new JFileChooser();
        int indice = fc.showSaveDialog(this);
        if (indice == JFileChooser.APPROVE_OPTION) {
            try {
                Path rutaAguardar = fc.getSelectedFile().toPath();
                resultado = this.manejadorDeArchivos.generarListadoMultas(listaMultas, rutaAguardar);
                if (resultado > 0) {
                    JOptionPane.showMessageDialog(rootPane, "Datos Exportados");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Datos No Exportados", null, JOptionPane.WARNING_MESSAGE);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, "Error : " + ex.getMessage());
            }
        }

    }//GEN-LAST:event_exportarActionPerformed

    private void listaPoliciasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPoliciasValueChanged
        policiasSeleccionadosEnLista = this.listaPolicias.getSelectedValuesList();
        this.rellenarTablaMultasPorListaPolis(this.orden.getSelectedItem().toString(), policiasSeleccionadosEnLista);
    }//GEN-LAST:event_listaPoliciasValueChanged

    private void añadirMulta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirMulta1ActionPerformed
        this.listaPolicias.clearSelection();
        this.rellenarTablaMultas(this.orden.getSelectedItem().toString());
        this.textoNombre.setText("");
        this.textoNumPlaca.setText("");
    }//GEN-LAST:event_añadirMulta1ActionPerformed
    public void rellenarTablaMultas(String orden) {
        try {
            String[] filas = new String[7];
            String[] titulos = {"id", "descripcion", "fecha", "importe", "idPolicia", "nifinfractor", "idtipo"};
            tabla = new DefaultTableModel(null, titulos);

            for (Multa m : this.datos.obtenerMultas(orden)) {
                filas[0] = m.getId().toString();
                filas[1] = m.getDescripcion();
                SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd -- HH:mm");
                if (m.getFecha() != null) {
                    filas[2] = sf.format(Timestamp.valueOf(m.getFecha()));
                }
                filas[3] = m.getImporte().toString();
                filas[4] = m.getIdPolicia().toString();
                filas[5] = m.getNifInfractor();
                filas[6] = m.getIdTipo().toString();
                this.tabla.addRow(filas);
            }
            this.tablaMultasPolicias.setModel(tabla);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getErrorCode() + " " + ex.getMessage() + " " + ex.getSQLState() + "Ha habido un problema al intentar rellenar la tabla, comprueba la conexión", "Error conectando a la base de datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void rellenarTablaPorBusqueda(String orden) {
        try {
            String[] filas = new String[7];
            String[] titulos = {"id", "descripcion", "fecha", "importe", "idPolicia", "nifinfractor", "idtipo"};
            tabla = new DefaultTableModel(null, titulos);
            for (Multa m : this.datos.obtenerMultasPolicia(this.textoNumPlaca.getText(), this.textoNombre.getText(), orden)) {
                filas[0] = m.getId().toString();
                filas[1] = m.getDescripcion();
                SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd -- HH:mm");
                if (m.getFecha() != null) {
                    filas[2] = sf.format(Timestamp.valueOf(m.getFecha()));
                }
                filas[3] = m.getImporte().toString();
                filas[4] = m.getIdPolicia().toString();
                filas[5] = m.getNifInfractor();
                filas[6] = m.getIdTipo().toString();
                this.tabla.addRow(filas);
            }
            this.tablaMultasPolicias.setModel(tabla);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getErrorCode() + " " + ex.getMessage() + " " + ex.getSQLState() + "Ha habido un problema al intentar rellenar la tabla, comprueba la conexión", "Error conectando a la base de datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void rellenarTablaMultasP(String orden, Policia policia) {
        try {
            String[] filas = new String[7];
            String[] titulos = {"id", "descripcion", "fecha", "importe", "idPolicia", "nifinfractor", "idtipo"};
            tabla = new DefaultTableModel(null, titulos);
            for (Multa m : this.datos.obtenerMultasPolicia(policia.getNumPlaca(), policia.getNombre(), orden)) {
                filas[0] = m.getId().toString();
                filas[1] = m.getDescripcion();
                SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd -- HH:mm");
                if (m.getFecha() != null) {
                    filas[2] = sf.format(Timestamp.valueOf(m.getFecha()));
                }
                filas[3] = m.getImporte().toString();
                filas[4] = m.getIdPolicia().toString();
                filas[5] = m.getNifInfractor();
                filas[6] = m.getIdTipo().toString();
                this.tabla.addRow(filas);
            }
            this.tablaMultasPolicias.setModel(tabla);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getErrorCode() + " " + ex.getMessage() + " " + ex.getSQLState() + "Ha habido un problema al intentar rellenar la tabla, comprueba la conexión", "Error conectando a la base de datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void rellenarTablaMultasPorListaPolis(String orden, List<Policia> policias) {
        try {
            String[] filas = new String[7];
            String[] titulos = {"id", "descripcion", "fecha", "importe", "idPolicia", "nifinfractor", "idtipo"};
            tabla = new DefaultTableModel(null, titulos);
            for (Policia policia : policias) {
                for (Multa m : this.datos.obtenerMultasPolicia(policia.getNumPlaca(), policia.getNombre(), orden)) {
                    filas[0] = m.getId().toString();
                    filas[1] = m.getDescripcion();
                    SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd -- HH:mm");
                    if (m.getFecha() != null) {
                        filas[2] = sf.format(Timestamp.valueOf(m.getFecha()));
                    }
                    filas[3] = m.getImporte().toString();
                    filas[4] = m.getIdPolicia().toString();
                    filas[5] = m.getNifInfractor();
                    filas[6] = m.getIdTipo().toString();
                    this.tabla.addRow(filas);
                }
            }
            this.tablaMultasPolicias.setModel(tabla);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getErrorCode() + " " + ex.getMessage() + " " + ex.getSQLState() + "Ha habido un problema al intentar rellenar la tabla, comprueba la conexión", "Error conectando a la base de datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setPolicia(Policia policia) {
        this.hayPolicia = true;
        this.policia = policia;
    }

    public void setListaPolicias(List<Policia> lista) {
        this.listaPoliciasSeleccionados = lista;
    }
    List<Policia> policiasSeleccionadosEnLista = new ArrayList();
    List<Policia> listaPoliciasSeleccionados;
    private Policia policia;
    private boolean hayPolicia = false;
    private ArchivosDAO manejadorDeArchivos;
    private DefaultTableModel tabla;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NombreL;
    private javax.swing.JLabel NumeroPlacaL;
    private javax.swing.JLabel NumeroPlacaL1;
    private javax.swing.JButton añadirMulta;
    private javax.swing.JButton añadirMulta1;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JLabel cabecera;
    private javax.swing.JLabel cerrar;
    private javax.swing.JButton exportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Policia> listaPolicias;
    private javax.swing.JPanel menuCerrar;
    private javax.swing.JComboBox orden;
    private javax.swing.JPanel panelBuscar;
    private javax.swing.JPanel panelMain;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JTable tablaMultasPolicias;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoNumPlaca;
    // End of variables declaration//GEN-END:variables
    private int x, y;
    private JDBC datos;

}
