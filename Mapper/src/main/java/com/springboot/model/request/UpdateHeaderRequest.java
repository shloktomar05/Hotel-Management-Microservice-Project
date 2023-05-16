package com.springboot.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder(toBuilder = true)
public class UpdateHeaderRequest {
    private String id;
    private String mapperName;
    private String destinationTable;
    private boolean headerFlag;
    private List<UpdateDetailRequest> details;
}
