package com.example.carsharingbackend.vaadinviews.admin.cars.grid.impl;

import com.example.carsharingbackend.entity.carinfo.CarEntity;
import com.example.carsharingbackend.entity.carinfo.FirmEntity;
import com.example.carsharingbackend.entity.carinfo.TransmissionEntity;
import com.example.carsharingbackend.entity.carinfo.TypeEntity;
import com.example.carsharingbackend.restClients.RestFirmClient;
import com.example.carsharingbackend.restClients.RestTransmissionClient;
import com.example.carsharingbackend.restClients.RestTypeClient;
import com.example.carsharingbackend.vaadinviews.admin.cars.grid.CarGridPresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.selection.SelectionListener;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.Getter;

import java.util.Collection;

@SpringComponent
@UIScope
public class CarGridViewImpl extends VerticalLayout implements CarGridPresenter.CarGridView {
    private Grid<CarEntity> grid;
    private Button addNewBtn;

    private Editor editor;
    @Getter
    private Button saveBtn = new Button("Save", VaadinIcon.CHECK.create());
    @Getter
    private Button deleteBtn = new Button("Delete", VaadinIcon.TRASH.create());

    public CarGridViewImpl() {
        editor = new Editor();
        grid = new Grid<>();
        grid.setWidth("1000px");
        grid.setHeight("100px");
        addNewBtn = new Button("Добавить...", VaadinIcon.PLUS.create());

        grid.addColumn(CarEntity::getId).setHeader("Идентификатор").setSortable(true).setWidth("80px");
        grid.addColumn(CarEntity::getDescription).setHeader("Описание").setSortable(false);
        grid.addColumn(e -> (int) e.getYear()).setHeader("Год выпуска").setSortable(true);
        grid.addColumn(CarEntity::getFirm).setHeader("Производитель").setSortable(true);
        grid.addColumn(CarEntity::getType).setHeader("Тип").setSortable(true);
        grid.addColumn(CarEntity::getTransmission).setHeader("Коробка передач").setSortable(true);
        grid.addColumn(CarEntity::getCostPerDay).setHeader("Стоимость").setSortable(true);
        HorizontalLayout actions = new HorizontalLayout(addNewBtn);
        add(actions, grid, editor);
        grid.addSelectionListener(e -> {
            CarEntity bean = e.getFirstSelectedItem().orElse(new CarEntity());
            editor.edit(bean);
        });
    }

    @Override
    public void setData(Collection<CarEntity> cars) {
        grid.setItems(cars);
    }

    @Override
    public Button getAddBtn() {
        return addNewBtn;
    }

    @Override
    public void edit(CarEntity car) {
        editor.edit(car);
    }

    @Override
    public CarEntity getCurrentBean() {
        return editor.bean;
    }

    @Override
    public void setSingleSelectListener(SelectionListener listener) {
        grid.addSelectionListener(listener);
    }

    @Override
    public Component mainLayout() {
        return this;
    }


    private class Editor extends VerticalLayout implements KeyNotifier {
        RestFirmClient firmClient = new RestFirmClient();
        RestTypeClient typeClient = new RestTypeClient();
        RestTransmissionClient transmissionClient = new RestTransmissionClient();


        private Binder<CarEntity> binder = new Binder<>();
        private Label label = new Label("Редактирование...");
        private TextField description = new TextField("Описание");
        private NumberField year;
        private Select<FirmEntity> firms = new Select(firmClient.list("").toArray());
        private Select<TypeEntity> types = new Select(typeClient.list("").toArray());
        private Select<TransmissionEntity> transmissions = new Select(transmissionClient.list("").toArray());
        private NumberField cost;
        private Button cancelBtn = new Button("Cancel");

        private HorizontalLayout actions = new HorizontalLayout(saveBtn, cancelBtn, deleteBtn);

        private CarEntity bean;

        public Editor() {
            setHeight("500px");
            cost = new NumberField("Арендная плата (руб/сутки)");
            cost.setStep(5);
            cost.setMin(0);
            cost.setValue(50d);
            cost.setHasControls(true);

            year = new NumberField("Год выпуска");
            year.setStep(1);
            year.setMin(1980);
            year.setHasControls(true);
            year.setPattern("^[1-2][0-9]{3}$");

            description.setWidth("300px");
            description.setValueChangeMode(ValueChangeMode.EAGER);
            firms.setLabel("Производитель");
            types.setLabel("Тип");
            transmissions.setLabel("Коробка передач");
            saveBtn.getElement().getThemeList().add("primary");
            saveBtn.addClickListener(e -> binder.writeBeanIfValid(bean));
            deleteBtn.getElement().getThemeList().add("error");
            cancelBtn.addClickListener(e -> cancel());
            addKeyPressListener(Key.ENTER, e -> saveBtn.click());
            binder.forField(description)
                    .bind(CarEntity::getDescription, CarEntity::setDescription);
            binder.forField(year)
                    .bind(car -> Double.valueOf(car.getYear()),
                            (car, y) -> car.setYear(y.intValue()));
            binder.forField(cost)
                    .bind(CarEntity::getCostPerDay, CarEntity::setCostPerDay);
            binder.forField(firms)
                    .bind(CarEntity::getFirm, CarEntity::setFirm);
            binder.forField(types)
                    .bind(CarEntity::getType, CarEntity::setType);
            binder.forField(transmissions)
                    .bind(CarEntity::getTransmission, CarEntity::setTransmission);

            VerticalLayout v1 = new VerticalLayout(firms, types, transmissions);
            VerticalLayout v2 = new VerticalLayout(cost, year, description);

            HorizontalLayout layout = new HorizontalLayout(v1, v2);


            add(label, layout, actions);
            setSpacing(true);
            setVisible(false);
        }

        public void edit(CarEntity bean) {
            setVisible(true);
            this.bean = bean;
            binder.readBean(this.bean);
        }

        private void cancel() {
            setVisible(false);
        }
    }
}
