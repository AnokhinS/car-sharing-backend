//package com.example.carsharingbackend.services;
//
//import com.vaadin.data.provider.Sort;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//
//import java.util.List;
//import java.util.stream.Stream;
//
//public class LazyService {
//
//    public int count() {
//        long cc = repository.count();
//        int count = (int)cc;
//        return(count);
//    }
//
//    //--------------------------------------------------------------------------
//    public Stream<E> getPage(int offset, int limit, List<Sort> sortOrders) {
//        int pageSize = offset/limit;
//        Pageable pageable = PageRequest.of(pageSize, limit);
//        Page<E> page = repository.findAll(pageable);
//        Stream<E> stm = page.stream();
//        return stm;
//    }
//}
