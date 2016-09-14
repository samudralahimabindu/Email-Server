import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;

public class Order extends JFrame implements KeyListener
{
	public static JButton jb[][]=new JButton[4][4];
	public Container cp;
	public JLabel jl,jl1;
	public int num_mov=0;
	public Order()
	{
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		cp=getContentPane();
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
		jl=new JLabel("No of Moves:"+Integer.toString(num_mov));
		panel.add(jl);
		jl1=new JLabel();
		panel.add(jl1);
		panel.addKeyListener(this);
		setResizable(false);
		int cnt=0;
		while(cnt<15)
		{
			Random r=new Random();
			int n=r.nextInt(4)+0;
			int n1=r.nextInt(4)+0;
			int n2=r.nextInt(15)+1;
			int status=1;
			if(!jb[n][n1].getText().equals(""))
				continue;
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<4;j++)
				{
					if(jb[i][j].getText().equals(Integer.toString(n2)))
						status=0;
				}
			}
			if(status==1)
			{
				jb[n][n1].setText(Integer.toString(n2));
				cnt++;
			}
		}			
	}
	public void keyPressed(KeyEvent ke)
	{
		if(ke.getKeyCode() == KeyEvent.VK_UP)
		{
			update('u');
		}
		if(ke.getKeyCode() == KeyEvent.VK_DOWN)
		{
			update('d');
		}
		if(ke.getKeyCode() == KeyEvent.VK_LEFT)
		{
			update('l');
		}
		if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			update('r');
		}
	}
	public void keyReleased(KeyEvent ke)
	{
	}
	public void update(char ch)
	{
		if(ch=='u')
		{
			int n=0,n1=0;
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<4;j++)
				{
					if(jb[i][j].getText().equals(""))
					{
						n=i;
						n1=j;
					}
				}
			}
			if(n!=0)
			{
				jb[n][n1].setText(jb[n-1][n1].getText());
				jb[n-1][n1].setText("");
				num_mov++;
				jl.setText("No of Moves:"+Integer.toString(num_mov));
				check();
			}
		}
		if(ch=='d')
		{
			int n=0,n1=0;
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<4;j++)
				{
					if(jb[i][j].getText().equals(""))
					{
						n=i;
						n1=j;
					}
				}
			}
			if(n!=3)
			{
				jb[n][n1].setText(jb[n+1][n1].getText());
				jb[n+1][n1].setText("");
				num_mov++;
				jl.setText("No of Moves:"+Integer.toString(num_mov));
				check();
			}
		}
		if(ch=='l')
		{
			int n=0,n1=0;
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<4;j++)
				{
					if(jb[i][j].getText().equals(""))
					{
						n=i;
						n1=j;
					}
				}
			}
			if(n1!=0)
			{
				jb[n][n1].setText(jb[n][n1-1].getText());
				jb[n][n1-1].setText("");
				num_mov++;
				jl.setText("No of Moves:"+Integer.toString(num_mov));
				check();
			}
		}
		if(ch=='r')
		{
			int n=0,n1=0;
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<4;j++)
				{
					if(jb[i][j].getText().equals(""))
					{
						n=i;
						n1=j;
					}
				}
			}
			if(n1!=3)
			{
				jb[n][n1].setText(jb[n][n1+1].getText());
				jb[n][n1+1].setText("");
				num_mov++;
				jl.setText("No of Moves:"+Integer.toString(num_mov));
				check();
			}
		}
	}
	public void keyTyped(KeyEvent ke)
	{
	}
	public void check()
	{
		int cnt=1;
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(i==3 && j==3)
					break;
				if(jb[i][j].getText().equals(Integer.toString(cnt)))
				{
					cnt++;
					System.out.println("entered");
					System.out.println(cnt);
				}
			}
		}
		if(cnt==16)
			jl1.setText("WON");
	}
	public static void main(String args[])
	{
		Order odr=new Order();
		odr.setVisible(true);
	}
}