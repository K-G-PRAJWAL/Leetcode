package com.kgprajwal.leetcodejavasolutions;

public class NumberOfLaserBeamsInABank {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int prevDevices = 0;
        int laserBeams = 0;
        for (int i = 0; i < n; i++) {
            int currDevices = 0;
            for (int j = 0; j < bank[0].length(); j++) {
                if (bank[i].charAt(j) == '1') currDevices += 1;
            }
            laserBeams += currDevices * prevDevices;
            if (currDevices != 0) prevDevices = currDevices;
        }
        return laserBeams;
    }
}
