package com.springboot.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder(toBuilder = true)
public class HeaderResponse {
    private String id;
    private String mapperName;
    private String destinationTable;
    private boolean headerFlag;
    private List<DetailResponse> mapperDetails;
}
