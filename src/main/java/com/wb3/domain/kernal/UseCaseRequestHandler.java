package com.wb3.domain.kernal;

public interface UseCaseRequestHandler<Request> {
    void Handle (Request request);
}
