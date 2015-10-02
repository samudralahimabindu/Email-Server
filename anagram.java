import java.io.*;
import java.util.*;
public class anagram
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
	public static char anag(String str,String str1)
	{
		String str2=str.toLowerCase();
		String str3=str1.toLowerCase();
		char ch[]=str2.toCharArray();
		char ch1[]=str3.toCharArray();
		int len1=ch.length;
		int len2=ch1.length;
		int cnt=0,cnt1=0,asc,asc1;
		if(len1==len2)
		{
			for(int i=0;i<len1;i++)
			{
				for(int j=0;j<len1;j++)
				{
					asc=ch1[i];
					asc1=ch[j];
					if(asc==asc1)
					{
						cnt++;
						break;
					}
				}
			}
			for(int i=0;i<len1;i++)
			{
				for(int j=0;j<len1;j++)
				{
					asc=ch[i];
					asc1=ch1[j];
					if(asc==asc1)
					{
						cnt1++;
						break;
					}
				}
			}
			if(cnt==len1 && cnt1==len2)
				return 'y';
			else
				return 'n';
		}
		else 
			return 'n';
	}
	public static void main(String[] args) throws IOException
	{
		FileReader fr=new FileReader("sample1.txt");
		BufferedReader br=new BufferedReader(fr);
		String l;
		String str;
		String str1;
		String s[]=new String[1000];
		String s1[][]=new String[100][100];
		String ws[]=new String[1000];
		int num[]=new int[100];
		int now=0,cnt=0,m=0;
		while((l=br.readLine())!=null)
		{
			StringTokenizer st=new StringTokenizer(l," ");
			while(st.hasMoreTokens())
			{
				str=st.nextToken();
				str1=remove_sc(str);
				s[now++]=str1.trim();
			}
		}
		for(int i=0;i<now;i++)
		{
			int k;
			if(i!=0)
			{
			for(k=0;k<cnt;k++)
			{
				if(num[k]==i)
					break;
			}
			if(num[k]==i)
				continue;
			}
			k=0;
			s1[m][k++]=s[i];
			for(int j=i+1;j<now;j++)
			{
				char ch=anag(s[i],s[j]);
				if(ch=='y')
				{
					char ch1='n';
					for(int n=0;n<k;n++)
					{
						if(s[j].equals(s1[m][n]))
						{
							ch1='y';
							num[cnt++]=j;
						}
					}
					if(ch1=='n')
					{
						s1[m][k++]=s[j];
						num[cnt++]=j;
					}
				}
			}
			m++;
		}
		for(int i=0;i<m;i++)
		{
			int cnt1=0;
			for(int j=0;j<s1[m].length;j++)
			{
				if(s1[i][j]!=null)
					cnt1++;
			}
			if(cnt1>=2)
			{
				int j;
				for(j=0;j<cnt1-1;j++)
				{
					System.out.print(s1[i][j]+",");
				}
				System.out.println(s1[i][j]);
			}
		}
	}	
}

