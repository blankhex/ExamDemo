/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examdemo;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author roman
 */
public class MainFrame extends javax.swing.JFrame {

    ArrayList<User> users;
    
    public void updateTable() {
        users.clear();
        ArrayList<ArrayList<String>> result = Database.query("SELECT id, fullname, username, password, type FROM users;");
        DefaultTableModel model = (DefaultTableModel)usersTable.getModel();
        
        model.setRowCount(0);
        for(ArrayList<String> row : result) {
            User user = new User(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4));
            users.add(user);
            model.addRow(new Object[]{user.getId(), user.getUsername(), user.getFullname(), row.get(4)});
        }
    }
    
    public MainFrame() {
        initComponents();
        users = new ArrayList<>();
        
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Имя пользователя");
        model.addColumn("ФИО");
        model.addColumn("Тип пользователя");
        
        
        usersTable.setModel(model);
        updateTable();
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        addUserButton = new javax.swing.JButton();
        deleteUserButton = new javax.swing.JButton();
        editUserButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Таблица пользователей:");

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Имя пользователя", "ФИО", "Тип"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(usersTable);

        addUserButton.setText("Добавить пользователя");
        addUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserButtonActionPerformed(evt);
            }
        });

        deleteUserButton.setText("Удалить пользователя");
        deleteUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserButtonActionPerformed(evt);
            }
        });

        editUserButton.setText("Изменить пользователя");
        editUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(addUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addUserButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editUserButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteUserButton)
                .addGap(69, 69, 69))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) usersTable.getModel();
        
        try {
            User user = users.get(usersTable.getSelectedRow());
            
            System.out.println(user);
            
            RegistationDialog dialog = new RegistationDialog(this, true);
            dialog.setUsername(user.getUsername());
            dialog.setPassword(user.getPassword());
            dialog.setFullname(user.getFullname());
            
            dialog.setVisible(true);
            
            if(!dialog.isReady()) {
                return;
            }
            
            
            
            if(Database.execute("UPDATE users SET username = '" + dialog.getUsername() + "', password = '" + dialog.getPassword() + "', fullname = '" + dialog.getFullname() + "' WHERE id = " + user.getId() + ";" )) {
                updateTable();
            } else {
                JOptionPane.showMessageDialog(this, "Невозможно удалить пользователя", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_editUserButtonActionPerformed

    private void addUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserButtonActionPerformed
        RegistationDialog dialog = new RegistationDialog(this, true);
        dialog.setVisible(true);

        String fullname = dialog.getFullname();
        String password = dialog.getPassword();
        String username = dialog.getUsername();
        if (dialog.isReady()) {
            if (!Database.execute("INSERT INTO users (fullname, username, password, type) VALUES('" + fullname + "', '" + username + "', '" + password + "', 1);")) {
                JOptionPane.showMessageDialog(this, "Невозможно зарегестрировать данного пользователя", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(this, "Пользователь зарегестрирован", "Информация", JOptionPane.INFORMATION_MESSAGE);
        }
        
        updateTable();
    }//GEN-LAST:event_addUserButtonActionPerformed

    private void deleteUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) usersTable.getModel();
        
        try {
            User user = users.get(usersTable.getSelectedRow());
            
            if(Database.execute("DELETE FROM users WHERE id = " + user.getId() + ";" )) {
                updateTable();
            } else {
                JOptionPane.showMessageDialog(this, "Невозможно удалить пользователя", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_deleteUserButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUserButton;
    private javax.swing.JButton deleteUserButton;
    private javax.swing.JButton editUserButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}