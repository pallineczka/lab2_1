package edu.iis.mto.bsearch;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;

public class BinarySearchTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test public void testEmptySeq() {
        int[] seq = {};
        int key = 5;

        exception.expect(IllegalArgumentException.class);
        BinarySearch.search(key, seq);
    }

    @Test
    public void testElementIsInSeq() {
        int[] seq = {5};
        int key = 5;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertThat(searchResult.isFound(),is(true));
        Assert.assertThat(searchResult.getPosition(),is(0));
    }

    @Test
    public void testElementNotExistInOneElementSeq() {
        int[] seq = {9};
        int key = 5;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertThat(searchResult.isFound(),is(false));
        Assert.assertThat(searchResult.getPosition(),is(-1));
    }

    @Test
    public void testElementIsFirstInSeq() {
        int[] seq = {3, 6, 9};
        int key = 3;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertThat(searchResult.isFound(),is(true));
        Assert.assertThat(searchResult.getPosition(),is(0));
    }

    @Test
    public void testElementIsLastInSeq() {
        int[] seq = {3, 6, 9};
        int key = 9;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertThat(searchResult.isFound(),is(true));
        Assert.assertThat(searchResult.getPosition(),is(seq.length - 1));
    }

    @Test
    public void testElementIsMiddleInSeq() {
        int[] seq = {3, 6, 9};
        int key = 6;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertThat(searchResult.isFound(),is(true));
        Assert.assertThat(searchResult.getPosition(),is((seq.length - 1)/2));
    }

    @Test
    public void testElementNotExistInSeq() {
        int[] seq = {3, 6, 9};
        int key = 5;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertThat(searchResult.isFound(),is(false));
        Assert.assertThat(searchResult.getPosition(),is(-1));
    }

    @Test
    public void testElementIsNegativeInSeq() {
        int[] seq = {-3, 6, 9};
        int key = -3;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertThat(searchResult.isFound(),is(true));
        Assert.assertThat(searchResult.getPosition(),is(0));
    }
}
