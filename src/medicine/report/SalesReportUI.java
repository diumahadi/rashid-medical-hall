package medicine.report;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import medicine.dao.ClientDao;
import medicine.dao.SalesDao;
import medicine.model.Client;
import medicine.model.SalesMaster;
import medicine.util.ReportUtil;

public final class SalesReportUI extends javax.swing.JInternalFrame {

    private ReportUtil reportViewer;

    public SalesReportUI() {
        initComponents();
        loadClientList();
        cbCustomer.setSelectedIndex(-1);
        chEndDate.setDate(new Date());
    }

    public void loadClientList() {
        ClientDao clientDao = new ClientDao();
        cbCustomer.removeAllItems();
        for (Client c : clientDao.display()) {
            if (c.getClientType() != 3) {
                cbCustomer.addItem(c);
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfSalesId = new javax.swing.JTextField();
        btnFindBySalesId = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        chSalesDate = new com.toedter.calendar.JDateChooser();
        btnFindDate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        chStartDate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        chEndDate = new com.toedter.calendar.JDateChooser();
        btnFindBetweenDates = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbCustomer = new javax.swing.JComboBox();
        btnFindCustomerSales = new javax.swing.JButton();
        desktopPane = new javax.swing.JDesktopPane();

        setClosable(true);
        setTitle("SALES REPORT");
        setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Sales ID");

        btnFindBySalesId.setText("Find Sales");
        btnFindBySalesId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindBySalesIdActionPerformed(evt);
            }
        });

        jLabel2.setText("Sales Date");

        btnFindDate.setText("Find Sales");
        btnFindDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindDateActionPerformed(evt);
            }
        });

        jLabel3.setText("From Date");

        jLabel4.setText("To Date");

        btnFindBetweenDates.setText("Find Sales");
        btnFindBetweenDates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindBetweenDatesActionPerformed(evt);
            }
        });

        jLabel5.setText("Customer");

        cbCustomer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnFindCustomerSales.setText("Find Sales");
        btnFindCustomerSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindCustomerSalesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfSalesId)
                    .addComponent(chSalesDate, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFindBySalesId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFindDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbCustomer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFindBetweenDates, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addComponent(btnFindCustomerSales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFindBetweenDates)
                    .addComponent(chEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfSalesId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFindBySalesId)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnFindDate)
                                .addComponent(jLabel5)
                                .addComponent(cbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnFindCustomerSales))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chSalesDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chStartDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(desktopPane))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktopPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindBySalesIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindBySalesIdActionPerformed

        String salesId = tfSalesId.getText();

        
        if (!salesId.trim().equals("")) {
            SalesDao salesDao = new SalesDao();
            SalesMaster master = salesDao.find(salesId);

            if (master.getCreatedAt() != null) {
                showSalesReport(salesId);
            } else {
                JOptionPane.showMessageDialog(this, "No such record found !!!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Insert sales number ???");
        }

    }//GEN-LAST:event_btnFindBySalesIdActionPerformed

    private void btnFindBetweenDatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindBetweenDatesActionPerformed

        if (chStartDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Select Start Date ???");
            return;
        }

        JInternalFrame frame = new JInternalFrame();
        DefaultTableModel dtm = new DefaultTableModel(new String[]{"", "", "", "", "", ""}, 0);
        JTable dataTable = new JTable();

        dataTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    long salesID = (long) table.getValueAt(row, 1);
                    showSalesReport(String.valueOf(salesID));
                }
            }
        });

        dataTable.setRowHeight(22);

        dtm.addRow(new Object[]{
            "SN", "SALES ID", "CUSTOMER", "PAID AMOUNT", "DUE AMOUNT", "DATE"
        });

        SalesDao salesDao = new SalesDao();
        int i = 1;
        for (SalesMaster mas : salesDao.display()) {
            Date date = mas.getSalesDate();
            Date startDate = chStartDate.getDate();
            Date endDate = chEndDate.getDate();
            if (date.getTime() >= startDate.getTime() && date.getTime() <= endDate.getTime()) {
                dtm.addRow(new Object[]{
                    i,
                    mas.getSalesId(),
                    mas.getClient().getFirstName(),
                    mas.getPaidAmount(),
                    mas.getDueAmount(),
                    mas.getSalesDate()
                });
                i++;
            }
        }

        dataTable.setModel(dtm);
        dataTable.setShowGrid(true);
        JScrollPane scrollPane = new JScrollPane(dataTable);

        frame.add(scrollPane);
        frame.setTitle("SALES LIST");
        frame.setVisible(true);
        frame.setClosable(true);
        frame.setSize(desktopPane.getWidth(), desktopPane.getHeight());
        desktopPane.add(frame);
        try {
            frame.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(SalesReportUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnFindBetweenDatesActionPerformed

    private void btnFindDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindDateActionPerformed

        if (chSalesDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Select Sales Date ???");
            return;
        }

        JInternalFrame frame = new JInternalFrame();
        DefaultTableModel dtm = new DefaultTableModel(new String[]{"", "", "", "", "", ""}, 0);
        JTable dataTable = new JTable();

        dataTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    long salesID = (long) table.getValueAt(row, 1);
                    showSalesReport(String.valueOf(salesID));
                }
            }
        });

        dataTable.setRowHeight(22);

        dtm.addRow(new Object[]{
            "SN", "SALES ID", "CUSTOMER", "PAID AMOUNT", "DUE AMOUNT", "DATE"
        });

        SalesDao salesDao = new SalesDao();
        int i = 1;
        for (SalesMaster mas : salesDao.display()) {
            
            java.util.Date utilDate = mas.getSalesDate();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            java.util.Date utilDate2 = chSalesDate.getDate();
            java.sql.Date sqlDate2 = new java.sql.Date(utilDate2.getTime());
            
            if (sqlDate.toString().equals(sqlDate2.toString())) {
                dtm.addRow(new Object[]{
                    i,
                    mas.getSalesId(),
                    mas.getClient().getFirstName(),
                    mas.getPaidAmount(),
                    mas.getDueAmount(),
                    mas.getSalesDate()
                });
                i++;
            }
        }

        dataTable.setModel(dtm);
        dataTable.setShowGrid(true);
        JScrollPane scrollPane = new JScrollPane(dataTable);

        frame.add(scrollPane);
        frame.setTitle("SALES LIST");
        frame.setVisible(true);
        frame.setClosable(true);
        frame.setSize(desktopPane.getWidth(), desktopPane.getHeight());
        desktopPane.add(frame);
        try {
            frame.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(SalesReportUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFindDateActionPerformed

    private void btnFindCustomerSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindCustomerSalesActionPerformed

        Client client = null;
        if (cbCustomer.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Select Customer ???");
            return;
        } else {
            client = (Client) cbCustomer.getSelectedItem();
        }

        JInternalFrame frame = new JInternalFrame();
        DefaultTableModel dtm = new DefaultTableModel(new String[]{"", "", "", "", "", ""}, 0);
        JTable dataTable = new JTable();

        dataTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    long salesID = (long) table.getValueAt(row, 1);
                    showSalesReport(String.valueOf(salesID));
                }
            }
        });

        dataTable.setRowHeight(22);

        dtm.addRow(new Object[]{
            "SN", "SALES ID", "CUSTOMER", "PAID AMOUNT", "DUE AMOUNT", "DATE"
        });

        SalesDao salesDao = new SalesDao();
        int i = 1;
        for (SalesMaster mas : salesDao.display()) {
            if (mas.getClient()!=null && client.getClientId() == mas.getClient().getClientId()) {
                dtm.addRow(new Object[]{
                    i,
                    mas.getSalesId(),
                    mas.getClient().getFirstName(),
                    mas.getPaidAmount(),
                    mas.getDueAmount(),
                    mas.getSalesDate()
                });
                i++;
            }
        }

        dataTable.setModel(dtm);
        dataTable.setShowGrid(true);
        JScrollPane scrollPane = new JScrollPane(dataTable);

        frame.add(scrollPane);
        frame.setTitle("SALES LIST");
        frame.setVisible(true);
        frame.setClosable(true);
        frame.setSize(desktopPane.getWidth(), desktopPane.getHeight());
        desktopPane.add(frame);
        try {
            frame.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(SalesReportUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFindCustomerSalesActionPerformed

    public void showSalesReport(String salesId) {
        
        desktopPane.removeAll();
        HashMap hashMap = new HashMap();
        SalesDao salesDao = new SalesDao();
        SalesMaster master = salesDao.find(salesId);

        DecimalFormat df = new DecimalFormat("00000000000");
        String salesIdFormat = df.format(Long.parseLong(salesId));
        hashMap.put("FORMATTED_ID", "SLS".concat(salesIdFormat));
        hashMap.put("SALES_ID", Long.parseLong(salesId));
        hashMap.put("CUSTOMER_NAME", master.getClient().getFirstName());
        hashMap.put("SALES_DATE", master.getSalesDate());
        hashMap.put("PAID_AMOUNT", master.getPaidAmount());
        hashMap.put("DUE_AMOUNT", master.getDueAmount());
        reportViewer = new ReportUtil("reports/PARTICULAR_SALES_VOUCHER.jasper", hashMap);
        reportViewer.setSize(desktopPane.getWidth(), desktopPane.getHeight());
        desktopPane.removeAll();
        desktopPane.add(reportViewer);
        try {
            reportViewer.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(SalesReportUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFindBetweenDates;
    private javax.swing.JButton btnFindBySalesId;
    private javax.swing.JButton btnFindCustomerSales;
    private javax.swing.JButton btnFindDate;
    private javax.swing.JComboBox cbCustomer;
    private com.toedter.calendar.JDateChooser chEndDate;
    private com.toedter.calendar.JDateChooser chSalesDate;
    private com.toedter.calendar.JDateChooser chStartDate;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfSalesId;
    // End of variables declaration//GEN-END:variables
}
