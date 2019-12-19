package medicine.ui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import medicine.dao.ExpenseHeadDao;
import medicine.model.ExpenseHead;
import medicine.model.User;

public final class ExpenseHeadUI extends javax.swing.JInternalFrame {

    private final User user;
    private ExpenseHead expenseHead;
    private ExpenseHeadDao headDao;

    public ExpenseHeadUI(User user) {
        initComponents();
        this.user = user;
        clearForm();
        enableButtons();

        cbSearch.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() != 38 && e.getKeyCode() != 40 && e.getKeyCode() != 10) {
                    String a = cbSearch.getEditor().getItem().toString();
                    String formatedString = a.toUpperCase();
                    cbSearch.removeAllItems();
                    cbSearch.addItem(null);

                    int st = 0;

                    if (formatedString.length() >= 3) {
                        ExpenseHeadDao headDao = new ExpenseHeadDao();
                        for (ExpenseHead hh : headDao.getMatch(formatedString)) {
                            cbSearch.addItem(hh);
                            st++;
                        }
                    }

                    cbSearch.getEditor().setItem(a);
                    cbSearch.hidePopup();
                    if (st != 0) {
                        cbSearch.showPopup();
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
        tfHeadName.setText("");
        cbDisplay.setSelectedIndex(0);
        cbSearch.removeAllItems();
        cbSearch.setSelectedItem(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbSearch = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfHeadName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbDisplay = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("EXPENSE HEAD");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbSearch.setEditable(true);
        cbSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbSearch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Head Name");

        tfHeadName.setText("jTextField1");
        tfHeadName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHeadNameActionPerformed(evt);
            }
        });

        jLabel2.setText("Display");

        cbDisplay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Show", "Hide" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfHeadName)
                    .addComponent(cbDisplay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfHeadName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
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
            if (tfHeadName.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Insert Expense Head ???");
                tfHeadName.requestFocus();
            } else {
                expenseHead = new ExpenseHead();
                expenseHead.setHeadName(tfHeadName.getText().trim());
                if (cbDisplay.getSelectedIndex() == 1) {
                    expenseHead.setDisplay(0);
                } else {
                    expenseHead.setDisplay(1);
                }
                expenseHead.setUser(user);

                headDao = new ExpenseHeadDao();
                headDao.save(expenseHead);

                clearForm();
                enableButtons();
                JOptionPane.showMessageDialog(this, "Successfully Saved.");
            }
        } catch (Exception e) {
            System.out.println("Error..." + e);
            JOptionPane.showMessageDialog(this, "Error !!!");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tfHeadNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHeadNameActionPerformed

        try {

        } catch (Exception e) {
        }
    }//GEN-LAST:event_tfHeadNameActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int check = JOptionPane.showConfirmDialog(this, "Are you sure ???");
        if (check == 0) {
            try {
                headDao = new ExpenseHeadDao();
                headDao.delete(expenseHead);
                clearForm();
                enableButtons();
                JOptionPane.showMessageDialog(this, "Delete successfully.");
            } catch (Exception e) {
                System.out.println("Error..." + e);
                System.out.println("Error !!!");
            }
        }


    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        try {
            if (tfHeadName.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Insert Expense Head ???");
                tfHeadName.requestFocus();
            } else {
                expenseHead.setHeadName(tfHeadName.getText().trim());
                if (cbDisplay.getSelectedIndex() == 1) {
                    expenseHead.setDisplay(0);
                } else {
                    expenseHead.setDisplay(1);
                }
                expenseHead.setUser(user);

                headDao = new ExpenseHeadDao();
                headDao.update(expenseHead);

                clearForm();
                enableButtons();
                JOptionPane.showMessageDialog(this, "Successfully Updated.");
            }
        } catch (Exception e) {
            System.out.println("Error..." + e);
            JOptionPane.showMessageDialog(this, "Error !!!");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

        clearForm();
        enableButtons();
    }//GEN-LAST:event_btnClearActionPerformed

    private void cbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSearchActionPerformed

        try {
            expenseHead = (ExpenseHead) cbSearch.getSelectedItem();
            if (expenseHead != null) {
                tfHeadName.setText(expenseHead.getHeadName());
                if (expenseHead.getDisplay() == 1) {
                    cbDisplay.setSelectedIndex(0);
                } else {
                    cbDisplay.setSelectedIndex(1);
                }
                disableButtons();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbDisplay;
    private javax.swing.JComboBox cbSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField tfHeadName;
    // End of variables declaration//GEN-END:variables
}
