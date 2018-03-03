package com.arolla.legacy.testing.quotebot;

import java.util.Calendar;
import java.util.Date;

import com.arolla.legacy.testing.thirdparty.quotebot.MarketStudyVendor;
import com.arolla.legacy.testing.thirdparty.quotebot.QuotePublisher;

public class BlogAuctionTask {

	private final MarketStudyVendor marketDataRetriever;

	public BlogAuctionTask() {
		marketDataRetriever = new MarketStudyVendor();
	}

	public BlogAuctionTask(MarketStudyVendor marketDataRetriever) {
		this.marketDataRetriever = marketDataRetriever;
	}

	@SuppressWarnings("deprecation")
	public void PriceAndPublish(String blog, String mode) {
		double avgPrice = marketDataRetriever.averagePrice(blog);
		double proposal = getProposal(avgPrice, mode);
		getQuotePubliser().publish(proposal);
	}

	protected QuotePublisher getQuotePubliser() {
		return QuotePublisher.INSTANCE;
	}

	private double getProposal(double avgPrice, String mode) {
		if (avgPrice % 2 == 0){
			return 3.14 * (avgPrice + 2);
		} else {
			return 3.15
					* getTimeFactor(mode)
					* (getCurrentTime() - new Date(2000, Calendar.JANUARY, 1)
					.getTime());
		}
	}

	private double getTimeFactor (String mode) {
		double timeFactor = 1;
		if (mode.equals("SLOW")) {
			timeFactor = 2;
		}
		if (mode.equals("MEDIUM")) {
			timeFactor = 4;
		}
		if (mode.equals("FAST")) {
			timeFactor = 8;
		}
		if (mode.equals("ULTRAFAST")) {
			timeFactor = 13;
		}
		return timeFactor;
	}

	protected long getCurrentTime() {
		return new Date().getTime();
	}
}
