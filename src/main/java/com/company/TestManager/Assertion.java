package com.company.TestManager;

import com.company.constants.ANSI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// class chứa các phương thức thường dùng để thực hiện việc giả định
public class Assertion {
    private final String defaultFailMessage = "Assertion failed error";
    private AssertionError assertionError;
    private Boolean pass;
    private Object expected;
    private Object actual;

    public Assertion() {
        this.pass = true;
        this.assertionError = null;
        this.expected = null;
        this.actual = null;
    }

    public <T> void assertEquals(T t1, T t2) {
        assertEquals(t1, t2, defaultFailMessage);
    }

    public <T> void assertEquals(T t1, T t2, String failMessage) {
        if (!this.pass) return;
        try {
            assert (t1 == null && t2 == null) || (t1 != null && t1.equals(t2)) : failMessage;
        } catch (AssertionError e) {
            setExpectedAndActual(t2, t1);
            this.assertionError = e;
            this.pass = false;
        }
    }

    public <T> void assertNotEquals(T t1, T t2) {
        assertNotEquals(t1, t2, defaultFailMessage);
    }

    public <T> void assertNotEquals(T t1, T t2, String failMessage) {
        if (!this.pass) return;
        try {
            assert (t1 == null && t2 != null) || (t1 != null && !t1.equals(t2)) : failMessage;
        } catch (AssertionError e) {
            this.setExpectedAndActual(t2, t1);
            this.assertionError = e;
            this.pass = false;
        }
    }

    public <T1, T2> void assertInstanceOf(T1 t1, Class<T2> cl) {
        assertInstanceOf(t1, cl, defaultFailMessage);
    }

    public <T1, T2> void assertInstanceOf(T1 t1, Class<T2> cl, String failMessage) {
        if (!this.pass) return;
        try {
            assert t1 != null && t1.getClass() == cl : failMessage;
        } catch (AssertionError e) {
            this.setExpectedAndActual(cl, t1);
            this.assertionError = e;
            this.pass = false;
        }
    }

    public void assertTrue(Boolean a) {
        assertTrue(a, defaultFailMessage);
    }

    public void assertTrue(Boolean a, String failMessage) {
        if (!this.pass) return;
        try {
            assert a : failMessage;
        } catch (AssertionError e) {
            this.setExpectedAndActual(true, false);
            this.assertionError = e;
            this.pass = false;
        }
    }

    public boolean judge() {
        return pass;
    }

    public void forceFail() {
        this.pass = false;
    }

    public List<String> getJudgementString() {
        if (assertionError == null) return List.of(ANSI.GREEN + ANSI.DOUBLE_TAB + "Passed" + ANSI.RESET);
        List<String> temp = new ArrayList<>(getExpectedAndActualString());
        temp.addAll(getStackTraceString());

        return temp;
    }

    private <T1, T2> void setExpectedAndActual(T1 expected, T2 actual) {
        this.expected = expected;
        this.actual = actual;
    }

    private List<String> getExpectedAndActualString() {
        return List.of(ANSI.DOUBLE_TAB + "Expected value: " + ANSI.RED + this.expected + ANSI.RESET, ANSI.DOUBLE_TAB + "Actual value: " + ANSI.RED + this.actual + ANSI.RESET, "");
    }

    private List<String> getStackTraceString() {
        StackTraceElement[] stackTraceElements = this.assertionError.getStackTrace();
        List<String> temp = new ArrayList<>();
        temp.add(ANSI.DOUBLE_TAB + this.assertionError.getMessage() + " at:" + ANSI.RED);
        Arrays.stream(stackTraceElements, this.assertionError.getMessage().equals(this.defaultFailMessage) ? 2 : 1, stackTraceElements.length).forEach(e -> temp.add(ANSI.TRIPLE_TAB + e));
        temp.add(ANSI.RESET);
        return temp;
    }
}
