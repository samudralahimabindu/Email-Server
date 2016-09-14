import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.*;

public class Game2048 extends JFrame implements KeyListener
{
	public static JButton jb[][]=new JButton[4][4];
	public static JButton b1,b2,b3,b4;
	public static JLabel jl,jl1;
	//public static JFrame jf;
	public Container cp;
	public int score=0;
	public Game2048()
	{
		//jf=new JFrame();
		setSize(400,400);
		setTitle("2048");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		cp=getContentPane();
		//jf.getContentPane().add(panel);
		cp.add(panel);
		GridLayout layout = new GridLayout(5,4);
		panel.setLayout(layout);
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				jb[i][j]=new JButton();
				jb[i][j].addKeyListener(this);
				jb[i][j].setPreferredSize(new Dimension(50,50));
				panel.add(jb[i][j]);
			}
		}
		jl=new JLabel("Score:"+Integer.toString(score));panel.add(jl);
		jl1=new JLabel();panel.add(jl1);
		panel.addKeyListener(this);
		//pack();
		setResizable(false);
		num_generator();
		num_generator();
	}	
	public void num_generator()
	{
		Random r=new Random();
		int n=r.nextInt(4)+0;
		int n1=r.nextInt(4)+0;
		int cnt=0;
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(!(jb[i][j].getText().equals("")))
					cnt++;
			}
		}
		if(cnt<16)
		{
			if(jb[n][n1].getText().equals(""))
			{
				jb[n][n1].setText("2");
			}
			else
				num_generator();	
		}
	}
	public void keyTyped(KeyEvent ke)
	{
	}
	public void keyPressed(KeyEvent ke)
	{
		if(ke.getKeyCode() == KeyEvent.VK_UP)
		{
			update("Up");
			jl.setText("Score:"+Integer.toString(score));
		}
		if(ke.getKeyCode() == KeyEvent.VK_DOWN)
		{
			update("Down");
		}
		if(ke.getKeyCode() == KeyEvent.VK_LEFT)
		{
			update("Left");
		}
		if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			update("Right");
		}
	}
	public void keyReleased(KeyEvent ke)
	{
	}
	public void update(String str)
	{
		if(str.equals("Up"))
			direction('u');
		if(str.equals("Down"))
			direction('d');
		if(str.equals("Left"))
			direction('l');
		if(str.equals("Right"))
			direction('r');
		num_generator();
	}
	public void direction(char dir)
	{
		if(dir=='r')
		{
			for(int i=0;i<4;i++)
			{
				String str1=jb[i][0].getText();
				String str2=jb[i][1].getText();
				String str3=jb[i][2].getText();
				String str4=jb[i][3].getText();
				if(str4.equals(str3))
				{
					if(str4.equals(""))
					{
						if(str1.equals(str2) && !str1.equals(""))
						{
							int n=Integer.parseInt(str1);
							jb[i][3].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[i][1].setText("");
							jb[i][0].setText("");
						}
						else if(!str1.equals(str2))
						{
							if(!str1.equals("") && !str2.equals(""))
							{
								jb[i][3].setText(jb[i][1].getText());
								jb[i][2].setText(jb[i][0].getText());
								jb[i][1].setText("");
								jb[i][0].setText("");
							}
							else if(str1.equals("") && !str2.equals(""))
							{
								jb[i][3].setText(jb[i][1].getText());
								jb[i][1].setText("");
							}
							else if(!str1.equals("") && str2.equals(""))
							{
								jb[i][3].setText(jb[i][0].getText());
								jb[i][0].setText("");
							}
						}
					}
					else if(!str4.equals(""))
					{
						int n=Integer.parseInt(str4);
						jb[i][3].setText(Integer.toString(n*2));
						score=score+(n*2);
						if((str2.equals(str1) && !str2.equals("")))
						{
							n=Integer.parseInt(str2);
							jb[i][2].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[i][1].setText("");
							jb[i][0].setText("");
						}
						else if(!str2.equals("") && !str1.equals(""))
						{
							jb[i][2].setText(jb[i][1].getText());
							jb[i][1].setText(jb[i][0].getText());
							jb[i][0].setText("");
						}
						else if(!str2.equals("") && str1.equals(""))
						{
							jb[i][2].setText(jb[i][1].getText());
							jb[i][1].setText("");
						}
						else if(str2.equals("") && !str1.equals(""))
						{
							jb[i][2].setText(jb[i][0].getText());
							jb[i][0].setText("");
						}
						else if(str2.equals("") && str1.equals(""))
						{
							jb[i][2].setText("");
						}
					}
				}
				else if(!str4.equals(str3))
				{
					if(!str4.equals("") && !str3.equals(""))
					{
						if(str1.equals(str2) && !str1.equals(""))
						{
							int n=Integer.parseInt(str1);
							jb[i][1].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[i][0].setText("");
						}
						else if(str2.equals("")&&str3.equals(str1))
						{
							int n=Integer.parseInt(str1);
							jb[i][2].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[i][0].setText("");
						}
						else if(str2.equals(""))
						{
							jb[i][1].setText(jb[i][0].getText());
							jb[i][0].setText("");
						}
						else if(str2.equals(str3))
						{
							int n=Integer.parseInt(str2);
							jb[i][2].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[i][1].setText(jb[i][0].getText());
							jb[i][0].setText("");
						}
					}
					else if(str4.equals("") && !str3.equals(""))
					{
						if(str3.equals(str2))
						{
							int n=Integer.parseInt(str2);
							jb[i][3].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[i][2].setText(jb[i][0].getText());
							jb[i][1].setText("");
							jb[i][0].setText("");
						}
						else if(str2.equals(str1) && !str2.equals(""))
						{
							jb[i][3].setText(jb[i][2].getText());
							int n=Integer.parseInt(str2);
							score=score+(n*2);
							jb[i][2].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[i][1].setText("");
							jb[i][0].setText("");
						}
						else if(str2.equals(""))
						{
							if(str3.equals(str1))
							{
								int n=Integer.parseInt(str1);
								jb[i][3].setText(Integer.toString(n*2));
								score=score+(n*2);
								jb[i][2].setText("");
								jb[i][0].setText("");
							}
							else
							{
								jb[i][3].setText(jb[i][2].getText());
								jb[i][2].setText(jb[i][0].getText());
								jb[i][0].setText("");
							}
						}
						else
						{
							jb[i][3].setText(jb[i][2].getText());
							jb[i][2].setText(jb[i][1].getText());
							jb[i][1].setText(jb[i][0].getText());
							jb[i][0].setText("");
						}	
					}
					else if(!str4.equals("") && str3.equals(""))
					{
						if(str2.equals(str1) && !str2.equals(""))
						{
							int n=Integer.parseInt(str2);
							jb[i][2].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[i][1].setText("");
							jb[i][0].setText("");
						}
						else if(str4.equals(str2))
						{
							int n=Integer.parseInt(str2);
							jb[i][3].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[i][2].setText(jb[i][0].getText());
							jb[i][1].setText("");
							jb[i][0].setText("");
						}
						else if(str2.equals(""))
						{
							if(str4.equals(str1))
							{
								int n=Integer.parseInt(str1);
								jb[i][3].setText(Integer.toString(n*2));
								score=score+(n*2);
								jb[i][2].setText("");
								jb[i][0].setText("");
							}
							else
							{
								jb[i][2].setText(jb[i][0].getText());
								jb[i][0].setText("");
							}
						}
						else
						{
							jb[i][2].setText(jb[i][1].getText());
							jb[i][1].setText(jb[i][0].getText());
							jb[i][0].setText("");
						}
					}
				}
			}			
		}
		if(dir=='l')
		{
			for(int i=0;i<4;i++)
			{
				String str1=jb[i][0].getText();
				String str2=jb[i][1].getText();
				String str3=jb[i][2].getText();
				String str4=jb[i][3].getText();
				if(str1.equals(str2))
				{
					if(str1.equals(""))
					{
						if(str4.equals(str3) && !str4.equals(""))
						{
							int n=Integer.parseInt(str4);
							jb[i][0].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[i][2].setText("");
							jb[i][3].setText("");
						}
						else if(!str4.equals(str3))
						{
							if(!str4.equals("") && !str3.equals(""))
							{
								jb[i][0].setText(jb[i][2].getText());
								jb[i][1].setText(jb[i][3].getText());
								jb[i][2].setText("");
								jb[i][3].setText("");
							}
							else if(str4.equals("") && !str3.equals(""))
							{
								jb[i][0].setText(jb[i][2].getText());
								jb[i][2].setText("");
							}
							else if(!str4.equals("") && str3.equals(""))
							{
								jb[i][0].setText(jb[i][3].getText());
								jb[i][3].setText("");
							}
						}
					}
					else if(!str1.equals(""))
					{
					int n=Integer.parseInt(str1);
					jb[i][0].setText(Integer.toString(n*2));
					score=score+(n*2);
					if((str3.equals(str4) && !str3.equals("")))
					{
						n=Integer.parseInt(str3);
						jb[i][1].setText(Integer.toString(n*2));
						score=score+(n*2);
						jb[i][2].setText("");
						jb[i][3].setText("");
					}
					else if(!str3.equals("") && !str4.equals(""))
					{
						jb[i][1].setText(jb[i][2].getText());
						jb[i][2].setText(jb[i][3].getText());
						jb[i][3].setText("");
					}
					else if(!str3.equals("") && str4.equals(""))
					{
						jb[i][1].setText(jb[i][2].getText());
						jb[i][2].setText("");
					}
					else if(str3.equals("") && !str4.equals(""))
					{
						jb[i][1].setText(jb[i][3].getText());
						jb[i][3].setText("");
					}
					else if(str3.equals("") && str4.equals(""))
					{
						jb[i][1].setText("");
					}
					}
				}
				else if(!str1.equals(str2))
				{
					if(!str1.equals("") && !str2.equals(""))
					{
						if(str4.equals(str3) && !str4.equals(""))
						{
							int n=Integer.parseInt(str4);
							jb[i][2].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[i][3].setText("");
						}
						else if(str3.equals("")&&str2.equals(str4))
						{
							int n=Integer.parseInt(str4);
							jb[i][1].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[i][3].setText("");
						}
						else if(str3.equals(""))
						{
							jb[i][2].setText(jb[i][3].getText());
							jb[i][3].setText("");
						}
						else if(str3.equals(str2))
						{
							int n=Integer.parseInt(str3);
							jb[i][1].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[i][2].setText(jb[i][3].getText());
							jb[i][3].setText("");
						}
					}
					else if(str1.equals("") && !str2.equals(""))
					{
						if(str2.equals(str3))
						{
							int n=Integer.parseInt(str3);
							jb[i][0].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[i][1].setText(jb[i][3].getText());
							jb[i][2].setText("");
							jb[i][3].setText("");
						}
						else if(str3.equals(str4) && !str3.equals(""))
						{
							jb[i][0].setText(jb[i][1].getText());
							int n=Integer.parseInt(str3);
							jb[i][1].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[i][2].setText("");
							jb[i][3].setText("");
						}
						else if(str3.equals(""))
						{
							if(str2.equals(str4))
							{
								int n=Integer.parseInt(str4);
								jb[i][0].setText(Integer.toString(n*2));
								score=score+(n*2);
								jb[i][1].setText("");
								jb[i][3].setText("");
							}
							else
							{
								jb[i][0].setText(jb[i][1].getText());
								jb[i][1].setText(jb[i][3].getText());
								jb[i][3].setText("");
							}
						}
						else
						{
							jb[i][0].setText(jb[i][1].getText());
							jb[i][1].setText(jb[i][2].getText());
							jb[i][2].setText(jb[i][3].getText());
							jb[i][3].setText("");
						}	
					}
					else if(!str1.equals("") && str2.equals(""))
					{
						if(str3.equals(str4) && !str3.equals(""))
						{
							int n=Integer.parseInt(str3);
							jb[i][1].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[i][2].setText("");
							jb[i][3].setText("");
						}
						else if(str1.equals(str3))
						{
							int n=Integer.parseInt(str3);
							jb[i][0].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[i][1].setText(jb[i][3].getText());
							jb[i][2].setText("");
							jb[i][3].setText("");
						}
						else if(str3.equals(""))
						{
							if(str1.equals(str4))
							{
								int n=Integer.parseInt(str4);
								jb[i][0].setText(Integer.toString(n*2));
								score=score+(n*2);
								jb[i][1].setText("");
								jb[i][3].setText("");
							}
							else
							{
								jb[i][1].setText(jb[i][3].getText());
								jb[i][3].setText("");
							}
						}
						else
						{
							jb[i][1].setText(jb[i][2].getText());
							jb[i][2].setText(jb[i][3].getText());
							jb[i][3].setText("");
						}
					}
				}
			}			
		}
		if(dir=='d')
		{
			for(int i=0;i<4;i++)
			{
				String str1=jb[0][i].getText();
				String str2=jb[1][i].getText();
				String str3=jb[2][i].getText();
				String str4=jb[3][i].getText();
				if(str4.equals(str3))
				{
					if(str4.equals(""))
					{
						if(str1.equals(str2) && !str1.equals(""))
						{
							int n=Integer.parseInt(str1);
							jb[3][i].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[1][i].setText("");
							jb[0][i].setText("");
						}
						else if(!str1.equals(str2))
						{
							if(!str1.equals("") && !str2.equals(""))
							{
								jb[3][i].setText(jb[1][i].getText());
								jb[2][i].setText(jb[0][i].getText());
								jb[1][i].setText("");
								jb[0][i].setText("");
							}
							else if(str1.equals("") && !str2.equals(""))
							{
								jb[3][i].setText(jb[1][i].getText());
								jb[1][i].setText("");
							}
							else if(!str1.equals("") && str2.equals(""))
							{
								jb[3][i].setText(jb[0][i].getText());
								jb[0][i].setText("");
							}
						}
					}
					else if(!str4.equals(""))
					{
					int n=Integer.parseInt(str4);
					jb[3][i].setText(Integer.toString(n*2));
					score=score+(n*2);
					if((str2.equals(str1) && !str2.equals("")))
					{
						n=Integer.parseInt(str2);
						jb[2][i].setText(Integer.toString(n*2));
						score=score+(n*2);
						jb[1][i].setText("");
						jb[0][i].setText("");
					}
					else if(!str2.equals("") && !str1.equals(""))
					{
						jb[2][i].setText(jb[1][i].getText());
						jb[1][i].setText(jb[0][i].getText());
						jb[0][i].setText("");
					}
					else if(!str2.equals("") && str1.equals(""))
					{
						jb[2][i].setText(jb[1][i].getText());
						jb[1][i].setText("");
					}
					else if(str2.equals("") && !str1.equals(""))
					{
						jb[2][i].setText(jb[0][i].getText());
						jb[0][i].setText("");
					}
					else if(str2.equals("") && str1.equals(""))
					{
						jb[2][i].setText("");
					}
					}
				}
				else if(!str4.equals(str3))
				{
					if(!str4.equals("") && !str3.equals(""))
					{
						if(str1.equals(str2) && !str1.equals(""))
						{
							int n=Integer.parseInt(str1);
							jb[1][i].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[0][i].setText("");
						}
						else if(str2.equals("")&&str3.equals(str1))
						{
							int n=Integer.parseInt(str1);
							jb[2][i].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[0][i].setText("");
						}
						else if(str2.equals(""))
						{
							jb[1][i].setText(jb[0][i].getText());
							jb[0][i].setText("");
						}
						else if(str2.equals(str3))
						{
							int n=Integer.parseInt(str2);
							jb[2][i].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[1][i].setText(jb[0][i].getText());
							jb[0][i].setText("");
						}
					}
					else if(str4.equals("") && !str3.equals(""))
					{
						if(str3.equals(str2))
						{
							int n=Integer.parseInt(str2);
							jb[3][i].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[2][i].setText(jb[0][i].getText());
							jb[1][i].setText("");
							jb[0][i].setText("");
						}
						else if(str2.equals(str1) && !str2.equals(""))
						{
							jb[3][i].setText(jb[2][i].getText());
							int n=Integer.parseInt(str2);
							jb[2][i].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[1][i].setText("");
							jb[0][i].setText("");
						}
						else if(str2.equals(""))
						{
							if(str3.equals(str1))
							{
								int n=Integer.parseInt(str1);
								jb[3][i].setText(Integer.toString(n*2));
								score=score+(n*2);
								jb[2][i].setText("");
								jb[0][i].setText("");
							}
							else
							{
								jb[3][i].setText(jb[2][i].getText());
								jb[2][i].setText(jb[0][i].getText());
								jb[0][i].setText("");
							}
						}
						else
						{
							jb[3][i].setText(jb[2][i].getText());
							jb[2][i].setText(jb[1][i].getText());
							jb[1][i].setText(jb[0][i].getText());
							jb[0][i].setText("");
						}	
					}
					else if(!str4.equals("") && str3.equals(""))
					{
						if(str2.equals(str1) && !str2.equals(""))
						{
							int n=Integer.parseInt(str2);
							jb[2][i].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[1][i].setText("");
							jb[0][i].setText("");
						}
						else if(str4.equals(str2))
						{
							int n=Integer.parseInt(str2);
							jb[3][i].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[2][i].setText(jb[0][i].getText());
							jb[1][i].setText("");
							jb[0][i].setText("");
						}
						else if(str2.equals(""))
						{
							if(str4.equals(str1))
							{
								int n=Integer.parseInt(str1);
								jb[3][i].setText(Integer.toString(n*2));
								score=score+(n*2);
								jb[2][i].setText("");
								jb[0][i].setText("");
							}
							else
							{
								jb[2][i].setText(jb[0][i].getText());
								jb[0][i].setText("");
							}
						}
						else
						{
							jb[2][i].setText(jb[1][i].getText());
							jb[1][i].setText(jb[0][i].getText());
							jb[0][i].setText("");
						}
					}
				}
			}			
		}
		if(dir=='u')
		{
			for(int i=0;i<4;i++)
			{
				String str1=jb[0][i].getText();
				String str2=jb[1][i].getText();
				String str3=jb[2][i].getText();
				String str4=jb[3][i].getText();
				if(str1.equals(str2))
				{
					if(str1.equals(""))
					{
						if(str4.equals(str3) && !str4.equals(""))
						{
							int n=Integer.parseInt(str4);
							jb[0][i].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[2][i].setText("");
							jb[3][i].setText("");
						}
						else if(!str4.equals(str3))
						{
							if(!str4.equals("") && !str3.equals(""))
							{
								jb[0][i].setText(jb[2][i].getText());
								jb[1][i].setText(jb[3][i].getText());
								jb[2][i].setText("");
								jb[3][i].setText("");
							}
							else if(str4.equals("") && !str3.equals(""))
							{
								jb[0][i].setText(jb[2][i].getText());
								jb[2][i].setText("");
							}
							else if(!str4.equals("") && str3.equals(""))
							{
								jb[0][i].setText(jb[3][i].getText());
								jb[3][i].setText("");
							}
						}
					}
					else if(!str1.equals(""))
					{
					int n=Integer.parseInt(str1);
					jb[0][i].setText(Integer.toString(n*2));
					score=score+(n*2);
					if((str3.equals(str4) && !str3.equals("")))
					{
						n=Integer.parseInt(str3);
						jb[1][i].setText(Integer.toString(n*2));
						score=score+(n*2);
						jb[2][i].setText("");
						jb[3][i].setText("");
					}
					else if(!str3.equals("") && !str4.equals(""))
					{
						jb[1][i].setText(jb[2][i].getText());
						jb[2][i].setText(jb[3][i].getText());
						jb[3][i].setText("");
					}
					else if(!str3.equals("") && str4.equals(""))
					{
						jb[1][i].setText(jb[2][i].getText());
						jb[2][i].setText("");
					}
					else if(str3.equals("") && !str4.equals(""))
					{
						jb[1][i].setText(jb[3][i].getText());
						jb[3][i].setText("");
					}
					else if(str3.equals("") && str4.equals(""))
					{
						jb[1][i].setText("");
					}
					}
				}
				else if(!str1.equals(str2))
				{
					if(!str1.equals("") && !str2.equals(""))
					{
						if(str4.equals(str3) && !str4.equals(""))
						{
							int n=Integer.parseInt(str4);
							jb[2][i].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[3][i].setText("");
						}
						else if(str3.equals("")&&str2.equals(str4))
						{
							int n=Integer.parseInt(str4);
							jb[1][i].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[3][i].setText("");
						}
						else if(str3.equals(""))
						{
							jb[2][i].setText(jb[3][i].getText());
							jb[3][i].setText("");
						}
						else if(str3.equals(str2))
						{
							int n=Integer.parseInt(str3);
							jb[1][i].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[2][i].setText(jb[3][i].getText());
							jb[3][i].setText("");
						}
					}
					else if(str1.equals("") && !str2.equals(""))
					{
						if(str2.equals(str3))
						{
							int n=Integer.parseInt(str3);
							jb[0][i].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[1][i].setText(jb[3][i].getText());
							jb[2][i].setText("");
							jb[3][i].setText("");
						}
						else if(str3.equals(str4) && !str3.equals(""))
						{
							jb[0][i].setText(jb[1][i].getText());
							int n=Integer.parseInt(str3);
							jb[1][i].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[2][i].setText("");
							jb[3][i].setText("");
						}
						else if(str3.equals(""))
						{
							if(str2.equals(str4))
							{
								int n=Integer.parseInt(str4);
								jb[0][i].setText(Integer.toString(n*2));
								score=score+(n*2);
								jb[1][i].setText("");
								jb[3][i].setText("");
							}
							else
							{
								jb[0][i].setText(jb[1][i].getText());
								jb[1][i].setText(jb[3][i].getText());
								jb[3][i].setText("");
							}
						}
						else
						{
							jb[0][i].setText(jb[1][i].getText());
							jb[1][i].setText(jb[2][i].getText());
							jb[2][i].setText(jb[3][i].getText());
							jb[3][i].setText("");
						}	
					}
					else if(!str1.equals("") && str2.equals(""))
					{
						if(str3.equals(str4) && !str3.equals(""))
						{
							int n=Integer.parseInt(str3);
							jb[1][i].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[2][i].setText("");
							jb[3][i].setText("");
						}
						else if(str1.equals(str3))
						{
							int n=Integer.parseInt(str3);
							jb[0][i].setText(Integer.toString(n*2));
							score=score+(n*2);
							jb[1][i].setText(jb[3][i].getText());
							jb[2][i].setText("");
							jb[3][i].setText("");
						}
						else if(str3.equals(""))
						{
							if(str1.equals(str4))
							{
								int n=Integer.parseInt(str4);
								jb[0][i].setText(Integer.toString(n*2));
								score=score+(n*2);
								jb[1][i].setText("");
								jb[3][i].setText("");
							}
							else
							{
								jb[1][i].setText(jb[3][i].getText());
								jb[3][i].setText("");
							}
						}
						else
						{
							jb[1][i].setText(jb[2][i].getText());
							jb[2][i].setText(jb[3][i].getText());
							jb[3][i].setText("");
						}
					}
				}
			}			
		}
	}
	public static void main(String args[])
	{
		Game2048 game=new Game2048();
		game.setVisible(true);
	}
}