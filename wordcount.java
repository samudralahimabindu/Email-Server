import java.io.*;
import java.util.*;
public class wordcount 
{
	public static String remove_sc(String str)
	{
		char ch[]=str.toCharArray();
		int len=ch.length;
		int j=0,k;
		char ch1[]=new char[30];
		for(int i=0;i<len;i++)
		{
			k=ch[i];
			if((k>=65 && k<=90) || (k>=97 && k<=122))
				ch1[j++]=ch[i];
		}
		String str1=new String(ch1);
		return str1;
	} 
	public static void main(String[] args) throws IOException
	{
		FileReader fr=new FileReader("sample.txt");
		BufferedReader br=new BufferedReader(fr);
		String l;
		String str;
		String str1;
		String s[]=new String[1000];
		String ws[]=new String[1000];
		int num[]=new int[100];
		int now=0,w=0;
		while((l=br.readLine())!=null)
		{
			StringTokenizer st=new StringTokenizer(l," ");
			while(st.hasMoreTokens())
			{
				str=st.nextToken();
				str1=remove_sc(str);
				s[now++]=str1.trim();
				//System.out.println(s[now-1]);
			}
		}
		ws[0]=s[0];
		num[0]=1;
		w=1;
		for(int i=1;i<now;i++)
		{
			int cnt=0;
			for(int j=0;j<w;j++)
			{
				if(s[i].equals(ws[j]))
				{
					num[j]=num[j]+1;
					cnt=1;
				}	
			}
			if(cnt==0)
			{
				ws[w]=s[i];
				num[w]=num[w]+1;
				w++;
			}
		}
		for(int i=0;i<w;i++)
		{
			System.out.println(ws[i]+"-"+num[i]);
		}
	}
}

