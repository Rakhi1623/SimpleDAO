package com.canddella.utility;

import java.io.FileOutputStream;
import java.io.IOException;

import com.canddella.dao.VehicleDAOImp;
import com.canddella.entity.Booking;
import com.canddella.entity.BookingPayment;
import com.canddella.entity.Customer;
import com.canddella.entity.Vehicle;
import com.canddella.service.BookingServiceImp;
import com.canddella.service.CustomerServiceImp;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFGenerator {

	public static void main(String[] args) {
		// Your main method code...
	}

	public static void generatePDFBill(BookingPayment payment) throws DocumentException {
		try {
			Document document = new Document();

			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("D://DriveEase//bills.pdf"));
			System.out.println("OP Generated");
			document.open();
			

			Booking booking = payment.getBooking();
			System.out.println(booking.getBooking_id());
			BookingServiceImp bookingServiceImp = new BookingServiceImp();
			Booking bookedCustomer = bookingServiceImp.searchBooking(booking.getBooking_id());
			System.out.println(bookedCustomer.getCustomer().getCustomer_id());
			CustomerServiceImp customerServiceImp = new CustomerServiceImp();
			Customer customerDetails = customerServiceImp.searchCustomer(bookedCustomer.getCustomer().getCustomer_id());
//           System.out.println(customerDetails.getCustomer_id());
			System.out.println(customerDetails.getCustomer_firstName());

			VehicleDAOImp vehicleDAOImp = new VehicleDAOImp();
			Vehicle vehicledetails = vehicleDAOImp.searchVehicle(bookedCustomer.getVehicle().getVehicle_Id());
//            System.out.println(vehicledetails.getVehicle_Id());

			Paragraph header = new Paragraph("***************Rental Company: DriveEase*******************");
			Image logoImage = Image.getInstance("C://Users//USER//Downloads//DriveEase-1 (2).jpg");
			logoImage.scaleToFit(150, 150);

			Paragraph space = new Paragraph("           ");
			Paragraph header2 = new Paragraph("*************** Welcome to DriveEase *************");
			Paragraph space2 = new Paragraph("           ");
			Paragraph line = new Paragraph("---------------------------------*****-------------------------------  ");

			Paragraph customerId = new Paragraph("Customer ID: " + customerDetails.getCustomer_id());
			Paragraph customerfirstName = new Paragraph(
					"Customer First Name: " + customerDetails.getCustomer_firstName());
			Paragraph customerlastName = new Paragraph("Customer Last Name: " + customerDetails.getCustomer_lastName());
			Paragraph vehicleId = new Paragraph("Vehicle ID: " + vehicledetails.getVehicle_Id());
			Paragraph timeOut = new Paragraph("Time Out: " + payment.getTimeOut().toString());
			Paragraph timeIn = new Paragraph("Time In: " + payment.getTimeIn().toString());
			Paragraph paymentMethod = new Paragraph("Payment Method: " + payment.getPayment_method());
			Paragraph totalAmount = new Paragraph("Total Amount: " + payment.getAmount());
			
			Paragraph totalAmount2 = new Paragraph(
					"Payment processed successfully. Amount paid: " + payment.getAmount());

			Paragraph space3 = new Paragraph("           ");
			Paragraph line2 = new Paragraph("---------------------------------*****-------------------------------  ");

			Paragraph thankYouMessage = new Paragraph(
					"Thank you for choosing DriveEase! We hope to serve you again soon.");

			// Add the paragraphs to the document
			document.add(header);
			document.add(logoImage);
			document.add(space);
			document.add(header2);
			document.add(space2);
			document.add(line);
			document.add(customerId);
			document.add(customerfirstName);
			document.add(customerlastName);
			document.add(vehicleId);
			document.add(timeOut);
			document.add(timeIn);
			document.add(paymentMethod);
			document.add(totalAmount);
			document.add(totalAmount2);
			document.add(space3);
			document.add(line2);
			document.add(thankYouMessage);

			// Close the document
			document.close();

			System.out.println("PDF generated successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Other utility methods...
}
