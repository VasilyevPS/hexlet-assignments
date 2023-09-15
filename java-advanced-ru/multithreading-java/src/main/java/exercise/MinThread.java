package exercise;

// BEGIN
class MinThread extends Thread {
    private int[] numbers;
    private int minValue;

    MinThread(int[] array) {
        this.numbers = array;
    }

    @Override
    public void run() {
        minValue = numbers[0];
        for (int number : numbers) {
            if (number < minValue) {
                minValue = number;
            }
        }
    }

    public int getMinValue() {
        return minValue;
    }
}
// END
