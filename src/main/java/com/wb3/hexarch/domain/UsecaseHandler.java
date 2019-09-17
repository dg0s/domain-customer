package com.wb3.hexarch.domain;

public class UsecaseHandler {

    public void Invoke(UseCase useCase) {
        useCase.execute();
    }

}
