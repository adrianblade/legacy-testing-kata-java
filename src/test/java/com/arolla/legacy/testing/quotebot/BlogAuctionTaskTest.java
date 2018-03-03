package com.arolla.legacy.testing.quotebot;

import com.arolla.legacy.testing.thirdparty.quotebot.MarketStudyVendor;
import com.arolla.legacy.testing.thirdparty.quotebot.QuotePublisher;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BlogAuctionTaskTest {

    @Test
    public void shouldSlowModGetProposalReturnProponsal() {
        MarketStudyVendor studyVendor = mock(MarketStudyVendor.class);
        when(studyVendor.averagePrice(anyString())).thenReturn(2.0);
        QuotePublisher publisher = mock(QuotePublisher.class);
        BlogAuctionTask auctionTask = new TestableBlogAuctionTask(studyVendor, publisher, 10);
        auctionTask.PriceAndPublish("asdf", "SLOW");
        verify(publisher).publish(12.56d);
    }

    @Test
    public void shouldMediumModGetProposalReturnProponsal() {
        MarketStudyVendor studyVendor = mock(MarketStudyVendor.class);
        when(studyVendor.averagePrice(anyString())).thenReturn(2.0);
        QuotePublisher publisher = mock(QuotePublisher.class);
        BlogAuctionTask auctionTask = new TestableBlogAuctionTask(studyVendor, publisher, 10);
        auctionTask.PriceAndPublish("asdf", "MEDIUM");
        verify(publisher).publish(12.56d);
    }

    @Test
    public void shouldFastModGetProposalReturnProponsal() {
        MarketStudyVendor studyVendor = mock(MarketStudyVendor.class);
        when(studyVendor.averagePrice(anyString())).thenReturn(2.0);
        QuotePublisher publisher = mock(QuotePublisher.class);
        BlogAuctionTask auctionTask = new TestableBlogAuctionTask(studyVendor, publisher, 10);
        auctionTask.PriceAndPublish("asdf", "FAST");
        verify(publisher).publish(12.56d);
    }

    @Test
    public void shouldULTRAFASTModGetProposalReturnProponsal() {
        MarketStudyVendor studyVendor = mock(MarketStudyVendor.class);
        when(studyVendor.averagePrice(anyString())).thenReturn(2.0);
        QuotePublisher publisher = mock(QuotePublisher.class);
        BlogAuctionTask auctionTask = new TestableBlogAuctionTask(studyVendor, publisher, 10);
        auctionTask.PriceAndPublish("asdf", "ULTRAFAST");
        verify(publisher).publish(12.56d);
    }

    @Test
    public void shouldSlowModGetProposalReturnProponsalEven() {
        MarketStudyVendor studyVendor = mock(MarketStudyVendor.class);
        when(studyVendor.averagePrice(anyString())).thenReturn(3.0);
        QuotePublisher publisher = mock(QuotePublisher.class);
        BlogAuctionTask auctionTask = new TestableBlogAuctionTask(studyVendor, publisher, 10);
        auctionTask.PriceAndPublish("asdf", "SLOW");
        verify(publisher).publish(-3.83700943079937E14d);
    }

    @Test
    public void shouldMediumModGetProposalReturnProponsalEven() {
        MarketStudyVendor studyVendor = mock(MarketStudyVendor.class);
        when(studyVendor.averagePrice(anyString())).thenReturn(3.0);
        QuotePublisher publisher = mock(QuotePublisher.class);
        BlogAuctionTask auctionTask = new TestableBlogAuctionTask(studyVendor, publisher, 10);
        auctionTask.PriceAndPublish("asdf", "MEDIUM");
        verify(publisher).publish(-7.67401886159874E14d);
    }

    @Test
    public void shouldFastModGetProposalReturnProponsalEven() {
        MarketStudyVendor studyVendor = mock(MarketStudyVendor.class);
        when(studyVendor.averagePrice(anyString())).thenReturn(3.0);
        QuotePublisher publisher = mock(QuotePublisher.class);
        BlogAuctionTask auctionTask = new TestableBlogAuctionTask(studyVendor, publisher, 10);
        auctionTask.PriceAndPublish("asdf", "FAST");
        verify(publisher).publish(-1.534803772319748E15d);
    }

    @Test
    public void shouldULTRAFASTModGetProposalReturnProponsalEven() {
        MarketStudyVendor studyVendor = mock(MarketStudyVendor.class);
        when(studyVendor.averagePrice(anyString())).thenReturn(3.0);
        QuotePublisher publisher = mock(QuotePublisher.class);
        BlogAuctionTask auctionTask = new TestableBlogAuctionTask(studyVendor, publisher, 10);
        auctionTask.PriceAndPublish("asdf", "ULTRAFAST");
        verify(publisher).publish(-2.49405613001959E15d);
    }

    private class TestableBlogAuctionTask extends BlogAuctionTask {
        QuotePublisher publiser;
        long currentTime;

        public TestableBlogAuctionTask(MarketStudyVendor studyVendor, QuotePublisher publiser, long currentTime) {
            super(studyVendor);
            this.publiser = publiser;
            this.currentTime = currentTime;
        }

        @Override
        protected QuotePublisher getQuotePubliser() {
            return this.publiser;
        }

        @Override
        protected long getCurrentTime() {
            return this.currentTime;
        }
    }
}