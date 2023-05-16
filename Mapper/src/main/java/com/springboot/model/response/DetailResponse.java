package com.springboot.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder(toBuilder = true)
public class DetailResponse {
    private String id;
    private String mapperId;
    private String name;
    private String dataType;
    private String destinationColumn;
}
