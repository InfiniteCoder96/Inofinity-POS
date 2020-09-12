/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Viewer;

import Model.DB;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jdesktop.xswingx.PromptSupport;

/**
 *
 * @author Ashan Lakshitha
 */
public class supplier_payment extends javax.swing.JDialog {

    /**
     * Creates new form customer_payment
     */
    DB d = new DB();
    String loginuser;
    Debit debit;
    SimpleDateFormat sdf;
    
    public supplier_payment(java.awt.Frame parent, boolean modal , String cus , String user , Debit c) {
        super(parent, modal);
        initComponents();
        setFrontText();
        datecombo.setCurrent(Calendar.getInstance());
        sdf = new SimpleDateFormat("YYYY-MM-dd");
        datecombo.setDateFormat(sdf);
        loginuser = user;
        debit = c;
        setcustomer(cus);
    }
    
    private void setFrontText() {
        setPront(cashtxt, "Cash Payment");
        setPront(cnotxt, "Cheque No#");
        setPront(camounttxt, "Amount");
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        customerlbl = new javax.swing.JLabel();
        balancelbl = new javax.swing.JLabel();
        cidtxt = new javax.swing.JLabel();
        typecombo = new javax.swing.JComboBox();
        chanegepanel = new javax.swing.JPanel();
        cashpanel = new javax.swing.JPanel();
        cashtxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        balancelbl2 = new javax.swing.JLabel();
        paymenttxt = new javax.swing.JLabel();
        duetxt = new javax.swing.JLabel();
        chequepanel = new javax.swing.JPanel();
        bankcombo = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        datecombo = new datechooser.beans.DateChooserCombo();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cnotxt = new javax.swing.JTextField();
        camounttxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Payment to supplier");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Create");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Real_Estate_sign_cheque-64.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Supplier");

        jLabel5.setText("Credit Details");

        customerlbl.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        customerlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        customerlbl.setText("Supplier Name");

        balancelbl.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        balancelbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        balancelbl.setText("0.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(balancelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(customerlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(14, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(balancelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(customerlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(113, Short.MAX_VALUE)))
        );

        typecombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash", "Cheque" }));
        typecombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typecomboActionPerformed(evt);
            }
        });

        chanegepanel.setBackground(new java.awt.Color(255, 255, 255));
        chanegepanel.setLayout(new java.awt.CardLayout());

        cashpanel.setBackground(new java.awt.Color(255, 255, 255));

        cashtxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cashtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashtxtActionPerformed(evt);
            }
        });
        cashtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cashtxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cashtxtKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Credit :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Payment :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Due :");

        balancelbl2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        balancelbl2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        balancelbl2.setText("0.00");

        paymenttxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        paymenttxt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        paymenttxt.setText("0.00");

        duetxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        duetxt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        duetxt.setText("0.00");

        javax.swing.GroupLayout cashpanelLayout = new javax.swing.GroupLayout(cashpanel);
        cashpanel.setLayout(cashpanelLayout);
        cashpanelLayout.setHorizontalGroup(
            cashpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cashpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cashtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(cashpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(cashpanelLayout.createSequentialGroup()
                        .addGroup(cashpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cashpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(paymenttxt, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(duetxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(cashpanelLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(balancelbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        cashpanelLayout.setVerticalGroup(
            cashpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cashpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cashpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cashtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cashpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(balancelbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(cashpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(paymenttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cashpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(duetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        chanegepanel.add(cashpanel, "card2");

        chequepanel.setBackground(new java.awt.Color(255, 255, 255));

        bankcombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "HNB", "SAMPATH", "BOC", "COMMERCIAL", "NTB", "NSB", "MAHAJANA", "DFCC" }));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel12.setText("Select Bank");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel13.setText("Select Date");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel14.setText("Cheque No#");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel15.setText("Amount");

        cnotxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cnotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnotxtActionPerformed(evt);
            }
        });
        cnotxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cnotxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cnotxtKeyTyped(evt);
            }
        });

        camounttxt.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        camounttxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camounttxtActionPerformed(evt);
            }
        });
        camounttxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                camounttxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                camounttxtKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout chequepanelLayout = new javax.swing.GroupLayout(chequepanel);
        chequepanel.setLayout(chequepanelLayout);
        chequepanelLayout.setHorizontalGroup(
            chequepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chequepanelLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(chequepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cnotxt)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bankcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(37, 37, 37)
                .addGroup(chequepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15)
                    .addComponent(jLabel13)
                    .addComponent(datecombo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(camounttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        chequepanelLayout.setVerticalGroup(
            chequepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chequepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(chequepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(chequepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bankcombo, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(datecombo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(chequepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(chequepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cnotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(camounttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        chanegepanel.add(chequepanel, "card3");

        jButton1.setText("Pay Now");
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chanegepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(typecombo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(typecombo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chanegepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void typecomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typecomboActionPerformed
        if(typecombo.getSelectedItem().toString().equals("Cash")){
            chequepanel.setVisible(false);
            cashpanel.setVisible(true);
        }else if(typecombo.getSelectedItem().toString().equals("Cheque")){
            cashpanel.setVisible(false);
            chequepanel.setVisible(true);
        }else{
            System.out.println(typecombo.getSelectedItem().toString());
        }
    }//GEN-LAST:event_typecomboActionPerformed

    private void cashtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashtxtActionPerformed
        
    }//GEN-LAST:event_cashtxtActionPerformed

    private void cashtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashtxtKeyReleased
        
        if(cashtxt.getText().isEmpty()){
            paymenttxt.setText("0.00");
            duetxt.setText(balancelbl.getText());
        }else if(balancelbl.getText().isEmpty()){
            
        }else{
        
        Double credit = Double.parseDouble(balancelbl.getText());
        Double payment = Double.parseDouble(cashtxt.getText());
        paymenttxt.setText(payment + "");
        duetxt.setText(credit - payment + "");
        
        }
        
    }//GEN-LAST:event_cashtxtKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(typecombo.getSelectedItem().toString().equals("Cash")){
        
            if(cashtxt.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please enter cash amount");
            }else{
                paycash();
            }
            
        }else if(typecombo.getSelectedItem().toString().equals("Cheque")){
            paycheque();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cnotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnotxtActionPerformed

    private void cnotxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cnotxtKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cnotxtKeyReleased

    private void camounttxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camounttxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_camounttxtActionPerformed

    private void camounttxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camounttxtKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_camounttxtKeyReleased

    private void cashtxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashtxtKeyTyped
        char c = evt.getKeyChar();
        
        String key = String.valueOf(c);
        
        if  (!(Character.isDigit(c) || key.equals(".") )) {
            evt.consume();
	    Toolkit.getDefaultToolkit().beep();
        } 
        
        if(cashtxt.getText().contains(".") && key.equals(".")){
            evt.consume();
	    Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_cashtxtKeyTyped

    private void camounttxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camounttxtKeyTyped
        char c = evt.getKeyChar();
        
        String key = String.valueOf(c);
        
        if  (!(Character.isDigit(c) || key.equals(".") )) {
            evt.consume();
	    Toolkit.getDefaultToolkit().beep();
        } 
        
        if(camounttxt.getText().contains(".") && key.equals(".")){
            evt.consume();
	    Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_camounttxtKeyTyped

    private void cnotxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cnotxtKeyTyped
        char c = evt.getKeyChar();
        
        String key = String.valueOf(c);
        
        if  (!(Character.isDigit(c) || key.equals("/")  || key.equals("-") || key.equals("/")|| key.equals(",")|| key.equals(".") || key.equals(".") || Character.isAlphabetic(c))) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_cnotxtKeyTyped

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
            java.util.logging.Logger.getLogger(supplier_payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(supplier_payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(supplier_payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(supplier_payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                supplier_payment dialog = new supplier_payment(new javax.swing.JFrame(), true , "0" , "admin" , null);
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
    private javax.swing.JLabel balancelbl;
    private javax.swing.JLabel balancelbl2;
    private javax.swing.JComboBox bankcombo;
    private javax.swing.JTextField camounttxt;
    private javax.swing.JPanel cashpanel;
    private javax.swing.JTextField cashtxt;
    private javax.swing.JPanel chanegepanel;
    private javax.swing.JPanel chequepanel;
    private javax.swing.JLabel cidtxt;
    private javax.swing.JTextField cnotxt;
    private javax.swing.JLabel customerlbl;
    private datechooser.beans.DateChooserCombo datecombo;
    private javax.swing.JLabel duetxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel paymenttxt;
    private javax.swing.JComboBox typecombo;
    // End of variables declaration//GEN-END:variables

    private void setcustomer(String cus) {
        
        try {
            ResultSet rs = d.srh("select * from supplier where id = '"+cus+"'");
            while (rs.next()) { 
               cidtxt.setText(cus);
               customerlbl.setText("<html>"+rs.getString("name")+"<br>"+rs.getString("number")+"</html>");
               balancelbl.setText(rs.getString("balance"));
               balancelbl2.setText(rs.getString("balance"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }

    private void paycash() {
    
        if(cashtxt.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Insert a valid Payment");
        }else{
            try {
                System.out.println("insert into supplier_payment (supplier_id, date, payment, payment_type, extra, user_usename ) values('"+cidtxt.getText()+"' , NOW() , '"+paymenttxt.getText()+"'  , 'Cash' , '' , '"+loginuser+"' , '"+balancelbl.getText()+"' , '"+duetxt.getText()+"' )");
                int j = d.audr("insert into supplier_payment (supplier_id, date, payment, payment_type, extra, user_usename ) "
                        + "values('"+cidtxt.getText()+"' , NOW() , '"+paymenttxt.getText()+"'  , 'Cash' , '' , '"+loginuser+"' )");
                int j1 = d.aud("update supplier set balance = balance - '"+paymenttxt.getText()+"' where id = '"+cidtxt.getText()+"' ");
                JOptionPane.showMessageDialog(this, "Saved Successfully with Reciept NO# " + j);
                debit.updatecustomer(cidtxt.getText());
                this.dispose();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
    }
    
    private void paycheque() {
        if(cnotxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Insert a valid Cheque No#");
        }else if(camounttxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Insert a valid Amount");
        }else{
            try {
                double payment = Double.parseDouble(camounttxt.getText());
                double credit = Double.parseDouble(balancelbl.getText());
                double balance = credit - payment;
                String chequeno = cnotxt.getText();
                String cheauedate = datecombo.getText();
                String bank = bankcombo.getSelectedItem().toString();
                
                int j = d.audr("insert into supplier_payment (supplier_id, date, payment, payment_type, extra, user_usename ) "
                        + "values('"+cidtxt.getText()+"' , NOW() , '"+payment+"'  , 'Cheque' , '"+chequeno+"' , '"+loginuser+"' )");
                
                int j1 = d.aud("update supplier set balance = balance - '"+payment+"' where id = '"+cidtxt.getText()+"' ");
                
                int j2 = d.aud("insert into cheque (number, payment_id, uid, type, date, bank, amount, status, cid) "
                        + "VALUES ( '"+chequeno+"' , '"+j+"' , '"+loginuser+"' , 'send' , '"+cheauedate+"' , '"+bank+"' , '"+payment+"' , '1' , '"+cidtxt.getText()+"' ) ");
                
                JOptionPane.showMessageDialog(this, "Saved Successfully with Reciept NO# " + j);
                debit.updatecustomer(cidtxt.getText());
                this.dispose();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
    }
    
    
}
