//
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.TimeZone;
//
//import javax.crypto.Mac;
//import javax.crypto.spec.SecretKeySpec;
//
//import org.apache.commons.codec.binary.Base64;
//import org.testng.annotations.Test;
//
//import com.mashape.unirest.http.HttpResponse;
//import com.mashape.unirest.http.Unirest;
//import com.mashape.unirest.http.exceptions.UnirestException;
//
//public class TurnOffInventory {
//
//	private String Finalkey= null;
//
//	@Test(priority = 1)
//	public void getKey() {
//
//		// Date currentTime = new Date();
//		Calendar calendar = Calendar.getInstance();
//		SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z");
//		// Give it to me in GMT time.
//		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
//		String date_string = sdf.format(calendar.getTime());
//		System.out.println(sdf.format(calendar.getTime()));
//		String public_key = "b3c5a917-73d2-4c76-b069-b6ecb61bc57e";
//		String private_key = "2a33dbcb-4448-4282-af49-93f0a4eaf822";
//		String to_hash = date_string + public_key;
//
//		try {
//			Mac md5_HMAC = Mac.getInstance("HmacMD5");
//			SecretKeySpec secret_key = new SecretKeySpec(private_key.getBytes(), "HmacMD5");
//			md5_HMAC.init(secret_key);
//
//			String hash = Base64.encodeBase64String(md5_HMAC.doFinal(to_hash.getBytes()));
//			Finalkey = String.join("|", new String[] { public_key.toString(), date_string, hash.toString() });
//			System.out.println("encode bytes is " + hash);
//			System.out.println("key is " + Finalkey);
//		} catch (Exception e) {
//			System.out.println("Error");
//		}
//
//	}
//
//	@Test(priority = 2)
//
//	public void turnOffInventory() throws UnirestException {
//
//		HttpResponse<String> response = Unirest
//				.post("https://shop-api-qa.ecomm.wholefoodsmarket.com/v1.3/RequestManager/Server.aspx")
//				.header("content-type", "text/plain").header("cache-control", "no-cache")
//				.header("postman-token", "81a34525-18fb-fa1e-582d-6542c5cc2bde")
//				.body("<SVC   CLIENTID=\"99999\"   METHOD=\"INVTOGGLE\">\r      <KEY>" + Finalkey
//						+ "</KEY>\r      <STORE>721</STORE>\r      <ITEM   ID=\"3473\">\r            <INVENTORYTYPE>Off</INVENTORYTYPE>\r<!--Off   |   Item   |   Options-->\r            <DOGENERATEOPTIONS>True</DOGENERATEOPTIONS>\r<!--True   |   False-->\r<!--Optional,   default   to   True,   does   nothing   unless   INVENTORYTYPE   is   'Options'-->       </ITEM>\r</SVC>")
//				.asString();
//
//		String s = response.getBody();
//		System.out.println("Response Status is :" +response.getStatus());
//
//		System.out.println(s);
//
//	}
