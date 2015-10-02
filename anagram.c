#include <stdio.h>


typedef struct node
{
	char s[10][10];
	int len,cnt;
	struct node *next;
}node;

node *create_new();

node *start,*newnode,*ptr,*prev;
char anag(char[],char[]);

void main()
{
	FILE *fp;
	char ch,c,ch1='n',str[10];
	int asc,i=0,j;
	fp=fopen("sample1.txt","r");
	while((c=getc(fp))!=EOF)
	{
		asc=c;
		if((asc>=65 && asc<=90) || (asc>=97 && asc<=122))
		{
			str[i++]=c;
		}
		else
		{
			str[i]='\0';
			if(start==NULL)
			{
				start=create_new();
				for(j=0;j<i;j++)
					start->s[start->cnt][j]=str[j];
				start->s[start->cnt][j]='\0';
				start->len=i;
				start->cnt=start->cnt+1;
			}
			else
			{
				for(ptr=start;ptr;prev=ptr,ptr=ptr->next)
				{
				       if(ptr->len==i)
				       {
						for(j=0;j<i;j++)
							ptr->s[ptr->cnt][j]=str[j];
						ptr->s[ptr->cnt][j]='\0';
						ptr->cnt=ptr->cnt+1;
						break;
				       }
				}
				if(ptr!=NULL)
				{
					i=0;
					continue;
				}
				else
				{
					ptr=create_new();
					prev->next=ptr;
					for(j=0;j<i;j++)
						ptr->s[ptr->cnt][j]=str[j];
					ptr->s[ptr->cnt][j]='\0';
					ptr->len=i;
					ptr->cnt=ptr->cnt+1;
					i=0;
				}
			}
		}
	}
	for(ptr=start;ptr;ptr=ptr->next)
	{
		if(ptr->len>=4)
		{
			for(i=0;i<ptr->cnt;i++)
			{
				printf("%s",ptr->s[i]);
				for(j=i+1;j<ptr->cnt;j++)
				{
					ch1=anag(ptr->s[i],ptr->s[j]);
					if(ch1=='y')
					{
						printf("%s,%s ",ptr->s[i],ptr->s[j]);
						ch1='n';
					}
				}
			}
		}
	}
}

node *create_new()
{
	newnode=(node*)malloc(sizeof(node));
	newnode->next=NULL;
	newnode->len=0;
	newnode->cnt=0;
	return newnode;
}

char anag(char s[10],char s1[10])
{
	int i,j,k,len2,len1,cnt1=0,cnt2=0,asc,asc1;
	for(i=0;s[i]!='\0';i++);
	len1=i;
	for(i=0;s1[i]!='\0';i++);
	len2=i;
	if(len1==len2)
	{
		for(i=0;i<len1;i++)
		{
			for(j=0;j<len1;j++)
			{
				asc=s[i];
				asc1=s1[j];
				if(asc==asc1 || asc==asc1-32)
				{
					cnt1++;
					break;
				}
			}
		}
		for(i=0;i<len1;i++)
		{
			for(j=0;j<len1;j++)
			{
				asc=s1[i];
				asc1=s[j];
				if(asc==asc1 || asc==asc1-32)
				{
					cnt2++;
					break;
				}
			}
		}
		if(cnt1==len1 && cnt2==len2)
			return 'y';
		else
			return 'n';
	}
	else
		return 'n';
}
