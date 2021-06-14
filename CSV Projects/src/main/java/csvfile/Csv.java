package csvfile;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Csv {
	
	public static void main(String[] args) {
		String path = "D:\\new.csv.csv";
		String line = "";
		List<String[]> Csvdata =new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while((line = br.readLine())!= null){
			  String values[] = line.split(",");
			  System.out.println("Date: " + values);
			  Csvdata.add(values);
			  line =br.readLine();
			  String value="";
			  String columnValue=tab;
			  String table_name="dynamic_table";
			  String column_name="";
			  for(int i=0;i<Csvdata.get(0).size();i++) {
			  	columnValue+=Csvdata.get(0)[i]+" varchar(255),";
			          column_name+=Csvdata.get(0)[i]+",";
			  }

			  StringBuffer columndata= new StringBuffer(columnValue);
			  columndata.deleteCharAt(sb.length()-1);  
			  StringBuffer column_name_data1= new StringBuffer(column_name);
			  column_name_data.deleteCharAt(sb.length()-1); 

			  Sting tableCode="CREATE TABLE "+table_name+"("+columndata+")";

			  //Mysql connection code example

			  Class.forName("com.mysql.jdbc.Driver");  
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/siva","root","Sowmithrasiva@7");  
			  Statement stmt=con.createStatement();  
			  stmt.executeQuery(tableCode);  

			  for(int i=1;i<Csvdata.size();i++){
			  String column_value="";
			  for(int j=0;j<Csvdata.get(i).size();j++){
			       column_value+="\""+Csvdata.get(i)[j]+"\",";
			  }
			  StringBuffer column_value_data= new StringBuffer(column_value);
			  column_value_data.deleteCharAt(sb.length()-1);  
			  String insert_Query="INSERT INTO"+table_name+"("+column_name_data1+") VALUES ("+ column_value_data + ");
			  stmt.executeQuery(insert_Query);
			  }
			}
			}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
