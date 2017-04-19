package pagerequestsonpagerequestsonpagerequests;

/*
 * Tyler Sefcik
 * Assignment 3
 */

import java.text.NumberFormat;
import java.util.LinkedList;

public class Memory {

	private int size;
	//Manipulation with LinkedList is faster than ArrayList because there is no bit shifting required in memory
	LinkedList<Page> memFifo;
	LinkedList<Page> memLru;
	LinkedList<Page> listF;
	LinkedList<Page> listL;
	private int cacheHit;
	private int cacheMiss;
	private int numRequests;
	private boolean interrupt;

	Memory(int size){
		this.size = size;
		memFifo = new LinkedList<Page>();
		memLru = new LinkedList<Page>();
		listF = new LinkedList<Page>();
		listL = new LinkedList<Page>();
		cacheHit = 0;
		cacheMiss = 0;
		numRequests = 0;
		interrupt = false;
	}

	/*
	 * pageRequest(page parameter){
		     if frames contains page we want
		         cache hit++
		     if it doesn't have what we need
		         cache miss++
		         remove page that is at the top of the toBeRemoved list
		         add the new page to the end of the toBeRemoved list (since it was just inserted)
		}
	 */

	public void fifo(Page p){
		numRequests++;
		if (memFifo.size() < size && !memFifo.contains(p)) {
			cacheMiss++;
			interrupt = true;
			listF.add(p);
			memFifo.add(p);
		} else if(memFifo.size() < size && memFifo.contains(p)) {
			cacheHit++;
			interrupt = false;
		} else {
			if (memFifo.contains(p)) {
				cacheHit++;
				interrupt = false;
			} else {
				cacheMiss++;
				interrupt = true;
				listF.add(p);
				Page temp = listF.remove(0);
				int index = memFifo.indexOf(temp);
				memFifo.set(index, p);
			}
		}
	}

	/*
	 * pageRequest(page parameter){
     if frames contains page we want
         cache hit++
         find the page in the toBeRemoved list
         take it out of its spot and add it to the end of the toBeRemoved list

     if it doesn't have what we need
         cache miss++
         remove page that is at the top of the toBeRemoved list
         add the new page to the end of the toBeRemoved list (since it was just asked for)
}
	 */

	public void lru(Page p){
		numRequests++;
		if (memLru.size() < size && !memLru.contains(p)) {
			cacheMiss++;
			interrupt = true;
			listL.add(p);
			memLru.add(p);
		} else if(memLru.size() < size && memLru.contains(p)) {
			cacheHit++; 
			interrupt = false;
		} else {
			if (memLru.contains(p)) {
				cacheHit++;
				interrupt = false;
				listL.remove(p);
				listL.add(p);
			} else {
				cacheMiss++;
				interrupt = true;
				listL.add(p);
				Page temp = listL.remove(0);
				int index = memLru.indexOf(temp);
				memLru.set(index, p);
			}
		}
	}

	private int getCacheHit() {
		return cacheHit;
	}

	private int getCacheMiss() {
		return cacheMiss;
	}

	private int getNumRequests() {
		return numRequests;
	}

	public void statistics(){
		NumberFormat percent = NumberFormat.getPercentInstance();
		double success = (double) getCacheHit() / getNumRequests();
		System.out.println("Number of cache hits: " + getCacheHit());
		System.out.println("Number of cache misses: " + getCacheMiss());
		System.out.println("Success Rate: " + percent.format(success));
	}

	public void resetStats(){
		numRequests = 0;
		cacheHit = 0;
		cacheMiss = 0;
	}

	public void printMemory(LinkedList<Page> list){
		for (int i = 0; i < list.size(); i++) {
			System.out.print("Frame " + (i+1) + ":   ");
			list.get(i).printPage();
		}

		int j = list.size() + 1;
		while (j < size + 1) {
			System.out.println("Frame " + j + ":     ");
			j++;
		}

		if (interrupt == true) {
			System.out.println("***");
		}
		System.out.println();
	}
}

