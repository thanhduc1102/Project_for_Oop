package com.company.TestManager;

import com.company.BaseURL;
import com.company.constants.ANSI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


// chứa các thuộc tính và phương thức cần cho 1 test để chạy (các class test khác phải kế thừa class này)
public abstract class Test {
    protected String apiName;
    protected String baseURLString;
    protected String fullURLString; //nên lưu ý thuộc tính này để gửi request nếu url cần phải bổ sung thêm route nhỏ (ví dụ: https://auctions-app-2.herokuapp.com/api/login)
    protected ArrayList<UnitTest> unitTests;

    public Test(BaseURL baseURLObject, String apiName) {
        this.baseURLString = baseURLObject.getBaseURL();
        this.apiName = apiName;
        this.fullURLString = baseURLObject.getBaseURL() + '/' + apiName;
        this.unitTests = new ArrayList<>();
    }

    //  phương thức này phải đc ghi đề ở class con
    protected abstract void initUnitTests();

    protected void beforeAll() throws IOException {
    }

    private boolean handledBeforeAll() {
        try {
            beforeAll();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(ANSI.RED + "Failed to prepare unit tests!");
            System.out.println("Try again later" + ANSI.RESET);
            return false;
        }
    }

    protected void beforeEach() throws IOException {
    }

    void handledBeforeEach(int testId) throws IOException {
        try {
            beforeEach();
        } catch (IOException e) {
            System.out.println(ANSI.RED + "Failed to prepare unit test " + testId + ANSI.RESET);
            throw e;
        }
    }

    protected void afterAll() throws IOException {
    }

    private boolean handledAfterAll() {
        try {
            afterAll();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(ANSI.RED + "Failed to finish after unit tests!");
            System.out.println("Try again later" + ANSI.RESET);
            return false;
        }
    }

    protected void afterEach() throws IOException {
    }

    void handledAfterEach(int testId) throws IOException {
        try {
            afterEach();
        } catch (IOException e) {
            System.out.println(ANSI.RED + "Failed to finish unit test " + testId + ANSI.RESET);
            throw e;
        }
    }

    private void introduceUnitTests() {
        if (unitTests.size() <= 0) return;
        System.out.print(ANSI.YELLOW);
        System.out.println("\nUnit tests for " + this.apiName + ": ");
        for (int i = 0; i < unitTests.size(); i++) {
            System.out.println("Unit test " + (i + 1) + ": " + unitTests.get(i).getExpectation());
        }
        System.out.println(ANSI.RESET);
    }

    private ArrayList<Integer> takeChosenUnitTestIds() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> chosenUnitTestList = new ArrayList<>();
        System.out.println("Input unit test ids to start testing (end with -1) or input 0 to test all:");
        while (scanner.hasNextInt()) {
            String input = scanner.next();
            if (input.equals("-1")) break;
            int temp = Integer.parseInt(input);
            if (temp > this.unitTests.size() || temp < -1) {
                System.out.println("Invalid unit test id");
                continue;
            }
            if (temp == 0) {
                chosenUnitTestList.clear();
                for (int i = 1; i <= this.unitTests.size(); i++) chosenUnitTestList.add(i);
                break;
            }
            chosenUnitTestList.add(temp);
        }
        return chosenUnitTestList;
    }

    private void notifyUnitTestsPassedOrFail(int totalUnitTests, ArrayList<String> failedTestList) {
        int totalTestsPassed = totalUnitTests - failedTestList.size();
        String color = totalTestsPassed == totalUnitTests ? ANSI.GREEN : ANSI.RED;
        System.out.println("\n" + color + "Total: " + totalTestsPassed + " of " + totalUnitTests + " tests passed!" + ANSI.RESET);
        if (failedTestList.size() <= 0) return;
        System.out.println(ANSI.RED + (failedTestList.size() != 1 ? "Failed test ids: " : "Failed test id: ") + String.join(", ", failedTestList) + ANSI.RESET);
    }

    //    thực hiện chọn test id để test trong 1 test api và loop qua những id đc chọn để gọi unittest và thực hiện unittest đó. Trước khi chạy các unittest đc chọn thì hàm beforeall đc chạy và sau khi unittest chạy xong hàm after all được chạy
    private void executeUnitTests() {
        if (this.unitTests.size() <= 0) {
            System.out.println(ANSI.YELLOW + "This api has no test!" + ANSI.RESET);
            return;
        }
        System.out.println(ANSI.YELLOW + "Preparing unit tests..." + ANSI.RESET);

//        chạy phương thức beforeAll được override ở class con nếu có lỗi thì thoát luôn
        if (!handledBeforeAll()) return;

//        khởi tạo fail test list mục đích để so sánh với các test đã chọn và đưa ra test pass hay fail
        ArrayList<String> failedTestList = new ArrayList<>();

//        thực hiện lấy các id của user nhập vào
        ArrayList<Integer> chosenUnitTestList = takeChosenUnitTestIds();

//        loop và chạy các unittest
        for (Integer testId : chosenUnitTestList) {
            boolean passed = this.unitTests.get(testId - 1).executeTest(testId);
            if (!passed) failedTestList.add(testId.toString());
        }

//        chạy phoưng thức after all được override ở class con nếu có lỗi thì thông báo lỗi và thoát
        if (!handledAfterAll()) return;
        
//        hàm có nhiệm vụ đưa ra test pass hay fail
        notifyUnitTestsPassedOrFail(chosenUnitTestList.size(), failedTestList);
    }

    protected void startTest() {
        initUnitTests();
        introduceUnitTests();
        executeUnitTests();
    }


    public String getFullURLString() {
        return fullURLString;
    }

    public String getBaseUrlString() {
        return baseURLString;
    }
}
