import java.util.Random;

public class Car {
    private final String name;
    private final StringBuilder moveStatus = new StringBuilder();
    private int totalMoveCount = 0;
    Random random = new Random();
    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int rand = random.nextInt(10);
        if(rand >= 4) {
            moveStatus.append("-");
            this.totalMoveCount += 1;
            System.out.println(moveStatus);
            return;
        }
        System.out.println(moveStatus);
    }

    public String getName() {
        return this.name;
    }

    public int getTotalMoveCount() {
        return this.totalMoveCount;
    }
}
