package com.vm.smartvin.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {
    private String mime;
    private String link;

    @JsonProperty("contextLink")
    private String contextLink;

    private int height;
    private int width;

    @JsonProperty("byteSize")
    private long byteSize;

    @JsonProperty("thumbnailLink")
    private String thumbnailLink;

    @JsonProperty("thumbnailHeight")
    private int thumbnailHeight;

    @JsonProperty("thumbnailWidth")
    private int thumbnailWidth;

    @JsonProperty("hostPageDomainFriendlyName")
    private String hostPageDomainFriendlyName;

    @JsonProperty("accentColor")
    private String accentColor;

    @JsonProperty("datePublished")
    private String datePublished;
}

