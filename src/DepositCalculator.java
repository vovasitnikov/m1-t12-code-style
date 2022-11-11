import java.util.Scanner;  //Владимир, молодец!!!

public class DepositCalculator {

    double calculateComplexPercentFunction(double a, double y, int d) {   // из задания "удалить постфикс Function", переименовать параметры на "говорящие", это ты увидел первым)))
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return rounding(pay, 2);
    }

    double calculateSimplePercentFunction(double amount, double yearRate, int depositPeriod) { // из задания "удалить постфикс Function"
        return rounding(amount + amount * yearRate * depositPeriod, 2);
    }

    double rounding(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculatingDepositProfit() {
        int period;
        int action;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double out = 0;     //объявление переменной и её инициализация и остальной код, нужна ли здесь отделяющая пустая строка?
        if (action == 1) {
            out = calculateSimplePercentFunction(amount, 0.06, period);
        } else if (action == 2) {
            out = calculateComplexPercentFunction(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculatingDepositProfit();
    }
}
