    import java.time.LocalTime;

    import java.util.Random;
	import java.util.Scanner;
	import java.util.concurrent.TimeUnit;
	
	//created by team bit_by_bit
	
	public class TypingSpeedCalculator 
	{
		

		static String[] sentences = {"An apple a day keeps the doctor away" , "Soul full of sunshine" , 
				     "Live what you Love" , "Whatever you are, be a good one" , 
				"Don't let yesterday take up too much of today" , "Being happy never goes out of style" ,
				"The best is yet to come" , "No act of kindness, no matter how small, is ever wasted" , 
				"It always seems impossible until it's done"};		//created by team bit_by_bit
		
		
		
		
		static String example,inSentence;
		static double seconds;
		static int wordnum,wordspermin,charpermin;
		
		
		
		
		
		//Calculating the Number of Words
		static void wordcount(int Chars)
		{
			int space=0;
	        for(int i=0;i<Chars;i++)
	        {
	        	if(example.charAt(i)==' ')
	        		space++;
	        }
	        wordnum=space+1;	
		}
		
		
		
		
		
		//COUNTDOWN
		static void countdown(int n) throws InterruptedException
		{
		    
	        TimeUnit.SECONDS.sleep(1);
	        System.out.println("Start typing in:");
		    TimeUnit.SECONDS.sleep(1);
		        while(n>=1)
		                 {
		                	System.out.println(n);
		                	TimeUnit.SECONDS.sleep(1);
		                   	n--;
		                 }
		    System.out.println("Go!!");
		    TimeUnit.SECONDS.sleep(1);
		   
		}
		
		//created by team bit_by_bit
		
		
		
		//Calculating the ACCURACY of typed word
		static int accuracy(String auto,String user,int wnum)	//created by team bit_by_bit
		{
			 auto=auto+" ";
			 user=user+" ";
			
			 int l=0,m=0,correct=0,per;
			 int anum=auto.length();
			 int unum=user.length();
			  while(l<anum&&m<unum)
		         {	
		        		while((auto.charAt(l)==user.charAt(m))&&(auto.charAt(l)!=' '))
		        		{
		        			l++;
		        			m++;
		        		}
		        		if((auto.charAt(l)==' ')&&(user.charAt(m)==' '))
		        			correct++;
		      	
		        		while(auto.charAt(l)!=' ')                //finding the next word in auto generated string
		        			l++;
		        		
		        		while(user.charAt(m)!=' ')                //finding the next word in user entered string
		        			m++;
		        		
		        		l++; m++;                                 //going to the next word
		        		
		          }
			 per=(int) (((double)correct/wnum)*100);              //calculating accuracy percentage 
			 return per;
		}
		
		
		//created by team bit_by_bit
		
		
		
		//Display all the content(required output)
		static void disp() throws InterruptedException
		{
			
	        int Apercentage;                                     // for accuracy
	        Apercentage=accuracy(example,inSentence,wordnum);
	       
	        System.out.println("----------------------------------");
	        TimeUnit.SECONDS.sleep(1);
	        System.out.println("Your Accurcy is : "+Apercentage+"%");
	        TimeUnit.SECONDS.sleep(1);
	        System.out.println("Time Taken : "+seconds+" sec");
	        TimeUnit.SECONDS.sleep(1);
		    System.out.println("You can write "+wordspermin+" wpm (WORDS/min)");
		    TimeUnit.SECONDS.sleep(1);
		    System.out.println("Also, you can write "+charpermin+" cpm (CHARACTERS/min)");
		    TimeUnit.SECONDS.sleep(1);
		    System.out.println("----------------------------------");
		    TimeUnit.SECONDS.sleep(1);
		    if(Apercentage>=75)
		    {
		    if(wordspermin<=30)
		    	System.out.println("NEEDS IMPROVEMENT!!");
		    else
		    	System.out.println("WELL DONE!!");
		    }
		    else 
		    	System.out.println("TYPE CORRECTLY!!");
		}
		
		
		
		//created by team bit_by_bit
		
	
		
		//MAIN function (Execution starts here)
		
		public static void main(String[] args) throws InterruptedException 
		{
			
			Random ran = new Random(); 
			example=sentences[ran.nextInt(8)];
		
			
			int anumChars = example.length();                    // getting the number of characters that auto generated
			
			System.out.println("Read out the sentence given below: ");
			System.out.println(example);
			TimeUnit.SECONDS.sleep(3);
			System.out.println("--------------------------------------------------------");
			TimeUnit.SECONDS.sleep(1);

			
			
			countdown(3);                                         //Calling Countdown
			
			
			  
			double start = LocalTime.now().toNanoOfDay();         //start time in nanosecond
			
			Scanner sc= new Scanner(System.in);
			inSentence  = sc.nextLine();                          //taking user input
			sc.close();
			
			double end = LocalTime.now().toNanoOfDay();           //end time in nanosecond
			  
			double calculatedTime = end - start;                  //difference between end and start time 
			seconds = calculatedTime / 1000000000.0;              //converting the calculated time to seconds 
			
	        int unumChars = inSentence.length();                  //getting the number of characters that user entered 
   
	        
	      //created by team bit_by_bit
	          
	        
	        wordcount(anumChars);                                 //Calling Wordcount
	       
	       
	        wordspermin = (int) (((double)wordnum/seconds)*60);   //Calculating words per min
	        
	        
	        charpermin=(int) (((double)unumChars/seconds)*60);    //Calculating characters per min
	        
	    
	        disp();	        	                                  //Calling Display
		}

	}