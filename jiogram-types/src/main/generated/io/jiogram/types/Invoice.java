package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Invoice {
    @JsonProperty("title") private final String title;
    @JsonProperty("description") private final String description;
    @JsonProperty("start_parameter") private final String startParameter;
    @JsonProperty("currency") private final String currency;
    @JsonProperty("total_amount") private final long totalAmount;

    @JsonCreator
    public Invoice(
            @JsonProperty("title") String title,
            @JsonProperty("description") String description,
            @JsonProperty("start_parameter") String startParameter,
            @JsonProperty("currency") String currency,
            @JsonProperty("total_amount") long totalAmount
    ) {
        this.title = title;
        this.description = description;
        this.startParameter = startParameter;
        this.currency = currency;
        this.totalAmount = totalAmount;
    }

    public String title() {
        return this.title;
    }

    public String description() {
        return this.description;
    }

    public String startParameter() {
        return this.startParameter;
    }

    public String currency() {
        return this.currency;
    }

    public long totalAmount() {
        return this.totalAmount;
    }
}
