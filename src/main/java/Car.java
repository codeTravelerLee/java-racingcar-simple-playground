import java.util.Random;

public class Car {
    private final String name;
    private final StringBuilder moveStatus = new StringBuilder();
    private static final int MOVE_THRESHOLD = 4;
    private static final String MOVE_STATUS_MARKER = "-";
    private final RandomGenerator randomGenerator;

    private int totalMoveCount = 0;
    Random random = new Random();
    public Car(String name, RandomGenerator randomGenerator) {
        this.name = name;
        this.randomGenerator = randomGenerator;
    }

    public void move() {
        int rand = this.randomGenerator.generate();
        if(rand >= MOVE_THRESHOLD) {
            moveStatus.append(MOVE_STATUS_MARKER);
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
