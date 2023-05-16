package com.springboot.mapper;

import com.springboot.model.Details;
import com.springboot.model.Header;
import com.springboot.model.request.DetailRequest;
import com.springboot.model.request.HeaderRequest;
import com.springboot.model.request.UpdateDetailRequest;
import com.springboot.model.request.UpdateHeaderRequest;
import com.springboot.model.response.DetailResponse;
import com.springboot.model.response.HeaderResponse;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@UtilityClass
public class MapperMap {
    public Header mapHeaderRequestToHeader(HeaderRequest headerRequest) {
        String uid = UUID.randomUUID().toString();
        return Header.builder()
                .id(uid)
                .headerFlag(headerRequest.isHeaderFlag())
                .mapperName(headerRequest.getMapperName())
                .mapperDetails(
                        mapDetailRequestToDetails(headerRequest.getMapperDetails(), uid))
                .build();
    }

    public List<Details> mapDetailRequestToDetails(List<DetailRequest> detailRequest, String uid) {
        List<Details> details = new ArrayList<>();
        for (DetailRequest detailRequestlist : detailRequest) {
            details.add(
                    Details.builder()
                            .id(UUID.randomUUID().toString())
                            .name(detailRequestlist.getName())
                            .mapperId(uid)
                            .destinationColumn(detailRequestlist.getDestinationColumn())
                            .dataType(detailRequestlist.getDataType())
                            .build());
        }
        return details;
    }

    public HeaderResponse mapHeaderToHeaderResponse(Header header) {
        return HeaderResponse.builder()
                .id(header.getId())
                .mapperName(header.getMapperName())
                .destinationTable(header.getDestinationTable())
                .headerFlag(header.isHeaderFlag())
                .mapperDetails(mapDetailToDetailResponse(header.getMapperDetails()))
                .build();
    }

    public List<DetailResponse> mapDetailToDetailResponse(List<Details> detailsList) {
        List<DetailResponse> detailResponseList = new ArrayList<>();
        for (Details details : detailsList) {
            detailResponseList.add(DetailResponse.builder()
                    .id(details.getId())
                    .mapperId(details.getMapperId())
                    .name(details.getName())
                    .dataType(details.getDataType())
                    .destinationColumn(details.getDestinationColumn())

                    .build());
        }
        return detailResponseList;
    }

    public Header mapUpdateHeaderRequestToHeader(UpdateHeaderRequest updateHeaderRequest, Header header) {
        return Header.builder()
                .id(updateHeaderRequest.getId())
                .mapperName(updateHeaderRequest.getMapperName())
                .destinationTable(updateHeaderRequest.getDestinationTable())
                .headerFlag(updateHeaderRequest.isHeaderFlag())
                .mapperDetails(mapUpdateDetailRequestToDetails( header.getMapperDetails(),updateHeaderRequest.getDetails(), header.getId()))
                .build();
    }

    public List<Details> mapUpdateDetailRequestToDetails( List<Details> existingDetails, List<UpdateDetailRequest> updateDetailRequests, String uuid) {
        Map<String ,Details > existingDetailMap = existingDetails.stream().collect(Collectors.toMap(Details::getId, Function.identity()));
        List<Details> detailsList = new ArrayList<>();
        for (UpdateDetailRequest request: updateDetailRequests){
            String id = existingDetailMap.get(request.getId()) != null ? existingDetailMap.get(request.getId()).getId() : UUID.randomUUID().toString();
            detailsList.add(Details.builder()
                            .id(id)
                            .mapperId(request.getMapperId())
                            .name(request.getName())
                            .dataType(request.getDataType())
                            .destinationColumn(request.getDestinationColumn())
                    .build());
        }
        return detailsList;
    }


}
