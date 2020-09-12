/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Viewer;

import Model.DB;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.PrinterName;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Ashan Lakshitha
 */
public class printbarcode extends javax.swing.JDialog {

    /**
     * Creates new form printbarcode
     */
    JasperPrint jp = null;
    DB d = new DB(); 
    String product = "";
    String stid = "";
    
    public printbarcode(java.awt.Frame parent, boolean modal , String pid) {
        super(parent, modal);
        initComponents();
        product = pid;
        getData();
    }
    
    public void getData(){
        String pid = "";
        String name = "";
        String exp = "";
        String mfd = "";
        Double price = 0.0;
        Double qty = 0.0;
        
        try {
            
            ResultSet rs = d.srh("select * , CURDATE() as mfd from stock inner join product on product.id = stock.product_id where product_id = '"+product+"' ORDER BY stock.id DESC limit 1");
            while(rs.next()){
                pid = rs.getString("product_id");
                stid = rs.getString("stock.id");
                price = rs.getDouble("maxprice");
                qty = rs.getDouble("buyqty");
                qtytxt.setText(qty +"");
                name = rs.getString("sname");
                exp = rs.getString("exdate");  
                mfd = rs.getString("mfd");
            }
            
            pidtxt.setText(pid);
            nametxt.setText(name);
            qtytxt.setText(qty+"");
            pricetxt.setText(price+"");
            mfdate.setText(mfd);
            expdate.setText(exp);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            
            d.aud("Truncate table tmpprint");
            
            int pi = 0;
            
            for (int i = 0; i < qty; i++) {
            pi = d.aud("insert into tmpprint (pid, price , defprice , sname , exp , mfd , stid ) values('"+product+"' , '"+price+"' , '"+price+"' , '"+name+"' , 'EXP "+exp+"' , 'MFD "+mfd+"' , '"+stid+"' )");
            }
            if(pi == 1){
                ViewReport(product);
            }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void getData2(){
        String pid = pidtxt.getText();
        String name = nametxt.getText();
        String mfd = "MFD "+mfdate.getText();
        String exp = "EXP "+expdate.getText();
        Double price = Double.parseDouble(pricetxt.getText());
        Double qty = Double.parseDouble(qtytxt.getText());
        
        try {
            
            d.aud("Truncate table tmpprint");
            
            int pi = 0;
            
            for (int i = 0; i < qty; i++) {
            pi = d.aud("insert into tmpprint (pid, price , defprice , sname , exp , mfd , stid ) values('"+product+"' , '"+price+"' , '"+price+"' , '"+name+"' , '"+exp+"' , '"+mfd+"' , '"+stid+"' )");
            }
            if(pi == 1){
                ViewReport(product);
                
            }
                
        } catch (Exception e) {
            e.printStackTrace();
            jButton1.setEnabled(true);
            saveandprintbtn.setEnabled(true);
            jButton1.setText("Generate");
        }
        jButton1.setEnabled(true);
        saveandprintbtn.setEnabled(true);
        jButton1.setText("Generate");
    }
    
    
    JasperPrint jpr = null;
    
    public void ViewReport(String i){
        try {
        //1 compile jrxm file
        JasperReport jr = JasperCompileManager.compileReport(getClass().getResourceAsStream("/Report/BARCODER.jrxml"));
        //2insert paramters
        java.util.Map m=new java.util.HashMap();
        //java.util.Date d=new Date(2015, 2, 236);
            m.put("ID", i);
        //3 run engine
            JasperPrint jp =JasperFillManager.fillReport(jr, m , d.getConnection());
        //4 view result
             JRViewer jv=new JRViewer(jp);
             jv.setBorder(BorderFactory.createEmptyBorder());
             jTabbedPane1.removeAll();
             jTabbedPane1.addTab("product ID :" + i, jv);
             //jTabbedPane1.setBorder(BorderFactory.createEmptyBorder());
             //jPanel3.add(jv);
             //reportpanel.add(jv);
             //JasperViewer.viewReport(jp);
             jpr = jp;
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    
    }
    
    public void printer() throws Exception{
    try {
        
        JasperPrint jasperPrint = jpr;         

        PrinterJob printerJob = PrinterJob.getPrinterJob();

        PageFormat pageFormat = PrinterJob.getPrinterJob().defaultPage();
        printerJob.defaultPage(pageFormat);

        int selectedService = 0;


        AttributeSet attributeSet = new HashPrintServiceAttributeSet(new PrinterName("BarcodePrinter", null));
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, attributeSet);

        try {
            printerJob.setPrintService(printService[selectedService]);

        } catch (Exception e) {

            System.out.println(e);
        }
        JRPrintServiceExporter exporter;
        PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
        printRequestAttributeSet.add(new Copies(1));

        // these are deprecated
        exporter = new JRPrintServiceExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, printService[selectedService]);
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, printService[selectedService].getAttributes());
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
        exporter.exportReport();

    } catch (JRException e) {
        e.printStackTrace();
    }
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        saveandprintbtn = new javax.swing.JButton();
        qtytxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        reportpanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jButton1 = new javax.swing.JButton();
        pricetxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pidtxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        mfdate = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        expdate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BARCODE PRINT");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(628, 126));

        saveandprintbtn.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        saveandprintbtn.setText(" Print");
        saveandprintbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveandprintbtnActionPerformed(evt);
            }
        });

        qtytxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qtytxtKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Print Qty");

        javax.swing.GroupLayout reportpanelLayout = new javax.swing.GroupLayout(reportpanel);
        reportpanel.setLayout(reportpanelLayout);
        reportpanelLayout.setHorizontalGroup(
            reportpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportpanelLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        reportpanelLayout.setVerticalGroup(
            reportpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
        );

        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton1.setText("Genarate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        pricetxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pricetxtKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Print Price");

        pidtxt.setEditable(false);
        pidtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pidtxtKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Product ID");

        nametxt.setFont(new java.awt.Font("FMBindumathi", 1, 14)); // NOI18N
        nametxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nametxtKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Print Name");

        mfdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mfdateKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("MF Date");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Expire Date");

        expdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                expdateKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(qtytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(116, 116, 116)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveandprintbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mfdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(expdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(reportpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(reportpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pidtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(mfdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(expdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(pricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qtytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(saveandprintbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveandprintbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveandprintbtnActionPerformed
        try {
            printer();
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Cannot print file");
        }
    }//GEN-LAST:event_saveandprintbtnActionPerformed
int Xmouse, Ymouse;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(qtytxt.getText().isEmpty()){
        
        }else{
            generatecodes();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void qtytxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtytxtKeyTyped
        char c = evt.getKeyChar();

        String key = String.valueOf(c);

        if  (!(Character.isDigit(c) )) {
            evt.consume();
        }

        
    }//GEN-LAST:event_qtytxtKeyTyped

    private void pricetxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pricetxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_pricetxtKeyTyped

    private void pidtxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pidtxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_pidtxtKeyTyped

    private void nametxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nametxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_nametxtKeyTyped

    private void mfdateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mfdateKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_mfdateKeyTyped

    private void expdateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_expdateKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_expdateKeyTyped

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
            java.util.logging.Logger.getLogger(printbarcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(printbarcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(printbarcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(printbarcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                printbarcode dialog = new printbarcode(new javax.swing.JFrame(), true , "1001");
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
    private javax.swing.JTextField expdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField mfdate;
    private javax.swing.JTextField nametxt;
    private javax.swing.JTextField pidtxt;
    private javax.swing.JTextField pricetxt;
    private javax.swing.JTextField qtytxt;
    private javax.swing.JPanel reportpanel;
    private javax.swing.JButton saveandprintbtn;
    // End of variables declaration//GEN-END:variables

    private void generatecodes() {
        jButton1.setEnabled(false);
        saveandprintbtn.setEnabled(false);
        jButton1.setText("Generating ...");
        getData2();
    
    }
}
