/**
 *   File: P3.java 
 *   Program P3 consist of 2 classes: P3Bday and P3
 *       P3Bday: data members and methods for month and day 
 *       P3: public application driver class to display a day of the week
 */

import java.util.Scanner;         // Read keyboard input
import java.text.DecimalFormat;   // Floating point format

/** class P3Bday - package access
 * public P3Bday() - no argument constructor
 * public P3Bday(int, int) - overloaded constructor
 *
 * getMonth() - return month
 * getDay() - return day 
 * isValid() - test range of all inputs: month (1-12), day (1-31)
 * setBday() - assign inputs to month, day (calls isValid())
 * soString() - format month/day into string
 *
 * isLeapBaby() - test if a leap year birthday, February 29th
 * dayOfYear() - calculate number of the day in the year e.g. 3 (1/3/12)
 * dayOfWeek() - calculate name of the day in the week e.g. "Tuesday"
 */
class P3BDay
{
  static final int YEAR = 2012; //package access to P3 driver
  static final int BIG_MONTH = 31;
  static final int SMALL_MONTH = 30;
  static final int SPEC_MONTH = 29;
    
  private int month = 0, day = 0;//data members

  public P3BDay() 
 {
    month = 3;
    day = 16;  
 } //no argument ctor, init to 3/16/2012

  public P3BDay( int m, int d) 
  {
    month = m;
    day = d;
  } // overloaded ctor init to parameters

  public int getMonth() 
  { 
    return month;
  } // return month
  public int getDay() 
  {
    return day; 
  } // return day

  //test range of all inputs: month (1-12), day (1-31)
  private boolean isValid(int m, int d) 
  { 
    // System.out.println("input m: " + m);
    // System.out.println("input d: " + d);
    boolean dayValid;
    boolean monthValid = ( m >= 1 && m <= 12);
            
    switch ( m )
   {
     case 1: case 3: case 5: case 7: case 8: case 10: case 12:
       dayValid = ( d > 0 && d <= BIG_MONTH ); 
     break;
     case 4: case 6: case 9: case 11:
       dayValid = ( d > 0 && d <= SMALL_MONTH );
     break;
     case 2: 
       dayValid = ( d > 0 && d <= SPEC_MONTH );
     break;
     default:
       dayValid = false;
     break;
				    
   }
     //System.out.println("monthValid: " + monthValid);
     //System.out.println("dayVali d: " + dayValid);
     if( monthValid != true)
     {
       System.out.println("ERROR -  Month legal range 1-12!"); 
     }
     if( dayValid != true)
     {
       System.out.println("ERROR - Birthday not in legal range!");
     }
     return ( dayValid && monthValid );	
  }

   //assign inputs to month, day (calls isValid())
   public boolean setBday (int m, int d) 
   {
     if(isValid(m, d)){
	// Now set the month and day
	month =  m;
	day = d;
	return true;
     } else {
	return false;
       }
    }
   // return formatted date values
   public String toString()
   {
     DecimalFormat twoDigits = new DecimalFormat( "00" );
     return( twoDigits.format (month) + "/" + (day) + "/" + YEAR);
   } 

   public boolean isLeapBaby() 
   { 
     // 1: Check for leap year
     // 2: If leap year, then check for m == 2 and d == 29
     // 3: Else, return false
     if ( month == 2 && day == 29 ) {
	return true;
     } else {
	return false;
     }

   }// return true if 02/29/12

   // calculate number of the day in the year e.g. 3 (1/8/2013)
   //return day of the year (1-365)

   public int dayOfYear()
   {
     // Initialize our main counter - this is what we will sum up all our days
     // and return in the end.
     int totalDayCount = 0;
     int daysInMonth = 0;
     // Now, loop through each month but only for months previous to the current
     // "month" variable.
     for (int m = 1; m < month; ++m) 
     {

       switch ( m )
       {		
         case 1: case 3: case 5: case 7: case 8: case 10: case 12:
	   daysInMonth = BIG_MONTH; break;
 	 case 4: case 6: case 9: case 11:
	   daysInMonth = SMALL_MONTH; break;
 	 case 2: 
	   daysInMonth = SPEC_MONTH; break;
       }
	totalDayCount += daysInMonth;
	// totalDayCount = totalDayCount + d;
	// return totalDayCount;
     }

      return totalDayCount + day;
    }

   private int daysInMonth( int m ) // return num of days in month
   {
     return 0; // NOT SURE IF THIS IS CORRECT FOR INVALID MONTH
   } 

   public String dayOfWeek() 
   {
     String dayOfWeek; 	
     int numericDayOfWeek = dayOfYear() % 7;

     if( numericDayOfWeek == 0)
	dayOfWeek = "Saturday";
     else if( numericDayOfWeek == 1)
	dayOfWeek = "Sunday";
     else if( numericDayOfWeek == 2)
	dayOfWeek = "Monday";
     else if( numericDayOfWeek == 3)
	dayOfWeek = "Tuesday";
     else if( numericDayOfWeek == 4)
	dayOfWeek = "Wednesday";
     else if( numericDayOfWeek == 5)
	dayOfWeek = "Thursday";
     else
	dayOfWeek = "Friday";
		
     if (isLeapBaby()) {
	dayOfWeek = " *****FUN day*****!";
     }
	return dayOfWeek;

   }   // return day of the week e.g. "Sunday"
	//call isLeapBaby, if true, then append "and is a LEAP baby!" to the 
	// dayOfWeek string in dayOfWeek()
}    

/** public class P3
 * This is the application driver class...
 */ 
public class P3
{
   /** Instances 2 P3BDay objects representing a day in the year
    * Allows input of a month and a day to calculate its occurence of the day of the 
    * week. Displays the day of the week.
    */
   public static void main(String[] args)
   {
     final int DUE_MONTH = 2; // January
     final int DUE_DAY = 2; // 01/21 is PA#3 is due date 

     boolean validDay; //boolean for error input
     char choice; // repeat program
     int m, d; // temporaries for input

     Scanner scan = new Scanner(System.in); //read input from keyboard
     String inputStr; // repeat input

     P3BDay firstDay = new P3BDay();// no arg ctor init to 03/16/12
     P3BDay bday = new P3BDay (DUE_MONTH, DUE_DAY); // overloaded 2 init ctor

     System.out.print ("PA#3 is due on " + bday);
     System.out.println(" which occurs on a " + bday.dayOfWeek());
		
     System.out.print( "The first day of lecture is " + firstDay);
     System.out.println(" which occurs on a " + firstDay.dayOfWeek());

     do
     {
	do
	{
	   System.out.print("\nEnter your birthday month and day (1 22): ");
	   m = scan.nextInt(); // assign to int for month
	   d = scan.nextInt(); // assign to int for day
	   if( validDay = bday.setBday(m, d) )// assign if legal
	     System.out.println(bday + " occurs on a " + bday.dayOfWeek() );
	   else
	   {
	     System.out.printf("%02d/%02d/%d is an ", m, d, P3BDay.YEAR);
	     System.out.println("INVALID birthday - enter AGAIN");
	   }
         }while(!validDay); // repeat program

	 System.out.print("\nWant another birth date (y/n)? ");
	 inputStr = scan.next();// read and assign to string
	 choice = inputStr.charAt(0); //assign to character

      }while(choice != 'n' && choice != 'N');// loop not n nor N

      scan.close(); // close this scanner
      System.exit(0);// close connections
    }
}    


