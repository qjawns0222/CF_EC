import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnimalTest {

   public static void main(String[] args) throws NumberFormatException, IOException {
      
      System.out.println("숫자(홀수만) : ");
      int num = System.in.read() - 48;
      System.in.read(); System.in.read();
      int[][] mabang = new int[num][num];//배열생성
      int row = 0; int col = num / 2;
      for(int su=1; su<= num*num; su++){
         if(mabang[row][col]!=0&&su!=1) {
            if(row==num-1&&col==0) {
               row=0;
               col=num-1;
            }else if(row==num-1) {
                  row=0;
                  col--;
                  
               }else if(col==0) {
                  col=num-1;
                  
                  row++;
               }   else {
                  row++;
                  col--;
               }
            row++;
            
         }
      mabang[row][col] = su;
   
      if(row==0&&col==num-1) {
         row=num-1;
         col=0;
      }else if(row==0) {
            row=num-1;
            col++;
            
         }else if(col==num-1) {
            col=0;
            
            row--;
         }   else {
            row--;
            col++;
         }
      

      //여기에 코드를 추가합니다.
      }
      //결과출력
      System.out.println();
      for(int i=0; i<mabang.length; i++){
      for(int j=0; j<mabang[i].length; j++){
      System.out.print(mabang[i][j] + "\t");
      }
      System.out.println();
      }

   }
   }