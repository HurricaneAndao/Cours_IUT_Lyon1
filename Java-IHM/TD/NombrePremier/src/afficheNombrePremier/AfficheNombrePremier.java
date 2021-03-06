/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afficheNombrePremier;

/**
 *
 * @author Guillaume
 */
public class AfficheNombrePremier extends javax.swing.JFrame {

    /**
     * Creates new form AfficheNombrePremier
     */
    public AfficheNombrePremier() {
        initComponents();
        listModel = new java.util.ArrayList<>();
        affichageList.setListData(listModel.toArray());  
        saisieNombre.selectAll();
        saisieNombre.requestFocus();
        setLocation(250, 150);
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
        saisieNombre = new javax.swing.JTextField();
        buttonAffiche = new javax.swing.JButton();
        buttonFin = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        affichageList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Affichage de nombre premier");

        jLabel1.setText("Quantité :");

        saisieNombre.setText("0");

        buttonAffiche.setText("Afficher");
        buttonAffiche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afficher(evt);
            }
        });

        buttonFin.setText("Fin");
        buttonFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fin(evt);
            }
        });

        jScrollPane1.setViewportView(affichageList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saisieNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAffiche)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonFin)
                .addContainerGap(108, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(saisieNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAffiche)
                    .addComponent(buttonFin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void afficher(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afficher
        //On vide l'affichage à chaque changement.
        listModel.clear();
        
        //On récupère ce qui est saisie dans saisieNombre.
        String nombreSaisie = saisieNombre.getText();
        
        //On test si c'est un nombre ou des lettres.
        if(isNumeric(nombreSaisie)){
            //nbSaisie transforme en Int le nombre en String.
            int nbSaisie = Integer.parseInt(nombreSaisie);

            //On test si le nombre saisie est négatif.
            if(nbSaisie<0){
                javax.swing.JOptionPane.showMessageDialog(this,"Erreur de saisie (nombre négatif) !","Erreur",javax.swing.JOptionPane.ERROR_MESSAGE);
                listModel.add("Erreur de saisie : Nombre négatif.");
                saisieNombre.selectAll();
                saisieNombre.requestFocus();
            }
            //On test si le nombre saisie est égal à 0.
            if(nbSaisie==0){
                javax.swing.JOptionPane.showMessageDialog(this,"Aucun nombre premier !","Information",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                listModel.add("Aucun nombre premier.");
                saisieNombre.selectAll();
                saisieNombre.requestFocus();
            }
            
            //Si tout est correcte, on génère les nombres premiers, on les stocks et on les affiches.
            String stringNombrePremier = "";
            
            if(nbSaisie>0){
                int nombreAfficher = 0;
                int nombreP = 1;
                
                listModel.add("Voici "+nbSaisie+" nombre(s) premier(s) : ");
                
                //Tant que le nombre de nombres premiers affichés est inferieur au nombre demandé, on génère.
                while(nombreAfficher<nbSaisie){
                    //On test si un nombre est premier ou non, si oui, on le stock.
                    if(estPremier(nombreP)){
                        String nombre = "  "+String.format("%05d", nombreP);
                        stringNombrePremier = stringNombrePremier+nombre;
                        nombreAfficher++;
                    }
                    
                    //On ajoute ici 10 résultats par ligne. 
                    if(nombreAfficher%10==0 && !stringNombrePremier.equals("")){
                      listModel.add(stringNombrePremier);
                      stringNombrePremier="";
                    }
                    nombreP++;
                }
            }
            //Enfin on affiche le résultat de la demande utilisateur.
            listModel.add(stringNombrePremier);
            affichageList.setListData(listModel.toArray());
            saisieNombre.requestFocus();
        } else {
            //Ici on retourne une erreur si des lettres sont saisies à la place de nombres.
             javax.swing.JOptionPane.showMessageDialog(this,"Erreur de saisie !\nMerci de saisir un"
                     + " nombre entier.","Erreur",javax.swing.JOptionPane.ERROR_MESSAGE);
            listModel.add("Erreur de saisie : Entrer un nombre entier.");
            affichageList.setListData(listModel.toArray());
            saisieNombre.selectAll();
            saisieNombre.requestFocus();
        }
        
        
    }//GEN-LAST:event_afficher
    //Fonction de contrôle de saisie, vérifie si un nombre est ben saisie, renvoie true or false.
    public static boolean isNumeric(String str){
        try {
            //On essaie de convertir en Int.
            int nb = Integer.parseInt(str);
        } catch(NumberFormatException nfe){
            //Si l'execption "NumberFormatException" est soulevée, la saisie n'est pas bonne.
            return false;
        }
        //Sinon la saisie est correcte.
        return true;
    }
    
    //Fonction qui vérifie si un nombre est premier ou non.
    public static boolean estPremier(int candidat){
       if(candidat == 1) return false;
       if(candidat != 0 && candidat != 1){
           for(int i = 2; i<=candidat/2; i++){
                if(candidat!=i && candidat%i==0){
                    return false;
                }
            }
        }
        return true;
    }
     
    private void fin(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fin
        // TODO add your handling code here:
        dispose();
        System.exit(0);
    }//GEN-LAST:event_fin

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
            java.util.logging.Logger.getLogger(AfficheNombrePremier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AfficheNombrePremier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AfficheNombrePremier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AfficheNombrePremier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AfficheNombrePremier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList affichageList;
    private javax.swing.JButton buttonAffiche;
    private javax.swing.JButton buttonFin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField saisieNombre;
    // End of variables declaration//GEN-END:variables
    java.util.ArrayList<String> listModel; 
}
