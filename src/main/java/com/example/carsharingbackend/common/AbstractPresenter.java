package com.example.carsharingbackend.common;

import com.vaadin.flow.component.Component;


public abstract class AbstractPresenter<M extends IModel, V extends IView> {
    protected M model;
    protected V view;

    public AbstractPresenter(M model, V view) {
        this.model = model;
        this.view = view;
    }

    protected abstract void bind();

    public abstract Component getView();

}
