package com.arolla.legacy.testing.quotebot;

public class Application {

	private static AutomaticQuoteBot bot = new AutomaticQuoteBot();

	public static void main(String[] args) {
		bot.sendAllQuotes("FAST");
	}

}
