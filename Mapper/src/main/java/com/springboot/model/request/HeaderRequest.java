package com.springboot.model.request;

import lombok.*;

import java.util.List;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder(toBuilder = true)
public class HeaderRequest {
    private String mapperName;
    private String destinationTable;
    private boolean headerFlag;
    private List<DetailRequest> mapperDetails;
}
