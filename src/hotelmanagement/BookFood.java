/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagement;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author doanvanson
 */
public class BookFood extends javax.swing.JFrame {

    /**
     * Creates new form BookFood
     */
    public BookFood() {
    	setTitle("Hotel Management - DVS");
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

        bookFood = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        lblRoomNumber = new javax.swing.JLabel();
        lblRoomNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        lblItemName = new javax.swing.JLabel();
        lblItemName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        inputRoomNumber = new javax.swing.JTextField();
        inputItemName = new javax.swing.JTextField();
        btnBookFood = new javax.swing.JButton();

        //Frame
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bookFood.setBackground(new java.awt.Color(255, 204, 204));
        lblBookFood = new JLabel("Book Food");
        lblBookFood.setBackground(Color.WHITE);
        lblBookFood.setForeground(Color.WHITE);
        lblBookFood.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 36));

        // lbl content
        lblRoomNumber.setText("Room Number");

        lblItemName.setText("Item Name");

        // Button Back
        btnBack.setFont(new Font("Dialog", Font.BOLD, 16)); 
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-go-back-32.png"))); 
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        // Button Book Food
        btnBookFood.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 24)); 
        btnBookFood.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-tableware-64.png"))); 
        btnBookFood.setText("Book Food");
        btnBookFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_buttonActionPerformed(evt);
            }
        });
        
       

        javax.swing.GroupLayout gl_bookFood = new javax.swing.GroupLayout(bookFood);
        gl_bookFood.setHorizontalGroup(
        	gl_bookFood.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_bookFood.createSequentialGroup()
        			.addContainerGap(285, Short.MAX_VALUE)
        			.addComponent(lblBookFood, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
        			.addGap(160)
        			.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_bookFood.createSequentialGroup()
        			.addGap(187)
        			.addGroup(gl_bookFood.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lblRoomNumber)
        				.addComponent(lblItemName))
        			.addGap(33)
        			.addGroup(gl_bookFood.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(inputItemName)
        				.addComponent(inputRoomNumber, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
        			.addContainerGap(255, Short.MAX_VALUE))
        		.addGroup(Alignment.LEADING, gl_bookFood.createSequentialGroup()
        			.addGap(261)
        			.addComponent(btnBookFood)
        			.addContainerGap(284, Short.MAX_VALUE))
        );
        gl_bookFood.setVerticalGroup(
        	gl_bookFood.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_bookFood.createSequentialGroup()
        			.addGroup(gl_bookFood.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblBookFood, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
        			.addGap(81)
        			.addGroup(gl_bookFood.createParallelGroup(Alignment.BASELINE)
        				.addComponent(inputRoomNumber, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        				.addComponent(lblRoomNumber))
        			.addGap(53)
        			.addGroup(gl_bookFood.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblItemName)
        				.addComponent(inputItemName, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
        			.addGap(65)
        			.addComponent(btnBookFood)
        			.addGap(114))
        );
        bookFood.setLayout(gl_bookFood);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bookFood, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bookFood, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

 // ========= Begin Event Click Button ===========
    
    // Event book_buttonActionPerformed
    private void book_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        String roomNumber, nameItem;
        roomNumber = inputRoomNumber.getText();
        nameItem = inputItemName.getText();
        if(roomNumber.equals("") || nameItem.equals("")){
            JOptionPane.showMessageDialog(null, "Please fill the details");
            return;
        }
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("JDBC:mysql://192.168.64.2:3306/Hotel_Management_System","root","password");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("USE Hotel_Management_System");
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM room");
            int flagRoomPeople = 0, flagHaveRoom = 0;
            while(rs.next()){
                String id = rs.getString("id");
                String occupied = rs.getString("occupied");
                if(roomNumber.equals(id)){
                	flagRoomPeople = 1; flagHaveRoom = 1;
                    if(occupied.equals("0")){
	                    JOptionPane.showMessageDialog(null, "Room is Vacant");
	                    flagRoomPeople = 0;
                    }
                    break;
                }
            }
            if( flagHaveRoom == 0) 
                    JOptionPane.showMessageDialog(null, "Room no. not available");
            rs.close();
            
            ResultSet rsItem = stmt.executeQuery("SELECT * FROM itemRestaurant");
            int flagItemName = 0;
            while(rsItem.next()){
                String itemName = rsItem.getString("itemName");
                if(nameItem.equals(itemName)){
                	flagItemName = 1;
                    break;
                }
            }
            if(flagItemName == 0) 
                    JOptionPane.showMessageDialog(null, "Food Item not available");
            
            if(flagRoomPeople == 1 && flagItemName==1){
                stmt.executeUpdate("INSERT INTO bookfood VALUES(" + roomNumber + ",'" + nameItem + "')");
                ResultSet rsNameGetPrice = stmt.executeQuery("SELECT * FROM itemRestaurant WHERE itemName ='" + nameItem +"'");
                rsNameGetPrice.next();
                String price = rsNameGetPrice.getString("itemPrice");
                int itemPrice = Integer.parseInt(price);
         
                ResultSet rsPriceSetRoom = stmt.executeQuery("SELECT * FROM bookings WHERE checkout IS NULL AND room = " + roomNumber);
                rsPriceSetRoom.next();
                int surchargeSaved = Integer.parseInt(rsPriceSetRoom.getString("surcharge"));
               
                surchargeSaved += itemPrice;

                stmt.executeUpdate("UPDATE bookings SET surcharge = " + surchargeSaved + " WHERE checkout IS NULL AND room = " + roomNumber);
               
                
                
                JOptionPane.showMessageDialog(null, "Food Booked");
                new Restaurant().setVisible(true);
                this.setVisible(false);
            }
            else{
                inputRoomNumber.setText("");
                inputItemName.setText("");
            }
            
            
        }
        catch(  HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e)
        {
            System.out.println("Esception: "+e);
        }
    }

    // Event back_buttonActionPerformed
    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new Restaurant().setVisible(true);
        this.setVisible(false);
    }

    
    //========= End Event Click Button ===========
    
    
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
            java.util.logging.Logger.getLogger(BookFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookFood.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookFood().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBookFood;
    private javax.swing.JTextField inputItemName;
    private javax.swing.JLabel lblRoomNumber;
    private javax.swing.JLabel lblItemName;
    private javax.swing.JPanel bookFood;
    private javax.swing.JTextField inputRoomNumber;
    private JLabel lblBookFood;
    // End of variables declaration
}
