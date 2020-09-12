/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Viewer;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Ashan Lakshitha
 */
public class Exec_backup{
    
    public void backuping(Exec_Upload eu){
        try {
            Runtime r = Runtime.getRuntime();
            
            Date d = new Date();
            String sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
            
            String path = "D:\\Backup\\POS - "+sd+".sql";
            String path2 = "G:\\POS - "+sd+".sql";
            
            String sql1 = "C:/Program Files (x86)/MySQL/MySQL Server 5.6/bin/mysqldump -uroot -p12345 --add-drop-database -B pos -r " + "\"" + path + " ";
            Process s = r.exec(sql1);
            
            String sql2 = "C:/Program Files (x86)/MySQL/MySQL Server 5.6/bin/mysqldump -uroot -p12345 --add-drop-database -B pos -r " + "\"" + path2 + " ";
            Process s2 = r.exec(sql2);
            
            JOptionPane.showMessageDialog(null,"Database.sql File has been saved successfully" );
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
}
