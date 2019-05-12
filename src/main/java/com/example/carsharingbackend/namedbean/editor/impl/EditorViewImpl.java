package com.example.carsharingbackend.namedbean.editor.impl;

import com.example.carsharingbackend.entity.common.NamedBean;
import com.example.carsharingbackend.namedbean.editor.EditorPresenter;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class EditorViewImpl extends VerticalLayout implements EditorPresenter.EditorView {

    private Label label = new Label("Редактирование...");
    private TextField name = new TextField("Название", "Введите название нового объекта");

    private Button saveBtn = new Button("Save", VaadinIcon.CHECK.create());
    private Button cancelBtn = new Button("Cancel");
    private Button deleteBtn = new Button("Delete", VaadinIcon.TRASH.create());

    private HorizontalLayout actions = new HorizontalLayout(saveBtn, cancelBtn, deleteBtn);

    private NamedBean bean;

    public EditorViewImpl() {
        add(label, name, actions);
        setSpacing(true);
        name.setWidth("300px");
        name.addValueChangeListener(e->{
            bean.setName(e.getValue());
        });
        saveBtn.getElement().getThemeList().add("primary");
        deleteBtn.getElement().getThemeList().add("error");
        cancelBtn.addClickListener(e -> cancel());
        addKeyPressListener(Key.ENTER, e -> saveBtn.click());

        setVisible(false);

    }

    @Override
    public void edit(NamedBean bean) {
        setVisible(true);
        this.bean=bean;
        String nameStr=bean.getName();
        if(nameStr==null){
            nameStr="";
        }
        name.setValue(nameStr);
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