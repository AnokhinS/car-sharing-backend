package com.example.carsharingbackend.vaadinviews.admin;

import com.example.carsharingbackend.common.mvp.AbstractPresenter;
import com.example.carsharingbackend.common.mvp.IModel;
import com.example.carsharingbackend.common.mvp.IView;
import com.example.carsharingbackend.vaadinviews.admin.carattributes.main.CarAttributePresenter;
import com.example.carsharingbackend.vaadinviews.admin.cars.main.CarPresenter;
import com.example.carsharingbackend.vaadinviews.admin.users.UserPresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class AdminPresenter extends AbstractPresenter<AdminPresenter.AdminModel, AdminPresenter.AdminView> {

    public interface AdminModel extends IModel{
        CarPresenter getCarPresenter();
        UserPresenter getUserPresenter();
        CarAttributePresenter getAttributesPresenter();
    }

    public interface AdminView extends IView{
        void setView(Component component);
        Button getCarsBtn();
        Button getUsersBtn();
        Button getAttBtn();
    }

    public AdminPresenter(AdminModel model, AdminView view) {
        super(model, view);
        bind();
    }

    @Override
    protected void bind() {
        view.getAttBtn().addClickListener(e->view.setView(model.getAttributesPresenter().getView()));
        view.getCarsBtn().addClickListener(e->view.setView(model.getCarPresenter().getView()));
        view.getUsersBtn().addClickListener(e->view.setView(model.getUserPresenter().getView()));
    }



}
