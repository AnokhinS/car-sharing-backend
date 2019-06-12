package com.example.carsharingbackend.vaadinviews.customer.carselection.utils;

import com.example.carsharingbackend.entity.carinfo.CarEntity;
import com.example.carsharingbackend.utils.ComponentBuilder;
import com.example.carsharingbackend.vaadinviews.customer.order.OrderPresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

public class CarWrapper extends VerticalLayout {

    @Getter
    private CarEntity carEntity;

    public CarWrapper(CarEntity car) {
        getElement().addEventListener("click", e -> {
            OrderPresenter op = new OrderPresenter(car);
            op.open();
        });
        carEntity = car;
        getElement().getStyle().set("border", "3px solid #9E9E9E");

        Label[] nameLabels = {new Label("Производитель:"), new Label("Тип:"), new Label("Коробка передач:"),
                new Label("Год выпуска:"), new Label("Описание:"), new Label("Стоимость, руб/сутки:")};
        for (Label l : nameLabels) {
            l.getElement().getStyle().set("color", "blue");
            l.setWidth("200px");
        }

        Label[] infoLabels = {new Label(car.getFirm().toString()), new Label(car.getType().toString()), new Label(car.getTransmission().toString()),
                new Label("" + (int) car.getYear()), new Label(car.getDescription()), new Label("" + car.getCostPerDay())};

        VerticalLayout carInfo = new VerticalLayout();

        for (int i = 0; i < nameLabels.length; i++) {
            carInfo.add(ComponentBuilder.toHorizontal(nameLabels[i], infoLabels[i]));
        }

        Image img = new Image(car.getImageUrl(), car.getFirm().toString() + "  " + car.getYear());

        HorizontalLayout info = new HorizontalLayout(img, carInfo);

        add(info);

    }

}
