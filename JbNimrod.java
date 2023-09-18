/**********************************************************************************************************************
                                                    Jacob Bogdany
                                                   Computer Science
                                                   Assignment Number: Nimrod
                                                   Purpose: Create an application that will win at the game Nimrod.
***********************************************************************************************************************
***********************************************************************************************************************
                                                      Variables:
                                       
***********************************************************************************************************************
***********************************************************************************************************************
                                                     Main Program
**********************************************************************************************************************/
import java.security.SecureRandom;
import java.util.Scanner;
public class JbNimrod
{
  
    public static void main(String[] args)
   {
      SecureRandom randomNumbers = new SecureRandom();
      Scanner input = new Scanner(System.in);
      
      int finish = 0;
      while(finish != 1)
      {
        int pa = 0;
        int pb = 0;
        
    System.out.printf("Enter whether the computer or player goes first (enter 1 for computer going");
    System.out.printf(" first 2 for player going first)%n");
    int choice = input.nextInt();
 if(choice == 1)
 {
     
      int counter = 0;
      int stpa = 0;
      int stpb = 0;
      
      System.out.printf("%nEnter 1 to come up with random pile numbers enter 2 to input them.%n");
      int choice2 = input.nextInt();
      if(choice2 == 1)
      {
      pa = 1 + randomNumbers.nextInt(500);
      pb = 1 + randomNumbers.nextInt(500);
      }
      else
      {
        System.out.printf("%nHow many sticks are in pile A (1-500)%n");
        pa =input.nextInt();
          System.out.printf("%nHow many sticks are in pile B (1-500)%n");
        pb =input.nextInt();
      }
        
      System.out.printf("Sticks in%nPile A:%d   Pile B:%d%n%n",pa,pb);
       boolean[] x = new boolean[1000];
       int[][] y = new int [1000][2];
      
       for(int i = 0; i < Math.max(pa,pb) + 1; i++)
       {
        
         if(x[i] == false)
         {
           
           x[i] = true;
           x[i + counter] = true;
           y[i][0] = i;
           
           y[i][1] = i + counter;
           ++counter;
         }
       }
        while(pa > 0 || pb > 0)
        {stpa = 0;
          stpb = 0;
          for(int currentRow = 0; currentRow < Math.max(pa,pb) + 1; currentRow++)
      {
           if (pa == pb)
           {
            stpa = pa;
            
            stpb = pb;
            break;
           }
          
           if (pa == 0)
             stpb = pb;
           if (pb == 0)
             stpa = pa;
           
        if(pa == y[currentRow][0] && pb == y [currentRow][1])
        {
          if(pa != 0)
          stpa = 1 + randomNumbers.nextInt(pa);
          else
          stpb = 1 + randomNumbers.nextInt(pb);
            
        }
        else if(pa == y[currentRow][1] && pb == y [currentRow][0])
          {
          if(pa != 0)
          stpa = 1 + randomNumbers.nextInt(pa);
          else
          stpb = 1 + randomNumbers.nextInt(pb);
          }
        
        
        if( stpa == 0 && stpb == 0)
          {
            for(int counter1 = 0; counter1 != 1;)
            {
              if(stpa == 500 && stpb == 500)
                break;
              stpa += 1;
              stpb += 1;
              for(int counter2 = 0; counter2 != 500; counter2++)
              {
                if (y[counter2][0] == pa - stpa && y[counter2][1] == pb - stpa)
                  counter1 += 1;
                if (y[counter2][1] == pa - stpa && y[counter2][0] == pb - stpa)
                  counter1 += 1;
              }
            }
          }
        if(stpa == 500 && stpb == 500)
        {stpa = 0;
          stpb = 0;}
        
        if(stpa == 0 && stpb == 0)
        {
        if(pa > pb)
        {
          if(pa == y[currentRow][1] && pb > y[currentRow][0])
          {
            stpb = pb - y[currentRow][0];
            stpa = 0;
          }
          else if(pb == y[currentRow][1] && pa != y[currentRow][0])
          {
           stpa = pa - y[currentRow][0];
            stpb = 0;
          }
          else if(pb == y[currentRow][0] && pa > y[currentRow][1])
          {
           stpa = pa - y[currentRow][1];
            stpb = 0;
          }
        }
        else
        {
          if(pb == y[currentRow][1] && pa > y[currentRow][0])
          {
            stpa = pa - y[currentRow][0];
            stpb = 0;
          }
          else if(pa == y[currentRow][1] && pb != y[currentRow][0])
          {
           stpb = pb - y[currentRow][0];
            stpa = 0;
          }
          else if(pa == y[currentRow][0] && pb > y[currentRow][1])
          {
           stpb = pb - y[currentRow][1];
            stpa = 0;
          }
        }
        }
      }
          
        pa = pa - stpa;
        pb = pb - stpb;
          
          System.out.printf("Computer takes %d from Pile A and %d from Pile B%n", stpa, stpb);
          if(pa == 0 && pb == 0)
          {
            System.out.printf("Computer wins!");
          break;
          }
          System.out.printf("Sticks in%nPile A:%d   Pile B:%d%n%n",pa,pb);
          int pile = 0;
          for(int c = 0; c != 1;)
          {
          System.out.printf("%nWhich pile will you be taking from (Enter 1 for pile A, 2 for pB and 3 for both)");
          pile = input.nextInt();
          if( pile == 1 || pile == 2 || pile == 3)
            c += 1;
          }
          System.out.printf("%nHow many sticks will you be taking from that pile(s)");
          int num = input.nextInt();
          
          switch(pile)
          {
            case 1: pa = pa - num;
            System.out.printf("%nPlayer takes %d from Pile A and %d from Pile B%n", num, 0);
              break;
            case 2:pb = pb - num;
            System.out.printf("%nPlayer takes %d from Pile A and %d from Pile B%n", 0, num);
              break;
            case 3:pa = pa - num;
              pb = pb - num;
              System.out.printf("%nPlayer takes %d from Pile A and %d from Pile B%n", num, num);
              break;
          }
          
          if(pa == 0 && pb == 0)
          {
            System.out.printf("Player wins!");
          break;
          }
          
          System.out.printf("Sticks left%nPile A:%d   Pile B:%d%n%n",pa,pb);
        }
       
       
  }
             else
    {
      
      int counter = 0;
      int stpa = 0;
      int stpb = 0;
      
      System.out.printf("%nEnter 1 to come up with random pile numbers enter 2 to input them.%n");
      int choice2 = input.nextInt();
      if(choice2 == 1)
      {
      pa = 1 + randomNumbers.nextInt(500);
      pb = 1 + randomNumbers.nextInt(500);
      }
      else
      {
        System.out.printf("%nHow many sticks are in pile A (1-500)%n");
        pa =input.nextInt();
          System.out.printf("%nHow many sticks are in pile B (1-500)%n");
        pb =input.nextInt();
      }
      
      System.out.printf("Sticks in%nPile A:%d   Pile B:%d%n%n",pa,pb);
       boolean[] x = new boolean[1000];
       int[][] y = new int [1000][2];
      
       for(int i = 0; i < Math.max(pa,pb) + 1; i++)
       {
        
         if(x[i] == false)
         {
           
           x[i] = true;
           x[i + counter] = true;
           y[i][0] = i;
           
           y[i][1] = i + counter;
           ++counter;
         }
       }
        while(pa > 0 || pb > 0)
        {
          
          int pile = 0;
          for(int c = 0; c != 1;)
          {
          System.out.printf("%nWhich pile will you be taking from (Enter 1 for pile A, 2 for pB and 3 for both)");
          pile = input.nextInt();
          if( pile == 1 || pile == 2 || pile == 3)
            c += 1;
          }
          System.out.printf("%nHow many sticks will you be taking from that pile(s)");
          int num = input.nextInt();
          
          switch(pile)
          {
            case 1: pa = pa - num;
            System.out.printf("%nPlayer takes %d from Pile A and %d from Pile B%n", num, 0);
              break;
            case 2:pb = pb - num;
            System.out.printf("%nPlayer takes %d from Pile A and %d from Pile B%n", 0, num);
              break;
            case 3:pa = pa - num;
              pb = pb - num;
              System.out.printf("%nPlayer takes %d from Pile A and %d from Pile B%n", num, num);
              break;
          }
          System.out.printf("Sticks in%nPile A:%d   Pile B:%d%n%n",pa,pb);
          
          
          if(pa == 0 && pb == 0)
          {
            System.out.printf("Player wins!");
          break;
          }
          
          stpa = 0;
          stpb = 0;
          for(int currentRow = 0; currentRow < Math.max(pa,pb) + 1; currentRow++)
      {
           if (pa == pb)
           {
            stpa = pa;
            
            stpb = pb;
           }
          
           if (pa == 0)
             stpb = pb;
           if (pb == 0)
             stpa = pa;
           
        if(pa == y[currentRow][0] && pb == y [currentRow][1])
        {
          if(pa != 0)
          stpa = 1 + randomNumbers.nextInt(pa);
          else
          stpb = 1 + randomNumbers.nextInt(pb);
        }
        else if(pa == y[currentRow][1] && pb == y [currentRow][0])
          {
          if(pa != 0)
          stpa = 1 + randomNumbers.nextInt(pa);
          else
          stpb = 1 + randomNumbers.nextInt(pb);
          }
        
        
        
        if( stpa == 0 && stpb == 0)
          {
            for(int counter1 = 0; counter1 != 1;)
            {
              if(stpa == 500 && stpb == 500)
                break;
              stpa += 1;
              stpb += 1;
              for(int counter2 = 0; counter2 != 500; counter2++)
              {
                if (y[counter2][0] == pa - stpa && y[counter2][1] == pb - stpa)
                  counter1 += 1;
                if (y[counter2][1] == pa - stpa && y[counter2][0] == pb - stpa)
                  counter1 += 1;
              }
            }
          }
        if(stpa == 500 && stpb == 500)
        {stpa = 0;
          stpb = 0;}
        
        if(stpa == 0 && stpb == 0)
        {
        if(pa > pb)
        {
          if(pa == y[currentRow][1] && pb > y[currentRow][0])
          {
            stpb = pb - y[currentRow][0];
            stpa = 0;
          }
          else if(pb == y[currentRow][1] && pa != y[currentRow][0])
          {
           stpa = pa - y[currentRow][0];
            stpb = 0;
          }
          else if(pb == y[currentRow][0] && pa > y[currentRow][1])
          {
           stpa = pa - y[currentRow][1];
            stpb = 0;
          }
        }
        else
        {
          if(pb == y[currentRow][1] && pa > y[currentRow][0])
          {
            stpa = pa - y[currentRow][0];
            stpb = 0;
          }
          else if(pa == y[currentRow][1] && pb != y[currentRow][0])
          {
           stpb = pb - y[currentRow][0];
            stpa = 0;
          }
          else if(pa == y[currentRow][0] && pb > y[currentRow][1])
          {
           stpb = pb - y[currentRow][1];
            stpa = 0;
          }
        }
        }
      }
          
        pa = pa - stpa;
        pb = pb - stpb;
          
          System.out.printf("Computer takes %d from Pile A and %d from Pile B%n", stpa, stpb);
          if(pa == 0 && pb == 0)
          {
            System.out.printf("Computer wins!");
          break;
          }
          
          
          System.out.printf("Sticks left%nPile A:%d   Pile B:%d%n%n",pa,pb);
        }
       
    }
    System.out.printf("%n%nif you would like to play again enter 0 if you would like to stop enter 1%n");
    finish = input.nextInt();
      }
    
    }
    
}