package View;

//author juliana abu shkara 207840216


import java.io.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.Booking;
import model.Hotel;
import model.Room;

public class SerialazableHotel {

	private static final String filePath = "Hotel.ser";

	// Save hotel object to file
	public static void saveHotel(Hotel hotel) {
		hotel.setRoomPk(Room.getRunningNumber());
		hotel.setBookingPK(Booking.getRunningNumber());
			
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
			oos.writeObject(hotel);
			System.out.println("Hotel object saved successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Load hotel object from file
	public static Hotel loadHotel() {
		File file = new File(filePath);
		if (!file.exists()) {
			System.out.println("File " + filePath + " does not exist.");
			return null;
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			Hotel hotel = (Hotel) ois.readObject();
			System.out.println("Hotel object loaded successfully!");
			
			return hotel;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
