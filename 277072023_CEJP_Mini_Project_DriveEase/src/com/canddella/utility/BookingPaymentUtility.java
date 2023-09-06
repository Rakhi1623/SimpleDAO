package com.canddella.utility;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.canddella.entity.Booking;
import com.canddella.entity.BookingPayment;
import com.canddella.entity.Customer;
import com.canddella.entity.ReferralDiscounts;
import com.canddella.entity.Rental;
import com.canddella.service.BookingPaymentServiceImp;
import com.canddella.service.BookingServiceImp;
import com.canddella.service.LoyaltyPointsServiceImp;
import com.canddella.service.ReferralDiscountsServiceImp;
import com.itextpdf.text.DocumentException;

public class BookingPaymentUtility {

	public static void main(String[] args) throws DocumentException {
		paymentMenu();
	}

	public static void paymentMenu() throws DocumentException {
		char selectChoice;
		do {
			Scanner scanner = new Scanner(System.in);

			System.out.println("1.Add Payment \n2.Display All Payment\n3.Update Payment\n4.Search Payment");
			int choice = scanner.nextInt();
			if (choice == 1) {
				addPayment();

			} else if (choice == 2) {
				displayAllPayment();

			} else if (choice == 3) {
				updatePaymentDetails();
			} else if (choice == 4) {
				BookingPayment bookingPayment = searchPayment();
				generatePDF(bookingPayment);

			}

			System.out.println("do you want continue");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');
	}

	private static BookingPayment searchPayment() throws DocumentException {
		BookingPaymentServiceImp paymentServiceImp = new BookingPaymentServiceImp();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the payment_id: ");
		String paymentId = scanner.nextLine();
		BookingPayment payment = paymentServiceImp.searchPayment(paymentId);

		if (payment != null) {

			System.out.println(payment.getPayment_id() + "   " + payment.getBooking().getBooking_id() + "     "
					+ payment.getTimeOut() + "         " + payment.getTimeIn() + "      " + payment.getAmount() + "    "
					+ payment.getPayment_date() + "     " + payment.getPayment_method());
		} else {
			System.out.println("Payment ID not found.");

		}

		return payment;
	}

	private static void updatePaymentDetails() throws DocumentException {
		BookingPaymentServiceImp paymentServiceImp = new BookingPaymentServiceImp();
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter formatt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		Scanner scanner = new Scanner(System.in);
		BookingPayment payment = searchPayment();

		if (payment != null) {
			System.out.println("1.update amount\n2.update payment date \n3.update payment method ");
			int updateChoice = scanner.nextInt();

			if (updateChoice == 1) {
				scanner.nextLine();
				System.out.println("Enter the Time Out : ");
				String updatetimeOut = scanner.nextLine();
				LocalDateTime timeOut = LocalDateTime.parse(updatetimeOut, formatt);
				payment.setTimeOut(timeOut);
				paymentServiceImp.updatePayment(payment);

			}

			else if (updateChoice == 2) {
				scanner.nextLine();
				System.out.println("Enter the Time In : ");
				String updatetimeIn = scanner.nextLine();
				LocalDateTime timeIn = LocalDateTime.parse(updatetimeIn, formatt);
				payment.setTimeIn(timeIn);
				paymentServiceImp.updatePayment(payment);

			}

			else if (updateChoice == 3) {
				scanner.nextLine();
				System.out.println("Enter the Amount : ");
				Long updateamount = scanner.nextLong();
				payment.setAmount(updateamount);

				paymentServiceImp.updatePayment(payment);

			} else if (updateChoice == 4) {
				scanner.nextLine();
				System.out.println("Enter the Payment date : ");
				String updatePayment_date = scanner.nextLine();
				LocalDate nUpdatePayment_date = LocalDate.parse(updatePayment_date, formater);
				paymentServiceImp.updatePayment(payment);

			} else if (updateChoice == 5) {
				scanner.nextLine();
				System.out.println("Enter the payment method : ");
				String updatePaymentMethod = scanner.nextLine();
				payment.setPayment_method(updatePaymentMethod);
				;

				paymentServiceImp.updatePayment(payment);

			}

		}
	}

	private static void displayAllPayment() {
		BookingPaymentServiceImp paymentServiceImp = new BookingPaymentServiceImp();
		List<BookingPayment> paymentList = paymentServiceImp.ListAllPayment();
		for (BookingPayment pay : paymentList) {
			System.out.println(pay.getPayment_id() + "   " + pay.getBooking().getBooking_id() + "    "
					+ pay.getTimeOut() + "        " + pay.getTimeIn() + "       " + pay.getAmount() + "    "
					+ pay.getPayment_date() + "     " + pay.getPayment_method());

		}
	}

	private static void addPayment() throws DocumentException {
		BookingPaymentServiceImp paymentServiceImp = new BookingPaymentServiceImp();
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter formatt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Payment_id : ");
		String payment_id = scanner.nextLine();
		BookingUtility.displayAllBooking();
		System.out.println("Enter the Booking_id : ");
		String booking_id = scanner.nextLine();
		// Booking booking = new Booking();
		Booking booking = BookingUtility.searchBooking(booking_id);
		
		if (booking == null) {
			System.out.println("Booking not found!");

		} else {
			System.out.println("  ");

			System.out.println("The actual date is   : " + booking.getAcutal_date());
			LocalDate actualDate = booking.getAcutal_date();

			System.out.println("Enter the Time Out : ");
			String ntimeOut = scanner.nextLine();
			LocalTime timeOut = LocalTime.parse(ntimeOut);
			LocalDateTime dateIn = timeOut.atDate(actualDate);

			System.out.println("Enter the Time In : ");
			String ntimeIn = scanner.nextLine();
			LocalTime timeIn = LocalTime.parse(ntimeIn);
			LocalDateTime dateOut = timeOut.atDate(actualDate);

			System.out.println("Enter the Payment_date : ");
			String payment_date = scanner.nextLine();
			LocalDate nPayment_date = LocalDate.parse(payment_date, formater);

			Duration duration = Duration.between(timeOut, timeIn);

			System.out.println("Enter the Vehicle_id : ");
			String vehicle_id = scanner.nextLine();
			RentalUtility.displayAllRental();

			Rental rental = RentalUtility.searchRental(vehicle_id);

			double rentalCostPerHour = rental.getCost_per_hour();
			Customer customer = booking.getCustomer();

			// Fetch referral discount for the customer
			ReferralDiscountsServiceImp referralDiscountsServiceImp = new ReferralDiscountsServiceImp();
			ReferralDiscounts referralDiscount = referralDiscountsServiceImp.searchReferralDiscount(customer);

			LoyaltyPointsServiceImp loyaltyPointsServiceImp = new LoyaltyPointsServiceImp();

			System.out.println("RentalCost Per Hour : " + rentalCostPerHour);
			System.out.println("Duration : " + duration.toHours());
			Long amount = (long) (duration.toHours() * rentalCostPerHour);
			BookingServiceImp BookingServiceImp = new BookingServiceImp();

			int numberOfBookings = BookingServiceImp.getNumberOfBookingsForCustomer(customer.getCustomer_id());
			ReferralDiscountsServiceImp ReferralDiscountsServiceImp = new ReferralDiscountsServiceImp();
			
			ReferralDiscounts referralDiscont = ReferralDiscountsServiceImp.searchReferralDiscount(customer);

			int loyaltyPoint = loyaltyPointsServiceImp.searchLoyaltyPoints(customer);
			if (numberOfBookings >= 15) {
				
				System.out.println("Congragulations you win one day tour..........");
				
			} else if (referralDiscont != null&& referralDiscont.isStatus()) {
		        long discountAmount = (long) (amount * 0.05);
		        amount -= discountAmount;
		        System.out.println("Applied a 5% referral discount.");
				ReferralDiscountsServiceImp.updateStatus(booking.getCustomer().getCustomer_id());

		    
			} else if (loyaltyPoint % 5 == 0) {
				long discountAmount = (long) (amount * 0.05);
				amount -= discountAmount;
				System.out.println("Applied a 5% loyalty points discount.");
			}

			System.out.println("Total Amount : " + amount);
			System.out.println("Enter the Payment_method : ");
			String paymentMethod = scanner.nextLine();

			paymentServiceImp.addPayment(
					new BookingPayment(payment_id, dateIn, dateOut, amount, nPayment_date, paymentMethod, booking));
			BookingPayment payment = paymentServiceImp.searchPayment(payment_id);
			generatePDF(payment);
			System.out.println("Payment processed successfully. Amount paid: " + amount);

		}
	}

	private static void generatePDF(BookingPayment payment) throws DocumentException {
		PDFGenerator pdfGenerator = new PDFGenerator();

		pdfGenerator.generatePDFBill(payment);
	}

}
