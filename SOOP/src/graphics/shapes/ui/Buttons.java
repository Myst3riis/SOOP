package graphics.shapes.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Button;
import java.awt.Choice;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Buttons extends JFrame
{

	private JFrame frmPanel;
	private JTextField height;
	private JTextField width;
	private JTextField positionX;
	private JTextField positionY;
	private JTextField txtSoop;
	private boolean onRect = false;
	private boolean onText = false;
	private boolean onCirc = true;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Boutons window = new Boutons();
					window.frmPanel.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	*/
	public static void affiche(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Buttons window = new Buttons();
					window.frmPanel.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Buttons()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public int getHeight()
	{
		return Integer.parseInt(this.height.getText());
	}

	public int getWidth()
	{
		return Integer.parseInt(this.width.getText());
	}
	/*
	public String getPosition()
	{
		return this.position.getText();
	}
	*/
	public int getPositionX()
	{
		return Integer.parseInt(this.positionX.getText());
	}
	public int getPositionY()
	{
		return Integer.parseInt(this.positionY.getText());
	}
	
	

	private void initialize()
	{
		frmPanel = new JFrame();
		frmPanel.setForeground(Color.WHITE);
		frmPanel.setTitle("Panel");
		frmPanel.setBounds(100, 100, 362, 266);
		frmPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setForeground(Color.WHITE);
		frmPanel.getContentPane().add(layeredPane, BorderLayout.CENTER);

		JButton btnNewButton = new JButton("Add shape");
		btnNewButton.setBounds(117, 189, 97, 25);
		layeredPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				if (onCirc && !onText && !onRect)
				{
					System.out.println("ADD CERCLE (" + getPositionX()+","+getPositionY()+")" + getWidth() +","+ getHeight());

				}
				else if (!onCirc && onText && !onRect)
				{
					System.out.println("ADD TEXT (" + getPositionX()+","+getPositionY()+")" + getWidth() +","+ getHeight());

				}
				else if (!onCirc && !onText && onRect)
				{
					System.out.println("ADD RECTANGLE (" + getPositionX()+","+getPositionY()+")" + getWidth() +","+ getHeight());
					getWidth();
					getHeight();
					getPositionX();
					getPositionY();

				}
				else
				{
					System.out.println("Select one shape !");
				}
			}
		});

		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.setSelected(true);
		tglbtnCircle.setBounds(117, 143, 91, 25);
		layeredPane.add(tglbtnCircle);
		tglbtnCircle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				if (!onCirc)
				{
					// System.out.println("CERCLE ON !!");
					onCirc = true;

				}
				else if (onCirc)
				{
					// System.out.println("CERCLE OFF !!");
					onCirc = false;
				}

			}
		});

		JToggleButton tglbtnText = new JToggleButton("Text");
		tglbtnText.setBounds(219, 143, 91, 25);
		layeredPane.add(tglbtnText);
		tglbtnText.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				if (!onText)
				{
					// System.out.println("TEXTE ON !!");
					onText = true;

				}
				else if (onText)
				{
					// System.out.println("TEXTE OFF !!");
					onText = false;
				}

			}
		});

		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.setBounds(12, 143, 93, 25);
		layeredPane.add(tglbtnRectangle);
		tglbtnRectangle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				if (!onRect)
				{
					// System.out.println("RECTANGLE ON !!");
					onRect = true;

				}
				else if (onRect)
				{
					// System.out.println("RECTANGLE OFF !!");
					onRect = false;
				}
			}
		});

		height = new JTextField();
		height.setBounds(92, 78, 57, 22);
		layeredPane.add(height);
		height.setColumns(10);

		width = new JTextField();
		width.setBounds(251, 78, 62, 22);
		layeredPane.add(width);
		width.setColumns(10);

		JTextPane txtpnHeight = new JTextPane();
		txtpnHeight.setEditable(false);
		txtpnHeight.setText("Height :");
		txtpnHeight.setBounds(35, 78, 57, 25);
		layeredPane.add(txtpnHeight);

		JTextPane txtpnWidth = new JTextPane();
		txtpnWidth.setEditable(false);
		txtpnWidth.setText("Width :");
		txtpnWidth.setBounds(197, 78, 57, 25);
		layeredPane.add(txtpnWidth);

		positionX = new JTextField();
		positionX.setColumns(10);
		positionX.setBounds(165, 105, 30, 22);
		layeredPane.add(positionX);

		JTextPane txtpnPosition = new JTextPane();
		txtpnPosition.setText("Position :  X :");
		txtpnPosition.setEditable(false);
		txtpnPosition.setBounds(73, 105, 91, 25);
		layeredPane.add(txtpnPosition);

		txtSoop = new JTextField();
		txtSoop.setEditable(false);
		txtSoop.setFont(new Font("HelveticaNeueLT Std Lt", Font.PLAIN, 57));
		txtSoop.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoop.setText("sOOP");
		txtSoop.setBounds(12, 0, 320, 75);
		layeredPane.add(txtSoop);
		txtSoop.setColumns(10);
		
		positionY = new JTextField();
		positionY.setColumns(10);
		positionY.setBounds(238, 105, 30, 22);
		layeredPane.add(positionY);
		
		JTextPane txtpnY = new JTextPane();
		txtpnY.setText("Y :");
		txtpnY.setEditable(false);
		txtpnY.setBounds(207, 105, 30, 25);
		layeredPane.add(txtpnY);
	}

	private static void addPopup(Component component, final JPopupMenu popup)
	{
		component.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				if (e.isPopupTrigger())
				{
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e)
			{
				if (e.isPopupTrigger())
				{
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e)
			{
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
