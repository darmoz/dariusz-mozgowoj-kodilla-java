package factoryChallenge;

public final class ShoppingTask implements Task {
    final String taskName;
    final String whatToBuy;
    final int quantity;

    public ShoppingTask(final String taskName, final String whatToBuy, final int quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getWhatToBuy() {
        return whatToBuy;
    }

    public int getQuantity() {
        return quantity;
    }

    public void executeTask() {
        System.out.println("Shopping has ben executed");
    }

    public boolean isTaskExecuted() {
        return true;
    }

}
