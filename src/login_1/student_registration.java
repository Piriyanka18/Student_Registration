package login_1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class student_registration {

	private JFrame frame;
	private JTextField id;
	private JTextField name;
	private JTextField contactno;
	private JTextField course;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_registration window = new student_registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public student_registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Registration");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(238, 22, 267, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(22, 85, 74, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(22, 120, 74, 24);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Contact No");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(22, 155, 74, 24);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Course");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(22, 190, 74, 24);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		id = new JTextField();
		id.setBounds(103, 88, 174, 20);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(103, 123, 174, 20);
		frame.getContentPane().add(name);
		
		contactno = new JTextField();
		contactno.setColumns(10);
		contactno.setBounds(103, 158, 174, 20);
		frame.getContentPane().add(contactno);
		
		course = new JTextField();
		course.setColumns(10);
		course.setBounds(103, 193, 174, 20);
		frame.getContentPane().add(course);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(333, 68, 441, 382);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				
					id.setText(model.getValueAt(i, 0).toString());
					name.setText(model.getValueAt(i, 1).toString());
					contactno.setText(model.getValueAt(i, 2).toString());
					course.setText(model.getValueAt(i, 3).toString());
					
				
			}
		});
		table.setBackground(new Color(240, 255, 240));
		model = new DefaultTableModel();
		Object[] column= {"ID","Name","Contact","Course"};
		Object[] row =new Object[4];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(id.getText().equals("") || name.getText().equals("") || contactno.getText().equals("")||
						course.getText().equals("")) 
				{
					JOptionPane.showMessageDialog(null, "Plese Fill Complete Information");
				}
				else {
					row[0] = id.getText();
					row[1] = name.getText();
					row[2] = contactno.getText();
					row[3] = course.getText();
					model.addRow(row);
					
					id.setText("");
					name.setText("");
					contactno.setText("");
					course.setText("");
					
					JOptionPane.showMessageDialog(null, "Saved Sucessfully");
				}
				
				
				
			}
		});
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(22, 317, 94, 34);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				  if(i>=0) {
					  model.setValueAt(id.getText(), i, 0);
						model.setValueAt(name.getText(), i, 1);
						model.setValueAt(contactno.getText(), i, 2);
						model.setValueAt(course.getText(), i, 3);
						JOptionPane.showMessageDialog(null, "Updated Sucessfully");
				  }
				  else {
					  JOptionPane.showMessageDialog(null, "Please Select a Row First");
				  }
					
					
				
			}
		});
		btnUpdate.setBackground(SystemColor.inactiveCaption);
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUpdate.setBounds(168, 317, 94, 34);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0) {
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Deleted Sucessfully");
				}
				else {
					JOptionPane.showMessageDialog(null, "Please Select a Row First");
				}
				
			}
		});
		btnDelete.setBackground(SystemColor.inactiveCaption);
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDelete.setBounds(22, 379, 94, 34);
		frame.getContentPane().add(btnDelete);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setText("");
				name.setText("");
				contactno.setText("");
				course.setText("");
			}
		});
		btnClear.setBackground(SystemColor.inactiveCaption);
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnClear.setBounds(168, 379, 94, 34);
		frame.getContentPane().add(btnClear);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\project\\Java\\images\\login-backgrounds-128292-582669-5455043.png"));
		lblNewLabel_2.setBounds(0, 0, 784, 461);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
