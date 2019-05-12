package com.example.carsharingbackend.carattributes.editor.impl;

import com.example.carsharingbackend.carattributes.editor.EditorPresenter;
import com.example.carsharingbackend.entity.common.NamedBean;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;


@UIScope
@SpringComponent
public class EditorViewImpl extends VerticalLayout implements EditorPresenter.EditorView {
    private Binder<NamedBean> binder = new Binder<>();
    private Label label = new Label("Редактирование...");
    private TextField name = new TextField("Название", "Введите название нового объекта");

    private Button saveBtn = new Button("Save", VaadinIcon.CHECK.create());
    private Button cancelBtn = new Button("Cancel");
    private Button deleteBtn = new Button("Delete", VaadinIcon.TRASH.create());

    private HorizontalLayout actions = new HorizontalLayout(saveBtn, cancelBtn, deleteBtn);

    private NamedBean bean;

    public EditorViewImpl() {
        name.setWidth("300px");
        name.setValueChangeMode(ValueChangeMode.EAGER);
        saveBtn.getElement().getThemeList().add("primary");
        saveBtn.addClickListener(e -> {
            binder.writeBeanIfValid(bean);
        });
        deleteBtn.getElement().getThemeList().add("error");
        cancelBtn.addClickListener(e -> cancel());
        addKeyPressListener(Key.ENTER, e -> saveBtn.click());
        binder.forField(name)
                .withValidator(new StringLengthValidator(
                        "Please add the last name", 1, null))
                .bind(NamedBean::getName, NamedBean::setName);

        add(label, name, actions);
        setSpacing(true);
        setVisible(false);

    }

    @Override
    public void edit(NamedBean bean) {
        setVisible(true);
        this.bean = bean;
        binder.readBean(this.bean);
    }

    @Override
    public NamedBean getBean() {
        return this.bean;
    }


    private void cancel() {
        setVisible(false);
    }


    @Override
    public Component mainLayout() {
        return this;
    }

    @Override
    public Button getSaveBtn() {
        return saveBtn;
    }

    @Override
    public Button getDeleteBtn() {
        return deleteBtn;
    }
}