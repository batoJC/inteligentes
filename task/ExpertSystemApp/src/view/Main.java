/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import expertsystem.HumanInterface;
import expertsystem.IFact;
import expertsystem.Motor;
import expertsystem.Rule;
import expertsystemapp.ReaderFile;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author Work
 */
public class Main extends javax.swing.JFrame implements HumanInterface {

    private String filePath = "";
    private  Motor motor;
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }
    
    public void run() {
        System.out.println("Run");
        motor = new Motor(this);
        
        String [] rules = ReaderFile.ReaderFile(filePath);
        for (String rule : rules) {
            motor.addRule(rule);
        }
        
        // TODO: start process
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSelectFile = new javax.swing.JButton();
        lblFile = new javax.swing.JLabel();
        btnInitMotor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResponse = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSelectFile.setText("Seleccionar Archivo Con las Reglas");
        btnSelectFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectFileActionPerformed(evt);
            }
        });

        lblFile.setText("Nombre archivo: ");

        btnInitMotor.setText("Iniciar Motor");
        btnInitMotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInitMotorActionPerformed(evt);
            }
        });

        txtResponse.setColumns(20);
        txtResponse.setRows(5);
        jScrollPane1.setViewportView(txtResponse);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSelectFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                        .addComponent(btnInitMotor))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFile)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelectFile)
                    .addComponent(btnInitMotor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFile)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectFileActionPerformed
        
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            // Set name of file
           
            System.out.println( file.getAbsolutePath());
        } 
    }//GEN-LAST:event_btnSelectFileActionPerformed

    private void btnInitMotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInitMotorActionPerformed
        txtResponse.setText("Iniciando Motor...");
        this.run();
    }//GEN-LAST:event_btnInitMotorActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInitMotor;
    private javax.swing.JButton btnSelectFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFile;
    private javax.swing.JTextArea txtResponse;
    // End of variables declaration//GEN-END:variables

    @Override
    public int askIntValue(String string) {
        // TODO: implement a joption for ask a int value

        return 0;
    }

    @Override
    public boolean askBoolValue(String string) {
        // TODO: implement a joption for ask a if yes or no
        return false;
    }

    @Override
    public void printFacts(List<IFact> list) {
        // TODO: print in the txtResponse
    }

    @Override
    public void printRules(List<Rule> list) {
        // TODO: print in the txtResponse
    }
}
