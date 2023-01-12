package com.company.TestManager;

import com.company.constants.ANSI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


// abstract class của các test (các class unit test khác phải kế thừa class này)
public abstract class UnitTest {
    private final Test testClass;
    private final List<List<String>> judgmentMessages;
    protected String expectation;
    protected HashMap<String, String> params;
    protected String fullURLString;
    protected String baseURLString;
    protected Assertion assertion;

    protected Integer numOfRepetitions;
    protected Integer totalRepeatedUnitTestPassed;

    public UnitTest(Test testClass, String expectation, Integer numOfRepetitions) {
        this.testClass = testClass;
        this.params = new HashMap<>();
        this.fullURLString = testClass.getFullURLString();
        this.baseURLString = testClass.getBaseUrlString();
        this.expectation = expectation;
        this.assertion = new Assertion();
        this.numOfRepetitions = numOfRepetitions;
        this.judgmentMessages = new ArrayList<>();
        this.totalRepeatedUnitTestPassed = 0;
    }

    public UnitTest(Test testClass, String expectation) {
        this(testClass, expectation, 1);
    }


    //    có thể được gọi ở class con để lấy đc accesstoken
    protected String getAccessToken() {
        return Connection.getAccessToken(this.baseURLString);
    }

    //    thường đc gọi ở class con để gửi post request (ko kèm access token)
    protected <T> T sendPostRequest(Class<T> cl) throws IOException {
        return Connection.sendPostRequest(this.fullURLString, this.params, cl, null);
    }

    //    thường đc gọi ở class con để gửi post request (có kèm access token)
    public <T> T sendPostRequestWithAccessToken(Class<T> cl) throws IOException {
        String accessToken = this.getAccessToken();
        return Connection.sendPostRequest(this.fullURLString, this.params, cl, accessToken);
    }

    //    thường đc gọi ở class con để gửi get request (ko kèm access token)
    protected <T> T sendGetRequest(Class<T> cl) throws IOException {
        return Connection.sendGetRequest(this.fullURLString, this.params, cl, null);
    }

    //    thường đc gọi ở class con để gửi get request (có kèm access token)
    protected <T> T sendGetRequestWithAccessToken(Class<T> cl) throws IOException {
        String accessToken = this.getAccessToken();
        return Connection.sendGetRequest(this.fullURLString, this.params, cl, accessToken);
    }

    //    hàm bắt buộc phải ghi đè ở lớp con
    protected abstract void test() throws IOException;

    protected boolean executeTest(int id) {
//        loop số lần mong muốn
        for (int i = 0; i < numOfRepetitions; i++) {
            try {
//                chạy hàm before each được ovr ở class con
                this.testClass.handledBeforeEach(id);
                this.test();
                this.testClass.handledAfterEach(id);
                this.totalRepeatedUnitTestPassed += this.assertion.judge() ? 1 : 0;

//                lấy đánh giá ở mỗi class assertion sau khi test xong hết sẽ in ra thông báo
                this.judgmentMessages.add(this.assertion.getJudgementString());
            } catch (NullPointerException | IOException e) {
//                chỗ này xử lí lỗi , nếu có lỗi xảy ra thì lỗi sẽ được thêm vào list lỗi để in ra khi test xong
                ArrayList<String> temp = new ArrayList<>();
                temp.add(ANSI.DOUBLE_TAB + e.getMessage());
                temp.addAll(Arrays.stream(e.getStackTrace()).map(v -> ANSI.RED + ANSI.TRIPLE_TAB + v + ANSI.RESET).toList());
                this.judgmentMessages.add(temp);
                this.forceFail();
            } finally {
//                khởi tạo lại assertion mới mỗi lần repeat 1 utest
                this.assertion = new Assertion();
            }
        }
        if (totalRepeatedUnitTestPassed.equals(this.numOfRepetitions)) {
            notifyTestPassed(id);
            return true;
        }
//        chú ý cái này vì nó có phương thức để in ra lỗi
        notifyTestFailed(id);
        return false;
    }

    public void forceFail() {
        this.assertion.forceFail();
    }

    private void notifyTestPassed(int i) {
        System.out.println(ANSI.GREEN + i + ") " + this.expectation + " (repeated " + this.numOfRepetitions + (this.numOfRepetitions == 1 ? " time)" : " times)") + " => Passed!" + ANSI.RESET + "\n");
    }

    private void notifyTestFailed(int i) {
        System.out.println(ANSI.RED + i + ") " + this.expectation + " => Failed!" + ANSI.RESET);
        for (int j = 0; j < this.judgmentMessages.size(); j++) {
            if (this.judgmentMessages.size() > 1)
                System.out.println(ANSI.SINGLE_TAB + ANSI.YELLOW + "Repeated unit test " + (j + 1) + ":" + ANSI.RESET);
            this.judgmentMessages.get(j).forEach(System.out::println);
            System.out.println(ANSI.SINGLE_TAB + ANSI.CLEAR_LINE);
        }
    }

    public String getExpectation() {
        return this.expectation;
    }
}
