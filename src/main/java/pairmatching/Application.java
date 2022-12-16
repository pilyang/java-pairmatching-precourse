package pairmatching;

import pairmatching.controller.PairMatchingController;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        try {
            PairMatchingController pairMatchingController = new PairMatchingController();
            pairMatchingController.startProgram();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // TODO 구현 진행
    }
}
