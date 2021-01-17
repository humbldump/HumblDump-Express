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

public class CargoDATA extends mainClass {
	public Boolean durum;
	public int id;

	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getCargo_From() {
		return Cargo_From;
	}
	public void setCargo_From(String cargo_From) {
		Cargo_From = cargo_From;
	}
	public String getCargo_To() {
		return Cargo_To;
	}
	public void setCargo_To(String cargo_To) {
		Cargo_To = cargo_To;
	}
	public String getCargo_Weight() {
		return Cargo_Weight;
	}
	public void setCargo_Weight(String cargo_Weight) {
		Cargo_Weight = cargo_Weight;
	}
	public String getCargo_Type() {
		return Cargo_Type;
	}
	public void setCargo_Type(String cargo_Type) {
		Cargo_Type = cargo_Type;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	private String sender;
	private String receiver;
	private String Cargo_From;
	private String Cargo_To;
	private String Cargo_Weight;
	private String Cargo_Type;
	private String Date;

}