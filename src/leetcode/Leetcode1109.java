package leetcode;

import java.util.Arrays;

public class Leetcode1109 {

    private int[] diff;

    private int length;

    public int[] corpFlightBookings(int[][] bookings, int n) {

        diff = new int[n + 1];
        length = n;

        Arrays.fill(diff,0);
        for (int i = 0; i < bookings.length; i++) {
            int[] booking = bookings[i];
            increment(booking);
        }

        return getResult();
    }

    private void increment(int[] booking) {
        int start = booking[0];
        int end = booking[1];
        int difference = booking[2];
        diff[start] += difference;

        if (end + 1 <= length) {
            diff[end + 1] -= difference;
        }
    }

    private int[] getResult() {
        int[] res = new int[length];
        res[0] = diff[1];
        for (int i = 1; i < length; i++) {
            res[i] = res[i - 1] + diff[i + 1];
        }
        return res;
    }



}
