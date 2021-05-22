import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        float num_1 = getFloat();
        float num_2 = getFloat();
        char operation = getOperation();
        float result = calc(num_1,num_2,operation);
        System.out.print("Result is: " + result);
    }

    public static float getFloat() {
        System.out.print("Input num and ENTER: ");
        float num;
        if (scanner.hasNextFloat()) {
            num = scanner.nextFloat();
        } else {
            System.out.println("Incorrect input. Try once more!");
            scanner.next(); //recursion
            num = getFloat();
        }
        return num;
    }

    public static char getOperation(){
        System.out.print("Input operation: ");
        char operation;
        if (scanner.hasNext()){
            operation = scanner.next().charAt(0);
        }else{
            System.out.println("Incorrect input. Try once more!");
            scanner.next(); //recursion
            operation = getOperation();
        }
        return operation;
    }

    public static float calc(float num_1, float num_2, char operation){
        float result;
        switch(operation){
            case '+':
                result = num_1 + num_2;
                break;
            case '-':
                result = num_1 - num_2;
                break;
            case '*':
                result = num_1 * num_2;
                break;
            case '/':
                result = num_1 / num_2;
                break;
            default:
                System.out.println("Operation is not OK. Try once more!");
                result = calc(num_1, num_2, getOperation()); //recursion
        }
        return result;
    }
}

