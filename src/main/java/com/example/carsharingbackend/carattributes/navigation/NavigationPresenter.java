package com.example.carsharingbackend.carattributes.navigation;

import com.example.carsharingbackend.common.AbstractPresenter;
import com.example.carsharingbackend.common.AttributeService;
import com.example.carsharingbackend.common.IModel;
import com.example.carsharingbackend.common.IView;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.shared.Registration;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import java.util.List;

@SpringComponent
@UIScope
public class NavigationPresenter extends AbstractPresenter<NavigationPresenter.NavigationModel, NavigationPresenter.NavigationView> {

    public interface NavigationModel extends IModel {
        List<AttributeService> getLinks();
    }

    public interface NavigationView extends IView {
        void setItems(List<AttributeService> links);

        Registration addValueChangeListener(HasValue.ValueChangeListener<AbstractField.ComponentValueChangeEvent<ListBox<AttributeService>, AttributeService>>  listener);
    }

    public NavigationPresenter(NavigationModel model, NavigationView view) {
        super(model, view);
        bind();
    }

    @Override
    protected void bind() {
        view.setItems(model.getLinks());
    }

    public void addValueChangeListener(HasValue.ValueChangeListener<AbstractField.ComponentValueChangeEvent<ListBox<AttributeService>, AttributeService>>  listener) {
        view.addValueChangeListener(listener);
    }


    public Component getView() {
        return view.mainLayout();
    }
}