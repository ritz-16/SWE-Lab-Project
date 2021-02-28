/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ritwik Basak
 */
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import javax.swing.*;
public class HomePageUI extends javax.swing.JFrame {
    private DisplayManager dispMgr;
    private SystemManager sysMgr;
    /**
     * Creates new form HomePageUI
     */
    private void displayText(String filename){
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollableTextArea = new JScrollPane(textArea);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        try(FileReader file = new FileReader(SystemManager.FILE_PATH + filename + ".txt");
            BufferedReader reader = new BufferedReader(file)){
            String oneLine;
            while((oneLine = reader.readLine()) != null){
                textArea.append(oneLine + "\n");
            }
            JFrame frame = new JFrame(filename);
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    if(filename.equals("About")) aboutButton.setEnabled(true);
                    if(filename.equals("Contact Us")) contactButton.setEnabled(true);
                    frame.dispose();
                }
            });
            frame.getContentPane().setLayout(new java.awt.GridLayout(1, 1));
            frame.getContentPane().add(scrollableTextArea);
            frame.setVisible(true);
        }
        catch(IOException e){
            if(filename.equals("About")) aboutButton.setEnabled(true);
            if(filename.equals("Contact Us")) contactButton.setEnabled(true);
            dispMgr.showError(e.getMessage());
        }
    }
    public HomePageUI(SystemManager sysMgr, DisplayManager dispMgr) {
        lookSettingCode();
        this.dispMgr = dispMgr;
        this.sysMgr = sysMgr;
        
        addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    
                    setVisible(false);
                    sysMgr.closeProgram();
                }
            }
        );
        
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

        jLabel1 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        RegisterButton = new javax.swing.JButton();
        contactButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("HOME PAGE");

        loginButton.setText("Login");
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButtonMouseClicked(evt);
            }
        });

        RegisterButton.setText("Register");
        RegisterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegisterButtonMouseClicked(evt);
            }
        });

        contactButton.setText("Contact Us");
        contactButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contactButtonMouseClicked(evt);
            }
        });

        aboutButton.setText("About");
        aboutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(RegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 135, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(contactButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aboutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(loginButton)
                .addGap(18, 18, 18)
                .addComponent(RegisterButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contactButton)
                    .addComponent(aboutButton))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutButtonMouseClicked
        // TODO add your handling code here:
        if(aboutButton.isEnabled()){
            aboutButton.setEnabled(false);
            displayText("About");
        }
    }//GEN-LAST:event_aboutButtonMouseClicked

    private void contactButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactButtonMouseClicked
        // TODO add your handling code here:
        if(contactButton.isEnabled()){
            contactButton.setEnabled(false);
            displayText("Contact Us");
        }
    }//GEN-LAST:event_contactButtonMouseClicked

    private void loginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        dispMgr.showLoginUI(true);
    }//GEN-LAST:event_loginButtonMouseClicked

    private void RegisterButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegisterButtonMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        dispMgr.showRegister(true);
    }//GEN-LAST:event_RegisterButtonMouseClicked

    private void lookSettingCode(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {}
    }
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePageUI().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RegisterButton;
    private javax.swing.JButton aboutButton;
    private javax.swing.JButton contactButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginButton;
    // End of variables declaration//GEN-END:variables
}
