package exercise;

class SafetyList {
    // BEGIN
    private int[] elementData = new int[10];
    private int size = 0;

    public int getSize() {
        return size;
    }

    public int get(int index) {
        return elementData[index];
    }

    public synchronized void add(int element) {
        int currentLength = elementData.length;
        if (currentLength == size) {
            int[] newElementDate = new int[currentLength * 2];
            System.arraycopy(elementData, 0, newElementDate, 0, currentLength);
            elementData = newElementDate;
        }
        elementData[size++] = element;
    }
    // END
}
