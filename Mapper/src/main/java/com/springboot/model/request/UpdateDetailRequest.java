package com.springboot.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder(toBuilder = true)
public class UpdateDetailRequest {
    private String id;
    private String mapperId;
    private String name;
    private String dataType;
    private String destinationColumn;
}
