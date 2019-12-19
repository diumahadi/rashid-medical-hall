package medicine.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import medicine.dao.SalesDao;
import medicine.dao.StockDao;
import medicine.exception.StockError;
import medicine.model.Client;
import medicine.model.Medicine;
import medicine.model.PSTitle;
import medicine.model.SalesDetails;
import medicine.model.SalesMaster;
import medicine.model.Stock;
import medicine.model.User;
import medicine.report.PrintSalesVoucherUI;

public final class SalesForm extends javax.swing.JInternalFrame {

    private final User user;
    private SalesMaster master;
    private SalesDetails details;
    private SalesDao salesDao;
    private double grandTotal = 0;

    private LinkedList<Medicine> tempList;
    private List<PSTitle> titleList = new ArrayList<>();
    private List<Medicine> medicineList = new ArrayList<>();
    private List<SalesDetails> tempDetails;

    public SalesForm(User user) {
        initComponents();
        this.user = user;
        enableButtons();
        loadTitle();
        clearForm();
        salesTable.setShowGrid(true);
        
        
        cbCustomer.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() != 38 && e.getKeyCode() != 40 && e.getKeyCode() != 10) {
                    String a = cbCustomer.getEditor().getItem().toString();
                    String formatedString = a.toUpperCase();
                    cbCustomer.removeAllItems();
                    cbCustomer.addItem(null);

                    int st = 0;

                    if (formatedString.length() >= 3) {
                        ClientDao clientDao = new ClientDao();
                        for (Client c : clientDao.getMatch(formatedString, (rbCustomer.isSelected()) ? 1 : 2)) {
                            cbCustomer.addItem(c);
                            st++;
                        }
                    } 

                    cbCustomer.getEditor().setItem(a);
                    cbCustomer.hidePopup();
                    if (st != 0) {
                        cbCustomer.showPopup();
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
                        tfStock.setText("");
                        tfQuantity.setText("");
                        tfPercentage.setText("");
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

    public void loadClientList() {
        ClientDao clientDao = new ClientDao();
        cbCustomer.removeAllItems();
        for (Client c : clientDao.display(1)) {
            cbCustomer.addItem(c);
        }
    }

    public void loadTitle() {
        PSTitleDao titleDao = new PSTitleDao();
        titleList = titleDao.display();
        cbPsType.removeAllItems();
        for (PSTitle t : titleList) {
            cbPsType.addItem(t);
        }
    }

    public void loadMedicines() {
        MedicineStockDao medicineStockDao = new MedicineStockDao();
        medicineList = medicineStockDao.display();
        cbMedicine.removeAllItems();
        for (Medicine m : medicineList) {
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
        tfAdvancedPayment.setText("");
        tfCustomerName.setText("");
        tfBarCode.setText("");
        tfDueAmount.setText("");
        tfPercentage.setText("");
        tfQuantity.setText("");
        tfSearch.setText("");
        tfStock.setText("");
        tfTotalAmount.setText("");
        tfUnitPurchase.setText("");
        tfUnitSales.setText("");
        cbMedicine.setSelectedIndex(-1);
        cbPsType.setSelectedIndex(0);
        cbCustomer.setSelectedItem(null);
        chSalesDate.setDate(new Date());
        DefaultTableModel model = (DefaultTableModel) salesTable.getModel();
        model.setRowCount(0);
        grandTotal = 0;
        ClientDao clientDao = new ClientDao();
        cbCustomer.getModel().setSelectedItem(clientDao.find("1"));
        tfAdvancedPayment.setBackground(Color.WHITE);

    }

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
        rbCustomer = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        lvCustomer = new javax.swing.JLabel();
        cbCustomer = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cbPsType = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        chSalesDate = new com.toedter.calendar.JDateChooser();
        tfCustomerName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbMedicine = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        tfQuantity = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfUnitPurchase = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfUnitSales = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tfPercentage = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfStock = new javax.swing.JTextField();
        tfBarCode = new javax.swing.JTextField();
        btnRemove = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        salesTable = new javax.swing.JTable();
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

        setClosable(true);
        setIconifiable(true);
        setTitle("SALES");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Sales ID");

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

        buttonGroup2.add(rbCustomer);
        rbCustomer.setSelected(true);
        rbCustomer.setText("Customer");
        rbCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCustomerActionPerformed(evt);
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
                .addComponent(rbCustomer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbStore)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFind))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbStore)
                        .addComponent(rbCustomer)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lvCustomer.setText("Customer");

        cbCustomer.setEditable(true);

        jLabel3.setText("New Custo.");

        cbPsType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Date");

        tfCustomerName.setText("jTextField1");

        jLabel8.setText("Title");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(lvCustomer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbCustomer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(chSalesDate, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPsType, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfCustomerName))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lvCustomer)
                    .addComponent(cbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(chSalesDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbPsType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
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

        jLabel7.setText("Quantity");

        tfQuantity.setText("jTextField2");

        jLabel9.setText("Unit Purchase");

        tfUnitPurchase.setEditable(false);
        tfUnitPurchase.setText("jTextField3");

        jLabel10.setText("Unit Sales");

        tfUnitSales.setText("jTextField4");

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicine/icon/math-add-icon-16px.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel15.setText("Bar Code");

        jLabel16.setText("Percent");

        tfPercentage.setText("jTextField1");
        tfPercentage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPercentageActionPerformed(evt);
            }
        });

        jLabel6.setText("Stock");

        tfStock.setEditable(false);
        tfStock.setText("jTextField1");

        tfBarCode.setText("jTextField1");
        tfBarCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBarCodeActionPerformed(evt);
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
                    .addComponent(jLabel6)
                    .addComponent(jLabel15)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbMedicine, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfUnitPurchase, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(tfQuantity, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfUnitSales)
                            .addComponent(tfPercentage)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(tfStock)
                    .addComponent(tfBarCode))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(tfBarCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbMedicine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(tfPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfUnitPurchase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(tfUnitSales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEdit)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        salesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine", "Quantity", "Price", "Per.%", "Total"
            }
        ));
        salesTable.setRowHeight(22);
        salesTable.setRowMargin(2);
        jScrollPane1.setViewportView(salesTable);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setText("Total Amount");

        tfTotalAmount.setEditable(false);
        tfTotalAmount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tfTotalAmount.setText("jTextField5");

        jLabel12.setText("Paid Amount");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAdvancedPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)))
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

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed

        String SALES_ID = tfSearch.getText();

        if (!SALES_ID.trim().equals("")) {
            salesDao = new SalesDao();
            master = salesDao.find(SALES_ID);
            if (master.getSalesId() != 0) {
                disableButtons();
                clearForm();
                tfAdvancedPayment.setText("" + master.getPaidAmount());
                tfDueAmount.setText("" + CommonDao.getTwoDecimal(master.getDueAmount()));
                tfSearch.setText("" + master.getSalesId());
                cbCustomer.getModel().setSelectedItem(master.getClient());
                cbPsType.getModel().setSelectedItem(master.getPsTitle());
                chSalesDate.setDate(master.getSalesDate());
                for (SalesDetails det : master.getDetails()) {
                    int quan = det.getQuantity();
                    float percent = (float) det.getPercentage();
                    float unitPrice = (float) CommonDao.getTwoDecimal(det.getSalesPrice() / det.getQuantity());
                    float sPrice = (float) det.getSalesPrice();

                    DefaultTableModel model = (DefaultTableModel) salesTable.getModel();
                    model.addRow(new Object[]{det.getMedicine(), quan, unitPrice, percent, sPrice});
                    tempList.add(det.getMedicine());
                    grandTotal = grandTotal + sPrice;
                    tfTotalAmount.setText("" + CommonDao.getTwoDecimal(grandTotal));
                }
            } else {
                JOptionPane.showMessageDialog(this, "No Such Record Found !!!");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Insert Sales ID ???");
        }

    }//GEN-LAST:event_btnFindActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        String quantity = tfQuantity.getText();
        //String purchasePrice = tfUnitPurchase.getText();
        String salesPrice = tfUnitSales.getText();

        if (quantity.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert Quantity ???");
        } else if (cbMedicine.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Select Medicine ???");
        } else if (salesPrice.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert Unit Sales Price ???");
        } else {

            if (cbMedicine.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Select Medicine ???");
            } else if (tfPercentage.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Insert Percent ???");
            } else {
                Medicine medicine = (Medicine) cbMedicine.getSelectedItem();
                if (!tempList.contains(medicine)) {
                    try {
                        int quan = Integer.parseInt(quantity);
                        double percent = Float.parseFloat(tfPercentage.getText());
                        double sPrice = Float.parseFloat(salesPrice);
                        double totalPrice = CommonDao.getTwoDecimal(quan * sPrice);
                        double currentAmount = CommonDao.getPercentage(percent, totalPrice);

                        DefaultTableModel model = (DefaultTableModel) salesTable.getModel();
                        model.addRow(new Object[]{medicine, quan, sPrice, percent, currentAmount});
                        tempList.add(medicine);
                        grandTotal = grandTotal + currentAmount;
                        tfTotalAmount.setText("" + CommonDao.getTwoDecimal(grandTotal));
                        tfBarCode.setText("");
                        tfAdvancedPayment.setText("");
                        tfDueAmount.setText("");
                        tfBarCode.requestFocus();
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Insert Valid Number !!!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Already Exists !!!");
                }
            }

        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tfAdvancedPaymentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAdvancedPaymentKeyReleased

        try {
            Double totalAmount = Double.parseDouble(tfTotalAmount.getText());
            Double paidAmount = Double.parseDouble(tfAdvancedPayment.getText());

            double dueAmount = totalAmount - paidAmount;
            if (paidAmount > totalAmount) {
                tfAdvancedPayment.setBackground(Color.red);
                tfDueAmount.setText("" + 0);
            } else {
                tfDueAmount.setText("" + CommonDao.getRound(dueAmount));
                tfAdvancedPayment.setBackground(Color.WHITE);
            }

        } catch (NumberFormatException e) {
            System.out.println("Error..." + e);
        }
    }//GEN-LAST:event_tfAdvancedPaymentKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        DefaultTableModel model = (DefaultTableModel) salesTable.getModel();
        String advancedPayment = tfAdvancedPayment.getText();
        int itemsTaken = model.getRowCount();

        if (CommonDao.getNumberOfRecords("sales_master") >= 1000) {
            JOptionPane.showMessageDialog(this, "Trial Period Expired !!!\nNow you have to purchase.");
            return;
        }

        if (itemsTaken <= 0) {
            JOptionPane.showMessageDialog(this, "No Medicine Selected ???");
        } else if (cbPsType.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Select PS Type ???");
        } else if (advancedPayment.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert Paid Payment ???");
        } else {
            try {
                master = new SalesMaster();

                if (!tfCustomerName.getText().trim().equals("")) {
                    ClientDao clientDao = new ClientDao();
                    Client c = new Client();
                    c.setFirstName(tfCustomerName.getText().trim());
                    c.setClientType(1);
                    c.setStartingDue(0);
                    c.setDisplay(1);
                    c.setUser(user);
                    master.setClient(clientDao.save(c));
                } else {
                    master.setClient((Client) cbCustomer.getSelectedItem());
                }

                master.setDueAmount(Double.parseDouble(tfDueAmount.getText()));
                master.setPaidAmount(Double.parseDouble(advancedPayment));
                master.setPsTitle((PSTitle) cbPsType.getSelectedItem());
                master.setSalesDate(chSalesDate.getDate());
                master.setUser(user);

                for (int i = 0; i < itemsTaken; i++) {
                    Medicine medicine = (Medicine) model.getValueAt(i, 0);
                    int quantity = Integer.parseInt(model.getValueAt(i, 1).toString());
                    double percent = Double.parseDouble(model.getValueAt(i, 3).toString());
                    double sPrice = Double.parseDouble(model.getValueAt(i, 4).toString());
                    details = new SalesDetails();
                    StockDao stockDao = new StockDao();
                    Stock stock = stockDao.find(medicine);
                    details.setExpiracyDate(stock.getExpiracyDate());
                    details.setMedicine(medicine);
                    details.setPercentage(percent);
                    details.setPurchasePrice(medicine.getUnitPurchase() * quantity);
                    details.setQuantity(quantity);
                    details.setSalesPrice(sPrice);
                    tempDetails.add(details);
                }
                master.setDetails(tempDetails);

                salesDao = new SalesDao();
                master = salesDao.save(master);

                clearForm();
                enableButtons();

                int check = JOptionPane.showConfirmDialog(this, "Do you print voucher ???");
                if (check == 0) {
                    PrintSalesVoucherUI showReport = new PrintSalesVoucherUI(null, closable, master);
                    showReport.setLocationRelativeTo(null);
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    double width = screenSize.getWidth();
                    double height = screenSize.getHeight();
                    showReport.setBounds(0, 0, (int) width, (int) height);
                    showReport.setVisible(true);
                }

            } catch (NumberFormatException | HeadlessException e) {
                System.out.println("Error..." + e);
                JOptionPane.showMessageDialog(this, "Error...");
            } catch (StockError ex) {
                System.out.println("Error.." + ex);
                JOptionPane.showMessageDialog(this, "Don't have sufficient stock !!!");
            } catch (Exception ex) {
                System.out.println("Error..." + ex);
                JOptionPane.showMessageDialog(this, "Error !!!");
            }
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int check = JOptionPane.showConfirmDialog(this, "Are you sure ???");
        if (check == 0) {
            try {
                salesDao = new SalesDao();
                if (salesDao.delete(master)) {
                    JOptionPane.showMessageDialog(this, "Record Deleted successfully.");
                    clearForm();
                } else {
                    JOptionPane.showMessageDialog(this, "Record cannot delete !!!");
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void cbMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMedicineActionPerformed

        try {
            Medicine medicine = (Medicine) cbMedicine.getSelectedItem();
            StockDao stockDao = new StockDao();
            Stock stock = stockDao.find(String.valueOf(medicine.getMedicineId()));
            tfStock.setText("" + stock.getStockQuantity());
            tfUnitPurchase.setText("" + medicine.getUnitPurchase());
            tfUnitSales.setText("" + medicine.getUnitSales());
        } catch (Exception e) {
        }

    }//GEN-LAST:event_cbMedicineActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearForm();
        enableButtons();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        DefaultTableModel model = (DefaultTableModel) salesTable.getModel();
        int row = salesTable.getSelectedRow();
        Medicine medicine = (Medicine) model.getValueAt(row, 0);
        grandTotal = grandTotal - (double) model.getValueAt(row, 4);
        tempList.remove(medicine);
        tfTotalAmount.setText("" + CommonDao.getTwoDecimal(grandTotal));
        model.removeRow(row);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void tfPercentageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPercentageActionPerformed

        btnAdd.doClick();
        tfBarCode.requestFocus();
    }//GEN-LAST:event_tfPercentageActionPerformed

    private void tfAdvancedPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAdvancedPaymentActionPerformed

        btnSave.doClick();

    }//GEN-LAST:event_tfAdvancedPaymentActionPerformed

    private void tfBarCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBarCodeActionPerformed

        try {
            MedicineDao medicineDao = new MedicineDao();
            Medicine m = medicineDao.find(tfBarCode.getText());
            if (m.getMedicineId() != 0) {
                cbMedicine.getModel().setSelectedItem(m);
                tfQuantity.requestFocus();
                tfBarCode.setText("");
                tfQuantity.setText("");
            } else {
                cbMedicine.setSelectedItem(null);
                tfStock.setText("");
                tfQuantity.setText("");
                tfPercentage.setText("");
                tfUnitPurchase.setText("");
                tfUnitSales.setText("");
                JOptionPane.showMessageDialog(this, "No Match Found !!!");
            }

            //JOptionPane.showMessageDialog(this, tfBarCode.getText());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tfBarCodeActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        DefaultTableModel model = (DefaultTableModel) salesTable.getModel();
        String advancedPayment = tfAdvancedPayment.getText();
        int itemsTaken = model.getRowCount();

        if (CommonDao.getNumberOfRecords("sales_master") >= 1000) {
            JOptionPane.showMessageDialog(this, "Trial Period Expired !!!\nNow you have to purchase.");
            return;
        }

        if (itemsTaken <= 0) {
            JOptionPane.showMessageDialog(this, "No Medicine Selected ???");
        } else if (cbPsType.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Select PS Type ???");
        } else if (advancedPayment.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Insert Paid Payment ???");
        } else {
            try {

                if (!tfCustomerName.getText().trim().equals("")) {
                    ClientDao clientDao = new ClientDao();
                    Client c = new Client();
                    c.setFirstName(tfCustomerName.getText().trim());
                    c.setClientType(1);
                    c.setStartingDue(0);
                    c.setDisplay(1);
                    c.setUser(user);
                    master.setClient(clientDao.save(c));
                } else {
                    master.setClient((Client) cbCustomer.getSelectedItem());
                }

                master.setDueAmount(Double.parseDouble(tfDueAmount.getText()));
                master.setPaidAmount(Double.parseDouble(advancedPayment));
                master.setPsTitle((PSTitle) cbPsType.getSelectedItem());
                master.setSalesDate(chSalesDate.getDate());
                master.setUser(user);

                for (int i = 0; i < itemsTaken; i++) {
                    Medicine medicine = (Medicine) model.getValueAt(i, 0);
                    int quantity = Integer.parseInt(model.getValueAt(i, 1).toString());
                    double percent = Double.parseDouble(model.getValueAt(i, 3).toString());
                    double sPrice = Double.parseDouble(model.getValueAt(i, 4).toString());
                    details = new SalesDetails();
                    StockDao stockDao = new StockDao();
                    Stock stock = stockDao.find(medicine);
                    details.setExpiracyDate(stock.getExpiracyDate());
                    details.setMedicine(medicine);
                    details.setPercentage(percent);
                    details.setPurchasePrice(medicine.getUnitPurchase() * quantity);
                    details.setQuantity(quantity);
                    details.setSalesPrice(sPrice);
                    tempDetails.add(details);
                }
                master.setDetails(tempDetails);

                salesDao = new SalesDao();
                master = salesDao.update(master);

                clearForm();
                enableButtons();

                JOptionPane.showMessageDialog(this, "Record Updated Successfully.");

            } catch (NumberFormatException | HeadlessException e) {
                System.out.println("Error..." + e);
                JOptionPane.showMessageDialog(this, "Error...");
            } catch (StockError ex) {
                System.out.println("Error.." + ex);
                JOptionPane.showMessageDialog(this, "Don't have sufficient stock !!!");
            } catch (Exception ex) {
                System.out.println("Error..." + ex);
                JOptionPane.showMessageDialog(this, "Error !!!");
            }
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        DefaultTableModel model = (DefaultTableModel) salesTable.getModel();
        int row = salesTable.getSelectedRow();
        Medicine medicine = (Medicine) model.getValueAt(row, 0);
        cbMedicine.setSelectedItem(medicine);
        tfQuantity.setText(""+Integer.parseInt(model.getValueAt(row, 1).toString()));
        tfUnitPurchase.setText(""+medicine.getUnitPurchase());
        tfUnitSales.setText(""+Double.parseDouble(model.getValueAt(row, 2).toString()));
        tfPercentage.setText(""+Double.parseDouble(model.getValueAt(row, 3).toString()));
        grandTotal = grandTotal - Double.parseDouble(model.getValueAt(row, 4).toString());
        tempList.remove(medicine);
        tfTotalAmount.setText("" + CommonDao.getTwoDecimal(grandTotal));
        model.removeRow(row);
        tfAdvancedPayment.setText("");
        tfDueAmount.setText("");
    }//GEN-LAST:event_btnEditActionPerformed

    private void rbStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbStoreActionPerformed

        lvCustomer.setText("Store");
    }//GEN-LAST:event_rbStoreActionPerformed

    private void rbCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCustomerActionPerformed

        lvCustomer.setText("Customer");
        ClientDao clientDao = new ClientDao();
        cbCustomer.getModel().setSelectedItem(clientDao.find("1"));
    }//GEN-LAST:event_rbCustomerActionPerformed


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
    private javax.swing.JComboBox cbCustomer;
    private javax.swing.JComboBox cbMedicine;
    private javax.swing.JComboBox cbPsType;
    private com.toedter.calendar.JDateChooser chSalesDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JLabel lvCustomer;
    private javax.swing.JRadioButton rbCustomer;
    private javax.swing.JRadioButton rbStore;
    private javax.swing.JTable salesTable;
    private javax.swing.JTextField tfAdvancedPayment;
    private javax.swing.JTextField tfBarCode;
    private javax.swing.JTextField tfCustomerName;
    private javax.swing.JTextField tfDueAmount;
    private javax.swing.JTextField tfPercentage;
    private javax.swing.JTextField tfQuantity;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfStock;
    private javax.swing.JTextField tfTotalAmount;
    private javax.swing.JTextField tfUnitPurchase;
    private javax.swing.JTextField tfUnitSales;
    // End of variables declaration//GEN-END:variables
}
