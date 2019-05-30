package com.example.carsharingbackend.vaadinviews.admin.carattributes.navigation;

import com.example.carsharingbackend.common.mvp.AbstractPresenter;
import com.example.carsharingbackend.common.AttributeClient;
import com.example.carsharingbackend.common.mvp.IModel;
import com.example.carsharingbackend.common.mvp.IView;
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
        List<AttributeClient> getLinks();
    }

    public interface NavigationView extends IView {
        void setItems(List<AttributeClient> links);

        Registration addValueChangeListener(HasValue.ValueChangeListener<AbstractField.ComponentValueChangeEvent<ListBox<AttributeClient>, AttributeClient>>  listener);
    }

    public NavigationPresenter(NavigationModel model, NavigationView view) {
        super(model, view);
        bind();
    }

    @Override
    protected void bind() {
        view.setItems(model.getLinks());
    }

    public void addValueChangeListener(HasValue.ValueChangeListener<AbstractField.ComponentValueChangeEvent<ListBox<AttributeClient>, AttributeClient>>  listener) {
        view.addValueChangeListener(listener);
    }


    public Component getView() {
        return view.mainLayout();
    }
}
