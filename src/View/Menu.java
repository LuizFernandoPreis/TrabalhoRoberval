/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

/**
 *
 * @author luizf
 */
import view.TelaBuscaCliente;
import View.TelaCadastroCliente;
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        DAO.ClasseDados.getInstance();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuCliente = new javax.swing.JMenuItem();
        menuFornecedor = new javax.swing.JMenuItem();
        menuFuncionario = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuBairro = new javax.swing.JMenuItem();
        menuCidade = new javax.swing.JMenuItem();
        menuEndereco = new javax.swing.JMenuItem();
        menucarteirinha = new javax.swing.JMenuItem();
        menuProduto = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        menuSair = new javax.swing.JMenuItem();
        menuMovimentos = new javax.swing.JMenu();
        menuContas = new javax.swing.JMenu();
        itemReceber = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Rober3x4.jpg"))); // NOI18N

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(102, 51, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(924, 395));

        jLabel9.setForeground(new java.awt.Color(240, 240, 240));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/paradiso-bar.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        jMenu1.setText("Cadastros");

        menuCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        menuCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Boss.png"))); // NOI18N
        menuCliente.setText("cliente");
        menuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClienteActionPerformed(evt);
            }
        });
        jMenu1.add(menuCliente);

        menuFornecedor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        menuFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Database.png"))); // NOI18N
        menuFornecedor.setText("Fornecedores");
        menuFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFornecedorActionPerformed(evt);
            }
        });
        jMenu1.add(menuFornecedor);

        menuFuncionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        menuFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Male.png"))); // NOI18N
        menuFuncionario.setText("Funcionários");
        menuFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFuncionarioActionPerformed(evt);
            }
        });
        jMenu1.add(menuFuncionario);
        jMenu1.add(jSeparator1);

        menuBairro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuBairro.setText("Bairro");
        menuBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBairroActionPerformed(evt);
            }
        });
        jMenu1.add(menuBairro);

        menuCidade.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuCidade.setText("Cidade");
        menuCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCidadeActionPerformed(evt);
            }
        });
        jMenu1.add(menuCidade);

        menuEndereco.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuEndereco.setText("Endereço");
        menuEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEnderecoActionPerformed(evt);
            }
        });
        jMenu1.add(menuEndereco);

        menucarteirinha.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menucarteirinha.setText("Carteirinha");
        menucarteirinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menucarteirinhaActionPerformed(evt);
            }
        });
        jMenu1.add(menucarteirinha);

        menuProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuProduto.setText("Produto");
        menuProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(menuProduto);
        jMenu1.add(jSeparator4);

        menuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        jMenu1.add(menuSair);

        jMenuBar1.add(jMenu1);

        menuMovimentos.setText("Movimentos");

        menuContas.setText("Contas");

        itemReceber.setText("Pagar");
        itemReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReceberActionPerformed(evt);
            }
        });
        menuContas.add(itemReceber);

        jMenuItem10.setText("Receber");
        menuContas.add(jMenuItem10);

        menuMovimentos.add(menuContas);

        jMenuBar1.add(menuMovimentos);

        jMenu3.setText("Relatórios");
        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Help symbol.png"))); // NOI18N
        jMenu4.setText("Ajuda");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClienteActionPerformed
       TelaCadastroCliente a = new TelaCadastroCliente();
       a.setVisible(true);
    }//GEN-LAST:event_menuClienteActionPerformed

    private void menuFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFuncionarioActionPerformed
       TelaCadastroFuncionario a = new TelaCadastroFuncionario(); 
       a.setVisible(true);
    }//GEN-LAST:event_menuFuncionarioActionPerformed

    private void menuBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBairroActionPerformed
       TelaCadastroBairro a = new TelaCadastroBairro();
       a.setVisible(true);
    }//GEN-LAST:event_menuBairroActionPerformed

    private void menuCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCidadeActionPerformed
        TelaCadastroCidade a = new TelaCadastroCidade();
        a.setVisible(true);
    }//GEN-LAST:event_menuCidadeActionPerformed

    private void menuEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEnderecoActionPerformed
        TelaCadastroEndereco a = new TelaCadastroEndereco();
        a.setVisible(true);
    }//GEN-LAST:event_menuEnderecoActionPerformed

    private void menucarteirinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menucarteirinhaActionPerformed
        TelaCadastroCarteirinha a = new TelaCadastroCarteirinha();
        a.setVisible(true);
    }//GEN-LAST:event_menucarteirinhaActionPerformed

    private void menuProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProdutoActionPerformed
        CadastroProduto a = new CadastroProduto();
        a.setVisible(true);
    }//GEN-LAST:event_menuProdutoActionPerformed

    private void menuFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFornecedorActionPerformed
       TelaCadastroFornecedor a = new TelaCadastroFornecedor();
       a.setVisible(true);
    }//GEN-LAST:event_menuFornecedorActionPerformed

    private void itemReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReceberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemReceberActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        TelaLog a = new TelaLog();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuSairActionPerformed

 
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemReceber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JMenuItem menuBairro;
    private javax.swing.JMenuItem menuCidade;
    private javax.swing.JMenuItem menuCliente;
    private javax.swing.JMenu menuContas;
    private javax.swing.JMenuItem menuEndereco;
    private javax.swing.JMenuItem menuFornecedor;
    private javax.swing.JMenuItem menuFuncionario;
    private javax.swing.JMenu menuMovimentos;
    private javax.swing.JMenuItem menuProduto;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenuItem menucarteirinha;
    // End of variables declaration//GEN-END:variables
}
