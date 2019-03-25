package edu.iis.mto.bsearch;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

    @Test public void testEmptySeq() throws IllegalArgumentException {
        int[] seq = new int[0];
        int key = 5;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertFalse(searchResult.isFound());
        Assert.assertEquals(-1, searchResult.getPosition());
    }

    @Test
    public void testElementIsInSeq() {
        int[] seq = {5};
        int key = 5;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertTrue(searchResult.isFound());
        Assert.assertEquals(0, searchResult.getPosition());
    }

    @Test
    public void testElementNotExistInOneElementSeq() {
        int[] seq = {9};
        int key = 5;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertFalse(searchResult.isFound());
        Assert.assertEquals(-1, searchResult.getPosition());
    }

    @Test
    public void testElementIsFirstInSeq() {
        int[] seq = {3, 6, 9};
        int key = 3;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertTrue(searchResult.isFound());
        Assert.assertEquals(0, searchResult.getPosition());
    }

    @Test
    public void testElementIsLastInSeq() {
        int[] seq = {3, 6, 9};
        int key = 9;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertTrue(searchResult.isFound());
        Assert.assertEquals(seq.length - 1, searchResult.getPosition());
    }

    @Test
    public void testElementIsMiddleInSeq() {
        int[] seq = {3, 6, 9};
        int key = 6;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertTrue(searchResult.isFound());
        Assert.assertEquals((seq.length - 1)/2, searchResult.getPosition());
    }

    @Test
    public void testElementNotExistInSeq() {
        int[] seq = {3, 6, 9};
        int key = 5;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertFalse(searchResult.isFound());
        Assert.assertEquals(-1, searchResult.getPosition());
    }

    @Test
    public void testElementIsNegativeInSeq() {
        int[] seq = {-3, 6, 9};
        int key = -3;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertTrue(searchResult.isFound());
        Assert.assertEquals(1, searchResult.getPosition());
    }
}
