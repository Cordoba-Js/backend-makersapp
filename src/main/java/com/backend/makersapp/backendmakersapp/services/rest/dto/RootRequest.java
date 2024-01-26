package com.backend.makersapp.backendmakersapp.services.rest.dto;

public class RootRequest {
    public Embedded _embedded;

    public Embedded get_embedded() {
        return _embedded;
    }

    public void set_embedded(Embedded _embedded) {
        this._embedded = _embedded;
    }
    
}
