package com.example.carsharingbackend.common.mvp;

import com.vaadin.flow.component.Component;


public abstract class AbstractPresenter<M extends IModel, V extends IView> {
    protected M model;
    protected V view;

    public AbstractPresenter(M model, V view) {
        this.model = model;
        this.view = view;
    }

    protected abstract void bind();

    public Component getView() {
        return view.mainLayout();
    }

}
