package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingGame {
    private final Scanner scanner = new Scanner(System.in);
    public void run() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        //자동차의 이름을 입력받는다
        String[] carNamesArray = getValidateCarNames();
        ArrayList<Car> cars = new ArrayList<>();
        for(String carName: carNamesArray) {
            cars.add(new Car(carName.trim(), randomNumberGenerator ));
        }

        //시도 횟수를 입력받는다.
        int tryCount = getValidateTryCount();

        printPlayResult(tryCount, cars);
        printWinner(cars);
    }

    private String[] getValidateCarNames() {
        while(true) {
            try{
                System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
                String carNames = scanner.nextLine();
                String[] carNamesArray = carNames.split(",");
                validateCarNameInput(carNamesArray);

                return carNamesArray;
            } catch(final IllegalArgumentException e) {
                System.out.println("에러! :" + e.getMessage());
            }
        }
    }

    private int getValidateTryCount() {
        while(true) {
            try {
                System.out.println("시도할 횟수는 몇 회인가요?");
                int tryCount = scanner.nextInt();
                validateTryCountInput(tryCount);

                return tryCount;
            } catch(final IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void validateCarNameInput(String[] carNamesArray) {
        if(carNamesArray.length < 2) {
            throw new IllegalArgumentException("쉼표로 구분된 2대 이상의 자동차를 입력해주세요.");
        }
    }

    public void validateTryCountInput(int count) {
        if(count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1번 이상이어야 해요!");
        }
    }

    private void printPlayResult(int tryCount, ArrayList<Car> cars) {
        System.out.println("실행 결과");
        for(int i=0; i<tryCount; i++) {
            for (Car car : cars) {
                System.out.print(car.getName() + " :");
                car.move();
            }
            System.out.println();
        }
    }

    private void printWinner(ArrayList<Car> cars) {
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

        String result = String.join(",", winners) + "가 최종 우승했습니다.";
        System.out.println(result);
    }
}
