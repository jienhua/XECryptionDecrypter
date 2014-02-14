/***************************************
 * Name   : XECryptionDecrypter
 * Author : Ji-En Hua
 * Date   : February, 14 2014
 * Version: 1
 ***************************************/
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.lang.Object;

public class XECryptionDecrypter
{
    
    public static void main(String[] args)
    {
        ArrayList list = new ArrayList();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        int count = 0;
        int holder = 0;
        
        try
        {
        	File file = new File("encrypted.txt");
        	Scanner scan = new Scanner(file);
            
        	while(scan.hasNextLine())
        	{
        		String[] tokens = scan.nextLine().split("\\.");
        		for (String token : tokens) {
        			list.add(token);
                }
                
            }
   
        	for(int i =1; i < list.size();i++)
        	{
        		holder = holder + Integer.parseInt((String) list.get(i));
        		count++;
        		if(count == 3)
        		{
        			list2.add((Integer)holder);
        			holder=0;
        			count=0;
        		}
        	}
            

            decryption(list2, mostInt(list2));
            
        }catch(IOException e)
        {
            System.out.println("error: IO error");
        }

        
    }
    
    
    
    
    public static int mostInt(ArrayList a)
    {
        int count =0;
        int mostCount =0;
        int answer = 0;
        int holder = 0;
        
        for(int i = 0; i < a.size();i++)
        {
            
            holder = (Integer)a.get(i);
            for(int ii=0;ii<a.size();ii++)
            {
                if(holder == (Integer)a.get(ii))
                {
                    count++;
                }
            }
            
            if(count > mostCount)
            {
                answer = holder;
            }
            
            count = 0;
        }
        
        return answer;
    }
    
    public static void decryption(ArrayList a, int b)
    {
        int e = 116;
        int eValue = 0;
        int holder = 0;
        eValue = b - e +1;
        
        for(int i = 0; i < a.size(); i++)
        {
            holder = (Integer)a.get(i) - eValue;
            System.out.print((char)holder);
        }
        
        System.out.println("");
    }
}