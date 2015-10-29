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
package com.eaero.payments.views;

import com.eaero.ApplicationWindow;
import com.eaero.payments.PaymentResume;
import com.eaero.payments.PaymentStatus;
import com.eaero.payments.models.PaymentResumeDAO;
import com.eaero.payments.models.PaymentStatusDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class PaymentMainView extends ApplicationWindow 
{
    public PaymentStatusDAO paymentStatusDAO = new PaymentStatusDAO();
    public PaymentResumeDAO paymentResumeDAO = new PaymentResumeDAO();
    
    public PaymentMainView() {
        super("Pagamentos");
        initComponents();
        initComboBoxStatuses();
        initResultTable();
        showResultTable();
    }
    
    public void initComboBoxStatuses()
    {
        comboboxStatuses.removeAllItems();
        
        try 
        {
            for(PaymentStatus status : this.paymentStatusDAO.read())
            {
                comboboxStatuses.addItem(status);
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(PaymentMainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void initResultTable()
    {
        tblResult.setAutoscrolls(true);
        tblResult.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[]{  "ID", "Cliente", "Passagem", "Origem", "Destino", "Data", "Hora", "Status" }
            ){
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false; 
                }

        });
        
        tblResult.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mousePressed(MouseEvent me) 
            {
                if (me.getClickCount() == 2) 
                {
                    int selectedRow = tblResult.getSelectedRow();
                    selectedRow = tblResult.convertRowIndexToModel(selectedRow);
                    int codigo = Integer.parseInt(tblResult.getModel().getValueAt(selectedRow, 0).toString());
                    String status = tblResult.getModel().getValueAt(selectedRow, 7).toString();
                    
                    try 
                    {
                        PaymentStatusDAO paymentStatusDAO = new PaymentStatusDAO();
                        PaymentResumeDAO paymentResumeDAO = new PaymentResumeDAO();
                                
                        int newStatus = (paymentStatusDAO.getIdByLabel(status) == 1) ? 2 : 1;
                        
                        paymentResumeDAO.changeStatusById(codigo, newStatus);
                        
                        showResultTable();
                    
                    } 
                    catch (SQLException ex) 
                    {
                        Logger.getLogger(PaymentMainView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        });
    }
    
    public void showResultTable()
    {
        DefaultTableModel tabela = (DefaultTableModel) tblResult.getModel();
        PaymentStatus status = (PaymentStatus) comboboxStatuses.getSelectedItem();
            
        while(tabela.getRowCount() > 0){
            tabela.removeRow(0);
        }
        
        try 
        {
            ArrayList<PaymentResume> resultado = this.paymentResumeDAO.getResume(status.getId());
            
            resultado.stream().forEach((item) -> {
                tabela.addRow(new Object[]{
                   item.getId(), item.getClientFirstName() + " " + item.getClientLastName(), item.getTicketNumber(), item.getDeparture(), item.getDestination(), item.getFlightDate(), item.getFlightHour(), item.getStatusName()
                });
            });
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(PaymentMainView.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        comboboxStatuses = new javax.swing.JComboBox();
        btnFilter = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(65, 65, 65));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/eaero/views/images/logo-small.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Pagamentos");

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por Pagamentos"));

        comboboxStatuses.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnFilter.setText("Filtrar");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        jLabel3.setText("Status do Pagamento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comboboxStatuses, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFilter, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboboxStatuses)
                    .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblResult);

        jLabel4.setText("Dê duplo clique para alterar o status do pagamento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        showResultTable();
    }//GEN-LAST:event_btnFilterActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new PaymentMainView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilter;
    private javax.swing.JComboBox comboboxStatuses;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResult;
    // End of variables declaration//GEN-END:variables
}
