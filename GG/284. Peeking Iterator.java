//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
 private Integer container = null;
 private Iterator<Integer> iterator;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
     if (iterator.hasNext()) {
         container = iterator.next();
     }
	}

 // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
     return this.container;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = container;
     if(iterator.hasNext()) {
         container = iterator.next();
     } else {
         container = null;
     }
     return res;
	}

	@Override
	public boolean hasNext() {
	    return container != null;
	}
}
