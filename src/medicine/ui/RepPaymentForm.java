package medicine.ui;

import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JOptionPane;
import medicine.dao.ClientDao;
import medicine.dao.ClientPaymentDao;
import medicine.dao.CommonDao;
import medicine.exception.UncaughtError;
import medicine.model.Client;
import medicine.model.ClientPayment;
import medicine.model.User;

public final class RepPaymentForm extends javax.swing.JInternalFrame {
    
    private final User user;
    private ClientPayment payment;
    private ClientPaymentDao paymentDao;
    
    public RepPaymentForm(User user) {
        initComponents();
        this.user = user;
        enableButtons();
        clearForm();
        
        cbRep.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() != 38 && e.getKeyCode() != 40 && e.getKeyCode() != 10) {
                    String a = cbRep.getEditor().getItem().toString();
                    String formatedString = a.toUpperCase();
                    cbRep.removeAllItems();
                    cbRep.addItem(null);
                    
                    int st = 0;
                    
                    if (formatedString.length() >= 3) {
                        ClientDao clientDao = new ClientDao();
                        for (Client c : clientDao.getMatch(formatedString, 3)) {
                            cbRep.addItem(c);
                            st++;
                        }
                    } else {
                        tfDueAmount.setText("");
                    }
                    
                    cbRep.getEditor().setItem(a);
                    cbRep.hidePopup();
                    if (st != 0) {
                        cbRep.showPopup();
                    }
                }
            }
        });
        
    }
    
    public void enableButtons() {
        btnSave.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }
    
    public void disableButtons() {
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
    }
    
    public void clearForm() {
        tfDueAmount.setText("");
        tfPaidAmount.setText("");
        tfSearch.setText("");
        cbRep.setSelectedIndex(-1);
        chPaidDate.setDate(new Date());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbRep = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        tfDueAmount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfPaidAmount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        chPaidDate = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("REPRESENTATIVE PAYMENT");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Payment ID");

        tfSearch.setText("jTextField3");

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Representative");

        cbRep.setEditable(true);
        cbRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRepActionPerformed(evt);
            }
        });

        jLabel2.setText("Due Amount");

        tfDueAmount.setText("jTextField1");

        jLabel3.setText("Paid Amount");

        tfPaidAmount.setText("jTextField2");
        tfPaidAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPaidAmountActionPerformed(evt);
            }
        });

        jLabel4.setText("Paid Date");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbRep, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfDueAmount)
                    .addComponent(tfPaidAmount)
                    .addComponent(chPaidDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbRep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfDueAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfPaidAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chPaidDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate)
                    .addComponent(btnClear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        String paidAmount = tfPaidAmount.getText();
        
        if (paidAmount.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Paid Amount ???");
        } else if (cbRep.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Select Representative ???");
        } else if (Double.parseDouble(paidAmount) > Double.parseDouble(tfDueAmount.getText())) {
            JOptionPane.showMessageDialog(this, "Insert valid paid amount ???");
        } else {
            try {
                payment = new ClientPayment();
                payment.setClient((Client) cbRep.getSelectedItem());
                payment.setPaidAmount(Double.parseDouble(tfPaidAmount.getText()));
                payment.setPaidDate(chPaidDate.getDate());
                payment.setPaymentType("PP");
                payment.setUser(user);
                paymentDao = new ClientPaymentDao();
                paymentDao.save(payment);
                
                clearForm();
                enableButtons();
                JOptionPane.showMessageDialog(this, "Record saved successfully");
            } catch (NumberFormatException | HeadlessException e) {
                System.out.println("" + e);
                JOptionPane.showMessageDialog(this, "Insert valid number !!!");
            } catch (UncaughtError ex) {
                System.out.println("Error..." + ex);
                JOptionPane.showMessageDialog(this, "Error !!!");
            }
            
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cbRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRepActionPerformed
        
        try {
            Client c = (Client) cbRep.getSelectedItem();
            paymentDao = new ClientPaymentDao();
            double totalDue = paymentDao.getTotalPurchaseDue(c);
            double totalPaid = paymentDao.getTotalPayment(c, "PP");
            tfDueAmount.setText("" + CommonDao.getTwoDecimal(totalDue - totalPaid));
            tfPaidAmount.setText("");
            chPaidDate.setDate(new Date());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbRepActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        
        String paymentId = tfSearch.getText();
        
        if (!paymentId.trim().equals("")) {
            paymentDao = new ClientPaymentDao();
            payment = paymentDao.find(paymentId);
            if (payment.getClient() != null) {
                disableButtons();
                cbRep.getModel().setSelectedItem(payment.getClient());
                paymentDao = new ClientPaymentDao();
                double dueAmount = paymentDao.getRepTotalDueAmount(payment.getClient());
                tfDueAmount.setText("" + (dueAmount + payment.getPaidAmount()));
                tfPaidAmount.setText("" + payment.getPaidAmount());
                chPaidDate.setDate(payment.getPaidDate());
            } else {
                clearForm();
                JOptionPane.showMessageDialog(this, "No such record found !!!");
            }
        } else {
            
            JOptionPane.showMessageDialog(this, "Insert Payment Number ???");
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
        String paidAmount = tfPaidAmount.getText();
        if (paidAmount.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Paid Amount ???");
        } else if (cbRep.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Select Representative ???");
        } else if (Double.parseDouble(paidAmount) > Double.parseDouble(tfDueAmount.getText())) {
            JOptionPane.showMessageDialog(this, "Insert valid paid amount ???");
        } else {
            try {
                payment.setClient((Client) cbRep.getSelectedItem());
                payment.setPaidAmount(Double.parseDouble(tfPaidAmount.getText()));
                payment.setPaymentType("PP");
                payment.setPaidDate(chPaidDate.getDate());
                payment.setUser(user);
                
                paymentDao = new ClientPaymentDao();
                paymentDao.update(payment);
                clearForm();
                enableButtons();
                JOptionPane.showMessageDialog(this, "Record updated successfully");
                
            } catch (NumberFormatException | HeadlessException e) {
                System.out.println("" + e);
                JOptionPane.showMessageDialog(this, "Insert valid number !!!");
            } catch (UncaughtError ex) {
                System.out.println("Error..." + ex);
                JOptionPane.showMessageDialog(this, "Error !!!");
            }
            
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        
        clearForm();
        enableButtons();

    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        int check = JOptionPane.showConfirmDialog(this, "Are you sure ???");
        if (check == 0) {
            paymentDao = new ClientPaymentDao();
            if (paymentDao.delete(payment)) {
                JOptionPane.showMessageDialog(this, "Deleted Successfully.");
                enableButtons();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Cannot Delete !!!");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tfPaidAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPaidAmountActionPerformed

        btnSave.doClick();
    }//GEN-LAST:event_tfPaidAmountActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbRep;
    private com.toedter.calendar.JDateChooser chPaidDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField tfDueAmount;
    private javax.swing.JTextField tfPaidAmount;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
