package com.techeerlog.global.mapper;

import com.techeerlog.framework.domain.Framework;
import com.techeerlog.framework.dto.FrameworkResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-17T01:05:53+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Amazon.com Inc.)"
)
public class FrameworkMapperImpl implements FrameworkMapper {

    @Override
    public FrameworkResponse frameworkToFrameworkResponse(Framework framework) {
        if ( framework == null ) {
            return null;
        }

        FrameworkResponse frameworkResponse = new FrameworkResponse();

        frameworkResponse.setName( framework.getName() );

        return frameworkResponse;
    }
}
