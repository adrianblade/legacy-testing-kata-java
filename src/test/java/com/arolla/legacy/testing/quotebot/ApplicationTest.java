package com.arolla.legacy.testing.quotebot;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ApplicationTest {

    @Test
    public void main() {
        //  create mock
        AutomaticQuoteBot automaticQuoteBotMock = mock(AutomaticQuoteBot.class);
        verify(automaticQuoteBotMock);
    }
}
