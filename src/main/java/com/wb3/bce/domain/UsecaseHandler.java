package com.wb3.bce.domain;

public class UsecaseHandler {

    public void Invoke(Usecase useCase) {
        useCase.execute();
    }

}
