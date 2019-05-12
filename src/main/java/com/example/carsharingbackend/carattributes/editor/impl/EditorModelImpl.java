package com.example.carsharingbackend.carattributes.editor.impl;

import com.example.carsharingbackend.entity.common.NamedBean;
import com.example.carsharingbackend.carattributes.editor.EditorPresenter;
import com.example.carsharingbackend.services.NamedBeanService;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
public class EditorModelImpl implements EditorPresenter.EditorModel {
    @Setter
    private NamedBeanService service;

    @Override
    public void save(NamedBean bean) {
        if (bean.getId() == 0) {
            service.create(bean);
        } else {
            service.update(bean);
        }
    }

    @Override
    public void delete(NamedBean bean) {
        service.delete(bean);
    }
}
