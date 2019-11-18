package com.wb3.bce.domain.kernal;

public abstract class UseCaseHandler<UseCase extends com.wb3.bce.domain.kernal.UseCase> {
    public void Handle(UseCase usecase) {
        usecase.execute();
    };
}
