package exercise;

// BEGIN
class MaxThread extends Thread {

    private int[] numbers;
    private int maxValue;

    MaxThread(int[] array) {
        this.numbers = array;
    }

    @Override
    public void run() {
        maxValue = numbers[0];
        for (int number : numbers) {
            if (number > maxValue) {
                maxValue = number;
            }
        }
    }

    public int getMaxValue() {
        return maxValue;
    }
}
// END
