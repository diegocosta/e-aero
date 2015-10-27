/*
 * The MIT License
 *
 * Copyright 2015 Diego.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.eaero.views;

import com.eaero.clients.views.ClientView;
import com.eaero.flights.views.FlightMainView;
import com.eaero.flights.views.FlightManagerView;
import com.eaero.tickets.views.TicketMainView;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainView extends javax.swing.JFrame {

    public MainView() 
    {
        try 
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) 
        {
            Logger.getLogger(ClientView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnClientLauncher = new javax.swing.JButton();
        btnFlightLauncher = new javax.swing.JButton();
        btnTicketLauncher = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnFlightManagerLauncher = new javax.swing.JButton();
        btnPaymentsLauncher = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(65, 65, 65));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/eaero/views/images/logo-small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel6)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        btnClientLauncher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/eaero/views/images/1445961180_group2.png"))); // NOI18N
        btnClientLauncher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientLauncherActionPerformed(evt);
            }
        });

        btnFlightLauncher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/eaero/views/images/1445961398_aiga_departingflights.png"))); // NOI18N
        btnFlightLauncher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlightLauncherActionPerformed(evt);
            }
        });

        btnTicketLauncher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/eaero/views/images/1445961674_ticket.png"))); // NOI18N
        btnTicketLauncher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTicketLauncherActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Pagamentos");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Voos");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Passagens");

        btnFlightManagerLauncher.setText("Gerenciar Voos");
        btnFlightManagerLauncher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlightManagerLauncherActionPerformed(evt);
            }
        });

        btnPaymentsLauncher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/eaero/views/images/1445962145_wallet.png"))); // NOI18N
        btnPaymentsLauncher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentsLauncherActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Clientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(186, 186, 186)
                .addComponent(jLabel3)
                .addGap(104, 104, 104))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFlightManagerLauncher, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnClientLauncher)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                .addComponent(btnFlightLauncher)
                                .addGap(79, 79, 79)
                                .addComponent(btnTicketLauncher))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPaymentsLauncher, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(107, 107, 107)
                    .addComponent(jLabel4)
                    .addContainerGap(584, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnFlightLauncher)
                            .addComponent(btnClientLauncher))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnTicketLauncher)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addGap(35, 35, 35)
                .addComponent(btnPaymentsLauncher, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFlightManagerLauncher, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(301, 301, 301)
                    .addComponent(jLabel4)
                    .addContainerGap(308, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClientLauncherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientLauncherActionPerformed
        ClientView cv = new ClientView();
        cv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cv.setVisible(true);
    }//GEN-LAST:event_btnClientLauncherActionPerformed

    private void btnFlightLauncherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlightLauncherActionPerformed
        FlightMainView cv = new FlightMainView();
        cv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cv.setVisible(true);
    }//GEN-LAST:event_btnFlightLauncherActionPerformed

    private void btnTicketLauncherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTicketLauncherActionPerformed
        TicketMainView cv = new TicketMainView();
        cv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cv.setVisible(true);
    }//GEN-LAST:event_btnTicketLauncherActionPerformed

    private void btnFlightManagerLauncherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlightManagerLauncherActionPerformed

        try 
        {
            
            FlightManagerView cv = new FlightManagerView();
            cv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            cv.setVisible(true);
        } 
        catch (SQLException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnFlightManagerLauncherActionPerformed

    private void btnPaymentsLauncherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentsLauncherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPaymentsLauncherActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new MainView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClientLauncher;
    private javax.swing.JButton btnFlightLauncher;
    private javax.swing.JButton btnFlightManagerLauncher;
    private javax.swing.JButton btnPaymentsLauncher;
    private javax.swing.JButton btnTicketLauncher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
