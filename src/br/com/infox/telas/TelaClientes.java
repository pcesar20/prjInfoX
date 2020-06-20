package br.com.infox.telas;

import br.com.infox.dal.ModuloConexao;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class TelaClientes extends javax.swing.JInternalFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;


    public TelaClientes() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    
    private void inserir(){
    String sql= "insert into pcclientes(nome_cliente, endcli, fonecli, email, cidade_cliente)values (?, ?, ?, ?, ?)";
    try {
        pst = conexao.prepareStatement(sql);
        pst.setString(1, txtCliNome.getText());
        pst.setString(2, txtCliEnd.getText());
        pst.setString(3, txtCliFone.getText());
        pst.setString(4, txtCliEmail.getText());
        pst.setString(5, cboCliCidade.getSelectedItem().toString());
        if(txtCliNome.getText().isEmpty() || txtCliEnd.getText().isEmpty() || txtCliFone.getText().isEmpty() || txtCliEmail.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Existe campo obrigatório sem preenchimento!");
        }
        int add = pst.executeUpdate();
        if (add > 0){
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                    txtCliNome.setText(null);
                    txtCliEnd.setText(null);
                    txtCliFone.setText(null);
                    txtCliEmail.setText(null);
                    cboCliCidade.setSelectedItem(null); 
        }
                   
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao executar, verifique a mensagem: " + e);
    }
    
}
    
    private void alterar(){
        String sql = "update pcclientes set nome_cliente=?, endcli=?, fonecli=?, email=?, cidade_cliente=? where cliente_id=?";
        String sql2 = "select cliente_id from pcclientes";
    try {
        pst = conexao.prepareStatement(sql);
        pst.setString(1, txtCliNome.getText());
        pst.setString(2, txtCliEnd.getText());
        pst.setString(3, txtCliFone.getText());
        pst.setString(4, txtCliEmail.getText());
        pst.setString(5, cboCliCidade.getSelectedItem().toString());
        pst.setString(6, txtCliID.getText());
        if(txtCliNome.getText().isEmpty() || txtCliEnd.getText().isEmpty() || txtCliFone.getText().isEmpty() || txtCliEmail.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Existe campo obrigatório sem preenchimento!");
        } else{
        int add = pst.executeUpdate(); 
        if (add > 0){
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
                    txtCliNome.setText(null);
                    txtCliEnd.setText(null);
                    txtCliFone.setText(null);
                    txtCliEmail.setText(null);
                    cboCliCidade.setSelectedItem(null); 
                    btnCliCreate.setEnabled(true);}}
    } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Erro ao executar, verifique a mensagem: " + e);
    }
    }
    
    private void excluir(){
    int delete = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir? ", "Atenção", JOptionPane.YES_NO_OPTION);
    if (delete == JOptionPane.YES_OPTION){
        String sql = "delete from pcclientes where cliente_id =?";
        try {
           pst = conexao.prepareStatement(sql);
           pst.setString(1, txtCliID.getText()); 
           int add = pst.executeUpdate();
           
           if (add > 0){
             JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
                    txtCliID.setText(null);
                    txtCliNome.setText(null);
                    txtCliEnd.setText(null);
                    txtCliFone.setText(null);
                    txtCliEmail.setText(null);
                    cboCliCidade.setSelectedItem(null); 
           }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar, verifique a mensagem: " + e);
        }
    }
}
    
    private void pesquisarcliente(){
        String sql = "select * from pcclientes where nome_cliente like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,txtPesquisa.getText() + "%");
            rs = pst.executeQuery();
            tblClientes.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar, verifique a mensagem: " + e);
        }
    }
    
    private void buscarcampos(){
        int setar = tblClientes.getSelectedRow();
        txtCliID.setText(tblClientes.getModel().getValueAt(setar,0).toString());
        txtCliNome.setText(tblClientes.getModel().getValueAt(setar,1).toString());
        txtCliEnd.setText(tblClientes.getModel().getValueAt(setar,2).toString());
        txtCliFone.setText(tblClientes.getModel().getValueAt(setar,3).toString());
        txtCliEmail.setText(tblClientes.getModel().getValueAt(setar,4).toString());
        btnCliCreate.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCliDelete = new javax.swing.JButton();
        btnCliUpdate = new javax.swing.JButton();
        btnCliCreate = new javax.swing.JButton();
        txtCliEnd = new javax.swing.JTextField();
        txtCliFone = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCliNome = new javax.swing.JTextField();
        txtCliEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        txtPesquisa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboCliCidade = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtCliID = new javax.swing.JTextField();

        setClosable(true);

        btnCliDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/delete.png"))); // NOI18N
        btnCliDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliDelete.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCliDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliDeleteActionPerformed(evt);
            }
        });

        btnCliUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/update.png"))); // NOI18N
        btnCliUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliUpdate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCliUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliUpdateActionPerformed(evt);
            }
        });

        btnCliCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/create.png"))); // NOI18N
        btnCliCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliCreate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCliCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliCreateActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        jLabel3.setText("Email");

        jLabel4.setText("Endereço");

        jLabel5.setText("Telefone");

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/iconfinder_search_button_36847.png"))); // NOI18N

        jLabel7.setText("Cidade");

        cboCliCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Goiânia", "Aparecida de Goiânia", "Senador Canedo", "Trindade" }));

        jLabel8.setText("ID");

        txtCliID.setEditable(false);
        txtCliID.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(103, 103, 103))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCliCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCliNome)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(btnCliUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(txtCliFone, javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(txtCliEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(50, 50, 50)
                                                        .addComponent(jLabel7)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cboCliCidade, 0, 1, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtCliEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtCliID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addGap(10, 10, 10)))
                        .addComponent(btnCliDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCliID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4))
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCliFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(cboCliCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCliEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCliUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCliCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCliDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(141, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCliDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliDeleteActionPerformed
        try {
           excluir();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Mensagem: " + e);
        }
    }//GEN-LAST:event_btnCliDeleteActionPerformed

    private void btnCliUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliUpdateActionPerformed
        try {
            alterar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Mensagem: " + e);
        }

    }//GEN-LAST:event_btnCliUpdateActionPerformed

    private void btnCliCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliCreateActionPerformed
        try {
            inserir();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Preencha o campo ID: " + e);
        }

    }//GEN-LAST:event_btnCliCreateActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        try {
            pesquisarcliente();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fala Zezé, bom dia, cara...");
        }
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        buscarcampos();
    }//GEN-LAST:event_tblClientesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliCreate;
    private javax.swing.JButton btnCliDelete;
    private javax.swing.JButton btnCliUpdate;
    private javax.swing.JComboBox<String> cboCliCidade;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtCliEmail;
    private javax.swing.JTextField txtCliEnd;
    private javax.swing.JTextField txtCliFone;
    private javax.swing.JTextField txtCliID;
    private javax.swing.JTextField txtCliNome;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
