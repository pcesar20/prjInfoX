
package br.com.infox.telas;

import br.com.infox.dal.ModuloConexao;
import javax.swing.*;
import java.sql.*;


public class TelaUsuario extends javax.swing.JInternalFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public TelaUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
private void consultar(){
    String sql = "select * from pcusuarios where usuario_id=?";
    try {
        pst = conexao.prepareStatement(sql);
        pst.setString(1, txtUserID.getText());
        rs = pst.executeQuery();
            if(rs.next()){
              txtUserNome.setText(rs.getString(2));
              txtUserFone.setText(rs.getString(3));
              txtUserLogin.setText(rs.getString(4));
              txtUserSenha.setText(rs.getString(5));
              cboUserPerfil.setSelectedItem(rs.getString(6));
                          }
            else{
               JOptionPane.showMessageDialog(null, "Usuário não cadastrado."); 
                    txtUserID.setText(null);
                    txtUserNome.setText(null);
                    txtUserFone.setText(null);
                    txtUserLogin.setText(null);
                    txtUserSenha.setText(null);
                    cboUserPerfil.setSelectedItem(null); 
            }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao executar, verifique a mensagem: " + e);
        
    }
            }
private void inserir(){
    String sql= "insert into pcusuarios(usuario_id, nome_usuario, fone, login, senha, perfil)values (?, ?, ?, ?, ?, ?)";
    try {
        pst = conexao.prepareStatement(sql);
        pst.setString(1, txtUserID.getText());
        pst.setString(2, txtUserNome.getText());
        pst.setString(3, txtUserFone.getText());
        pst.setString(4, txtUserLogin.getText());
        pst.setString(5, txtUserSenha.getText());
        pst.setString(6, cboUserPerfil.getSelectedItem().toString());
        if(txtUserID.getText().isEmpty() || txtUserNome.getText().isEmpty() || txtUserLogin.getText().isEmpty() || txtUserSenha.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Existe campo obrigatório sem preenchimento!");
        }
        int add = pst.executeUpdate();
        if (add > 0){
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                    txtUserID.setText(null);
                    txtUserNome.setText(null);
                    txtUserFone.setText(null);
                    txtUserLogin.setText(null);
                    txtUserSenha.setText(null);
                    cboUserPerfil.setSelectedItem(null); 
        }
                   
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao executar, verifique a mensagem: " + e);
    }
    
}

private void alterar(){
    String sql = "update pcusuarios set nome_usuario=?, fone=?, login=?, senha=?, perfil=? where usuario_id=?";
    try {
        pst = conexao.prepareStatement(sql);
        pst.setString(1, txtUserNome.getText());
        pst.setString(2, txtUserFone.getText());
        pst.setString(3, txtUserLogin.getText());
        pst.setString(4, txtUserSenha.getText());
        pst.setString(5, cboUserPerfil.getSelectedItem().toString());
        pst.setString(6, txtUserID.getText());
        if(txtUserID.getText().isEmpty() || txtUserNome.getText().isEmpty() || txtUserLogin.getText().isEmpty() || txtUserSenha.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Existe campo obrigatório sem preenchimento!");
        } else{
        int add = pst.executeUpdate(); 
        if (add > 0){
            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");
                    txtUserID.setText(null);
                    txtUserNome.setText(null);
                    txtUserFone.setText(null);
                    txtUserLogin.setText(null);
                    txtUserSenha.setText(null);
                    cboUserPerfil.setSelectedItem(null); }}
    } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Erro ao executar, verifique a mensagem: " + e);
    }
}

private void excluir(){
    int delete = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir? ", "Atenção", JOptionPane.YES_NO_OPTION);
    if (delete == JOptionPane.YES_OPTION){
        String sql = "delete from pcusuarios where usuario_id =?";
        try {
           pst = conexao.prepareStatement(sql);
           pst.setString(1, txtUserID.getText()); 
           int add = pst.executeUpdate();
           
           if (add > 0){
             JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso!");
              txtUserID.setText(null);
                    txtUserNome.setText(null);
                    txtUserFone.setText(null);
                    txtUserLogin.setText(null);
                    txtUserSenha.setText(null);
                    cboUserPerfil.setSelectedItem(null); 
           }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar, verifique a mensagem: " + e);
        }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUserID = new javax.swing.JTextField();
        txtUserNome = new javax.swing.JTextField();
        txtUserFone = new javax.swing.JTextField();
        txtUserLogin = new javax.swing.JTextField();
        txtUserSenha = new javax.swing.JTextField();
        cboUserPerfil = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnUserCreate = new javax.swing.JButton();
        btnUserRead = new javax.swing.JButton();
        btnUserUpdate = new javax.swing.JButton();
        btnUserDelete = new javax.swing.JButton();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(640, 380));

        jLabel1.setText("ID");

        jLabel2.setText("Nome");

        jLabel3.setText("Fone");

        jLabel4.setText("Login");

        jLabel5.setText("Senha");

        jLabel6.setText("Perfil");

        cboUserPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\PCESAR\\Downloads\\iconfinder_user-id_285641.png")); // NOI18N
        jLabel7.setText("jLabel7");

        btnUserCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/create.png"))); // NOI18N
        btnUserCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUserCreate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUserCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserCreateActionPerformed(evt);
            }
        });

        btnUserRead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/read.png"))); // NOI18N
        btnUserRead.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUserRead.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUserRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserReadActionPerformed(evt);
            }
        });

        btnUserUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/update.png"))); // NOI18N
        btnUserUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUserUpdate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUserUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserUpdateActionPerformed(evt);
            }
        });

        btnUserDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/delete.png"))); // NOI18N
        btnUserDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUserDelete.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUserDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUserCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUserRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(146, 146, 146)
                                    .addComponent(btnUserUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnUserDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cboUserPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(34, 34, 34)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtUserSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtUserFone, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(txtUserNome, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(11, 11, 11))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnUserCreate, btnUserDelete, btnUserRead, btnUserUpdate});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtUserNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(cboUserPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtUserSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtUserFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUserRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUserUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUserDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUserCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnUserCreate, btnUserDelete, btnUserRead, btnUserUpdate});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUserReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserReadActionPerformed
        try {
            consultar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Mensagem: " + e);
        }
    }//GEN-LAST:event_btnUserReadActionPerformed

    private void btnUserCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserCreateActionPerformed
        try {
            inserir();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Preencha o campo ID: " + e);
        }
        
    }//GEN-LAST:event_btnUserCreateActionPerformed

    private void btnUserUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserUpdateActionPerformed
        try {
            alterar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Mensagem: " + e);
        }
                
    }//GEN-LAST:event_btnUserUpdateActionPerformed

    private void btnUserDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserDeleteActionPerformed
           try {
            excluir();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Mensagem: " + e);
        }
    }//GEN-LAST:event_btnUserDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUserCreate;
    private javax.swing.JButton btnUserDelete;
    private javax.swing.JButton btnUserRead;
    private javax.swing.JButton btnUserUpdate;
    private javax.swing.JComboBox<String> cboUserPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtUserFone;
    private javax.swing.JTextField txtUserID;
    private javax.swing.JTextField txtUserLogin;
    private javax.swing.JTextField txtUserNome;
    private javax.swing.JTextField txtUserSenha;
    // End of variables declaration//GEN-END:variables
}
