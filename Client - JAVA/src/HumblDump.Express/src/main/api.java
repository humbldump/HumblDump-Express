/**
 * HumblDump Express
 *
 * @package   HumblDump - Express
 * @author    Mahir Tekin Erdensan - humbldump@protonmail.com
 * @copyright Copyright (c) 2020
 * @link      http://github.com/humbldump
 * @version   1.0.1
 */
package main;

import java.io.*;
import java.net.*;

//indiryo api uzerinden istekgonder
class ApiRequest {
	public String _method = null;
	public String _Query = null;
	private String url = "https://indiryo.com/ExpressAPI/index.php";

	ApiRequest(String method, String Query) {
		if (method == null)
			throw new RuntimeException("Kod hatasý!");
		this._method = method;
		this._Query = (Query == null) ? "null" : Query;
	}

	String GET() {
		try {
			if (this._method == null)
				throw new RuntimeException("Kod hatasý!");
			String q = URLEncoder.encode(this._Query, "UTF-8").replace("+", "%20");

			URL urlm = new URL(this.url + "?method=" + this._method + "&q=" + q);
			HttpURLConnection conn = (HttpURLConnection) urlm.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");

			if (conn.getResponseCode() != 200)
				throw new RuntimeException("Kod Hatasý: " + conn.getResponseCode());

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			return br.readLine();
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		} catch (MalformedURLException e) {
			throw new RuntimeException(e.getMessage());
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
