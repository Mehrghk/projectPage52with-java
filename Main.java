package com.tt;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DFA dfa = new DFA();
        System.out.print("enter string: ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next(); // گرفتن رشته ورودی

        for (char input : inputString.toCharArray()) {
            dfa.processInput(input);
        }

        // برای چک کردن اینکه آیا در حالت پذیرش هستیم یا خیر
        if (dfa.isAccepting()) {
            System.out.println("Input string accepted.");
        }
        else {
            System.out.println("Input string not accepted.");
        }
    }

    public static class DFA {
        // حالات مختلف DFA
        enum State {
            Q0, Q1, Q2, Q3
        }
        // متغیر برای نگهداری وضعیت فعلی
        private State currentState;
        // سازنده برای تنظیم حالت اولیه
        public DFA() {
            currentState = State.Q0;  // شروع از حالت Q0
        }

        // متد برای پردازش هر ورودی
        public void processInput(char input) {
            switch (currentState) {
                case Q0:
                    if (input == 'a') {
                        currentState = State.Q1;
                    } else if (input == 'b') {
                        currentState = State.Q3;
                    }
                    break;
                case Q1:
                    if (input == 'a') {
                        currentState = State.Q3;
                    } else if (input == 'b') {
                        currentState = State.Q2;
                    }
                    break;
                case Q2:
                    // حالت Q2 یک حالت پذیرش است، از این حالت به خودش حلقه می‌زند
                    if (input == 'a' || input == 'b') {
                        currentState = State.Q2;
                    }
                    break;
                case Q3:
                    // حالت Q3 به خودش حلقه می‌زند
                    if (input == 'a' || input == 'b') {
                        currentState = State.Q3;
                    }
                    break;
            }
        }

        // متد برای چک کردن اینکه آیا در حالت پذیرش هستیم یا خیر
        public boolean isAccepting() {
            return currentState == State.Q2;
        }
    }
}
