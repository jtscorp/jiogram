package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WebAppInfo {
    @JsonProperty("url") private final String url;

    @JsonCreator
    public WebAppInfo(
            @JsonProperty("url") String url
    ) {
        this.url = url;
    }

    public String url() {
        return this.url;
    }
}
