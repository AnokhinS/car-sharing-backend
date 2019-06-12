package com.example.carsharingbackend.vaadinviews.registration;

import com.example.carsharingbackend.common.mvp.AbstractPresenter;
import com.example.carsharingbackend.common.mvp.IModel;
import com.example.carsharingbackend.common.mvp.IView;
import com.example.carsharingbackend.entity.userinfo.User;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;


@SpringComponent
@UIScope
public class RegistrationPresenter extends AbstractPresenter<RegistrationPresenter.RegistrationModel, RegistrationPresenter.RegistrationView> {

    public interface RegistrationModel extends IModel {
        void createNewUser(User user);
    }

    public interface RegistrationView extends IView {
        Button getSubmitBtn();
        void openDialog();
        User getNewUser();
    }

    public RegistrationPresenter(RegistrationModel model, RegistrationView view) {
        super(model, view);
        bind();
        view.openDialog();
    }

    @Override
    protected void bind() {
        view.getSubmitBtn().addClickListener(e -> {
            User user = view.getNewUser();
            if (user != null) {
                model.createNewUser(user);
            }

        });
    }
}
