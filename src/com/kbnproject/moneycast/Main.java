package com.kbnproject.moneycast;

import com.kbnproject.moneycast.Config.ConfigLoader;
import com.kbnproject.moneycast.Controller.MoneyController;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ConfigLoader config;

        MoneyController controller;

        try{
            config = new ConfigLoader("application.properties");
            String apiKey = config.getProperty("api.key");
            controller = new MoneyController(apiKey);
        }catch(IOException e){
            System.err.println(e.getMessage());
            return;
        }

        while(true) {
            System.out.println("""
                    Choose one option:\s
                    1: USD\s
                    2: COP\s
                    3: BRL\s
                    4: Register\s
                    5: Exit""");

            int castUnit = scanner.nextInt();

            switch (castUnit) {
                case 1:
                    String usd = controller.getMoneyCast("USD");
                    System.out.println("""
                            Select the value cast:\s
                            1: COP\s
                            2: BRL\s
                            3: Back""");

                    int castValue = scanner.nextInt();

                    switch (castValue){
                        case 1:
                            System.out.println(controller.castRate(usd, "COP"));
                            System.out.println("Write the amount to be cast: ");
                            System.out.println(controller.valueCasted(scanner.nextDouble()));
                            break;
                        case 2:
                            System.out.println(controller.castRate(usd, "BRL"));
                            System.out.println("Write the amount to be cast: ");
                            System.out.println(controller.valueCasted(scanner.nextDouble()));
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Invalid option");
                            break;
                    }
                    break;
                case 2:
                    String cop = controller.getMoneyCast("COP");
                    System.out.println("""
                            Select the value cast:\s
                            1: USD\s
                            2: BRL\s
                            3: Back""");

                    switch (scanner.nextInt()){
                        case 1:
                            System.out.println(controller.castRate(cop, "USD"));
                            System.out.println("Write the amount to be cast: ");
                            System.out.println(controller.valueCasted(scanner.nextDouble()));
                            break;
                        case 2:
                            System.out.println(controller.castRate(cop, "BRL"));
                            System.out.println("Write the amount to be cast: ");
                            System.out.println(controller.valueCasted(scanner.nextDouble()));
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Invalid option");
                            break;
                    }
                    break;
                case 3:
                    String brl = controller.getMoneyCast("BRL");
                    System.out.println("""
                            Select the value cast:\s
                            1: USD\s
                            2: COP\s
                            3: Back""");

                    switch (scanner.nextInt()){
                        case 1:
                            System.out.println(controller.castRate(brl, "USD"));
                            System.out.println("Write the amount to be cast: ");
                            System.out.println(controller.valueCasted(scanner.nextDouble()));
                            break;
                        case 2:
                            System.out.println(controller.castRate(brl, "COP"));
                            System.out.println("Write the amount to be cast: ");
                            System.out.println(controller.valueCasted(scanner.nextDouble()));
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Invalid option");
                            break;
                    }
                    break;
                case 4:
                    System.out.println(controller.getList());
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
