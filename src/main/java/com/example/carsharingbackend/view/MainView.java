package com.example.carsharingbackend.view;

import com.example.carsharingbackend.entity.common.NamedBean;
import com.example.carsharingbackend.services.NamedBeanService;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.ui.Notification;
import lombok.Getter;
import lombok.Setter;


public class MainView extends VerticalLayout {
    private NamedBeanEditor editor;
    @Setter
    private NamedBeanService currentService;
    @Getter
    private TextField filter;
    private Button addNewBtn;
    @Getter
    private Grid<NamedBean> grid;



    public MainView() {
        this.editor = new NamedBeanEditor();
        this.grid = new Grid<>();
        this.filter = new TextField();
        this.addNewBtn = new Button("Добавить...", VaadinIcon.PLUS.create());
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        add(actions, grid, editor);

        filter.setPlaceholder("Фильтрация по названию");
        grid.addColumn(NamedBean::getId).setHeader("Идентификатор").setSortable(true).setWidth("50px");
        grid.addColumn(NamedBean::getName).setHeader("Название").setSortable(true);
        grid.asSingleSelect().addValueChangeListener(e -> {
           // editor.editEmployee(e.getValue());
            Notification.show("EDIT?");
        });
        filter.setValueChangeMode(ValueChangeMode.EAGER);
    }

    public class NamedBeanEditor extends VerticalLayout implements KeyNotifier {
        private NamedBean bean;

        TextField name = new TextField("Название", "Введите название вового объекта");

        Button save = new Button("Save", VaadinIcon.CHECK.create());
        Button cancel = new Button("Cancel");
        Button delete = new Button("Delete", VaadinIcon.TRASH.create());

        HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);
        Binder<NamedBean> binder = new Binder<>(NamedBean.class);

        public NamedBeanEditor() {
            add(name, actions);

            binder.bindInstanceFields(this);

            setSpacing(true);

            save.getElement().getThemeList().add("primary");
            delete.getElement().getThemeList().add("error");

            addKeyPressListener(Key.ENTER, e -> save());

//            save.addClickListener(e -> save());
//            delete.addClickListener(e -> delete());
//            cancel.addClickListener(e -> editEmployee(employee));
            setVisible(false);
        }
    }

    private interface ChangeHandler {
        void onChange();
    }

    public void save(){

    }

}
