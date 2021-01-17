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

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.google.gson.*;

public class mainClass {
	static CargoDATA[] CargoList = new CargoDATA[20];

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String res = GetAdminpass();
					LoginScreen.main(res);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void GirisDogru() {
		MainScreen.main(null);
	}
	
	static CargoDATA GeciciObj(int id) {
		String bs = new ApiRequest("GetCustomCargo", String.valueOf(id)).GET();
		JsonObject obj = JsonParser.parseString(bs).getAsJsonObject();
		
		if (obj.get("durum").getAsString() != "true") {
			return null;
		}
		JsonArray body = obj.getAsJsonArray("body");
		JsonObject po = ((JsonElement) body.get(0)).getAsJsonObject();
		
		CargoDATA gecici = new CargoDATA();
		
		gecici.durum = obj.get("durum").getAsBoolean();
		gecici.id = po.get("id").getAsInt();
		
		gecici.setReceiver(po.get("receiver").getAsString());
		gecici.setSender(po.get("sender").getAsString());
		gecici.setCargo_From(po.get("Cargo_From").getAsString());
		gecici.setCargo_To(po.get("Cargo_To").getAsString());
		gecici.setDate(po.get("Date").getAsString());
		gecici.setCargo_Weight(po.get("Cargo_Weight").getAsString());
		gecici.setCargo_Type(po.get("Cargo_Type").getAsString());
		
		return gecici;
	}
	// Decreaser ama çile çektireninden
	static void Decreasr() {
		int nCount = (CargoList[CargoList.length - 1] == null) ? 1 : 0;

		for (int i = 0; i < CargoList.length - 1; i++) {

			if (CargoList[i] == null) {
				int z = i + 1;
				while (CargoList[z] == null && z < CargoList.length - 1) {
					z++;
				}
				CargoList[i] = CargoList[z];
				CargoList[z] = null;
				nCount++;
			}
		}

		if (nCount == 0) {
			for (int i = 0; i < CargoList.length - 1; i++) {
				CargoList[i] = CargoList[i + 1];
			}
			CargoList[CargoList.length - 1] = null;
		}
	}

	// Old Decreaser :D lol
	static int DecreaseList() {
		for (int i = CargoList.length - 1; i >= 0; i--) {
			if (i - 1 == -1)
				break;
			CargoList[i - 1] = CargoList[i];
		}

		CargoList[CargoList.length - 1] = null;
		return CargoList.length - 1;
	}

	static void GetLatestCargo() {
		String request = new ApiRequest("GetLastCargo", null).GET();

		JsonObject obj = JsonParser.parseString(request).getAsJsonObject();

		if (obj.get("durum").getAsString() != "true") {
			showMessageDialog(null, obj.get("body").getAsString());
			throw new RuntimeException(obj.get("body").getAsString());
		}
		;

		JsonArray body = obj.getAsJsonArray("body");

		for (int i = 0; i < body.size(); i++) {
			// element oluþtor sonra objeye dönüþtür
			mainClass.CargoList[i] = null;
			JsonObject po = ((JsonElement) body.get(i)).getAsJsonObject();
			mainClass.CargoList[i] = new CargoDATA();

			mainClass.CargoList[i].durum = obj.get("durum").getAsBoolean();
			mainClass.CargoList[i].id = po.get("id").getAsInt();
			
			
			mainClass.CargoList[i].setReceiver(po.get("receiver").getAsString());
			mainClass.CargoList[i].setSender(po.get("sender").getAsString());
			mainClass.CargoList[i].setCargo_From(po.get("Cargo_From").getAsString());
			mainClass.CargoList[i].setCargo_To(po.get("Cargo_To").getAsString());
			mainClass.CargoList[i].setDate(po.get("Date").getAsString());
			mainClass.CargoList[i].setCargo_Weight(po.get("Cargo_Weight").getAsString());
			mainClass.CargoList[i].setCargo_Type(po.get("Cargo_Type").getAsString());
		}
		
		
	}

	public static void Kapat(JFrame kim) {
		kim.dispose();
	}

	static String GetAdminpass() {
		String bs = new ApiRequest("GetAdminPass", null).GET();
		JsonObject obj = JsonParser.parseString(bs).getAsJsonObject();
		if (obj.get("durum").getAsString() != "true") {
			showMessageDialog(null,obj.get("body").getAsString());
			throw new RuntimeException(obj.get("body").getAsString());
		}
			

		String s = obj.get("body").getAsString();
		return s;
	}
}
