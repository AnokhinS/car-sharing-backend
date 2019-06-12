package com.example.carsharingbackend.vaadinviews.customer.order;

import com.example.carsharingbackend.common.mvp.AbstractPresenter;
import com.example.carsharingbackend.common.mvp.IModel;
import com.example.carsharingbackend.common.mvp.IView;
import com.example.carsharingbackend.entity.Order;
import com.example.carsharingbackend.entity.carinfo.CarEntity;
import com.example.carsharingbackend.restClients.RestOrderClient;
import com.example.carsharingbackend.vaadinviews.customer.order.impl.OrderModelImpl;
import com.example.carsharingbackend.vaadinviews.customer.order.impl.OrderViewImpl;
import com.vaadin.flow.component.button.Button;

public class OrderPresenter extends AbstractPresenter<OrderPresenter.OrderModel, OrderPresenter.OrderView> {

    public interface OrderModel extends IModel {
        void createOrder(Order order);
    }

    public interface OrderView extends IView {
        Button getSubmitBtn();

        void open();

        Order getOrder();
    }

    public OrderPresenter(CarEntity car) {
        super(new OrderModelImpl(), new OrderViewImpl(car));
        bind();
    }

    @Override
    protected void bind() {
        view.getSubmitBtn().addClickListener(e -> model.createOrder(view.getOrder()));
    }

    public void open() {
        view.open();
    }

}
