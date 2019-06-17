package com.example.carsharingbackend.vaadinviews.customer.order.impl;


import com.example.carsharingbackend.entity.Order;
import com.example.carsharingbackend.entity.carinfo.CarEntity;
import com.example.carsharingbackend.utils.OrderSumHelper;
import com.example.carsharingbackend.vaadinviews.customer.carselection.utils.CarWrapper;
import com.example.carsharingbackend.vaadinviews.customer.order.NewOrderPresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.data.binder.Binder;
import lombok.Getter;

public class NewOrderViewImpl extends Dialog implements NewOrderPresenter.OrderView {

    private Binder<Order> binder;


    DatePicker startDate = new DatePicker("Начало пользования");
    DatePicker endDate = new DatePicker("Конец пользования");
    private Button submit;
    private NumberField sumArea;

    @Getter
    private Order order;
    private CarEntity car;

    public NewOrderViewImpl(CarEntity car) {
        this.car = car;
        order = new Order();
        sumArea = new NumberField("Стоимость аренды");
        sumArea.setReadOnly(true);

        binder = new Binder<>();
        binder.forField(startDate)
                .bind(Order::getStartDate, Order::setStartDate);
        binder.forField(endDate)
                .bind(Order::getEndDate, Order::setEndDate);
        binder.forField(startDate)
                .bind(Order::getStartDate, Order::setStartDate);
        binder.forField(sumArea)
                .bind(Order::getSum, Order::setSum);
        binder.readBean(order);
        submit = new Button("Подтвердить");
        submit.addClickListener(e -> {
            binder.writeBeanIfValid(order);
            order.setCar(car);
        });
        startDate.addValueChangeListener(e -> {
            sumArea.setValue(calculateSum());
        });
        endDate.addValueChangeListener(e -> {
            sumArea.setValue(calculateSum());
        });
        Span title = new Span(new H3("Оформляем ваш заказ..."));
        VerticalLayout layout = new VerticalLayout(title, new CarWrapper(this.car), startDate, endDate, sumArea, submit);
        add(layout);

    }

    private double calculateSum() {
        return OrderSumHelper.getSum(startDate.getValue(), endDate.getValue(), car.getCostPerDay());
    }


    @Override
    public Component mainLayout() {
        return this;
    }

    @Override
    public Button getSubmitBtn() {
        return submit;
    }
}