package sample_notes;



import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class APITest_loginpage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		
		   
		   
	 //_API Testing for result printing
		   
		   
		   try
			{
					String URL = "http://192.168.3.252:8090/H2H_V2/login/validate";
				
					   MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
					   				
					   String UName= "jngj";
					   String pass = "Login@123";
					   
					   String URLPaarameters = "txtUserId="+UName+
							                   "&txtPwd="+pass;
							                   
					   
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
