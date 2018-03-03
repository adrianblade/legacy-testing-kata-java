package com.arolla.legacy.testing.quotebot;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AutomaticQuoteBotTest {

    @Test
    public void sendAllQuotes() {
        IAdSpace mockAdSpace = mock(IAdSpace.class);
        when(mockAdSpace.getTestableAdSpaces())
                .thenReturn(
                        Arrays.asList(
                                "HackerNews", "Reddit",
                                "TechCrunch", "BuzzFeed",
                        "TMZ", "TheHuffPost", "GigaOM") );
        for (String blog : mockAdSpace.getTestableAdSpaces()) {
            BlogAuctionTask auctionTask = new BlogAuctionTask();
            auctionTask.PriceAndPublish(blog, null);
        }
    }
}