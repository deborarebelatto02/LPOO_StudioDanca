/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.ifsul.cc.lpoo_studiodanca.view;

import br.edu.ifsul.cc.lpoo_studiodanca.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo_studiodanca.dao.model.Modalidade;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author debor
 */
public class TelaModalidadesFinal extends javax.swing.JFrame {

    private PersistenciaJPA jpa;
    private DefaultListModel listModelModalidades;

    /**
     * Creates new form TelaModalidades
     */
    public TelaModalidadesFinal() {
        initComponents();
        jpa = new PersistenciaJPA();
        listModelModalidades = new DefaultListModel<>();
        lstModalidades.setModel(listModelModalidades);
        listarModalidades();
    }

    public void listarModalidades() {
        listModelModalidades.clear();
        List<Modalidade> modalidades = jpa.getModalidades();

        for (Modalidade modalidade : modalidades) {
            listModelModalidades.addElement(modalidade);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        lstModalidades = new javax.swing.JList<>();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Modalidades cadastradas:");

        lstModalidades.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstModalidades);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNovo)
                                .addGap(58, 58, 58)
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRemover))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnRemover))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        String modalidade = JOptionPane.showInputDialog(this, "Insira o nome da nova modalidade:", "Adicionar nova", JOptionPane.PLAIN_MESSAGE);

        if (modalidade != null && !modalidade.trim().isEmpty()) {
            jpa.addModalidade(modalidade);
            listarModalidades();
        } else {
            JOptionPane.showMessageDialog(this, "ERRO! O nome da modalidade não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        String modalidadeSelecionada = lstModalidades.getSelectedValue();

        if (modalidadeSelecionada != null) {

            int confirmacaoDel = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja remover a modalidade " + modalidadeSelecionada);

            if (confirmacaoDel == JOptionPane.YES_OPTION) {
                try {

                    jpa = new PersistenciaJPA();
                    jpa.conexaoAberta();

                    jpa.remover(modalidadeSelecionada);
                    listarModalidades();

                    jpa.fecharConexao();

                } catch (Exception e) {
                    System.err.println("Erro ao excluir modalidade: " + e.getMessage());
                } finally {
                    jpa.fecharConexao();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nenhuma modalidade selecionada!");
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String modalidadeSelecionada = lstModalidades.getSelectedValue();

        if (modalidadeSelecionada != null) {
            try {
                jpa = new PersistenciaJPA();
                jpa.conexaoAberta();

                Modalidade modalidadePersistida = (Modalidade) jpa.find(Modalidade.class, modalidadeSelecionada.toString());
                modalidadePersistida.setDescricao(JOptionPane.showInputDialog(rootPane, "Informe o nome da modalidade", modalidadeSelecionada.toString()));

                jpa.persist(modalidadePersistida);
                listarModalidades();

                jpa.fecharConexao();

            } catch (Exception e) {
                System.err.println("Erro ao editar modalidade: " + e.getMessage());
            } finally {
                jpa.fecharConexao();
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaModalidadesFinal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstModalidades;
    // End of variables declaration//GEN-END:variables
}