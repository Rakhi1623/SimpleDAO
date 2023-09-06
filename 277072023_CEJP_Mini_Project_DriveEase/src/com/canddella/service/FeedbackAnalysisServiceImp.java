package com.canddella.service;

import java.util.List;

import com.canddella.dao.FeedbackAnalysisDAOImp;
import com.canddella.entity.FeedbackAnalysis;

public class FeedbackAnalysisServiceImp implements FeedbackAnalysisService {
	FeedbackAnalysisDAOImp feedbackAnalysisDAOImp = new FeedbackAnalysisDAOImp();
	
	@Override
	public FeedbackAnalysis searchFeedbackAnalysis(FeedbackAnalysis feedbackAnalysis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateFeedbackAnalysis(String feedback_Id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addFeedbackAnalysis(FeedbackAnalysis feedbackAnalysis) {
		feedbackAnalysisDAOImp.addFeedbackAnalysis(feedbackAnalysis);

	}

	@Override
	public List<FeedbackAnalysis> listAllFeedbackAnalysis() {
		
		return feedbackAnalysisDAOImp.listAllFeedbackAnalysis();
	}

}
