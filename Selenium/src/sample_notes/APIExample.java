package sample_notes;



import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class APIExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		try
		{
				String URL = "http://192.168.3.251:8090/DB_TEST/Database_connection_Check";
			
				   MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
				   				
				   String Database_Type = "Oracle";
				   String DBname = "EXIMTZ";
				   String DBuser = "eximpg";
				   String DBpass = "EXIMPG";
				   String DBip = "192.168.128.47";
				   			   
				   String URLPaarameters = "Database_Type="+Database_Type+
						   				   "&Database_Name="+DBname+
						   				   "&User_Name="+DBuser+
						   				   "&Password="+DBpass+
						   				   "&IP_Address="+DBip;
				   
				   RequestBody body = RequestBody.create(mediaType, URLPaarameters);
					
				   Request request = new Request.Builder()
						   .url(URL)
						   .method("POST", body)
						   .addHeader("Content-Type", "application/x-www-form-urlencoded")
						   .build();
				   
				   OkHttpClient client = new OkHttpClient().newBuilder().build();
				   
				   Response response = client.newCall(request).execute();
		    		
		    	   String Response = response.body().string();
				   
		    	   System.out.println(Response);
				
		}
		catch(Exception e)
    	{
			e.printStackTrace();
    	}
		   
		  		   
	}

}
