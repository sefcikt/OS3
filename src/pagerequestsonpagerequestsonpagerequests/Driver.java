package pagerequestsonpagerequestsonpagerequests;

/*
 * Tyler Sefcik
 * Assignment 3
 */

import java.util.Scanner;

public class Driver {
	
	static Scanner input = new Scanner(System.in);
	static int size;
	
	public static void main(String[] args) {
		System.out.println("Enter the number of frames desired: ");
		size = input.nextInt();
		
		runFifoAndLru();
	}
	
	public static void runFifoAndLru(){
		Page p1 = new Page(1);
		Page p2 = new Page(2);
		Page p3 = new Page(3);
		Page p4 = new Page(4);
		Page p5 = new Page(5);
		Page p6 = new Page(6);
		Page p7 = new Page(7);
		Page p8 = new Page(8);
		Page p9 = new Page(9);
		Page p10 = new Page(10);

		Memory mem = new Memory(size);

		System.out.println();
		System.out.println("------First In First Out------");
		System.out.println();
		
		mem.fifo(p1);
		System.out.println("Request Page 1");
		mem.printMemory(mem.memFifo);
		mem.fifo(p2);
		System.out.println("Request Page 2");
		mem.printMemory(mem.memFifo);
		mem.fifo(p3);
		System.out.println("Request Page 3");
		mem.printMemory(mem.memFifo);
		mem.fifo(p3);
		System.out.println("Request Page 3");
		mem.printMemory(mem.memFifo);
		mem.fifo(p5);
		System.out.println("Request Page 5");
		mem.printMemory(mem.memFifo);
		mem.fifo(p6);
		System.out.println("Request Page 6");
		mem.printMemory(mem.memFifo);
		mem.fifo(p4);
		System.out.println("Request Page 4");
		mem.printMemory(mem.memFifo);
		mem.fifo(p7);
		System.out.println("Request Page 7");
		mem.printMemory(mem.memFifo);
		mem.fifo(p2);
		System.out.println("Request Page 2");
		mem.printMemory(mem.memFifo);
		mem.fifo(p6);
		System.out.println("Request Page 6");
		mem.printMemory(mem.memFifo);
		mem.fifo(p3);
		System.out.println("Request Page 3");
		mem.printMemory(mem.memFifo);
		mem.fifo(p3);
		System.out.println("Request Page 3");
		mem.printMemory(mem.memFifo);
		mem.fifo(p4);
		System.out.println("Request Page 4");
		mem.printMemory(mem.memFifo);
		mem.fifo(p9);
		System.out.println("Request Page 9");
		mem.printMemory(mem.memFifo);
		mem.fifo(p8);
		System.out.println("Request Page 8");
		mem.printMemory(mem.memFifo);
		mem.fifo(p9);
		System.out.println("Request Page 9");
		mem.printMemory(mem.memFifo);
		mem.fifo(p10);
		System.out.println("Request Page 10");
		mem.printMemory(mem.memFifo);
		mem.fifo(p7);
		System.out.println("Request Page 7");
		mem.printMemory(mem.memFifo);
		
		System.out.println();
		mem.statistics();
		mem.resetStats();
		
		System.out.println();
		System.out.println();
		System.out.println("------Least Recently Used------");
		System.out.println();
		
		mem.lru(p1);
		System.out.println("Request Page 1");
		mem.printMemory(mem.memLru);
		mem.lru(p2);
		System.out.println("Request Page 2");
		mem.printMemory(mem.memLru);
		mem.lru(p3);
		System.out.println("Request Page 3");
		mem.printMemory(mem.memLru);
		mem.lru(p3);
		System.out.println("Request Page 3");
		mem.printMemory(mem.memLru);
		mem.lru(p5);
		System.out.println("Request Page 5");
		mem.printMemory(mem.memLru);
		mem.lru(p6);
		System.out.println("Request Page 6");
		mem.printMemory(mem.memLru);
		mem.lru(p4);
		System.out.println("Request Page 4");
		mem.printMemory(mem.memLru);
		mem.lru(p7);
		System.out.println("Request Page 7");
		mem.printMemory(mem.memLru);
		mem.lru(p2);
		System.out.println("Request Page 2");
		mem.printMemory(mem.memLru);
		mem.lru(p6);
		System.out.println("Request Page 6");
		mem.printMemory(mem.memLru);
		mem.lru(p3);
		System.out.println("Request Page 3");
		mem.printMemory(mem.memLru);
		mem.lru(p3);
		System.out.println("Request Page 3");
		mem.printMemory(mem.memLru);
		mem.lru(p4);
		System.out.println("Request Page 4");
		mem.printMemory(mem.memLru);
		mem.lru(p9);
		System.out.println("Request Page 9");
		mem.printMemory(mem.memLru);
		mem.lru(p8);
		System.out.println("Request Page 8");
		mem.printMemory(mem.memLru);
		mem.lru(p9);
		System.out.println("Request Page 9");
		mem.printMemory(mem.memLru);
		mem.lru(p10);
		System.out.println("Request Page 10");
		mem.printMemory(mem.memLru);
		mem.lru(p7);
		System.out.println("Request Page 7");
		mem.printMemory(mem.memLru);
		
		System.out.println();
		mem.statistics();
	}
	
}
