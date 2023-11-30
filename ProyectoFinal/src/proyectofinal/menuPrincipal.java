package proyectofinal;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Arrays;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import static proyectofinal.Prueba4.actualizarCalificaciones;
import static proyectofinal.Prueba4.agregarPalabras;
import static proyectofinal.Prueba4.aumentarOraciones;
import static proyectofinal.Prueba4.compararResultados;
import static proyectofinal.Prueba4.completarOraciones;
import static proyectofinal.Prueba4.descargarPDF;
import static proyectofinal.Prueba4.ordenarPalabras;
import static proyectofinal.Prueba4.traducir;
import static proyectofinal.Prueba4.verCalificaciones;

public class menuPrincipal extends javax.swing.JFrame {
    static ArrayList<String> verbosIngles = new ArrayList<>();
    static ArrayList<String> verbosEspanol = new ArrayList<>();
    static ArrayList<String> verbosInglesI = new ArrayList<>();
    static ArrayList<String> verbosEspanolI = new ArrayList<>();
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static Usuario usuario;
    static Calificaciones Cl;
    static MySQL con=new MySQL();
    static Connection cn=con.conectar();
    public menuPrincipal() {
        initComponents();
        nombeMP.setText(usuario.getNombre());
        tokenMP.setText(usuario.getToken());
        this.setLocationRelativeTo(null);
    }
    
    public static void menuP(ArrayList<String> InglesI,ArrayList<String> EspanolI,ArrayList<String> Ingles,ArrayList<String> Espanol,ArrayList<Usuario> usuariosL, Usuario usu){
        verbosInglesI=InglesI;
        verbosEspanolI=EspanolI;
        verbosIngles=Ingles;
        verbosEspanol=Espanol;
        usuarios=usuariosL;
        usuario=usu;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        minijuegosMP = new javax.swing.JButton();
        compararMP = new javax.swing.JButton();
        agregarPalabrasMP = new javax.swing.JButton();
        ieMP = new javax.swing.JButton();
        eiMP = new javax.swing.JButton();
        verCalificacionMp = new javax.swing.JButton();
        pdfMP = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        salir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombeMP = new javax.swing.JTextField();
        tokenMP = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(150, 201, 210));

        minijuegosMP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        minijuegosMP.setText("Jugar minijuegos");
        minijuegosMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minijuegosMPActionPerformed(evt);
            }
        });

        compararMP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        compararMP.setText("Comparar resultados");
        compararMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compararMPActionPerformed(evt);
            }
        });

        agregarPalabrasMP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        agregarPalabrasMP.setText("Agregar palabras");
        agregarPalabrasMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPalabrasMPActionPerformed(evt);
            }
        });

        ieMP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ieMP.setText("Traducir del inglés al español");
        ieMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ieMPActionPerformed(evt);
            }
        });

        eiMP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        eiMP.setText("Traducir del español al inglés");
        eiMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eiMPActionPerformed(evt);
            }
        });

        verCalificacionMp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        verCalificacionMp.setText("Ver calificaciones");
        verCalificacionMp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCalificacionMpActionPerformed(evt);
            }
        });

        pdfMP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pdfMP.setText("Descargar PDF de notas");
        pdfMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfMPActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("¿Deseas estudiar tus preguntas erradas?");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Estudiar preguntas erradas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pdfMP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(compararMP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(verCalificacionMp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ieMP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(agregarPalabrasMP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eiMP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(minijuegosMP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(ieMP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eiMP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agregarPalabrasMP)
                .addGap(18, 18, 18)
                .addComponent(minijuegosMP)
                .addGap(18, 18, 18)
                .addComponent(verCalificacionMp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(compararMP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pdfMP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(83, 83, 83))
        );

        jPanel2.setBackground(new java.awt.Color(4, 40, 62));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(92, 173, 192));
        jLabel1.setText("¡Bienvenido!");

        salir.setBackground(new java.awt.Color(252, 164, 181));
        salir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        salir.setText("Cerrar sesión");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Token:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tokenMP))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nombeMP))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(salir)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombeMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tokenMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salir)
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ieMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ieMPActionPerformed
        CalificacionUsuario calificacion = traducir(verbosIngles, verbosEspanol,usuario);
        usuario.agregarCalificacion(calificacion);
        actualizarCalificaciones(calificacion.getPreguntasRealizadas(),calificacion.getPreguntasCorrectas(),calificacion.getPorcentajeAcierto(), usuario);
    }//GEN-LAST:event_ieMPActionPerformed

    private void eiMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eiMPActionPerformed
        CalificacionUsuario calificacion = traducir(verbosEspanol, verbosIngles,usuario);
        usuario.agregarCalificacion(calificacion);
        actualizarCalificaciones(calificacion.getPreguntasRealizadas(),calificacion.getPreguntasCorrectas(),calificacion.getPorcentajeAcierto(), usuario);
    }//GEN-LAST:event_eiMPActionPerformed

    private void minijuegosMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minijuegosMPActionPerformed
        String opcion = JOptionPane.showInputDialog( "¿Qué minijuego deseas jugar?\n1. Ordenar palabras\n2. Completar oraciones\n3. Agregar oraciones\n0. Salir");
                            if (opcion.equals("1")) {
                                ordenarPalabras();
                            }
                            else if (opcion.equals("2")) {
                                completarOraciones();
                            }
                            else if (opcion.equals("3")) {
                                aumentarOraciones();
                            }
                            else if (opcion.equals("0")) {
                                return;
                            }
    }//GEN-LAST:event_minijuegosMPActionPerformed

    private void verCalificacionMpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCalificacionMpActionPerformed
        //verCalificaciones(usuario);
        Cl.Cali(usuario);
        Cl =new Calificaciones();
        Cl.setVisible(true);
    }//GEN-LAST:event_verCalificacionMpActionPerformed

    private void pdfMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfMPActionPerformed
        descargarPDF(usuario);
    }//GEN-LAST:event_pdfMPActionPerformed

    private void compararMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compararMPActionPerformed
        compararResultados(usuarios);
    }//GEN-LAST:event_compararMPActionPerformed

    private void agregarPalabrasMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPalabrasMPActionPerformed
        agregarPalabras();
    }//GEN-LAST:event_agregarPalabrasMPActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String[] opciones = {"Traducir del inglés al español","Traducir del español al inglés", "Salir"};
        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción ", "Repetir preguntas erradas",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        if(seleccion==0){
            
        }
        else if(seleccion==1){
        }
        else if(seleccion==2){
            return;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarPalabrasMP;
    private javax.swing.JButton compararMP;
    private javax.swing.JButton eiMP;
    private javax.swing.JButton ieMP;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton minijuegosMP;
    private javax.swing.JTextField nombeMP;
    private javax.swing.JButton pdfMP;
    private javax.swing.JButton salir;
    private javax.swing.JTextField tokenMP;
    private javax.swing.JButton verCalificacionMp;
    // End of variables declaration//GEN-END:variables
}
