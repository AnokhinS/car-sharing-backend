package com.example.carsharingbackend.vaadinviews.admin.users;

import com.example.carsharingbackend.common.mvp.AbstractPresenter;
import com.example.carsharingbackend.common.mvp.IModel;
import com.example.carsharingbackend.common.mvp.IView;
import com.example.carsharingbackend.entity.userinfo.User;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import java.util.Collection;

@SpringComponent
@UIScope
public class UserPresenter extends AbstractPresenter<UserPresenter.UserModel, UserPresenter.UserView> {

    public interface UserModel extends IModel {
        Collection<User> getAll(String startsWith);
    }

    public interface UserView extends IView {
        void setData(Collection<User> users);
        TextField getFilter();
    }

    public UserPresenter(UserModel model, UserView view) {
        super(model, view);
        bind();
    }

    @Override
    protected void bind() {

        view.setData(model.getAll(""));
        view.getFilter().addValueChangeListener(e -> view.setData(model.getAll(view.getFilter().getValue())));
    }
}
