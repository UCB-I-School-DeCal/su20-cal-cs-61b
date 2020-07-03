/** Array based list.
 *  @author Josh Hug
 */

public class AList {
    private int[] items;
    private int size;

    /** Creates an empty list. */
    public AList() {
        item new int[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        // If out of space, resize array!
        if (size==items.length) {
            int[] a = new int[size + 1];
            /** arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
             *     src − This is the source array.
             *     srcPos − This is the starting position in the source array.
             *     dest − This is the destination array.
             *     destPos − This is the starting position in the destination data.
             *     length − This is the number of array elements to be copied.        */
            System.arraycopy(items, 0, a, 0, size);
            items = a;
        }
        // Below is the same whether or not you resize array
        items[size] = x;
        size += 1;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return items[size-1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int removeLast() {
        returnItem =items[size-1];
        items[size-1] = 0;  // Save memory now
        size -= 1 ;
        return returnItem;
    }
} 