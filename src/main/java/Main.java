import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();

        String[] carsNamesArray = carNames.split(",");
        ArrayList<Car> cars = new ArrayList<>(carsNamesArray.length);

        for(String carName: carsNamesArray) {
            cars.add(new Car(carName.trim()));
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = scanner.nextInt();

        System.out.println("실행 결과");
        for(int i=0; i<tryCount; i++) {
            for (Car car : cars) {
                System.out.print(car.getName() + " :");
                car.move();
            }
            System.out.println();
        }

        ArrayList<String> winners = new ArrayList<>(cars.size());

        int highestMoveCount = 0;
        for(Car car: cars) {
            int carMoveCount = car.getTotalMoveCount();

            if (carMoveCount >= highestMoveCount) {
                highestMoveCount = carMoveCount;
            }
        }

        for(Car car: cars) {
            if(car.getTotalMoveCount() == highestMoveCount) {
                winners.add(car.getName());
            }
        }

        for(String winner : winners) {
            System.out.print(winner);
            System.out.print(",");
        }
        System.out.println("가 최종 우승했습니다.");



    }
}
