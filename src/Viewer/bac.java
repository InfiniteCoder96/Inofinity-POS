/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author Ashan Lakshitha
 */
public class bac {
    
    
    public static void main(String[] args) {
        
        
            String name = "Dialog 100            ";

            DecimalFormatSymbols symbols = new DecimalFormatSymbols();

            symbols.setGroupingSeparator(' ');
            DecimalFormat format = new DecimalFormat("###.00", symbols);

            System.out.println((name)+"");
            System.out.print(String.format("%" + 6 + "s", format.format(95.3)));
            System.out.print(String.format("%" + 5 + "s", 100));
            System.out.print(String.format("%" + 9 + "s", format.format(9530)) );
        
        
    }
    
}
