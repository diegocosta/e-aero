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

import com.eaero.clients.Client;
import com.eaero.clients.models.ClientDAO;
import com.eaero.clients.views.ClientView;
import com.eaero.flights.FlightResume;
import com.eaero.flights.models.FlightResumeDAO;
import com.eaero.tickets.Payment;
import com.eaero.tickets.PaymentMethod;
import com.eaero.tickets.Ticket;
import com.eaero.tickets.TicketType;
import com.eaero.tickets.models.PaymentMethodDAO;
import com.eaero.tickets.models.TicketDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FlightDetailView extends javax.swing.JFrame {
    
    private int flightCode;
    private int seats;
    private int seatsFirstClass;
    
    private Client client = new Client();
    private FlightResume resume = new FlightResume();
    
    private ClientDAO clientDAO = new ClientDAO();
    private FlightResumeDAO flightResumeDAO = new FlightResumeDAO();
    private TicketDAO ticketDAO = new TicketDAO();
    
    public FlightDetailView(int flightCode) throws SQLException 
    {
        this.changeSwingToSystemLookAndFeel();
        
        initComponents();
        
        this.flightCode = flightCode;
        this.resume = this.flightResumeDAO.getResume(this.flightCode);
        
        this.initResumePage();
    }
    
    private void changeSwingToSystemLookAndFeel()
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FlightDetailView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void initResumePage() throws SQLException
    {
        panelDetalhesCliente.setVisible(false);
        
        this.seats = this.resume.getAircraftSeats() - this.resume.getTicketsSale();
        this.seatsFirstClass = this.resume.getAircraftSeatsFistClass() - this.resume.getTicketsSaleFirstClass();
        
        lblCompanhia.setText(this.resume.getCompanyName());
        lblDestino.setText(this.resume.getItineraryDestination());
        lblOrigem.setText(this.resume.getItineraryDeparture());
        lblHora.setText(this.resume.getFlightHour().toString());
        lblData.setText(this.resume.getFlightDate().toString());
        lblPreco.setText(this.resume.getFlightCost().toString());
        lblDia.setText(this.resume.getRoutineDays());
        lblPassagensDePrimeira.setText(String.valueOf(this.seatsFirstClass));
        lblPassagensDisponiveis.setText(String.valueOf(this.seats));
        lblPrecoPontos.setText(String.valueOf(this.resume.getCostInPoints()));
        lblPrecoPrimeiraPontos.setText(String.valueOf(this.resume.getCostInPoints(this.resume.getCostFirstClass())));
        lblPrecoPrimeira.setText(String.valueOf(this.resume.getCostFirstClass()));
    }
    
    private void initTicketType()
    {
        comboboxTicketType.removeAllItems();
        
        ArrayList<TicketType> ticketTypes = new ArrayList<>();
        
        if(this.seats > 0)
            ticketTypes.add(new TicketType("Passagem Comum", false));
        
        if(this.seatsFirstClass > 0)
            ticketTypes.add(new TicketType("Primeira Classe", true));
        
        
        ticketTypes.stream().forEach((tt) -> {
            comboboxTicketType.addItem(tt);
        });
    }
    
    private void initPaymentOptions()
    {
        comboboxPaymentOptions.removeAllItems();
        
        try 
        {
            PaymentMethodDAO paymentMethodDAO = new PaymentMethodDAO();
            ArrayList<PaymentMethod> paymentMethods = paymentMethodDAO.read();
            
            paymentMethods.stream().forEach((pm) -> {
                
                if("Pontos".equals(pm.getLabel())){
                    if(this.client.getFidelity() >= this.resume.getCostInPoints()){
                        comboboxPaymentOptions.addItem(pm);
                    }
                }
                else
                {
                    comboboxPaymentOptions.addItem(pm);
                }
            });
        } 
        catch (SQLException ex) {
            Logger.getLogger(FlightDetailView.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        lblDia = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblOrigem = new javax.swing.JLabel();
        lblDestino = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblCompanhia = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        lblPassagensDisponiveis = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblPassagensDePrimeira = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblPrecoPontos = new javax.swing.JLabel();
        lblPrecoPrimeira = new javax.swing.JLabel();
        lblPrecoPrimeiraPontos = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnContinuar = new javax.swing.JButton();
        panelDetalhesCliente = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblNomeCliente = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblDocumento = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblPontos = new javax.swing.JLabel();
        btnComprarPassagem = new javax.swing.JButton();
        comboboxTicketType = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        comboboxPaymentOptions = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(65, 65, 65));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/eaero/views/images/logo-small.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Resumo do Voo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 356, Short.MAX_VALUE)
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalhes do Voo"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Dia :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Hora :");

        lblDia.setText("jLabel4");

        lblHora.setText("jLabel4");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Origem : ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Destino :");

        lblOrigem.setText("jLabel8");

        lblDestino.setText("jLabel8");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Companhia : ");

        lblCompanhia.setText("jLabel9");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Preço"));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Passagens Disponíveis : ");

        lblPassagensDisponiveis.setText("jLabel15");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Passagens Disponíveis na Primeira Classe :");

        lblPassagensDePrimeira.setText("jLabel16");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Preço :");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Em Pontos :");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Preço :");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Em Pontos : ");

        lblPrecoPontos.setText("jLabel20");

        lblPrecoPrimeira.setText("jLabel20");

        lblPrecoPrimeiraPontos.setText("jLabel20");

        lblPreco.setText("jLabel10");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPassagensDisponiveis))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(lblPreco))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(lblPrecoPontos)))
                .addGap(50, 50, 50)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPrecoPrimeiraPontos))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(lblPrecoPrimeira))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(lblPassagensDePrimeira)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPassagensDePrimeira))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(lblPassagensDisponiveis)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18)
                    .addComponent(lblPrecoPrimeira)
                    .addComponent(lblPreco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19)
                    .addComponent(lblPrecoPontos)
                    .addComponent(lblPrecoPrimeiraPontos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Data :");

        lblData.setText("jLabel21");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDia))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblHora)))
                .addGap(126, 126, 126)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblOrigem))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDestino)))
                .addGap(133, 133, 133)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCompanhia))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblData)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblDia)
                    .addComponent(jLabel4)
                    .addComponent(lblOrigem)
                    .addComponent(jLabel8)
                    .addComponent(lblCompanhia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblHora)
                    .addComponent(jLabel5)
                    .addComponent(lblDestino)
                    .addComponent(jLabel1)
                    .addComponent(lblData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Comprar Passagens"));

        jLabel10.setText("Informe um e-mail válido");

        txtEmail.setText("diego@diegocosta.com.br");

        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        panelDetalhesCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalhes"));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Nome : ");

        lblNomeCliente.setText("jLabel12");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Documento :");

        lblDocumento.setText("jLabel13");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Pontos Disponíveis : ");

        lblPontos.setText("jLabel14");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNomeCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(lblDocumento)
                .addGap(79, 79, 79)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPontos)
                .addGap(21, 21, 21))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblNomeCliente)
                    .addComponent(jLabel12)
                    .addComponent(lblDocumento)
                    .addComponent(jLabel13)
                    .addComponent(lblPontos))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnComprarPassagem.setText("Comprar Passagem");
        btnComprarPassagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarPassagemActionPerformed(evt);
            }
        });

        comboboxTicketType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Escolha a Passagem");

        comboboxPaymentOptions.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel20.setText("Forma de Pagamento");

        javax.swing.GroupLayout panelDetalhesClienteLayout = new javax.swing.GroupLayout(panelDetalhesCliente);
        panelDetalhesCliente.setLayout(panelDetalhesClienteLayout);
        panelDetalhesClienteLayout.setHorizontalGroup(
            panelDetalhesClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetalhesClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDetalhesClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnComprarPassagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDetalhesClienteLayout.createSequentialGroup()
                        .addGroup(panelDetalhesClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboboxTicketType, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(panelDetalhesClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDetalhesClienteLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(comboboxPaymentOptions, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelDetalhesClienteLayout.setVerticalGroup(
            panelDetalhesClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetalhesClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(panelDetalhesClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(panelDetalhesClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboboxTicketType, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboboxPaymentOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnComprarPassagem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDetalhesCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnContinuar))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelDetalhesCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComprarPassagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarPassagemActionPerformed
        
        TicketType ticketType = (TicketType) comboboxTicketType.getSelectedItem();
        PaymentMethod paymentMethod = (PaymentMethod) comboboxPaymentOptions.getSelectedItem();

        Ticket newTicket = new Ticket();
        newTicket.setNumber(UUID.randomUUID().toString().substring(0, 6));
        newTicket.setFirstClass(ticketType.getFirstClass());
        newTicket.setFlightId(this.resume.getFlightId());
        newTicket.setClientId(this.client.getId());
        
        Payment newPayment = new Payment();
        newPayment.setMethodId(paymentMethod.getId());
        newPayment.setStatus(0);
        newPayment.setTicketId(seats);
        
        try 
        {
            this.ticketDAO.create(newTicket);
            
            if("Dinheiro".equals(paymentMethod.getLabel())){
                this.clientDAO.addFidelityPoints(this.client.getId(), (this.resume.getCostInPoints() / 2) );
            }
            
            
            if("Pontos".equals(paymentMethod.getLabel())){
                int cost = (ticketType.getFirstClass()) ? this.resume.getCostInPoints(this.resume.getCostFirstClass()) : this.resume.getCostInPoints();
                this.clientDAO.removeFidelityPoints(this.client.getId(), cost);
            }
            
            JOptionPane.showMessageDialog(null, "Sua Passagem foi comprada", "Passagem", JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (SQLException ex) {
            Logger.getLogger(FlightDetailView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnComprarPassagemActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        String email = txtEmail.getText();
        
        if(email.isEmpty() || !email.contains("@")){
            JOptionPane.showMessageDialog(null, "Informe um e-mail válido", "email", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try 
        {
            this.client = this.clientDAO.findByEmail(email);
            
            if(this.client == null)
            {
                System.out.println("Client não encontrado");
                JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado com esse e-mail", "Cliente", JOptionPane.ERROR_MESSAGE);
                
            }
            else 
            {
                System.out.println("Cliente encontrado: " + this.client.getFirstName());
                panelDetalhesCliente.setVisible(true);
                lblNomeCliente.setText(this.client.getFirstName() + " " + this.client.getLastName());
                lblDocumento.setText(this.client.getDocument());
                lblPontos.setText(String.valueOf(this.client.getFidelity()));
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(FlightDetailView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.initTicketType();
        this.initPaymentOptions();
    }//GEN-LAST:event_btnContinuarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprarPassagem;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JComboBox comboboxPaymentOptions;
    private javax.swing.JComboBox comboboxTicketType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblCompanhia;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDestino;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblOrigem;
    private javax.swing.JLabel lblPassagensDePrimeira;
    private javax.swing.JLabel lblPassagensDisponiveis;
    private javax.swing.JLabel lblPontos;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblPrecoPontos;
    private javax.swing.JLabel lblPrecoPrimeira;
    private javax.swing.JLabel lblPrecoPrimeiraPontos;
    private javax.swing.JPanel panelDetalhesCliente;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}
