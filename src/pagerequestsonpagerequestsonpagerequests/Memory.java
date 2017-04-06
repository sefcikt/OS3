package pagerequestsonpagerequestsonpagerequests;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;

public class Memory {

	private int size;
	LinkedList<Page> memFifo;
	LinkedList<Page> memLru;
	ArrayList<Page> listF;
	ArrayList<Page> listL;
	private int cacheHit;
	private int cacheMiss;
	private int numRequests;
	private boolean hit;

	Memory(int size){
		this.size = size;
		memFifo = new LinkedList<Page>();
		memLru = new LinkedList<Page>();
		listF = new ArrayList<Page>();
		listL = new ArrayList<Page>();
		cacheHit = 0;
		cacheMiss = 0;
		numRequests = 0;
		hit = false;
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
			hit = false;
			listF.add(p);
			memFifo.add(p);
		} else if(memFifo.size() < size && memFifo.contains(p)) {
			cacheHit++;
			hit = true;
		} else {
			if (memFifo.contains(p)) {
				cacheHit++;
				hit = true;
			} else {
				cacheMiss++;
				hit = false;
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
			hit = false;
			listL.add(p);
			memLru.add(p);
		} else if(memLru.size() < size && memLru.contains(p)) {
			cacheHit++; 
			hit = true;
		} else {
			if (memLru.contains(p)) {
				cacheHit++;
				hit = true;
				listL.remove(p);
				listL.add(p);
			} else {
				cacheMiss++;
				hit = false;
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
	
	public void printMemoryF(){
		for (int i = 0; i < memFifo.size(); i++) {
			System.out.print("Frame " + (i+1) + ":   ");
			memFifo.get(i).printPage();
		}
		if (hit == true) {
			System.out.println("***");
		}
		System.out.println();
	}

	public void printMemoryL(){
		for (int i = 0; i < memLru.size(); i++) {
			System.out.print("Frame " + (i+1) + ":   ");
			memLru.get(i).printPage();
		}
		if (hit == true) {
			System.out.println("***");
		}
		System.out.println();
	}

}

