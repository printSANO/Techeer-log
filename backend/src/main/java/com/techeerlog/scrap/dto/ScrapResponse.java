package com.techeerlog.scrap.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 사용자가 마이페이지에서 스크랩한 프로젝트 리스트를 보여줄 때 사용될 정보 포함해야 됨
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScrapResponse {
    private Long scrapId;
    private Long projectId;
}
