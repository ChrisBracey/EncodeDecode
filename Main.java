
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JComboBox;

public class Main 
{

	private static ArrayList<String> arr;
	private static JTextField tf1;
	private static JButton btn;
	private static String str;
	private static JTextField tf2;
	private static JLabel input, output;
	private static JComboBox combo;
	private static String item;


	public static void main(String[] args) 
	{
		arr = new ArrayList<String>();
		tf1 = new JTextField();
		tf1.setBounds(197, 97, 169, 28);
		btn = new JButton("Encode/Decode");
		btn.setBounds(286, 216, 138, 29);
		str = "";
		tf2 = new JTextField();
		tf2.setBounds(197, 139, 169, 28);
		tf2.setEditable(false);

		char[] keyboard = "qwertyuiop[asdfghjkl;zxcvbnm,".toCharArray();
		JFrame frame = new JFrame("Endode/Decode Text");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		input = new JLabel("Input");
		input.setBounds(64, 103, 111, 16);
		frame.getContentPane().add(input);

		String[] strArr = {"Encode", "Decode"};
		combo = new JComboBox(strArr);
		combo.setSelectedIndex(0);
		combo.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					item = (String)combo.getSelectedItem();
				}
			});
		combo.setBounds(100,103,70,16);
		frame.getContentPane().add(combo);
		
		frame.setSize(446, 297);
		output = new JLabel("Encoded/Decoded");
		output.setBounds(64, 145, 111,16);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-446/2, 
			dim.height/2-297/2);

		frame.getContentPane().add(output);
		frame.getContentPane().add(tf1);
		frame.getContentPane().add(btn);
		frame.getContentPane().add(tf2);
		frame.getContentPane().setLayout(null);
		btn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{

				str = "";
				char[] carr = tf1.getText().toLowerCase().toCharArray();

				if(item.equals("Encode"))
				{
					for(int j = 0; j<carr.length; ++j)
					{
						for(int k = 0; k<keyboard.length; ++k)
						{
							if(carr[j]==keyboard[k])
							{
								if(carr[j]=='[')
								{
									carr[j] = 'q';
								} else if(carr[j] == ';')
								{
									carr[j] = 'a';
								} else if(carr[j] == ',')
								{
									carr[j] = 'z';
								} else
									carr[j] = keyboard[k+1];
								break;
							}
						}
					}
				}
				else if(item.equals("Decode")) 
				{
					for(int j = 0; j<carr.length; ++j)
					{
						for(int k = 0; k<keyboard.length; ++k)
						{
							if(carr[j]==keyboard[k])
							{
								if(carr[j]=='q')
								{
									carr[j] = '[';
								} else if(carr[j] == 'a')
								{
									carr[j] = ';';
								} else if(carr[j] == 'z')
								{
									carr[j] = ',';
								} else
									carr[j] = keyboard[k-1];
								break;
							}
						}
					}
				}

				for(int j = 0; j<carr.length; ++j)
				{
					str+=carr[j];
				}

				tf2.setText(str);
			}
		});

		tf1.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
				btn.doClick();
			}
		});

		frame.setVisible(true);
	}
}
