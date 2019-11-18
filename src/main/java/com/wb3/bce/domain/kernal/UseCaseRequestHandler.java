package com.wb3.bce.domain.kernal;

public interface UseCaseRequestHandler<Request> {
    void Handle (Request request);
}
