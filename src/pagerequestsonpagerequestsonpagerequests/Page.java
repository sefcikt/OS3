package pagerequestsonpagerequestsonpagerequests;

public class Page {
	private int id;
	Page previous;
	Page next;
	
	Page(int id){
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public Page getPrevious() {
		return previous;
	}
	
	public Page getNext() {
		return next;
	}
	
	public String toString(){
		return "Page " + id;
	}
	
	public void printPage(){
		System.out.println(toString());
	}
	
	public void printEmptyPage(){
		System.out.println("      ");
	}
	
}
