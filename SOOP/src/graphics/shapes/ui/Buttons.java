package graphics.shapes.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import java.awt.Color;
//import java.awt.Dimension;

import javax.swing.SwingConstants;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.OffsetAttributes;
import graphics.shapes.attributes.SelectionAttributes;
//import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.text.html.StyleSheet;

public class Buttons extends JFrame
{

	private JFrame frmPanel;
	private JTextField height;
	private JTextField width;
	private JTextField positionX;
	private JTextField positionY;
	private JTextField txtSoop;
	private int fillColor;
	private int strokeColor;
	private String[] colorList =
	{ "black", "blue", "gray", "green", "orange", "red", "white", "yellow" };
	private boolean onRect = false;
	private boolean onText = false;
	private boolean onCirc = true;
	private SCollection model;
	private ShapesView sview;
	private JTextField textField;
	private String txtSTR;


	public static void affiche(SCollection model, ShapesView sview)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Buttons window = new Buttons(model, sview);
					window.frmPanel.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Buttons(SCollection model, ShapesView sview)
	{
		initialize();
		this.model = model;
		this.sview = sview;
	}


	public int getHeight()
	{
		return Integer.parseInt(this.height.getText());
	}

	public int getWidth()
	{
		return Integer.parseInt(this.width.getText());
	}

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
		frmPanel.setTitle("sOOP Panel");
		frmPanel.setBounds(100, 100, 362, 421);
		frmPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setForeground(Color.WHITE);
		frmPanel.getContentPane().add(layeredPane, BorderLayout.CENTER);

		JButton btnNewButton = new JButton("Add shape");
		btnNewButton.setBounds(117, 336, 97, 25);
		layeredPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				StyleSheet cl = new StyleSheet();
				Color fColor = cl.stringToColor(colorList[fillColor]);
				Color sColor = cl.stringToColor(colorList[strokeColor]);

				if (onCirc && !onText && !onRect)
				{
					SCircle c3 = new SCircle(new Point(getPositionX(), getPositionY()), getHeight() / 2);
					c3.addAttributes(new ColorAttributes(true, true, fColor, sColor));
					c3.addAttributes(new SelectionAttributes());
					c3.addAttributes(new OffsetAttributes());
					model.add(c3);
					sview.paintComponent(sview.getGraphics());
					model.updateBounds(sview.getGraphics());
				}
				else if (!onCirc && onText && !onRect)
				{
					SText t2 = new SText(new Point(getPositionX(), getPositionY()), txtSTR);
					t2.addAttributes(new ColorAttributes(true, true, fColor, sColor));
					t2.addAttributes(new FontAttributes());
					t2.addAttributes(new SelectionAttributes());
					t2.addAttributes(new OffsetAttributes());
					model.add(t2);
					sview.paintComponent(sview.getGraphics());
					model.updateBounds(sview.getGraphics());
				}
				else if (!onCirc && !onText && onRect)
				{
					SRectangle a = new SRectangle(new Point(getPositionX(), getPositionY()), getWidth(), getHeight());
					a.addAttributes(new ColorAttributes(true, true, fColor, sColor));
					a.addAttributes(new SelectionAttributes());
					a.addAttributes(new OffsetAttributes());
					model.add(a);
					sview.paintComponent(sview.getGraphics());
					model.updateBounds(sview.getGraphics());
				}
				else
				{
					System.out.println("SELECT ONE SHAPE !!");
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
					onCirc = true;

				}
				else if (onCirc)
				{
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
					onText = true;
				}
				else if (onText)
				{
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
					onRect = true;
				}
				else if (onRect)
				{
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

		JComboBox colorBox = new JComboBox(this.colorList);
		colorBox.setBounds(165, 196, 156, 25);
		layeredPane.add(colorBox);
		colorBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				fillColor = colorBox.getSelectedIndex();
			}
		});

		JComboBox strokeColorBox = new JComboBox(this.colorList);
		strokeColorBox.setBounds(165, 234, 156, 25);
		layeredPane.add(strokeColorBox);
		strokeColorBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				strokeColor = strokeColorBox.getSelectedIndex();
			}
		});

		JTextPane txtpnColor = new JTextPane();
		txtpnColor.setText("Color :");
		txtpnColor.setEditable(false);
		txtpnColor.setBounds(92, 196, 57, 25);
		layeredPane.add(txtpnColor);

		JTextPane txtpnOutlineColor = new JTextPane();
		txtpnOutlineColor.setText("Stroke Color :");
		txtpnOutlineColor.setEditable(false);
		txtpnOutlineColor.setBounds(58, 234, 91, 25);
		layeredPane.add(txtpnOutlineColor);

		JTextPane txtpnText = new JTextPane();
		txtpnText.setText("Text :");
		txtpnText.setEditable(false);
		txtpnText.setBounds(21, 272, 40, 25);
		layeredPane.add(txtpnText);

		textField = new JTextField();
		textField.setBounds(73, 272, 259, 52);
		layeredPane.add(textField);
		textField.setColumns(10);
		txtSTR = textField.getText();

	}
}
