package javaass8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Year;
import java.util.ArrayList;

public class MyJson {
	public static void main(String[] args) throws IOException {
		File file = new File("E:\\Program Files\\eclipse-workspace\\assignment\\src\\javaass8\\Question3_camino.txt");
		ArrayList<Vehicle> vehicles = readAndGetVehicles(file);
		String s = getJsonString(vehicles);
		writeToFile(s, file.getParent());
	}

	private static ArrayList<Vehicle> readAndGetVehicles(File file) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String VehicleInfo = bufferedReader.readLine();
		String[] VehicleValue = new String[9];
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		while (true) {
			VehicleInfo = bufferedReader.readLine();
			if (VehicleInfo == null)
				break;
			VehicleValue = VehicleInfo.split("~");
			vehicles.add(new Vehicle(VehicleValue));
		}
		bufferedReader.close();
		return vehicles;
	}

	public static String getJsonString(ArrayList<Vehicle> vehicles) {
		StringBuilder sb = new StringBuilder();
		sb.append("{\r\n" + "\"gmps-camino\" : [\r\n");
		for (Vehicle v : vehicles) {
			sb.append(v.toString());
			sb.append(",\r\n");
		}
		sb.delete(sb.length() - 3, sb.length() - 1);
		sb.append("]\r\n" + "}");
		return sb.toString();
	}

	public static void writeToFile(String inputToWrite, String filePath) throws IOException {
		File f = new File (filePath + "\\Question3_output.txt");
		f.createNewFile();
		FileWriter fw = new FileWriter(f);
		BufferedWriter bf = new BufferedWriter(fw);
		bf.write(inputToWrite);
		bf.close();
	}
}

class Vehicle {

	String id;
	String webId;
	Category category;
	Year year;
	String make;
	String model;
	String trim;
	String type;
	double price;
	URL photo;

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\r\n");
		sb.append("\"id\" : \"" + this.id + "\",\r\n");
		sb.append("\"category\" : \"" + this.category + "\",\r\n");
		sb.append("\"year\" : \"" + this.year + "\",\r\n");
		sb.append("\"make\" : \"" + this.make + "\",\r\n");
		sb.append("\"model\" : \"" + this.model + "\",\r\n");
		sb.append("\"trim\" : \"" + this.trim + "\",\r\n");
		sb.append("\"type\" : \"" + this.type + "\",\r\n");
		sb.append("\"price\" : \"" + this.price + "\",\r\n");
		sb.append("\"photo\" : \"" + this.photo + "\",\r\n}");
		return sb.toString();
	}

	Vehicle(String[] arr) {
		this.id = arr[0];
		this.webId = arr[1];
		this.category = Category.getCategory(arr[2].toLowerCase());
		this.year = Year.parse(arr[3]);
		this.make = arr[4];
		this.model = arr[5];
		this.trim = arr[6];
		this.type = arr[7];
		this.price = Double.parseDouble(arr[8]);
		try {
			this.photo = new URL(arr[9]);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}

enum Category {
	NEW, USED, CERTIFIED;

	public static Category getCategory(String cat) {
		switch (cat) {
		case "used":
			return USED;
		case "new":
			return NEW;
		case "certified":
			return CERTIFIED;
		default:
			throw new IllegalArgumentException();
		}
	}

	@Override
	public String toString() {
		switch (this) {
		case NEW:
			return "NEW";
		case USED:
			return "USED";
		case CERTIFIED:
			return "CERTIFIED";
		default:
			throw new IllegalArgumentException();
		}
	}
} 
