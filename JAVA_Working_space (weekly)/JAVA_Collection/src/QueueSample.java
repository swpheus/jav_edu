import java.util.LinkedList;

public class QueueSample {
	public static void main(String[] args) {
		QueueSample sample = new QueueSample();
		sample.checkLinkedList1();
	}

	public void checkLinkedList1() {
		// TODO Auto-generated method stub
		LinkedList<String> link =new LinkedList<String>();
		link.add("A");
		link.addFirst("B");
		System.out.println(link);
		link.offerFirst("c");
		System.out.println(link);
		link.addLast("D");
		System.out.println(link);
		link.offer("E");
		System.out.println(link);
		link.offerLast("F");
		System.out.println(link);
		link.push("G");
		System.out.println(link);
		link.add(0,"H");
		System.out.println(link);
		System.out.println("Ex="+link.set(0, "I"));
		System.out.println(link);
	}
}
