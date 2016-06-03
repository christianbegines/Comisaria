package Vista;

import Datos.ArchivosDAO;
import Datos.JDBC;
import Modelo.Policia;
import java.awt.Color;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Rubén Soler;
 *
 * Ventana Grafica que se abre al arrancar el programa, desde esta se puede
 * seleccionar un policia y borrarlo.
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Genera la ventan principal. La coloca en el medio. Deshabilita los
     * botones hasta recibir conexion. Inicia los componentes.
     */
    public Principal() {
        this.setIconImage(i);
        this.setUndecorated(true);
        this.setLocation(400, 100);
        initComponents();
        this.gestionarMultas.setEnabled(false);
        this.gestionarPolicias.setEnabled(false);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     *
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuCerrar = new javax.swing.JPanel();
        minimizar = new javax.swing.JLabel();
        cerrar = new javax.swing.JLabel();
        autores = new javax.swing.JLabel();
        panelMain = new javax.swing.JPanel();
        gestionarPolicias = new javax.swing.JButton();
        gestionarMultas = new javax.swing.JButton();
        panelDerecha = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        panelConexion = new java.awt.Panel();
        estadoConexion = new javax.swing.JLabel();
        BD = new javax.swing.JLabel();
        panelOrden = new javax.swing.JPanel();
        ordenarPor = new javax.swing.JLabel();
        listaPolicias = new javax.swing.JLabel();
        orden = new javax.swing.JComboBox<>();
        panelTabla = new javax.swing.JScrollPane();
        tablaPolicias = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        borrar = new javax.swing.JButton();
        limpiarSeleccion = new javax.swing.JButton();
        botonCargar = new javax.swing.JButton();
        botonRecargar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Comisaria Rubén & Christian");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
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

        minimizar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        minimizar.setForeground(new java.awt.Color(153, 153, 153));
        minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/minimizar.png"))); // NOI18N
        minimizar.setToolTipText("Minimizar");
        minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizar.setFocusable(false);
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizarMouseClicked(evt);
            }
        });

        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar.png"))); // NOI18N
        cerrar.setToolTipText("Cerrar");
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrar.setFocusable(false);
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });

        autores.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        autores.setForeground(new java.awt.Color(0, 51, 255));
        autores.setText("Comisaria  Rubén & Christian");
        autores.setToolTipText("Autores");
        autores.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                autoresMouseDragged(evt);
            }
        });
        autores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                autoresMousePressed(evt);
            }
        });

        panelMain.setBackground(new java.awt.Color(255, 255, 255));

        gestionarPolicias.setBackground(new java.awt.Color(0, 102, 204));
        gestionarPolicias.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        gestionarPolicias.setForeground(new java.awt.Color(255, 255, 255));
        gestionarPolicias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/policia.png"))); // NOI18N
        gestionarPolicias.setText("Gestionar Policias");
        gestionarPolicias.setToolTipText("Abrir ventana de gestión de policias");
        gestionarPolicias.setBorder(null);
        gestionarPolicias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gestionarPolicias.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        gestionarPolicias.setMaximumSize(new java.awt.Dimension(90, 25));
        gestionarPolicias.setMinimumSize(new java.awt.Dimension(90, 25));
        gestionarPolicias.setSelected(true);
        gestionarPolicias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionarPoliciasActionPerformed(evt);
            }
        });

        gestionarMultas.setBackground(new java.awt.Color(0, 102, 204));
        gestionarMultas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        gestionarMultas.setForeground(new java.awt.Color(255, 255, 255));
        gestionarMultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/multa.png"))); // NOI18N
        gestionarMultas.setText("Gestionar Multas");
        gestionarMultas.setToolTipText("Abrir ventana de gestión de multas");
        gestionarMultas.setBorder(null);
        gestionarMultas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gestionarMultas.setMaximumSize(new java.awt.Dimension(90, 25));
        gestionarMultas.setMinimumSize(new java.awt.Dimension(90, 25));
        gestionarMultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionarMultasActionPerformed(evt);
            }
        });

        panelDerecha.setBackground(new java.awt.Color(255, 255, 255));

        org.jdesktop.layout.GroupLayout panelDerechaLayout = new org.jdesktop.layout.GroupLayout(panelDerecha);
        panelDerecha.setLayout(panelDerechaLayout);
        panelDerechaLayout.setHorizontalGroup(
            panelDerechaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );
        panelDerechaLayout.setVerticalGroup(
            panelDerechaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 273, Short.MAX_VALUE)
        );

        logo.setBackground(new java.awt.Color(255, 255, 255));
        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/policia.jpg"))); // NOI18N
        logo.setText(" ");
        logo.setToolTipText("Cuerpo Nacional de Policia");
        logo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        org.jdesktop.layout.GroupLayout panelMainLayout = new org.jdesktop.layout.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelMainLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(gestionarMultas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 343, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(gestionarPolicias, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 343, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(23, 23, 23)
                .add(panelDerecha, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(logo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 269, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panelMainLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(panelMainLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(panelDerecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, panelMainLayout.createSequentialGroup()
                        .add(16, 16, 16)
                        .add(gestionarPolicias, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(26, 26, 26)
                        .add(gestionarMultas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(298, 298, 298))
            .add(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .add(logo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .add(360, 360, 360))
        );

        panelConexion.setBackground(new java.awt.Color(255, 255, 255));

        estadoConexion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        estadoConexion.setForeground(new java.awt.Color(255, 0, 0));
        estadoConexion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estadoConexion.setText("Sin conexión");
        estadoConexion.setToolTipText("Estado de la base de datos");
        estadoConexion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        estadoConexion.setFocusable(false);

        BD.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BD.setText("BD:");

        org.jdesktop.layout.GroupLayout panelConexionLayout = new org.jdesktop.layout.GroupLayout(panelConexion);
        panelConexion.setLayout(panelConexionLayout);
        panelConexionLayout.setHorizontalGroup(
            panelConexionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panelConexionLayout.createSequentialGroup()
                .add(BD)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(estadoConexion)
                .addContainerGap())
        );
        panelConexionLayout.setVerticalGroup(
            panelConexionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelConexionLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelConexionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(estadoConexion)
                    .add(BD))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelOrden.setBackground(new java.awt.Color(255, 255, 255));

        ordenarPor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ordenarPor.setForeground(new java.awt.Color(0, 51, 204));
        ordenarPor.setText("Ordenar por:");

        listaPolicias.setBackground(new java.awt.Color(255, 255, 255));
        listaPolicias.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        listaPolicias.setForeground(new java.awt.Color(0, 102, 204));
        listaPolicias.setText("POLICIAS");

        orden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "idPolicia", "nombre", "numPlaca", "edad", "departamento" }));
        orden.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ordenItemStateChanged(evt);
            }
        });
        orden.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                ordenCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        orden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordenActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout panelOrdenLayout = new org.jdesktop.layout.GroupLayout(panelOrden);
        panelOrden.setLayout(panelOrdenLayout);
        panelOrdenLayout.setHorizontalGroup(
            panelOrdenLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelOrdenLayout.createSequentialGroup()
                .add(listaPolicias, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 239, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 140, Short.MAX_VALUE)
                .add(ordenarPor)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(orden, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        panelOrdenLayout.setVerticalGroup(
            panelOrdenLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelOrdenLayout.createSequentialGroup()
                .add(panelOrdenLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(listaPolicias, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(ordenarPor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(orden, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelTabla.setBackground(new java.awt.Color(255, 255, 255));

        tablaPolicias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "idPolicia", "nombre", "numPlaca", "edad", "departamento", "foto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        panelTabla.setViewportView(tablaPolicias);

        borrar.setText("Borrar");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        limpiarSeleccion.setLabel("Limpiar Selección");
        limpiarSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarSeleccionActionPerformed(evt);
            }
        });

        botonCargar.setText("Cargar Archivo");
        botonCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargarActionPerformed(evt);
            }
        });

        botonRecargar.setLabel("Recargar");
        botonRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRecargarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout menuCerrarLayout = new org.jdesktop.layout.GroupLayout(menuCerrar);
        menuCerrar.setLayout(menuCerrarLayout);
        menuCerrarLayout.setHorizontalGroup(
            menuCerrarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(menuCerrarLayout.createSequentialGroup()
                .addContainerGap()
                .add(menuCerrarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(menuCerrarLayout.createSequentialGroup()
                        .add(menuCerrarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(panelMain, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 658, Short.MAX_VALUE)
                            .add(menuCerrarLayout.createSequentialGroup()
                                .add(12, 12, 12)
                                .add(menuCerrarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(menuCerrarLayout.createSequentialGroup()
                                        .add(borrar)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(limpiarSeleccion)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(botonRecargar)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(botonCargar))
                                    .add(menuCerrarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(panelConexion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(menuCerrarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                            .add(panelTabla)
                                            .add(panelOrden, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .add(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .add(menuCerrarLayout.createSequentialGroup()
                        .add(minimizar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(autores, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(31, 31, 31)
                        .add(cerrar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 109, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
            .add(jSeparator1)
        );
        menuCerrarLayout.setVerticalGroup(
            menuCerrarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(menuCerrarLayout.createSequentialGroup()
                .add(menuCerrarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, cerrar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, autores, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(minimizar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelMain, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 235, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelOrden, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelTabla, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 135, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(menuCerrarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(borrar)
                    .add(limpiarSeleccion)
                    .add(botonCargar)
                    .add(botonRecargar))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelConexion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(menuCerrar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(menuCerrar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gestionarPoliciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionarPoliciasActionPerformed
        this.repaint();
        int indice;
        String departamento = null;
        int edad = 0;
        PoliciasMantenimiento ventanaPolicias = new PoliciasMantenimiento(this, true);
        ventanaPolicias.setConexion(this.datos);
        if ((indice = this.tablaPolicias.getSelectedRow()) != (-1)) {
            Integer idPolicia = Integer.parseInt(tablaPolicias.getValueAt(indice, 0).toString());
            String nombre = tablaPolicias.getValueAt(indice, 1).toString();
            String numPlaca = tablaPolicias.getValueAt(indice, 2).toString();
            try {
                edad = Integer.parseInt(tablaPolicias.getValueAt(indice, 3).toString());
                departamento = tablaPolicias.getValueAt(indice, 4).toString();
            } catch (NullPointerException ex) {
            }
            Path foto = Paths.get(tablaPolicias.getValueAt(indice, 5).toString());
            policiaSeleccionado = new Policia(idPolicia, nombre, numPlaca);
            if (edad != 0) {
                policiaSeleccionado.setEdad(edad);
            }
            if (departamento != null) {
                policiaSeleccionado.setDepartamento(departamento);
            }
            if (foto != null) {
                policiaSeleccionado.setFoto(foto);
            }
            ventanaPolicias.setPolicia(policiaSeleccionado);
        }
        ventanaPolicias.setVisible(true);
    }//GEN-LAST:event_gestionarPoliciasActionPerformed

    private void gestionarMultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionarMultasActionPerformed
        this.repaint();
        MultasLista ventanaMultas = new MultasLista(this, true);
        ventanaMultas.setConexion(this.datos);
        ventanaMultas.setManejadorDeArchivos(this.manejadorDeArchivos);
        int indice;
        String departamento = null;
        int edad = 0;
        if ((indice = this.tablaPolicias.getSelectedRow()) != (-1)) {
            Integer idPolicia = Integer.parseInt(tablaPolicias.getValueAt(indice, 0).toString());
            String nombre = tablaPolicias.getValueAt(indice, 1).toString();
            String numPlaca = tablaPolicias.getValueAt(indice, 2).toString();
            try {
                edad = Integer.parseInt(tablaPolicias.getValueAt(indice, 3).toString());
                departamento = tablaPolicias.getValueAt(indice, 4).toString();
            } catch (NullPointerException ex) {
            }
            Path foto = Paths.get(tablaPolicias.getValueAt(indice, 5).toString());
            policiaSeleccionado = new Policia(idPolicia, nombre, numPlaca);
            if (edad != 0) {
                policiaSeleccionado.setEdad(edad);
            }
            if (departamento != null) {
                policiaSeleccionado.setDepartamento(departamento);
            }
            if (foto != null) {
                policiaSeleccionado.setFoto(foto);
            }

            ventanaMultas.setPolicia(policiaSeleccionado);
            
        }
        ventanaMultas.setVisible(true);
    }//GEN-LAST:event_gestionarMultasActionPerformed

    private void menuCerrarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCerrarMouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_menuCerrarMouseDragged

    private void menuCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCerrarMousePressed
        this.x = evt.getX();
        this.y = evt.getY();
    }//GEN-LAST:event_menuCerrarMousePressed

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_cerrarMouseClicked
    /**
     * Minimizar
     *
     * @param evt evento click para minimizar la ventana
     */
    private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_minimizarMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.datos = new JDBC();
        this.manejadorDeArchivos = new ArchivosDAO();
        try {
            this.datos.nuevaConexion();
            this.gestionarMultas.setEnabled(true);
            this.gestionarPolicias.setEnabled(true);
            this.estadoConexion.setText("Conectada");
            this.estadoConexion.setForeground(Color.green);
            this.rellenarTabla(this.orden.getSelectedItem().toString());
        } catch (SQLException ex) {
            this.gestionarMultas.setToolTipText("Sin conexión");
            this.gestionarPolicias.setToolTipText("Sin conexión");
            this.estadoConexion.setToolTipText("Comprueba tu conexión a la BD");
            JOptionPane.showMessageDialog(null, ex.getErrorCode() + " " + ex.getMessage() + " " + ex.getSQLState() + "Ha habido un problema al intentar conectar con la base de datos, comprueba la conexión", "Error conectando a la base de datos", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(rootPane, "No ha sido posible de conectar ");
        }
    }//GEN-LAST:event_formWindowOpened

    private void autoresMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_autoresMouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_autoresMouseDragged

    private void autoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_autoresMousePressed
        this.x = evt.getX();
        this.y = evt.getY();
    }//GEN-LAST:event_autoresMousePressed

    private void ordenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ordenItemStateChanged
        try {
            this.rellenarTabla(this.orden.getSelectedItem().toString());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "No es posible ordenar los datos"+"\n" +"no existe algun campo");

        }
    }//GEN-LAST:event_ordenItemStateChanged

    private void ordenCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_ordenCaretPositionChanged

    }//GEN-LAST:event_ordenCaretPositionChanged

    private void ordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordenActionPerformed

    }//GEN-LAST:event_ordenActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        int seleccionado = this.tablaPolicias.getSelectedRow();
        if (seleccionado != -1) {
            try {
                this.datos.borrarPorIdPolicia(Integer.parseInt(this.tablaPolicias.getValueAt(seleccionado, 0).toString()));
                this.rellenarTabla(this.orden.getSelectedItem().toString());
            } catch (SQLException | IOException ex) {
               JOptionPane.showMessageDialog(rootPane, "El policia no se encunetra en la base de datos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No has seleccionado ningun policia", "No has seleccionado ningun policia", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_borrarActionPerformed

    private void limpiarSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarSeleccionActionPerformed
        this.tablaPolicias.clearSelection();
    }//GEN-LAST:event_limpiarSeleccionActionPerformed

    private void botonCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargarActionPerformed
        List<Policia> listaPolicias;
        List<Policia> policiasNoInsertados = new ArrayList();
        int registros = 0;
        try {
            final JFileChooser fc = new JFileChooser();
            int indice = fc.showOpenDialog(this);
            if (indice == JFileChooser.APPROVE_OPTION) {
                fichero = fc.getSelectedFile();
                ruta = fichero.getAbsolutePath();
            }
            listaPolicias = this.manejadorDeArchivos.obtenerPoliciasDeFicher(fichero);
            for (Policia p : listaPolicias) {
                try {
                    registros = datos.insertarPoliciasPorLista(p);
                } catch (SQLException ex) {
                    if (ex.getErrorCode() == 1062) {
                        policiasNoInsertados.add(p);
                    }
                }
            }
            if (policiasNoInsertados.size() != 0) {
                JOptionPane.showMessageDialog(rootPane, "El Policia ya existe" + policiasNoInsertados, null, JOptionPane.WARNING_MESSAGE);
            }
            if (registros != 0) {
                JOptionPane.showMessageDialog(rootPane, "Datos Cargados");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Datos NO cargados :", null, JOptionPane.WARNING_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Datos NO cargados" + ex.getMessage(), null, JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botonCargarActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowStateChanged

    private void botonRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRecargarActionPerformed
        try {
            this.rellenarTabla(this.orden.getSelectedItem().toString());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Datos No ordenados");
        }
    }//GEN-LAST:event_botonRecargarActionPerformed
    public void rellenarTabla(String orden) throws IOException {
        try {
            String[] filas = new String[6];
            String[] titulos = {"IdPolicia", "Nombre", "NumPlaca", "Edad", "Departamento", "Foto"};
            tabla = new DefaultTableModel(null, titulos);

            for (Policia p : this.datos.obtenerPolicias(orden)) {
                filas[0] = p.getIdPolicia().toString();
                filas[1] = p.getNombre();
                filas[2] = p.getNumPlaca();
                try {
                    filas[3] = p.getEdad().toString();
                } catch (NullPointerException ex) {
                    filas[3] = 0 + "";
                }
                filas[4] = p.getDepartamento();
                if (p.getFoto() == null) {
                    Path rutaIcono = Paths.get(this.rutaAbsoluta.getCanonicalPath() + "/src/Imagenes/iconoanonimo.jpg");
                    filas[5] = rutaIcono.toString();
                } else {
                    filas[5] = p.getFoto().toString();
                }
                this.tabla.addRow(filas);
            }
            this.tablaPolicias.setModel(tabla);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getErrorCode() + " " + ex.getMessage() + " " + ex.getSQLState() + "Ha habido un problema al intentar rellenar la tabla, comprueba la conexión", "Error conectando a la base de datos", JOptionPane.ERROR_MESSAGE);
        }
    }
    Policia policiaSeleccionado;
    private File rutaAbsoluta = new File(".");
    private DefaultTableModel tabla;
    private JDBC datos;
    private final Image i = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/icono.png"));
    private int x = 0;
    private int y = 0;
    private File fichero;
    private String ruta;
    private ArchivosDAO manejadorDeArchivos;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BD;
    private javax.swing.JLabel autores;
    private javax.swing.JButton borrar;
    private javax.swing.JButton botonCargar;
    private javax.swing.JButton botonRecargar;
    private javax.swing.JLabel cerrar;
    private javax.swing.JLabel estadoConexion;
    private javax.swing.JButton gestionarMultas;
    private javax.swing.JButton gestionarPolicias;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton limpiarSeleccion;
    private javax.swing.JLabel listaPolicias;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel menuCerrar;
    private javax.swing.JLabel minimizar;
    private javax.swing.JComboBox<String> orden;
    private javax.swing.JLabel ordenarPor;
    private java.awt.Panel panelConexion;
    private javax.swing.JPanel panelDerecha;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelOrden;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JTable tablaPolicias;
    // End of variables declaration//GEN-END:variables
}
