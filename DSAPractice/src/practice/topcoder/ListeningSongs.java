package practice.topcoder;

import java.util.Arrays;
/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=14123
 * 
 */
public class ListeningSongs {
	public int listen(int[] durations1, int[] durations2, int minutes, int T) {
		int seconds = minutes * 60;
		Arrays.sort(durations1);
		Arrays.sort(durations2);
		int totalSoFar = 0;
		int count = 0;
		int i = 0;
		int j = 0;
		while(i < durations1.length && i < T) {
			totalSoFar += durations1[i++];
			count++;
			if(totalSoFar > seconds)
				return -1;
		}
		if(i >= durations1.length)
			return -1;
		while(j < durations2.length && j < T) {
			totalSoFar += durations2[j++];
			count++;
			if(totalSoFar > seconds)
				return -1;
		}
		if(j >= durations2.length)
			return -1;
		//System.out.println("total" + totalSoFar);
		while(i < durations1.length || j < durations2.length) {
			int val1 = Integer.MAX_VALUE;
			int val2 = Integer.MAX_VALUE;
			if(i < durations1.length)
				val1 = durations1[i];
			if(j < durations2.length)
				val2 = durations2[j];
			if(val1 <= val2) {
				totalSoFar += val1;
				i++;
			} else {
				totalSoFar += val2;
				j++;
			}
			if(totalSoFar > seconds)
				break;
			//System.out.println("total so " + totalSoFar + " count " + count);
			count++;
		}
		System.out.println(count);
		return count;
	}
}
