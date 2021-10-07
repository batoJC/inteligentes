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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;

/**
 *
 * @author Work
 */
public class Main extends javax.swing.JFrame implements HumanInterface {

    private String filePath = "";
    private Motor motor;
    public Scanner keyboard = new Scanner(System.in);
    public String regla;
    public boolean bandera=true;
    public Question answer=new Question(this,true);


    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }

    public void run() {
        System.out.println("Run");
        motor = new Motor(this);

        ArrayList<String> rules = ReaderFile.ReaderFile(filePath);
        rules.forEach((rule) -> {
            motor.addRule(rule);
        });

        // TODO: start process
        do{
        txtResponse.setText(txtResponse.getText() + "\n Resolución **");
        motor.solve();
        txtResponse.setText(txtResponse.getText() + "\n¿Desea salir? (s/n)");
        } while (!close("¿Desea salir? (s/n)").equalsIgnoreCase("s"));
        this.setVisible(false);

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
        txtResponse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtResponseKeyPressed(evt);
            }
        });
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
            filePath = file.getAbsolutePath();
        }
    }//GEN-LAST:event_btnSelectFileActionPerformed

    private void btnInitMotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInitMotorActionPerformed
        txtResponse.setText("Iniciando Motor...");
        this.run();
        
    }//GEN-LAST:event_btnInitMotorActionPerformed

    private void txtResponseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtResponseKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try{
                this.regla=this.getText();
            } catch (BadLocationException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtResponseKeyPressed

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

    
    
    public String close(String question){
        answer.recibeDatos(question);
        answer.setVisible(true);
        String mensaje = answer.obtenerTexto();
        answer.limpiarTexto();
        return mensaje;
    }
        
    
    @Override
    public int askIntValue(String question) {
        // TODO: implement a joption for ask a int value
        System.out.println(question);
        txtResponse.setText(txtResponse.getText() + "\n" + question);

        try {
            answer.recibeDatos(question);
            answer.setVisible(true);
            String mensaje = answer.obtenerTexto();
            answer.limpiarTexto();
            txtResponse.setText(txtResponse.getText() + "\n" + mensaje);
            return Integer.parseInt(mensaje);
        } catch (NumberFormatException e) {
            return 0;
        }

    }

    @Override
    public boolean askBoolValue(String question) {
        try {
            System.out.println(question + " (si, no)");
            txtResponse.setText(txtResponse.getText() + "\n" + question + " (si, no)");
            answer.recibeDatos(question+ " (si, no)");
            answer.setVisible(true);
            String mensaje = answer.obtenerTexto();
            answer.limpiarTexto();
            String res = mensaje;
            txtResponse.setText(txtResponse.getText() + "\n" + mensaje);
            return (res.equals("si"));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void printFacts(List<IFact> facts) {
        String res = "Solución(s) encontrada(s) : \n";
        Collections.sort(facts, (IFact f1, IFact f2) -> {
            return Integer.compare(f2.getLevel(), f1.getLevel());
        });
        for (IFact f : facts) {
            if (f.getLevel() != 0) {
                res += f.toString() + "\n";
            }
        }
        System.out.println(res);
        txtResponse.setText(txtResponse.getText() + "\n" + res);
    }

    @Override
    public void printRules(List<Rule> rules) {
        String res = "";
        for (Rule r : rules) {
            res += r.toString() + "\n";
        }
        System.out.println(res);
        txtResponse.setText(txtResponse.getText() + "\n" + res);
    }

    private String getText() throws BadLocationException {
        Document document = txtResponse.getDocument();
        Element rootElem = document.getDefaultRootElement();
        int numLines = rootElem.getElementCount();
        Element lineElem = rootElem.getElement(numLines - 1);
        int lineStart = lineElem.getStartOffset();
        int lineEnd = lineElem.getEndOffset();
        String lineText = document.getText(lineStart, lineEnd - lineStart);
        return lineText.replace("\n", "");
    }
}
