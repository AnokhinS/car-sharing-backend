package com.example.carsharingbackend.vaadinviews.customer.order;

import com.example.carsharingbackend.common.mvp.AbstractPresenter;
import com.example.carsharingbackend.common.mvp.IModel;
import com.example.carsharingbackend.common.mvp.IView;
import com.example.carsharingbackend.entity.Order;
import com.example.carsharingbackend.entity.carinfo.CarEntity;
import com.example.carsharingbackend.vaadinviews.customer.order.impl.NewOrderModelImpl;
import com.example.carsharingbackend.vaadinviews.customer.order.impl.NewOrderViewImpl;
import com.vaadin.flow.component.button.Button;


public class NewOrderPresenter extends AbstractPresenter<NewOrderPresenter.OrderModel, NewOrderPresenter.OrderView> {

    public interface OrderModel extends IModel {
        void createOrder(Order order);
    }

    public interface OrderView extends IView {
        Button getSubmitBtn();

        void open();

        void close();
        Order getOrder();
    }

    public NewOrderPresenter(CarEntity car) {
        super(new NewOrderModelImpl(), new NewOrderViewImpl(car));
        bind();
    }

    @Override
    protected void bind() {
        view.getSubmitBtn().addClickListener(e -> {
            model.createOrder(view.getOrder());
            view.close();
        });
    }

    public void open() {
        view.open();
    }

}
