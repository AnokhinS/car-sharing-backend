package com.example.carsharingbackend.vaadinviews.profile;

import com.example.carsharingbackend.common.mvp.AbstractPresenter;
import com.example.carsharingbackend.common.mvp.IModel;
import com.example.carsharingbackend.common.mvp.IView;
import com.example.carsharingbackend.entity.Order;
import com.example.carsharingbackend.entity.userinfo.User;
import com.example.carsharingbackend.security.Authorization;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.annotation.Secured;

import javax.jws.soap.SOAPBinding;
import java.util.Collection;

@SpringComponent
@Scope(value = "prototype")
public class ProfilePresenter extends AbstractPresenter<ProfilePresenter.ProfileModel, ProfilePresenter.ProfileView> {

    public interface ProfileModel extends IModel {
        Collection<Order> getOrders();
        User getUser();
    }

    public interface ProfileView extends IView{
        void setUser(User user);
        void setOrders(Collection<Order> orders);
    }



    public ProfilePresenter(ProfileModel model, ProfileView view) {
        super(model, view);
        bind();
    }

    @Override
    protected void bind() {
        view.setUser(model.getUser());
        view.setOrders(model.getOrders());
    }


}
