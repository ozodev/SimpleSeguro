package com.simple.seguros.core.dtos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.Data;

@Data
public class PageDto implements ResponseDto{
    private List<Object> content;
    private Pageable pageable;
    private Boolean last;
    private Boolean first;
    private Integer totalPages;
    private Integer size;
    private Integer number;
    private Integer numberOfElements;
    private Sort sort;

    public PageDto(Page<?> page){
        this.setPageable(page.getPageable());
        this.setLast(page.isLast());
        this.setFirst(page.isFirst());
        this.setTotalPages(page.getTotalPages());
        this.setSize(page.getSize());
        this.setNumber(page.getNumber());
        this.setNumberOfElements(page.getNumberOfElements());
        this.sort = page.getSort();
    }
}
