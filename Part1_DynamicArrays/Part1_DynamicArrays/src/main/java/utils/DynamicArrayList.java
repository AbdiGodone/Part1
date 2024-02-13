package utils;

/**
 *
 * @author michelle
 */
public class DynamicArrayList {

    private final int maxInitialSize = 1000;
    private final int minInitialSize = 5;

    protected int num_elements;
    protected int initialSize;

    private String[] array;


    public DynamicArrayList() {
        array = new String[minInitialSize];
    }

    /**
     *this constructor has a parameter the initialSize of the array it asks the user for initialSize
     * it has validations such as the user cannot initialise to 0 or less in the array, and we throw IllegalArgument
     * another validation I have a max size which is 1000 if they enter number greater than that then we make initialSize to 1000 as it's the closest to our max
     * other than that we make initialSize be the same as to what the user entered
     * lastly we make an array of type string and the size of the initialSize
     */
    public DynamicArrayList(int initialSize){
        if (initialSize <= 0) {
            throw new IllegalArgumentException("Initial size cannot be less than zero");
        } else if (initialSize > maxInitialSize) {
            this.initialSize = maxInitialSize;
        } else {
            this.initialSize = initialSize;
        }

        array = new String[initialSize];
    }



    /**
     *this method gets a position to check in the array which is validated, returns the elements in that position
     * @param pos the position being searched in the array
     * @return the index position
     */
    public String get(int pos){
        if (pos < 0 || pos>=array.length ){
            throw new IndexOutOfBoundsException("position given not in the array");
        }

        return array[pos];
    }

    /**
     *this method takes a String text and compares all the text in the array until it finds a match ignores case and returns the index which it was found
     * if we do not find match it means it's not in the array, and we return -1
     * @param text the String to be found
     * @return the index in which the string was found
     */
    public int indexOf(String text){
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(text)){
              return i;
            }

        }
        //indicating that the string cannot be found in the array
        return -1;
    }

    /**
     * this method gets a String parameter and adds it to my array, returns nothing
     * if the number of elements in the array reaches the same size as the array length we grow the array as we cant add without growing
     * if there is space then we reach the last in the array with the num_element, and we add the text,
     * and we increment the num_element
     *
     * @param text the text to be added to my array
     */
    public void add(String text){
        if (num_elements == array.length){
                Grow(array);
        }
        array[num_elements] = text;
        num_elements++;
    }

    /**
     * this method returns the size of my array
     * @return the size of my array
     */
    public int size(){
        return num_elements;
    }


    /**
     *this method takes in two parameters a string called st and it overwrites the string in that position provided, the position is validated
     * saves the value that was overwritten in a variable and overwrites the value and then returns the variable that has the value that was deleted
     * @param text the new string to be added
     * @param position the position in which it will be added
     */
   public String set(int position, String text){
       if (position < 0 || position >= array.length) {
           throw new IndexOutOfBoundsException();
       }
       String previousValue= array[position];

       array[position] = text;


       return previousValue;
    }

    /**
     * this method checks if the string passed in the parameter is in the array if it's in the array it does shift delete
     * @param text the text to be removed
     * @return boolean false if unsuccessful and true if successful
     */
    public boolean remove(String text){
        boolean deleted = false;
        if (text == null){
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < num_elements; i++) {
            //outer loop loops through the array
            if (text.equals(array[i])){
                //if it finds element
                for (int j = i; j < num_elements - 1; j++) {
                    //inner loop loops from the element found the end of the array and does shift delete
                    array[j] = array[j + 1];
                }
                //when deleted we decrement the num_elements
                num_elements--;
                deleted = true;

            }


        }
return deleted;
    }


    /**
     * this method sets my numOfElements back to 0
     */
    public void clear(){

        num_elements = 0;
    }


    /**
     * this method grows my array everytime that it reaches the array length, and it grows by 100 every time
     * @param text the array which will be passed when called
     */
    public void Grow(String[] text) {
        String[] newArray = new String[array.length + 100];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }
}
