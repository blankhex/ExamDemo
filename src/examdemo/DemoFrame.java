/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examdemo;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author roman
 */
public class DemoFrame extends javax.swing.JFrame {
    
    ArrayList<User> users;
    /**
     * Creates new form DemoFrame
     */
    
    public void updateData() {
        selectUserComboBox.removeAllItems();
        
        users.clear();
        ArrayList<ArrayList<String>> result = Database.query("SELECT id, fullname, username, password, type FROM users;");
        for(ArrayList<String> row : result) {
            User user = new User(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4));
            users.add(user);
            selectUserComboBox.addItem(user.getUsername());
        }
        usersList.updateUI();
        selectUserComboBox.updateUI();
    }
    
    public DemoFrame() {
        initComponents();
        users = new ArrayList<>();
        
        usersList.setModel(new AbstractListModel<String>() {
            @Override
            public int getSize() {
                return users.size();
            }

            @Override
            public String getElementAt(int index) {
                return users.get(index).getFullname() + " " + users.get(index).getType();
            }
        });
        
        updateData();
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        type1 = new javax.swing.JRadioButton();
        type2 = new javax.swing.JRadioButton();
        type3 = new javax.swing.JRadioButton();
        type4 = new javax.swing.JRadioButton();
        selectUserComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersList = new javax.swing.JList<>();
        setButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(type1);
        type1.setText("Заказчик");

        buttonGroup1.add(type2);
        type2.setText("Менеджер");

        buttonGroup1.add(type3);
        type3.setText("Директор");

        buttonGroup1.add(type4);
        type4.setText("Кладовщик");

        selectUserComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectUserComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectUserComboBoxItemStateChanged(evt);
            }
        });
        selectUserComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectUserComboBoxActionPerformed(evt);
            }
        });

        usersList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(usersList);

        setButton.setText("Задать");
        setButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Отмена");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(setButton, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(selectUserComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(type1)
                    .addComponent(type2)
                    .addComponent(type3)
                    .addComponent(type4)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(type1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectUserComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectUserComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectUserComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectUserComboBoxActionPerformed

    private void selectUserComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectUserComboBoxItemStateChanged
        try {
        int index = selectUserComboBox.getSelectedIndex();
        
        User user = users.get(index);
        switch(user.getType()) {
            case 1:
                type1.setSelected(true);
                break;
            case 2:
                type2.setSelected(true);
                break;
            case 3:
                type3.setSelected(true);
                break;
            case 4:
                type4.setSelected(true);
                break;
                
        }
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_selectUserComboBoxItemStateChanged

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void setButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setButtonActionPerformed
        try {
            int index = selectUserComboBox.getSelectedIndex();
            int type = 1;
            
            if(type1.isSelected())
                type = 1;
            if(type2.isSelected())
                type = 2;
            if(type3.isSelected())
                type = 3;
            if(type4.isSelected())
                type = 4;
            
            if(Database.execute("UPDATE users SET type = " + type + " WHERE id = " + users.get(index).getId())) {
                updateData();
            } else {
                
            }
            
        
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_setButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DemoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DemoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DemoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DemoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DemoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> selectUserComboBox;
    private javax.swing.JButton setButton;
    private javax.swing.JRadioButton type1;
    private javax.swing.JRadioButton type2;
    private javax.swing.JRadioButton type3;
    private javax.swing.JRadioButton type4;
    private javax.swing.JList<String> usersList;
    // End of variables declaration//GEN-END:variables
}
