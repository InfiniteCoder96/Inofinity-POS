/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.DB;
import java.awt.Toolkit;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.xswingx.PromptSupport;

/**
 *
 * @author ashan
 */
public class Expenses extends javax.swing.JDialog {

    /**
     * Creates new form Expenses
     */
    DB d = new DB();
    String user;
    DefaultTableModel dtm ;
    
    public Expenses(java.awt.Frame parent, boolean modal , String Username) {
        super(parent, modal);
        initComponents();
        setFrontText();
        dtm = (DefaultTableModel) jTable1.getModel();
        user = Username;
        tableload();
    }
    
    private void setFrontText() {
        setPront(nametxt, "Expense Description");
        setPront(amounttxt, "Amount");
    }

    private void setPront(JTextField a, String text) {
        PromptSupport.setPrompt(text, a);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, a);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        amounttxt = new javax.swing.JTextField();
        nametxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cattxt = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Expenses");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("create");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/colored-03-48.png"))); // NOI18N

        amounttxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        amounttxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amounttxtActionPerformed(evt);
            }
        });
        amounttxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amounttxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amounttxtKeyTyped(evt);
            }
        });

        nametxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        nametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametxtActionPerformed(evt);
            }
        });
        nametxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nametxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nametxtKeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Catagary", "Description", "Amount"
            }
        ));
        jTable1.setRowHeight(30);
        jTable1.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable1);

        cattxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Salary", "Utility", "Financial" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amounttxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nametxt, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                            .addComponent(cattxt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(cattxt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(amounttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void amounttxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amounttxtActionPerformed
        if(amounttxt.getText().isEmpty()){

        }else{
            save();
        }
    }//GEN-LAST:event_amounttxtActionPerformed

    private void amounttxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amounttxtKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_amounttxtKeyReleased

    private void amounttxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amounttxtKeyTyped
        char c = evt.getKeyChar();

        String key = String.valueOf(c);

        if  (!(Character.isDigit(c) || key.equals("/") || key.equals(" ") || key.equals("(") || key.equals(")") || key.equals("-") || key.equals("+") || key.equals("/")|| key.equals(",")|| key.equals(".") || key.equals(".") || Character.isAlphabetic(c))) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }

        if(amounttxt.getText().length() == 0 && key.equals(" ") ){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_amounttxtKeyTyped

    private void nametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametxtActionPerformed
        if(nametxt.getText().isEmpty()){

        }else{
            amounttxt.requestFocus();
        }
    }//GEN-LAST:event_nametxtActionPerformed

    private void nametxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nametxtKeyReleased

    }//GEN-LAST:event_nametxtKeyReleased

    private void nametxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nametxtKeyTyped
        char c = evt.getKeyChar();

        String key = String.valueOf(c);

        if  (!(Character.isDigit(c) || key.equals("/") || key.equals(" ") || key.equals("(") || key.equals(")") || key.equals("-") || key.equals("+") || key.equals("/")|| key.equals(",")|| key.equals(".") || key.equals(".") || Character.isAlphabetic(c))) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }

        if(nametxt.getText().length() == 0 && key.equals(" ") ){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_nametxtKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        save();
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
            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Expenses dialog = new Expenses(new javax.swing.JFrame(), true , "admin");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amounttxt;
    private javax.swing.JComboBox<String> cattxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nametxt;
    // End of variables declaration//GEN-END:variables

    private void save() {
    
        if(nametxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Insert a valid Name");
        }else{
            try {
                int j = d.audr("insert into expenses ( catagary, description, amount, cdate, cuser) values('"+cattxt.getSelectedItem().toString()+"' , '"+nametxt.getText()+"' , '"+amounttxt.getText()+"' , NOW()  , '"+user+"' ) ");
                tableload();
                clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void clear() {
        nametxt.setText("");
        amounttxt.setText("");
        
    }

    private void tableload() {
    
     dtm.setRowCount(0);
        
        try {
            ResultSet rs = d.srh("select * from expenses order by id DESC ");
            while (rs.next()) { 
               java.util.Vector v = new java.util.Vector();
               v.add(rs.getString("cdate"));
               v.add(rs.getString("catagary"));
               v.add(rs.getString("description"));
               v.add(rs.getString("amount"));
               dtm.addRow(v);               
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
}
