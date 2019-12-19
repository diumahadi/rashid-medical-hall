package medicine.ui;

import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import medicine.dao.CompanyDao;
import medicine.model.Company;
import medicine.model.User;

public final class CompanyForm extends javax.swing.JInternalFrame {

    private Company company;
    private final User user;

    public CompanyForm(User user) {
        initComponents();
        this.user = user;
        enableButtons();
        clearForm();

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
                        CompanyDao companyDao = new CompanyDao();
                        for (Company com : companyDao.getMatch(formatedString)) {
                            cbSearch.addItem(com);
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
        tfAddress.setText("");
        tfCompanyName.setText("");
        tfEmail.setText("");
        tfMobile.setText("");
        tfWebUrl.setText("");
        cbSearch.setSelectedIndex(-1);
        cbDisplay.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbSearch = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfCompanyName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfMobile = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfWebUrl = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfAddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbDisplay = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setClosable(true);
        setTitle("COMPANY");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbSearch.setEditable(true);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Company Name");

        tfCompanyName.setText("jTextField1");

        jLabel2.setText("Email");

        tfEmail.setText("jTextField2");

        jLabel3.setText("Mobile");

        tfMobile.setText("jTextField3");

        jLabel4.setText("Website");

        tfWebUrl.setText("jTextField4");

        jLabel5.setText("Address");

        tfAddress.setText("jTextField5");

        jLabel6.setText("Display");

        cbDisplay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Show", "Hide" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCompanyName)
                    .addComponent(tfEmail)
                    .addComponent(tfMobile)
                    .addComponent(tfWebUrl)
                    .addComponent(tfAddress)
                    .addComponent(cbDisplay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfWebUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
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

        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
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
                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btn_clear)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate))
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

        String companyName = tfCompanyName.getText();
        try {
            company = new Company();
            company.setAddress(tfAddress.getText());
            company.setCompanyName(companyName.toUpperCase());
            if (cbDisplay.getSelectedIndex() == 0) {
                company.setDisplay(1);
            } else {
                company.setDisplay(0);
            }
            company.setEmail(tfEmail.getText());
            company.setLogo(null);
            company.setMobile(tfMobile.getText());
            company.setUser(user);
            company.setWebUrl(tfWebUrl.getText());

            CompanyDao companyDao = new CompanyDao();
            companyDao.save(company);

            clearForm();
            enableButtons();
            JOptionPane.showMessageDialog(this, "Record Saved Successfully.");

        } catch (HeadlessException e) {
            System.out.println("Error.." + e);
            JOptionPane.showMessageDialog(this, "Error...");
        }


    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        String companyName = tfCompanyName.getText();
        try {
            company.setAddress(tfAddress.getText());
            company.setCompanyName(companyName.toUpperCase());
            if (cbDisplay.getSelectedIndex() == 0) {
                company.setDisplay(1);
            } else {
                company.setDisplay(0);
            }
            company.setEmail(tfEmail.getText());
            company.setLogo(null);
            company.setMobile(tfMobile.getText());
            company.setUser(user);
            company.setWebUrl(tfWebUrl.getText());

            CompanyDao companyDao = new CompanyDao();
            companyDao.update(company);

            clearForm();
            enableButtons();
            JOptionPane.showMessageDialog(this, "Record Updated Successfully.");

        } catch (HeadlessException e) {
            System.out.println("Error.." + e);
            JOptionPane.showMessageDialog(this, "Error...");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void cbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSearchActionPerformed

        try {
            company = (Company) cbSearch.getSelectedItem();
            if (company != null) {
                tfAddress.setText(company.getAddress());
                tfCompanyName.setText(company.getCompanyName());
                tfEmail.setText(company.getEmail());
                tfMobile.setText(company.getMobile());
                tfWebUrl.setText(company.getWebUrl());
                if (company.getDisplay() == 1) {
                    cbDisplay.setSelectedIndex(0);
                } else {
                    cbDisplay.setSelectedIndex(1);
                }
                disableButtons();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbSearchActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed

        clearForm();
        enableButtons();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int check = JOptionPane.showConfirmDialog(this, "Are you sure ???");
        if (check == 0) {
            CompanyDao companyDao = new CompanyDao();
            if (companyDao.delete(company)) {
                clearForm();
                enableButtons();
                JOptionPane.showMessageDialog(this, "Deleted Successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Cannot Delete !!!");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btn_clear;
    private javax.swing.JComboBox cbDisplay;
    private javax.swing.JComboBox cbSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfCompanyName;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfMobile;
    private javax.swing.JTextField tfWebUrl;
    // End of variables declaration//GEN-END:variables

}
