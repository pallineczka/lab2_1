package edu.iis.mto.bsearch;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

    @Test public void emptySeq() throws IllegalArgumentException {
        int[] seq = new int[0];
        int key = 5;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertFalse(searchResult.isFound());
        Assert.assertEquals(-1, searchResult.getPosition());
    }

    @Test
    public void elementIsInSeq() {
        int[] seq = {5};
        int key = 5;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertTrue(searchResult.isFound());
        Assert.assertEquals(0, searchResult.getPosition());
    }

    @Test
    public void elementNotExistInSeq() {
        int[] seq = {9};
        int key = 5;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertFalse(searchResult.isFound());
        Assert.assertEquals(-1, searchResult.getPosition());
    }
}
