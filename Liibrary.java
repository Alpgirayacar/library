
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import library.Book;
import library.DbHelper;
import library.Person;
import library.Reader;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alpgiray ACAR
 */
public class Liibrary extends javax.swing.JFrame {

    /**
     * Creates new form Liibrary
     */
     DefaultTableModel model;
     DefaultTableModel model2;
     public ArrayList<Book> getBook() throws SQLException{
         
          Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet ;
        ArrayList<Book> books=null;
        try{
             connection = dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select * from library.book");
            books=new ArrayList<Book>();
            while (resultSet.next()){
                books.add(new Book (resultSet.getString("id"),resultSet.getString("name"),resultSet.getString("writer")));
          
                
            }
            
        }catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
        }finally{ 
            statement.close();
            connection.close();
        
        }
        return books;
        
        
     }
     public ArrayList<Person> getPerson() throws SQLException{
        
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet ;
        ArrayList<Person> persons=null;
        try{
             connection = dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select * from library.person");
            persons=new ArrayList<Person>();
            while (resultSet.next()){
                persons.add(new Person (resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("surname"),resultSet.getString("email")));
          
                
            }
            
        }catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
        }finally{ 
            statement.close();
            connection.close();
        
        }
        return  persons;
        
        
        
    }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    public Liibrary() {
        initComponents();
         model= (DefaultTableModel)tblReader.getModel();
         model2=(DefaultTableModel)tblBook.getModel();
         
       try{
            ArrayList<Person>persons=getPerson();
                 for(Person person:persons){
                Object[]row ={person.getId(),person.getName(),person.getSurname(),person.getEmail()};
                model.addRow(row);
            }
            
         }catch(SQLException ex){
                    
                } 
       
         try{
            ArrayList<Book>books=getBook();
                 for(Book book:books){
                Object[]row ={book.getId(),book.getName(),book.getWriter()};
                model2.addRow(row);
            }
            
         }catch(SQLException ex){
                    
                } 
        
        
        
       
    }
    
    
    
    
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReader = new javax.swing.JTable();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblSurname = new javax.swing.JLabel();
        txtSurname = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        lblSechReader = new javax.swing.JLabel();
        txtSerchReader = new javax.swing.JTextField();
        lblReaderMessage = new javax.swing.JLabel();
        lblBookMessage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtBookSerch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBook = new javax.swing.JTable();
        lblBookName = new javax.swing.JLabel();
        txtBookName = new javax.swing.JTextField();
        lblWriter = new javax.swing.JLabel();
        txtWriter = new javax.swing.JTextField();
        lblBookId = new javax.swing.JLabel();
        txtBookId = new javax.swing.JTextField();
        btnBookAdd = new javax.swing.JButton();
        btnBookDelete = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblReader.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "İd", "İsim", "Soyisim", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblReader);
        if (tblReader.getColumnModel().getColumnCount() > 0) {
            tblReader.getColumnModel().getColumn(0).setResizable(false);
            tblReader.getColumnModel().getColumn(1).setResizable(false);
            tblReader.getColumnModel().getColumn(2).setResizable(false);
            tblReader.getColumnModel().getColumn(3).setResizable(false);
        }

        lblName.setText("İsim:");

        lblSurname.setText("Soyisim:");

        lblId.setText("İd:");

        lblEmail.setText("Email:");

        btnAdd.setText("Ekle");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblSechReader.setText("Ara:");

        txtSerchReader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerchReaderActionPerformed(evt);
            }
        });
        txtSerchReader.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSerchReaderKeyReleased(evt);
            }
        });

        lblReaderMessage.setText("                                         OKUYUCU  LİSTESİ");

        lblBookMessage.setText("                                                 KİTAP LİSTESİ");

        jLabel1.setText("Ara:");

        txtBookSerch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookSerchActionPerformed(evt);
            }
        });
        txtBookSerch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBookSerchKeyReleased(evt);
            }
        });

        tblBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "İd", "İsim", "Yazar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblBook);
        if (tblBook.getColumnModel().getColumnCount() > 0) {
            tblBook.getColumnModel().getColumn(0).setResizable(false);
            tblBook.getColumnModel().getColumn(1).setResizable(false);
            tblBook.getColumnModel().getColumn(2).setResizable(false);
        }

        lblBookName.setText("İsim:");

        lblWriter.setText("Yazar:");

        lblBookId.setText("İd:");

        btnBookAdd.setText("Ekle");
        btnBookAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookAddActionPerformed(evt);
            }
        });

        btnBookDelete.setText("Sil");
        btnBookDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookDeleteActionPerformed(evt);
            }
        });

        btnDelete.setText("Sil");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblBookMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lblReaderMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBookSerch, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSechReader, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSerchReader, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(58, 58, 58))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblBookName, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBookId))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBookName)
                                    .addComponent(txtBookId, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(lblWriter)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtWriter, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(btnBookDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnBookAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtName)
                                            .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(lblEmail)
                                                .addGap(15, 15, 15))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSurname)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))
                            .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblId)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReaderMessage)
                    .addComponent(lblBookMessage))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSerchReader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSechReader)
                    .addComponent(jLabel1)
                    .addComponent(txtBookSerch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblName))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblSurname)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblId)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnDelete)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblBookName)
                            .addComponent(txtBookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblWriter)
                                .addComponent(txtWriter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBookId)
                            .addComponent(txtBookId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBookAdd)
                            .addComponent(btnBookDelete))))
                .addContainerGap(147, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Connection connection= null;
        DbHelper dbHelper=new DbHelper();
        PreparedStatement statement=null;
        try{
            connection=dbHelper.getConnection();
            String sql ="insert into library.person (id,name,surname,email)values(?,?,?,?)";
            statement=connection.prepareStatement(sql);
            statement.setString(1, txtId.getText());
            statement.setString(2, txtName.getText());
            statement.setString(3, txtSurname.getText());
            statement.setString(4, txtEmail.getText());
            int result =statement.executeUpdate();
        }catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
            
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(Liibrary.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Liibrary.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBookAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookAddActionPerformed
         Connection connection= null;
        DbHelper dbHelper=new DbHelper();
        PreparedStatement statement=null;
        try{
            connection=dbHelper.getConnection();
            String sql ="insert into library.person (id,name,writer)values(?,?,?)";
            statement=connection.prepareStatement(sql);
            statement.setString(1, txtBookId.getText());
            statement.setString(2, txtBookName.getText());
            statement.setString(3, txtWriter.getText());
            
            int result =statement.executeUpdate();
        }catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
            
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(Liibrary.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Liibrary.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnBookAddActionPerformed

    private void btnBookDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookDeleteActionPerformed
        
    }//GEN-LAST:event_btnBookDeleteActionPerformed

    private void txtBookSerchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookSerchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookSerchActionPerformed

    private void txtBookSerchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBookSerchKeyReleased
        // TODO add your handling code here:
        String BookSerchKey=txtBookSerch.getText();
        TableRowSorter<DefaultTableModel>tableRowSorter=new  TableRowSorter<DefaultTableModel>(model); 
        tblBook.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(BookSerchKey));
    }//GEN-LAST:event_txtBookSerchKeyReleased

    private void txtSerchReaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerchReaderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerchReaderActionPerformed

    private void txtSerchReaderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerchReaderKeyReleased
        // TODO add your handling code here:
        String SerchReaderKey=txtSerchReader.getText();
        TableRowSorter<DefaultTableModel>tableRowSorter=new  TableRowSorter<DefaultTableModel>(model2); 
        tblReader.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(SerchReaderKey));
        
    }//GEN-LAST:event_txtSerchReaderKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Liibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Liibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Liibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Liibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Liibrary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBookAdd;
    private javax.swing.JButton btnBookDelete;
    private javax.swing.JButton btnDelete;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBookId;
    private javax.swing.JLabel lblBookMessage;
    private javax.swing.JLabel lblBookName;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblReaderMessage;
    private javax.swing.JLabel lblSechReader;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JLabel lblWriter;
    private javax.swing.JTable tblBook;
    private javax.swing.JTable tblReader;
    private javax.swing.JTextField txtBookId;
    private javax.swing.JTextField txtBookName;
    private javax.swing.JTextField txtBookSerch;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSerchReader;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JTextField txtWriter;
    // End of variables declaration//GEN-END:variables
}
