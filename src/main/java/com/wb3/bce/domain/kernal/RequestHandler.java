package com.wb3.bce.domain.kernal;

public interface RequestHandler<Request> {
    void Handle (Request request);
}
