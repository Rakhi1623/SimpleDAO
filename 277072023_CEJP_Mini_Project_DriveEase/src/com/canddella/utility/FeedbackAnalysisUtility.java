package com.canddella.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

import com.canddella.entity.Customer;
import com.canddella.entity.Drivers;
import com.canddella.entity.FeedbackAnalysis;
import com.canddella.service.FeedbackAnalysisServiceImp;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;

public class FeedbackAnalysisUtility {

	public static void main(String[] args) {
		feedbackAnalysisMenu();
	}

	public static void feedbackAnalysisMenu() {
		char selectChoice;
		do {

			Scanner scanner = new Scanner(System.in);

			System.out.println("1.Add FeedbackAnalysis \n2.Display All FeedbackAnalysis\n3.Analysis Feedback\n4.Analysis of sentiment\n5.Result Feedback Analysis");
			int choice = scanner.nextInt();

			if (choice == 1) {
				addFeedbackAnalysis();
			} else if (choice == 2) {
				displayAllFeedbackAnalysis();

			}else if (choice==3) {
				analysisFeedback();
				
			}
			else if(choice==4) {
				sentimentResultAnalysis();
				
			}else if(choice==5) {
				  scanner.nextLine();
	                System.out.println("Enter the Driver ID: ");
	                String driverId = scanner.nextLine();
	                displayFeedbacksByDriverId(driverId);
			}
			  
			System.out.println("do you want continue");
			selectChoice = scanner.next().charAt(0);
		} while (selectChoice == 'y' || selectChoice == 'Y');

	}

	private static void displayFeedbacksByDriverId(String driverId) {
	
		    FeedbackAnalysisServiceImp feedbackAnalysisServiceImp = new FeedbackAnalysisServiceImp();

		    ArrayList<FeedbackAnalysis> feedbackAnalysisList;
		    feedbackAnalysisList = (ArrayList<FeedbackAnalysis>) feedbackAnalysisServiceImp.listAllFeedbackAnalysis();

		    Properties props = new Properties();
		    props.setProperty("annotators", "tokenize, ssplit, pos, lemma, parse, sentiment");
		    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

		    System.out.println("Feedbacks for Driver ID " + driverId + ":");

		    for (FeedbackAnalysis feedbackAnalysis : feedbackAnalysisList) {
		        if (feedbackAnalysis.getDriver().getDriver_Id().equals(driverId)) {
		            String feedbackText = feedbackAnalysis.getFeedback();

		            Annotation annotation = new Annotation(feedbackText);
		            pipeline.annotate(annotation);

		            CoreMap sentence = annotation.get(CoreAnnotations.SentencesAnnotation.class).get(0);
		            String sentiment = sentence.get(SentimentCoreAnnotations.SentimentClass.class);

		            System.out.println("Feedback: " + feedbackText);
		            System.out.println("Sentiment: " + sentiment);
		            System.out.println();
		        }
		    }
		}

		
	

	private static void sentimentResultAnalysis() {
		FeedbackAnalysisServiceImp FeedbackAnalysisServiceImp = new FeedbackAnalysisServiceImp();

		ArrayList<FeedbackAnalysis> FeedbackAnalysisList;
		FeedbackAnalysisList = (ArrayList<FeedbackAnalysis>) FeedbackAnalysisServiceImp.listAllFeedbackAnalysis();
        // Set up Stanford NLP pipeline
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, parse, sentiment");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        
       HashMap<String, String> driverSentimentAnalysis = new HashMap<>();
        
        for (FeedbackAnalysis feedbackAnalys : FeedbackAnalysisList) {
        	String driverId = feedbackAnalys.getDriver().getDriver_Id();
            String feedbackText = feedbackAnalys.getFeedback();
      
        Annotation annotation = new Annotation(feedbackText);
        pipeline.annotate(annotation);

        // Get sentiment annotation from the annotation
        CoreMap sentence = annotation.get(CoreAnnotations.SentencesAnnotation.class).get(0);
        String sentiment = sentence.get(SentimentCoreAnnotations.SentimentClass.class);

        driverSentimentAnalysis.put(driverId, sentiment);
    }
        for (HashMap.Entry<String, String> entry : driverSentimentAnalysis.entrySet()) {
            String driverId = entry.getKey();
            String sentiment = entry.getValue();
            System.out.println("Driver ID: " + driverId + " Sentiment: " + sentiment);
        }
    }
	

	

	private static void analysisFeedback() {
		FeedbackAnalysisServiceImp FeedbackAnalysisServiceImp = new FeedbackAnalysisServiceImp();

		ArrayList<FeedbackAnalysis> FeedbackAnalysisList;
		FeedbackAnalysisList = (ArrayList<FeedbackAnalysis>) FeedbackAnalysisServiceImp.listAllFeedbackAnalysis();
        // Set up Stanford NLP pipeline
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, parse, sentiment");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        
        
        
        for (FeedbackAnalysis feedbackAnalys : FeedbackAnalysisList) {
            String feedbackText = feedbackAnalys.getFeedback();
        // Create an annotation with the text
        Annotation annotation = new Annotation(feedbackText);
        pipeline.annotate(annotation);

        // Get sentiment annotation from the annotation
        CoreMap sentence = annotation.get(CoreAnnotations.SentencesAnnotation.class).get(0);
        String sentiment = sentence.get(SentimentCoreAnnotations.SentimentClass.class);

        System.out.println("Sentiment: " + sentiment);
    }
		
	}

	private static void displayAllFeedbackAnalysis() {
		FeedbackAnalysisServiceImp FeedbackAnalysisServiceImp = new FeedbackAnalysisServiceImp();

		ArrayList<FeedbackAnalysis> FeedbackAnalysisList;
		FeedbackAnalysisList = (ArrayList<FeedbackAnalysis>) FeedbackAnalysisServiceImp.listAllFeedbackAnalysis();
		for (FeedbackAnalysis feedbackanaly : FeedbackAnalysisList) {
			System.out.println(feedbackanaly.getFeedback_Id() + "   " + feedbackanaly.getCustomer().getCustomer_id()
					+ "   " + feedbackanaly.getDriver().getDriver_Id() + "   " + feedbackanaly.getFeedback());

		}

	}

	private static void addFeedbackAnalysis() {
		FeedbackAnalysisServiceImp FeedbackAnalysisServiceImp = new FeedbackAnalysisServiceImp();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the FeedbackAnalysis_id : ");
		String feedbackAnalysis_id = scanner.nextLine();
		System.out.println("Enter the Customer_id : ");
		String customer_id = scanner.nextLine();
		Customer customer = new Customer();
		customer.setCustomer_id(customer_id);
		System.out.println("Enter the Driver-id : ");
		String driver_id = scanner.nextLine();
		Drivers driver = new Drivers();
		driver.setDriver_Id(driver_id);
		System.out.println("Enter the Feedback : ");
		String Feedback = scanner.nextLine();

		FeedbackAnalysisServiceImp
				.addFeedbackAnalysis(new FeedbackAnalysis(feedbackAnalysis_id, Feedback, customer, driver));
	}

}
