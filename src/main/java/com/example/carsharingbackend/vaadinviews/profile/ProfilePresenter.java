package com.example.carsharingbackend.vaadinviews.profile;

import com.example.carsharingbackend.common.mvp.AbstractPresenter;
import com.example.carsharingbackend.common.mvp.IModel;
import com.example.carsharingbackend.common.mvp.IView;
import com.example.carsharingbackend.entity.userinfo.User;
import com.example.carsharingbackend.vaadinviews.profile.impl.orders.OrderPresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.context.annotation.Scope;

@SpringComponent
@Scope(value = "prototype")
public class ProfilePresenter extends AbstractPresenter<ProfilePresenter.ProfileModel, ProfilePresenter.ProfileView> {

    public interface ProfileModel extends IModel {
        User getUser();
    }

    public interface ProfileView extends IView{
        void setUser(User user);

        void setOrders(Component grid);
    }

    private OrderPresenter orderPresenter;

    public ProfilePresenter(ProfileModel model, ProfileView view, OrderPresenter orderPresenter) {
        super(model, view);
        this.orderPresenter = orderPresenter;
        bind();
    }

    @Override
    protected void bind() {
        if (model.getUser() == null) {
            UI.getCurrent().navigate("login");
            return;
        }
        view.setUser(model.getUser());
        view.setOrders(orderPresenter.getView());
    }


}
