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
package com.eaero.flights.views;

import com.eaero.clients.views.ClientView;
import com.eaero.flights.Aircraft;
import com.eaero.flights.Flight;
import com.eaero.flights.FlightRoutine;
import com.eaero.flights.Itinerary;
import com.eaero.flights.models.AircraftDAO;
import com.eaero.flights.models.FlightDAO;
import com.eaero.flights.models.FlightRoutineDAO;
import com.eaero.flights.models.ItineraryDAO;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FlightManagerView extends javax.swing.JFrame 
{    
    public ItineraryDAO itinerarioDAO = new ItineraryDAO();
    public Itinerary itinerary = new Itinerary();
    
    public Aircraft aircraft = new Aircraft();
    public AircraftDAO aircraftDAO = new AircraftDAO();
    
    public FlightRoutine routine = new FlightRoutine();
    public FlightRoutineDAO routineDAO = new FlightRoutineDAO();
    
    public Flight flight = new Flight();
    public FlightDAO flightDAO = new FlightDAO();

    public FlightManagerView() throws SQLException 
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
        
        vooSelRotina.removeAllItems();
        
        for(FlightRoutine r : this.routineDAO.read())
        {
            vooSelRotina.addItem(r);
        }
        
        vooSelItinerario.removeAllItems();
        
        for(Itinerary i : this.itinerarioDAO.read())
        {
            vooSelItinerario.addItem(i);
        }
        
        vooSelAviao.removeAllItems();
        
        for(Aircraft a : this.aircraftDAO.read())
        {
            vooSelAviao.addItem(a);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
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
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        aviTxtAssentos = new javax.swing.JTextField();
        aviTxtAssentosPrimeira = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        aviBtnAcao = new javax.swing.JButton();
        aviTxtCodigo = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        vooBtnCadastrar = new javax.swing.JButton();
        vooTxtHora = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        vooTxtPreco = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        vooSelRotina = new javax.swing.JComboBox();
        vooSelItinerario = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        vooSelAviao = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(65, 65, 65));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/eaero/views/images/logo-small.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Gerenciador de Voos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Gerenciar Itinerários"), "Gerenciar Itinerários"));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                .addGap(0, 93, Short.MAX_VALUE))
                            .addComponent(itiTxtDuracao))))
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
                .addComponent(Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Gerenciar Aviões"));

        jLabel9.setText("Assentos na Primeira Classe");

        jLabel8.setText("Assentos");

        jLabel5.setText("Código");

        aviBtnAcao.setText("Cadastrar");
        aviBtnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aviBtnAcaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aviTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aviTxtAssentos, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(aviTxtAssentosPrimeira, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aviBtnAcao, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(aviBtnAcao, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(aviTxtAssentosPrimeira)
                    .addComponent(aviTxtAssentos)
                    .addComponent(aviTxtCodigo))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Gerenciar Voos"));

        jLabel10.setText("Hora");

        vooBtnCadastrar.setText("Cadastrar");
        vooBtnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vooBtnCadastrarActionPerformed(evt);
            }
        });

        jLabel11.setText("Preço");

        jLabel12.setText("Rotina de Voo");

        vooSelRotina.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        vooSelItinerario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setText("Itinerário");

        vooSelAviao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setText("Avião");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vooSelItinerario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vooTxtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(vooTxtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(vooSelRotina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(0, 593, Short.MAX_VALUE))
                    .addComponent(vooSelAviao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vooBtnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vooTxtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vooTxtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vooSelRotina, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vooSelItinerario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vooSelAviao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(vooBtnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vooBtnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vooBtnCadastrarActionPerformed
        FlightRoutine fr = (FlightRoutine) vooSelRotina.getSelectedItem();
        Aircraft ar = (Aircraft) vooSelAviao.getSelectedItem();
        Itinerary it = (Itinerary) vooSelItinerario.getSelectedItem();

        this.flight.setAircraftId(ar.getId());
        this.flight.setItineraryId(it.getId());
        this.flight.setRoutineId(fr.getId());
        this.flight.setCost(Double.parseDouble(vooTxtPreco.getText()));
        this.flight.setHour(Time.valueOf(vooTxtHora.getText()));
        
        try 
        {
            this.flightDAO.create(this.flight);
            JOptionPane.showMessageDialog(null, "Voo Cadastrado", "Gerenciar Voos", JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(FlightManagerView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_vooBtnCadastrarActionPerformed

    private void CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarActionPerformed
        try 
        {
            this.itinerary = this.itinerarioDAO.findByCode(itiTxtCodigo.getText());
            
            if(this.itinerary != null)
            {
                System.out.println("Itinerario já existe");
                JOptionPane.showMessageDialog(null, "Já Existe esse Itinerário", "Gerenciar Itinerários", JOptionPane.INFORMATION_MESSAGE);
                
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
                
                this.itinerarioDAO.create(novoItinerario);
                
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

    private void aviBtnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aviBtnAcaoActionPerformed
        try 
        {
            this.aircraft = this.aircraftDAO.findByCode(aviTxtCodigo.getText());
           
            if(this.aircraft != null)
            {
                System.out.println("Itinerario já existe");
                JOptionPane.showMessageDialog(null, "Já Existe esse Avião", "Gerenciar Aviões", JOptionPane.INFORMATION_MESSAGE);

                aviTxtAssentos.setText(String.valueOf(this.aircraft.getSeats()));
                aviTxtAssentosPrimeira.setText(String.valueOf(this.aircraft.getSeatsFirstClass()));
            }
            else 
            {
                Aircraft novoAviao = new Aircraft();
                novoAviao.setCode(aviTxtCodigo.getText());
                novoAviao.setCompanyId(1);
                novoAviao.setSeats(Integer.parseInt(aviTxtAssentos.getText()));
                novoAviao.setSeatsFirstClass(Integer.parseInt(aviTxtAssentosPrimeira.getText()));
        
                this.aircraftDAO.create(novoAviao);
                JOptionPane.showMessageDialog(null, "Avião Cadastrado", "Gerenciar Aviões", JOptionPane.INFORMATION_MESSAGE);
            
                aviTxtCodigo.setText(null);
                aviTxtAssentos.setText(null);
                aviTxtAssentosPrimeira.setText(null);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(FlightManagerView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_aviBtnAcaoActionPerformed

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new FlightManagerView().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(FlightManagerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cadastrar;
    private javax.swing.JButton aviBtnAcao;
    private javax.swing.JTextField aviTxtAssentos;
    private javax.swing.JTextField aviTxtAssentosPrimeira;
    private javax.swing.JTextField aviTxtCodigo;
    private javax.swing.JTextField itiTxtCodigo;
    private javax.swing.JTextField itiTxtDestino;
    private javax.swing.JTextField itiTxtDuracao;
    private javax.swing.JTextField itiTxtOrigem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton vooBtnCadastrar;
    private javax.swing.JComboBox vooSelAviao;
    private javax.swing.JComboBox vooSelItinerario;
    private javax.swing.JComboBox vooSelRotina;
    private javax.swing.JTextField vooTxtHora;
    private javax.swing.JTextField vooTxtPreco;
    // End of variables declaration//GEN-END:variables
}
