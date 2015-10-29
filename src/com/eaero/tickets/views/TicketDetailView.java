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

package com.eaero.tickets.views;

import com.eaero.ApplicationWindow;
import com.eaero.clients.views.ClientView;
import com.eaero.tickets.TicketResume;
import com.eaero.tickets.models.NoteDAO;
import com.eaero.tickets.models.TicketDAO;
import com.eaero.tickets.models.TicketResumeDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicketDetailView extends ApplicationWindow 
{
    private TicketResumeDAO ticketResumeDAO = new TicketResumeDAO();
    private TicketDAO ticketDAO = new TicketDAO();
    private NoteDAO noteDAO = new NoteDAO();
    
    private TicketResume resume = new TicketResume();
    
    private int id;
    
    public TicketDetailView(String code) throws SQLException 
    {
        super("Detalhes da Passagem");

        initComponents();
        
        this.resume = this.ticketResumeDAO.getResume(code);
        this.id = resume.getId();
        
        txtClientName.setText(this.resume.getLastName() + ", " + resume.getFirstName());
        txtBoardingDate.setText(this.resume.getDate());
        txtBoardingTime.setText(this.resume.getHour().toString());
        txtCompanyName.setText(this.resume.getCompany().toUpperCase());
        txtFlightCode.setText(this.resume.getTicketCode().toUpperCase());
        txtItineraryDeparture.setText(this.resume.getDeparture());
        txtItineraryDestination.setText(this.resume.getDestination());
        txtCode.setText(String.valueOf(this.resume.getId()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtFlightCode = new javax.swing.JLabel();
        txtBoardingTime = new javax.swing.JLabel();
        txtBoardingDate = new javax.swing.JLabel();
        txtClientName = new javax.swing.JLabel();
        txtItineraryDeparture = new javax.swing.JLabel();
        txtItineraryDestination = new javax.swing.JLabel();
        txtCode = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnCheckin = new javax.swing.JButton();
        btnNotes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(65, 65, 65));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/eaero/views/images/logo-small.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Detalhe da Passagem");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel6)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(39, 39, 39))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 221));

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel2.setText("* O EMBARQUE ENCERRA 15 MINUTOS");

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel3.setText("SEQUENCE NO: ");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/eaero/views/images/UPC-barcode.png"))); // NOI18N

        txtCompanyName.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        txtCompanyName.setText("AEROLITO");

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel5.setText("VOO /");
        jLabel5.setAlignmentY(0.0F);

        jLabel8.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel8.setText("NOME/ NAME:");

        jLabel9.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel9.setText("EMBARQUE /");
        jLabel9.setAlignmentY(0.0F);

        jLabel10.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel10.setText("BOARDING TIME :");

        jLabel11.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel11.setText("DATA /");
        jLabel11.setAlignmentY(0.0F);

        jLabel12.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel12.setText("DATE :");

        jLabel13.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel13.setText("FLIGHT NO:");

        jLabel14.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel14.setText("PARA/ TO:");

        jLabel15.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel15.setText("DE/ FROM:");

        txtFlightCode.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        txtFlightCode.setText("000000");

        txtBoardingTime.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        txtBoardingTime.setText("00:00:00");

        txtBoardingDate.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        txtBoardingDate.setText("0000-00-00");

        txtClientName.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txtClientName.setText("Nome do Cliente");

        txtItineraryDeparture.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txtItineraryDeparture.setText("Nome do Local de Origem");

        txtItineraryDestination.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txtItineraryDestination.setText("Nome do Local de Destino");

        txtCode.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtCode.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtClientName))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(txtItineraryDestination))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(txtItineraryDeparture))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel13)
                                    .addComponent(txtFlightCode))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtBoardingTime)
                                        .addGap(28, 28, 28)
                                        .addComponent(txtBoardingDate))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10))
                                        .addGap(46, 46, 46)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12))))))
                        .addContainerGap(76, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtCompanyName)
                        .addGap(0, 452, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCode)
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtCompanyName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel12))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel10))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFlightCode)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtBoardingTime)
                                .addComponent(txtBoardingDate)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtClientName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtItineraryDeparture))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtItineraryDestination)))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtCode))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnCancel.setText("Cancelar Passagem");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnCheckin.setText("Check-In & Imprimir Passagem");
        btnCheckin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckinActionPerformed(evt);
            }
        });

        btnNotes.setText("Cadastrar Observações");
        btnNotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNotes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckinActionPerformed
        JOptionPane.showMessageDialog(null, "Quem sabe na próxima versão?", "Check-In", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnCheckinActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Você quer apagar a passagem ?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0)
        {
            try 
            {
                this.ticketDAO.delete(this.ticketDAO.findById(this.id));
                
                JOptionPane.showMessageDialog(null, "A passagem foi apagada", "Passagem", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);   
            } 
            catch (SQLException ex) {
                Logger.getLogger(ClientView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnNotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotesActionPerformed
        NotesMainView nmv = new NotesMainView(this.resume.getId());
        nmv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nmv.setVisible(true);
    }//GEN-LAST:event_btnNotesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCheckin;
    private javax.swing.JButton btnNotes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel txtBoardingDate;
    private javax.swing.JLabel txtBoardingTime;
    private javax.swing.JLabel txtClientName;
    private javax.swing.JLabel txtCode;
    private javax.swing.JLabel txtCompanyName;
    private javax.swing.JLabel txtFlightCode;
    private javax.swing.JLabel txtItineraryDeparture;
    private javax.swing.JLabel txtItineraryDestination;
    // End of variables declaration//GEN-END:variables
}
