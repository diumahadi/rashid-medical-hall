package medicine.ui;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import medicine.dao.ClientDao;
import medicine.dao.CommonDao;
import medicine.dao.MedicineDao;
import medicine.dao.MedicineStockDao;
import medicine.dao.PSTitleDao;
import medicine.dao.PurchaseDao;
import medicine.dao.UnitDao;
import medicine.model.Client;
import medicine.model.Medicine;
import medicine.model.PSTitle;
import medicine.model.PurchaseDetails;
import medicine.model.PurchaseMaster;
import medicine.model.Unit;
import medicine.model.User;

public final class PurchaseForm extends javax.swing.JInternalFrame {

    private final User user;
    private PurchaseMaster master;
    private PurchaseDetails details;
    private PurchaseDao masterDao;
    private double grandTotal = 0;

    private LinkedList<Medicine> tempList;
    private List<PurchaseDetails> tempDetails;

    public PurchaseForm(User user) {
        initComponents();
        this.user = user;
        loadUnits();
        loadTitle();
        enableButtons();
        clearForm();
        purchaseTable.setShowGrid(true);

        cbRepresentative.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() != 38 && e.getKeyCode() != 40 && e.getKeyCode() != 10) {
                    String a = cbRepresentative.getEditor().getItem().toString();
                    String formatedString = a.toUpperCase();
                    cbRepresentative.removeAllItems();
                    cbRepresentative.addItem(null);

                    int st = 0;

                    if (formatedString.length() >= 3) {
                        ClientDao clientDao = new ClientDao();
                        for (Client c : clientDao.getMatch(formatedString, (rbRepresentative.isSelected()) ? 3 : 2)) {
                            cbRepresentative.addItem(c);
                            st++;
                        }
                    } 

                    cbRepresentative.getEditor().setItem(a);
                    cbRepresentative.hidePopup();
                    if (st != 0) {
                        cbRepresentative.showPopup();
                    }
                }
            }
        });

        cbMedicine.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() != 38 && e.getKeyCode() != 40 && e.getKeyCode() != 10) {
                    String a = cbMedicine.getEditor().getItem().toString();
                    String formatedString = a.toUpperCase();
                    cbMedicine.removeAllItems();
                    cbMedicine.addItem(null);

                    int st = 0;

                    if (formatedString.length() >= 3) {
                        MedicineDao medicineDao = new MedicineDao();
                        for (Medicine m : medicineDao.getMatch(formatedString)) {
                            cbMedicine.addItem(m);
                            st++;
                        }
                    } else {
                        tfQuantity.setText("");
                        tfPercent.setText("");
                        tfUnitPurchase.setText("");
                        tfUnitSales.setText("");
                    }

                    cbMedicine.getEditor().setItem(a);
                    cbMedicine.hidePopup();
                    if (st != 0) {
                        cbMedicine.showPopup();
                    }
                }
            }
        });
    }

    public void loadTitle() {
        PSTitleDao titleDao = new PSTitleDao();
        cbPsType.removeAllItems();
        for (PSTitle t : titleDao.display()) {
            cbPsType.addItem(t);
        }
    }

    public void loadUnits() {
        UnitDao unitDao = new UnitDao();
        cbUnit.removeAllItems();
        for (Unit u : unitDao.display()) {
            cbUnit.addItem(u);
        }
    }

    public void loadMedicines() {
        MedicineStockDao medicineStockDao = new MedicineStockDao();
        cbMedicine.removeAllItems();
        for (Medicine m : medicineStockDao.display()) {
            cbMedicine.addItem(m);
        }
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
        tempList = new LinkedList<>();
        tempDetails = new ArrayList<>();
        PSTitleDao titleDao = new PSTitleDao();
        cbPsType.setSelectedItem(titleDao.find("1"));
        tfInvoiceNo.setText("");
        tfAdvancedPayment.setText("");
        tfDueAmount.setText("");
        tfQuantity.setText("");
        tfSearch.setText("");
        tfTotalAmount.setText("");
        tfUnitPurchase.setText("");
        tfUnitSales.setText("");
        tfPercent.setText("");
        cbMedicine.setSelectedIndex(-1);
        cbRepresentative.setSelectedIndex(-1);
        cbUnit.setSelectedIndex(-1);
        chExpiracy.setDate(new Date());
        chPurchase.setDate(new Date());
        DefaultTableModel model = (DefaultTableModel) purchaseTable.getModel();
        model.setRowCount(0);
        grandTotal = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        rbStore = new javax.swing.JRadioButton();
        rbRepresentative = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbRepresentative = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cbPsType = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        chPurchase = new com.toedter.calendar.JDateChooser();
        tfInvoiceNo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbMedicine = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cbUnit = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        tfQuantity = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        chExpiracy = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        tfUnitPurchase = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfUnitSales = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tfPercent = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        tfTotalAmount = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfAdvancedPayment = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfDueAmount = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        purchaseTable = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("PURCHASE");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("PURCHASE ID");

        tfSearch.setText("jTextField1");

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbStore);
        rbStore.setText("Store");
        rbStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbStoreActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbRepresentative);
        rbRepresentative.setSelected(true);
        rbRepresentative.setText("Representative");
        rbRepresentative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbRepresentativeActionPerformed(evt);
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
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbRepresentative)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbStore)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind)
                    .addComponent(rbStore)
                    .addComponent(rbRepresentative))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Rep.");

        cbRepresentative.setEditable(true);

        jLabel3.setText("PS Type");

        cbPsType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Date");

        tfInvoiceNo.setText("jTextField1");

        jLabel17.setText("Invoice No");

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
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbRepresentative, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbPsType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chPurchase, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addComponent(tfInvoiceNo))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfInvoiceNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbRepresentative, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbPsType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chPurchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Medicine");

        cbMedicine.setEditable(true);
        cbMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMedicineActionPerformed(evt);
            }
        });

        jLabel6.setText("Unit");

        cbUnit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Quantity");

        tfQuantity.setText("jTextField2");

        jLabel8.setText("Expiracy");

        jLabel9.setText("Unit Purchase");

        tfUnitPurchase.setText("jTextField3");

        jLabel10.setText("Unit Sales");

        tfUnitSales.setText("jTextField4");

        jLabel16.setText("Percent");

        tfPercent.setText("jTextField1");
        tfPercent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPercentActionPerformed(evt);
            }
        });
        tfPercent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPercentKeyReleased(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicine/icon/math-add-icon-16px.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicine/icon/math-minus-icon-16px.png"))); // NOI18N
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbMedicine, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(cbUnit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfQuantity)
                                    .addComponent(tfUnitPurchase, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel8))
                                .addGap(5, 5, 5)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                            .addComponent(tfPercent)
                            .addComponent(tfUnitSales, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(chExpiracy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbMedicine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(cbUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(chExpiracy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(tfPercent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfUnitPurchase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(tfUnitSales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addComponent(btnRemove)
                    .addComponent(btnEdit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setText("Total Amount");

        tfTotalAmount.setEditable(false);
        tfTotalAmount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tfTotalAmount.setText("jTextField5");

        jLabel12.setText("Advanced Payment");

        tfAdvancedPayment.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tfAdvancedPayment.setText("jTextField6");
        tfAdvancedPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAdvancedPaymentActionPerformed(evt);
            }
        });
        tfAdvancedPayment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfAdvancedPaymentKeyReleased(evt);
            }
        });

        jLabel13.setText("Due Amount");

        tfDueAmount.setEditable(false);
        tfDueAmount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tfDueAmount.setText("jTextField7");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

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

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfTotalAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(tfDueAmount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAdvancedPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(tfTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(tfAdvancedPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(tfDueAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnSave)
                                    .addComponent(btnUpdate))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnDelete)
                                    .addComponent(btnClear))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        purchaseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine", "Unit", "Quantity", "Purchase", "Sales", "Expiracy"
            }
        ));
        purchaseTable.setRowHeight(22);
        purchaseTable.setRowMargin(2);
        jScrollPane1.setViewportView(purchaseTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        String quantity = tfQuantity.getText();
        String purchasePrice = tfUnitPurchase.getText();
        String salesPrice = tfUnitSales.getText();

        if (quantity.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert Quantity ???");
        } else if (cbMedicine.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Select Medicine ???");
        } else if (purchasePrice.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert Unit Purchase Price ???");
        } else if (salesPrice.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert Unit Sales Price ???");
        } else if (Double.parseDouble(purchasePrice) > Double.parseDouble(salesPrice)) {
            JOptionPane.showMessageDialog(this, "Verify Purchase and Sales Price ???");
        } else {
            Medicine medicine = (Medicine) cbMedicine.getSelectedItem();
            if (!tempList.contains(medicine)) {
                try {
                    Unit unit = (Unit) cbUnit.getSelectedItem();
                    int quan = Integer.parseInt(quantity);
                    double pPrice = Double.parseDouble(purchasePrice);
                    double sPrice = Double.parseDouble(salesPrice);
                    String exDate = new SimpleDateFormat("dd-MM-yyyy").format(chExpiracy.getDate());
                    DefaultTableModel model = (DefaultTableModel) purchaseTable.getModel();
                    model.addRow(new Object[]{medicine, unit, quan, pPrice, sPrice, exDate});
                    tempList.add(medicine);
                    grandTotal = grandTotal + (quan * pPrice);
                    tfTotalAmount.setText("" + CommonDao.getTwoDecimal(grandTotal));
                    tfQuantity.setText("");
                    tfUnitPurchase.setText("");
                    tfUnitSales.setText("");
                    cbMedicine.setSelectedItem(null);
                    chExpiracy.setDate(new Date());
                    cbMedicine.requestFocus();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Insert Valid Number !!!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Already Exists !!!");
            }
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        DefaultTableModel model = (DefaultTableModel) purchaseTable.getModel();
        String advancedPayment = tfAdvancedPayment.getText();
        int itemsTaken = model.getRowCount();

        if (CommonDao.getNumberOfRecords("purchase_master") >= 1000) {
            JOptionPane.showMessageDialog(this, "Trial Period Expired !!!\nNow you have to purchase.");
            return;
        }

        if (itemsTaken <= 0) {
            JOptionPane.showMessageDialog(this, "No Medicine Selected ???");
        } else if (cbPsType.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Select PS Type ???");
        } else if (advancedPayment.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert Advanced Payment ???");
        } else {
            try {
                master = new PurchaseMaster();
                master.setInvoiceNo(tfInvoiceNo.getText());
                master.setClient((Client) cbRepresentative.getSelectedItem());

                master.setDueAmount(Double.parseDouble(tfDueAmount.getText()));
                master.setPaidAmount(Double.parseDouble(advancedPayment));
                master.setPurchaseDate(chPurchase.getDate());
                master.setUser(user);
                master.setpSTitle((PSTitle) cbPsType.getSelectedItem());

                for (int i = 0; i < itemsTaken; i++) {
                    Medicine medicine = (Medicine) model.getValueAt(i, 0);
                    Unit unit = null;
                    Unit unit_check = (Unit) model.getValueAt(i, 1);
                    if (unit_check != null) {
                        unit = (Unit) model.getValueAt(i, 1);
                    }

                    int quantity = Integer.parseInt(model.getValueAt(i, 2).toString());
                    double pPrice = Double.parseDouble(model.getValueAt(i, 3).toString());
                    double sPrice = Double.parseDouble(model.getValueAt(i, 4).toString());
                    String string = model.getValueAt(i, 5).toString();

                    DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                    Date exDate = format.parse(string);

                    details = new PurchaseDetails();
                    details.setExpiracyDate(exDate);
                    details.setMedicine(medicine);
                    details.setPurchasePrice(pPrice);
                    details.setQuantity(quantity);
                    details.setSalesPrice(sPrice);
                    details.setUnit(unit);
                    tempDetails.add(details);
                }

                master.setDetails(tempDetails);
                masterDao = new PurchaseDao();
                masterDao.save(master);

                clearForm();
                enableButtons();
                JOptionPane.showMessageDialog(this, "Record saved successfully.");

            } catch (NumberFormatException | ParseException e) {
                System.out.println("Error..." + e);
                JOptionPane.showMessageDialog(this, "Error...");
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tfAdvancedPaymentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAdvancedPaymentKeyReleased

        try {
            Double totalAmount = Double.parseDouble(tfTotalAmount.getText());
            Double paidAmount = Double.parseDouble(tfAdvancedPayment.getText());

            double dueAmount = totalAmount - paidAmount;
            if (paidAmount > totalAmount) {
                tfAdvancedPayment.setBackground(Color.red);
                tfDueAmount.setText("" + 0);
            } else {
                tfDueAmount.setText("" + CommonDao.getTwoDecimal(dueAmount));
                tfAdvancedPayment.setBackground(Color.WHITE);
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_tfAdvancedPaymentKeyReleased

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed

        DefaultTableModel model = (DefaultTableModel) purchaseTable.getModel();
        String invoiceNo = tfSearch.getText();
        if (invoiceNo.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert purchase no ???");
        } else {
            try {
                masterDao = new PurchaseDao();
                master = masterDao.find(invoiceNo);
                if (master.getPurchaseId() != 0) {
                    clearForm();
                    grandTotal = 0;
                    tfInvoiceNo.setText(master.getInvoiceNo());
                    tfAdvancedPayment.setText("" + master.getPaidAmount());
                    tfDueAmount.setText("" + CommonDao.getTwoDecimal(master.getDueAmount()));
                    chPurchase.setDate(master.getPurchaseDate());
                    cbPsType.getModel().setSelectedItem((PSTitle) master.getpSTitle());
                    cbRepresentative.getModel().setSelectedItem((Client) master.getClient());

                    for (PurchaseDetails det : master.getDetails()) {
                        String exDate = new SimpleDateFormat("dd-MM-yyyy").format(det.getExpiracyDate());
                        model.addRow(new Object[]{det.getMedicine(), det.getUnit(), det.getQuantity(), det.getPurchasePrice(), det.getSalesPrice(), exDate});
                        grandTotal = grandTotal + (det.getQuantity() * det.getPurchasePrice());
                        tfTotalAmount.setText("" + CommonDao.getTwoDecimal(grandTotal));
                        tempList.add(det.getMedicine());
                    }

                    disableButtons();
                } else {
                    JOptionPane.showMessageDialog(this, "No Such Record Found !!!");
                    clearForm();
                }
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Insert Valid Number !!!");
            }
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int check = JOptionPane.showConfirmDialog(this, "Are you sure ???");
        if (check == 0) {
            masterDao = new PurchaseDao();
            if (masterDao.delete(master)) {
                JOptionPane.showMessageDialog(this, "Deleted Successfully.");
                enableButtons();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Cannot Delete !!!");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void cbMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMedicineActionPerformed

        try {
            Medicine medicine = (Medicine) cbMedicine.getSelectedItem();
            tfUnitPurchase.setText("" + medicine.getUnitPurchase());
            tfUnitSales.setText("" + medicine.getUnitSales());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbMedicineActionPerformed

    private void tfPercentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPercentKeyReleased

        try {
            float percent = Float.parseFloat(tfPercent.getText());
            float mrpPrice = Float.parseFloat(tfUnitSales.getText());
            tfUnitPurchase.setText("" + CommonDao.getPercentage(percent, mrpPrice));
        } catch (NumberFormatException e) {
            System.out.println("Error..." + e);
        }

    }//GEN-LAST:event_tfPercentKeyReleased

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

        clearForm();
        enableButtons();
    }//GEN-LAST:event_btnClearActionPerformed

    private void tfPercentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPercentActionPerformed

        btnAdd.doClick();
    }//GEN-LAST:event_tfPercentActionPerformed

    private void tfAdvancedPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAdvancedPaymentActionPerformed

        btnSave.doClick();
    }//GEN-LAST:event_tfAdvancedPaymentActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        DefaultTableModel model = (DefaultTableModel) purchaseTable.getModel();
        String advancedPayment = tfAdvancedPayment.getText();
        int itemsTaken = model.getRowCount();

        if (itemsTaken <= 0) {
            JOptionPane.showMessageDialog(this, "No Medicine Selected ???");
        } else if (cbPsType.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Select PS Type ???");
        } else if (advancedPayment.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert Advanced Payment ???");
        } else {
            try {
                master.setInvoiceNo(tfInvoiceNo.getText());
                master.setClient((Client) cbRepresentative.getSelectedItem());

                master.setDueAmount(Double.parseDouble(tfDueAmount.getText()));
                master.setPaidAmount(Double.parseDouble(advancedPayment));
                master.setPurchaseDate(chPurchase.getDate());
                master.setUser(user);
                master.setpSTitle((PSTitle) cbPsType.getSelectedItem());

                for (int i = 0; i < itemsTaken; i++) {
                    Medicine medicine = (Medicine) model.getValueAt(i, 0);
                    Unit unit = null;
                    Unit unit_check = (Unit) model.getValueAt(i, 1);
                    if (unit_check != null) {
                        unit = (Unit) model.getValueAt(i, 1);
                    }

                    int quantity = Integer.parseInt(model.getValueAt(i, 2).toString());
                    double pPrice = Double.parseDouble(model.getValueAt(i, 3).toString());
                    double sPrice = Double.parseDouble(model.getValueAt(i, 4).toString());
                    String string = model.getValueAt(i, 5).toString();

                    DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                    Date exDate = format.parse(string);

                    details = new PurchaseDetails();
                    details.setExpiracyDate(exDate);
                    details.setMedicine(medicine);
                    details.setPurchasePrice(pPrice);
                    details.setQuantity(quantity);
                    details.setSalesPrice(sPrice);
                    details.setUnit(unit);
                    tempDetails.add(details);
                }
                master.setDetails(tempDetails);
                masterDao = new PurchaseDao();
                masterDao.update(master);

                clearForm();
                enableButtons();
                JOptionPane.showMessageDialog(this, "Record Updated successfully.");

            } catch (NumberFormatException | ParseException e) {
                System.out.println("Error..." + e);
                JOptionPane.showMessageDialog(this, "Error...");
            }
        }


    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed

        DefaultTableModel model = (DefaultTableModel) purchaseTable.getModel();
        int row = purchaseTable.getSelectedRow();
        Medicine medicine = (Medicine) model.getValueAt(row, 0);
        int qty = Integer.parseInt(model.getValueAt(row, 2).toString());
        double price = Double.parseDouble(model.getValueAt(row, 3).toString());
        grandTotal = grandTotal - (qty * price);
        tempList.remove(medicine);
        tfTotalAmount.setText("" + CommonDao.getTwoDecimal(grandTotal));
        model.removeRow(row);
        tfDueAmount.setText("");
        tfAdvancedPayment.setText("");
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        DefaultTableModel model = (DefaultTableModel) purchaseTable.getModel();
        int row = purchaseTable.getSelectedRow();
        Medicine medicine = (Medicine) model.getValueAt(row, 0);
        int qty = Integer.parseInt(model.getValueAt(row, 2).toString());
        double price = Double.parseDouble(model.getValueAt(row, 3).toString());
        grandTotal = grandTotal - (qty * price);

        Unit u = (Unit) model.getValueAt(row, 1);
        cbUnit.setSelectedItem(u);
        tfQuantity.setText("" + qty);
        tfUnitPurchase.setText("" + Double.parseDouble(model.getValueAt(row, 3).toString()));
        tfUnitSales.setText("" + Double.parseDouble(model.getValueAt(row, 4).toString()));

        tempList.remove(medicine);
        tfTotalAmount.setText("" + CommonDao.getTwoDecimal(grandTotal));
        model.removeRow(row);
        tfDueAmount.setText("");
        tfAdvancedPayment.setText("");
    }//GEN-LAST:event_btnEditActionPerformed

    private void rbRepresentativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbRepresentativeActionPerformed
        jLabel2.setText("Rep.");
    }//GEN-LAST:event_rbRepresentativeActionPerformed

    private void rbStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbStoreActionPerformed
        jLabel2.setText("Store");

    }//GEN-LAST:event_rbStoreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cbMedicine;
    private javax.swing.JComboBox cbPsType;
    private javax.swing.JComboBox cbRepresentative;
    private javax.swing.JComboBox cbUnit;
    private com.toedter.calendar.JDateChooser chExpiracy;
    private com.toedter.calendar.JDateChooser chPurchase;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable purchaseTable;
    private javax.swing.JRadioButton rbRepresentative;
    private javax.swing.JRadioButton rbStore;
    private javax.swing.JTextField tfAdvancedPayment;
    private javax.swing.JTextField tfDueAmount;
    private javax.swing.JTextField tfInvoiceNo;
    private javax.swing.JTextField tfPercent;
    private javax.swing.JTextField tfQuantity;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfTotalAmount;
    private javax.swing.JTextField tfUnitPurchase;
    private javax.swing.JTextField tfUnitSales;
    // End of variables declaration//GEN-END:variables
}
