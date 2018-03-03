package com.arolla.legacy.testing.quotebot;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AdSpaceTest {

    @Test
    public void shouldReturngetAdSpaces() {
        TestableAdSpace testableAdSpace = new TestableAdSpace(new ArrayList<>());
        Collection<String> testableAdSpaces = testableAdSpace.getTestableAdSpaces();
        assertThat(testableAdSpaces.isEmpty(), is(true));
    }

    private class TestableAdSpace extends AdSpace {

        private Collection<String> listAllBlogs;

        public TestableAdSpace(Collection<String> listAllBlogs) {
            this.listAllBlogs = listAllBlogs;
        }

        @Override
        protected Collection<String> getListAllBlogs() {
            return listAllBlogs;
        }
    }
}