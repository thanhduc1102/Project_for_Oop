package com.company;

import com.company.TestManager.TestManager;
import com.company.constants.ANSI;
import com.company.constants.EndpointConstants;

import java.util.Scanner;

// class chính chứa các hàm thực hiện luồng công việc
public class App {
    private final BaseURL baseUrl;
    private final TestManager testManager;
    private final Scanner scanner;
    private boolean running;

    public App() {
        this.scanner = new Scanner(System.in);
        this.baseUrl = new BaseURL();
        this.testManager = new TestManager();
        this.running = true;
    }

    public void start() {
        tag:
        while (this.running) {
            printOption();
            switch (this.getOption("Select option (integer):")) {
                case 0 -> {
                    this.quitApp();
                    break tag;
                }
                case 1 -> this.checkBaseUrl();
                case 2 -> this.changeBaseUrl();
                case 3 -> this.testAPI();
            }
            int temp = this.getOption("Continue? (1|0)");
            if (temp == 0) this.quitApp();
        }
    }

    private void printOption() {
        System.out.print(ANSI.YELLOW);
        System.out.println("Options: ");
        System.out.println("0) Quit");
        System.out.println("1) Check Base URL");
        System.out.println("2) Change Base URL");
        System.out.println("3) Test API");
        System.out.print(ANSI.RESET);
    }

    private int getOption(String s) {
        System.out.println("\n" + s);
        int option = this.scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    private void checkBaseUrl() {
        System.out.println(this.baseUrl.getBaseURL());
    }

    private void changeBaseUrl() {
        System.out.println("Input Base URL ID to set or input 0 to enter new Base URL string:");
        System.out.println(ANSI.YELLOW);
        EndpointConstants.baseUrls.forEach((i, s) -> System.out.println(i + ") " + s + (i == 1 ? " (Default)" : "")));
        System.out.println(ANSI.RESET);
        int option = getOption("Your choice: ");
        if (option != 0) this.baseUrl.setBaseURL(EndpointConstants.baseUrls.get(option));
        else {
            System.out.println("New Base URL string:");
            String baseURL = scanner.nextLine();
            if (baseURL != null && !baseURL.equals("")) {
                this.baseUrl.setBaseURL(baseURL);
                EndpointConstants.baseUrls.put(EndpointConstants.baseUrls.size() + 1, baseURL);
            } else {
                System.out.println("Will use default Base URL!");
            }
        }
        System.out.println("Base ULR set!");
    }

    private void testAPI() {
        System.out.print(ANSI.YELLOW);
        System.out.println("\nSelect API to test: ");
        for (int i = 1; i <= EndpointConstants.paths.size(); i++) {
            System.out.println(i + ") " + EndpointConstants.testNames.get(i));
        }
        System.out.print(ANSI.RESET);
        int testId = getOption("Input api Id (integer):");
        this.testManager.startTest(testId, this.baseUrl);
    }

    private void quitApp() {
        this.scanner.close();
        this.running = false;
        System.out.println("App quited!");
    }
}
