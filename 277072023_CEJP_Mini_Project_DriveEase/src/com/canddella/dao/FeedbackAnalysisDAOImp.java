package com.canddella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Customer;
import com.canddella.entity.Drivers;
import com.canddella.entity.FeedbackAnalysis;

public class FeedbackAnalysisDAOImp implements FeedbackAnalysisDAO {

	@Override
	public void updateFeedbackAnalysis(String feedback_Id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<FeedbackAnalysis> listAllFeedbackAnalysis() {
		
		ArrayList<FeedbackAnalysis> feedbackAnalysiseList = new ArrayList();
		
		try {
		
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection= ds.getConnection();
			
			
			String sqlQuery = "select * from feedbackanalysis";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			ResultSet resultSet	= statement.executeQuery();
			
			
			while(resultSet.next())
			{
				Customer customer = new Customer();
				customer.setCustomer_id(resultSet.getString(2));
				Drivers driver = new Drivers();
				driver.setDriver_Id(resultSet.getString(3));
			
				FeedbackAnalysis feedbackAnalysis = new FeedbackAnalysis(resultSet.getString(1),resultSet.getString(4),customer,driver);
				feedbackAnalysiseList.add(feedbackAnalysis);
			}
			connection.close();
		
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		
		}
			
		return feedbackAnalysiseList;
		
	
		
		
	

		
	
	}

	@Override
	public FeedbackAnalysis searchFeedbackAnalysis(FeedbackAnalysis feedbackAnalysis) {

		return null;
	}

	@Override
	public void addFeedbackAnalysis(FeedbackAnalysis feedbackAnalysis) {

		try {
			Connection connection = null;
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();

			String sqlQuery = "insert into feedbackanalysis (feedback_id,customer_id,driver_id,feedback) "
					+ "values(?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setString(1, feedbackAnalysis.getFeedback_Id());
			statement.setString(2, feedbackAnalysis.getCustomer().getCustomer_id());
			statement.setString(3, feedbackAnalysis.getDriver().getDriver_Id());
			statement.setString(4, feedbackAnalysis.getFeedback());

			statement.executeUpdate();

			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
}
