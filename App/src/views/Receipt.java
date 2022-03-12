/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.awt.print.PrinterException;
import java.math.BigDecimal;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Booking;

/**
 *
 * @author USER
 */
public class Receipt extends javax.swing.JFrame {

    /**
     * Creates new form Receipt
     */
    public Receipt() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        printButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        receiptArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        printButton.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(284, 114));

        receiptArea.setEditable(false);
        receiptArea.setColumns(20);
        receiptArea.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        receiptArea.setLineWrap(true);
        receiptArea.setRows(5);
        receiptArea.setText("                                                                Receipt");
        receiptArea.setWrapStyleWord(true);
        receiptArea.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(receiptArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 585, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(receiptArea, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(printButton, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        try
        {
            boolean complete = receiptArea.print();
            if(complete)
            {
                ImageIcon successIcon = new ImageIcon("src/img/successSmall.png");
                JOptionPane.showMessageDialog(
                        null, 
                        "Printed Successfully", 
                        "Success", 
                        JOptionPane.INFORMATION_MESSAGE, 
                        successIcon
                );
            }
            else
            {
                JOptionPane.showMessageDialog(
                        null, 
                        "Print Action Terminated", 
                        "Printing Cancelled", 
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
        catch(PrinterException e)
        {
            JOptionPane.showMessageDialog(
                    null, 
                    "Some error occured", 
                    "Printing Error", 
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_printButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Receipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton printButton;
    private javax.swing.JTextArea receiptArea;
    // End of variables declaration//GEN-END:variables

    public void display(Booking record)
    {
        String pattern = "-".repeat(87);
        Receipt screen = new Receipt();
        screen.setVisible(true);
        
        screen.receiptArea.append(
                "\n\nBooking Id: #" + record.getBookingId() + 
                "\n\nCustomer Details\n" + pattern + "\n" +
                "Name:\t" + record.getCustomerName() + "\n" +
                "IC/Passport:\t" + record.getPersonalId() + "\n" +
                "Gender:\t" + record.getGender() + "\n" +
                "E-mail:\t" + record.getCustomerEmail() + "\n" +
                "\n\nBooking Details\n" + pattern + "\n" +
                "Room Id:\t\t" + record.getBookedRoom() + "\n" +
                "Dates:\t\t" + record.getStartDate() + " to " + 
                record.getEndDate() + " (" + record.getStayDays() + " days)\n" +
                "Room Charges:\t" + 
                String.format("%.2f", new BigDecimal(record.getNightPay())) + "\n" +
                "Extra Charges\t\t" + String.format("%.2f", new BigDecimal(record.getExtraCharges())) + "\n" +
                "Taxes:\t\t"+ String.format("%.2f", new BigDecimal(record.getTax())) + "\n" +
                "Total Payment:\t" + String.format("%.2f", new BigDecimal(record.getTotalPayment()))
        );
    }
}