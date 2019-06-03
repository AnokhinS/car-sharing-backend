package com.example.carsharingbackend.vaadinviews.admin.carattributes.grid.impl;

import com.example.carsharingbackend.entity.common.NamedBean;
import com.example.carsharingbackend.vaadinviews.admin.carattributes.grid.CarAttributeGridPresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.selection.SelectionListener;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.Getter;

import java.util.Collection;

@SpringComponent
@UIScope
public class CarAttributeGridViewImpl extends VerticalLayout implements CarAttributeGridPresenter.GridView {
    @Getter
    private TextField filter;
    @Getter
    private Button addNewBtn;
    private Grid<NamedBean> grid;
    private Editor editor;
    @Getter
    private Button saveBtn = new Button("Save", VaadinIcon.CHECK.create());
    @Getter
    private Button deleteBtn = new Button("Delete", VaadinIcon.TRASH.create());

    public CarAttributeGridViewImpl() {
        editor = new Editor();
        filter = new TextField();
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.setPlaceholder("Фильтрация по названию");
        filter.setWidth("300px");
        addNewBtn = new Button("Добавить...", VaadinIcon.PLUS.create());
        grid = new Grid<>();
        grid.addColumn(NamedBean::getId).setHeader("Идентификатор").setSortable(true).setWidth("80px");
        grid.addColumn(NamedBean::getName).setHeader("Название").setSortable(true);

        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        add(actions, grid, editor);

    }

    @Override
    public Component mainLayout() {
        return this;
    }

    @Override
    public void setData(Collection<NamedBean> list) {
        grid.setItems(list);
    }

    @Override
    public Button getAddBtn() {
        return addNewBtn;
    }

    @Override
    public void edit(NamedBean bean) {
        editor.edit(bean);
    }


    @Override
    public void setSingleSelectListener(SelectionListener listener) {
        grid.addSelectionListener(listener);
    }



    private class Editor extends VerticalLayout implements KeyNotifier {
        private Binder<NamedBean> binder = new Binder<>();
        private Label label = new Label("Редактирование...");
        private TextField name = new TextField("Название", "Введите название нового объекта");
        private Button cancelBtn = new Button("Cancel");

        private HorizontalLayout actions = new HorizontalLayout(saveBtn, cancelBtn, deleteBtn);

        private NamedBean bean;

        public Editor() {
            name.setWidth("300px");
            name.setValueChangeMode(ValueChangeMode.EAGER);
            saveBtn.getElement().getThemeList().add("primary");
            saveBtn.addClickListener(e -> binder.writeBeanIfValid(bean));
            deleteBtn.getElement().getThemeList().add("error");
            cancelBtn.addClickListener(e -> cancel());
            addKeyPressListener(Key.ENTER, e -> saveBtn.click());
            binder.forField(name)
                    .withValidator(new StringLengthValidator(
                            "Введите название", 1, null))
                    .bind(NamedBean::getName, NamedBean::setName);

            add(label, name, actions);
            setSpacing(true);
            setVisible(false);
        }

        public void edit(NamedBean bean) {
            setVisible(true);
            this.bean = bean;
            binder.readBean(this.bean);
        }

        private void cancel() {
            setVisible(false);
        }
    }
}
