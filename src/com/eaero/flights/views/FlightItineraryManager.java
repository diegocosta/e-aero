/*
 * The MIT License
 *
 * Copyright 2015 Jeferson
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

package com.eaero.flights.views;


import com.eaero.ApplicationWindow;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.eaero.flights.Itinerary;
import com.eaero.flights.models.ItineraryDAO;
import javax.swing.JOptionPane;


public class FlightItineraryManager extends ApplicationWindow 
{
    public Itinerary itinerary =  new Itinerary();
    public ItineraryDAO itineraryDao = new ItineraryDAO();
    
    public FlightItineraryManager() {
        super("Itinerários");
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel13 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        itiTxtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        itiTxtOrigem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        itiTxtDestino = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        itiTxtDuracao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Cadastrar = new javax.swing.JButton();
        Apagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel13.setBackground(new java.awt.Color(65, 65, 65));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/eaero/views/images/logo-small.png"))); // NOI18N

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Gerenciar Itinerario");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addGap(20, 20, 20))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel30)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addGap(39, 39, 39))
        );

        jPanel14.setBackground(new java.awt.Color(239, 239, 239));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Gerenciar Itinerários"), "Gerenciar Itinerários"));

        itiTxtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itiTxtCodigoActionPerformed(evt);
            }
        });

        jLabel1.setText("Código");

        jLabel2.setText("Origem");

        jLabel3.setText("Destino");

        jLabel4.setText("Duração");

        Cadastrar.setText("Cadastrar");
        Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarActionPerformed(evt);
            }
        });

        Apagar.setText("Apagar");
        Apagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApagarActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itiTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itiTxtOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itiTxtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 229, Short.MAX_VALUE))
                            .addComponent(itiTxtDuracao)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Apagar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(itiTxtDuracao, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(itiTxtDestino)
                    .addComponent(itiTxtOrigem)
                    .addComponent(itiTxtCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Apagar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(132, 132, 132))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarActionPerformed
        try
        {
            this.itinerary = this.itineraryDao.findByCode(itiTxtCodigo.getText());

            if(this.itinerary != null)
            {
                System.out.println("Itinerario já existe");
                JOptionPane.showMessageDialog(null, "Já Existe esse Itinerário","", JOptionPane.INFORMATION_MESSAGE);

                itiTxtOrigem.setText(this.itinerary.getDeparture());
                itiTxtDestino.setText(this.itinerary.getDestination());
                itiTxtDuracao.setText(this.itinerary.getDuration().toString());
            }
            else
            {
                System.out.println("Itinerario não encontrado");

                Itinerary novoItinerario = new Itinerary();
                novoItinerario.setCode(itiTxtCodigo.getText());
                novoItinerario.setDeparture(itiTxtOrigem.getText());
                novoItinerario.setDestination(itiTxtDestino.getText());
                novoItinerario.setDuration(Double.parseDouble(itiTxtDuracao.getText()));

                this.itineraryDao.create(novoItinerario);

                JOptionPane.showMessageDialog(null, "Itinerário Cadastrado", "Gerenciar Itinerários", JOptionPane.INFORMATION_MESSAGE);

                itiTxtCodigo.setText("");
                itiTxtDestino.setText("");
                itiTxtOrigem.setText("");
                itiTxtDuracao.setText("");
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(FlightManagerView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CadastrarActionPerformed

    private void ApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApagarActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Você quer apagar o itinerario  ?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0)
        {
            try 
            {
                this.itineraryDao.delete(this.itineraryDao.findByCode(this.itiTxtCodigo.getText()));
            } 
            catch (SQLException ex) {
                Logger.getLogger(FlightItineraryManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            JOptionPane.showMessageDialog(null, "O itinerario foi apagada", "Itinerario", JOptionPane.INFORMATION_MESSAGE);
            
        }  
    }//GEN-LAST:event_ApagarActionPerformed

    private void itiTxtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itiTxtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itiTxtCodigoActionPerformed

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlightItineraryManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Apagar;
    private javax.swing.JButton Cadastrar;
    private javax.swing.JTextField itiTxtCodigo;
    private javax.swing.JTextField itiTxtDestino;
    private javax.swing.JTextField itiTxtDuracao;
    private javax.swing.JTextField itiTxtOrigem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    // End of variables declaration//GEN-END:variables
}
