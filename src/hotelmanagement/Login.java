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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

/**
 *
 * @author doanvanson
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
	private JFrame frame; // show message DiaLog
    public Login() {
    	setTitle("Hotel Management - DVS");
    	
    	connectSQL();
    	initComponents();
        
    }

    // Create DataBase Default
    private void connectSQL(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.64.2:3306/","root","password");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS Hotel_Management_System");
            stmt.executeUpdate("USE Hotel_Management_System");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS staff (id int NOT NULL PRIMARY KEY auto_increment, name varchar(20) NOT NULL, contact varchar(20) NOT NULL, codeStaff varchar(20) NOT NULL, username  varchar(20) NOT NULL UNIQUE, password  varchar(20) NOT NULL, role varchar(20) NOT NULL);");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS customer (codeCustomer  varchar(20) PRIMARY KEY, name varchar(20) NOT NULL, contact varchar(20) NOT NULL, address varchar(30));");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS bookings (id int primary key auto_increment, codeCustomer  varchar(20) not null, number_of_persons int NOT NULL, room int NOT NULL, checkin varchar(30) not null, checkout varchar(30), surcharge int DEFAULT 0);");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS room (id int NOT NULL PRIMARY KEY, beds int NOT NULL, capacity int NOT NULL, price int NOT NULL, occupied int NOT NULL );");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS itemRestaurant (itemName varchar(20) NOT NULL, itemPrice varchar(20) NOT NULL);");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS bookfood (room int NOT NULL, itemName varchar(20) NOT NULL);");
            
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM staff");
            rs.next();
            String count = rs.getString("COUNT(*)");
            if(count.equals("0")){
            	// Login Default Account Admin with username = admin && password = admin
                stmt.executeUpdate("INSERT INTO staff(name, contact, codeStaff, username, password, role) values('administrator','0','0','admin','admin','admin');");
            }
            
            rs = stmt.executeQuery("SELECT COUNT(*) FROM room;");
            rs.next();
            count = rs.getString("COUNT(*)");
            if(count.equals("0")){
                stmt.executeUpdate("INSERT INTO room VALUES(101,1,1,500,0);");
                stmt.executeUpdate("INSERT INTO room VALUES(102,2,2,900,0);");
                stmt.executeUpdate("INSERT INTO room VALUES(103,1,2,800,0);");
                stmt.executeUpdate("INSERT INTO room VALUES(104,2,4,1600,0);");
                stmt.executeUpdate("INSERT INTO room VALUES(201,1,1,800,0);");
                stmt.executeUpdate("INSERT INTO room VALUES(202,1,2,1500,0);");
                stmt.executeUpdate("INSERT INTO room VALUES(203,3,6,2500,0);");
                stmt.executeUpdate("INSERT INTO room VALUES(204,4,4,3500,0);");
                stmt.executeUpdate("INSERT INTO room VALUES(301,2,3,1600,0);");
                stmt.executeUpdate("INSERT INTO room VALUES(302,2,2,2000,0);");
                stmt.executeUpdate("INSERT INTO room VALUES(303,5,6,4000,0);");
                stmt.executeUpdate("INSERT INTO room VALUES(304,4,6,4800,0);");
            }
            
            rs = stmt.executeQuery("SELECT COUNT(*) FROM itemRestaurant;");
            rs.next();
            count = rs.getString("COUNT(*)");
            if(count.equals("0")){
                stmt.executeUpdate("INSERT INTO itemRestaurant VALUES('banh mi', '5000');");
                stmt.executeUpdate("INSERT INTO itemRestaurant VALUES('pho', '20000');");
                stmt.executeUpdate("INSERT INTO itemRestaurant VALUES('piza', '50000');");
            }
        }
        catch(  HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Exception" + e);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    
    private void initComponents() {

        Login = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        inputUsername = new javax.swing.JTextField();
        inputPassword = new javax.swing.JPasswordField();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblHotelManagement = new javax.swing.JLabel();
        lblEmployeeLogin = new javax.swing.JLabel();

        // frame
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Login.setBackground(new java.awt.Color(255, 204, 204));
        
        // lbl content
        lblHotelManagement.setFont(new java.awt.Font("Vivaldi", 3, 48)); 
        lblHotelManagement.setText("Hotel Management");
        lblHotelManagement.setIconTextGap(5);

        lblEmployeeLogin.setFont(new java.awt.Font("Museo Sans For Dell", 1, 24)); 
        lblEmployeeLogin.setText("Employee Login");
        
        lblUsername.setFont(new java.awt.Font("Kristen ITC", 1, 18)); 
        lblUsername.setText("Username");

        lblPassword.setFont(new java.awt.Font("Kristen ITC", 1, 18));
        lblPassword.setText("Password");

        // Button Login
        btnLogin.setFont(new Font("Dialog", Font.BOLD, 22)); 
        btnLogin.setText("login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_buttonActionPerformed(evt);
            }
        });

      
        javax.swing.GroupLayout gl_Login = new javax.swing.GroupLayout(Login);
        gl_Login.setHorizontalGroup(
        	gl_Login.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_Login.createSequentialGroup()
        			.addContainerGap(248, Short.MAX_VALUE)
        			.addComponent(lblHotelManagement, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)
        			.addGap(195))
        		.addGroup(gl_Login.createSequentialGroup()
        			.addContainerGap(318, Short.MAX_VALUE)
        			.addGroup(gl_Login.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblUsername)
        				.addComponent(lblPassword))
        			.addGap(40)
        			.addGroup(gl_Login.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(inputUsername)
        				.addComponent(inputPassword, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
        			.addGap(290))
        		.addGroup(Alignment.LEADING, gl_Login.createSequentialGroup()
        			.addGap(397)
        			.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(427, Short.MAX_VALUE))
        		.addGroup(gl_Login.createSequentialGroup()
        			.addContainerGap(370, Short.MAX_VALUE)
        			.addComponent(lblEmployeeLogin, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
        			.addGap(342))
        );
        gl_Login.setVerticalGroup(
        	gl_Login.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_Login.createSequentialGroup()
        			.addGap(22)
        			.addComponent(lblHotelManagement, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
        			.addComponent(lblEmployeeLogin, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(gl_Login.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblUsername)
        				.addComponent(inputUsername, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
        			.addGap(22)
        			.addGroup(gl_Login.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblPassword)
        				.addComponent(inputPassword, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
        			.addGap(46)
        			.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        			.addGap(96))
        );
        Login.setLayout(gl_Login);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(Login, GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(Login, GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);

        pack();
    }
    
    
    // ========= Begin Event Click Button ===========
    
    // Event login_buttonActionPerformed
    private void login_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String username = inputUsername.getText();
        String password = String.valueOf(inputPassword.getPassword());
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.64.2:3306/Hotel_Management_System","root","password");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("USE Hotel_Management_System");
            ResultSet rs = stmt.executeQuery("SELECT * FROM staff");
            
            int flag = 0;
            while(rs.next()){
                String user = rs.getString("username");
                String pass = rs.getString("password");
                if(username.equals(user) && password.equals(pass)){
                    flag = 1;
                    break;
                }
            }
            
            rs.close();
            if( flag == 1){
                new MainScreen().setVisible(true);
                this.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(frame, "Invalid Username or Password");
                inputUsername.setText("");
                inputPassword.setText("");
            }
        }
        catch(  HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e)
        {
            System.out.println("Esception: " + e);
        }
        
    }
    
    //========= End Event Click Button ===========

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblHotelManagement;
    private javax.swing.JLabel lblEmployeeLogin;
    private javax.swing.JPanel Login;
    private javax.swing.JButton btnLogin;
    private javax.swing.JPasswordField inputPassword;
    private javax.swing.JTextField inputUsername;
    // End of variables declaration  
}