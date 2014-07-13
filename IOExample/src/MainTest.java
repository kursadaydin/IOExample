import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class MainTest {

	
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		
		 BufferedReader inputStream = null;
		 PrintWriter bufferedWriter = null;
		 PrintWriter bufferedWriter2 = null;
		 
		   try {
			   inputStream = new BufferedReader(new FileReader("C:\\Users\\KürþadPC\\Desktop\\dosya.txt"));
			   bufferedWriter = new PrintWriter(new FileWriter("C:\\Users\\KürþadPC\\Desktop\\dosya2.txt"));
			   bufferedWriter2 = new PrintWriter(new FileWriter("C:\\Users\\KürþadPC\\Desktop\\dosya3.txt"));
			   String line = null;
			   
			   int i =1;
			   ArrayList<Fatura> fList = new ArrayList<Fatura>();
			   while((line = inputStream.readLine()) != null){
				   String temp[] =line.split(";");
				   Fatura fTemp = new Fatura();
				   fTemp.setTcNo(Long.parseLong(temp[0]));
				   fTemp.setAd(temp[1]);
				   fTemp.setSoyad(temp[2]);
				   fTemp.setHesapNo(Long.parseLong(temp[3]));
				   fTemp.setTutar(Double.parseDouble(temp[4]));
				   fTemp.setYerlesimYeri(temp[5]);
				   
				   fList.add(fTemp);
				   
				  bufferedWriter.append(i+" 'nci satir okundu");
				  bufferedWriter.append("\r\n");
				  
				  bufferedWriter2.append(fTemp.getTcNo()+":"+fTemp.getAd()+ ":"+fTemp.getSoyad()+":"+fTemp.getHesapNo()+":" + fTemp.getTutar()+":"+fTemp.getYerlesimYeri()+":"+i);
					bufferedWriter2.append("\r\n");
					i++;
				   
			   }

			   for (Fatura f1 : fList) {
					
					System.out.println(f1.getAd()+" "+f1.getSoyad()+" "+f1.getTcNo());
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  finally{
		   inputStream.close();
		   bufferedWriter.close();
		   bufferedWriter2.close();
		   
		  }
		  
	  }
}

