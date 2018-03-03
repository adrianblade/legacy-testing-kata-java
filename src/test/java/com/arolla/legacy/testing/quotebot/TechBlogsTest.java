package com.arolla.legacy.testing.quotebot;


import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TechBlogsTest {

    @Test
    public void shouldListAllBlogsNotEmpty() {
        assertThat(TechBlogs.listAllBlogs().isEmpty(), is(false));
    }
}