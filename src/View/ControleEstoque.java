/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author aluno
 */
public class ControleEstoque extends javax.swing.JFrame {

    /**
     * Creates new form ControleEstoque
     */
    public ControleEstoque() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanFiltro = new javax.swing.JPanel();
        jTFFitrar = new javax.swing.JTextField();
        buscaChave = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanFiltro1 = new javax.swing.JPanel();
        jTFFitrar1 = new javax.swing.JTextField();
        buscaBox = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        estoqueTable = new javax.swing.JTable();
        jLabelTitulo1 = new javax.swing.JLabel();
        carregarBotao = new javax.swing.JButton();
        sairBotao = new javax.swing.JButton();
        acrescentarBotao = new javax.swing.JButton();
        registrarBotao = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jScrollPane1.setViewportView(jEditorPane1);

        jPanFiltro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanFiltro.setEnabled(false);

        buscaChave.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id", "descricao" }));
        buscaChave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaChaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanFiltroLayout = new javax.swing.GroupLayout(jPanFiltro);
        jPanFiltro.setLayout(jPanFiltroLayout);
        jPanFiltroLayout.setHorizontalGroup(
            jPanFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buscaChave, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jTFFitrar, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanFiltroLayout.setVerticalGroup(
            jPanFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanFiltroLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFFitrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscaChave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable2);

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanFiltro1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanFiltro1.setEnabled(false);

        buscaBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id", "codigo barra", "descrição" }));
        buscaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanFiltro1Layout = new javax.swing.GroupLayout(jPanFiltro1);
        jPanFiltro1.setLayout(jPanFiltro1Layout);
        jPanFiltro1Layout.setHorizontalGroup(
            jPanFiltro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanFiltro1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buscaBox, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTFFitrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanFiltro1Layout.setVerticalGroup(
            jPanFiltro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanFiltro1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanFiltro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFFitrar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(339, 339, 339))
        );

        estoqueTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(estoqueTable);

        jLabelTitulo1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabelTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo1.setText("Estoque");

        carregarBotao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Down.png"))); // NOI18N
        carregarBotao.setText("Carregar");
        carregarBotao.setPreferredSize(new java.awt.Dimension(115, 35));
        carregarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregarBotaoActionPerformed(evt);
            }
        });

        sairBotao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Exit.png"))); // NOI18N
        sairBotao.setText("Sair");
        sairBotao.setPreferredSize(new java.awt.Dimension(115, 35));
        sairBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairBotaoActionPerformed(evt);
            }
        });

        acrescentarBotao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Database.png"))); // NOI18N
        acrescentarBotao.setText("Acrescentar item");

        registrarBotao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Create.png"))); // NOI18N
        registrarBotao.setText("Registrar novo");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Dollar.png"))); // NOI18N
        jButton1.setText("Movimento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanFiltro1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(carregarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(registrarBotao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(acrescentarBotao)
                        .addGap(26, 26, 26)
                        .addComponent(sairBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(224, 224, 224)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabelTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanFiltro1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carregarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sairBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(acrescentarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registrarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscaChaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaChaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscaChaveActionPerformed

    private void buscaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscaBoxActionPerformed

    private void carregarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarBotaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carregarBotaoActionPerformed

    private void sairBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairBotaoActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_sairBotaoActionPerformed

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
            java.util.logging.Logger.getLogger(ControleEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControleEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControleEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControleEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControleEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acrescentarBotao;
    private javax.swing.JComboBox<String> buscaBox;
    private javax.swing.JComboBox<String> buscaChave;
    private javax.swing.JButton carregarBotao;
    private javax.swing.JTable estoqueTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTitulo1;
    private javax.swing.JPanel jPanFiltro;
    private javax.swing.JPanel jPanFiltro1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTFFitrar;
    private javax.swing.JTextField jTFFitrar1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton registrarBotao;
    private javax.swing.JButton sairBotao;
    // End of variables declaration//GEN-END:variables
}
