package com.canddella.dao;

import java.util.List;

import com.canddella.entity.FeedbackAnalysis;

public interface FeedbackAnalysisDAO {

	FeedbackAnalysis searchFeedbackAnalysis(FeedbackAnalysis feedbackAnalysis);
	
	public void updateFeedbackAnalysis(String feedback_Id) ;
	
	public void addFeedbackAnalysis( FeedbackAnalysis feedbackAnalysis);
	
	public List<FeedbackAnalysis> listAllFeedbackAnalysis ();



}
