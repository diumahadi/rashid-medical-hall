package medicine.ui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JOptionPane;
import medicine.dao.ExpenseDao;
import medicine.dao.ExpenseHeadDao;
import medicine.model.Expense;
import medicine.model.ExpenseHead;
import medicine.model.User;

public final class ExpenseUI extends javax.swing.JInternalFrame {

    private final User user;
    private Expense expense;
    private ExpenseDao expenseDao;

    public ExpenseUI(User user) {
        initComponents();
        this.user = user;
        clearForm();
        enableButtons();

        cbHead.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() != 38 && e.getKeyCode() != 40 && e.getKeyCode() != 10) {
                    String a = cbHead.getEditor().getItem().toString();
                    String formatedString = a.toUpperCase();
                    cbHead.removeAllItems();
                    cbHead.addItem(null);

                    int st = 0;

                    if (formatedString.length() >= 3) {
                        ExpenseHeadDao headDao = new ExpenseHeadDao();
                        for (ExpenseHead hh : headDao.getMatch(formatedString)) {
                            cbHead.addItem(hh);
                            st++;
                        }
                    }

                    cbHead.getEditor().setItem(a);
                    cbHead.hidePopup();
                    if (st != 0) {
                        cbHead.showPopup();
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
        tfExpAmount.setText("");
        tfSearch.setText("");
        cbHead.setSelectedItem(null);
        cbStatus.setSelectedIndex(0);
        chExpenseDate.setDate(new Date());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbHead = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        tfExpAmount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        chExpenseDate = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("EXPENSE");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("EXPENSE NO");

        tfSearch.setText("jTextField1");

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
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Head");

        cbHead.setEditable(true);

        jLabel3.setText("Exp. Amount");

        tfExpAmount.setText("jTextField2");

        jLabel4.setText("Exp. Date");

        jLabel5.setText("Status");

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "Cancel" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbHead, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfExpAmount)
                    .addComponent(chExpenseDate, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(cbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfExpAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chExpenseDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        try {
            if (cbHead.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Select Expense Head ???");
                cbHead.requestFocus();
            } else if (tfExpAmount.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Insert Expense Amount ???");
                tfExpAmount.requestFocus();
            } else {
                try {
                    expense = new Expense();
                    expense.setAmount(Double.parseDouble(tfExpAmount.getText()));
                    expense.setExpenseDate(chExpenseDate.getDate());
                    expense.setExpenseHead((ExpenseHead) cbHead.getSelectedItem());
                    String status = cbStatus.getSelectedItem().toString();
                    if (status.trim().equalsIgnoreCase("Cancel")) {
                        status = "C";
                    } else {
                        status = "A";
                    }
                    expense.setStatus(status);
                    expense.setUser(user);
                    expenseDao = new ExpenseDao();
                    expenseDao.save(expense);

                    clearForm();
                    enableButtons();
                    JOptionPane.showMessageDialog(this, "Successfully Saved.");
                } catch (NumberFormatException ex) {
                    System.out.println("Error..." + ex);
                    JOptionPane.showMessageDialog(this, "Insert valid number !!!");
                } catch (Exception e) {
                    System.out.println("Error..." + e);
                    JOptionPane.showMessageDialog(this, "Error !!!");
                }
            }

        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        if (!tfSearch.getText().trim().equals("")) {
            expenseDao = new ExpenseDao();
            expense = expenseDao.find(tfSearch.getText());

            if (expense.getExpenseId() != 0) {
                tfExpAmount.setText("" + expense.getAmount());
                cbHead.getModel().setSelectedItem(expense.getExpenseHead());
                if (expense.getStatus().equals("C")) {
                    cbStatus.setSelectedItem(1);
                }else{
                    cbStatus.setSelectedItem(0);
                }
                chExpenseDate.setDate(expense.getExpenseDate());
                disableButtons();
            }else{
                clearForm();
                JOptionPane.showMessageDialog(this, "No Such Record Found !!!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Insert Expense ID !!!");
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        try {
            if (cbHead.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Select Expense Head ???");
                cbHead.requestFocus();
            } else if (tfExpAmount.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Insert Expense Amount ???");
                tfExpAmount.requestFocus();
            } else {
                try {
                    expense.setAmount(Double.parseDouble(tfExpAmount.getText()));
                    expense.setExpenseDate(chExpenseDate.getDate());
                    expense.setExpenseHead((ExpenseHead) cbHead.getSelectedItem());
                    String status = cbStatus.getSelectedItem().toString();
                    if (status.trim().equalsIgnoreCase("Cancel")) {
                        status = "C";
                    } else {
                        status = "A";
                    }
                    expense.setStatus(status);
                    expense.setUser(user);
                    expenseDao = new ExpenseDao();
                    expenseDao.update(expense);

                    clearForm();
                    enableButtons();
                    JOptionPane.showMessageDialog(this, "Successfully Updated.");
                } catch (NumberFormatException ex) {
                    System.out.println("Error..." + ex);
                    JOptionPane.showMessageDialog(this, "Insert valid number !!!");
                } catch (Exception e) {
                    System.out.println("Error..." + e);
                    JOptionPane.showMessageDialog(this, "Error !!!");
                }

            }

        } catch (Exception e) {
            System.out.println("Error..."+e);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int check = JOptionPane.showConfirmDialog(this, "Are you sure ???");
        if (check == 0) {
            expenseDao = new ExpenseDao();
            if (expenseDao.delete(expense)) {
                JOptionPane.showMessageDialog(this, "Deleted Successfully.");
                enableButtons();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Cannot Delete !!!");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbHead;
    private javax.swing.JComboBox cbStatus;
    private com.toedter.calendar.JDateChooser chExpenseDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField tfExpAmount;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
